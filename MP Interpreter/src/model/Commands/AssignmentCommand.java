package model.Commands;

import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AssignmentCommand implements ICommand  {

    private LeftHandSideContext leftHandExpr;
    private ExpressionContext rightHandExpr;

    public AssignmentCommand(LeftHandSideContext leftHandExpr,
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

    @Override
    public void execute() {

    }

    public LeftHandSideContext getLeftHandExpr() {
        return leftHandExpr;
    }

    public ExpressionContext getRightHandExpr() {
        return rightHandExpr;
    }
}
