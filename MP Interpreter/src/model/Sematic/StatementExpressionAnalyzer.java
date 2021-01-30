package model.Sematic;

import model.Commands.AssignmentCommand;
import model.Commands.MethodCallCommand;
import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.PseudoErrorListener;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.Scope;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.Token;

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
//        System.out.println("Enter Method Invocation!!!!!!!!!!!!!");
        PseudoMethod pseudoMethod = SymbolTableManager.getInstance().getMethod(methodInvocation.Identifier().getText());

        if(pseudoMethod == null){
            Token firstToken = methodInvocation.getStart();
            int lineNumber = firstToken.getLine();
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_FUNCTION, "", methodInvocation.Identifier().getText(), lineNumber);
        }

        MethodCallCommand methodCallCommand = new MethodCallCommand(methodInvocation.Identifier(), methodInvocation.expressionList());
        CommandExecuter.handleStatementExecution(methodCallCommand);
    }

    private void handleAssignmentStatement(AssignmentContext assignment) {
//        System.out.println("Enter Assignment!!!!!!!!!!!!!");
        Scope scope = ScopeCreator.getInstance().getActiveScope();
        PseudoValue pseudoValue = scope.searchVariableIncludingLocal(assignment.Identifier().getText());

        if(pseudoValue == null){
            Token firstToken = assignment.getStart();
            int lineNumber = firstToken.getLine();
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "", assignment.Identifier().getText(), lineNumber);
        }

        AssignmentCommand assignmentCommand;
        if(assignment.expression(1) != null){
            assignmentCommand = new AssignmentCommand(assignment.Identifier(), assignment.expression(1), assignment.expression(0));
        } else {
            assignmentCommand = new AssignmentCommand(assignment.Identifier(), assignment.expression(0));
        }
        CommandExecuter.handleStatementExecution(assignmentCommand);
    }
}
