package model.Sematic;

import model.ErrorChecking.Checker;
import model.PseudoCodeParser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExpressionAnalyzer implements ParseTreeListener {

    private boolean hasVoidMethodCall;
    private ExpressionContext exprCtx;

    public void analyze(ExpressionContext exprCtx){
        this.exprCtx = exprCtx;
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

//            } else if (isArrayElement(exprCtx)) {

            }
            else if (Checker.isVariableOrConst(exprCtx)) {
//                this.evaluateVariable(exprCtx);
            }

        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
