package model.Item;

public class ErrorMessage {

    private int lineNumber;
    private String errorMessage;

    public ErrorMessage(int lineNumber, String errorMessage){
        this.lineNumber = lineNumber;
        this.errorMessage = errorMessage;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
