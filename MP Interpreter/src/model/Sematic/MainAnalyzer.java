package model.Sematic;

import model.ErrorChecking.ErrorHandler;
import model.ErrorChecking.PseudoErrorListener;
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

    private boolean evaluated = false;

    public void analyze(MainDeclarationContext ctx) {
//        if(!ExecutionManager.getInstance().hasFoundEntryPoint()) {
//            ExecutionManager.getInstance().reportFoundEntryPoint(ParserHandler.getInstance().getCurrentClassName());
////

//        MethodTracker.reset();
//        PseudoMethod pseudoMethod = new PseudoMethod();
//        pseudoMethod.setMethodName("main");
//        SymbolTableManager.getInstance().addPseudoMethod("main", pseudoMethod);
        Scope scope = ScopeCreator.getInstance().openScope();
        scope.setParent(scope);
//        pseudoMethod.setParentScope(scope);
         SymbolTableManager.setParentScope(scope);
//        ExecutionManager.getInstance().openFunctionExecution(pseudoMethod);
//        ExecutionManager.getInstance().setIsMain(true);
//        pseudoMethod.execute();
//        MethodTracker.getInstance().reportEnterFunction(pseudoMethod);
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, ctx);

//
//        }
//        else {
//            System.out.println("Already found main in " + ExecutionManager.getInstance().getEntryClassName());
//        }
        evaluated = false;
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        if(parserRuleContext instanceof BlockContext && !evaluated) {
            BlockContext blockCtx = ((BlockContext) parserRuleContext);

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            blockAnalyzer.analyze(blockCtx);

            evaluated = true;
        } else if(parserRuleContext instanceof StatementContext && ((StatementContext) parserRuleContext).RETURN() != null){
            PseudoErrorListener.reportCustomError(ErrorHandler.DEFAULT, "Can not have return in main. ", parserRuleContext.getStart().getLine());

        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
