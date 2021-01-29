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

import java.util.regex.Pattern;

public class TypeChecker implements IErrorChecker, ParseTreeListener {

    private PseudoValue pseudoValue;
    private ParserRuleContext prCtx;
    private int lineNumber;

//    public TypeChecker(PseudoValue assignmentValue, BlockContext blkCtx) {
//        this.pseudoValue = assignmentValue;
//        this.blkCtx = blkCtx;
//
//        Token firstToken = blkCtx.getStart();
//        this.lineNumber = firstToken.getLine();
//    }

    public TypeChecker(PseudoValue assignmentValue, ParserRuleContext prCtx) {
        this.pseudoValue = assignmentValue;
        this.prCtx = prCtx;

        Token firstToken = prCtx.getStart();
        this.lineNumber = firstToken.getLine();
    }

    @Override
    public void verify() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.prCtx);
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
        if(ctx instanceof BlockContext) {
//            ExpressionContext expCtx = (ExpressionContext) ctx;
            BlockContext blkCtx = (BlockContext) ctx;
            if (Checker.isFunctionCall(blkCtx)){

                Scope scope = ScopeCreator.getInstance().openScope();
//                ClassScope classScope = SymbolTableManager.getInstance().getClassScope(
//                        ParserHandler.getInstance().getCurrentClassName());
//                PseudoMethod pseudoMethod = scope.searchMethod(blkCtx.getText());
                PseudoMethod pseudoMethod = SymbolTableManager.getInstance().getMethod(blkCtx.getText());

                if(pseudoValue == null)
                    return;

                if(pseudoMethod == null)
                    return;

                if(this.pseudoValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
                    if(pseudoMethod.getReturnType() != PseudoMethod.MethodType.BOOL_TYPE) {
                        String additionalMessage = "Expected boolean.";
                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
                else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.INT) {
                    if(pseudoMethod.getReturnType() != PseudoMethod.MethodType.INT_TYPE) {
                        String additionalMessage = "Expected int.";
                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
                else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.FLOAT) {
                    if(pseudoMethod.getReturnType() != PseudoMethod.MethodType.FLOAT_TYPE) {
                        String additionalMessage = "Expected floating point or double.";
                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
                else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.STRING) {
                    if (pseudoMethod.getReturnType() != PseudoMethod.MethodType.STRING_TYPE) {
                        String additionalMessage = "Expected string.";
                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                    }
                }

            }
            /*else {
                EvaluationCommand evaluationCommand = new EvaluationCommand(expCtx);
                evaluationCommand.execute();
                if(this.pseudoValue.getPrimitiveType() == PrimitiveType.BOOL) {
                    if(!evaluationCommand.getModifiedExp().equals("true") && !evaluationCommand.getStringResult().equals("false")) {
                        String additionalMessage = "Expected boolean.";
                        BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
                else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.INT) {
                    if(!this.isInteger(evaluationCommand.getModifiedExp())) {
                        String additionalMessage = "Expected int.";
                        BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
                else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.DECIMAL) {
                    if(!this.isDecimal(evaluationCommand.getModifiedExp())) {
                        String additionalMessage = "Expected floating point or double.";
                        BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
                else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.STRING) {
                    if(evaluationCommand.isNumericResult()){
                        String additionalMessage = "Expected string.";
                        BuildChecker.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
            }*/

        } else if(ctx instanceof LiteralContext) {
            if(this.pseudoValue == null) {
                return;
            }
            LiteralContext literalCtx = (LiteralContext) ctx;
            String expressionString = literalCtx.getText();

            if(this.pseudoValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
                if(literalCtx.BooleanLiteral() == null) {
                    String additionalMessage = "Expected boolean.";
                    PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                }
            }
            else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.INT) {
                if(literalCtx.IntegerLiteral() == null) {
                    String additionalMessage = "Expected int.";
                    PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                }
            }
            else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.FLOAT) {
                if(literalCtx.FloatingPointLiteral() == null) {
                    String additionalMessage = "Expected floating point or double.";
                    PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                }
            }
            else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.STRING) {
                if(expressionString.charAt(0) != '\"' && expressionString.charAt(expressionString.length() - 1) != '\"') {
                    String additionalMessage = "Expected string.";
                    PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                }

                else if(literalCtx.StringLiteral() == null) {
                    String additionalMessage = "Expected string.";
                    PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                }
            }
        }
        else if(ctx instanceof ExpressionContext) {
            ExpressionContext exprCtx = (ExpressionContext) ctx;
            if (Checker.isFunctionCallExpression(exprCtx)){
                PseudoMethod pseudoMethod = SymbolTableManager.getInstance().getMethod(Checker.getFunctionExpression(exprCtx).Identifier().getText());
                if(pseudoValue == null)
                    return;

                if(pseudoMethod == null)
                    return;

                if(this.pseudoValue.getPrimitiveType() == PrimitiveType.BOOLEAN) {
                    if(pseudoMethod.getReturnType() != PseudoMethod.MethodType.BOOL_TYPE) {
                        String additionalMessage = "Expected boolean.";
                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
                else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.INT) {
                    if(pseudoMethod.getReturnType() != PseudoMethod.MethodType.INT_TYPE) {
                        String additionalMessage = "Expected int.";
                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
                else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.FLOAT) {
                    if(pseudoMethod.getReturnType() != PseudoMethod.MethodType.FLOAT_TYPE) {
                        String additionalMessage = "Expected floating point or double.";
                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH,  additionalMessage, this.lineNumber);
                    }
                }
                else if(this.pseudoValue.getPrimitiveType() == PrimitiveType.STRING) {
                    if (pseudoMethod.getReturnType() != PseudoMethod.MethodType.STRING_TYPE) {
                        String additionalMessage = "Expected string.";
                        PseudoErrorListener.reportCustomError(ErrorRepository.TYPE_MISMATCH, additionalMessage, this.lineNumber);
                    }
                }
            }
        }

    }

    private boolean isInteger(String text) {
        try{
            Integer.parseInt(text);

            if(text.charAt(0) != '\"' && text.charAt(text.length() - 1) != '\"' && !text.contains("."))
                return true;
        }
        catch (Exception e) {
            return false;
        }

        return false;
    }

    private boolean isDecimal(String text) {
        try {
            Float.parseFloat(text);

            if(text.charAt(0) != '\"' && text.charAt(text.length() - 1) != '\"' && text.contains("."))
                return true;
        }
        catch(Exception e) {
            return false;
        }

        return false;
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }



}