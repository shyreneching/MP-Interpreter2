package model.Commands;

import model.ErrorChecking.*;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.Utils.AssignmentUtils;
import org.antlr.v4.runtime.Token;

public class ReturnCommand implements ICommand {
    private ExpressionContext exprContext;
    private PseudoMethod assignedPseudoMethod;

    public ReturnCommand(ExpressionContext exprContext, PseudoMethod pseudoMethod) {
        this.exprContext = exprContext;
        this.assignedPseudoMethod = pseudoMethod;

        if (exprContext != null) {
            UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.exprContext);
            undeclaredChecker.verify();


            PseudoValue pseudoValue = this.assignedPseudoMethod.getReturnValue();

            if (pseudoValue == null) {
                Token firstToken = this.exprContext.getStart();
                int lineNumber = firstToken.getLine();

                PseudoErrorListener.reportCustomError(ErrorHandler.RETURN_IN_VOID, "", lineNumber);
            }

            TypeChecker typeChecker = new TypeChecker(pseudoValue, this.exprContext);
            typeChecker.setReturnStmnt();
            typeChecker.verify();
            typeChecker.resetReturnStmnt();
        }
    }


    @Override
    public void execute() {
        if(exprContext != null) {
            ExpressionCommand checker = new ExpressionCommand(this.exprContext);
            checker.execute();
            System.out.println("ReturnCommand - method return value: " + this.assignedPseudoMethod.getReturnValue().getValue());
            PseudoValue pseudoValue = this.assignedPseudoMethod.getReturnValue();

            if (!checker.isString())
                AssignmentUtils.assignAppropriateValue(pseudoValue, checker.getValueResult());
            else
                AssignmentUtils.assignAppropriateValue(pseudoValue, checker.getStringResult());
//        //Console.log(LogType.DEBUG,"Return value is: " +evaluationCommand.getResult().toEngineeringString());
        }
    }
}
