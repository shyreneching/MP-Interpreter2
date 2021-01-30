package model;

import model.Sematic.MethodAnalyzer;

public class PseudoMethodWalker extends PseudoCodeBaseListener {

    @Override
    public void enterMethodDeclaration(PseudoCodeParser.MethodDeclarationContext ctx) {
        MethodAnalyzer methodAnalyzer = new MethodAnalyzer();
        methodAnalyzer.analyze(ctx);
    }
}
