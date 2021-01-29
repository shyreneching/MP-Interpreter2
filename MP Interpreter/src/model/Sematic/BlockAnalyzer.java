package model.Sematic;

import model.PseudoCodeParser;

import java.util.List;
import model.PseudoCodeParser.*;

public class BlockAnalyzer {

    public BlockAnalyzer() {
//        create intance of children scope;
    }

    public void analyze(BlockContext ctx) {
        BlockStatementsContext blockstatments = ctx.blockStatements();
        List<BlockStatementContext> blockList = blockstatments.blockStatement();

        for(BlockStatementContext blockStatementCtx : blockList) {
            if(blockStatementCtx.statement() != null) {
                StatementContext statementCtx = blockStatementCtx.statement();
                StatementAnalyzer statementAnalyzer = new StatementAnalyzer();
                statementAnalyzer.analyze(statementCtx);
            }
            else if(blockStatementCtx.localVariableDeclaration() != null) {
                LocalVariableDeclarationContext localVarDecStatementCtx = blockStatementCtx.localVariableDeclaration();

                LocalVariableAnalyzer localVarAnalyzer = new LocalVariableAnalyzer();
                localVarAnalyzer.analyze(localVarDecStatementCtx);
            }
        }
//      delete scope
    }
}
