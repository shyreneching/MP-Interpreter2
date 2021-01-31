package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import model.ErrorChecking.ErrorRepository;
import model.ErrorChecking.PseudoErrorListener;
import model.Execution.ExecutionManager;
import model.Execution.MethodTracker;
import model.Item.ErrorMessage;
import model.Sematic.StatementControlOverseer;
import model.SymbolTable.Scope.Scope;
import model.SymbolTable.Scope.ScopeCreator;
import model.SymbolTable.SymbolTableManager;
import model.Utils.LocalVarTracker;
import model.notifications.NotificationListener;
import model.notifications.Notifications;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.GenericStyledArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.Paragraph;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.reactfx.collection.ListModification;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUI extends Application implements NotificationListener {
    private CodeArea codeArea;
    private TextArea output_textArea = new TextArea();

    private static final String[] KEYWORDS = new String[] {
            "abstract", "assert", "bool", "break", "byte",
            "case", "catch", "char", "class", "constant",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while",

            "up to", "down to", "func", "print", "scan", "String",
            "create", "then"
    };

    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    private static final String PAREN_PATTERN = "\\(|\\)";
    private static final String BRACE_PATTERN = "\\{|\\}";
    private static final String BRACKET_PATTERN = "\\[|\\]";
    private static final String SEMICOLON_PATTERN = "\\;";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/"   // for whole text processing (text blocks)
            + "|" + "/\\*[^\\v]*" + "|" + "^\\h*\\*([^\\v]*|/)";  // for visible paragraph processing (line by line)

    private static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<BRACE>" + BRACE_PATTERN + ")"
                    + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
                    + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    public static void launchApplication(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        UIHolder.initialize(this);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        double scene_width = width*0.5;
        double scene_height = height*0.75;
        boolean wrap = true;

        //Parent root = FXMLLoader.load(getClass().getResource("ParserUIFXML.fxml"));
        Text text1 = new Text();
        text1.setText("PseudoIDE");
        text1.setFont(Font.font("Helvetica", 24));
        text1.setFill(Color.SALMON);

        Text text2 = new Text();
        text2.setText("MP - Interpreter");
        text2.setFont(Font.font("Helvetica", 10));
        text2.setFill(Color.SALMON);

        codeArea = new CodeArea();
        codeArea.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(2), Insets.EMPTY)));
        // add line numbers to the left of area
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

        codeArea.getVisibleParagraphs().addModificationObserver
                (
                        new VisibleParagraphStyler<>( codeArea, this::computeHighlighting )
                );

        // auto-indent: insert previous line's indents on enter
        final Pattern whiteSpace = Pattern.compile( "^\\s+" );
        codeArea.addEventHandler( KeyEvent.KEY_PRESSED, KE ->
        {
            if ( KE.getCode() == KeyCode.ENTER ) {
                int caretPosition = codeArea.getCaretPosition();
                int currentParagraph = codeArea.getCurrentParagraph();
                Matcher m0 = whiteSpace.matcher( codeArea.getParagraph( currentParagraph-1 ).getSegments().get( 0 ) );
                if ( m0.find() ) Platform.runLater( () -> codeArea.insertText( caretPosition, m0.group() ) );
            }
        });

        codeArea.replaceText(0, 0, "main(){\n\n" + "}");

        VirtualizedScrollPane vsp = new VirtualizedScrollPane(codeArea);
        StackPane stack = new StackPane();
        stack.setMinHeight(360);
        stack.getChildren().add(vsp);
        stack.setStyle("-fx-padding: 20px; -fx-border-insets: 20px; -fx-background-insets: 20px;");

        Button parse_button = new Button();
        parse_button.setText("Run");
        parse_button.setPadding(new Insets(5));
        parse_button.setFont(Font.font("Helvetica", 12));
        parse_button.setStyle("-fx-background-color: salmon");
        parse_button.setTextFill(Color.WHITE);
        parse_button.setAlignment(Pos.CENTER);
        parse_button.setMinWidth(100.0);

        output_textArea = new TextArea();
        output_textArea.minHeight(200.0);
        output_textArea.setWrapText(true);
        output_textArea.setPrefColumnCount(20);
        output_textArea.setPrefRowCount(10);
        output_textArea.setPromptText("Output will appear here");
        output_textArea.setEditable(false);
        output_textArea.setFocusTraversable(false);
        output_textArea.setMouseTransparent(true);
        output_textArea.setStyle("-fx-padding: 20px;-fx-border-insets: 20px; -fx-background-insets: 20px;");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPrefHeight(600.0);
        vbox.setPrefWidth(900.0);
        vbox.setStyle("-fx-padding: 25px;-fx-border-insets: 25px;");
        vbox.getChildren().addAll(text1, text2, stack, parse_button, output_textArea);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(scene_height);
        anchorPane.setPrefWidth(scene_width);
        anchorPane.setStyle("-fx-background-color: black");
        anchorPane.getChildren().addAll(vbox);
        AnchorPane.setBottomAnchor(vbox, 0.0);
        AnchorPane.setTopAnchor(vbox, 0.0);
        AnchorPane.setLeftAnchor(vbox, 0.0);
        AnchorPane.setRightAnchor(vbox, 0.0);

        SymbolTableManager.initialize();
        PseudoErrorListener.initialize();
        ExecutionManager.initialize();
        ScopeCreator.initialize();
        StatementControlOverseer.initialize();
        MethodTracker.initialize();
        LocalVarTracker.initialize();

        parse_button.setOnMouseClicked(e -> {
            try {
                //printToOutput("I hate this");
                ExecutionManager.reset();
                ScopeCreator.reset();
                SymbolTableManager.reset();
                PseudoErrorListener.getInstance().setSuccessful(true);
                StatementControlOverseer.reset();
                ErrorRepository.reset();
                MethodTracker.reset();
                LocalVarTracker.reset();
                resetOutput();

                //printToOutput("I hate this 2");

//            CharStream input = CharStreams.fromFileName("input/test2.java");
                CharStream input = CharStreams.fromStream(new ByteArrayInputStream(codeArea.getText().getBytes(StandardCharsets.UTF_8)));
                PseudoCodeLexer lexer = new PseudoCodeLexer(input);
                PseudoCodeParser parser = new PseudoCodeParser(new CommonTokenStream(lexer));
                parser.addParseListener(new PseudoCodeBaseListener());
                lexer.removeErrorListeners();
                parser.removeErrorListeners();
                lexer.addErrorListener(ErrorListener.INSTANCE);
                parser.addErrorListener(ErrorListener.INSTANCE);
                parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
//            for (PredictionMode c : PredictionMode.values())
////                System.out.println(c);
//            parser.setErrorHandler(new ErrorRecovery());
                parser.addErrorListener(new ErrorListener());

//                parser.compilationUnit();

                ParserRuleContext parserRuleContext = parser.compilationUnit();
                ParseTreeWalker treeWalker = new ParseTreeWalker();
                treeWalker.walk(new PseudoMethodWalker(), parserRuleContext);
                treeWalker.walk(new PseudoCodeCustomListener(), parserRuleContext);

                //printToOutput("What");

                System.out.println(ErrorListener.INSTANCE.toString());

                System.out.println(PseudoErrorListener.INSTANCE.toString());

                if(PseudoErrorListener.getInstance().isSuccessful()) {
                    //System.out.println("executionList number: " + ExecutionManager.getInstance().getExecutionList().size());
                    ExecutionManager.getInstance().executeAllActions();
                    System.out.println("PseudoErrorListener executed");
                }
                else {
                    System.out.println("Fix identified errors before executing!");
                }

//            var outputname = "input/parser-output.txt";
//            OutputStream outStream = new FileOutputStream(outputname);
////            for (String l: result){
////                outStream.write(l.getBytes());
////                outStream.write("\r\n".getBytes());
////            }
//            outStream.write(ErrorListener.INSTANCE.toString().getBytes());
//            outStream.close();

                ArrayList<ErrorMessage> combinedErrorsList = new ArrayList<ErrorMessage>();

                combinedErrorsList.addAll(ErrorListener.INSTANCE.getSyntaxErrors());
                combinedErrorsList.addAll(PseudoErrorListener.getInstance().getSemanticErrors());

                combinedErrorsList.sort(Comparator.comparingInt(ErrorMessage::getLineNumber));
                //System.out.println(combinedErrorsList.size());

                if (combinedErrorsList.size() > 0){
                    String output = "";

                    for (ErrorMessage error : combinedErrorsList){
                        output = output + error.getErrorMessage() + "\n";
                    }

                    printToOutput(output);
//                    System.out.println("I printed!");
                }

                output_textArea.setMouseTransparent(false);
                ErrorListener.INSTANCE.resetErrors();
                PseudoErrorListener.getInstance().resetSemanticErrorsList();
                ErrorListener.INSTANCE.resetSyntaxErrorsList();
            } catch (IOException ex) {
                //System.out.println(ex);
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

//        parse_button.setOnMouseClicked( event -> {
//            resetOutput();
//            test();
//        });

        Group root = new Group(anchorPane);

        Scene scene = new Scene(root, scene_width, scene_height);
        scene.getStylesheets().add("/public/java-keywords.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("MO - Interpreter");
        primaryStage.show();
    }

    private StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while(matcher.find()) {
            String styleClass =
                    matcher.group("KEYWORD") != null ? "keyword" :
                            matcher.group("PAREN") != null ? "paren" :
                                    matcher.group("BRACE") != null ? "brace" :
                                            matcher.group("BRACKET") != null ? "bracket" :
                                                    matcher.group("SEMICOLON") != null ? "semicolon" :
                                                            matcher.group("STRING") != null ? "string" :
                                                                    matcher.group("COMMENT") != null ? "comment" :
                                                                            null; /* never happens */ assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }

    private class VisibleParagraphStyler<PS, SEG, S> implements Consumer<ListModification<? extends Paragraph<PS, SEG, S>>>
    {
        private final GenericStyledArea<PS, SEG, S> area;
        private final Function<String, StyleSpans<S>> computeStyles;
        private int prevParagraph, prevTextLength;

        public VisibleParagraphStyler( GenericStyledArea<PS, SEG, S> area, Function<String,StyleSpans<S>> computeStyles )
        {
            this.computeStyles = computeStyles;
            this.area = area;
        }

        @Override
        public void accept( ListModification<? extends Paragraph<PS, SEG, S>> lm )
        {
            if ( lm.getAddedSize() > 0 )
            {
                int paragraph = Math.min( area.firstVisibleParToAllParIndex() + lm.getFrom(), area.getParagraphs().size()-1 );
                String text = area.getText( paragraph, 0, paragraph, area.getParagraphLength( paragraph ) );

                if ( paragraph != prevParagraph || text.length() != prevTextLength )
                {
                    int startPos = area.getAbsolutePosition( paragraph, 0 );
                    Platform.runLater( () -> area.setStyleSpans( startPos, computeStyles.apply( text ) ) );
                    prevTextLength = text.length();
                    prevParagraph = paragraph;
                }
            }
        }
    }

    public void resetOutput(){
        output_textArea.setText("");
    }

    public void printToOutput(String output) {
        String toPrint = output;
//        System.out.println("I'm here!");
//        System.out.println("toPrint: " + toPrint);
//        output_textArea.setEditable(false);
//        output_textArea.setText(output);
        output_textArea.appendText(toPrint);

//        Platform.runLater(() -> {
//            output_textArea.setText(toPrint);
//        });

//        System.out.println("I supposedly printed!");
    }

    public void notified(String notificationString, model.notifications.Parameters params){
        if(notificationString == Notifications.ON_FOUND_SCAN_STATEMENT) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.getDialogPane();
            dialog.setTitle("Scan Dialog");
            dialog.setHeaderText(null);
            dialog.getDialogPane().getButtonTypes().remove(1);

            dialog.getEditor().setText("");
            dialog.setContentText(params.getStringExtra("MESSAGE_DISPLAY_KEY", "Input: "));
        }
    }

    public void test (){
        printToOutput("Hi");
        printToOutput("\n");
        printToOutput("Hello");
        printToOutput("\n");
    }
}