package model.Sematic;

import model.ErrorChecking.Checker;
import model.ErrorChecking.ErrorHandler;
import model.ErrorChecking.PseudoErrorListener;
import model.Item.PseudoMethod;
import model.PseudoCodeParser.*;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class ExpressionAnalyzer implements ParseTreeListener {

    private boolean hasSemanticError;
    private ExpressionContext exprCtx;

    public void analyze(ExpressionContext exprCtx){
        this.exprCtx = exprCtx;
        this.hasSemanticError  = false;
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

            if (Checker.isFunctionCall(exprCtx)) {
                this.semcCheck(exprCtx);
//            } else if (isArrayElement(exprCtx)) {

            }
//            else if (Checker.isVariableOrConst(exprCtx)) {
////                this.evaluateVariable(exprCtx);
//            }

        }
    }

    private void semcCheck(ExpressionContext exprCtx) {

        PseudoMethod pseudoMethod = SymbolTableManager.getInstance().getMethod(exprCtx.Identifier().getText());
        if(pseudoMethod == null){
            PseudoErrorListener.reportCustomError(ErrorHandler.UNDECLARED_FUNCTION, "", exprCtx.Identifier().getText(), exprCtx.getStart().getLine());
            return;
        }
        if(pseudoMethod.getReturnType().equals(PseudoMethod.MethodType.VOID_TYPE)){
            this.setHasSemanticError();
            PseudoErrorListener.reportCustomError(ErrorHandler.DEFAULT, "Void function has no return value.", exprCtx.getStart().getLine());
        } else{
//            System.out.println("ExpressionAnalyzer - expr: " + exprCtx.getText());
//            System.out.println("ExpressionAnalyzer - function name: " + exprCtx.Identifier());
            if((exprCtx.expressionList() == null || exprCtx.expressionList().expression() == null)) {
//                System.out.println("1ExpressionAnalyzer - paramsN: " + pseudoMethod.getParameterValueSize());
//                System.out.println("1ExpressionAnalyzer - call list: " + exprCtx.expressionList() );
                if(pseudoMethod.getParameterValueSize() > 0){
                    PseudoErrorListener.reportCustomError(ErrorHandler.PARAMETER_COUNT_MISMATCH, "", pseudoMethod.getMethodName(),exprCtx.getStart().getLine());
                    this.setHasSemanticError();
                }
                return;
            }else{
                List<ExpressionContext> exprCtxList = exprCtx.expressionList().expression();

                //map values in parameters
                for(int i = 0; i < exprCtxList.size(); i++) {
                    System.out.println("ExpressionAnalyzer - params: " + exprCtxList.get(i).getText());
                    ExpressionContext expressionContext = exprCtxList.get(i);
                    pseudoMethod.verifyParameterByValueAt(expressionContext, i);
                }
            }
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    public void setHasSemanticError() {
        this.hasSemanticError = true;
    }

    public boolean isHasSemanticError() {
        return hasSemanticError;
    }
}
