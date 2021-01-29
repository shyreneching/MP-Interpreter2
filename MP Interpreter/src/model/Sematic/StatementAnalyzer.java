package model.Sematic;

import model.Commands.DoWhileCommand;
import model.Commands.ForCommand;
import model.Commands.IFCommand;
import model.Commands.WhileCommand;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.ScopeCreator;

import java.util.List;

public class StatementAnalyzer {
    public void analyze(StatementContext statementCtx) {
        if(statementCtx.ifThenStatement() != null) {
            this.handleIfStatement(statementCtx.ifThenStatement());
        }
        else if (statementCtx.whileStatement() != null) {
            this.handleWhilwStatement(statementCtx.whileStatement());
        }
        else if (statementCtx.forStatement() != null) {
            this.handleForStatement(statementCtx.forStatement());
        }
        else if (statementCtx.doStatement() != null) {
            this.handleDoStatement(statementCtx.doStatement());
        }
        else if (statementCtx.block() != null) {
            BlockContext blockCtx = statementCtx.block();

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            blockAnalyzer.analyze(blockCtx);


//            StatementWithoutTrailingSubstatementContext statementwithSub = statementCtx.statementWithoutTrailingSubstatement();
//            StatementWithoutTrailingAnalyzer statementAnalyzer = new StatementWithoutTrailingAnalyzer();
//            statementAnalyzer.analyze(statementwithSub);
        }
        else if (statementCtx.BREAK() != null) {

        }
        else if (statementCtx.RETURN() != null) {

        }
        else if (statementCtx.CONTINUE() != null) {

        }
        else if (statementCtx.scanInvocation() != null) {

        }
        else if (statementCtx.printInvocation() != null) {

        }
        else if(statementCtx.printInvocation() != null){
            StatementExpressionAnalyzer expressionAnalyzer = new StatementExpressionAnalyzer();
            expressionAnalyzer.analyze(statementCtx.statementExpression());
        }
    }

    private void handleDoStatement(DoStatementContext doStatement) {

        BlockContext block = doStatement.block();

        DoWhileCommand doWhileCommand = new DoWhileCommand(doStatement.Identifier(), doStatement.additiveExpression());
        StatementControlOverseer.getInstance().openControlledCommand(doWhileCommand);

        BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
        blockAnalyzer.analyze(block);

        StatementControlOverseer.getInstance().compileControlledCommand();
    }


    // NOT COMPLETE YET
    public void handleIfStatement(IfThenStatementContext ifthenCtx){

        List<BlockContext> blockstatments = ifthenCtx.block();
        List<ConditionalExpressionContext> conditionalStatments = ifthenCtx.conditionalExpression();

        int i;
        for(i = 0; i < conditionalStatments.size(); i++){
            IFCommand ifCommand = new IFCommand(ifthenCtx.conditionalExpression(i));
            StatementControlOverseer.getInstance().openConditionalCommand(ifCommand);

            BlockContext block = ifthenCtx.block(i);

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            blockAnalyzer.analyze(block);

            StatementControlOverseer.getInstance().reportExitPositiveRule();
        }

        // if ELSE statment exist
        if (ifthenCtx.block(i) != null) {
            BlockContext block = ifthenCtx.block(i);

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            blockAnalyzer.analyze(block);
        }
        StatementControlOverseer.getInstance().compileControlledCommand();

    }

    public void handleWhilwStatement(WhileStatementContext whileStatement) {
        BlockContext block = whileStatement.block();

        WhileCommand whileCommand = new WhileCommand(whileStatement.Identifier(), whileStatement.expression());
        StatementControlOverseer.getInstance().openControlledCommand(whileCommand);

        BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
        blockAnalyzer.analyze(block);

        StatementControlOverseer.getInstance().compileControlledCommand();
    }

    private void handleForStatement(ForStatementContext forStatement) {

        ScopeCreator.getInstance().openScope();

        ForControlAnalyzer forControlAnalyzer = new ForControlAnalyzer();
        forControlAnalyzer.analyze(forStatement.forheader());

        ForCommand forCommand = new ForCommand(forControlAnalyzer.getLocalVarDecContext(), forControlAnalyzer.getExprContext(), forControlAnalyzer.getUpdateCommand());
        StatementControlOverseer.getInstance().openControlledCommand(forCommand);

        BlockContext blkCtx = forStatement.block();
        BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
        blockAnalyzer.analyze(blkCtx);

        StatementControlOverseer.getInstance().compileControlledCommand();

        ScopeCreator.getInstance().closeScope();
        System.out.println("End of FOR loop");
    }
}
