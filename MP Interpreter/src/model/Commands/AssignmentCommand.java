package model.Commands;

import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class AssignmentCommand implements ICommand  {

    private TerminalNode leftHandExpr;
    private ExpressionContext rightHandExpr;
    private ExpressionContext arrayAssVal;

    public AssignmentCommand(TerminalNode leftHandExpr,
                             ExpressionContext rightHandExpr) {
        this.leftHandExpr = leftHandExpr;
        this.rightHandExpr = rightHandExpr;

//        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.leftHandExprCtx);
//        undeclaredChecker.verify();
//
//        ConstChecker constChecker = new ConstChecker(this.leftHandExprCtx);
//        constChecker.verify();
//
//        undeclaredChecker = new UndeclaredChecker(this.rightHandExprCtx);
//        undeclaredChecker.verify();


//        ParseTreeWalker functionWalker = new ParseTreeWalker();
//        functionWalker.walk(new MethodCallVerifier(), this.rightHandExprCtx);
//
//
//        PseudoValue pseudoValue;
//        if(ExecutionManager.getInstance().isInFunctionExecution()) {
//            pseudoValue = VariableSearcher.searchVariableInFunction(ExecutionManager.getInstance().getCurrentFunction(), this.leftHandExprCtx.getText());
//        }
//        else {
//            pseudoValue = VariableSearcher.searchVariable(this.leftHandExprCtx.getText());
//        }
//
//        TypeChecker typeChecker = new TypeChecker(pseudoValue, this.rightHandExprCtx);
//        typeChecker.verify();
    }

    public AssignmentCommand(TerminalNode leftHandExpr, ExpressionContext arrayAssVal,
                             ExpressionContext rightHandExpr) {
        this.leftHandExpr = leftHandExpr;
        this.rightHandExpr = rightHandExpr;
        this.arrayAssVal = arrayAssVal;
    }

    @Override
    public void execute() {

    }

    public TerminalNode getLeftHandExpr() {
        return leftHandExpr;
    }

    public ExpressionContext getRightHandExpr() {
        return rightHandExpr;
    }
}
