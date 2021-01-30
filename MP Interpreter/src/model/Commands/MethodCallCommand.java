package model.Commands;

import model.PseudoCodeParser.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class MethodCallCommand implements ICommand {

    private List<ExpressionListContext> exprCtx;
    private String functionName;

    public MethodCallCommand(TerminalNode functionName, List<ExpressionListContext> exprCtx){
        this.functionName = functionName.getText();
        this.exprCtx = exprCtx;
    }

    @Override
    public void execute() {

    }
}
