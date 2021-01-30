package model.Sematic;

import model.Commands.*;
import model.Execution.ExecutionManager;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.ScopeCreator;

import java.util.List;

public class StatementAnalyzer {
    public void analyze(StatementContext statementCtx) {
        if(statementCtx.ifThenStatement() != null) {
            this.handleIfStatement(statementCtx.ifThenStatement());
        }
        else if (statementCtx.whileStatement() != null) {
            this.handleWhileStatement(statementCtx.whileStatement());
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

        }
        else if (statementCtx.RETURN() != null) {
            this.handleReturnStatement(statementCtx.expression());
        }
        else if (statementCtx.scanInvocation() != null) {
            this.handleScanStatement(statementCtx.scanInvocation());
        }
        else if (statementCtx.printInvocation() != null) {
            this.handlePrintStatement(statementCtx.printInvocation().expression(0));
        }
        else if(statementCtx.printInvocation() != null){
            StatementExpressionAnalyzer expressionAnalyzer = new StatementExpressionAnalyzer();
            expressionAnalyzer.analyze(statementCtx.statementExpression());
        }
    }


    private void handleDoStatement(DoStatementContext doStatement) {

        BlockContext block = doStatement.block();

        DoWhileCommand doWhileCommand = new DoWhileCommand(doStatement.Identifier(), doStatement.expression());
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
            IFCommand ifCommand = new IFCommand(ifthenCtx.conditionalExpression(i).expression());
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

    public void handleWhileStatement(WhileStatementContext whileStatement) {
        BlockContext block = whileStatement.block();

        WhileCommand whileCommand = new WhileCommand(whileStatement.Identifier(), whileStatement.expression());
        StatementControlOverseer.getInstance().openControlledCommand(whileCommand);

        BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
        blockAnalyzer.analyze(block);

        StatementControlOverseer.getInstance().compileControlledCommand();
    }

    private void handleForStatement(ForStatementContext forStatement) {

        ScopeCreator.getInstance().openScope();


//        ForControlAnalyzer forControlAnalyzer = new ForControlAnalyzer();
//        forControlAnalyzer.analyze(forStatement.forheader());
        String iteration = "";
        if(forStatement.forheader().UPTO()!=null){
            iteration = "up to";
        }else{
            iteration = "down to";
        }


        ForCommand forCommand = new ForCommand(forStatement.forheader().forinitializer(), forStatement.forheader().expression(0), iteration);
        StatementControlOverseer.getInstance().openControlledCommand(forCommand);

        BlockContext blkCtx = forStatement.block();
        BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
        blockAnalyzer.analyze(blkCtx);

        StatementControlOverseer.getInstance().compileControlledCommand();

        ScopeCreator.getInstance().closeScope();
        System.out.println("End of FOR loop");
    }

    private void handleScanStatement(ScanInvocationContext scanInvocation) {
        ScanCommand scanCommand;

        if(scanInvocation.expression(1) != null)
            scanCommand = new ScanCommand(scanInvocation.expression(0).getText(), scanInvocation.expression(1), scanInvocation.Identifier().getText());
        else
            scanCommand = new ScanCommand(scanInvocation.expression(0).getText(), scanInvocation.Identifier().getText());

        CommandExecuter.handleStatementExecution(scanCommand);
    }

    private void handlePrintStatement(ExpressionContext ctx) {
        PrintCommand printCommand = new PrintCommand(ctx);
        CommandExecuter.handleStatementExecution(printCommand);
//        StatementControlOverseer statementControl = StatementControlOverseer.getInstance();
//        //add to conditional controlled command
//        if(statementControl.isInConditionalCommand()) {
//            IConditionalCommand conditionalCommand = (IConditionalCommand) statementControl.getActiveControlledCommand();
//
//            if(statementControl.isInPositiveRule()) {
//                conditionalCommand.addPositiveCommand(printCommand);
//            }
//            else {
//                conditionalCommand.addNegativeCommand(printCommand);
//            }
//        }
//
//        else if(statementControl.isInControlledCommand()) {
//            IControlledCommand controlledCommand = (IControlledCommand) statementControl.getActiveControlledCommand();
//            controlledCommand.addCommand(printCommand);
//        }
//        else {
//            ExecutionManager.getInstance().addCommand(printCommand);
//        }

    }
    private void handleReturnStatement(ExpressionContext returnExpr) {
        
    }
}
