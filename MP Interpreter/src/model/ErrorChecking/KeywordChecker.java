package model.ErrorChecking;

import model.PseudoCodeParser.*;

public class KeywordChecker implements IErrorChecker{

    private BlockContext blkCtx;
    private int lineNumber;

    public KeywordChecker(BlockContext blkCtx) {
        this.blkCtx = blkCtx;
        this.lineNumber = this.blkCtx.getStart().getLine();
    }

    @Override
    public void verify() {
        String identifier = Checker.getIdentifier(blkCtx);
        String literal = Checker.getConstant(blkCtx);
        if(literal == null && identifier == null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.MISSING_THIS_KEYWORD, "", this.blkCtx.getText(), this.lineNumber);
        }
    }
}
