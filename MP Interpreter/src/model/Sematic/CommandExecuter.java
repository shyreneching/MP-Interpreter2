package model.Sematic;

import model.Commands.ICommand;
import model.Commands.IConditionalCommand;
import model.Commands.IControlledCommand;
import model.Execution.ExecutionManager;

public class CommandExecuter {

    public static void handleStatementExecution(ICommand command) {

        StatementControlOverseer statementControl = StatementControlOverseer.getInstance();

        //add to conditional controlled command
        if(statementControl.isInConditionalCommand()) {
            IConditionalCommand conditionalCommand = (IConditionalCommand) statementControl.getActiveControlledCommand();

            if(statementControl.isInPositiveRule()) {
                conditionalCommand.addPositiveCommand(command);
            }
            else {
                conditionalCommand.addNegativeCommand(command);
            }
        }

        else if(statementControl.isInControlledCommand()) {
            IControlledCommand controlledCommand = (IControlledCommand) statementControl.getActiveControlledCommand();
            controlledCommand.addCommand(command);
        }
        else {
            ExecutionManager.getInstance().addCommand(command);
        }

    }
}
