import javafx.stage.Stage;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import view.ParserUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
//    public static void main(String[] args) {
//        try {
//            CharStream input = CharStreams.fromFileName("input/test2.java");
//            PseudoCodeLexer lexer = new PseudoCodeLexer(input);
//            PseudoCodeParser parser = new PseudoCodeParser(new CommonTokenStream(lexer));
//            parser.addParseListener(new PseudoCodeBaseListener());
//            lexer.removeErrorListeners();
//            parser.removeErrorListeners();
//            lexer.addErrorListener(ErrorListener.INSTANCE);
//            parser.addErrorListener(ErrorListener.INSTANCE);
//            parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
////            for (PredictionMode c : PredictionMode.values())
//////                System.out.println(c);
////            parser.setErrorHandler(new ErrorRecovery());
////            parser.addErrorListener(new ErrorListener());
//
//            parser.compilationUnit();
//            System.out.println(ErrorListener.INSTANCE.toString());
//            var outputname = "input/parser-output.txt";
//            OutputStream outStream = new FileOutputStream(outputname);
////            for (String l: result){
////                outStream.write(l.getBytes());
////                outStream.write("\r\n".getBytes());
////            }
//            outStream.write(ErrorListener.INSTANCE.toString().getBytes());
//            outStream.close();
//
//        } catch (IOException ex) {
//            //System.out.println(ex);
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public static void main(String[] args) {
        ParserUI.launchApplication(args);
    }
}
