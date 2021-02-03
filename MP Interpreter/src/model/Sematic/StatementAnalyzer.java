package model.Sematic;

import model.Commands.*;
import model.ErrorChecking.ErrorHandler;
import model.ErrorChecking.MultipleVariableDeclarationChecker;
import model.ErrorChecking.PseudoErrorListener;
import model.ErrorChecking.UndeclaredChecker;
import model.Execution.ExecutionManager;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.ScopeCreator;

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

        DoWhileCommand doWhileCommand;
        if(doStatement.expression().size() == 1) {
            if (doStatement.UPTO() != null)
                doWhileCommand = new DoWhileCommand(doStatement.Identifier(0), doStatement.expression(0), "up to");
            else
                doWhileCommand = new DoWhileCommand(doStatement.Identifier(0), doStatement.expression(0), "down to");
        } else {
            if (doStatement.UPTO() != null)
                doWhileCommand = new DoWhileCommand(doStatement.Identifier(0), doStatement.expression(0), doStatement.expression(1), "up to");
            else
                doWhileCommand = new DoWhileCommand(doStatement.Identifier(0), doStatement.expression(0), doStatement.expression(1), "down to");
        }
        StatementControlOverseer.getInstance().openControlledCommand(doWhileCommand);

        BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
        blockAnalyzer.analyze(block);

        StatementControlOverseer.getInstance().compileControlledCommand();

    }


    // NOT COMPLETE YET
    public void handleIfStatement(IfThenStatementContext ifthenCtx){

        IFCommand ifCommand = new IFCommand(ifthenCtx.conditionalExpression().expression());
        StatementControlOverseer.getInstance().openConditionalCommand(ifCommand);

        BlockContext block = ifthenCtx.block(0);

        BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
        blockAnalyzer.analyze(block);

        StatementControlOverseer.getInstance().reportExitPositiveRule();

        if(ifthenCtx.ifThenStatement() != null){
            handleIfStatement(ifthenCtx.ifThenStatement());
        }

        if (ifthenCtx.block(1) != null) {
            BlockContext blockctx = ifthenCtx.block(1);
            blockAnalyzer.analyze(blockctx);
        }
        StatementControlOverseer.getInstance().compileControlledCommand();

    }

    public void handleWhileStatement(WhileStatementContext whileStatement) {
        boolean isSuccess;

        isSuccess = UndeclaredChecker.verifyVariableOrConst(whileStatement.Identifier(0));
        String msg = "right hand";
        boolean lefthand = false;
        boolean righthand = true;

        if(isSuccess){
            UndeclaredChecker firstCheck = new UndeclaredChecker(whileStatement.expression(0));
            firstCheck.verify();
            ExpressionCommand firstBound = new ExpressionCommand(whileStatement.expression(0));
            firstBound.execute();

            if(whileStatement.expression(1) != null){
                msg = "array index";
                UndeclaredChecker secondCheck = new UndeclaredChecker(whileStatement.expression(1));
                secondCheck.verify();
                ExpressionCommand laterBound= new ExpressionCommand(whileStatement.expression(1));
                laterBound.execute();
                if(!laterBound.isString() && laterBound.getValueResult().stripTrailingZeros().scale() <= 0 || laterBound.getValueResult().toString().equals("0")){
                    righthand = true;
                } else{
                    righthand = false;
                    PseudoErrorListener.reportCustomError(ErrorHandler.DEFAULT, "While loop right hand is not 'INT' declaration. ", whileStatement.getStart().getLine());
                }
            }


            if (!firstBound.isString() && firstBound.getValueResult().stripTrailingZeros().scale() <= 0 || firstBound.getValueResult().toString().equals("0")){
                lefthand = true;
            } else {
                PseudoErrorListener.reportCustomError(ErrorHandler.DEFAULT, "While loop " + msg + " is not 'INT' declaration. ", whileStatement.getStart().getLine());
            }

            if(lefthand && righthand){
                BlockContext block = whileStatement.block();
                WhileCommand whileCommand;
                if(whileStatement.expression().size() == 1) {
                    if (whileStatement.UPTO() != null)
                        whileCommand = new WhileCommand(whileStatement.Identifier(0), whileStatement.expression(0), "up to");
                    else
                        whileCommand = new WhileCommand(whileStatement.Identifier(0), whileStatement.expression(0), "down to");
                } else {
                    if (whileStatement.UPTO() != null)
                        whileCommand = new WhileCommand(whileStatement.Identifier(0), whileStatement.expression(0), whileStatement.expression(1), "up to");
                    else
                        whileCommand = new WhileCommand(whileStatement.Identifier(0), whileStatement.expression(0), whileStatement.expression(1), "down to");
                }
                StatementControlOverseer.getInstance().openControlledCommand(whileCommand);

                BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
                blockAnalyzer.analyze(block);

                StatementControlOverseer.getInstance().compileControlledCommand();
            }
        }


    }

    private void handleForStatement(ForStatementContext forStatement) {
        ScopeCreator.getInstance().openScope();


        boolean isSuccess;
        ForinitializerContext forinitializerCtx = forStatement.forheader().forinitializer();
        if(forinitializerCtx.INT() == null){ //Shyrene added - checking if lefthand just assignment
            isSuccess = UndeclaredChecker.verifyVariableOrConst(forStatement.forheader().forinitializer().Identifier());

        } else{
            isSuccess = MultipleVariableDeclarationChecker.verifyVariableOrConst(forinitializerCtx.Identifier());

        }

        if(isSuccess){
            UndeclaredChecker rightHandID = new UndeclaredChecker(forStatement.forheader().expression(0));
            rightHandID.verify();
            ExpressionCommand laterBound= new ExpressionCommand(forStatement.forheader().expression(0));
            laterBound.execute();
            UndeclaredChecker leftHandID = new UndeclaredChecker(forStatement.forheader().forinitializer().customAssignError().expression());
            leftHandID.verify();
            ExpressionCommand firstBound = new ExpressionCommand(forStatement.forheader().forinitializer().customAssignError().expression());
            firstBound.execute();
            boolean lefthand = false;
            boolean righthand = false;
            if (!firstBound.isString() && firstBound.getValueResult().stripTrailingZeros().scale() <= 0 || firstBound.getValueResult().toString().equals("0")){
                lefthand = true;
            } else {
                PseudoErrorListener.reportCustomError(ErrorHandler.DEFAULT, "For loop left hand is not 'INT' declaration. ", forStatement.getStart().getLine());
            }

            if(!laterBound.isString() && laterBound.getValueResult().stripTrailingZeros().scale() <= 0 || laterBound.getValueResult().toString().equals("0")){
                righthand = true;
            } else{
                PseudoErrorListener.reportCustomError(ErrorHandler.DEFAULT, "For loop right hand is not 'INT' declaration. ", forStatement.getStart().getLine());
            }

            if(lefthand && righthand){


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
            }
        }
        ScopeCreator.getInstance().closeScope();
    }

    private void handleScanStatement(ScanInvocationContext scanInvocation) {
        ScanCommand scanCommand;

        if(scanInvocation.expression().size() > 1)
            scanCommand = new ScanCommand(scanInvocation.expression(0), scanInvocation.expression(1), scanInvocation.Identifier());
        else
            scanCommand = new ScanCommand(scanInvocation.expression(0), scanInvocation.Identifier());

        CommandExecuter.handleStatementExecution(scanCommand);
    }

    private void handlePrintStatement(ExpressionContext ctx) {
        if(ctx != null){
            ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
            expressionAnalyzer.analyze(ctx);
            if(!expressionAnalyzer.isHasSemanticError()){
                PrintCommand printCommand = new PrintCommand(ctx);

                CommandExecuter.handleStatementExecution(printCommand);
            }
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
