package model.ErrorChecking;

import model.ErrorListener;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import javax.swing.text.View;
import java.util.Arrays;
import java.util.BitSet;

public class PseudoErrorListener implements ANTLRErrorListener {
    public static ErrorListener INSTANCE = new ErrorListener();
    private static final boolean REPORT_SYNTAX_ERRORS = true;

    private static PseudoErrorListener sharedInstance = null;

    private boolean successful = true;

    private static String errorMsg = "";

    public static PseudoErrorListener getInstance() {
        return sharedInstance;
    }

    public static void initialize() {
        sharedInstance = new PseudoErrorListener();
        ErrorRepository.initialize();
    }

    public static void reportCustomError(int errorcode, String additionalMessage, Object... parameters) {
        String errorMessage = String.format("Semantic Error: " + ErrorRepository.getErrorMessage(errorcode) + " " + additionalMessage, parameters);
        System.out.println("ERROR: " + errorMessage);
        //View.printInConsole("ERROR: " + errorMessage + "\n");

        String s[] = errorMessage.split("line [0-9]+");
        String line = errorMessage.substring(errorMessage.indexOf("line"), errorMessage.indexOf("."));

        String number = errorMessage.substring(errorMessage.indexOf("line ") + 5, errorMessage.indexOf(s[1]));

//        PseudoError pseudoError = new PseudoError();

        errorMsg = errorMsg + "\n"  +s[0] + " " +s[1] + "(Line "+ Integer.parseInt(number) +")";
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
        if (!REPORT_SYNTAX_ERRORS) {
            return;
        }

        String sourceName = recognizer.getInputStream().getSourceName();
        if (!sourceName.isEmpty()) {
            sourceName = String.format("%s; ", sourceName);
        }

        CommonTokenStream tokens = (CommonTokenStream)recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];

        String[] temp;
        String[] unnanType = {"boolean;", "byte;", "short;", "int;", "long;", "char;", "float;", "double;", "String;", "Object;"};
        if (msg.contains("extraneous")){
            temp = msg.split("'");
//            System.out.println(temp[1]);
            if (msg.contains("'++' expecting ';'")){
                msg = "redundant '+' in arithmetic expression";
            } else if (msg.contains("input ';' expecting")){
                msg = "lacking argument before ';'";
            } else if (temp[1].equals(")")){
                msg = "uneven parentheses, missing one '('";
            } else if(temp[1].equals("(")){
                msg = "uneven parentheses, missing one ')'";
            } else if (/*Arrays.stream(unnanType).anyMatch(msg::contains)*/Arrays.asList(unnanType).contains(temp[1] + ";") ){
                msg = "no identifier found for '" + temp[1] + "' data type";
            } else {
                msg = "irrelevant character '"+ temp[1] +"' found";
            }
        }
        else if (msg.contains("missing")){
            temp = msg.split("'");
//            System.out.println(temp[1]);
            if (msg.contains("++")){
                msg = "multiple '+' in arithmetic expression";
            } else if (msg.contains("--")){
                msg = "multiple '-' in arithmetic expression";
//            }
//            else if (msg.contains("missing ';'")){
//                msg = "Excess '"+ temp[3] + "'";
            } else if (msg.contains("}")){
                msg = "missing closing bracket '}'";
                line = line - 1;
//            } else if (msg.contains("missing {StringLiteral, Identifier}")){
//                msg = "missing argument before '"+temp[1] + "'";
//                msg = "missing argument before '"+temp[1] + "'";
            } else {
//                msg = "looking for '" + temp[1] +"' but found " + temp[3];
            }
        }
        else if(msg.contains("mismatched input")) {
            temp = msg.split("'");
            if (Arrays.stream(unnanType).anyMatch(msg::contains)){
                temp = msg.split("'");
                msg = "no identifier found for '" + temp[1].replace(";", "") + "' data type";

            } else if (temp[1].equals(")")){
                msg = "uneven parentheses, missing one '('";
            } else if(temp[1].equals("(")){
                msg = "uneven parentheses, missing one ')'";
            }  else {
                msg = "found '"+ temp[1] + "' looking for " + msg.split("expecting ")[1]+"";
            }
        }
        else if(msg.contains("no viable alternative")){
            temp = msg.split("'");
            if (Arrays.stream(unnanType).anyMatch(msg::contains)){
                temp = msg.split("'");
                msg = "no identifier found for '" + temp[1].replace(";", "") + "' data type";

            }else if (msg.contains("print") && (msg.contains("-") || msg.contains("*") || msg.contains("/") || msg.contains("%"))){
                temp = msg.split("'");
                msg = "unecessary '" + temp[1].charAt(temp[1].length() - 1)+ "' in print statement";

            }else if (errorLine.contains("if") ){
                temp = msg.split("'");
                msg = "did not find expected comparison operator in If statement";

            } else{
                msg = "no solution for : '" + temp[1];
            }

        } else if(msg.contains("cannot find symbol")) {
            msg = "No symbol '" + msg.split("'")[1] + "' found";

//        } else {

        }


//        underlineError(recognizer, offendingSymbol, line, charPositionInLine);
        //System.err.println(msg+ ", line "+line+":"+charPositionInLine+" in file: "+ sourceName);
//        errorMsg = errorMsg + "\n" + "Syntax Error: " + msg+ ", (Line "+line+")[Char "+charPositionInLine+"] in file: "+ sourceName;
        errorMsg = errorMsg + "\n" + "Syntax Error: " + msg+ ", (Line "+line+")[Char "+charPositionInLine+"]";
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
}
