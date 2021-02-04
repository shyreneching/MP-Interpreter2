package model.Sematic;

import model.Commands.ExpressionCommand;
import model.ErrorChecking.Checker;
import model.ErrorChecking.ErrorHandler;
import model.ErrorChecking.PseudoErrorListener;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class OperationsAnalyzer implements ParseTreeListener {

    private boolean hasSemanticError;
    private ExpressionContext exprCtx;

    private String typeConsistent;

    public void analyze(ExpressionContext exprCtx){
        this.exprCtx = exprCtx;
        this.hasSemanticError  = false;
        this.typeConsistent = "";
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, exprCtx);
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof ExpressionContext){
            ExpressionContext exprCtx = (ExpressionContext) ctx;

           if (Checker.isVariableOrConst(exprCtx)) {
                this.varTypeCheck(exprCtx);
            } else if( exprCtx.primary()!= null && exprCtx.primary().literal()!= null){
                System.out.println("ExpressionAnalyzer - Literal checking");
                varTypeCheck(exprCtx);
            }

        }
    }

    private void varTypeCheck(ExpressionContext exprCtx) {
//        System.out.println("EXPRESSION ANALYZER: " + exprCtx.getText());
        if(exprCtx.primary().literal() != null){ //Shyrene added check if constant
            if(exprCtx.primary().literal().IntegerLiteral(0) != null && exprCtx.primary().literal().IntegerLiteral(1) == null){
                this.typeConsistent = this.typeConsistent + "I";
            } else if(exprCtx.primary().literal().StringLiteral() != null){
                this.typeConsistent = this.typeConsistent + "S";
            } else if(exprCtx.primary().literal().BooleanLiteral() != null){
                this.typeConsistent = this.typeConsistent + "B";
            } else if(exprCtx.primary().literal().FloatingPointLiteral() != null){
                this.typeConsistent = this.typeConsistent + "F";
            }

        } else if(exprCtx.Identifier() != null || exprCtx.primary().Identifier() != null){ // variable

            PseudoValue pseudoValue;
            if(exprCtx.Identifier() == null ){
                pseudoValue = VariableSearcher.searchVariableCorrectly(exprCtx.primary().Identifier().getText());
            } else{
                pseudoValue = VariableSearcher.searchVariableCorrectly(exprCtx.Identifier().getText());
            }

            if(pseudoValue != null){
                PseudoValue.PrimitiveType primType = pseudoValue.getPrimitiveType();

                if(primType.equals(PseudoValue.PrimitiveType.INT)){
                    this.typeConsistent = this.typeConsistent + "I";
                } else if(primType.equals(PseudoValue.PrimitiveType.STRING)){
                    this.typeConsistent = this.typeConsistent + "S";
                } else if(primType.equals(PseudoValue.PrimitiveType.BOOLEAN)){
                    this.typeConsistent = this.typeConsistent + "B";
                } else if(primType.equals(PseudoValue.PrimitiveType.FLOAT)){
                    this.typeConsistent = this.typeConsistent + "F";
                }
            }
        }

    }


    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof ExpressionContext){
            this.uniqueTypeChecker(typeConsistent);
        }
    }

    private void uniqueTypeChecker(String typeConsistent) {
        StringBuilder sb = new StringBuilder(typeConsistent);
        for (int i = 0; i < sb.length(); i++) {
            int count = 0;
            for (int j = i + 1; j < sb.length(); j++) {
                if (sb.charAt(i) == sb.charAt(j)) {
                    sb.deleteCharAt(j);
                    j--;
                    count++;
                }
            }
            if (count >= 1) {
                sb.deleteCharAt(i);
                i--;
            }
        }
//        System.out.println(sb.length());
        if(typeConsistent.length() > 1 && sb.length() != 0){
            this.setHasSemanticError();
            PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, "", this.exprCtx.getStart().getLine());
        }
    }


    public void setHasSemanticError() {
        this.hasSemanticError = true;
    }

    public String getTypeConsistent(){
        return this.typeConsistent;
    }

    public boolean isHasSemanticError() {
        return hasSemanticError;
    }
}
