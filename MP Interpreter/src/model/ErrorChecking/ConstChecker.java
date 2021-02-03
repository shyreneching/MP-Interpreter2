package model.ErrorChecking;

import model.Commands.ExpressionCommand;
import model.Execution.ExecutionManager;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.Sematic.VariableSearcher;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ConstChecker implements IErrorChecker, ParseTreeListener {

    private ExpressionContext exprCtx;
    private int lineNumber;

    public ConstChecker(ExpressionContext exprCtx) {
        this.exprCtx = exprCtx;

        Token firstToken = this.exprCtx.getStart();
        this.lineNumber = firstToken.getLine();
    }

    @Override
    public void verify() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.exprCtx);
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
        if(ctx instanceof ExpressionContext) {
            ExpressionContext exprCtx = (ExpressionContext) ctx;
            if(Checker.isVariableOrConst(exprCtx)) {
                this.verifyVariableOrConst(exprCtx);
            } else  if (ExpressionCommand.isArrayElement(exprCtx)) {
                this.verifyVariableOrConst(exprCtx);
            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    private void verifyVariableOrConst(ExpressionContext varExprCtx) {
        PseudoValue pseudoValue = null;

        if(ExecutionManager.getInstance().isInFunctionExecution()) {
            PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
            if(varExprCtx.LBRACK() == null){
                pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, varExprCtx.primary().Identifier().getText());
            } else {
                pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, varExprCtx.Identifier().getText());
            }
        }else{
            if(varExprCtx.LBRACK() == null){
                pseudoValue = VariableSearcher.searchVariableInMain(SymbolTableManager.getInstance().getParentScope(), varExprCtx.primary().Identifier().getText());
            } else {
                pseudoValue = VariableSearcher.searchVariableInMain(SymbolTableManager.getInstance().getParentScope(), varExprCtx.Identifier().getText());
            }
        }


        if(pseudoValue != null && pseudoValue.isConst()) {
            PseudoErrorListener.reportCustomError(ErrorRepository.CONST_REASSIGNMENT, "", varExprCtx.getText(), this.lineNumber);
        }
    }

    public static void verifyVariableOrConst(TerminalNode node) {
        PseudoValue pseudoValue = null;

        if(ExecutionManager.getInstance().isInFunctionExecution()) {
            PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
            pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, node.getText());
        }else{
            pseudoValue = VariableSearcher.searchVariableInMain(SymbolTableManager.getInstance().getParentScope(), node.getText());
        }


        if(pseudoValue != null && pseudoValue.isConst()) {
            PseudoErrorListener.reportCustomError(ErrorRepository.CONST_REASSIGNMENT, "", node.getText(), node.getSymbol().getLine());
        }
    }
}
