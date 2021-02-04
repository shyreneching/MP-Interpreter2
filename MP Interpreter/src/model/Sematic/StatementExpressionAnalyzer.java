package model.Sematic;

import model.Commands.AssignmentCommand;
import model.Commands.ExpressionCommand;
import model.Commands.MethodCallCommand;
import model.ErrorChecking.ErrorHandler;
import model.ErrorChecking.PseudoErrorListener;
import model.Item.PseudoArray;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
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
            PseudoErrorListener.reportCustomError(ErrorHandler.UNDECLARED_FUNCTION, "", methodInvocation.Identifier().getText(), lineNumber);
        }

        MethodCallCommand methodCallCommand = new MethodCallCommand(methodInvocation.Identifier(), methodInvocation.expressionList(0), methodInvocation.getStart().getLine());
        CommandExecuter.handleStatementExecution(methodCallCommand);
    }

    private void handleAssignmentStatement(AssignmentContext assignment) {
//        System.out.println("Enter Assignment!!!!!!!!!!!!!");
//        Scope scope = ScopeCreator.getInstance().getActiveScope();
//        PseudoValue pseudoValue = scope.searchVariableIncludingLocal(assignment.Identifier().getText());
//
//        if(pseudoValue == null){
//            Token firstToken = assignment.getStart();
//            int lineNumber = firstToken.getLine();
//            PseudoErrorListener.reportCustomError(ErrorHandler.UNDECLARED_VARIABLE, "", assignment.Identifier().getText(), lineNumber);
//        }
        ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();


        AssignmentCommand assignmentCommand = null;
        if(assignment.LBRACK()!= null){ // Shyrene added - for array declaration
            ExpressionCommand expressionCommand = new ExpressionCommand(assignment.expression(0));
            expressionCommand.execute();
            if(!expressionCommand.isString() && expressionCommand.getValueResult().stripTrailingZeros().scale() <= 0 ){
                PseudoValue pseudoValue = VariableSearcher.searchVariableCorrectly(assignment.Identifier().getText());
                if(pseudoValue != null){
                    if(pseudoValue.getValue() != null && pseudoValue.getValue() instanceof PseudoArray && ((PseudoArray)pseudoValue.getValue()).getSize() > 0){
                        PseudoArray pseudoArray = ((PseudoArray) pseudoValue.getValue());
                        if(expressionCommand.getValueResult().intValue() < pseudoArray.getSize()){
                            assignmentCommand = new AssignmentCommand(assignment.Identifier(), assignment.expression(0), assignment.expression(1));
                            expressionAnalyzer.analyze(assignment.expression(1));
                        }
                    } else{
                        assignmentCommand = new AssignmentCommand(assignment.Identifier(), assignment.expression(0), assignment.expression(1));
                        expressionAnalyzer.analyze(assignment.expression(1));
                    }

                } else {
//                    System.out.println("StatementExpressionAnalyzer - pseudoValue: " + pseudoValue);
                    PseudoErrorListener.reportCustomError(ErrorHandler.UNDECLARED_VARIABLE, "",assignment.Identifier().getText() , assignment.getStart().getLine());
                }


            }

        } else {
            expressionAnalyzer.analyze(assignment.expression(0));
            OperationsAnalyzer operationsAnalyzer = new OperationsAnalyzer();
            operationsAnalyzer.analyze(assignment.expression(0));
            assignmentCommand = new AssignmentCommand(assignment.Identifier(), assignment.expression(0));
        }
        CommandExecuter.handleStatementExecution(assignmentCommand);
    }
}
