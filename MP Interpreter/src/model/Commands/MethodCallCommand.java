package model.Commands;

import model.ErrorChecking.ParameterMismatchChecker;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.Sematic.VariableSearcher;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class MethodCallCommand implements ICommand, ParseTreeListener {

    private PseudoMethod method;
    private ExpressionListContext ctx;
    private String functionName;

    public MethodCallCommand(TerminalNode functionName, ExpressionListContext ctx){
        this.functionName = functionName.getText();
        this.ctx = ctx;
        this.findMethod();

        if(ctx != null) {
            ParseTreeWalker treeWalker = new ParseTreeWalker();
            treeWalker.walk(this, this.ctx);
        }

        this.verifyParameters();
    }

    @Override
    public void execute() {
        this.mapParameters();
        this.method.execute();
    }

    private void findMethod() {
        this.method = SymbolTableManager.getInstance().getMethod(this.functionName);
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        if(parserRuleContext instanceof ExpressionListContext) {
            ExpressionListContext expressionListContext = (ExpressionListContext) parserRuleContext;
            PseudoMethod method = SymbolTableManager.getInstance().getMethod(functionName);

            if (expressionListContext.expression() != null) {
                ParameterMismatchChecker paramsMismatchChecker = new ParameterMismatchChecker(method, expressionListContext);
                paramsMismatchChecker.verify();
            }

        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    public PseudoValue getReturnValue() {
        return this.method.getReturnValue();
    }

    private void verifyParameters() {
        if(this.ctx.expression() == null || this.ctx == null) {
            return;
        }

        List<ExpressionContext> exprCtxList = this.ctx.expression();
        //map values in parameters
        for(int i = 0; i < exprCtxList.size(); i++) {
            ExpressionContext expressionContext = exprCtxList.get(i);
            this.method.verifyParameterByValueAt(expressionContext, i);
        }
    }

    private void mapParameters() {
        System.out.println("MethodCallCommand - Mapping Parameters!!!");

        if (this.ctx == null) {
            return;
        }

        List<ExpressionContext> expressionContextList = this.ctx.expression();

        //map values in parameters
        for(int i = 0; i < expressionContextList.size(); i++) {
            ExpressionContext expressionContext = expressionContextList.get(i);

            if(this.method.getParameterAt(i).getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {
                PseudoValue value = VariableSearcher.searchVariable(expressionContext.getText());
                this.method.mapArrayAt(value, i, expressionContext.getText());
            }
            else {
                ExpressionCommand expressionCommand = new ExpressionCommand(expressionContext);
                expressionCommand.execute();

                if (expressionCommand.isNumeric()) {
                    this.method.mapParameterByValueAt(expressionCommand.getValueResult().toEngineeringString(), i);
                }
                else {
                    this.method.mapParameterByValueAt(expressionCommand.getStringResult(), i);
                }
            }
        }
    }
}
