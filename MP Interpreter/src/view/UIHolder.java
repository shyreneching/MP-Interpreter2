package view;

public class UIHolder {

    private ParserUI parserUI;
    public static UIHolder INSTANCE;

    private UIHolder(ParserUI parserUI){
        this.parserUI = parserUI;
    }

    public static void initialize(ParserUI parserUI) {
        INSTANCE = new UIHolder(parserUI);
    }

    public static UIHolder getInstance() {
        return INSTANCE;
    }

    public ParserUI getParserUI() {
        return parserUI;
    }
}
