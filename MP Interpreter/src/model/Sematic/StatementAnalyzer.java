package model.Sematic;

import model.Commands.*;
import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.MultipleVariableDeclarationChecker;
import model.ErrorChecking.PseudoErrorListener;
import model.ErrorChecking.UndeclaredChecker;
import model.Execution.ExecutionManager;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.ScopeCreator;

import java.util.List;
import java.util.regex.PatternSyntaxException;

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
        else if(statementCtx.statementExpression() != null){
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

        ForinitializerContext forinitializerCtx = forStatement.forheader().forinitializer();
        if(forinitializerCtx.INT() == null){ //Shyrene added - checking if upeerbound just assignment

            UndeclaredChecker.verifyVariableOrConst(forStatement.forheader().forinitializer().Identifier());
        } else{
            MultipleVariableDeclarationChecker.verifyVariableOrConst(forinitializerCtx.Identifier());

        }

        ExpressionCommand laterBound= new ExpressionCommand(forStatement.forheader().expression(0));
        laterBound.execute();
        ExpressionCommand firstBound = new ExpressionCommand(forStatement.forheader().forinitializer().customAssignError().expression());
        firstBound.execute();
        boolean lefthand = false;
        boolean righthand = false;
        if (!firstBound.isString() && firstBound.getValueResult().stripTrailingZeros().scale() <= 0){
            lefthand = true;
        } else {
            PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "For loop left hand is not 'INT' declaration. ", forStatement.getStart().getLine());
        }

        if(!laterBound.isString() && laterBound.getValueResult().stripTrailingZeros().scale() <= 0){
            righthand = true;
        } else{
            PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "For loop right hand is not 'INT' declaration. ", forStatement.getStart().getLine());
        }

        if(lefthand && righthand){
            ScopeCreator.getInstance().openScope();

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

        ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
        expressionAnalyzer.analyze(ctx);
        if(!expressionAnalyzer.isHasSemanticError()){
            PrintCommand printCommand = new PrintCommand(ctx);

            CommandExecuter.handleStatementExecution(printCommand);
        }

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
        ReturnCommand returnCommand = new ReturnCommand(returnExpr, ExecutionManager.getInstance().getCurrentFunction());

        StatementControlOverseer statementControl = StatementControlOverseer.getInstance();

        if(statementControl.isInConditionalCommand()) {
            IConditionalCommand conditionalCommand = (IConditionalCommand) statementControl.getActiveControlledCommand();

            if(statementControl.isInPositiveRule()) {
                conditionalCommand.addPositiveCommand(returnCommand);
            }
            else {
                String functionName = ExecutionManager.getInstance().getCurrentFunction().getMethodName();
                conditionalCommand.addNegativeCommand(returnCommand);
            }
        }

        else if(statementControl.isInControlledCommand()) {
            IControlledCommand controlledCommand = (IControlledCommand) statementControl.getActiveControlledCommand();
            controlledCommand.addCommand(returnCommand);
        }
        else {
            ExecutionManager.getInstance().addCommand(returnCommand);
        }
    }
}
