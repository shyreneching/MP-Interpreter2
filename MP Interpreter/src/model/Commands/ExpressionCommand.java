package model.Commands;

import com.udojava.evalex.Expression;
import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.PseudoErrorListener;
import model.ErrorChecking.TypeChecker;
import model.Execution.ExecutionManager;
import model.Execution.MethodTracker;
import model.Item.PseudoArray;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser;
import model.Sematic.VariableSearcher;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class ExpressionCommand implements ICommand, ParseTreeListener {

    private boolean isNumeric, hasException = false, isString = false, isBool = false;
    private PseudoCodeParser.ExpressionContext exprCtx;
    private String modifiedExp, stringResult = "";
    private BigDecimal valueResult;
    private HashMap<String, String> map;

    public ExpressionCommand(PseudoCodeParser.ExpressionContext exprCtx) {
        this.exprCtx = exprCtx;
        this.map = new HashMap<>();
    }

    @Override
    public void execute() {


        this.modifiedExp = this.exprCtx.getText();

        if(modifiedExp.equals("T") || modifiedExp.equals("F"))
            isBool = true;
//        if(modifiedExp.equals("T")){
//            modifiedExp = "true";
//        } else if(modifiedExp.equals("F")){
//            modifiedExp = "false";
//        }
//            modifiedExp = modifiedExp.replaceAll("(?<=(\\d|\\.))f", "");
//        if(exprCtx.primary() != null && isFloat(exprCtx)){
////            System.out.println(TypeChecker.isDecimal(modifiedExp.substring(0,modifiedExp.length()-1)));
//            modifiedExp = modifiedExp.substring(0,modifiedExp.length()-1);
//        }

//        for (PseudoCodeParser.ExpressionContext eCtx : this.exprCtx.expression()) {
//            if (isFunctionCall(eCtx)) {
//                ExpressionCommand expressionCommand = new ExpressionCommand(eCtx);
//                expressionCommand.execute();
//
//                if(!map.containsKey(eCtx.getText())){
//                    map.put(eCtx.getText(), expressionCommand.getModifiedExp());
//                }
////                this.modifiedExp = this.modifiedExp.replace(eCtx.getText(), expressionCommand.getModifiedExp());
//
//                methodEval = false;
//            }
//        }

        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.exprCtx);

//        isNumeric = (!this.modifiedExp.contains("\"") && !this.modifiedExp.contains("\'")) || !isString;
            if(!isString && (this.modifiedExp.contains("\"") || this.modifiedExp.contains("\'")))
                isString = true;

        if (isString) {

            if (this.modifiedExp.contains("==") || this.modifiedExp.contains("!=")) {


                String[] strings = {"", ""};

                if (this.modifiedExp.contains("=="))
                    strings = this.modifiedExp.split("==");

                if (this.modifiedExp.contains("!="))
                    strings = this.modifiedExp.split("!=");

                String equalityFunction = "STREQ("+strings[0]+", " + strings[1] + ")";

                if (this.modifiedExp.contains("!="))
                    equalityFunction = "not(" + equalityFunction + ")";

                Expression e = new Expression(equalityFunction);
                e = change(e, map);

                e.addLazyFunction(e.new LazyFunction("STREQ", 2) {

                    private Expression.LazyNumber ZERO = new Expression.LazyNumber() {
                        public BigDecimal eval() {
                            return BigDecimal.ZERO;
                        }
                        public String getString() {
                            return "0";
                        }
                    };

                    private Expression.LazyNumber ONE = new Expression.LazyNumber() {
                        public BigDecimal eval() {
                            return BigDecimal.ONE;
                        }
                        public String getString() {
                            return null;
                        }
                    };

                    public Expression.LazyNumber lazyEval(List<Expression.LazyNumber> lazyParams) {
                        if (lazyParams.get(0).getString().equals(lazyParams.get(1).getString())) {
                            return ONE;
                        }
                        return ZERO;
                    }
                });

                e.setVariable("T", "true");
                e.setVariable("F", "false");
//                for(String s : map.keySet()){
//                    e.setVariable(s, map.get(s));
//                }
//                System.out.println("ExpressionCommand - modifiedExp: " + modifiedExp);

                this.valueResult = e.eval();
                isString = false;
                isBool = true;
            }else if (this.exprCtx.expression().size() != 0 && !isArrayElement(exprCtx) && !isFunctionCall(exprCtx)) {
                for (PseudoCodeParser.ExpressionContext expCtx :
                        this.exprCtx.expression()) {

                    if (!isArray(expCtx)) {

                        ExpressionCommand exprCmd = new ExpressionCommand(expCtx);
                        exprCmd.execute();

                        if (!exprCmd.isString())
                            this.stringResult += exprCmd.getValueResult().toEngineeringString();
                        else
                            this.stringResult += exprCmd.getStringResult();

                    }
                }

            } else if (isArrayElement(exprCtx) || isFunctionCall(exprCtx) || isVariableOrConst(exprCtx)){
                Expression e = new Expression(exprCtx.getText());
                e = change(e, map);

                this.stringResult = e.getOriginalExpression().replace("\"", "");
            }
            else {
                this.stringResult = modifiedExp.replace("\"", "");
            }

        } else {

            modifiedExp = modifiedExp.replaceAll("(?<=(\\d|\\.))f", "");

            if (this.modifiedExp.contains("!")) {
                this.modifiedExp = this.modifiedExp.replaceAll("!", "not");
                this.modifiedExp = this.modifiedExp.replaceAll("not=", "!=");
                isBool = true;
            }

            if (this.modifiedExp.contains("&&") || this.modifiedExp.contains("||"))
                isBool = true;

            Expression evalEx = new Expression(this.modifiedExp);
            evalEx = change(evalEx, map);
            evalEx.setVariable("T", "true");
            evalEx.setVariable("F", "false");
//            for(String s : map.keySet()){
//                evalEx.setVariable(s, map.get(s));
//            }
            System.out.println("MODIFIED EXPR " + evalEx.toString());
//
//            evalEx = change(evalEx, map);

            try {
                this.valueResult = evalEx.eval(false);
                this.stringResult = this.valueResult.toEngineeringString();
            } catch (Expression.ExpressionException ex) {
                System.out.println("ExpressionCommand - ExpressionException");
                this.valueResult = new BigDecimal(0);
                this.stringResult = "";
                this.hasException = true;
            } catch (ArithmeticException ex) {
                //StatementControlOverseer.getInstance().setCurrentCatchClause(IAttemptCommand.CatchTypeEnum.ARITHMETIC_EXCEPTION);

                ExecutionManager.getInstance().setCurrentCheckedLineNumber(this.exprCtx.getStart().getLine());
                PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "", exprCtx.getStart().getLine());

                this.valueResult = new BigDecimal(0);
                this.stringResult = "";
                this.hasException = true;
            }

        }

