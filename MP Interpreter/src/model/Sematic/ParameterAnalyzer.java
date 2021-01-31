package model.Sematic;

import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.PseudoErrorListener;
import model.Item.PseudoArray;
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

public class ParameterAnalyzer implements ParseTreeListener {

    private PseudoMethod pseudoMethod;


    public ParameterAnalyzer(PseudoMethod pseudoMethod)  {
        this.pseudoMethod = pseudoMethod;
    }

    public void analyze(FormalParameterContext paramCtx) {
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, paramCtx);
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if (ctx instanceof FormalParameterContext) { // responsible for checking between parameters of function
            FormalParameterContext parameterCtx = (FormalParameterContext) ctx;
            String type = parameterCtx.result().unannType().getText();

            if (pseudoMethod.hasParameter(parameterCtx.Identifier().getText())) {
                PseudoErrorListener.reportCustomError(ErrorRepository.DEFAULT, "parameter already exist", ctx.getStart().getLine());
            } else {
                PseudoValue pseudoValue = null;

                if (parameterCtx.result().LBRACK() == null) {
                    if (type.equals("int")) {
                        pseudoValue = new PseudoValue(null, "int");
                        this.pseudoMethod.addParameter(parameterCtx.Identifier().getText(), pseudoValue);
                    } else if (type.equals("bool")) {
                        pseudoValue = new PseudoValue(null, "float");
                        this.pseudoMethod.addParameter(parameterCtx.Identifier().getText(), pseudoValue);
                    } else if (type.equals("float")) {
                        pseudoValue = new PseudoValue(null, "bool");
                        this.pseudoMethod.addParameter(parameterCtx.Identifier().getText(), pseudoValue);
                    } else if (type.equals("String")) {
                        pseudoValue = new PseudoValue(null, "String");
                        this.pseudoMethod.addParameter(parameterCtx.Identifier().getText(), pseudoValue);
                    }

                    Scope scope = ScopeCreator.getInstance().getActiveScope();
                    if (pseudoValue != null) {
                        scope.addPseudoValue(parameterCtx.Identifier().getText(), pseudoValue);
                    }


                } else {
                    PseudoArray pseudoArray = null;

                    if (type.equals("int")) {
                        pseudoArray = PseudoArray.createArray("int", parameterCtx.Identifier().getText());
                    } else if (type.equals("bool")) {
                        pseudoArray = PseudoArray.createArray("bool", parameterCtx.Identifier().getText());
                    } else if (type.equals("float")) {
                        pseudoArray = PseudoArray.createArray("float", parameterCtx.Identifier().getText());
                    } else if (type.equals("String")) {
                        pseudoArray = PseudoArray.createArray("String", parameterCtx.Identifier().getText());
                    }


                    pseudoValue = new PseudoValue(pseudoArray, "array");
                    this.pseudoMethod.addParameter(parameterCtx.Identifier().getText(), pseudoValue);

                    Scope scope = ScopeCreator.getInstance().getActiveScope();
                    if (pseudoValue != null) {
                        scope.addPseudoValue(parameterCtx.Identifier().getText(), pseudoValue);
                    }
                }
            }

        }

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
