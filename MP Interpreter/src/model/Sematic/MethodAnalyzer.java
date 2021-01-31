package model.Sematic;

import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.MultipleMethodDeclarationChecker;
import model.ErrorChecking.PseudoErrorListener;
import model.Execution.ExecutionManager;
import model.Execution.MethodTracker;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
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

public class MethodAnalyzer implements ParseTreeListener {

    private MethodDeclarationContext mthd;
    private PseudoMethod pseudoMethod;

    private boolean hasReturn = false;


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

            this.pseudoMethod = pseudoMethod;
            SymbolTableManager.getInstance().addPseudoMethod(mthdName, pseudoMethod);


//        SymbolTableManager.getInstance().setParentScope(scope);
        }

    }

    public void setPseudoMethod(MethodDeclarationContext mthd){
        if(mthd.methodDeclarator().Identifier() != null){
            this.mthd = mthd;
            this.pseudoMethod = SymbolTableManager.getInstance().getMethod(mthd.methodDeclarator().Identifier().getText());
            Scope scope = ScopeCreator.getInstance().openScope();
            pseudoMethod.setParentScope(scope);
            MethodTracker.getInstance().reportEnterFunction(pseudoMethod);


            Traverse();
        }
    }

    public void Traverse(){

        ExecutionManager.getInstance().openFunctionExecution(pseudoMethod);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, mthd);
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
            FormalParameterContext paramsCtx = (FormalParameterContext) ctx;

            if (paramsCtx.Identifier() != null) {
                ParameterAnalyzer parameterAnalyzer = new ParameterAnalyzer(pseudoMethod);
                parameterAnalyzer.analyze(paramsCtx);
            }
        } else if(ctx instanceof BlockContext){
            BlockContext blockCtx = ((BlockContext) ctx);

            BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
            blockAnalyzer.analyze(blockCtx);
        } else if(ctx instanceof StatementContext && ((StatementContext) ctx).RETURN() != null){
            if(pseudoMethod.getReturnType().equals(PseudoMethod.MethodType.VOID_TYPE)){
                Token firstToken = ctx.getStart();
                int lineNumber = firstToken.getLine();
                PseudoErrorListener.reportCustomError(ErrorRepository.RETURN_IN_VOID, "", lineNumber);
            }
            if(hasReturn){
                Token firstToken = ctx.getStart();
                int lineNumber = firstToken.getLine();

                PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "Double return statement", lineNumber);
            }
            hasReturn = true;
            pseudoMethod.setValidReturns(hasReturn);
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
