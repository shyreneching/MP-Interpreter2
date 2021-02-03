package model.Commands;

import model.ErrorChecking.ErrorHandler;
import model.ErrorChecking.PseudoErrorListener;
import model.Execution.ExecutionManager;
import model.Item.PseudoArray;
import model.PseudoCodeParser.*;
import org.antlr.v4.runtime.Token;

public class ArrayInitializationCommand implements ICommand {

    private PseudoArray assignedBaracoArray;
    private ExpressionContext exprCtx;

    public ArrayInitializationCommand(PseudoArray baracoArray, ExpressionContext exprCtx) {
        this.assignedBaracoArray = baracoArray;
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
        ExpressionContext exprCtx = this.exprCtx.expression(0);

        if(exprCtx != null) {
            ExpressionCommand evaluationCommand = new ExpressionCommand(exprCtx);
            evaluationCommand.execute();

            ExecutionManager.getInstance().setCurrentCheckedLineNumber(exprCtx.getStart().getLine());
            this.assignedBaracoArray.initializeSize(evaluationCommand.getValueResult().intValue());
        }

    }
}