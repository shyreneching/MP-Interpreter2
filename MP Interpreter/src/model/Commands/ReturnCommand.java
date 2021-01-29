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

        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.exprContext);
        undeclaredChecker.verify();

        PseudoValue pseudoValue = this.assignedPseudoMethod.getReturnValue();

        if (pseudoValue == null) {
            Token firstToken = this.exprContext.getStart();
            int lineNumber = firstToken.getLine();

            PseudoErrorListener.reportCustomError(ErrorRepository.RETURN_IN_VOID, "", lineNumber);
        }

        TypeChecker typeChecker = new TypeChecker(pseudoValue, this.exprContext);
        typeChecker.verify();
    }


    @Override
    public void execute() {
        Checker checker = new Checker(this.exprContext);
        checker.execute();

        PseudoValue pseudoValue = this.assignedPseudoMethod.getReturnValue();

        if (checker.isNumericResult())
            AssignmentUtils.assignAppropriateValue(pseudoValue, checker.getResult());
        else
            AssignmentUtils.assignAppropriateValue(pseudoValue, checker.getStringResult());
        //Console.log(LogType.DEBUG,"Return value is: " +evaluationCommand.getResult().toEngineeringString());
    }
}
