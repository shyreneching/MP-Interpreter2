package model.ErrorChecking;

import model.ErrorListener;
import model.Item.ErrorMessage;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class PseudoErrorListener implements ANTLRErrorListener {
    public static PseudoErrorListener INSTANCE = new PseudoErrorListener();
    private static final boolean REPORT_SYNTAX_ERRORS = true;

    private static PseudoErrorListener sharedInstance = null;

    private boolean successful = true;

    private static String errorMsg = "";

    private static ArrayList<ErrorMessage> semanticErrors = new ArrayList<ErrorMessage>();

    public static PseudoErrorListener getInstance() {
        return sharedInstance;
    }

    public static void initialize() {
        sharedInstance = new PseudoErrorListener();
        ErrorRepository.initialize();
    }

    public static void reportCustomError(int errorcode, String additionalMessage, Object... parameters) {
        String errorMessage = String.format("Semantic Error: " + ErrorRepository.getErrorMessage(errorcode) + " " + additionalMessage, parameters);

        //View.printInConsole("ERROR: " + errorMessage + "\n");

        String s[] = errorMessage.split(" at line [0-9]+");
        String line = errorMessage.substring(errorMessage.indexOf("line"), errorMessage.indexOf("."));

        String number = errorMessage.substring(errorMessage.indexOf("line ") + 5, errorMessage.indexOf(s[1]));
//        PseudoError pseudoError = new PseudoError();
//        if(s[1].length() != 2){
//            s[1] = "";
//        } else{
//            s[1] = s[1].substring(2);
//        }

        errorMessage = s[0] +s[1].trim() + " (Line "+ Integer.parseInt(number) +")";

        ErrorMessage error = new ErrorMessage(Integer.parseInt(number), errorMessage);

        semanticErrors.add(error);

        System.out.println("ERROR: " + errorMessage);
        errorMsg = errorMsg + errorMessage + "\n";
//        pseudoError.setLineNumber( Integer.parseInt(number) );
//        pseudoError.setErrorPrefix(s[0]);
//        pseudoError.setLineLayout(line);
//        pseudoError.setErrorSuffix(s[1]);
//

        sharedInstance.successful = false;
    }

    public static void reportCustomError(int errorcode, String additionalMessage) {
        String errorMessage = String.format("Semantic Error: " + ErrorRepository.getErrorMessage(errorcode) + " " + additionalMessage);

        errorMsg = errorMsg + "\n"  + errorMessage;
        sharedInstance.successful = false;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException re) {
    }

    @Override
    public String toString() {
        return errorMsg;
    }



    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

    }

    public void setSuccessful(boolean b) {
        successful = b;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public ArrayList<ErrorMessage> getSemanticErrors() {
        return semanticErrors;
    }
}
