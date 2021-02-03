package model.Commands;

import model.Execution.ExecutionManager;
import model.Item.PseudoArray;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.notifications.NotificationListener;
import model.notifications.Notifications;
import model.notifications.NotificationsCenter;
import model.notifications.Parameters;
import org.antlr.v4.runtime.tree.TerminalNode;

import static model.Commands.ExpressionCommand.searchValue;

public class ScanCommand implements ICommand, NotificationListener {

    private String scanMessage;
    private ExpressionContext identifierArray;
    private TerminalNode identifier;

    public ScanCommand(ExpressionContext scanMessage, TerminalNode identifier) {
        ExpressionCommand expressionCommand = new ExpressionCommand(scanMessage);
        expressionCommand.execute();
        if(expressionCommand.isString())
            this.scanMessage = expressionCommand.getStringResult();
        else
            this.scanMessage = expressionCommand.getValueResult().toEngineeringString();
//        this.scanMessage = scanMessage;
        this.identifier = identifier;

    }

    public ScanCommand(ExpressionContext scanMessage, ExpressionContext identifierArray, TerminalNode identifier) {
        ExpressionCommand expressionCommand = new ExpressionCommand(scanMessage);
        expressionCommand.execute();
        if(expressionCommand.isString())
            this.scanMessage = expressionCommand.getStringResult();
        else
            this.scanMessage = expressionCommand.getValueResult().toEngineeringString();
//        this.scanMessage = scanMessage;
        this.identifierArray = identifierArray;
        this.identifier = identifier;
    }

    @Override
    public void execute() {
//        ExpressionCommand expressionCommand = new ExpressionCommand(this.scanMessage);
//        expressionCommand.execute();
//        String expCommandString;
//        System.out.println(scanMessage.getText());
//        if(expressionCommand.isString())
//            expCommandString = expressionCommand.getStringResult();
//        else
//            expCommandString = expressionCommand.getValueResult().toEngineeringString();

        NotificationsCenter.getInstance().addObserver(Notifications.ON_SCAN_DIALOG_DISMISSED, this); //add an observer to listen to when the dialog has been dismissed

        Parameters params = new Parameters();
        params.putExtra("MESSAGE_DISPLAY_KEY", this.scanMessage);
        System.out.println("Blocking execution!");
        ExecutionManager.getInstance().blockExecution();

        NotificationsCenter.getInstance().postNotification(Notifications.ON_FOUND_SCAN_STATEMENT, params);

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
                NotificationsCenter.getInstance().removeObserver(Notifications.ON_SCAN_DIALOG_DISMISSED, this); //remove observer after using

                if(!scanMessage.contains("Try Again! "))
                    this.scanMessage = "Try Again! " + this.scanMessage;

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
                NotificationsCenter.getInstance().removeObserver(Notifications.ON_SCAN_DIALOG_DISMISSED, this); //remove observer after using

                if(!scanMessage.contains("Try Again! "))
                    this.scanMessage = "Try Again! " + this.scanMessage;

                this.execute();
            }

            isSuccessful = true;
        }

        if(isSuccessful) {
            NotificationsCenter.getInstance().removeObserver(Notifications.ON_SCAN_DIALOG_DISMISSED, this); //remove observer after using
            ExecutionManager.getInstance().resumeExecution(); //resume execution of thread
        }
    }

    @Override
    public void notified(String notificationString, Parameters params) {
        if(notificationString == Notifications.ON_SCAN_DIALOG_DISMISSED) {
            this.getUserInput(params);
        }
    }
}
