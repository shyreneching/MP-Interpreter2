package model.Sematic;

import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.PseudoErrorListener;
import model.PseudoCodeParser;

import java.util.List;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.ScopeCreator;

public class BlockAnalyzer {

    public BlockAnalyzer() {
//        create intance of children scope;
        ScopeCreator.getInstance().openScope();
    }

    public void analyze(BlockContext ctx) {
        List<BlockStatementContext> blockList = ctx.blockStatement();

        for(BlockStatementContext blockStatementCtx : blockList) {
            if(blockStatementCtx.statement() != null) {
                StatementContext statementCtx = blockStatementCtx.statement();
                StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
                statementAnalyzer.analyze(statementCtx);
            }
            else if(blockStatementCtx.localVariableDeclarationStatement() != null) {
                LocalVariableDeclarationContext localVarDecStatementCtx = blockStatementCtx.localVariableDeclarationStatement().localVariableDeclaration();

                LocalVariableAnalyzer localVarAnalyzer = new LocalVariableAnalyzer();
                localVarAnalyzer.analyze(localVarDecStatementCtx);
            } else if(blockStatementCtx.statement() == null && blockStatementCtx.localVariableDeclarationStatement() == null){
                PseudoErrorListener.reportCustomError(ErrorRepository.NOT_A_STATEMENT, "", blockStatementCtx.getText(), blockStatementCtx.getStart().getLine());
            }
        }
      ScopeCreator.getInstance().closeScope();
    }
}
