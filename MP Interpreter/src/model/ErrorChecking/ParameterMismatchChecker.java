package model.ErrorChecking;

import model.Item.PseudoMethod;
import model.PseudoCodeParser.*;

import java.util.List;

public class ParameterMismatchChecker implements IErrorChecker {

    private PseudoMethod pseudoMethod;
    private List<ExpressionContext> exprCtxList;
    private int lineNumber;

    public ParameterMismatchChecker(PseudoMethod pseudoMethod, ExpressionContext argumentsCtx) {
        this.pseudoMethod = pseudoMethod;

        if(argumentsCtx.expressionList() != null) {
            this.exprCtxList = argumentsCtx.expressionList().expression();
        }

        this.lineNumber = argumentsCtx.getStart().getLine();
    }

    public ParameterMismatchChecker(PseudoMethod pseudoMethod, ExpressionListContext argumentsCtx) {
        this.pseudoMethod = pseudoMethod;

        if(argumentsCtx.expressionList() != null) {
            this.exprCtxList = argumentsCtx.expression();
        }

        this.lineNumber = argumentsCtx.getStart().getLine();
    }


    @Override
    public void verify() {
        System.out.println("paramteter mismatch checker " + pseudoMethod.getMethodName());
        System.out.println("paramteter mismatch checker " + pseudoMethod.getParameterValueSize());
        if(this.pseudoMethod == null) {
            return;
        }

        if(this.exprCtxList == null && this.pseudoMethod.getParameterValueSize() != 0) {
            PseudoErrorListener.reportCustomError(ErrorHandler.PARAMETER_COUNT_MISMATCH, "", this.pseudoMethod.getMethodName(), this.lineNumber);
        }
        else if(this.exprCtxList != null && this.exprCtxList.size() != this.pseudoMethod.getParameterValueSize()) {
            PseudoErrorListener.reportCustomError(ErrorHandler.PARAMETER_COUNT_MISMATCH, "", this.pseudoMethod.getMethodName(), this.lineNumber);
        }
    }
}
