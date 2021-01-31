package model.Sematic;

import model.Commands.ExpressionCommand;
import model.Execution.ExecutionManager;
import model.Item.PseudoArray;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.Scope;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class IdentifierMapper implements ParseTreeListener {

    private String originalExp = null;
    private String modifiedExp = null;

    private PseudoMethod method;
    private PseudoValue value;
    private Scope methodScope;

    public IdentifierMapper(String expStr, PseudoMethod method) {
        this.originalExp = expStr;
        this.modifiedExp = expStr;
        this.method = method;
        this.methodScope = method.getParentScope();
    }

    public void analyze(ExpressionContext exp) {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, exp);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {
        if(parserRuleContext instanceof PrimaryContext) {
            PrimaryContext primaryContext = (PrimaryContext) parserRuleContext;

            if(primaryContext.Identifier() != null) {
                String var = primaryContext.getText();

                if (!ExpressionCommand.isArray(var))
                    this.searchVariable(var);
            }
        } else if (parserRuleContext instanceof ExpressionContext) {

            ExpressionContext expressionContext = (ExpressionContext) parserRuleContext;

            if (expressionContext.expression().size() == 2) {
                if (ExpressionCommand.isArray(expressionContext.expression(0))) {
                    searchArray(expressionContext);
                }
            }

        }
    }

    private void searchVariable(String identifier) {
        if(this.method.hasParameter(identifier)) {
            this.modifiedExp = this.modifiedExp.replace(identifier, this.method.getParameter(identifier).getValue().toString());
        }
        else {
            this.value = ScopeCreator.searchVariableInLocalIterative(identifier, this.methodScope);

            if (this.value == null) {
                this.value = SymbolTableManager.getInstance().searchVariableIncludingLocal(identifier);
            }
            this.modifiedExp = this.modifiedExp.replace(identifier, this.value.getValue().toString());
        }
    }

    private void searchArray(ExpressionContext expressionContext) {
        PseudoValue value = ExpressionCommand.searchValue(expressionContext.expression(0).getText());

        if (value != null) {
            if (value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {

                PseudoArray array = (PseudoArray) value.getValue();

                ExpressionCommand expressionCommand = new ExpressionCommand(expressionContext.expression(1));
                expressionCommand.execute();

                ExecutionManager.getInstance().setCurrentCheckedLineNumber(expressionContext.getStart().getLine());
                PseudoValue arrayValue = array.getValueAt(expressionCommand.getValueResult().intValue());

                if (arrayValue == null)
                    return;

                if (arrayValue.getPrimitiveType() == PseudoValue.PrimitiveType.STRING) {
                    this.modifiedExp = this.modifiedExp.replace(expressionContext.getText(), "\"" + arrayValue.getValue().toString() + "\"");
                } else {
                    this.modifiedExp = this.modifiedExp.replace(expressionContext.expression(0).getText() + "[" + expressionCommand.getValueResult().intValue() + "]", arrayValue.getValue().toString());
                }

            }
        }

    }

    public PseudoValue getValue() {
        return this.value;
    }

    public String getOriginalExp() {
        return this.originalExp;
    }

    public String getModifiedExp() {
        return this.modifiedExp;
    }
}