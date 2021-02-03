// Generated from C:/Users/erwin/Desktop/CMPILER/MP-Interpreter2/MP Interpreter/src\PseudoCode.g4 by ANTLR 4.9
package model;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PseudoCodeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRINT=1, SCAN=2, FUNC=3, MAIN=4, STRING=5, CONSTANT=6, CREATE=7, THEN=8, 
		BOOL=9, BREAK=10, CONTINUE=11, DO=12, ELSE=13, FLOAT=14, FOR=15, IF=16, 
		INT=17, RETURN=18, VOID=19, WHILE=20, UPTO=21, DOWNTO=22, IntegerLiteral=23, 
		FloatingPointLiteral=24, BooleanLiteral=25, StringLiteral=26, LPAREN=27, 
		RPAREN=28, LBRACE=29, RBRACE=30, LBRACK=31, RBRACK=32, SEMI=33, COMMA=34, 
		ASSIGN=35, GT=36, LT=37, BANG=38, TILDE=39, QUESTION=40, COLON=41, EQUAL=42, 
		LE=43, GE=44, NOTEQUAL=45, AND=46, OR=47, ADD=48, SUB=49, MUL=50, DIV=51, 
		BSLASH=52, BITAND=53, BITOR=54, CARET=55, MOD=56, DQUOTE=57, Identifier=58, 
		WS=59, COMMENT=60, LINE_COMMENT=61;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PRINT", "SCAN", "FUNC", "MAIN", "STRING", "CONSTANT", "CREATE", "THEN", 
			"BOOL", "BREAK", "CONTINUE", "DO", "ELSE", "FLOAT", "FOR", "IF", "INT", 
			"RETURN", "VOID", "WHILE", "UPTO", "DOWNTO", "IntegerLiteral", "DecimalIntegerLiteral", 
			"DecimalNumeral", "Digits", "Digit", "NonZeroDigit", "FloatingPointLiteral", 
			"DecimalFloatingPointLiteral", "FloatTypeSuffix", "BooleanLiteral", "StringLiteral", 
			"StringCharacters", "StringCharacter", "EscapeSequence", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "ASSIGN", "GT", 
			"LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", 
			"AND", "OR", "ADD", "SUB", "MUL", "DIV", "BSLASH", "BITAND", "BITOR", 
			"CARET", "MOD", "DQUOTE", "Identifier", "JavaLetter", "JavaLetterOrDigit", 
			"WS", "COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'scan'", "'func'", "'main'", "'String'", "'constant'", 
			"'create'", "'then'", "'bool'", "'break'", "'continue'", "'do'", "'else'", 
			"'float'", "'for'", "'if'", "'int'", "'return'", "'void'", "'while'", 
			"'up to'", "'down to'", null, null, null, null, "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "';'", "','", "'='", "'>'", "'<'", "'!'", "'~'", 
			"'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'+'", 
			"'-'", "'*'", "'/'", "'\\'", "'&'", "'|'", "'^'", "'%'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PRINT", "SCAN", "FUNC", "MAIN", "STRING", "CONSTANT", "CREATE", 
			"THEN", "BOOL", "BREAK", "CONTINUE", "DO", "ELSE", "FLOAT", "FOR", "IF", 
			"INT", "RETURN", "VOID", "WHILE", "UPTO", "DOWNTO", "IntegerLiteral", 
			"FloatingPointLiteral", "BooleanLiteral", "StringLiteral", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "ASSIGN", 
			"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", 
			"NOTEQUAL", "AND", "OR", "ADD", "SUB", "MUL", "DIV", "BSLASH", "BITAND", 
			"BITOR", "CARET", "MOD", "DQUOTE", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public PseudoCodeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PseudoCode.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 68:
			return JavaLetter_sempred((RuleContext)_localctx, predIndex);
		case 69:
			return JavaLetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean JavaLetter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return Character.isJavaIdentifierStart(_input.LA(-1));
		case 1:
			return Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}
	private boolean JavaLetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return Character.isJavaIdentifierPart(_input.LA(-1));
		case 3:
			return Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u01c9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u011b\n\32\5\32"+
		"\u011d\n\32\3\33\6\33\u0120\n\33\r\33\16\33\u0121\3\34\3\34\5\34\u0126"+
		"\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\5\37\u012f\n\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\5\37\u0137\n\37\3 \3 \3!\3!\3\"\3\"\5\"\u013f\n\"\3\""+
		"\3\"\3#\6#\u0144\n#\r#\16#\u0145\3$\3$\5$\u014a\n$\3%\3%\3%\3&\3&\3\'"+
		"\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3"+
		"\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\38\38\38\39\39\39\3:\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3"+
		"@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\7E\u0195\nE\fE\16E\u0198\13E\3F\3F\3F"+
		"\3F\3F\3F\5F\u01a0\nF\3G\3G\3G\3G\3G\3G\5G\u01a8\nG\3H\6H\u01ab\nH\rH"+
		"\16H\u01ac\3H\3H\3I\3I\3I\3I\7I\u01b5\nI\fI\16I\u01b8\13I\3I\3I\3I\3I"+
		"\3I\3J\3J\3J\3J\7J\u01c3\nJ\fJ\16J\u01c6\13J\3J\3J\3\u01b6\2K\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\2\67\29\2;\32=\2?\2A\33C\34"+
		"E\2G\2I\2K\35M\36O\37Q S!U\"W#Y$[%]&_\'a(c)e*g+i,k-m.o/q\60s\61u\62w\63"+
		"y\64{\65}\66\177\67\u00818\u00839\u0085:\u0087;\u0089<\u008b\2\u008d\2"+
		"\u008f=\u0091>\u0093?\3\2\16\3\2\63;\3\2hh\4\2HHVV\4\2$$^^\n\2$$))^^d"+
		"dhhppttvv\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802\udc01\3\2\udc02"+
		"\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\2\u01cd\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2;\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2"+
		"\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008f\3\2\2"+
		"\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\3\u0095\3\2\2\2\5\u009b\3\2\2\2\7\u00a0"+
		"\3\2\2\2\t\u00a5\3\2\2\2\13\u00aa\3\2\2\2\r\u00b1\3\2\2\2\17\u00ba\3\2"+
		"\2\2\21\u00c1\3\2\2\2\23\u00c6\3\2\2\2\25\u00cb\3\2\2\2\27\u00d1\3\2\2"+
		"\2\31\u00da\3\2\2\2\33\u00dd\3\2\2\2\35\u00e2\3\2\2\2\37\u00e8\3\2\2\2"+
		"!\u00ec\3\2\2\2#\u00ef\3\2\2\2%\u00f3\3\2\2\2\'\u00fa\3\2\2\2)\u00ff\3"+
		"\2\2\2+\u0105\3\2\2\2-\u010b\3\2\2\2/\u0113\3\2\2\2\61\u0115\3\2\2\2\63"+
		"\u011c\3\2\2\2\65\u011f\3\2\2\2\67\u0125\3\2\2\29\u0127\3\2\2\2;\u0129"+
		"\3\2\2\2=\u0136\3\2\2\2?\u0138\3\2\2\2A\u013a\3\2\2\2C\u013c\3\2\2\2E"+
		"\u0143\3\2\2\2G\u0149\3\2\2\2I\u014b\3\2\2\2K\u014e\3\2\2\2M\u0150\3\2"+
		"\2\2O\u0152\3\2\2\2Q\u0154\3\2\2\2S\u0156\3\2\2\2U\u0158\3\2\2\2W\u015a"+
		"\3\2\2\2Y\u015c\3\2\2\2[\u015e\3\2\2\2]\u0160\3\2\2\2_\u0162\3\2\2\2a"+
		"\u0164\3\2\2\2c\u0166\3\2\2\2e\u0168\3\2\2\2g\u016a\3\2\2\2i\u016c\3\2"+
		"\2\2k\u016f\3\2\2\2m\u0172\3\2\2\2o\u0175\3\2\2\2q\u0178\3\2\2\2s\u017b"+
		"\3\2\2\2u\u017e\3\2\2\2w\u0180\3\2\2\2y\u0182\3\2\2\2{\u0184\3\2\2\2}"+
		"\u0186\3\2\2\2\177\u0188\3\2\2\2\u0081\u018a\3\2\2\2\u0083\u018c\3\2\2"+
		"\2\u0085\u018e\3\2\2\2\u0087\u0190\3\2\2\2\u0089\u0192\3\2\2\2\u008b\u019f"+
		"\3\2\2\2\u008d\u01a7\3\2\2\2\u008f\u01aa\3\2\2\2\u0091\u01b0\3\2\2\2\u0093"+
		"\u01be\3\2\2\2\u0095\u0096\7r\2\2\u0096\u0097\7t\2\2\u0097\u0098\7k\2"+
		"\2\u0098\u0099\7p\2\2\u0099\u009a\7v\2\2\u009a\4\3\2\2\2\u009b\u009c\7"+
		"u\2\2\u009c\u009d\7e\2\2\u009d\u009e\7c\2\2\u009e\u009f\7p\2\2\u009f\6"+
		"\3\2\2\2\u00a0\u00a1\7h\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7p\2\2\u00a3"+
		"\u00a4\7e\2\2\u00a4\b\3\2\2\2\u00a5\u00a6\7o\2\2\u00a6\u00a7\7c\2\2\u00a7"+
		"\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9\n\3\2\2\2\u00aa\u00ab\7U\2\2\u00ab"+
		"\u00ac\7v\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7p\2\2"+
		"\u00af\u00b0\7i\2\2\u00b0\f\3\2\2\2\u00b1\u00b2\7e\2\2\u00b2\u00b3\7q"+
		"\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7"+
		"\7c\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7v\2\2\u00b9\16\3\2\2\2\u00ba\u00bb"+
		"\7e\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7c\2\2\u00be"+
		"\u00bf\7v\2\2\u00bf\u00c0\7g\2\2\u00c0\20\3\2\2\2\u00c1\u00c2\7v\2\2\u00c2"+
		"\u00c3\7j\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7p\2\2\u00c5\22\3\2\2\2\u00c6"+
		"\u00c7\7d\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7n\2\2"+
		"\u00ca\24\3\2\2\2\u00cb\u00cc\7d\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7"+
		"g\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7m\2\2\u00d0\26\3\2\2\2\u00d1\u00d2"+
		"\7e\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7v\2\2\u00d5"+
		"\u00d6\7k\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7w\2\2\u00d8\u00d9\7g\2\2"+
		"\u00d9\30\3\2\2\2\u00da\u00db\7f\2\2\u00db\u00dc\7q\2\2\u00dc\32\3\2\2"+
		"\2\u00dd\u00de\7g\2\2\u00de\u00df\7n\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1"+
		"\7g\2\2\u00e1\34\3\2\2\2\u00e2\u00e3\7h\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5"+
		"\7q\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7\7v\2\2\u00e7\36\3\2\2\2\u00e8\u00e9"+
		"\7h\2\2\u00e9\u00ea\7q\2\2\u00ea\u00eb\7t\2\2\u00eb \3\2\2\2\u00ec\u00ed"+
		"\7k\2\2\u00ed\u00ee\7h\2\2\u00ee\"\3\2\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1"+
		"\7p\2\2\u00f1\u00f2\7v\2\2\u00f2$\3\2\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5"+
		"\7g\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8\7t\2\2\u00f8"+
		"\u00f9\7p\2\2\u00f9&\3\2\2\2\u00fa\u00fb\7x\2\2\u00fb\u00fc\7q\2\2\u00fc"+
		"\u00fd\7k\2\2\u00fd\u00fe\7f\2\2\u00fe(\3\2\2\2\u00ff\u0100\7y\2\2\u0100"+
		"\u0101\7j\2\2\u0101\u0102\7k\2\2\u0102\u0103\7n\2\2\u0103\u0104\7g\2\2"+
		"\u0104*\3\2\2\2\u0105\u0106\7w\2\2\u0106\u0107\7r\2\2\u0107\u0108\7\""+
		"\2\2\u0108\u0109\7v\2\2\u0109\u010a\7q\2\2\u010a,\3\2\2\2\u010b\u010c"+
		"\7f\2\2\u010c\u010d\7q\2\2\u010d\u010e\7y\2\2\u010e\u010f\7p\2\2\u010f"+
		"\u0110\7\"\2\2\u0110\u0111\7v\2\2\u0111\u0112\7q\2\2\u0112.\3\2\2\2\u0113"+
		"\u0114\5\61\31\2\u0114\60\3\2\2\2\u0115\u0116\5\63\32\2\u0116\62\3\2\2"+
		"\2\u0117\u011d\7\62\2\2\u0118\u011a\59\35\2\u0119\u011b\5\65\33\2\u011a"+
		"\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u0117\3\2"+
		"\2\2\u011c\u0118\3\2\2\2\u011d\64\3\2\2\2\u011e\u0120\5\67\34\2\u011f"+
		"\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\66\3\2\2\2\u0123\u0126\7\62\2\2\u0124\u0126\59\35\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0124\3\2\2\2\u01268\3\2\2\2\u0127\u0128\t\2\2\2\u0128"+
		":\3\2\2\2\u0129\u012a\5=\37\2\u012a<\3\2\2\2\u012b\u012c\5\65\33\2\u012c"+
		"\u012e\7\60\2\2\u012d\u012f\5\65\33\2\u012e\u012d\3\2\2\2\u012e\u012f"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\5? \2\u0131\u0137\3\2\2\2\u0132"+
		"\u0133\7\60\2\2\u0133\u0134\5\65\33\2\u0134\u0135\5? \2\u0135\u0137\3"+
		"\2\2\2\u0136\u012b\3\2\2\2\u0136\u0132\3\2\2\2\u0137>\3\2\2\2\u0138\u0139"+
		"\t\3\2\2\u0139@\3\2\2\2\u013a\u013b\t\4\2\2\u013bB\3\2\2\2\u013c\u013e"+
		"\5\u0087D\2\u013d\u013f\5E#\2\u013e\u013d\3\2\2\2\u013e\u013f\3\2\2\2"+
		"\u013f\u0140\3\2\2\2\u0140\u0141\5\u0087D\2\u0141D\3\2\2\2\u0142\u0144"+
		"\5G$\2\u0143\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0143\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146F\3\2\2\2\u0147\u014a\n\5\2\2\u0148\u014a\5I%\2\u0149"+
		"\u0147\3\2\2\2\u0149\u0148\3\2\2\2\u014aH\3\2\2\2\u014b\u014c\7^\2\2\u014c"+
		"\u014d\t\6\2\2\u014dJ\3\2\2\2\u014e\u014f\7*\2\2\u014fL\3\2\2\2\u0150"+
		"\u0151\7+\2\2\u0151N\3\2\2\2\u0152\u0153\7}\2\2\u0153P\3\2\2\2\u0154\u0155"+
		"\7\177\2\2\u0155R\3\2\2\2\u0156\u0157\7]\2\2\u0157T\3\2\2\2\u0158\u0159"+
		"\7_\2\2\u0159V\3\2\2\2\u015a\u015b\7=\2\2\u015bX\3\2\2\2\u015c\u015d\7"+
		".\2\2\u015dZ\3\2\2\2\u015e\u015f\7?\2\2\u015f\\\3\2\2\2\u0160\u0161\7"+
		"@\2\2\u0161^\3\2\2\2\u0162\u0163\7>\2\2\u0163`\3\2\2\2\u0164\u0165\7#"+
		"\2\2\u0165b\3\2\2\2\u0166\u0167\7\u0080\2\2\u0167d\3\2\2\2\u0168\u0169"+
		"\7A\2\2\u0169f\3\2\2\2\u016a\u016b\7<\2\2\u016bh\3\2\2\2\u016c\u016d\7"+
		"?\2\2\u016d\u016e\7?\2\2\u016ej\3\2\2\2\u016f\u0170\7>\2\2\u0170\u0171"+
		"\7?\2\2\u0171l\3\2\2\2\u0172\u0173\7@\2\2\u0173\u0174\7?\2\2\u0174n\3"+
		"\2\2\2\u0175\u0176\7#\2\2\u0176\u0177\7?\2\2\u0177p\3\2\2\2\u0178\u0179"+
		"\7(\2\2\u0179\u017a\7(\2\2\u017ar\3\2\2\2\u017b\u017c\7~\2\2\u017c\u017d"+
		"\7~\2\2\u017dt\3\2\2\2\u017e\u017f\7-\2\2\u017fv\3\2\2\2\u0180\u0181\7"+
		"/\2\2\u0181x\3\2\2\2\u0182\u0183\7,\2\2\u0183z\3\2\2\2\u0184\u0185\7\61"+
		"\2\2\u0185|\3\2\2\2\u0186\u0187\7^\2\2\u0187~\3\2\2\2\u0188\u0189\7(\2"+
		"\2\u0189\u0080\3\2\2\2\u018a\u018b\7~\2\2\u018b\u0082\3\2\2\2\u018c\u018d"+
		"\7`\2\2\u018d\u0084\3\2\2\2\u018e\u018f\7\'\2\2\u018f\u0086\3\2\2\2\u0190"+
		"\u0191\7$\2\2\u0191\u0088\3\2\2\2\u0192\u0196\5\u008bF\2\u0193\u0195\5"+
		"\u008dG\2\u0194\u0193\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2"+
		"\u0196\u0197\3\2\2\2\u0197\u008a\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u01a0"+
		"\t\7\2\2\u019a\u019b\n\b\2\2\u019b\u01a0\6F\2\2\u019c\u019d\t\t\2\2\u019d"+
		"\u019e\t\n\2\2\u019e\u01a0\6F\3\2\u019f\u0199\3\2\2\2\u019f\u019a\3\2"+
		"\2\2\u019f\u019c\3\2\2\2\u01a0\u008c\3\2\2\2\u01a1\u01a8\t\13\2\2\u01a2"+
		"\u01a3\n\b\2\2\u01a3\u01a8\6G\4\2\u01a4\u01a5\t\t\2\2\u01a5\u01a6\t\n"+
		"\2\2\u01a6\u01a8\6G\5\2\u01a7\u01a1\3\2\2\2\u01a7\u01a2\3\2\2\2\u01a7"+
		"\u01a4\3\2\2\2\u01a8\u008e\3\2\2\2\u01a9\u01ab\t\f\2\2\u01aa\u01a9\3\2"+
		"\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01af\bH\2\2\u01af\u0090\3\2\2\2\u01b0\u01b1\7\61"+
		"\2\2\u01b1\u01b2\7,\2\2\u01b2\u01b6\3\2\2\2\u01b3\u01b5\13\2\2\2\u01b4"+
		"\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b6\u01b4\3\2"+
		"\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01ba\7,\2\2\u01ba"+
		"\u01bb\7\61\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\bI\2\2\u01bd\u0092\3\2"+
		"\2\2\u01be\u01bf\7\61\2\2\u01bf\u01c0\7\61\2\2\u01c0\u01c4\3\2\2\2\u01c1"+
		"\u01c3\n\r\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2"+
		"\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7"+
		"\u01c8\bJ\2\2\u01c8\u0094\3\2\2\2\22\2\u011a\u011c\u0121\u0125\u012e\u0136"+
		"\u013e\u0145\u0149\u0196\u019f\u01a7\u01ac\u01b6\u01c4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}