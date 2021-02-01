package model.Sematic;

import model.Commands.AssignmentCommand;
import model.Commands.ExpressionCommand;
import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.PseudoErrorListener;
import model.ErrorChecking.TypeChecker;
import model.Item.PseudoArray;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.Scope;
import model.SymbolTable.Scope.ScopeCreator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigDecimal;

public class LocalVariableAnalyzer implements ParseTreeListener {
    private boolean isFinal = false;
    private String type;

    public void analyze(LocalVariableDeclarationContext localVariableDeclaration) {

        if(localVariableDeclaration.variableModifier() != null){
            this.isFinal = true;
        }

        if(localVariableDeclaration.result().LBRACK() == null){
            this.type = localVariableDeclaration.result().unannType().getText();
        } else {
            this.type = "array";
        }
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, localVariableDeclaration);
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

        if (ctx instanceof VariableDeclaratorContext) {
            VariableDeclaratorContext varCtx = (VariableDeclaratorContext) ctx;
            PseudoValue pseudoValue = null;
            if(varCtx.variableInitializer() != null){
                if(!this.type.equals("array")){
//                    System.out.println("HELOOOOOOOOOOOOOOOO");
//                    System.out.println("type: "+ type);

//                    pseudoValue = PseudoValue.createEmptyVariable(type);
                    System.out.println("Local Variable Analyzer - expr: " +varCtx.variableInitializer().expression().getText());
                    ExpressionCommand expressionCommand = new ExpressionCommand(varCtx.variableInitializer().expression());
                    expressionCommand.execute();
                    Object value = null;

                    if(this.type.equals("bool")){
                        if(expressionCommand.getValueResult().compareTo(new BigDecimal("0")) == 0){
                            value = false;
                        } else {
                            value = true;
                        }
                        pseudoValue = new PseudoValue(value, type);
                    } else if(this.type.equals("int")){
                        value = expressionCommand.getValueResult().intValue();
                        pseudoValue = new PseudoValue(value, type);
                    } else if(this.type.equals("float")){
                        value = expressionCommand.getValueResult().floatValue();
                        pseudoValue = new PseudoValue(value, type);
                    } else if(this.type.equals("String")){
                        value = expressionCommand.getStringResult();
                        pseudoValue = new PseudoValue(value, type);
                    }

                    System.out.println("LocalVariableAnalyzer - Value: "+ value);
                    TypeChecker typeChecker = new TypeChecker(pseudoValue,varCtx.variableInitializer().expression());
                    typeChecker.verify();
                    if(isFinal){
                        pseudoValue.makeConst();
                    }
                    AssignmentCommand assignmentCommand = new AssignmentCommand(varCtx.Identifier(), varCtx.variableInitializer().expression());
                    CommandExecuter.handleStatementExecution(assignmentCommand);

                } else{
                    Token firstToken = varCtx.getStart();
                    int lineNumber = firstToken.getLine();
                    if(!type.equals(varCtx.variableInitializer().arrayInitializer().unannType().getText())){

                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH, "", lineNumber);
                    }
                    ExpressionCommand expressionCommand = new ExpressionCommand(varCtx.variableInitializer().arrayInitializer().expression());
                    expressionCommand.execute();
                    // evaluate varCtx.variableInitializer().arrayInitializer().expression();)
//                    TypeChecker.isNumeric(varCtx.variableInitializer().arrayInitializer().expression().getText());
                    int arraysize;
                    if(expressionCommand.isNumeric() && !expressionCommand.getValueResult().toString().contains(".") ){
                        arraysize = expressionCommand.getValueResult().intValue();
                        PseudoArray pseudoArray = PseudoArray.createArray(type,varCtx.Identifier().getText());
//                    if(!(arraysize instanceof Integer)){
//                        PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "Invalid array inatialization.", lineNumber);
//                    }
                        pseudoArray.initializeSize(arraysize);
                        if(isFinal){
                            pseudoArray.markFinal();
                        }
                        pseudoValue = new PseudoValue(pseudoArray, "array");
                    }
                    Scope scope = ScopeCreator.getInstance().getActiveScope();
                    if(pseudoValue != null){
                        scope.addPseudoValue(varCtx.Identifier().getText(), pseudoValue);
                    }
//                    AssignmentCommand assignmentCommand = new AssignmentCommand(varCtx.Identifier(), varCtx.variableInitializer().expression());
//                    CommandExecuter.handleStatementExecution(assignmentCommand);
                }
            } else {
                pseudoValue = PseudoValue.createEmptyVariable(type);
            }
//            System.out.println(pseudoValue);
            Scope scope = ScopeCreator.getInstance().getActiveScope();
//            System.out.println("THIS IS CURRENT SCOPE " + scope.getParent());
            if(pseudoValue != null){
                scope.addPseudoValue(varCtx.Identifier().getText(), pseudoValue);
            }

        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
