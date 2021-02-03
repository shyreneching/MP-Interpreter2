// Generated from C:/Users/ShyreneChing/Desktop/DLSU/AY 2020-2021 Term 1/CMPILER/MP/MC02/MP-Interpreter2/MP Interpreter/src\PseudoCode.g4 by ANTLR 4.9
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
			"DecimalFloatingPointLiteral", "FloatTypeSuffix", "BooleanLiteral", "StringLiteral", 
			"StringCharacters", "StringCharacter", "EscapeSequence", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "ASSIGN", "DOT", 
			"GT", "LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", 
			"NOTEQUAL", "AND", "OR", "ADD", "SUB", "MUL", "DIV", "BSLASH", "BITAND", 
			"BITOR", "CARET", "MOD", "DQUOTE", "Identifier", "JavaLetter", "JavaLetterOrDigit", 
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
		case 69:
			return JavaLetter_sempred((RuleContext)_localctx, predIndex);
		case 70:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u01cd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u011d\n\32"+
		"\5\32\u011f\n\32\3\33\6\33\u0122\n\33\r\33\16\33\u0123\3\34\3\34\5\34"+
		"\u0128\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\5\37\u0131\n\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\5\37\u0139\n\37\3 \3 \3!\3!\3\"\3\"\5\"\u0141"+
		"\n\"\3\"\3\"\3#\6#\u0146\n#\r#\16#\u0147\3$\3$\5$\u014c\n$\3%\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60"+
		"\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\38\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3=\3=\3>\3>\3?\3"+
		"?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\7F\u0199\nF\fF\16F\u019c\13"+
		"F\3G\3G\3G\3G\3G\3G\5G\u01a4\nG\3H\3H\3H\3H\3H\3H\5H\u01ac\nH\3I\6I\u01af"+
		"\nI\rI\16I\u01b0\3I\3I\3J\3J\3J\3J\7J\u01b9\nJ\fJ\16J\u01bc\13J\3J\3J"+
		"\3J\3J\3J\3K\3K\3K\3K\7K\u01c7\nK\fK\16K\u01ca\13K\3K\3K\3\u01ba\2L\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\2\67\29\2;\32=\2?\2"+
		"A\33C\34E\2G\2I\2K\35M\36O\37Q S!U\"W#Y$[%]&_\'a(c)e*g+i,k-m.o/q\60s\61"+
		"u\62w\63y\64{\65}\66\177\67\u00818\u00839\u0085:\u0087;\u0089<\u008b="+
		"\u008d\2\u008f\2\u0091>\u0093?\u0095@\3\2\16\3\2\63;\3\2hh\4\2HHVV\4\2"+
		"$$^^\n\2$$))^^ddhhppttvv\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802"+
		"\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17"+
		"\17\2\u01d1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2;\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u"+
		"\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\3\u0097"+
		"\3\2\2\2\5\u009d\3\2\2\2\7\u00a2\3\2\2\2\t\u00a7\3\2\2\2\13\u00ac\3\2"+
		"\2\2\r\u00b3\3\2\2\2\17\u00bc\3\2\2\2\21\u00c3\3\2\2\2\23\u00c8\3\2\2"+
		"\2\25\u00cd\3\2\2\2\27\u00d3\3\2\2\2\31\u00dc\3\2\2\2\33\u00df\3\2\2\2"+
		"\35\u00e4\3\2\2\2\37\u00ea\3\2\2\2!\u00ee\3\2\2\2#\u00f1\3\2\2\2%\u00f5"+
		"\3\2\2\2\'\u00fc\3\2\2\2)\u0101\3\2\2\2+\u0107\3\2\2\2-\u010d\3\2\2\2"+
		"/\u0115\3\2\2\2\61\u0117\3\2\2\2\63\u011e\3\2\2\2\65\u0121\3\2\2\2\67"+
		"\u0127\3\2\2\29\u0129\3\2\2\2;\u012b\3\2\2\2=\u0138\3\2\2\2?\u013a\3\2"+
		"\2\2A\u013c\3\2\2\2C\u013e\3\2\2\2E\u0145\3\2\2\2G\u014b\3\2\2\2I\u014d"+
		"\3\2\2\2K\u0150\3\2\2\2M\u0152\3\2\2\2O\u0154\3\2\2\2Q\u0156\3\2\2\2S"+
		"\u0158\3\2\2\2U\u015a\3\2\2\2W\u015c\3\2\2\2Y\u015e\3\2\2\2[\u0160\3\2"+
		"\2\2]\u0162\3\2\2\2_\u0164\3\2\2\2a\u0166\3\2\2\2c\u0168\3\2\2\2e\u016a"+
		"\3\2\2\2g\u016c\3\2\2\2i\u016e\3\2\2\2k\u0170\3\2\2\2m\u0173\3\2\2\2o"+
		"\u0176\3\2\2\2q\u0179\3\2\2\2s\u017c\3\2\2\2u\u017f\3\2\2\2w\u0182\3\2"+
		"\2\2y\u0184\3\2\2\2{\u0186\3\2\2\2}\u0188\3\2\2\2\177\u018a\3\2\2\2\u0081"+
		"\u018c\3\2\2\2\u0083\u018e\3\2\2\2\u0085\u0190\3\2\2\2\u0087\u0192\3\2"+
		"\2\2\u0089\u0194\3\2\2\2\u008b\u0196\3\2\2\2\u008d\u01a3\3\2\2\2\u008f"+
		"\u01ab\3\2\2\2\u0091\u01ae\3\2\2\2\u0093\u01b4\3\2\2\2\u0095\u01c2\3\2"+
		"\2\2\u0097\u0098\7r\2\2\u0098\u0099\7t\2\2\u0099\u009a\7k\2\2\u009a\u009b"+
		"\7p\2\2\u009b\u009c\7v\2\2\u009c\4\3\2\2\2\u009d\u009e\7u\2\2\u009e\u009f"+
		"\7e\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7p\2\2\u00a1\6\3\2\2\2\u00a2\u00a3"+
		"\7h\2\2\u00a3\u00a4\7w\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7e\2\2\u00a6"+
		"\b\3\2\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7k\2\2\u00aa"+
		"\u00ab\7p\2\2\u00ab\n\3\2\2\2\u00ac\u00ad\7U\2\2\u00ad\u00ae\7v\2\2\u00ae"+
		"\u00af\7t\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7p\2\2\u00b1\u00b2\7i\2\2"+
		"\u00b2\f\3\2\2\2\u00b3\u00b4\7e\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7p"+
		"\2\2\u00b6\u00b7\7u\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba"+
		"\7p\2\2\u00ba\u00bb\7v\2\2\u00bb\16\3\2\2\2\u00bc\u00bd\7e\2\2\u00bd\u00be"+
		"\7t\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7v\2\2\u00c1"+
		"\u00c2\7g\2\2\u00c2\20\3\2\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7j\2\2\u00c5"+
		"\u00c6\7g\2\2\u00c6\u00c7\7p\2\2\u00c7\22\3\2\2\2\u00c8\u00c9\7d\2\2\u00c9"+
		"\u00ca\7q\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7n\2\2\u00cc\24\3\2\2\2\u00cd"+
		"\u00ce\7d\2\2\u00ce\u00cf\7t\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1\7c\2\2"+
		"\u00d1\u00d2\7m\2\2\u00d2\26\3\2\2\2\u00d3\u00d4\7e\2\2\u00d4\u00d5\7"+
		"q\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9"+
		"\7p\2\2\u00d9\u00da\7w\2\2\u00da\u00db\7g\2\2\u00db\30\3\2\2\2\u00dc\u00dd"+
		"\7f\2\2\u00dd\u00de\7q\2\2\u00de\32\3\2\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1"+
		"\7n\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7g\2\2\u00e3\34\3\2\2\2\u00e4\u00e5"+
		"\7h\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7c\2\2\u00e8"+
		"\u00e9\7v\2\2\u00e9\36\3\2\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7q\2\2\u00ec"+
		"\u00ed\7t\2\2\u00ed \3\2\2\2\u00ee\u00ef\7k\2\2\u00ef\u00f0\7h\2\2\u00f0"+
		"\"\3\2\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7v\2\2\u00f4"+
		"$\3\2\2\2\u00f5\u00f6\7t\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8\7v\2\2\u00f8"+
		"\u00f9\7w\2\2\u00f9\u00fa\7t\2\2\u00fa\u00fb\7p\2\2\u00fb&\3\2\2\2\u00fc"+
		"\u00fd\7x\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100\7f\2\2"+
		"\u0100(\3\2\2\2\u0101\u0102\7y\2\2\u0102\u0103\7j\2\2\u0103\u0104\7k\2"+
		"\2\u0104\u0105\7n\2\2\u0105\u0106\7g\2\2\u0106*\3\2\2\2\u0107\u0108\7"+
		"w\2\2\u0108\u0109\7r\2\2\u0109\u010a\7\"\2\2\u010a\u010b\7v\2\2\u010b"+
		"\u010c\7q\2\2\u010c,\3\2\2\2\u010d\u010e\7f\2\2\u010e\u010f\7q\2\2\u010f"+
		"\u0110\7y\2\2\u0110\u0111\7p\2\2\u0111\u0112\7\"\2\2\u0112\u0113\7v\2"+
		"\2\u0113\u0114\7q\2\2\u0114.\3\2\2\2\u0115\u0116\5\61\31\2\u0116\60\3"+
		"\2\2\2\u0117\u0118\5\63\32\2\u0118\62\3\2\2\2\u0119\u011f\7\62\2\2\u011a"+
		"\u011c\59\35\2\u011b\u011d\5\65\33\2\u011c\u011b\3\2\2\2\u011c\u011d\3"+
		"\2\2\2\u011d\u011f\3\2\2\2\u011e\u0119\3\2\2\2\u011e\u011a\3\2\2\2\u011f"+
		"\64\3\2\2\2\u0120\u0122\5\67\34\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\66\3\2\2\2\u0125\u0128"+
		"\7\62\2\2\u0126\u0128\59\35\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2"+
		"\u01288\3\2\2\2\u0129\u012a\t\2\2\2\u012a:\3\2\2\2\u012b\u012c\5=\37\2"+
		"\u012c<\3\2\2\2\u012d\u012e\5\65\33\2\u012e\u0130\7\60\2\2\u012f\u0131"+
		"\5\65\33\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2"+
		"\u0132\u0133\5? \2\u0133\u0139\3\2\2\2\u0134\u0135\7\60\2\2\u0135\u0136"+
		"\5\65\33\2\u0136\u0137\5? \2\u0137\u0139\3\2\2\2\u0138\u012d\3\2\2\2\u0138"+
		"\u0134\3\2\2\2\u0139>\3\2\2\2\u013a\u013b\t\3\2\2\u013b@\3\2\2\2\u013c"+
		"\u013d\t\4\2\2\u013dB\3\2\2\2\u013e\u0140\5\u0089E\2\u013f\u0141\5E#\2"+
		"\u0140\u013f\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143"+
		"\5\u0089E\2\u0143D\3\2\2\2\u0144\u0146\5G$\2\u0145\u0144\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148F\3\2\2\2"+
		"\u0149\u014c\n\5\2\2\u014a\u014c\5I%\2\u014b\u0149\3\2\2\2\u014b\u014a"+
		"\3\2\2\2\u014cH\3\2\2\2\u014d\u014e\7^\2\2\u014e\u014f\t\6\2\2\u014fJ"+
		"\3\2\2\2\u0150\u0151\7*\2\2\u0151L\3\2\2\2\u0152\u0153\7+\2\2\u0153N\3"+
		"\2\2\2\u0154\u0155\7}\2\2\u0155P\3\2\2\2\u0156\u0157\7\177\2\2\u0157R"+
		"\3\2\2\2\u0158\u0159\7]\2\2\u0159T\3\2\2\2\u015a\u015b\7_\2\2\u015bV\3"+
		"\2\2\2\u015c\u015d\7=\2\2\u015dX\3\2\2\2\u015e\u015f\7.\2\2\u015fZ\3\2"+
		"\2\2\u0160\u0161\7?\2\2\u0161\\\3\2\2\2\u0162\u0163\7\60\2\2\u0163^\3"+
		"\2\2\2\u0164\u0165\7@\2\2\u0165`\3\2\2\2\u0166\u0167\7>\2\2\u0167b\3\2"+
		"\2\2\u0168\u0169\7#\2\2\u0169d\3\2\2\2\u016a\u016b\7\u0080\2\2\u016bf"+
		"\3\2\2\2\u016c\u016d\7A\2\2\u016dh\3\2\2\2\u016e\u016f\7<\2\2\u016fj\3"+
		"\2\2\2\u0170\u0171\7?\2\2\u0171\u0172\7?\2\2\u0172l\3\2\2\2\u0173\u0174"+
		"\7>\2\2\u0174\u0175\7?\2\2\u0175n\3\2\2\2\u0176\u0177\7@\2\2\u0177\u0178"+
		"\7?\2\2\u0178p\3\2\2\2\u0179\u017a\7#\2\2\u017a\u017b\7?\2\2\u017br\3"+
		"\2\2\2\u017c\u017d\7(\2\2\u017d\u017e\7(\2\2\u017et\3\2\2\2\u017f\u0180"+
		"\7~\2\2\u0180\u0181\7~\2\2\u0181v\3\2\2\2\u0182\u0183\7-\2\2\u0183x\3"+
		"\2\2\2\u0184\u0185\7/\2\2\u0185z\3\2\2\2\u0186\u0187\7,\2\2\u0187|\3\2"+
		"\2\2\u0188\u0189\7\61\2\2\u0189~\3\2\2\2\u018a\u018b\7^\2\2\u018b\u0080"+
		"\3\2\2\2\u018c\u018d\7(\2\2\u018d\u0082\3\2\2\2\u018e\u018f\7~\2\2\u018f"+
		"\u0084\3\2\2\2\u0190\u0191\7`\2\2\u0191\u0086\3\2\2\2\u0192\u0193\7\'"+
		"\2\2\u0193\u0088\3\2\2\2\u0194\u0195\7$\2\2\u0195\u008a\3\2\2\2\u0196"+
		"\u019a\5\u008dG\2\u0197\u0199\5\u008fH\2\u0198\u0197\3\2\2\2\u0199\u019c"+
		"\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u008c\3\2\2\2\u019c"+
		"\u019a\3\2\2\2\u019d\u01a4\t\7\2\2\u019e\u019f\n\b\2\2\u019f\u01a4\6G"+
		"\2\2\u01a0\u01a1\t\t\2\2\u01a1\u01a2\t\n\2\2\u01a2\u01a4\6G\3\2\u01a3"+
		"\u019d\3\2\2\2\u01a3\u019e\3\2\2\2\u01a3\u01a0\3\2\2\2\u01a4\u008e\3\2"+
		"\2\2\u01a5\u01ac\t\13\2\2\u01a6\u01a7\n\b\2\2\u01a7\u01ac\6H\4\2\u01a8"+
		"\u01a9\t\t\2\2\u01a9\u01aa\t\n\2\2\u01aa\u01ac\6H\5\2\u01ab\u01a5\3\2"+
		"\2\2\u01ab\u01a6\3\2\2\2\u01ab\u01a8\3\2\2\2\u01ac\u0090\3\2\2\2\u01ad"+
		"\u01af\t\f\2\2\u01ae\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01ae\3\2"+
		"\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b3\bI\2\2\u01b3"+
		"\u0092\3\2\2\2\u01b4\u01b5\7\61\2\2\u01b5\u01b6\7,\2\2\u01b6\u01ba\3\2"+
		"\2\2\u01b7\u01b9\13\2\2\2\u01b8\u01b7\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01ba\3\2"+
		"\2\2\u01bd\u01be\7,\2\2\u01be\u01bf\7\61\2\2\u01bf\u01c0\3\2\2\2\u01c0"+
		"\u01c1\bJ\2\2\u01c1\u0094\3\2\2\2\u01c2\u01c3\7\61\2\2\u01c3\u01c4\7\61"+
		"\2\2\u01c4\u01c8\3\2\2\2\u01c5\u01c7\n\r\2\2\u01c6\u01c5\3\2\2\2\u01c7"+
		"\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01cb\3\2"+
		"\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cc\bK\2\2\u01cc\u0096\3\2\2\2\22\2\u011c"+
		"\u011e\u0123\u0127\u0130\u0138\u0140\u0147\u014b\u019a\u01a3\u01ab\u01b0"+
		"\u01ba\u01c8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}