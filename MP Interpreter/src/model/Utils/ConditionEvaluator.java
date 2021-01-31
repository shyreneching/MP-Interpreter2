//package model.Utils;
//
//import model.Commands.ExpressionCommand;
//import model.PseudoCodeParser.*;
//
//import java.math.BigDecimal;
//
//public class ConditionEvaluator {
//
//    public static boolean evaluateCondition(String condition) {
//
//        //catch rules if the if value has direct boolean flags
//        if(condition.contains("(true)")) {
//            return true;
//        }
//        else if(condition.contains("(false)")) {
//            return false;
//        }
//
//        if (condition.contains("!")) {
//            condition = condition.replaceAll("!", "not");
//            condition = condition.replaceAll("not=", "!=");
//        }
//
//        if (condition.contains("and")) {
//            condition = condition.replaceAll("and", "&&");
//        }
//
//        if (condition.contains("or")) {
//            condition = condition.replaceAll("or", "||");
//        }
//
//        Expression expression = new Expression(condition);
//
//        BigDecimal result = expression.eval();
//
//        //System.out.println("Evaluating: " +conditionExprCtx.getText() + " Result: " +result);
//
//        return (1 == Integer.parseInt(result.toEngineeringString()));
//    }
//
//    public static boolean evaluateCondition(ExpressionContext expressionContext) {
//
//        //catch rules if the if value has direct boolean flags
//        if(expressionContext.getText().equals("T")) {
//            return true;
//        }
//        else if(expressionContext.getText().equals("F")) {
//            return false;
//        }
//
//        ExpressionCommand expressionCommand = new ExpressionCommand(expressionContext);
//        expressionCommand.execute();
//
//        int result = expressionCommand.getValueResult().intValue();
//
//        return (result == 1);
//    }
//}