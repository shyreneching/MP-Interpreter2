package model.ErrorChecking;

import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.Item.PseudoValue.PrimitiveType;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.Scope;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeChecker implements IErrorChecker, ParseTreeListener {

    private PseudoValue pseudoValue;
    private ExpressionContext exprCtx;
    private int lineNumber;

    private String returnStmnt;

    public TypeChecker(PseudoValue assignmentValue, ExpressionContext exprCtx) {
        this.pseudoValue = assignmentValue;
        this.exprCtx = exprCtx;

        Token firstToken = exprCtx.getStart();
        this.lineNumber = firstToken.getLine();
        this.returnStmnt = "";
    }

    @Override
    public void verify() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.exprCtx);
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if (ctx instanceof ExpressionContext) {

            ExpressionContext expCtx = (ExpressionContext) ctx;

            if (Checker.isFunctionCall(exprCtx)) {

                Scope scope = ScopeCreator.getInstance().openScope();

                PseudoMethod pseudoMethod = SymbolTableManager.getInstance().getMethod(expCtx.getText());

                if (pseudoValue == null)
                    return;

                if (pseudoMethod == null)
                    return;

                if (this.pseudoValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
                    if (pseudoMethod.getReturnType() != PseudoMethod.MethodType.BOOL_TYPE) {
                        String additionalMessage = "Expected value 'BOOL'.";
                        PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                    }
                } else if (this.pseudoValue.getPrimitiveType() == PrimitiveType.INT) {
                    if (pseudoMethod.getReturnType() != PseudoMethod.MethodType.INT_TYPE) {
                        String additionalMessage = "Expected value 'INT'.";
                        PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                    }
                } else if (this.pseudoValue.getPrimitiveType() == PrimitiveType.FLOAT) {
                    if (pseudoMethod.getReturnType() != PseudoMethod.MethodType.FLOAT_TYPE) {
                        String additionalMessage = "Expected value 'FLOAT'.";
                        PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                    }
                } else if (this.pseudoValue.getPrimitiveType() == PrimitiveType.STRING) {
                    if (pseudoMethod.getReturnType() != PseudoMethod.MethodType.STRING_TYPE) {
                        String additionalMessage = "Expected value 'STRING'.";
                        PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                    }
                }

            }

        } else if (ctx instanceof LiteralContext) {
            if (this.pseudoValue == null) {
                return;
            }
            LiteralContext literalCtx = (LiteralContext) ctx;
            String expressionString = literalCtx.getText();

            if (this.pseudoValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
                if (literalCtx.BooleanLiteral() == null) {
                    String additionalMessage = "Expected value 'BOOL'"+ returnStmnt +".";
                    PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                }
            } else if (this.pseudoValue.getPrimitiveType() == PrimitiveType.INT) {
                if (literalCtx.IntegerLiteral() == null) {
                    String additionalMessage = "Expected value 'INT'"+ returnStmnt +".";
                    PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                }
            } else if (this.pseudoValue.getPrimitiveType() == PrimitiveType.FLOAT) {
                if (literalCtx.FloatingPointLiteral() == null) {
                    String additionalMessage = "Expected value 'FLOAT'"+ returnStmnt +".";
                    PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                }
            } else if (this.pseudoValue.getPrimitiveType() == PrimitiveType.STRING) {
                if (expressionString.charAt(0) != '\"' && expressionString.charAt(expressionString.length() - 1) != '\"') {
                    String additionalMessage = "Expected value 'STRING'"+ returnStmnt +".";
                    PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                } else if (literalCtx.StringLiteral() == null) {
                    String additionalMessage = "Expected value 'STRING'"+ returnStmnt +".";
                    PseudoErrorListener.reportCustomError(ErrorHandler.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                }
            }
        }

    }

    public void setReturnStmnt() {
        this.returnStmnt = " in return statement";
    }

    public void resetReturnStmnt(){
        this.returnStmnt = "";
    }

    private boolean isInteger(String text) {
        try {
            Integer.parseInt(text);

            if (text.charAt(0) != '\"' && text.charAt(text.length() - 1) != '\"' && !text.contains("."))
                return true;
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public static boolean isDecimal(String text) {
        try {
            Float.parseFloat(text);

            if (text.charAt(0) != '\"' && text.charAt(text.length() - 1) != '\"' && text.contains("."))
                return true;
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }
}