//        isString = false;
    }

    public Expression change(Expression expr, HashMap<String,String> map){
        Iterator<Expression.Token> iter = expr.getExpressionTokenizer();;
        List<String> copy = new ArrayList<String>();
        while (iter.hasNext()){
            Expression.Token t = iter.next();
            if(t == null)
                break;
            else
                copy.add(t.toString());
        }

        for(String s: copy)
            System.out.println(s);

        List<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list, new MyComparator());

        for(String s : list){
            Expression temp = new Expression(s);

            Iterator<Expression.Token> iter2 = temp.getExpressionTokenizer();
            List<String> copy2 = new ArrayList<String>();
            while (iter2.hasNext()){
                Expression.Token t = iter2.next();
                if(t == null)
                    break;
                else
                    copy2.add(t.toString());
            }


            copy = alter(copy, copy2, map.get(s));
        }

        String str = "";
        for(String s : copy)
            str = str + s;

        return new Expression(str);
    }

    public List<String> alter(List<String> orig, List<String> cmp, String chnge){
        List<String> arr = new ArrayList<>();
        for(int i = 0; i < orig.size(); i++){
            if(orig.get(i).equals(cmp.get(0)) && i + cmp.size() - 1 < orig.size()){
                boolean check = true;
                for(int j = 1; j < cmp.size(); j++){
                    if(!orig.get(i + j).equals(cmp.get(j)))
                        check = false;
                }
                if(check){
                    arr.add(chnge);
                    i += cmp.size() - 1;
                } else{
                    arr.add(orig.get(i));
                }
            } else {
                arr.add(orig.get(i));
            }
        }

        return arr;
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        if (parserRuleContext instanceof PseudoCodeParser.ExpressionContext) {
            PseudoCodeParser.ExpressionContext exprCtx = (PseudoCodeParser.ExpressionContext) parserRuleContext;

            if (isFunctionCall(exprCtx) && !isInMethod(exprCtx)) {
                System.out.println("ExprCmmd : THIS IS A FUNCTION CALLLLL - " + exprCtx.getText());
                this.evaluateFunctionCall(exprCtx);
            } else if (isArrayElement(exprCtx)) {
                this.evaluateArray(exprCtx);
            } else if (isVariableOrConst(exprCtx)) {
                this.evaluateVariable(exprCtx);
            }
        }

    }

    public boolean isInMethod(PseudoCodeParser.ExpressionContext exprCtx){
        if(exprCtx.getText().equals(this.exprCtx.getText()) || (exprCtx.getParent().getText().equals(this.exprCtx.getText()) &&
                !(exprCtx.getParent() instanceof PseudoCodeParser.ExpressionListContext)))
            return false;
        else if (exprCtx.getParent() instanceof PseudoCodeParser.ExpressionListContext)
            return true;
        else
            return isInMethod((PseudoCodeParser.ExpressionContext) exprCtx.getParent());
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    public static boolean isFloat(PseudoCodeParser.ExpressionContext exprCtx) {
        Pattern functionPattern = Pattern.compile("((\\d+\\.\\d*)|(\\.\\d+))f");

        if (functionPattern.matcher(exprCtx.getText()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFunctionCall(PseudoCodeParser.ExpressionContext exprCtx) {
        Pattern functionPattern = Pattern.compile("([a-zA-Z0-9]+)\\(([ ,.a-zA-Z0-9]*)\\)");

        if (exprCtx.expressionList() != null || functionPattern.matcher(exprCtx.getText()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isVariableOrConst(PseudoCodeParser.ExpressionContext exprCtx) {
        if (exprCtx.primary() != null && exprCtx.primary().Identifier() != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isArrayElement(PseudoCodeParser.ExpressionContext exprCtx) {
        if (exprCtx.LBRACK() != null) {
            PseudoValue value = searchValue(exprCtx.Identifier().getText());

            if (value != null)
                return value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY;
            else
                return false;
        } else {
            return false;
        }
    }

    public static boolean isArray(PseudoCodeParser.ExpressionContext exprCtx) {
        PseudoValue value = searchValue(exprCtx.getText());

        if (value != null) {
            return value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY && !isArrayElement(exprCtx);
        }

        return false;
    }

    public static boolean isArray(String s) {
        PseudoValue value = searchValue(s);

        if (value != null) {
            return value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY;
        }

        return false;
    }

    private void evaluateFunctionCall(PseudoCodeParser.ExpressionContext exprCtx) {

            PseudoCodeParser.ExpressionContext eCtx = exprCtx;
//        for (PseudoCodeParser.ExpressionContext eCtx : exprCtx.expression()) {

            String functionName = eCtx.Identifier().getText();
            System.out.println("ExprCmmd : MY FUNCTION NAME IS " + functionName);

            PseudoMethod pseudoMethod = SymbolTableManager.getInstance().getMethod(functionName);

            if (pseudoMethod == null) {
                return;
            }

            List<PseudoCodeParser.ExpressionContext> exprCtxList;

            if (eCtx.expressionList() != null) {
                exprCtxList = eCtx.expressionList().expression();
            } else {
//                exprCtxList = exprCtx.expressionList().expression();
                exprCtxList = new ArrayList<>();
            }

            for (int i = 0; i < exprCtxList.size(); i++) {
                PseudoCodeParser.ExpressionContext parameterExprCtx = exprCtxList.get(i);

                if (isArray(parameterExprCtx)) {
                    PseudoValue pseudoValue = searchValue(parameterExprCtx.getText());
                    pseudoMethod.mapArrayAt(pseudoValue, i, parameterExprCtx.getText());
                } else {
                    ExpressionCommand expressionCommand = new ExpressionCommand(parameterExprCtx);
                    expressionCommand.execute();

                    if (expressionCommand.getValueResult() != null || !expressionCommand.getStringResult().equals("")) {
                        if (!expressionCommand.isString())
                            pseudoMethod.mapParameterByValueAt(expressionCommand.getValueResult().toEngineeringString(), i);
                        else
                            pseudoMethod.mapParameterByValueAt(expressionCommand.getStringResult(), i);
                    }
                }
            }

            pseudoMethod.execute();

            //System.out.println(TAG + ": " + "Before modified EXP function call: " + this.modifiedExp);


            if (pseudoMethod.getReturnType() == PseudoMethod.MethodType.STRING_TYPE) {
                if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), "\"" + pseudoMethod.getReturnValue().getValue().toString() + "\"");
                }
                isString = true;
//                this.modifiedExp = this.modifiedExp.replace(exprCtx.getText(),
//                        "\"" + pseudoMethod.getReturnValue().getValue().toString() + "\"");
            } else {
                if(pseudoMethod.getReturnType() == PseudoMethod.MethodType.BOOL_TYPE)
                    isBool = true;
                if (pseudoMethod.getReturnValue() == null){
//                    this.modifiedExp = "\"\"";
                    map.put(exprCtx.getText(), "\"" + "\"\"");
//                    PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "Void function has no return value.", exprCtx.getStart().getLine());
                    isString = true;
                }
                else if(!map.containsKey(exprCtx.getText())){

//                    System.out.println("ExpressionCommand - method execution get returnValue: " + pseudoMethod.getReturnValue().getValue());
//                    map.put(exprCtx.getText(), "\"" + pseudoMethod.getReturnValue().getValue().toString());

                    map.put(exprCtx.getText(), pseudoMethod.getReturnValue().getValue().toString());

                }
//                this.modifiedExp = this.modifiedExp.replace(exprCtx.getText(),
//                        pseudoMethod.getReturnValue().getValue().toString());
            }

            //System.out.println(TAG + ": " + "After modified EXP function call: " + this.modifiedExp);

//        }
    }

    private void evaluateVariable(PseudoCodeParser.ExpressionContext exprCtx) {
        PseudoValue pseudoValue = VariableSearcher.searchVariable(exprCtx.getText());
//        System.out.println("Entering expression command " + exprCtx.getText());
//        System.out.println("Pseudo value: " + pseudoValue.getValue());
        if (pseudoValue == null || pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {
            return;
        }

        try {

            if(pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN)
                isBool = true;

            if (pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.STRING) {
                if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), "\"" + pseudoValue.getValue().toString() + "\"");
                }
                isString = true;
//                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
//                        "\"" + pseudoValue.getValue().toString() + "\"");
            } else {
                String s = pseudoValue.getValue().toString();
                if(s.equals("true") && pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN)
                    s = "T";
                else if(s.equals("false") && pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN)
                    s = "F";
                if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), s);
                }
//                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
//                        pseudoValue.getValue().toString());
            }
//            System.out.println("modified exp: " + modifiedExp);

        } catch (NullPointerException e) {
            if (pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.INT) {
                if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), "0");
                }
//                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
//                        "0");
            }else {
                if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), "null");
                }
