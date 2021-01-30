package model.Commands;

import model.PseudoCodeParser.*;

public class ScanCommand implements ICommand  {

    private String scanMessage;
    private ExpressionContext identifierArray;
    private String identifier;

    public ScanCommand(String scanMessage, String identifier) {
        scanMessage = scanMessage.replace("\"", "");
        this.scanMessage = scanMessage.replace("'", "");
        this.identifier = identifier;

    }

    public ScanCommand(String messageToDisplay, ExpressionContext identifierArray, String identifier) {
        this.scanMessage = scanMessage.replace("\"", "");
        this.identifierArray = identifierArray;
        this.identifier = identifier;
    }

    @Override
    public void execute() {


    }
}
