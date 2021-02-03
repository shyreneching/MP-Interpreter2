package model.Sematic;

import model.Commands.ArrayInitializationCommand;
import model.Commands.AssignmentCommand;
import model.Commands.ExpressionCommand;
import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.MultipleVariableDeclarationChecker;
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
    private LocalVariableDeclarationContext localVariableDeclaration;

    public void analyze(LocalVariableDeclarationContext localVariableDeclaration) {
        this.localVariableDeclaration = localVariableDeclaration;
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
            MultipleVariableDeclarationChecker.verifyVariableOrConst(varCtx.Identifier());
//            MultipleVariableDeclarationChecker multVarChecker = new MultipleVariableDeclarationChecker(varCtx.Identifier(),varCtx);
//            multVarChecker.verify();
            PseudoValue pseudoValue = null;
            if(varCtx.variableInitializer() != null){
                if(!this.type.equals("array")){
//                    System.out.println("HELOOOOOOOOOOOOOOOO");
//                    System.out.println("type: "+ type);

//                    pseudoValue = PseudoValue.createEmptyVariable(type);
                    ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
                    expressionAnalyzer.analyze(varCtx.variableInitializer(0).expression());

                    if(!expressionAnalyzer.isHasSemanticError()){
                        System.out.println("LocalVariableAnalyzer - expr: " +varCtx.variableInitializer(0).expression().getText());
                        ExpressionCommand expressionCommand = new ExpressionCommand(varCtx.variableInitializer(0).expression());
                        expressionCommand.execute();
                        Object value = null;
                        boolean sucess = true;
                        if(expressionCommand.getValueResult().toString().equals("0")){
                            pseudoValue = PseudoValue.createEmptyVariable(type);
                            switch (type){
                                case "bool":
                                    value = true;
                                    break;
                                case "int":
                                    value = 0;
                                    break;
                                case "float":
                                    value = 0.0;
                                    break;
                                case "String":
                                    value = "";
                                    break;
                            }
                        } else if(this.type.equals("bool")&& !expressionCommand.isString()){
                            if(expressionCommand.getValueResult().compareTo(new BigDecimal("0")) == 0){
                                value = false;
                            } else if(expressionCommand.getValueResult().compareTo(new BigDecimal("1")) == 0){
                                value = true;
                            }
                            pseudoValue = new PseudoValue(value, type);
                        } else if(this.type.equals("int") && !expressionCommand.isString() && !expressionCommand.getValueResult().toString().contains(".")){
                            value = expressionCommand.getValueResult().intValue();
                            pseudoValue = new PseudoValue(value, type);
                        } else if(this.type.equals("float") && !expressionCommand.isString() && expressionCommand.getValueResult().toString().contains(".")){
                            value = expressionCommand.getValueResult().floatValue();
                            pseudoValue = new PseudoValue(value, type);
                        } else if(this.type.equals("String") && expressionCommand.isString()){
                            value = expressionCommand.getStringResult();
                            pseudoValue = new PseudoValue(value, type);
                        } else {
                            sucess = false;
                            PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH, "Expected value '" + type.toUpperCase() + "'. ", varCtx.getStart().getLine());
                        }

                        System.out.println("LocalVariableAnalyzer - Value: "+ value);
                        TypeChecker typeChecker = new TypeChecker(pseudoValue,varCtx.variableInitializer(0).expression());
                        typeChecker.verify();
                        if(isFinal && pseudoValue != null){
                            pseudoValue.makeConst();
                        }

                        if(sucess){
                            //Shyrene added - using variable declaration assignment command
                            AssignmentCommand assignmentCommand = new AssignmentCommand(varCtx.Identifier(), varCtx.variableInitializer(0).expression(), pseudoValue.getPrimitiveType());
                            CommandExecuter.handleStatementExecution(assignmentCommand);
                        }

                    }


                } else{
                    Token firstToken = varCtx.getStart();
                    int lineNumber = firstToken.getLine();
                    String arrayType = this.localVariableDeclaration.result().unannType().getText();
//                    System.out.println("LocalVariableAnalyzer - arrayType: "+ arrayType);
//                    System.out.println("LocalVariableAnalyzer - ititialize type: "+ varCtx.variableInitializer().arrayInitializer().unannType().getText());

                    if(!arrayType.equals(varCtx.variableInitializer(0).arrayInitializer().unannType().getText())){
                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH, "", lineNumber);
                    }

                    ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
                    expressionAnalyzer.analyze(varCtx.variableInitializer(0).arrayInitializer().expression());

                    if(!expressionAnalyzer.isHasSemanticError()){
                        ExpressionCommand expressionCommand = new ExpressionCommand(varCtx.variableInitializer(0).arrayInitializer().expression());
                        expressionCommand.execute();
                        // evaluate varCtx.variableInitializer().arrayInitializer().expression();)
//                    TypeChecker.isNumeric(varCtx.variableInitializer().arrayInitializer().expression().getText());
                        System.out.println("LocalVariableAnalyzer - arrayInitializationsize: "+ expressionCommand.getValueResult());
                        System.out.println("LocalVariableAnalyzer - isInt: "+ (expressionCommand.getValueResult().stripTrailingZeros().scale() <= 0 ));
                        int arraysize;
                        if(expressionCommand.getValueResult().toString().equals("0")){
                            System.out.println("Jfdklsgsegh we rgehg weriouwehg");
                            PseudoArray pseudoArray = PseudoArray.createArray(arrayType,varCtx.Identifier().getText());
                            pseudoValue = new PseudoValue(pseudoArray, "array");
                            ArrayInitializationCommand arrayInitializeCommand = new ArrayInitializationCommand(pseudoArray, varCtx.variableInitializer(0).arrayInitializer().expression());
                            CommandExecuter.handleStatementExecution(arrayInitializeCommand);
                        } else if(!expressionCommand.isString() && expressionCommand.getValueResult().stripTrailingZeros().scale() <= 0  && !expressionCommand.getValueResult().toString().contains(".")){


                            arraysize = expressionCommand.getValueResult().intValue();
                            PseudoArray pseudoArray = PseudoArray.createArray(arrayType,varCtx.Identifier().getText());

                            pseudoArray.initializeSize(arraysize);
                            if(isFinal){
                                pseudoArray.markFinal();
                            }
                            pseudoValue = new PseudoValue(pseudoArray, "array");
                        } else{
                            PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "Invalid initialization of array size. ", varCtx.getStart().getLine());
                        }

//                        Scope scope = ScopeCreator.getInstance().getActiveScope();
//                        if(pseudoValue != null){
//                            scope.addPseudoValue(varCtx.Identifier().getText(), pseudoValue);
//                        }
//                    AssignmentCommand assignmentCommand = new AssignmentCommand(varCtx.Identifier(), varCtx.variableInitializer().expression());
//                    CommandExecuter.handleStatementExecution(assignmentCommand);
                    }
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
