package model.Sematic;

import model.Commands.*;
import model.Execution.ExecutionManager;
import model.PseudoCodeParser.*;

public class StatementWithoutTrailingAnalyzer {
    public void analyze(StatementWithoutTrailingSubstatementContext statementCtx) {
        if (statementCtx.emptyStatement() != null) {

        }
        else if (statementCtx.statementExpression() != null) {
            this.handleEpressionStatement(statementCtx.statementExpression());
        }
//        else if (statementCtx.switchStatement() != null) {
//
//        }

        else if (statementCtx.breakStatement() != null) {

        }
        else if (statementCtx.continueStatement() != null) {

    }
        else if (statementCtx.returnStatement() != null) {
            ExpressionContext exprCtx = statementCtx.returnStatement().expression();
            ReturnCommand returnCommand = new ReturnCommand(exprCtx, ExecutionManager.getInstance().getCurrentFunction());
            /*
             * TODO: Return commands supposedly stops a controlled or conditional command and returns back the control to the caller.
             * Find a way to halt such commands if they are inside a controlled command.
             */ctionName = ExecutionManager.getInstance().getCurrentFunction().getMethodName();
                    ExecutionManager.getInstance().getCurrentFunction().setValidReturns(true);
                    conditionalCommand.addNegativeCommand(returnCommand);
                }
            }

            StatementControlOverseer statementControl = StatementControlOverseer.getInstance();

            if(statementControl.isInConditionalCommand()) {
                IConditionalCommand conditionalCommand = (IConditionalCommand) statementControl.getActiveControlledCommand();

                if(statementControl.isInPositiveRule()) {
                    conditionalCommand.addPositiveCommand(returnCommand);
                }
                else {
                    String fun
            else if(statementControl.isInControlledCommand()) {
                IControlledCommand controlledCommand = (IControlledCommand) statementControl.getActiveControlledCommand();
                controlledCommand.addCommand(returnCommand);
            }
//            else if (statementControl.isInAttemptCommand()) {
//                IAttemptCommand attemptCommand = (IAttemptCommand) statementControl.getActiveControlledCommand();
//
//                if(statementControl.isInTryBlock()) {
//                    attemptCommand.addTryCommand(returnCommand);
//                } else {
//                    attemptCommand.addCatchCommand(statementControl.getCurrentCatchType(), returnCommand);
//                }
//            }
            else {
                ExecutionManager.getInstance().getCurrentFunction().setValidReturns(true);

                ExecutionManager.getInstance().addCommand(returnCommand);
            }
        }

    }

    private void handleEpressionStatement(StatementExpressionContext statementExpression) {
        if (statementExpression.assignment() != null) {
            AssignmentContext assignmentContext = statementExpression.assignment();
            AssignmentCommand command = new AssignmentCommand(assignmentContext.leftHandSide(), assignmentContext.expression());

        }
//        else if (statementExpression.postIncrementExpression() != null) {
//
//        }
//        else if (statementExpression.postDecrementExpression() != null) {
//
//        }
        else if (statementExpression.printInvocation() != null) {
            PrintInvocationContext printContext = statementExpression.printInvocation();
            PrintCommand printCommand = new PrintCommand(printContext);

            CommandExecuter.handleStatementExecution(printCommand);

        }
        else if (statementExpression.scanInvocation() != null) {
            ScanInvocationContext scanContext = statementExpression.scanInvocation();
            ScanCommand printCommand = new ScanCommand(scanContext);

            CommandExecuter.handleStatementExecution(printCommand);
        }
        else if (statementExpression.methodInvocation() != null) {
            String functionName = statementExpression.methodInvocation().Identifier().getText();

            MethodCallCommand methodCallCommand = new MethodCallCommand(functionName, statementExpression.methodInvocation().argumentList());
            CommandExecuter.handleStatementExecution(methodCallCommand);
        }
    }


}
