package model.ErrorChecking;

import model.Item.PseudoMethod;
import model.PseudoCodeParser.*;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.Token;

public class MultipleMethodDeclarationChecker implements IErrorChecker {

    private MethodDeclaratorContext methodDecCtx;
    private int lineNumber;

    public MultipleMethodDeclarationChecker(MethodDeclaratorContext methodDecCtx) {
        this.methodDecCtx = methodDecCtx;

        Token firstToken = methodDecCtx.getStart();
        this.lineNumber = firstToken.getLine();
    }

    @Override
    public void verify() {
        this.verifyFunctionCall(this.methodDecCtx.Identifier().getText());
    }

    private void verifyFunctionCall(String identifierString) {

//        ClassScope classScope = SymbolTableManager.getInstance().getClassScope(
//                ParserHandler.getInstance().getCurrentClassName());

        PseudoMethod parserMethod = SymbolTableManager.getInstance().getMethod(identifierString);

        if(parserMethod != null) {
            PseudoErrorListener.reportCustomError(ErrorHandler.MULTIPLE_FUNCTION, "", identifierString, this.lineNumber);
        }
    }
}