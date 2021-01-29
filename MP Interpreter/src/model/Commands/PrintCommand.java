package model.Commands;

import model.ErrorChecking.UndeclaredChecker;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class PrintCommand implements ICommand {

    private String printstatement = "";

    public PrintCommand(PrintInvocationContext statement) {

        if(statement.Identifier() != null){
            UndeclaredChecker undeclaredChecker = new UndeclaredChecker(statement);
            undeclaredChecker.verify();
        }

        for(TerminalNode t: statement.Identifier()){
            t.getText();
            PseudoValue pv = SymbolTableManager.getInstance().searchVariableIncludingLocal(t.getText());
        }
        if(statement.StringLiteral() != null){
            this.printstatement = statement.StringLiteral().toString();
        }



    }

    @Override
    public void execute() {
        //print in IDE statement
        System.out.println(printstatement);

        printstatement = "";
    }



    public String getStatementToPrint() {
        return this.printstatement;
    }
}
