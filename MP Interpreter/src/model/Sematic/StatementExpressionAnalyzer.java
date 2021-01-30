package model.Sematic;

import model.Commands.AssignmentCommand;
import model.Commands.MethodCallCommand;
import model.PseudoCodeParser.*;

public class StatementExpressionAnalyzer {
    public void analyze(StatementExpressionContext statementExpression) {
        if(statementExpression.assignment() != null) {
            this.handleAssignmentStatement(statementExpression.assignment());
        }
        else if (statementExpression.methodInvocation() != null) {
            this.handleMethod(statementExpression.methodInvocation());
        }
    }

    private void handleMethod(MethodInvocationContext methodInvocation) {
        MethodCallCommand methodCallCommand = new MethodCallCommand(methodInvocation.Identifier(), methodInvocation.expressionList());
        CommandExecuter.handleStatementExecution(methodCallCommand);
    }

    private void handleAssignmentStatement(AssignmentContext assignment) {
        AssignmentCommand assignmentCommand;
        if(assignment.expression(1) != null){
            assignmentCommand = new AssignmentCommand(assignment.Identifier(), assignment.expression(1), assignment.expression(0));
        } else {
            assignmentCommand = new AssignmentCommand(assignment.Identifier(), assignment.expression(0));
        }
        CommandExecuter.handleStatementExecution(assignmentCommand);
    }
}
