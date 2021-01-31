package model;

import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.PseudoErrorListener;
import model.Execution.MethodTracker;
import model.Item.PseudoMethod;
import model.Sematic.MainAnalyzer;
import model.Sematic.MethodAnalyzer;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.Token;

public class PseudoCodeCustomListener extends PseudoCodeBaseListener {

    @Override
    public void enterMainDeclaration(PseudoCodeParser.MainDeclarationContext ctx) {
        MainAnalyzer mainAnalyzer = new MainAnalyzer();
        mainAnalyzer.analyze(ctx);
    }

    @Override
    public void enterMethodDeclaration(PseudoCodeParser.MethodDeclarationContext ctx) {
        MethodAnalyzer methodAnalyzer = new MethodAnalyzer();
        methodAnalyzer.setPseudoMethod(ctx);
    }

    @Override
    public void exitMethodDeclaration(PseudoCodeParser.MethodDeclarationContext ctx) {
        if(ctx.methodDeclarator().Identifier() != null){
            PseudoMethod pseudoMethod = SymbolTableManager.getInstance().getMethod(ctx.methodDeclarator().Identifier().getText());
            if(!pseudoMethod.hasValidReturns() && !pseudoMethod.getReturnType().equals(PseudoMethod.MethodType.VOID_TYPE)){
                Token firstToken = ctx.getStart();
                int lineNumber = firstToken.getLine();
                PseudoErrorListener.reportCustomError(ErrorRepository.NO_RETURN_STATEMENT, "", ctx.methodDeclarator().Identifier().getText(), pseudoMethod.getReturnValue().getPrimitiveType(), lineNumber);
            }

            ScopeCreator.getInstance().closeScope();
//            MethodTracker.getInstance().reportEnterFunction(SymbolTableManager.getInstance().getMethod(ctx.methodDeclarator().Identifier().getText()));
        }
    }



}
