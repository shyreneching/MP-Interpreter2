package model.Commands;

import com.udojava.evalex.Expression;
import model.ErrorChecking.ErrorHandler;
import model.ErrorChecking.PseudoErrorListener;
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

    private boolean isNumeric, hasException = false, isString = false, isBool = false, evaluated = false;
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

        if(modifiedExp.equals("T") || modifiedExp.equals("F")) {
            isBool = true;
        }
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
        System.out.println("MODIFIED EXPR ORIGINALLY IS " + modifiedExp);

//        isNumeric = (!this.modifiedExp.contains("\"") && !this.modifiedExp.contains("\'")) || !isString;
            if(!evaluated && !isString && (this.modifiedExp.contains("\"") || this.modifiedExp.contains("\'")))
                isString = true;

        if (isString && !evaluated) {

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
                computeString(exprCtx);

            } else if (isArrayElement(exprCtx) || isFunctionCall(exprCtx) || isVariableOrConst(exprCtx)){
                Expression e = new Expression(exprCtx.getText());
                e = change(e, map);

                this.stringResult = e.getOriginalExpression().replace("\"", "");
            }
            else {
                this.stringResult = modifiedExp.replace("\"", "");
            }

        } else if (!evaluated){

            modifiedExp = modifiedExp.replaceAll("(?<=(\\d|\\.))f", "");

            if (this.modifiedExp.contains("!")) {
                this.modifiedExp = this.modifiedExp.replaceAll("!", "not ");
                this.modifiedExp = this.modifiedExp.replaceAll("not =", "!=");
                isBool = true;
            }

            if (this.modifiedExp.contains("&&") || this.modifiedExp.contains("||") || this.modifiedExp.contains("=") || this.modifiedExp.contains(">") || this.modifiedExp.contains("<"))
                isBool = true;

            Expression evalEx = new Expression(this.modifiedExp);
            evalEx = change(evalEx, map);
            evalEx.setVariable("T", "true");
            evalEx.setVariable("F", "false");
//            for(String s : map.keySet()){
//                evalEx.setVariable(s, map.get(s));
//            }
//
//            evalEx = change(evalEx, map);
            System.out.println("MODIFIED EXPR " + evalEx.toString());

            try {
                this.valueResult = evalEx.eval(false);
                this.stringResult = this.valueResult.toEngineeringString();
                System.out.println("LOOK HERE PLS: " + modifiedExp + " " + stringResult);
            } catch (Expression.ExpressionException ex) {
//                System.out.println("ExpressionCommand - ExpressionException");
                this.valueResult = new BigDecimal(0);
                this.stringResult = "";
                this.hasException = true;
            } catch (ArithmeticException ex) {
                //StatementControlOverseer.getInstance().setCurrentCatchClause(IAttemptCommand.CatchTypeEnum.ARITHMETIC_EXCEPTION);

                ExecutionManager.getInstance().setCurrentCheckedLineNumber(this.exprCtx.getStart().getLine());
                PseudoErrorListener.reportCustomError(ErrorHandler.DEFAULT, "", exprCtx.getStart().getLine());

                this.valueResult = new BigDecimal(0);
                this.stringResult = "";
                this.hasException = true;
            }

        }

