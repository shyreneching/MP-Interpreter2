package model.Sematic;

import model.ErrorChecking.MultipleMethodDeclarationChecker;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.SymbolTable.Scope.Scope;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MethodAnalyzer implements ParseTreeListener {

    private MethodDeclarationContext mthd;
    private PseudoMethod pseudoMethod;


    public void analyze(MethodDeclarationContext mthd) {

        MultipleMethodDeclarationChecker checker = new MultipleMethodDeclarationChecker(mthd.methodDeclarator());
        checker.verify();

        String mthdName = mthd.methodDeclarator().Identifier().getText();


        PseudoMethod pseudoMethod = new PseudoMethod();
        pseudoMethod.setMethodName(mthdName);

        if(mthd.result() != null){
            UnannTypeContext type = mthd.result().unannType();


            if (type.equals(PseudoMethod.MethodType.BOOL_TYPE)){
                pseudoMethod.setReturnType(PseudoMethod.MethodType.BOOL_TYPE);
            } else if (type.equals(PseudoMethod.MethodType.INT_TYPE)){
                pseudoMethod.setReturnType(PseudoMethod.MethodType.INT_TYPE);
            } else if (type.equals(PseudoMethod.MethodType.FLOAT_TYPE)){
                pseudoMethod.setReturnType(PseudoMethod.MethodType.FLOAT_TYPE);
            } else if (type.equals(PseudoMethod.MethodType.STRING_TYPE)){
                pseudoMethod.setReturnType(PseudoMethod.MethodType.STRING_TYPE);
            }

        } else if (mthd.VOID() != null){
            pseudoMethod.setReturnType(PseudoMethod.MethodType.VOID_TYPE);
        }

        this.pseudoMethod = pseudoMethod;
        SymbolTableManager.getInstance().addPseudoMethod(mthdName, pseudoMethod);

        Scope scope = ScopeCreator.getInstance().openScope();
        SymbolTableManager.getInstance().setParentScope(scope);
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


        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
