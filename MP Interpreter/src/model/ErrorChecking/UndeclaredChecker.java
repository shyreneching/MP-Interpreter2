package model.ErrorChecking;

import model.Execution.ExecutionManager;
import model.Item.PseudoMethod;
import model.Item.PseudoValue;
import model.PseudoCodeParser.*;
import model.Sematic.VariableSearcher;
import model.SymbolTable.SymbolTableManager;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.regex.Pattern;

public class UndeclaredChecker implements IErrorChecker, ParseTreeListener {

    private ParserRuleContext ctx;
    private String prevFunctionName = "";
    private int lineNumber;

    public UndeclaredChecker(ParserRuleContext ctx) {
        this.ctx = ctx;

        Token firstToken = this.ctx.getStart();
        this.lineNumber = firstToken.getLine();
    }

    @Override
    public void verify() {
        ParseTreeWalker treeWalker = new ParseTreeWalker();
        treeWalker.walk(this, this.ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof BlockContext) {
            BlockContext blkCtx = (BlockContext) ctx;
            if(Checker.isFunctionCall(blkCtx)) {
                System.out.println("FUNCTION ENTER " + ctx.getText());
                String s[] = blkCtx.getText().split("\\(");
                prevFunctionName = s[0];
                this.verifyFunctionCall(blkCtx);
            }
            else if(Checker.isVariableOrConst(blkCtx)) {
                System.out.println("VARIABLE ENTER " + ctx.getText());
                if(!prevFunctionName.equals(blkCtx.getText()))
                    this.verifyVariableOrConst(blkCtx);
            }
        } else if (ctx instanceof PrintInvocationContext){
            for(TerminalNode t: ((PrintInvocationContext) ctx).Identifier()){
                verifyVariable(t.getText());
            }

        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub

    }

    private void verifyFunctionCall(BlockContext funcExprCtx) {

        //ThisKeywordChecker thisChecker = new ThisKeywordChecker(funcExprCtx.expression(0));
        //thisChecker.verify();

//        MethodInvocationContext method = funcExprCtx.blockStatements().blockStatement(0).statement().statementWithoutTrailingSubstatement().expressionStatement().statementExpression().methodInvocation();
        MethodInvocationContext method = Checker.getFunction(funcExprCtx);
        if(method.argumentList() == null) {
            return;
        }

        String functionName = method.methodName().getText();

//        ClassScope classScope = SymbolTableManager.getInstance().getClassScope(
//                ParserHandler.getInstance().getCurrentClassName());
//        PseudoMethod PseudoMethod = classScope.searchMethod(functionName);
        PseudoMethod pseudoMethod = SymbolTableManager.getInstance().getMethod(functionName);

        if(pseudoMethod == null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_FUNCTION, "", functionName, this.lineNumber);
        }
        else {
            //Console.log(LogType.DEBUG, "Function found: " +functionName);
        }
    }

    private void verifyVariableOrConst(BlockContext varExprCtx) {
        PseudoValue pseudoValue = null;

        if(ExecutionManager.getInstance().isInFunctionExecution()) {
            PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
            pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, Checker.getIdentifier(varExprCtx));
        }

//        //if after function finding, mobi value is still null, search class
//        if(pseudoValue == null) {
//            ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
//            pseudoValue = VariableSearcher.searchVariableInClassIncludingLocal(classScope, Checker.getIdentifier(varExprCtx));
//        }

        //after second pass, we conclude if it cannot be found already
        if(pseudoValue == null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "", varExprCtx.getText(), this.lineNumber);
        }
    }

    /*
     * Verifies a var or const identifier from a scan statement since scan grammar is different.
     */
    public static void verifyVarOrConstForScan(String identifier, StatementContext statementCtx) {
        PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
//        ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
        PseudoValue pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, identifier);

        Token firstToken = statementCtx.getStart();

        if(pseudoValue == null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "", identifier, firstToken.getLine());
        }
    }

    private void verifyVariable(String identifier) {
        PseudoValue pseudoValue = null;

        if(ExecutionManager.getInstance().isInFunctionExecution()) {
            PseudoMethod pseudoMethod = ExecutionManager.getInstance().getCurrentFunction();
            pseudoValue = VariableSearcher.searchVariableInFunction(pseudoMethod, identifier);
        }

        if(pseudoValue == null) {
            PseudoErrorListener.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "", identifier, this.lineNumber);
        }
    }

}
