package model;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ErrorRecovery  extends BailErrorStrategy {
    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        super.recover(recognizer, e);
    }
}
