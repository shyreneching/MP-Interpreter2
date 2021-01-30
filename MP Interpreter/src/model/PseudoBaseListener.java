package model;

import model.Sematic.MainAnalyzer;

public class PseudoBaseListener extends PseudoCodeBaseListener {

    @Override
    public void enterMainDeclaration(PseudoCodeParser.MainDeclarationContext ctx) {
        MainAnalyzer mainAnalyzer = new MainAnalyzer();
        mainAnalyzer.analyze(ctx);
    }
}
