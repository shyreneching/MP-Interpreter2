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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressionCommand implements ICommand, ParseTreeListener {

    private boolean isNumeric, hasException = false, methodEval = false;
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
//        if(modifiedExp.equals("T")){
//            modifiedExp = "true";
//        } else if(modifiedExp.equals("F")){
//            modifiedExp = "false";
//        }

        if(modifiedExp.charAt(modifiedExp.length() - 1) == 'f'){
//            System.out.println(TypeChecker.isDecimal(modifiedExp.substring(0,modifiedExp.length()-1)));
            modifiedExp = modifiedExp.substring(0,modifiedExp.length()-1);
        }

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

        methodEval = false;
        isNumeric = !this.modifiedExp.contains("\"") && !this.modifiedExp.contains("\'");

        if (!isNumeric) {

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
                isNumeric = true;
            }else if (this.exprCtx.expression().size() != 0 && !isArrayElement(exprCtx) && !isFunctionCall(exprCtx)) {
                for (PseudoCodeParser.ExpressionContext expCtx :
                        this.exprCtx.expression()) {

                    if (!isArray(expCtx)) {

                        ExpressionCommand exprCmd = new ExpressionCommand(expCtx);
                        exprCmd.execute();

                        if (exprCmd.isNumeric())
                            this.stringResult += exprCmd.getValueResult().toEngineeringString();
                        else
                            this.stringResult += exprCmd.getStringResult();

                    }
                }

            } else {
                this.stringResult = modifiedExp.replace("\"", "");
            }

        } else {

            if (this.modifiedExp.contains("!")) {
                this.modifiedExp = this.modifiedExp.replaceAll("!", "not");
                this.modifiedExp = this.modifiedExp.replaceAll("not=", "!=");
            }

            Expression evalEx = new Expression(this.modifiedExp);
            evalEx = change(evalEx, map);
            evalEx.setVariable("T", "true");
            evalEx.setVariable("F", "false");
//            for(String s : map.keySet()){
//                evalEx.setVariable(s, map.get(s));
//            }
//            System.out.println(modifiedExp);
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
    }

    public Expression change(Expression expr, HashMap<String,String> map){
        Iterator<Expression.Token> iter = expr.getExpressionTokenizer();
        List<String> copy = new ArrayList<String>();
        while (iter.hasNext())
            copy.add(iter.next().toString());

        for(String s: copy)
            System.out.println(s);

        for(String s : map.keySet()){
            Expression temp = new Expression(s);

            Iterator<Expression.Token> iter2 = temp.getExpressionTokenizer();
            List<String> copy2 = new ArrayList<String>();
            while (iter2.hasNext())
                copy2.add(iter2.next().toString());


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

                methodEval = true;
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
        if (exprCtx.expression(0) != null && exprCtx.expression(1) != null) {
            PseudoValue value = searchValue(exprCtx.expression(0).getText());

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
                        if (expressionCommand.isNumeric())
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
//                this.modifiedExp = this.modifiedExp.replace(exprCtx.getText(),
//                        "\"" + pseudoMethod.getReturnValue().getValue().toString() + "\"");
            } else {
                if (pseudoMethod.getReturnValue() == null){
                    this.modifiedExp = " ";
                    map.put(exprCtx.getText(), "\"" + " ");
                    PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "Void function has no return value.", exprCtx.getStart().getLine());
                }
                else if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), "\"" + pseudoMethod.getReturnValue().getValue().toString());
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

            if (pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.STRING) {
                if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), "\"" + pseudoValue.getValue().toString() + "\"");
                }
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
        PseudoValue value = searchValue(exprCtx.expression(0).getText());

        if (value != null) {
            if (value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {

                PseudoArray pseudoArray = (PseudoArray) value.getValue();

                ExpressionCommand exprCmd = new ExpressionCommand(exprCtx.expression(1));
                exprCmd.execute();

                ExecutionManager.getInstance().setCurrentCheckedLineNumber(exprCtx.getStart().getLine());
                PseudoValue arrayValue = pseudoArray.getValueAt(exprCmd.getValueResult().intValue());

                if (arrayValue == null)
                    return;

                if (arrayValue.getPrimitiveType() == PseudoValue.PrimitiveType.STRING) {
                    //this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.expression(0).getText() + "\\[([a-zA-Z0-9]*)]", "\"" + arrayPseudoValue.getValue().toString() + "\"");
//                    this.modifiedExp = this.modifiedExp.replace(exprCtx.getText(), "\"" + arrayValue.getValue().toString() + "\"");

                    if(!map.containsKey(exprCtx.getText())){
                        map.put(exprCtx.getText(), "\"" + arrayValue.getValue().toString() + "\"");
                    }
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

    public boolean isNumeric() {
        return isNumeric;
    }

    public boolean isHasException() {
        return hasException;
    }
}
