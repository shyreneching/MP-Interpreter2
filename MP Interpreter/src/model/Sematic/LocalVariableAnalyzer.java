package model.Sematic;

import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.PseudoErrorListener;
import model.Item.PseudoArray;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.Scope;
import model.SymbolTable.Scope.ScopeCreator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

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
                    ExpressionContext value = varCtx.variableInitializer().expression();

                    // Evaluate value

                    pseudoValue = new PseudoValue(value, type);
                    if(isFinal){
                        pseudoValue.makeConst();
                    }

                } else{
                    Token firstToken = varCtx.getStart();
                    int lineNumber = firstToken.getLine();
                    if(!type.equals(varCtx.variableInitializer().arrayInitializer().unannType().getText())){

                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH, "", lineNumber);
                    }

                    // evaluate varCtx.variableInitializer().arrayInitializer().expression();)
//                    int arraysize = varCtx.variableInitializer().arrayInitializer().expression();


                    varCtx.variableInitializer().arrayInitializer().expression();
                    PseudoArray pseudoArray = PseudoArray.createArray(type,varCtx.Identifier().getText());
//                    if(!(arraysize instanceof Integer)){
//                        PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "Invalid array inatialization.", lineNumber);
//                    }
//                    pseudoArray.initializeSize(arraysize);
                    if(isFinal){
                        pseudoArray.markFinal();
                    }
                }
            } else {
                pseudoValue = PseudoValue.createEmptyVariable(type);
            }
            Scope scope = ScopeCreator.getInstance().getActiveScope();
            if(pseudoValue != null){
                scope.addPseudoValue(varCtx.Identifier().getText(), pseudoValue);
            }

        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
