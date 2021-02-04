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
		ASSIGN=35, DOT=36, GT=37, LT=38, BANG=39, TILDE=40, QUESTION=41, COLON=42, 
		EQUAL=43, LE=44, GE=45, NOTEQUAL=46, AND=47, OR=48, ADD=49, SUB=50, MUL=51, 
		DIV=52, BSLASH=53, BITAND=54, BITOR=55, CARET=56, MOD=57, DQUOTE=58, Identifier=59, 
		WS=60, COMMENT=61, LINE_COMMENT=62;
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
			"DecimalFloatingPointLiteral", "Sign", "FloatTypeSuffix", "BooleanLiteral", 
			"StringLiteral", "StringCharacters", "StringCharacter", "EscapeSequence", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", 
			"ASSIGN", "DOT", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", 
			"LE", "GE", "NOTEQUAL", "AND", "OR", "ADD", "SUB", "MUL", "DIV", "BSLASH", 
			"BITAND", "BITOR", "CARET", "MOD", "DQUOTE", "Identifier", "JavaLetter", 
			"JavaLetterOrDigit", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'scan'", "'func'", "'main'", "'String'", "'constant'", 
			"'create'", "'then'", "'bool'", "'break'", "'continue'", "'do'", "'else'", 
			"'float'", "'for'", "'if'", "'int'", "'return'", "'void'", "'while'", 
			"'up to'", "'down to'", null, null, null, null, "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "';'", "','", "'='", "'.'", "'>'", "'<'", "'!'", 
			"'~'", "'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", 
			"'+'", "'-'", "'*'", "'/'", "'\\'", "'&'", "'|'", "'^'", "'%'", "'\"'"
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
			"DOT", "GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", 
			"GE", "NOTEQUAL", "AND", "OR", "ADD", "SUB", "MUL", "DIV", "BSLASH", 
			"BITAND", "BITOR", "CARET", "MOD", "DQUOTE", "Identifier", "WS", "COMMENT", 
			"LINE_COMMENT"
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
		case 70:
			return JavaLetter_sempred((RuleContext)_localctx, predIndex);
		case 71:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u01da\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\5\32\u011e\n\32"+
		"\3\32\3\32\5\32\u0122\n\32\5\32\u0124\n\32\3\33\6\33\u0127\n\33\r\33\16"+
		"\33\u0128\3\34\3\34\5\34\u012d\n\34\3\35\3\35\3\36\3\36\3\37\5\37\u0134"+
		"\n\37\3\37\3\37\3\37\5\37\u0139\n\37\3\37\3\37\3\37\5\37\u013e\n\37\3"+
		"\37\3\37\3\37\3\37\5\37\u0144\n\37\3 \3 \3!\3!\3\"\3\"\3#\3#\5#\u014e"+
		"\n#\3#\3#\3$\6$\u0153\n$\r$\16$\u0154\3%\3%\5%\u0159\n%\3&\3&\3&\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\3"+
		"8\38\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3"+
		"A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\7G\u01a6\nG\fG\16G\u01a9\13G\3H"+
		"\3H\3H\3H\3H\3H\5H\u01b1\nH\3I\3I\3I\3I\3I\3I\5I\u01b9\nI\3J\6J\u01bc"+
		"\nJ\rJ\16J\u01bd\3J\3J\3K\3K\3K\3K\7K\u01c6\nK\fK\16K\u01c9\13K\3K\3K"+
		"\3K\3K\3K\3L\3L\3L\3L\7L\u01d4\nL\fL\16L\u01d7\13L\3L\3L\3\u01c7\2M\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\2\67\29\2;\32=\2?\2"+
		"A\2C\33E\34G\2I\2K\2M\35O\36Q\37S U!W\"Y#[$]%_&a\'c(e)g*i+k,m-o.q/s\60"+
		"u\61w\62y\63{\64}\65\177\66\u0081\67\u00838\u00859\u0087:\u0089;\u008b"+
		"<\u008d=\u008f\2\u0091\2\u0093>\u0095?\u0097@\3\2\17\3\2\63;\3\2//\3\2"+
		"hh\4\2HHVV\5\2$$++^^\13\2$$))++^^ddhhppttvv\6\2&&C\\aac|\4\2\2\u0081\ud802"+
		"\udc01\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17"+
		"\"\"\4\2\f\f\17\17\2\u01e0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2;\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2"+
		"\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2"+
		"\2\2\u0097\3\2\2\2\3\u0099\3\2\2\2\5\u009f\3\2\2\2\7\u00a4\3\2\2\2\t\u00a9"+
		"\3\2\2\2\13\u00ae\3\2\2\2\r\u00b5\3\2\2\2\17\u00be\3\2\2\2\21\u00c5\3"+
		"\2\2\2\23\u00ca\3\2\2\2\25\u00cf\3\2\2\2\27\u00d5\3\2\2\2\31\u00de\3\2"+
		"\2\2\33\u00e1\3\2\2\2\35\u00e6\3\2\2\2\37\u00ec\3\2\2\2!\u00f0\3\2\2\2"+
		"#\u00f3\3\2\2\2%\u00f7\3\2\2\2\'\u00fe\3\2\2\2)\u0103\3\2\2\2+\u0109\3"+
		"\2\2\2-\u010f\3\2\2\2/\u0117\3\2\2\2\61\u0119\3\2\2\2\63\u0123\3\2\2\2"+
		"\65\u0126\3\2\2\2\67\u012c\3\2\2\29\u012e\3\2\2\2;\u0130\3\2\2\2=\u0143"+
		"\3\2\2\2?\u0145\3\2\2\2A\u0147\3\2\2\2C\u0149\3\2\2\2E\u014b\3\2\2\2G"+
		"\u0152\3\2\2\2I\u0158\3\2\2\2K\u015a\3\2\2\2M\u015d\3\2\2\2O\u015f\3\2"+
		"\2\2Q\u0161\3\2\2\2S\u0163\3\2\2\2U\u0165\3\2\2\2W\u0167\3\2\2\2Y\u0169"+
		"\3\2\2\2[\u016b\3\2\2\2]\u016d\3\2\2\2_\u016f\3\2\2\2a\u0171\3\2\2\2c"+
		"\u0173\3\2\2\2e\u0175\3\2\2\2g\u0177\3\2\2\2i\u0179\3\2\2\2k\u017b\3\2"+
		"\2\2m\u017d\3\2\2\2o\u0180\3\2\2\2q\u0183\3\2\2\2s\u0186\3\2\2\2u\u0189"+
		"\3\2\2\2w\u018c\3\2\2\2y\u018f\3\2\2\2{\u0191\3\2\2\2}\u0193\3\2\2\2\177"+
		"\u0195\3\2\2\2\u0081\u0197\3\2\2\2\u0083\u0199\3\2\2\2\u0085\u019b\3\2"+
		"\2\2\u0087\u019d\3\2\2\2\u0089\u019f\3\2\2\2\u008b\u01a1\3\2\2\2\u008d"+
		"\u01a3\3\2\2\2\u008f\u01b0\3\2\2\2\u0091\u01b8\3\2\2\2\u0093\u01bb\3\2"+
		"\2\2\u0095\u01c1\3\2\2\2\u0097\u01cf\3\2\2\2\u0099\u009a\7r\2\2\u009a"+
		"\u009b\7t\2\2\u009b\u009c\7k\2\2\u009c\u009d\7p\2\2\u009d\u009e\7v\2\2"+
		"\u009e\4\3\2\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a2\7c"+
		"\2\2\u00a2\u00a3\7p\2\2\u00a3\6\3\2\2\2\u00a4\u00a5\7h\2\2\u00a5\u00a6"+
		"\7w\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8\7e\2\2\u00a8\b\3\2\2\2\u00a9\u00aa"+
		"\7o\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7p\2\2\u00ad"+
		"\n\3\2\2\2\u00ae\u00af\7U\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7t\2\2\u00b1"+
		"\u00b2\7k\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7i\2\2\u00b4\f\3\2\2\2\u00b5"+
		"\u00b6\7e\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7u\2\2"+
		"\u00b9\u00ba\7v\2\2\u00ba\u00bb\7c\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd"+
		"\7v\2\2\u00bd\16\3\2\2\2\u00be\u00bf\7e\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1"+
		"\7g\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\20\3\2\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7j\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\u00c9\7p\2\2\u00c9\22\3\2\2\2\u00ca\u00cb\7d\2\2\u00cb\u00cc\7q\2\2\u00cc"+
		"\u00cd\7q\2\2\u00cd\u00ce\7n\2\2\u00ce\24\3\2\2\2\u00cf\u00d0\7d\2\2\u00d0"+
		"\u00d1\7t\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7c\2\2\u00d3\u00d4\7m\2\2"+
		"\u00d4\26\3\2\2\2\u00d5\u00d6\7e\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7"+
		"p\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7p\2\2\u00db\u00dc"+
		"\7w\2\2\u00dc\u00dd\7g\2\2\u00dd\30\3\2\2\2\u00de\u00df\7f\2\2\u00df\u00e0"+
		"\7q\2\2\u00e0\32\3\2\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4"+
		"\7u\2\2\u00e4\u00e5\7g\2\2\u00e5\34\3\2\2\2\u00e6\u00e7\7h\2\2\u00e7\u00e8"+
		"\7n\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7v\2\2\u00eb"+
		"\36\3\2\2\2\u00ec\u00ed\7h\2\2\u00ed\u00ee\7q\2\2\u00ee\u00ef\7t\2\2\u00ef"+
		" \3\2\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7h\2\2\u00f2\"\3\2\2\2\u00f3"+
		"\u00f4\7k\2\2\u00f4\u00f5\7p\2\2\u00f5\u00f6\7v\2\2\u00f6$\3\2\2\2\u00f7"+
		"\u00f8\7t\2\2\u00f8\u00f9\7g\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7w\2\2"+
		"\u00fb\u00fc\7t\2\2\u00fc\u00fd\7p\2\2\u00fd&\3\2\2\2\u00fe\u00ff\7x\2"+
		"\2\u00ff\u0100\7q\2\2\u0100\u0101\7k\2\2\u0101\u0102\7f\2\2\u0102(\3\2"+
		"\2\2\u0103\u0104\7y\2\2\u0104\u0105\7j\2\2\u0105\u0106\7k\2\2\u0106\u0107"+
		"\7n\2\2\u0107\u0108\7g\2\2\u0108*\3\2\2\2\u0109\u010a\7w\2\2\u010a\u010b"+
		"\7r\2\2\u010b\u010c\7\"\2\2\u010c\u010d\7v\2\2\u010d\u010e\7q\2\2\u010e"+
		",\3\2\2\2\u010f\u0110\7f\2\2\u0110\u0111\7q\2\2\u0111\u0112\7y\2\2\u0112"+
		"\u0113\7p\2\2\u0113\u0114\7\"\2\2\u0114\u0115\7v\2\2\u0115\u0116\7q\2"+
		"\2\u0116.\3\2\2\2\u0117\u0118\5\61\31\2\u0118\60\3\2\2\2\u0119\u011a\5"+
		"\63\32\2\u011a\62\3\2\2\2\u011b\u0124\7\62\2\2\u011c\u011e\5? \2\u011d"+
		"\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\59"+
		"\35\2\u0120\u0122\5\65\33\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0124\3\2\2\2\u0123\u011b\3\2\2\2\u0123\u011d\3\2\2\2\u0124\64\3\2\2"+
		"\2\u0125\u0127\5\67\34\2\u0126\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\66\3\2\2\2\u012a\u012d\7\62\2"+
		"\2\u012b\u012d\59\35\2\u012c\u012a\3\2\2\2\u012c\u012b\3\2\2\2\u012d8"+
		"\3\2\2\2\u012e\u012f\t\2\2\2\u012f:\3\2\2\2\u0130\u0131\5=\37\2\u0131"+
		"<\3\2\2\2\u0132\u0134\5? \2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0136\5\65\33\2\u0136\u0138\7\60\2\2\u0137\u0139"+
		"\5\65\33\2\u0138\u0137\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\3\2\2\2"+
		"\u013a\u013b\5A!\2\u013b\u0144\3\2\2\2\u013c\u013e\5? \2\u013d\u013c\3"+
		"\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\7\60\2\2\u0140"+
		"\u0141\5\65\33\2\u0141\u0142\5A!\2\u0142\u0144\3\2\2\2\u0143\u0133\3\2"+
		"\2\2\u0143\u013d\3\2\2\2\u0144>\3\2\2\2\u0145\u0146\t\3\2\2\u0146@\3\2"+
		"\2\2\u0147\u0148\t\4\2\2\u0148B\3\2\2\2\u0149\u014a\t\5\2\2\u014aD\3\2"+
		"\2\2\u014b\u014d\5\u008bF\2\u014c\u014e\5G$\2\u014d\u014c\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\5\u008bF\2\u0150F\3\2\2"+
		"\2\u0151\u0153\5I%\2\u0152\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0154\u0155\3\2\2\2\u0155H\3\2\2\2\u0156\u0159\n\6\2\2\u0157"+
		"\u0159\5K&\2\u0158\u0156\3\2\2\2\u0158\u0157\3\2\2\2\u0159J\3\2\2\2\u015a"+
		"\u015b\7^\2\2\u015b\u015c\t\7\2\2\u015cL\3\2\2\2\u015d\u015e\7*\2\2\u015e"+
		"N\3\2\2\2\u015f\u0160\7+\2\2\u0160P\3\2\2\2\u0161\u0162\7}\2\2\u0162R"+
		"\3\2\2\2\u0163\u0164\7\177\2\2\u0164T\3\2\2\2\u0165\u0166\7]\2\2\u0166"+
		"V\3\2\2\2\u0167\u0168\7_\2\2\u0168X\3\2\2\2\u0169\u016a\7=\2\2\u016aZ"+
		"\3\2\2\2\u016b\u016c\7.\2\2\u016c\\\3\2\2\2\u016d\u016e\7?\2\2\u016e^"+
		"\3\2\2\2\u016f\u0170\7\60\2\2\u0170`\3\2\2\2\u0171\u0172\7@\2\2\u0172"+
		"b\3\2\2\2\u0173\u0174\7>\2\2\u0174d\3\2\2\2\u0175\u0176\7#\2\2\u0176f"+
		"\3\2\2\2\u0177\u0178\7\u0080\2\2\u0178h\3\2\2\2\u0179\u017a\7A\2\2\u017a"+
		"j\3\2\2\2\u017b\u017c\7<\2\2\u017cl\3\2\2\2\u017d\u017e\7?\2\2\u017e\u017f"+
		"\7?\2\2\u017fn\3\2\2\2\u0180\u0181\7>\2\2\u0181\u0182\7?\2\2\u0182p\3"+
		"\2\2\2\u0183\u0184\7@\2\2\u0184\u0185\7?\2\2\u0185r\3\2\2\2\u0186\u0187"+
		"\7#\2\2\u0187\u0188\7?\2\2\u0188t\3\2\2\2\u0189\u018a\7(\2\2\u018a\u018b"+
		"\7(\2\2\u018bv\3\2\2\2\u018c\u018d\7~\2\2\u018d\u018e\7~\2\2\u018ex\3"+
		"\2\2\2\u018f\u0190\7-\2\2\u0190z\3\2\2\2\u0191\u0192\7/\2\2\u0192|\3\2"+
		"\2\2\u0193\u0194\7,\2\2\u0194~\3\2\2\2\u0195\u0196\7\61\2\2\u0196\u0080"+
		"\3\2\2\2\u0197\u0198\7^\2\2\u0198\u0082\3\2\2\2\u0199\u019a\7(\2\2\u019a"+
		"\u0084\3\2\2\2\u019b\u019c\7~\2\2\u019c\u0086\3\2\2\2\u019d\u019e\7`\2"+
		"\2\u019e\u0088\3\2\2\2\u019f\u01a0\7\'\2\2\u01a0\u008a\3\2\2\2\u01a1\u01a2"+
		"\7$\2\2\u01a2\u008c\3\2\2\2\u01a3\u01a7\5\u008fH\2\u01a4\u01a6\5\u0091"+
		"I\2\u01a5\u01a4\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u008e\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01b1\t\b"+
		"\2\2\u01ab\u01ac\n\t\2\2\u01ac\u01b1\6H\2\2\u01ad\u01ae\t\n\2\2\u01ae"+
		"\u01af\t\13\2\2\u01af\u01b1\6H\3\2\u01b0\u01aa\3\2\2\2\u01b0\u01ab\3\2"+
		"\2\2\u01b0\u01ad\3\2\2\2\u01b1\u0090\3\2\2\2\u01b2\u01b9\t\f\2\2\u01b3"+
		"\u01b4\n\t\2\2\u01b4\u01b9\6I\4\2\u01b5\u01b6\t\n\2\2\u01b6\u01b7\t\13"+
		"\2\2\u01b7\u01b9\6I\5\2\u01b8\u01b2\3\2\2\2\u01b8\u01b3\3\2\2\2\u01b8"+
		"\u01b5\3\2\2\2\u01b9\u0092\3\2\2\2\u01ba\u01bc\t\r\2\2\u01bb\u01ba\3\2"+
		"\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01bf\u01c0\bJ\2\2\u01c0\u0094\3\2\2\2\u01c1\u01c2\7\61"+
		"\2\2\u01c2\u01c3\7,\2\2\u01c3\u01c7\3\2\2\2\u01c4\u01c6\13\2\2\2\u01c5"+
		"\u01c4\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c7\u01c5\3\2"+
		"\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c7\3\2\2\2\u01ca\u01cb\7,\2\2\u01cb"+
		"\u01cc\7\61\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\bK\2\2\u01ce\u0096\3\2"+
		"\2\2\u01cf\u01d0\7\61\2\2\u01d0\u01d1\7\61\2\2\u01d1\u01d5\3\2\2\2\u01d2"+
		"\u01d4\n\16\2\2\u01d3\u01d2\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d3\3"+
		"\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8"+
		"\u01d9\bL\2\2\u01d9\u0098\3\2\2\2\25\2\u011d\u0121\u0123\u0128\u012c\u0133"+
		"\u0138\u013d\u0143\u014d\u0154\u0158\u01a7\u01b0\u01b8\u01bd\u01c7\u01d5"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}