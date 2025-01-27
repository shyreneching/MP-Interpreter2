package model.Commands;

import model.Execution.ExecutionManager;
import model.Item.PseudoArray;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import view.UIAlert.Alerts;
import view.UIAlert.IAlert;
import view.UIAlert.AlertHolder;
import view.UIAlert.Parameters;
import org.antlr.v4.runtime.tree.TerminalNode;

import static model.Commands.ExpressionCommand.searchValue;

public class ScanCommand implements ICommand, IAlert {

    private String startMessage = "";
    private ExpressionContext scanMessage;
    private ExpressionContext identifierArray;
    private TerminalNode identifier;

    public ScanCommand(ExpressionContext scanMessage, TerminalNode identifier) {
//        ExpressionCommand expressionCommand = new ExpressionCommand(scanMessage);
//        expressionCommand.execute();
//        if(expressionCommand.isString())
//            this.scanMessage = expressionCommand.getStringResult();
//        else
//            this.scanMessage = expressionCommand.getValueResult().toEngineeringString();
        this.scanMessage = scanMessage;
        this.identifier = identifier;

    }

    public ScanCommand(ExpressionContext scanMessage, ExpressionContext identifierArray, TerminalNode identifier) {
//        ExpressionCommand expressionCommand = new ExpressionCommand(scanMessage);
//        expressionCommand.execute();
//        if(expressionCommand.isString())
//            this.scanMessage = expressionCommand.getStringResult();
//        else
//            this.scanMessage = expressionCommand.getValueResult().toEngineeringString();
        this.scanMessage = scanMessage;
        this.identifierArray = identifierArray;
        this.identifier = identifier;
    }

    @Override
    public void execute() {
        ExpressionCommand expressionCommand = new ExpressionCommand(this.scanMessage);
        expressionCommand.execute();
        String expCommandString;
        System.out.println(scanMessage.getText());
        if(expressionCommand.isString())
            expCommandString = expressionCommand.getStringResult();
        else
            expCommandString = expressionCommand.getValueResult().toEngineeringString();

        AlertHolder.getInstance().addObserver(Alerts.ON_SCAN_DIALOG_DISMISSED, this); //add an observer to listen to when the dialog has been dismissed

        Parameters params = new Parameters();
        params.putExtra("MESSAGE_DISPLAY_KEY", this.startMessage + expCommandString);
        System.out.println("Blocking execution!");
        ExecutionManager.getInstance().blockExecution();

        AlertHolder.getInstance().postNotification(Alerts.ON_FOUND_SCAN_STATEMENT, params);

    }

    private void getUserInput(Parameters params) {
        boolean isSuccessful;

        if (identifierArray == null){
            String valueEntered = params.getStringExtra("VALUE_ENTERED_KEY", "");

            PseudoValue pseudoValue = searchValue(identifier.getText());

            try {
                pseudoValue.setValue(valueEntered);
                isSuccessful = true;
            } catch (NumberFormatException ex) {
                isSuccessful = false;
                AlertHolder.getInstance().removeObserver(Alerts.ON_SCAN_DIALOG_DISMISSED, this); //remove observer after using

                this.startMessage = "Try Again! ";

                this.execute();
            }
        }
        else{
            String valueEntered = params.getStringExtra("VALUE_ENTERED_KEY", "");

            PseudoValue value = ExpressionCommand.searchValue(identifier.getText());
            PseudoArray pseudoArray = (PseudoArray) value.getValue();

            ExpressionCommand expressionCommand = new ExpressionCommand(identifierArray);
            expressionCommand.execute();

            ExecutionManager.getInstance().setCurrentCheckedLineNumber(identifierArray.getStart().getLine());

            //create a new array value to replace value at specified index
            PseudoValue newArrayValue = new PseudoValue(null, PseudoValue.convert(pseudoArray.getPrimitiveType()));
            try {
                newArrayValue.setValue(valueEntered);
                pseudoArray.updateValueAt(newArrayValue, expressionCommand.getValueResult().intValue());
            } catch (NumberFormatException ex) {
                isSuccessful = false;
                AlertHolder.getInstance().removeObserver(Alerts.ON_SCAN_DIALOG_DISMISSED, this); //remove observer after using

                this.startMessage = "Try Again! ";

                this.execute();
            }

            isSuccessful = true;
        }

        if(isSuccessful) {
            AlertHolder.getInstance().removeObserver(Alerts.ON_SCAN_DIALOG_DISMISSED, this); //remove observer after using
            ExecutionManager.getInstance().resumeExecution(); //resume execution of thread
        }
    }

    @Override
    public void notified(String notificationString, Parameters params) {
        if(notificationString == Alerts.ON_SCAN_DIALOG_DISMISSED) {
            this.getUserInput(params);
        }
    }
}
