package model.Commands;

import model.ErrorChecking.ErrorHandler;
import model.ErrorChecking.PseudoErrorListener;
import model.Execution.ExecutionManager;
import model.Item.PseudoArray;
import model.PseudoCodeParser.*;
import org.antlr.v4.runtime.Token;

public class ArrayInitializationCommand implements ICommand {

    private PseudoArray assignedPseudoArray;
    private ExpressionContext exprCtx;

    public ArrayInitializationCommand(PseudoArray pseudoArray, ExpressionContext exprCtx) {
        this.assignedPseudoArray = pseudoArray;
        this.exprCtx = exprCtx;

        if (exprCtx.expression(0) != null) {
            if (exprCtx.expression(0).getText().contains("\"") || exprCtx.expression(0).getText().contains(".")) {
                Token firstToken = this.exprCtx.getStart();
                int lineNumber = firstToken.getLine();

                PseudoErrorListener.reportCustomError(ErrorHandler.INVALID_INDEX_ASSIGN, "", lineNumber);
            }
        }
    }


    @Override
    public void execute() {
        ExpressionContext exprCtx = this.exprCtx;

        if(exprCtx != null) {
            ExpressionCommand evaluationCommand = new ExpressionCommand(exprCtx);
            evaluationCommand.execute();

            ExecutionManager.getInstance().setCurrentCheckedLineNumber(exprCtx.getStart().getLine());
            this.assignedPseudoArray.initializeSize(evaluationCommand.getValueResult().intValue());
        }

    }
}