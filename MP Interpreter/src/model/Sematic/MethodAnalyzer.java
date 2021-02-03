package model.Sematic;

import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.MultipleMethodDeclarationChecker;
import model.ErrorChecking.PseudoErrorListener;
import model.Execution.ExecutionManager;
import model.Execution.MethodTracker;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser;
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

import java.util.LinkedHashMap;

public class MethodAnalyzer implements ParseTreeListener {

    private MethodDeclarationContext mthd;
    private PseudoMethod pseudoMethod;

    private boolean hasReturn = false;
    private boolean evaluated = false;


    public void analyze(MethodDeclarationContext mthd) {

        if(mthd.methodDeclarator().Identifier() != null){
            MultipleMethodDeclarationChecker checker = new MultipleMethodDeclarationChecker(mthd.methodDeclarator());
            checker.verify();

            String mthdName = mthd.methodDeclarator().Identifier().getText();


            PseudoMethod pseudoMethod = new PseudoMethod();
            pseudoMethod.setMethodName(mthdName);
            pseudoMethod.setValidReturns(hasReturn);

            if(mthd.result() != null){
                String type = mthd.result().unannType().getText();

                if (type.equals("bool")){
                    pseudoMethod.setReturnType(PseudoMethod.MethodType.BOOL_TYPE);
                } else if (type.equals("int")){
                    pseudoMethod.setReturnType(PseudoMethod.MethodType.INT_TYPE);
                } else if (type.equals("float")){
                    pseudoMethod.setReturnType(PseudoMethod.MethodType.FLOAT_TYPE);
                } else if (type.equals("String")){
                    pseudoMethod.setReturnType(PseudoMethod.MethodType.STRING_TYPE);
                }

            } else if (mthd.VOID() != null){
                pseudoMethod.setReturnType(PseudoMethod.MethodType.VOID_TYPE);
            }
            Scope scope = ScopeCreator.getInstance().openScope();
            pseudoMethod.setParentScope(scope);

            this.pseudoMethod = pseudoMethod;
            SymbolTableManager.getInstance().addPseudoMethod(mthdName, pseudoMethod);
            addParameter(mthd);
            ScopeCreator.getInstance().closeScope();
//        SymbolTableManager.getInstance().setParentScope(scope);
        }

    }

    public void setPseudoMethod(MethodDeclarationContext mthd){
        if(mthd.methodDeclarator().Identifier() != null){

            this.mthd = mthd;
            this.pseudoMethod = SymbolTableManager.getInstance().getMethod(mthd.methodDeclarator().Identifier().getText());
            MethodTracker.getInstance().reportEnterFunction(pseudoMethod);
            Scope scope = ScopeCreator.getInstance().openScope();
            pseudoMethod.setParentScope(scope);

//            LinkedHashMap<String, PseudoValue> mthdParams =pseudoMethod.getParameterValues();
//            for (String i : mthdParams.keySet()){
//                scope.addPseudoValue(i, mthdParams.get(i));
//            }


            Traverse();
        }
    }

    public void Traverse(){

        ExecutionManager.getInstance().openFunctionExecution(pseudoMethod);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, mthd);

        evaluated = false;
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if (ctx instanceof FormalParameterContext) { // check the params

        } else if(ctx instanceof BlockContext && !evaluated){
            BlockContext blockCtx = ((BlockContext) ctx);

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            blockAnalyzer.analyze(blockCtx);
            evaluated = true;
        } else if(ctx instanceof StatementContext && ((StatementContext) ctx).RETURN() != null){
            if(pseudoMethod.getReturnType().equals(PseudoMethod.MethodType.VOID_TYPE) && ((StatementContext) ctx).expression()!= null){
                Token firstToken = ctx.getStart();
                int lineNumber = firstToken.getLine();
                PseudoErrorListener.reportCustomError(ErrorRepository.RETURN_IN_VOID, "", lineNumber);
            }

            hasReturn = !isInMethod(ctx);
            if(hasReturn && pseudoMethod.hasValidReturns()){
                Token firstToken = ctx.getStart();
                int lineNumber = firstToken.getLine();

                PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "Double return statement. ", lineNumber);
            }
            System.out.println("Method Analyzer - hasReturn:" + hasReturn);
            pseudoMethod.setValidReturns(hasReturn || pseudoMethod.hasValidReturns());
        }
    }

    public boolean isInMethod(ParserRuleContext exprCtx){
        System.out.println("Method Analyzer - expression:" + exprCtx.getParent().getText());
        if (exprCtx.getParent() instanceof BlockContext || exprCtx.getParent() instanceof BlockStatementContext)
            return isInMethod(exprCtx.getParent());
        else if(exprCtx.getParent().getText().equals(mthd.getText()))
            return false;
        else
            return true;
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    public void addParameter(MethodDeclarationContext method) {
        FormalParametersContext parameterlist =  method.methodDeclarator().formalParameters();

        if (parameterlist != null && parameterlist.formalParameter() != null){
            for(FormalParameterContext paramsCtx: parameterlist.formalParameter()){
                System.out.println("Should be adding parameter");
                if (paramsCtx.Identifier() != null) {
                    ParameterAnalyzer parameterAnalyzer = new ParameterAnalyzer(pseudoMethod);
                    parameterAnalyzer.analyze(paramsCtx);
                }

            }
        }
    }
}
