package model.ErrorChecking;

import model.Execution.ExecutionManager;
import model.Execution.MethodTracker;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.Sematic.VariableSearcher;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.regex.Pattern;

public class UndeclaredChecker implements IErrorChecker, ParseTreeListener {

    private ExpressionContext exprCtx;
    private String prevFunctionName = "";
    private int lineNumber;

    public UndeclaredChecker(ExpressionContext exprCtx) {
        this.exprCtx = exprCtx;

        Token firstToken = this.exprCtx.getStart();
        this.lineNumber = firstToken.getLine();
    }
    @Override
    public void verify() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.exprCtx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof ExpressionContext) {
            ExpressionContext exprCtx = (ExpressionContext) ctx;
            if(Checker.isFunctionCall(exprCtx)) {
                System.out.println("FUNCTION ENTER " + ctx.getText());
                String s[] = exprCtx.getText().split("\\(");
                prevFunctionName = s[0];
                this.verifyFunctionCall(exprCtx);
            }
            else if(Checker.isVariableOrConst(exprCtx)) {
                System.out.println("VARIABLE ENTER " + ctx.getText());
                if(!prevFunctionName.equals(exprCtx.getText()))
                    this.verifyVariableOrConst(exprCtx);
            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    private void verifyFunctionCall(ExpressionContext funcExprCtx) {

        if(funcExprCtx.expression(0) == null) {
            return;
        }

        String functionName = funcExprCtx.Identifier().getText();

        PseudoMethod pseudoMethod = SymbolTableManager.getInstance().getMethod(functionName);

        if(pseudoMethod == null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_FUNCTION, "", functionName, this.lineNumber);
        }
        else {
            //Console.log(LogType.DEBUG, "Function found: " +functionName);
        }

    }

    private void verifyVariableOrConst(ExpressionContext varExprCtx) {
        PseudoValue pseudoValue = null;

        if(ExecutionManager.getInstance().isInFunctionExecution()) {
            PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
//            PseudoMethod pseudoMethod = MethodTracker.getInstance().getLatestFunction();

            pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, varExprCtx.primary().Identifier().getText());
        } else{

//            System.out.println("Undeclared Checker - Searching in Main");

            pseudoValue = VariableSearcher.searchVariableInMain(SymbolTableManager.getInstance().getParentScope(), varExprCtx.primary().Identifier().getText());
        }
        System.out.println("Undeclared Checker - pseudoValue " + pseudoValue.getValue());
        if(pseudoValue == null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "", varExprCtx.getText(), this.lineNumber);
        }
    }

    public static void verifyVariableOrConst(TerminalNode node) {
        PseudoValue pseudoValue = null;

        if(ExecutionManager.getInstance().isInFunctionExecution()) {
            PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
            pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, node.getText());
        } else{
            pseudoValue = VariableSearcher.searchVariableInMain(SymbolTableManager.getInstance().getParentScope(), node.getText());
        }


        if(pseudoValue == null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "", node.getText(), node.getSymbol().getLine());
        }
    }

    /*
     * Verifies a var or const identifier from a scan statement since scan grammar is different.
     */
    public static void verifyVarOrConstForScan(String identifier, StatementContext statementCtx) {
        PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
        PseudoValue pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, identifier);

        Token firstToken = statementCtx.getStart();

        if(pseudoValue == null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "", identifier, firstToken.getLine());
        }
    }

}
