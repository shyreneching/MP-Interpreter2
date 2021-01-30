package model.Sematic;

import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.Scope;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MainAnalyzer implements ParseTreeListener {

    public void analyze(MainDeclarationContext ctx) {
//        if(!ExecutionManager.getInstance().hasFoundEntryPoint()) {
//            ExecutionManager.getInstance().reportFoundEntryPoint(ParserHandler.getInstance().getCurrentClassName());
//

            Scope scope = ScopeCreator.getInstance().openScope();
            scope.setParent(SymbolTableManager.getInstance());
            SymbolTableManager.setParentScope(scope);

            ParseTreeWalker treeWalker = new ParseTreeWalker();
            treeWalker.walk(this, ctx);

//
//        }
//        else {
//            System.out.println("Already found main in " + ExecutionManager.getInstance().getEntryClassName());
//        }
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        if(parserRuleContext instanceof BlockContext) {
            BlockContext blockCtx = ((BlockContext) parserRuleContext);

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            blockAnalyzer.analyze(blockCtx);
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
