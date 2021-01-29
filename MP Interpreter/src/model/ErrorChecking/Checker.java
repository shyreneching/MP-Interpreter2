package model.ErrorChecking;

import jdk.nashorn.api.tree.IdentifierTree;
import model.PseudoCodeParser.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.regex.Pattern;

public class Checker {

//    private static String identifier;
//    private static String constant;
//    private static String function;

    public static boolean isFunctionCall(BlockContext blkCtx){
        Pattern functionPattern = Pattern.compile("([a-zA-Z0-9]+)\\(([ ,.a-zA-Z0-9]*)\\)");

        MethodInvocationContext m = blkCtx.blockStatements().blockStatement(0).statement().statementWithoutTrailingSubstatement().statementExpression().methodInvocation();

        if ( m != null || functionPattern.matcher( m.getText()).matches()) {
//            function = m.getText();
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFunctionCallExpression(ExpressionContext epxrCtx){
        Pattern functionPattern = Pattern.compile("([a-zA-Z0-9]+)\\(([ ,.a-zA-Z0-9]*)\\)");

        MethodInvocationContext m = epxrCtx.assignmentExpression().conditionalAndExpression().equalityExpression().relationalExpression().additiveExpression().multiplicativeExpression().unaryExpression().primary().methodInvocation();

        if ( m != null || functionPattern.matcher( m.getText()).matches()) {
//            function = m.getText();
            return true;
        } else {
            return false;
        }
    }

    public static boolean isVariableOrConst(BlockContext blkCtxx) {
        VariableDeclaratorContext p = blkCtxx.blockStatements().blockStatement(0).localVariableDeclaration().variableDeclaratorList().variableDeclarator(0);
        ParserRuleContext k = p.variableInitializer().expression().assignmentExpression().conditionalAndExpression().equalityExpression();
        k = ((EqualityExpressionContext) k).relationalExpression().additiveExpression();
        PrimaryContext c = ((AdditiveExpressionContext) k).multiplicativeExpression().unaryExpression().primary();


        if (c != null || p.Identifier() != null) {
//            identifier = p.variableDeclaratorId().Identifier().getText();
//            constant = c.getText();
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAdditiveExpression(ExpressionContext epxrCtx){


    }

    public static MethodInvocationContext getFunction(BlockContext blkCtx) {
        MethodInvocationContext m = blkCtx.blockStatements().blockStatement(0).statement().statementWithoutTrailingSubstatement().statementExpression().methodInvocation();
        return m;
    }

    public static MethodInvocationContext getFunctionExpression(ExpressionContext epxrCtx) {
        MethodInvocationContext m = epxrCtx.assignmentExpression().conditionalAndExpression().equalityExpression().relationalExpression().additiveExpression().multiplicativeExpression().unaryExpression().primary().methodInvocation();
        return m;
    }

    public static String getConstant(BlockContext blkCtx) {
        ParserRuleContext p = blkCtx.blockStatements().blockStatement(0).localVariableDeclaration().variableDeclaratorList().variableDeclarator(0);
        p = ((VariableDeclaratorContext) p).variableInitializer().expression().assignmentExpression().conditionalAndExpression();
        p = ((EqualityExpressionContext) p).relationalExpression().additiveExpression();
        return ((AdditiveExpressionContext) p).multiplicativeExpression().unaryExpression().primary().getText();
    }

    public static String getIdentifier(BlockContext blkCtx){
        return blkCtx.blockStatements().blockStatement(0).localVariableDeclaration().variableDeclaratorList().variableDeclarator(0).Identifier().getText();
    }
}
