package model.ErrorChecking;

import model.Item.PseudoMethod;
import model.PseudoCodeParser.*;

import java.util.List;

public class ParameterMismatchChecker implements IErrorChecker {

    private PseudoMethod pseudoMethod;
    private List<FormalParameterContext> exprCtxList;
    private int lineNumber;

    public ParameterMismatchChecker(PseudoMethod pseudoMethod, FormalParameterListContext argumentsCtx) {
        this.pseudoMethod = pseudoMethod;

        if(argumentsCtx.formalParameters() != null) {
            this.exprCtxList = argumentsCtx.formalParameters().formalParameter();
        }

        this.lineNumber = argumentsCtx.getStart().getLine();
    }


    @Override
    public void verify() {
        if(this.pseudoMethod == null) {
            return;
        }

        if(this.exprCtxList == null && this.pseudoMethod.getParameterValueSize() != 0) {
            PseudoErrorListener.reportCustomError(ErrorRepository.PARAMETER_COUNT_MISMATCH, "", this.pseudoMethod.getMethodName(), this.lineNumber);
        }
        else if(this.exprCtxList != null && this.exprCtxList.size() != this.pseudoMethod.getParameterValueSize()) {
            PseudoErrorListener.reportCustomError(ErrorRepository.PARAMETER_COUNT_MISMATCH, "", this.pseudoMethod.getMethodName(), this.lineNumber);
        }
    }
}
