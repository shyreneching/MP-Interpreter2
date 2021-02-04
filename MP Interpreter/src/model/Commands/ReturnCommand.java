package model.Commands;

import model.ErrorChecking.*;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.Sematic.VariableSearcher;
import model.Utils.AssignmentUtils;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ReturnCommand implements ICommand {
    private TerminalNode identifier;
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

    public ReturnCommand(TerminalNode exprContext, PseudoMethod pseudoMethod) {
        this.identifier = exprContext;
        this.assignedPseudoMethod = pseudoMethod;

        if (exprContext != null) {
            PseudoValue value = VariableSearcher.searchVariableCorrectly(exprContext.getText());
            if(value == null) {
                PseudoErrorListener.reportCustomError(ErrorHandler.UNDECLARED_VARIABLE, "", exprContext.getText(), exprContext.getSymbol().getLine());
            }


            PseudoValue pseudoValue = this.assignedPseudoMethod.getReturnValue();

            if (pseudoValue == null) {
                Token firstToken = this.exprContext.getStart();
                int lineNumber = firstToken.getLine();

                PseudoErrorListener.reportCustomError(ErrorHandler.RETURN_IN_VOID, "", lineNumber);
            }

//            TypeChecker typeChecker = new TypeChecker(pseudoValue, this.exprContext);
//            typeChecker.setReturnStmnt();
//            typeChecker.verify();
//            typeChecker.resetReturnStmnt();
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
        } else {
            PseudoValue value = VariableSearcher.searchVariableInFunction(this.assignedPseudoMethod, identifier.getText());

            this.assignedPseudoMethod.setReturnValue(value);
        }
    }
}
