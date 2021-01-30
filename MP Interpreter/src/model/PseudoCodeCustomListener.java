package model;

import model.Sematic.MainAnalyzer;
import model.Sematic.MethodAnalyzer;

public class PseudoCodeCustomListener extends PseudoCodeBaseListener {

    @Override
    public void enterMainDeclaration(PseudoCodeParser.MainDeclarationContext ctx) {
        MainAnalyzer mainAnalyzer = new MainAnalyzer();
        mainAnalyzer.analyze(ctx);
    }

    @Override
    public void enterMethodDeclaration(PseudoCodeParser.MethodDeclarationContext ctx) {
        MethodAnalyzer methodAnalyzer = new MethodAnalyzer();
        methodAnalyzer.analyze(ctx);
    }


}
