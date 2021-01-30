package model.Commands;

import model.ErrorChecking.UndeclaredChecker;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class PrintCommand implements ICommand {

    private String printstatement = "";
    private ExpressionContext statement;

    public PrintCommand(ExpressionContext statement) {


        UndeclaredChecker undeclaredChecker = new UndeclaredChecker(statement);
        undeclaredChecker.verify();
        this.statement = statement;

//        for(TerminalNode t: statement.Identifier()){
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
        System.out.println(printstatement);

        String print_text = this.statement.getText();
        if(print_text.contains('"' + "")){
            String[] temp = print_text.split("\"");

        }

        printstatement = "";
    }



    public String getStatementToPrint() {
        return this.printstatement;
    }
}
