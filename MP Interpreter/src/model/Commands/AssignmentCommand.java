package model.Commands;

import model.ErrorChecking.ConstChecker;
import model.ErrorChecking.ParameterMismatchChecker;
import model.ErrorChecking.TypeChecker;
import model.ErrorChecking.UndeclaredChecker;
import model.Execution.ExecutionManager;
import model.Item.PseudoArray;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser;
import model.PseudoCodeParser.*;
import model.Sematic.VariableSearcher;
import model.SymbolTable.SymbolTableManager;
import model.Utils.AssignmentUtils;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class AssignmentCommand implements ICommand, ParseTreeListener {

    private TerminalNode leftHandExpr;
    private ExpressionContext rightHandExpr;
    private ExpressionContext arrayAssVal;
    private boolean leftHandArrayAccessor;

    public AssignmentCommand(TerminalNode leftHandExpr,
                             ExpressionContext rightHandExpr) {
        this.leftHandExpr = leftHandExpr;
        this.rightHandExpr = rightHandExpr;
        leftHandArrayAccessor = false;

//        UndeclaredChecker.verifyVariableOrConst(leftHandExpr);

        ConstChecker.verifyVariableOrConst(leftHandExpr);

        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.rightHandExpr);
        undeclaredChecker.verify();


        ParseTreeWalker functionWalker = new ParseTreeWalker();
        functionWalker.walk(this, this.rightHandExpr);


        PseudoValue pseudoValue;
        if(ExecutionManager.getInstance().isInFunctionExecution()) {
            pseudoValue = VariableSearcher.searchVariableInFunction(ExecutionManager.getInstance().getCurrentFunction(), this.leftHandExpr.getText());
        }
        else {
            pseudoValue = VariableSearcher.searchVariable(this.leftHandExpr.getText());
        }

        TypeChecker typeChecker = new TypeChecker(pseudoValue, this.rightHandExpr);
        typeChecker.verify();
    }

    public AssignmentCommand(TerminalNode leftHandExpr, ExpressionContext arrayAssVal,
                             ExpressionContext rightHandExpr) {
        this.leftHandExpr = leftHandExpr;
        this.rightHandExpr = rightHandExpr;
        this.arrayAssVal = arrayAssVal;
        leftHandArrayAccessor = true;

        UndeclaredChecker.verifyVariableOrConst(leftHandExpr);
        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.arrayAssVal);
        undeclaredChecker.verify();

        ConstChecker.verifyVariableOrConst(leftHandExpr);

        undeclaredChecker = new UndeclaredChecker(this.rightHandExpr);
        undeclaredChecker.verify();


        ParseTreeWalker functionWalker = new ParseTreeWalker();
        functionWalker.walk(this, this.rightHandExpr);


        PseudoValue pseudoValue;
        if(ExecutionManager.getInstance().isInFunctionExecution()) {
            pseudoValue = VariableSearcher.searchVariableInFunction(ExecutionManager.getInstance().getCurrentFunction(), this.leftHandExpr.getText());
        }
        else {
            pseudoValue = VariableSearcher.searchVariable(this.leftHandExpr.getText());
        }

        TypeChecker typeChecker = new TypeChecker(pseudoValue, this.rightHandExpr);
        typeChecker.verify();
    }

    @Override
    public void execute() {
        ExpressionCommand expressionCommand = new ExpressionCommand(this.rightHandExpr);
        expressionCommand.execute();

        if(expressionCommand.isHasException())
            return;

        if(this.isLeftHandArrayAccessor()) {

            if(expressionCommand.isNumeric())
                this.handleArrayAssignment(expressionCommand.getValueResult().toEngineeringString());
            else
                this.handleArrayAssignment(expressionCommand.getStringResult());
        }
        else {
            PseudoValue pseudoValue = VariableSearcher.searchVariable(this.leftHandExpr.getText());

            if (expressionCommand.isNumeric()) {

                if (!pseudoValue.isConst()) {
                    AssignmentUtils.assignAppropriateValue(pseudoValue, expressionCommand.getValueResult());
                }

            } else {

                if (!pseudoValue.isConst()) {
                    AssignmentUtils.assignAppropriateValue(pseudoValue, expressionCommand.getStringResult());
                }
            }
        }
    }

    public TerminalNode getLeftHandExpr() {
        return leftHandExpr;
    }

    public ExpressionContext getRightHandExpr() {
        return rightHandExpr;
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        if(parserRuleContext instanceof PseudoCodeParser.ExpressionContext) {
            PseudoCodeParser.ExpressionContext exprCtx = (PseudoCodeParser.ExpressionContext) parserRuleContext;
            if (ExpressionCommand.isFunctionCall(exprCtx)) {
                if(exprCtx.expression(0) == null)
                    return;

                String functionName = exprCtx.expression(0).getText();

                PseudoMethod method = SymbolTableManager.getInstance().getMethod(functionName);

                if (exprCtx.expressionList() != null) {
                    ParameterMismatchChecker paramsMismatchChecker = new ParameterMismatchChecker(method, exprCtx);
                    paramsMismatchChecker.verify();
                }
            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    private void handleArrayAssignment(String resultString) {
        PseudoValue pseudoValue = VariableSearcher.searchVariable(leftHandExpr.getText());
        PseudoArray pseudoArray = (PseudoArray) pseudoValue.getValue();

        ExpressionCommand expressionCommand = new ExpressionCommand(arrayAssVal);
        expressionCommand.execute();

        ExecutionManager.getInstance().setCurrentCheckedLineNumber(arrayAssVal.getStart().getLine());

        //create a new array value to replace value at specified index
        PseudoValue newArrayValue = new PseudoValue(null, PseudoValue.convert(pseudoArray.getPrimitiveType()));
        newArrayValue.setValue(resultString);
        pseudoArray.updateValueAt(newArrayValue, expressionCommand.getValueResult().intValue());

        //Console.log("Index to access: " +evaluationCommand.getResult().intValue()+ " Updated with: " +resultString);
    }

    public boolean isLeftHandArrayAccessor() {
        return leftHandArrayAccessor;
    }
}
