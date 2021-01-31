package model.Commands;

import model.ErrorChecking.UndeclaredChecker;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import view.ParserUI;
import view.UIHolder;

public class PrintCommand implements ICommand {

    private String printstatement = "";
    private ExpressionContext statement;

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
        //System.out.println(printstatement);

        String print_text = this.statement.getText();
        System.out.println(print_text);
        if(print_text.contains('"' + "")){
            System.out.println("I'm entering this if statement");
            String[] temp = print_text.split("\"");
            for (String t : temp){
                if (!t.equals("")) {
                    System.out.println("I'm entering this if in the for loop");
                    System.out.println(t);
                    UIHolder.getInstance().getParserUI().printToOutput(t + "\n");
                }
            }
        }

        printstatement = "";
    }

    public String getStatementToPrint() {
        return this.printstatement;
    }
}
