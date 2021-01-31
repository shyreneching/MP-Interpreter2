package model.ErrorChecking;

import model.Execution.ExecutionManager;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeListener;
import model.PseudoCodeParser.*;
import model.Sematic.VariableSearcher;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MultipleVariableDeclarationChecker implements IErrorChecker, ParseTreeListener {

    private TerminalNode varDecIdCtx;
    private int lineNumber;

    public MultipleVariableDeclarationChecker(TerminalNode varDecIdCtx, VariableDeclaratorContext varDecctx) {
        this.varDecIdCtx = varDecIdCtx;

        Token firstToken = varDecctx.getStart();
        this.lineNumber = firstToken.getLine();
    }

    @Override
    public void verify() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.varDecIdCtx);
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
        if(ctx instanceof TerminalNode) {
            TerminalNode varDecCtx = (TerminalNode) ctx;
            this.verifyVariableOrConst(varDecCtx.getText());
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    private void verifyVariableOrConst(String identifierString) {
        PseudoValue pseudoValue = null;

//        if(ExecutionManager.getInstance().isInFunctionExecution()) {
//            PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
//            pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, identifierString);
//        }

        if(ExecutionManager.getInstance().isInFunctionExecution()) {
            PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
            pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, identifierString);
        }


        if(pseudoValue == null) {
            pseudoValue = ScopeCreator.searchVariableInLocalIterative(identifierString, ScopeCreator.getInstance().getActiveScope());
        }

//        if(pseudoValue == null) {
//            ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
//            pseudoValue = VariableSearcher.searchVariableInClass(classScope, identifierString);
//        }


        if(pseudoValue != null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.MULTIPLE_VARIABLE, "", identifierString, this.lineNumber);
        }
    }
}