//                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
//                        "null");
            }

        }
    }

    private void evaluateArray(PseudoCodeParser.ExpressionContext exprCtx) {
        PseudoValue value = searchValue(exprCtx.Identifier().getText());

        if (value != null) {
            if (value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {

                PseudoArray pseudoArray = (PseudoArray) value.getValue();

                ExpressionCommand exprCmd = new ExpressionCommand(exprCtx.expression(0));
                exprCmd.execute();

                ExecutionManager.getInstance().setCurrentCheckedLineNumber(exprCtx.getStart().getLine());
                PseudoValue arrayValue = pseudoArray.getValueAt(exprCmd.getValueResult().intValue());

                if (arrayValue == null)
                    return;

                if(arrayValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN)
                    isBool = true;
                if (arrayValue.getPrimitiveType() == PseudoValue.PrimitiveType.STRING) {
                    //this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.expression(0).getText() + "\\[([a-zA-Z0-9]*)]", "\"" + arrayPseudoValue.getValue().toString() + "\"");
//                    this.modifiedExp = this.modifiedExp.replace(exprCtx.getText(), "\"" + arrayValue.getValue().toString() + "\"");

                    if(!map.containsKey(exprCtx.getText())){
                        map.put(exprCtx.getText(), "\"" + arrayValue.getValue().toString() + "\"");
                    }
                    isString = true;
                } else {
                    //this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.expression(0).getText() + "\\[([a-zA-Z0-9]*)]", arrayPseudoValue.getValue().toString());
//                    this.modifiedExp = this.modifiedExp.replace(exprCtx.getText(), arrayValue.getValue().toString());

                    if(!map.containsKey(exprCtx.getText())){
                        map.put(exprCtx.getText(), arrayValue.getValue().toString());
                    }
                }

            }
        }

    }

    public static PseudoValue searchValue(String identifier) {

        PseudoValue pseudoValue = null;

        if(MethodTracker.getInstance().isInsideFunction()) {
            PseudoMethod pseudoMethod = MethodTracker.getInstance().getLatestFunction();

            if(pseudoMethod.hasParameter(identifier)) {
                pseudoValue =  pseudoMethod.getParameter(identifier);
            }
            else {
//                System.out.println("method------------->" + pseudoMethod.getMethodName());
//                System.out.println("method------------->" + pseudoMethod.getParentScope());
                pseudoValue = ScopeCreator.searchVariableInLocalIterative(identifier, pseudoMethod.getParentScope());
            }
        }

        if(pseudoValue == null) {
            pseudoValue = SymbolTableManager.getInstance().searchVariableIncludingLocal(identifier);
        }

        return pseudoValue;

    }

    public BigDecimal getValueResult() {
        return valueResult;
    }

    public String getStringResult() {
        return stringResult;
    }

    public String getModifiedExp() {
        return modifiedExp;
    }

    public boolean isString() {
        return isString;
    }

    public boolean isHasException() {
        return hasException;
    }

    public boolean isBool() {
        return isBool;
    }
}

class MyComparator implements java.util.Comparator<String> {

    private int referenceLength;

    public MyComparator() {
        super();
//        this.referenceLength = reference.length();
    }

    public int compare(String s1, String s2) {
        int dist1 = Math.abs(s1.length());
        int dist2 = Math.abs(s2.length());

        return dist2 - dist1;
    }
}
