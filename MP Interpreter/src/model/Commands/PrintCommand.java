package model.Commands;

import model.ErrorChecking.UndeclaredChecker;
import model.Item.PseudoValue;
import model.PseudoCodeParser;
import model.PseudoCodeParser.*;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import view.ParserUI;
import view.UIHolder;

import java.util.regex.Pattern;

public class PrintCommand implements ICommand, ParseTreeListener {

    private String printstatement = "";
    private ExpressionContext statement;
    private boolean evaluated = false;

    public PrintCommand(ExpressionContext statement) {

        this.statement = statement;
        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(this.statement);
        undeclaredChecker.verify();

//        for(TerminalNode t: statement){
//            t.getText();
//            PseudoValue pv = SymbolTableManager.getInstance().searchVariableIncludingLocal(t.getText());
//        }
//        if(statement.StringLiteral() != null){
//            this.printstatement = statement.StringLiteral().toString();
//        }
        this.printstatement = "";


    }

    @Override
    public void execute() {
        //print in IDE statement

//        System.out.println("I'm executing!");
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        parseTreeWalker.walk(this, this.statement);

//        System.out.println("Printstatement: " + printstatement);
//        if(printstatement.contains('"' + "")){
//            System.out.println("I'm entering this if statement");
//            String[] temp = printstatement.split("\"");
//            for (String t : temp){
//                if (!t.equals("")) {
//                    System.out.println("I'm entering this if in the for loop");
//                    System.out.println(t);
//                    UIHolder.getInstance().getParserUI().printToOutput(t + "\n");
//                }
//            }
//        }

        String s = this.printstatement.replace("\\n", "\n");
        s = s.replace("\\b", "\b");
        s = s.replace("\\t", "\t");
        s = s.replace("\\f", "\f");
        s = s.replace("\\r", "\r");
        s = s.replace("\\\"", "\"");
        s = s.replace("\\\'", "\\'");
        s = s.replace("\\\\", "\\");
        s = s.replace("\\)", ")");
        System.out.println(s);
        UIHolder.getInstance().getParserUI().printToOutput(s);

        printstatement = "";
        evaluated = false;
    }

    @Override
    public void enterEveryRule(ParserRuleContext context) {
//        System.out.println("Entering rule!");

        if (context instanceof ExpressionContext && !evaluated) {

            ExpressionContext expressionContext = (ExpressionContext) context;

            ExpressionCommand expressionCommand = new ExpressionCommand(expressionContext);
            expressionCommand.execute();

            if (!expressionCommand.isString()){
                System.out.println("PrintCommand - numeric result for expr command ");
                String s = expressionCommand.getValueResult().toEngineeringString();

                if(isFloat(s + "f")){
                    while(s.charAt(s.length()-1) == '0' && s.charAt(s.length()-2) != '.'){
                        s = s.substring(0, s.length() - 1);
                    }
                }

                printstatement += s;
            }

            else
                printstatement += expressionCommand.getStringResult();

            evaluated = true;

        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext context) {

    }

    @Override
    public void visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    public String getStatementToPrint() {
        return this.printstatement;
    }

    public static boolean isFloat(String exprCtx) {
        Pattern functionPattern = Pattern.compile("((\\d+\\.\\d*)|(\\.\\d+))f");

        if (functionPattern.matcher(exprCtx).matches()) {
            return true;
        } else {
            return false;
        }
    }
}