//        isString = false;
    }

    public void computeString(PseudoCodeParser.ExpressionContext exprCtx){
        for (PseudoCodeParser.ExpressionContext expCtx :
                exprCtx.expression()) {

            if(expCtx.primary()==null && expCtx.Identifier()==null)
                computeString(expCtx);
            else {

                String s = expCtx.getText();

                if(s.equals("null"))
                    continue;

                if (expCtx.primary() != null && expCtx.primary().literal() != null && expCtx.primary().literal().StringLiteral() != null)
                    s = s.substring(1, s.length() - 1);

                    if (map.containsKey(s))
                        s = map.get(s);
                System.out.println(s);

                if(s.charAt(0)=='"' && s.charAt(s.length() - 1)=='"'){
                    s = s.substring(1, s.length() - 1);
                } else if(s.contains(".")){
                    while(s.charAt(s.length()-1) == '0' && s.charAt(s.length()-2) != '.'){
                        s = s.substring(0, s.length() - 1);
                    }
                }
                this.stringResult += s;
            }

        }
    }

    public Expression change(Expression expr, HashMap<String,String> map){
        Iterator<Expression.Token> iter = expr.getExpressionTokenizer();;
        List<String> copy = new ArrayList<String>();
        while (iter.hasNext()){
            Expression.Token t = iter.next();
            if(t == null)
                break;
            else {
                if(t.toString().equals("-u")){
                    copy.add("-");
                }
                else if(t.toString().charAt(0) == ']' && t.toString().length() > 1){
                    copy.add(t.toString().substring(0,1));
                    copy.add(t.toString().substring(1));
                } else
                    copy.add(t.toString());
            }
        }

        for(String s: copy)
            System.out.println(s);

        List<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list, new MyComparator());

        for(String s : list){
            System.out.println("WHAT AM III?? + " + s);
            Expression temp = new Expression(s);

            Iterator<Expression.Token> iter2 = temp.getExpressionTokenizer();
            List<String> copy2 = new ArrayList<String>();
            while (iter2.hasNext()){
                Expression.Token t = iter2.next();
                if(t == null)
                    break;
                else {
                    if(t.toString().equals("-u")){
                        copy2.add("-");
                    }
                    else if(t.toString().charAt(0) == ']' && t.toString().length() > 1){
                        copy2.add(t.toString().substring(0,1));
                        copy2.add(t.toString().substring(1));
                    } else
                        copy2.add(t.toString());
                }
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
        if (parserRuleContext instanceof PseudoCodeParser.ExpressionContext && !isInMethod(exprCtx)) {
            PseudoCodeParser.ExpressionContext exprCtx = (PseudoCodeParser.ExpressionContext) parserRuleContext;

            if(exprCtx.AND() != null){
                this.evaluateAND(exprCtx);
            } else if(exprCtx.OR() != null){
                this.evaluateOR(exprCtx);
            }
            else if (isFunctionCall(exprCtx)) {
                System.out.println("ExprCmmd : THIS IS A FUNCTION CALLLLL - " + exprCtx.getText());
                this.evaluateFunctionCall(exprCtx);
            } else if (isArrayElement(exprCtx)) {
                this.evaluateArray(exprCtx);
            } else if (isVariableOrConst(exprCtx)) {
                this.evaluateVariable(exprCtx);
            } else if (isParenExpr(exprCtx)){
                this.evaluateParenExpr(exprCtx);
            }
        }

    }

    public boolean isInMethod(PseudoCodeParser.ExpressionContext exprCtx){
        if(exprCtx.getText().equals(this.exprCtx.getText()) || (exprCtx.getParent().getText().equals(this.exprCtx.getText()) &&
                !(exprCtx.getParent() instanceof PseudoCodeParser.ExpressionListContext) &&
                ((PseudoCodeParser.ExpressionContext)(exprCtx.getParent())).LBRACK() == null))
            return false;
        else if (exprCtx.getParent() instanceof PseudoCodeParser.ExpressionListContext || ((PseudoCodeParser.ExpressionContext)(exprCtx.getParent())).LBRACK() != null)
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

    public static boolean isParenExpr(PseudoCodeParser.ExpressionContext exprCtx) {
        if (exprCtx.primary() != null && exprCtx.primary().expression() != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isArrayElement(PseudoCodeParser.ExpressionContext exprCtx) {
        if (exprCtx.LBRACK() != null) {
            PseudoValue value = searchValue(exprCtx.Identifier().getText());

            if (value != null) {
                System.out.println("iSARRAYELEMENT: " + exprCtx.getText() + " " + value.getValue().toString());
                return value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY;
            }
            else
                System.out.println("iSARRAYELEMENT: FAILL " + exprCtx.getText());
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
//                    PseudoErrorListener.reportCustomError(ErrorHandler.DEFAULT, "Void function has no return value.", exprCtx.getStart().getLine());
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


            if (pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.STRING) {
                if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), "\"" + pseudoValue.getValue().toString() + "\"");
                }
                isString = true;
//                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
//                        "\"" + pseudoValue.getValue().toString() + "\"");
            } else {
                if(pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN)
                    isBool = true;
                String s = pseudoValue.getValue().toString();
                System.out.println("IM EVALUATING + " + exprCtx.getText() + " " + s);
//                if(s.equals("true") && pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN)
//                    s = "T";
//                else if(s.equals("false") && pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.BOOLEAN)
//                    s = "F";
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

    private void evaluateParenExpr(PseudoCodeParser.ExpressionContext exprCtx) {
        ExpressionCommand expressionCommand = new ExpressionCommand(exprCtx.primary().expression());
        expressionCommand.execute();

        try {
            if(expressionCommand.isBool)
                this.isBool = true;
            if(expressionCommand.isString()){
                if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), "\"" + expressionCommand.getStringResult() + "\"");
                }
            } else {
                if(!map.containsKey(exprCtx.getText())){
                    map.put(exprCtx.getText(), expressionCommand.getValueResult().toEngineeringString());
                }
            }

        } catch (NullPointerException e) {
//            if (pseudoValue.getPrimitiveType() == PseudoValue.PrimitiveType.INT) {
//                if(!map.containsKey(exprCtx.getText())){
//                    map.put(exprCtx.getText(), "0");
//                }
////                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
////                        "0");
//            }else {
//                if(!map.containsKey(exprCtx.getText())){
//                    map.put(exprCtx.getText(), "null");
//                }
////                this.modifiedExp = this.modifiedExp.replaceFirst(exprCtx.getText(),
////                        "null");
//            }

        }
    }

    private void evaluateAND(PseudoCodeParser.ExpressionContext exprCtx) {
        isBool = true;
        evaluated = true;
        try {
            ExpressionCommand expressionCommand1 = new ExpressionCommand(exprCtx.expression(0));
            expressionCommand1.execute();
            String s1 = expressionCommand1.getValueResult().toEngineeringString();

            ExpressionCommand expressionCommand2 = new ExpressionCommand(exprCtx.expression(1));
            expressionCommand2.execute();
            String s2 = expressionCommand2.getValueResult().toEngineeringString();
            if(s1.equals("1") && s2.equals("1")){
                this.valueResult = new BigDecimal(1);
            } else {
                this.valueResult = new BigDecimal(0);
            }
            this.stringResult = this.valueResult.toEngineeringString();

        } catch (NullPointerException e) {
            this.valueResult = new BigDecimal(0);
            this.stringResult = this.valueResult.toEngineeringString();
        }

    }

    private void evaluateOR(PseudoCodeParser.ExpressionContext exprCtx) {
        isBool = true;
        evaluated = true;
        try {
            ExpressionCommand expressionCommand1 = new ExpressionCommand(exprCtx.expression(0));
            expressionCommand1.execute();
            String s1 = expressionCommand1.getValueResult().toEngineeringString();

            ExpressionCommand expressionCommand2 = new ExpressionCommand(exprCtx.expression(1));
            expressionCommand2.execute();
            String s2 = expressionCommand2.getValueResult().toEngineeringString();
            if(s1.equals("1") || s2.equals("1")){
                this.valueResult = new BigDecimal(1);
            } else {
                this.valueResult = new BigDecimal(0);
            }
            this.stringResult = this.valueResult.toEngineeringString();

        } catch (NullPointerException e) {
            this.valueResult = new BigDecimal(0);
            this.stringResult = this.valueResult.toEngineeringString();
        }

    }

    private void evaluateArray(PseudoCodeParser.ExpressionContext exprCtx) {
//        PseudoValue value = searchValue(exprCtx.Identifier().getText());
        PseudoValue value = VariableSearcher.searchVariable(exprCtx.Identifier().getText());

        if (value != null) {
            if (value.getPrimitiveType() == PseudoValue.PrimitiveType.ARRAY) {

                PseudoArray pseudoArray = (PseudoArray) value.getValue();

                ExpressionCommand exprCmd = new ExpressionCommand(exprCtx.expression(0));
                exprCmd.execute();

                ExecutionManager.getInstance().setCurrentCheckedLineNumber(exprCtx.getStart().getLine());
                PseudoValue arrayValue = pseudoArray.getValueAt(exprCmd.getValueResult().intValue());

                if (arrayValue == null) {
                    return;
                }

                System.out.println("MY ARRAY VALUE ISSSS " + arrayValue.getValue().toString());
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
        } else
            System.out.println("ARRAY NOT FOUUUUUND");

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
