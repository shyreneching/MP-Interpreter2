package model.ErrorChecking;

import model.PseudoCodeParser.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.regex.Pattern;

public class Checker {

  public static boolean isFunctionCall(ExpressionContext exprCtx) {
        Pattern functionPattern = Pattern.compile("([a-zA-Z0-9]+)\\(([ ,.a-zA-Z0-9]*)\\)");

        if (exprCtx.expressionList() != null || functionPattern.matcher(exprCtx.getText()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isVariableOrConst(ExpressionContext exprCtx) {
        if (exprCtx.primary() != null && exprCtx.primary().Identifier() != null) {
            return true;
        } else {
            return false;
        }
    }

//    public static boolean isAdditiveExpression(ExpressionContext epxrCtx){
//
//
//    }
//
//    public static MethodInvocationContext getFunction(BlockContext blkCtx) {
//        MethodInvocationContext m = blkCtx.blockStatements().blockStatement(0).statement().statementWithoutTrailingSubstatement().statementExpression().methodInvocation();
//        return m;
//    }
//
//    public static MethodInvocationContext getFunctionExpression(ExpressionContext epxrCtx) {
//        MethodInvocationContext m = epxrCtx.statementExpression().
//        return m;
//    }
//
//    public static String getConstant(BlockContext blkCtx) {
//        ParserRuleContext p = blkCtx.blockStatements().blockStatement(0).localVariableDeclaration().variableDeclaratorList().variableDeclarator(0);
//        p = ((VariableDeclaratorContext) p).variableInitializer().expression().assignmentExpression().conditionalAndExpression();
//        p = ((EqualityExpressionContext) p).relationalExpression().additiveExpression();
//        return ((AdditiveExpressionContext) p).multiplicativeExpression().unaryExpression().primary().getText();
//    }
//
//    public static String getIdentifier(BlockContext blkCtx){
//        return blkCtx.blockStatements().blockStatement(0).localVariableDeclaration().variableDeclaratorList().variableDeclarator(0).Identifier().getText();
//    }
}
