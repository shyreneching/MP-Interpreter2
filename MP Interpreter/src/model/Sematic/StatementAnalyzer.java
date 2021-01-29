package model.Sematic;

import model.Commands.DoWhileCommand;
import model.Commands.IFCommand;
import model.Commands.WhileCommand;
import model.PseudoCodeParser.*;

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
        else if (statementCtx.statementWithoutTrailingSubstatement() != null) {
            StatementWithoutTrailingSubstatementContext statementwithSub = statementCtx.statementWithoutTrailingSubstatement();
            StatementWithoutTrailingAnalyzer statementAnalyzer = new StatementWithoutTrailingAnalyzer();
            statementAnalyzer.analyze(statementwithSub);
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
        List<OnlyConditionalExpressionContext> conditionalStatments = ifthenCtx.onlyConditionalExpression();

        int i;
        for(i = 0; i < conditionalStatments.size(); i++){
            IFCommand ifCommand = new IFCommand(ifthenCtx.onlyConditionalExpression(i));
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

        WhileCommand whileCommand = new WhileCommand(whileStatement.Identifier(), whileStatement.additiveExpression());
        StatementControlOverseer.getInstance().openControlledCommand(whileCommand);

        BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
        blockAnalyzer.analyze(block);

        StatementControlOverseer.getInstance().compileControlledCommand();
    }

    private void handleForStatement(ForStatementContext forStatement) {
    }
}
