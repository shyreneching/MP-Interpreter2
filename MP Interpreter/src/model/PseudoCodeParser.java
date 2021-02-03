// Generated from C:/Users/ShyreneChing/Desktop/DLSU/AY 2020-2021 Term 1/CMPILER/MP/MC02/MP-Interpreter2/MP Interpreter/src\PseudoCode.g4 by ANTLR 4.9
package model;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PseudoCodeParser extends Parser {
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
	public static final int
		RULE_compilationUnit = 0, RULE_variableModifier = 1, RULE_mainDeclaration = 2, 
		RULE_methodDeclaration = 3, RULE_methodDeclarator = 4, RULE_variableDeclaratorList = 5, 
		RULE_variableDeclarator = 6, RULE_variableInitializer = 7, RULE_arrayInitializer = 8, 
		RULE_result = 9, RULE_unannType = 10, RULE_formalParameters = 11, RULE_formalParameter = 12, 
		RULE_literal = 13, RULE_block = 14, RULE_blockStatement = 15, RULE_localVariableDeclarationStatement = 16, 
		RULE_localVariableDeclaration = 17, RULE_statement = 18, RULE_forStatement = 19, 
		RULE_forheader = 20, RULE_forinitializer = 21, RULE_customAssignError = 22, 
		RULE_doStatement = 23, RULE_whileStatement = 24, RULE_ifThenStatement = 25, 
		RULE_printInvocation = 26, RULE_scanInvocation = 27, RULE_expressionList = 28, 
		RULE_statementExpression = 29, RULE_methodInvocation = 30, RULE_conditionalExpression = 31, 
		RULE_assignment = 32, RULE_expression = 33, RULE_unaryExpression = 34, 
		RULE_primary = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "variableModifier", "mainDeclaration", "methodDeclaration", 
			"methodDeclarator", "variableDeclaratorList", "variableDeclarator", "variableInitializer", 
			"arrayInitializer", "result", "unannType", "formalParameters", "formalParameter", 
			"literal", "block", "blockStatement", "localVariableDeclarationStatement", 
			"localVariableDeclaration", "statement", "forStatement", "forheader", 
			"forinitializer", "customAssignError", "doStatement", "whileStatement", 
			"ifThenStatement", "printInvocation", "scanInvocation", "expressionList", 
			"statementExpression", "methodInvocation", "conditionalExpression", "assignment", 
			"expression", "unaryExpression", "primary"
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

	@Override
	public String getGrammarFileName() { return "PseudoCode.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PseudoCodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public MainDeclarationContext mainDeclaration() {
			return getRuleContext(MainDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PseudoCodeParser.EOF, 0); }
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(72);
				methodDeclaration();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			mainDeclaration();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(79);
				methodDeclaration();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifierContext extends ParserRuleContext {
		public TerminalNode CONSTANT() { return getToken(PseudoCodeParser.CONSTANT, 0); }
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitVariableModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitVariableModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variableModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(CONSTANT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainDeclarationContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(PseudoCodeParser.MAIN, 0); }
		public TerminalNode LPAREN() { return getToken(PseudoCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PseudoCodeParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterMainDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitMainDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitMainDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainDeclarationContext mainDeclaration() throws RecognitionException {
		MainDeclarationContext _localctx = new MainDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mainDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(MAIN);
			setState(90);
			match(LPAREN);
			setState(91);
			match(RPAREN);
			setState(92);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(PseudoCodeParser.FUNC, 0); }
		public MethodDeclaratorContext methodDeclarator() {
			return getRuleContext(MethodDeclaratorContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TerminalNode VOID() { return getToken(PseudoCodeParser.VOID, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_methodDeclaration);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(FUNC);
				setState(97);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case BOOL:
				case FLOAT:
				case INT:
					{
					setState(95);
					result();
					}
					break;
				case VOID:
					{
					setState(96);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(99);
				methodDeclarator();
				setState(100);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(FUNC);
				setState(103);
				methodDeclarator();
				setState(104);
				block();
				notifyErrorListeners("lacking return type");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				match(FUNC);
				setState(110);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case BOOL:
				case FLOAT:
				case INT:
					{
					setState(108);
					result();
					}
					break;
				case VOID:
					{
					setState(109);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(112);
				methodDeclarator();
				notifyErrorListeners("lacking function body");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(115);
				match(FUNC);
				setState(118);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case BOOL:
				case FLOAT:
				case INT:
					{
					setState(116);
					result();
					}
					break;
				case VOID:
					{
					setState(117);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(120);
				block();
				notifyErrorListeners("can't find function name");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(PseudoCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PseudoCodeParser.RPAREN, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterMethodDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitMethodDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitMethodDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclaratorContext methodDeclarator() throws RecognitionException {
		MethodDeclaratorContext _localctx = new MethodDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDeclarator);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(Identifier);
				setState(126);
				match(LPAREN);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT) | (1L << COMMA) | (1L << Identifier))) != 0)) {
					{
					setState(127);
					formalParameters(0);
					}
				}

				setState(130);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(LPAREN);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT) | (1L << COMMA) | (1L << Identifier))) != 0)) {
					{
					setState(132);
					formalParameters(0);
					}
				}

				setState(135);
				match(RPAREN);
				notifyErrorListeners("can't find function name");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(Identifier);
				setState(138);
				match(LPAREN);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT) | (1L << COMMA) | (1L << Identifier))) != 0)) {
					{
					setState(139);
					formalParameters(0);
					}
				}

				notifyErrorListeners("uneven parenthesis, lacking ')'");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(Identifier);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT) | (1L << COMMA) | (1L << Identifier))) != 0)) {
					{
					setState(144);
					formalParameters(0);
					}
				}

				setState(147);
				match(RPAREN);
				notifyErrorListeners("uneven parenthesis, lacking '('");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorListContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PseudoCodeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PseudoCodeParser.COMMA, i);
		}
		public VariableDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterVariableDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitVariableDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitVariableDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorListContext variableDeclaratorList() throws RecognitionException {
		VariableDeclaratorListContext _localctx = new VariableDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			variableDeclarator();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(152);
				match(COMMA);
				setState(153);
				variableDeclarator();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(PseudoCodeParser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitVariableDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitVariableDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableDeclarator);
		int _la;
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(Identifier);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(160);
					match(ASSIGN);
					setState(161);
					variableInitializer();
					}
				}

				}
				break;
			case STRING:
			case BOOL:
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				unannType();
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(165);
					match(ASSIGN);
					setState(166);
					variableInitializer();
					}
				}

				notifyErrorListeners("declaring keyword as variable name");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerContext extends ParserRuleContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitVariableInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitVariableInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableInitializer);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				arrayInitializer();
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case StringLiteral:
			case LPAREN:
			case RPAREN:
			case BANG:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(PseudoCodeParser.CREATE, 0); }
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(PseudoCodeParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(PseudoCodeParser.RBRACK, 0); }
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(CREATE);
			setState(178);
			unannType();
			setState(179);
			match(LBRACK);
			setState(180);
			expression(0);
			setState(181);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(PseudoCodeParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(PseudoCodeParser.RBRACK, 0); }
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_result);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			unannType();
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(184);
				match(LBRACK);
				setState(185);
				match(RBRACK);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnannTypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(PseudoCodeParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(PseudoCodeParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(PseudoCodeParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(PseudoCodeParser.STRING, 0); }
		public UnannTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterUnannType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitUnannType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitUnannType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannTypeContext unannType() throws RecognitionException {
		UnannTypeContext _localctx = new UnannTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unannType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PseudoCodeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PseudoCodeParser.COMMA, i);
		}
		public List<FormalParametersContext> formalParameters() {
			return getRuleContexts(FormalParametersContext.class);
		}
		public FormalParametersContext formalParameters(int i) {
			return getRuleContext(FormalParametersContext.class,i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		return formalParameters(0);
	}

	private FormalParametersContext formalParameters(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, _parentState);
		FormalParametersContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_formalParameters, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(191);
				formalParameter();
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(192);
						match(COMMA);
						setState(193);
						formalParameter();
						}
						} 
					}
					setState(198);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(207);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(199);
					formalParameter();
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(200);
						match(COMMA);
						setState(201);
						formalParameter();
						}
						}
						setState(206);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(209);
				formalParameter();
				setState(210);
				formalParameters(4);
				notifyErrorListeners("no separator found in parameters");
				}
				break;
			case 3:
				{
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(213);
						match(COMMA);
						}
						} 
					}
					setState(218);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(219);
				match(COMMA);
				setState(220);
				formalParameters(3);
				notifyErrorListeners("lacking parameter");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(246);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new FormalParametersContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formalParameters);
						setState(225);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(226);
						match(COMMA);
						setState(227);
						match(COMMA);
						setState(231);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(228);
								match(COMMA);
								}
								} 
							}
							setState(233);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
						}
						setState(234);
						formalParameters(2);
						notifyErrorListeners("lacking parameter");
						}
						break;
					case 2:
						{
						_localctx = new FormalParametersContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formalParameters);
						setState(237);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(238);
						match(COMMA);
						setState(242);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(239);
								match(COMMA);
								}
								} 
							}
							setState(244);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
						}
						notifyErrorListeners("lacking parameter");
						}
						break;
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_formalParameter);
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				result();
				setState(252);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(Identifier);
				notifyErrorListeners("no specified data type");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				result();
				notifyErrorListeners("no parameter name");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public List<TerminalNode> IntegerLiteral() { return getTokens(PseudoCodeParser.IntegerLiteral); }
		public TerminalNode IntegerLiteral(int i) {
			return getToken(PseudoCodeParser.IntegerLiteral, i);
		}
		public TerminalNode DOT() { return getToken(PseudoCodeParser.DOT, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(PseudoCodeParser.FloatingPointLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(PseudoCodeParser.StringLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(PseudoCodeParser.BooleanLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_literal);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				match(IntegerLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				match(IntegerLiteral);
				setState(263);
				match(DOT);
				setState(264);
				match(IntegerLiteral);
				notifyErrorListeners("invalid format for 'FLOAT', must have 'f' at the end");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(266);
				match(FloatingPointLiteral);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(267);
				match(StringLiteral);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(268);
				match(BooleanLiteral);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PseudoCodeParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PseudoCodeParser.RBRACE, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			int _alt;
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				match(LBRACE);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << SCAN) | (1L << STRING) | (1L << CONSTANT) | (1L << BOOL) | (1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << LPAREN) | (1L << RPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << Identifier))) != 0)) {
					{
					{
					setState(272);
					blockStatement();
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(278);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(LBRACE);
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(280);
						blockStatement();
						}
						} 
					}
					setState(285);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				notifyErrorListeners("no closing curly brace '}' found");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_blockStatement);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				localVariableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(291);
				expression(0);
				notifyErrorListeners("invalid statement");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PseudoCodeParser.SEMI, 0); }
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitLocalVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_localVariableDeclarationStatement);
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				localVariableDeclaration();
				setState(297);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				localVariableDeclaration();
				notifyErrorListeners("lacking ';' at the end of line");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public VariableModifierContext variableModifier() {
			return getRuleContext(VariableModifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_localVariableDeclaration);
		int _la;
		try {
			setState(315);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case CONSTANT:
			case BOOL:
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONSTANT) {
					{
					setState(304);
					variableModifier();
					}
				}

				setState(307);
				result();
				setState(308);
				variableDeclaratorList();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				match(Identifier);
				setState(311);
				result();
				setState(312);
				variableDeclaratorList();
				notifyErrorListeners("identifier found before data type in the declaration");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfThenStatementContext ifThenStatement() {
			return getRuleContext(IfThenStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoStatementContext doStatement() {
			return getRuleContext(DoStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PseudoCodeParser.SEMI, 0); }
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public PrintInvocationContext printInvocation() {
			return getRuleContext(PrintInvocationContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(PseudoCodeParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(PseudoCodeParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(PseudoCodeParser.CONTINUE, 0); }
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public ScanInvocationContext scanInvocation() {
			return getRuleContext(ScanInvocationContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public List<TerminalNode> ADD() { return getTokens(PseudoCodeParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(PseudoCodeParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(PseudoCodeParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(PseudoCodeParser.SUB, i);
		}
		public List<TerminalNode> MUL() { return getTokens(PseudoCodeParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(PseudoCodeParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(PseudoCodeParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(PseudoCodeParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(PseudoCodeParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(PseudoCodeParser.MOD, i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statement);
		int _la;
		try {
			setState(365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				ifThenStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				whileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(320);
				doStatement();
				setState(321);
				match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(323);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(324);
				printInvocation();
				setState(325);
				match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(327);
				printInvocation();
				notifyErrorListeners("lacking ';' at the end of line");
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(330);
				match(RETURN);
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << LPAREN) | (1L << RPAREN) | (1L << BANG) | (1L << Identifier))) != 0)) {
					{
					setState(331);
					expression(0);
					}
				}

				setState(334);
				match(SEMI);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(335);
				match(RETURN);
				setState(336);
				result();
				setState(337);
				match(SEMI);
				notifyErrorListeners("cannot return data type");
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(340);
				match(BREAK);
				setState(341);
				match(SEMI);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(342);
				match(CONTINUE);
				setState(343);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(344);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(345);
				statementExpression();
				setState(346);
				match(SEMI);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(348);
				statementExpression();
				notifyErrorListeners("lacking ';' at the end of line");
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(351);
				scanInvocation();
				setState(352);
				match(SEMI);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(354);
				scanInvocation();
				notifyErrorListeners("lacking ';' at the end of line");
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(357);
				match(Identifier);
				setState(358);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(360); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(359);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(362); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0) );
				notifyErrorListeners("redundant arithmetic operator symbol found");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public ForheaderContext forheader() {
			return getRuleContext(ForheaderContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			forheader();
			setState(368);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForheaderContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(PseudoCodeParser.FOR, 0); }
		public ForinitializerContext forinitializer() {
			return getRuleContext(ForinitializerContext.class,0);
		}
		public TerminalNode UPTO() { return getToken(PseudoCodeParser.UPTO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOWNTO() { return getToken(PseudoCodeParser.DOWNTO, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(PseudoCodeParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(PseudoCodeParser.StringLiteral, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(PseudoCodeParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PseudoCodeParser.Identifier, i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(PseudoCodeParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(PseudoCodeParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(PseudoCodeParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(PseudoCodeParser.RBRACK, i);
		}
		public ForheaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forheader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterForheader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitForheader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitForheader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForheaderContext forheader() throws RecognitionException {
		ForheaderContext _localctx = new ForheaderContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_forheader);
		int _la;
		try {
			int _alt;
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				match(FOR);
				setState(371);
				forinitializer();
				setState(372);
				match(UPTO);
				setState(373);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(375);
				match(FOR);
				setState(376);
				forinitializer();
				setState(377);
				match(DOWNTO);
				setState(378);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
				match(FOR);
				setState(381);
				forinitializer();
				setState(390); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(390);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case StringLiteral:
							{
							setState(382);
							match(StringLiteral);
							}
							break;
						case Identifier:
							{
							setState(383);
							match(Identifier);
							setState(388);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LBRACK) {
								{
								setState(384);
								match(LBRACK);
								setState(385);
								expression(0);
								setState(386);
								match(RBRACK);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(392); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(394);
				expression(0);
				notifyErrorListeners("wrong syntax for 'for loop' should contain 'up to' or 'down to' keyword");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForinitializerContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public CustomAssignErrorContext customAssignError() {
			return getRuleContext(CustomAssignErrorContext.class,0);
		}
		public TerminalNode INT() { return getToken(PseudoCodeParser.INT, 0); }
		public TerminalNode LBRACK() { return getToken(PseudoCodeParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(PseudoCodeParser.RBRACK, 0); }
		public ForinitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forinitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterForinitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitForinitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitForinitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForinitializerContext forinitializer() throws RecognitionException {
		ForinitializerContext _localctx = new ForinitializerContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forinitializer);
		int _la;
		try {
			setState(417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INT) {
					{
					setState(399);
					match(INT);
					}
				}

				setState(402);
				match(Identifier);
				setState(403);
				customAssignError();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				match(Identifier);
				setState(405);
				match(LBRACK);
				setState(406);
				expression(0);
				setState(407);
				match(RBRACK);
				setState(408);
				customAssignError();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(410);
				match(Identifier);
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(411);
					match(LBRACK);
					setState(412);
					expression(0);
					setState(413);
					match(RBRACK);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CustomAssignErrorContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(PseudoCodeParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CustomAssignErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customAssignError; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterCustomAssignError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitCustomAssignError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitCustomAssignError(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CustomAssignErrorContext customAssignError() throws RecognitionException {
		CustomAssignErrorContext _localctx = new CustomAssignErrorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_customAssignError);
		try {
			setState(422);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				match(ASSIGN);
				setState(420);
				expression(0);
				}
				break;
			case UPTO:
			case DOWNTO:
			case StringLiteral:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				notifyErrorListeners("did not find assignment operator");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoStatementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(PseudoCodeParser.DO, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(PseudoCodeParser.WHILE, 0); }
		public List<TerminalNode> Identifier() { return getTokens(PseudoCodeParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PseudoCodeParser.Identifier, i);
		}
		public TerminalNode UPTO() { return getToken(PseudoCodeParser.UPTO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(PseudoCodeParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(PseudoCodeParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(PseudoCodeParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(PseudoCodeParser.RBRACK, i);
		}
		public TerminalNode DOWNTO() { return getToken(PseudoCodeParser.DOWNTO, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(PseudoCodeParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(PseudoCodeParser.StringLiteral, i);
		}
		public DoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterDoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitDoStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitDoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoStatementContext doStatement() throws RecognitionException {
		DoStatementContext _localctx = new DoStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_doStatement);
		int _la;
		try {
			int _alt;
			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				match(DO);
				setState(425);
				block();
				setState(426);
				match(WHILE);
				setState(427);
				match(Identifier);
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(428);
					match(LBRACK);
					setState(429);
					expression(0);
					setState(430);
					match(RBRACK);
					}
				}

				setState(434);
				match(UPTO);
				setState(435);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				match(DO);
				setState(438);
				block();
				setState(439);
				match(WHILE);
				setState(440);
				match(Identifier);
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(441);
					match(LBRACK);
					setState(442);
					expression(0);
					setState(443);
					match(RBRACK);
					}
				}

				setState(447);
				match(DOWNTO);
				setState(448);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				match(DO);
				setState(451);
				block();
				setState(452);
				match(WHILE);
				setState(453);
				match(Identifier);
				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(454);
					match(LBRACK);
					setState(455);
					expression(0);
					setState(456);
					match(RBRACK);
					}
				}

				setState(468); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(468);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case StringLiteral:
							{
							setState(460);
							match(StringLiteral);
							}
							break;
						case Identifier:
							{
							setState(461);
							match(Identifier);
							setState(466);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LBRACK) {
								{
								setState(462);
								match(LBRACK);
								setState(463);
								expression(0);
								setState(464);
								match(RBRACK);
								}
							}

							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(470); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(472);
				expression(0);
				notifyErrorListeners("wrong syntax for 'do while loop' should contain 'up to' or 'down to' keyword");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(PseudoCodeParser.WHILE, 0); }
		public List<TerminalNode> Identifier() { return getTokens(PseudoCodeParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PseudoCodeParser.Identifier, i);
		}
		public TerminalNode UPTO() { return getToken(PseudoCodeParser.UPTO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(PseudoCodeParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(PseudoCodeParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(PseudoCodeParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(PseudoCodeParser.RBRACK, i);
		}
		public TerminalNode DOWNTO() { return getToken(PseudoCodeParser.DOWNTO, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(PseudoCodeParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(PseudoCodeParser.StringLiteral, i);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_whileStatement);
		int _la;
		try {
			int _alt;
			setState(523);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(477);
				match(WHILE);
				setState(478);
				match(Identifier);
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(479);
					match(LBRACK);
					setState(480);
					expression(0);
					setState(481);
					match(RBRACK);
					}
				}

				setState(485);
				match(UPTO);
				setState(486);
				expression(0);
				setState(487);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				match(WHILE);
				setState(490);
				match(Identifier);
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(491);
					match(LBRACK);
					setState(492);
					expression(0);
					setState(493);
					match(RBRACK);
					}
				}

				setState(497);
				match(DOWNTO);
				setState(498);
				expression(0);
				setState(499);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				match(WHILE);
				setState(502);
				match(Identifier);
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(503);
					match(LBRACK);
					setState(504);
					expression(0);
					setState(505);
					match(RBRACK);
					}
				}

				setState(515); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(515);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case StringLiteral:
							{
							setState(509);
							match(StringLiteral);
							}
							break;
						case Identifier:
							{
							setState(510);
							match(Identifier);
							{
							setState(511);
							match(LBRACK);
							setState(512);
							expression(0);
							setState(513);
							match(RBRACK);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(517); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(519);
				expression(0);
				setState(520);
				block();
				notifyErrorListeners("wrong syntax for 'while loop' should contain 'up to' or 'down to' keyword");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfThenStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PseudoCodeParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(PseudoCodeParser.LPAREN, 0); }
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PseudoCodeParser.RPAREN, 0); }
		public List<TerminalNode> THEN() { return getTokens(PseudoCodeParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(PseudoCodeParser.THEN, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PseudoCodeParser.ELSE, 0); }
		public IfThenStatementContext ifThenStatement() {
			return getRuleContext(IfThenStatementContext.class,0);
		}
		public IfThenStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterIfThenStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitIfThenStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitIfThenStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenStatementContext ifThenStatement() throws RecognitionException {
		IfThenStatementContext _localctx = new IfThenStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_ifThenStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			match(IF);
			setState(526);
			match(LPAREN);
			setState(527);
			conditionalExpression();
			setState(528);
			match(RPAREN);
			setState(529);
			match(THEN);
			setState(530);
			block();
			setState(537);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(531);
				match(ELSE);
				setState(535);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case THEN:
					{
					setState(532);
					match(THEN);
					setState(533);
					block();
					}
					break;
				case IF:
					{
					setState(534);
					ifThenStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintInvocationContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(PseudoCodeParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(PseudoCodeParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(PseudoCodeParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PseudoCodeParser.RPAREN, i);
		}
		public TerminalNode ADD() { return getToken(PseudoCodeParser.ADD, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(PseudoCodeParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(PseudoCodeParser.StringLiteral, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(PseudoCodeParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PseudoCodeParser.Identifier, i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(PseudoCodeParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(PseudoCodeParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(PseudoCodeParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(PseudoCodeParser.RBRACK, i);
		}
		public PrintInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterPrintInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitPrintInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitPrintInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintInvocationContext printInvocation() throws RecognitionException {
		PrintInvocationContext _localctx = new PrintInvocationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_printInvocation);
		int _la;
		try {
			setState(584);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				match(PRINT);
				setState(540);
				match(LPAREN);
				setState(541);
				expression(0);
				setState(542);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(544);
				match(PRINT);
				setState(545);
				match(LPAREN);
				setState(546);
				expression(0);
				setState(547);
				match(ADD);
				setState(548);
				match(RPAREN);
				notifyErrorListeners("additional ‘+’ sign at end of print");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(551);
				match(PRINT);
				setState(552);
				match(LPAREN);
				{
				setState(562);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case StringLiteral:
					{
					setState(553);
					match(StringLiteral);
					}
					break;
				case PRINT:
				case SCAN:
				case FUNC:
				case MAIN:
				case STRING:
				case CONSTANT:
				case CREATE:
				case THEN:
				case BOOL:
				case BREAK:
				case CONTINUE:
				case DO:
				case ELSE:
				case FLOAT:
				case FOR:
				case IF:
				case INT:
				case RETURN:
				case VOID:
				case WHILE:
				case UPTO:
				case DOWNTO:
				case IntegerLiteral:
				case FloatingPointLiteral:
				case BooleanLiteral:
				case LPAREN:
				case LBRACE:
				case RBRACE:
				case LBRACK:
				case RBRACK:
				case SEMI:
				case COMMA:
				case ASSIGN:
				case DOT:
				case GT:
				case LT:
				case BANG:
				case TILDE:
				case QUESTION:
				case COLON:
				case EQUAL:
				case LE:
				case GE:
				case NOTEQUAL:
				case AND:
				case OR:
				case ADD:
				case SUB:
				case MUL:
				case DIV:
				case BSLASH:
				case BITAND:
				case BITOR:
				case CARET:
				case MOD:
				case DQUOTE:
				case WS:
				case COMMENT:
				case LINE_COMMENT:
					{
					setState(554);
					_la = _input.LA(1);
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << RPAREN) | (1L << Identifier))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case Identifier:
					{
					setState(555);
					match(Identifier);
					setState(560);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
					case 1:
						{
						setState(556);
						match(LBRACK);
						setState(557);
						expression(0);
						setState(558);
						match(RBRACK);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(573); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(573);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case StringLiteral:
						{
						setState(564);
						match(StringLiteral);
						}
						break;
					case PRINT:
					case SCAN:
					case FUNC:
					case MAIN:
					case STRING:
					case CONSTANT:
					case CREATE:
					case THEN:
					case BOOL:
					case BREAK:
					case CONTINUE:
					case DO:
					case ELSE:
					case FLOAT:
					case FOR:
					case IF:
					case INT:
					case RETURN:
					case VOID:
					case WHILE:
					case UPTO:
					case DOWNTO:
					case IntegerLiteral:
					case FloatingPointLiteral:
					case BooleanLiteral:
					case LPAREN:
					case LBRACE:
					case RBRACE:
					case LBRACK:
					case RBRACK:
					case SEMI:
					case COMMA:
					case ASSIGN:
					case DOT:
					case GT:
					case LT:
					case BANG:
					case TILDE:
					case QUESTION:
					case COLON:
					case EQUAL:
					case LE:
					case GE:
					case NOTEQUAL:
					case AND:
					case OR:
					case ADD:
					case SUB:
					case MUL:
					case DIV:
					case BSLASH:
					case BITAND:
					case BITOR:
					case CARET:
					case MOD:
					case DQUOTE:
					case WS:
					case COMMENT:
					case LINE_COMMENT:
						{
						setState(565);
						_la = _input.LA(1);
						if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << RPAREN) | (1L << Identifier))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case Identifier:
						{
						setState(566);
						match(Identifier);
						setState(571);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
						case 1:
							{
							setState(567);
							match(LBRACK);
							setState(568);
							expression(0);
							setState(569);
							match(RBRACK);
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(575); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << SCAN) | (1L << FUNC) | (1L << MAIN) | (1L << STRING) | (1L << CONSTANT) | (1L << CREATE) | (1L << THEN) | (1L << BOOL) | (1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << ELSE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << VOID) | (1L << WHILE) | (1L << UPTO) | (1L << DOWNTO) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << RBRACE) | (1L << LBRACK) | (1L << RBRACK) | (1L << SEMI) | (1L << COMMA) | (1L << ASSIGN) | (1L << DOT) | (1L << GT) | (1L << LT) | (1L << BANG) | (1L << TILDE) | (1L << QUESTION) | (1L << COLON) | (1L << EQUAL) | (1L << LE) | (1L << GE) | (1L << NOTEQUAL) | (1L << AND) | (1L << OR) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << BSLASH) | (1L << BITAND) | (1L << BITOR) | (1L << CARET) | (1L << MOD) | (1L << DQUOTE) | (1L << Identifier) | (1L << WS) | (1L << COMMENT) | (1L << LINE_COMMENT))) != 0) );
				}
				setState(577);
				match(RPAREN);
				notifyErrorListeners("lacking 'double quotes' in print statement");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(579);
				match(PRINT);
				setState(580);
				match(LPAREN);
				setState(581);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << RPAREN) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(582);
				match(RPAREN);
				notifyErrorListeners("value of keyword cannot be printed");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScanInvocationContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(PseudoCodeParser.SCAN, 0); }
		public TerminalNode LPAREN() { return getToken(PseudoCodeParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PseudoCodeParser.COMMA, 0); }
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public TerminalNode RPAREN() { return getToken(PseudoCodeParser.RPAREN, 0); }
		public TerminalNode LBRACK() { return getToken(PseudoCodeParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(PseudoCodeParser.RBRACK, 0); }
		public ScanInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scanInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterScanInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitScanInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitScanInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScanInvocationContext scanInvocation() throws RecognitionException {
		ScanInvocationContext _localctx = new ScanInvocationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_scanInvocation);
		try {
			setState(603);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(586);
				match(SCAN);
				setState(587);
				match(LPAREN);
				setState(588);
				expression(0);
				setState(589);
				match(COMMA);
				setState(590);
				match(Identifier);
				setState(591);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
				match(SCAN);
				setState(594);
				match(LPAREN);
				setState(595);
				expression(0);
				setState(596);
				match(COMMA);
				setState(597);
				match(Identifier);
				setState(598);
				match(LBRACK);
				setState(599);
				expression(0);
				setState(600);
				match(RBRACK);
				setState(601);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PseudoCodeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PseudoCodeParser.COMMA, i);
		}
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
		}
		public ExpressionListContext expressionList(int i) {
			return getRuleContext(ExpressionListContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		return expressionList(0);
	}

	private ExpressionListContext expressionList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, _parentState);
		ExpressionListContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_expressionList, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(638);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(606);
				expression(0);
				setState(611);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(607);
						match(COMMA);
						setState(608);
						expression(0);
						}
						} 
					}
					setState(613);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(622);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
				case 1:
					{
					setState(614);
					expression(0);
					setState(619);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(615);
						match(COMMA);
						setState(616);
						expression(0);
						}
						}
						setState(621);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(624);
				expression(0);
				setState(625);
				expressionList(4);
				notifyErrorListeners("no separator found in parameters");
				}
				break;
			case 3:
				{
				setState(631);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(628);
						match(COMMA);
						}
						} 
					}
					setState(633);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				}
				setState(634);
				match(COMMA);
				setState(635);
				expressionList(3);
				notifyErrorListeners("lacking parameter");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(663);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(661);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionListContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionList);
						setState(640);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(641);
						match(COMMA);
						setState(642);
						match(COMMA);
						setState(646);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(643);
								match(COMMA);
								}
								} 
							}
							setState(648);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
						}
						setState(649);
						expressionList(2);
						notifyErrorListeners("lacking parameter");
						}
						break;
					case 2:
						{
						_localctx = new ExpressionListContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionList);
						setState(652);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(653);
						match(COMMA);
						setState(657);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(654);
								match(COMMA);
								}
								} 
							}
							setState(659);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
						}
						notifyErrorListeners("lacking parameter");
						}
						break;
					}
					} 
				}
				setState(665);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatementExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_statementExpression);
		try {
			setState(668);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(666);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(667);
				methodInvocation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodInvocationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(PseudoCodeParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(PseudoCodeParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(PseudoCodeParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PseudoCodeParser.RPAREN, i);
		}
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
		}
		public ExpressionListContext expressionList(int i) {
			return getRuleContext(ExpressionListContext.class,i);
		}
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitMethodInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_methodInvocation);
		try {
			setState(700);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(670);
				match(Identifier);
				setState(671);
				match(LPAREN);
				setState(673);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					setState(672);
					expressionList(0);
					}
					break;
				}
				setState(675);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(676);
				match(Identifier);
				setState(677);
				match(LPAREN);
				setState(679);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(678);
					expressionList(0);
					}
					break;
				}
				setState(681);
				match(RPAREN);
				setState(682);
				match(LPAREN);
				setState(684);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(683);
					expressionList(0);
					}
					break;
				}
				setState(686);
				match(RPAREN);
				notifyErrorListeners("redundant parentheses");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(688);
				match(Identifier);
				setState(689);
				match(LPAREN);
				setState(691);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(690);
					expressionList(0);
					}
					break;
				}
				notifyErrorListeners("uneven parenthesis, lacking ')'");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(694);
				match(Identifier);
				setState(696);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(695);
					expressionList(0);
					}
					break;
				}
				setState(698);
				match(RPAREN);
				notifyErrorListeners("uneven parenthesis, lacking '('");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_conditionalExpression);
		try {
			setState(706);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(702);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(703);
				assignment();
				notifyErrorListeners("assignment operator found, expecting comparison operator");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(PseudoCodeParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(PseudoCodeParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(PseudoCodeParser.RBRACK, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_assignment);
		try {
			setState(718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(708);
				match(Identifier);
				setState(709);
				match(ASSIGN);
				setState(710);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(711);
				match(Identifier);
				setState(712);
				match(LBRACK);
				setState(713);
				expression(0);
				setState(714);
				match(RBRACK);
				setState(715);
				match(ASSIGN);
				setState(716);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public TerminalNode LBRACK() { return getToken(PseudoCodeParser.LBRACK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(PseudoCodeParser.RBRACK, 0); }
		public TerminalNode LPAREN() { return getToken(PseudoCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PseudoCodeParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode BANG() { return getToken(PseudoCodeParser.BANG, 0); }
		public List<TerminalNode> MUL() { return getTokens(PseudoCodeParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(PseudoCodeParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(PseudoCodeParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(PseudoCodeParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(PseudoCodeParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(PseudoCodeParser.MOD, i);
		}
		public List<TerminalNode> ADD() { return getTokens(PseudoCodeParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(PseudoCodeParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(PseudoCodeParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(PseudoCodeParser.SUB, i);
		}
		public TerminalNode LE() { return getToken(PseudoCodeParser.LE, 0); }
		public TerminalNode GE() { return getToken(PseudoCodeParser.GE, 0); }
		public TerminalNode GT() { return getToken(PseudoCodeParser.GT, 0); }
		public TerminalNode LT() { return getToken(PseudoCodeParser.LT, 0); }
		public TerminalNode EQUAL() { return getToken(PseudoCodeParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(PseudoCodeParser.NOTEQUAL, 0); }
		public TerminalNode AND() { return getToken(PseudoCodeParser.AND, 0); }
		public TerminalNode OR() { return getToken(PseudoCodeParser.OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				setState(721);
				primary();
				}
				break;
			case 2:
				{
				setState(722);
				match(Identifier);
				setState(723);
				match(LBRACK);
				setState(724);
				expression(0);
				setState(725);
				match(RBRACK);
				}
				break;
			case 3:
				{
				setState(727);
				match(Identifier);
				setState(728);
				match(LPAREN);
				setState(730);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(729);
					expressionList(0);
					}
					break;
				}
				setState(732);
				match(RPAREN);
				}
				break;
			case 4:
				{
				{
				setState(733);
				match(BANG);
				}
				setState(734);
				unaryExpression();
				}
				break;
			case 5:
				{
				setState(735);
				primary();
				setState(736);
				match(LPAREN);
				setState(737);
				match(RPAREN);
				notifyErrorListeners("redundant parenthesis");
				}
				break;
			case 6:
				{
				setState(740);
				primary();
				setState(741);
				match(RPAREN);
				notifyErrorListeners("uneven parenthesis, lacking '('");
				}
				break;
			case 7:
				{
				setState(744);
				primary();
				setState(745);
				match(LPAREN);
				notifyErrorListeners("uneven parenthesis, lacking ')'");
				}
				break;
			case 8:
				{
				setState(748);
				match(LPAREN);
				setState(749);
				match(RPAREN);
				setState(750);
				primary();
				notifyErrorListeners("redundant parenthesis");
				}
				break;
			case 9:
				{
				setState(753);
				match(RPAREN);
				setState(754);
				primary();
				notifyErrorListeners("uneven parenthesis, lacking '('");
				}
				break;
			case 10:
				{
				setState(757);
				match(LPAREN);
				setState(758);
				primary();
				notifyErrorListeners("uneven parenthesis, lacking ')'");
				}
				break;
			case 11:
				{
				setState(761);
				unaryExpression();
				setState(763); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(762);
						unaryExpression();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(765); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				notifyErrorListeners("no operators found");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(804);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(802);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(771);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(772);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(773);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(774);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(775);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(776);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(777);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(778);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(779);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(780);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(781);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(782);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(783);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(784);
						match(AND);
						setState(785);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(786);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(787);
						match(OR);
						setState(788);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(789);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(790);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(792); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(791);
							_la = _input.LA(1);
							if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							}
							}
							setState(794); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0) );
						setState(796);
						expression(3);
						notifyErrorListeners("redundant arithmetic operator symbol found");
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(799);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(800);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						notifyErrorListeners("lacking argument after operator/excess operator");
						}
						break;
					}
					} 
				}
				setState(806);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public TerminalNode LBRACK() { return getToken(PseudoCodeParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(PseudoCodeParser.RBRACK, 0); }
		public TerminalNode LPAREN() { return getToken(PseudoCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PseudoCodeParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_unaryExpression);
		try {
			setState(819);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(807);
				primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(808);
				match(Identifier);
				setState(809);
				match(LBRACK);
				setState(810);
				expression(0);
				setState(811);
				match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(813);
				match(Identifier);
				setState(814);
				match(LPAREN);
				setState(816);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
				case 1:
					{
					setState(815);
					expressionList(0);
					}
					break;
				}
				setState(818);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(PseudoCodeParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PseudoCodeParser.RPAREN, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PseudoCodeParser.Identifier, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_primary);
		try {
			setState(827);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(821);
				match(LPAREN);
				setState(822);
				expression(0);
				setState(823);
				match(RPAREN);
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(825);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(826);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return formalParameters_sempred((FormalParametersContext)_localctx, predIndex);
		case 28:
			return expressionList_sempred((ExpressionListContext)_localctx, predIndex);
		case 33:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formalParameters_sempred(FormalParametersContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expressionList_sempred(ExpressionListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 11);
		case 9:
			return precpred(_ctx, 10);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0340\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\7\2L\n\2\f\2\16\2O\13\2\3\2\3\2\7\2"+
		"S\n\2\f\2\16\2V\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5"+
		"\5d\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5q\n\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5y\n\5\3\5\3\5\3\5\5\5~\n\5\3\6\3\6\3\6\5\6\u0083\n\6"+
		"\3\6\3\6\3\6\5\6\u0088\n\6\3\6\3\6\3\6\3\6\3\6\5\6\u008f\n\6\3\6\3\6\3"+
		"\6\5\6\u0094\n\6\3\6\3\6\5\6\u0098\n\6\3\7\3\7\3\7\7\7\u009d\n\7\f\7\16"+
		"\7\u00a0\13\7\3\b\3\b\3\b\5\b\u00a5\n\b\3\b\3\b\3\b\5\b\u00aa\n\b\3\b"+
		"\3\b\5\b\u00ae\n\b\3\t\3\t\5\t\u00b2\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\5\13\u00bd\n\13\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00c5\n\r\f\r\16"+
		"\r\u00c8\13\r\3\r\3\r\3\r\7\r\u00cd\n\r\f\r\16\r\u00d0\13\r\5\r\u00d2"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u00d9\n\r\f\r\16\r\u00dc\13\r\3\r\3\r\3\r"+
		"\3\r\5\r\u00e2\n\r\3\r\3\r\3\r\3\r\7\r\u00e8\n\r\f\r\16\r\u00eb\13\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f3\n\r\f\r\16\r\u00f6\13\r\3\r\7\r\u00f9"+
		"\n\r\f\r\16\r\u00fc\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u0106\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0110\n\17\3"+
		"\20\3\20\7\20\u0114\n\20\f\20\16\20\u0117\13\20\3\20\3\20\3\20\7\20\u011c"+
		"\n\20\f\20\16\20\u011f\13\20\3\20\5\20\u0122\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u0129\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0131\n\22\3"+
		"\23\5\23\u0134\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u013e"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u014f\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\6\24\u016b\n\24\r\24\16\24\u016c\3\24\5\24\u0170\n\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0187\n\26\6\26\u0189\n\26\r"+
		"\26\16\26\u018a\3\26\3\26\3\26\5\26\u0190\n\26\3\27\5\27\u0193\n\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01a2"+
		"\n\27\5\27\u01a4\n\27\3\30\3\30\3\30\5\30\u01a9\n\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\5\31\u01b3\n\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u01c0\n\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u01cd\n\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u01d5\n\31\6\31\u01d7\n\31\r\31\16\31\u01d8\3\31\3\31\3\31\5\31"+
		"\u01de\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01e6\n\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01f2\n\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01fe\n\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\6\32\u0206\n\32\r\32\16\32\u0207\3\32\3\32\3\32\3\32\5\32\u020e"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u021a\n\33"+
		"\5\33\u021c\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0233\n\34\5\34"+
		"\u0235\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u023e\n\34\6\34\u0240"+
		"\n\34\r\34\16\34\u0241\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u024b\n"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\5\35\u025e\n\35\3\36\3\36\3\36\3\36\7\36\u0264\n\36"+
		"\f\36\16\36\u0267\13\36\3\36\3\36\3\36\7\36\u026c\n\36\f\36\16\36\u026f"+
		"\13\36\5\36\u0271\n\36\3\36\3\36\3\36\3\36\3\36\7\36\u0278\n\36\f\36\16"+
		"\36\u027b\13\36\3\36\3\36\3\36\3\36\5\36\u0281\n\36\3\36\3\36\3\36\3\36"+
		"\7\36\u0287\n\36\f\36\16\36\u028a\13\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\7\36\u0292\n\36\f\36\16\36\u0295\13\36\3\36\7\36\u0298\n\36\f\36\16\36"+
		"\u029b\13\36\3\37\3\37\5\37\u029f\n\37\3 \3 \3 \5 \u02a4\n \3 \3 \3 \3"+
		" \5 \u02aa\n \3 \3 \3 \5 \u02af\n \3 \3 \3 \3 \3 \5 \u02b6\n \3 \3 \3"+
		" \5 \u02bb\n \3 \3 \5 \u02bf\n \3!\3!\3!\3!\5!\u02c5\n!\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u02d1\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\5#\u02dd\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\6#\u02fe\n#\r#\16#\u02ff\3#\3#\5"+
		"#\u0304\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\6#\u031b\n#\r#\16#\u031c\3#\3#\3#\3#\3#\3#\7#\u0325\n#\f#\16#\u0328"+
		"\13#\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0333\n$\3$\5$\u0336\n$\3%\3%\3%\3"+
		"%\3%\3%\5%\u033e\n%\3%\2\5\30:D&\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFH\2\t\6\2\7\7\13\13\20\20\23\23\4\2\63\66"+
		";;\5\2\34\34\36\36==\4\2\65\66;;\3\2\63\64\4\2\'(./\4\2--\60\60\2\u03af"+
		"\2M\3\2\2\2\4Y\3\2\2\2\6[\3\2\2\2\b}\3\2\2\2\n\u0097\3\2\2\2\f\u0099\3"+
		"\2\2\2\16\u00ad\3\2\2\2\20\u00b1\3\2\2\2\22\u00b3\3\2\2\2\24\u00b9\3\2"+
		"\2\2\26\u00be\3\2\2\2\30\u00e1\3\2\2\2\32\u0105\3\2\2\2\34\u010f\3\2\2"+
		"\2\36\u0121\3\2\2\2 \u0128\3\2\2\2\"\u0130\3\2\2\2$\u013d\3\2\2\2&\u016f"+
		"\3\2\2\2(\u0171\3\2\2\2*\u018f\3\2\2\2,\u01a3\3\2\2\2.\u01a8\3\2\2\2\60"+
		"\u01dd\3\2\2\2\62\u020d\3\2\2\2\64\u020f\3\2\2\2\66\u024a\3\2\2\28\u025d"+
		"\3\2\2\2:\u0280\3\2\2\2<\u029e\3\2\2\2>\u02be\3\2\2\2@\u02c4\3\2\2\2B"+
		"\u02d0\3\2\2\2D\u0303\3\2\2\2F\u0335\3\2\2\2H\u033d\3\2\2\2JL\5\b\5\2"+
		"KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PT\5\6\4\2"+
		"QS\5\b\5\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2"+
		"WX\7\2\2\3X\3\3\2\2\2YZ\7\b\2\2Z\5\3\2\2\2[\\\7\6\2\2\\]\7\35\2\2]^\7"+
		"\36\2\2^_\5\36\20\2_\7\3\2\2\2`c\7\5\2\2ad\5\24\13\2bd\7\25\2\2ca\3\2"+
		"\2\2cb\3\2\2\2de\3\2\2\2ef\5\n\6\2fg\5\36\20\2g~\3\2\2\2hi\7\5\2\2ij\5"+
		"\n\6\2jk\5\36\20\2kl\b\5\1\2l~\3\2\2\2mp\7\5\2\2nq\5\24\13\2oq\7\25\2"+
		"\2pn\3\2\2\2po\3\2\2\2qr\3\2\2\2rs\5\n\6\2st\b\5\1\2t~\3\2\2\2ux\7\5\2"+
		"\2vy\5\24\13\2wy\7\25\2\2xv\3\2\2\2xw\3\2\2\2yz\3\2\2\2z{\5\36\20\2{|"+
		"\b\5\1\2|~\3\2\2\2}`\3\2\2\2}h\3\2\2\2}m\3\2\2\2}u\3\2\2\2~\t\3\2\2\2"+
		"\177\u0080\7=\2\2\u0080\u0082\7\35\2\2\u0081\u0083\5\30\r\2\u0082\u0081"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0098\7\36\2\2"+
		"\u0085\u0087\7\35\2\2\u0086\u0088\5\30\r\2\u0087\u0086\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\36\2\2\u008a\u0098\b\6\1\2"+
		"\u008b\u008c\7=\2\2\u008c\u008e\7\35\2\2\u008d\u008f\5\30\r\2\u008e\u008d"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0098\b\6\1\2\u0091"+
		"\u0093\7=\2\2\u0092\u0094\5\30\r\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\36\2\2\u0096\u0098\b\6\1\2\u0097"+
		"\177\3\2\2\2\u0097\u0085\3\2\2\2\u0097\u008b\3\2\2\2\u0097\u0091\3\2\2"+
		"\2\u0098\13\3\2\2\2\u0099\u009e\5\16\b\2\u009a\u009b\7$\2\2\u009b\u009d"+
		"\5\16\b\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2"+
		"\u009e\u009f\3\2\2\2\u009f\r\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\7"+
		"=\2\2\u00a2\u00a3\7%\2\2\u00a3\u00a5\5\20\t\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00ae\3\2\2\2\u00a6\u00a9\5\26\f\2\u00a7\u00a8\7"+
		"%\2\2\u00a8\u00aa\5\20\t\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\b\b\1\2\u00ac\u00ae\3\2\2\2\u00ad\u00a1\3\2"+
		"\2\2\u00ad\u00a6\3\2\2\2\u00ae\17\3\2\2\2\u00af\u00b2\5\22\n\2\u00b0\u00b2"+
		"\5D#\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\21\3\2\2\2\u00b3"+
		"\u00b4\7\t\2\2\u00b4\u00b5\5\26\f\2\u00b5\u00b6\7!\2\2\u00b6\u00b7\5D"+
		"#\2\u00b7\u00b8\7\"\2\2\u00b8\23\3\2\2\2\u00b9\u00bc\5\26\f\2\u00ba\u00bb"+
		"\7!\2\2\u00bb\u00bd\7\"\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\25\3\2\2\2\u00be\u00bf\t\2\2\2\u00bf\27\3\2\2\2\u00c0\u00c1\b\r\1\2\u00c1"+
		"\u00c6\5\32\16\2\u00c2\u00c3\7$\2\2\u00c3\u00c5\5\32\16\2\u00c4\u00c2"+
		"\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00e2\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ce\5\32\16\2\u00ca\u00cb\7"+
		"$\2\2\u00cb\u00cd\5\32\16\2\u00cc\u00ca\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2"+
		"\2\2\u00d1\u00c9\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\5\32\16\2\u00d4\u00d5\5\30\r\6\u00d5\u00d6\b\r\1\2\u00d6\u00e2"+
		"\3\2\2\2\u00d7\u00d9\7$\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dd\u00de\7$\2\2\u00de\u00df\5\30\r\5\u00df\u00e0\b\r\1\2\u00e0"+
		"\u00e2\3\2\2\2\u00e1\u00c0\3\2\2\2\u00e1\u00d1\3\2\2\2\u00e1\u00da\3\2"+
		"\2\2\u00e2\u00fa\3\2\2\2\u00e3\u00e4\f\3\2\2\u00e4\u00e5\7$\2\2\u00e5"+
		"\u00e9\7$\2\2\u00e6\u00e8\7$\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2"+
		"\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9"+
		"\3\2\2\2\u00ec\u00ed\5\30\r\4\u00ed\u00ee\b\r\1\2\u00ee\u00f9\3\2\2\2"+
		"\u00ef\u00f0\f\4\2\2\u00f0\u00f4\7$\2\2\u00f1\u00f3\7$\2\2\u00f2\u00f1"+
		"\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\b\r\1\2\u00f8\u00e3\3\2"+
		"\2\2\u00f8\u00ef\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\31\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\5\24\13"+
		"\2\u00fe\u00ff\7=\2\2\u00ff\u0106\3\2\2\2\u0100\u0101\7=\2\2\u0101\u0106"+
		"\b\16\1\2\u0102\u0103\5\24\13\2\u0103\u0104\b\16\1\2\u0104\u0106\3\2\2"+
		"\2\u0105\u00fd\3\2\2\2\u0105\u0100\3\2\2\2\u0105\u0102\3\2\2\2\u0106\33"+
		"\3\2\2\2\u0107\u0110\7\31\2\2\u0108\u0109\7\31\2\2\u0109\u010a\7&\2\2"+
		"\u010a\u010b\7\31\2\2\u010b\u0110\b\17\1\2\u010c\u0110\7\32\2\2\u010d"+
		"\u0110\7\34\2\2\u010e\u0110\7\33\2\2\u010f\u0107\3\2\2\2\u010f\u0108\3"+
		"\2\2\2\u010f\u010c\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110"+
		"\35\3\2\2\2\u0111\u0115\7\37\2\2\u0112\u0114\5 \21\2\u0113\u0112\3\2\2"+
		"\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118"+
		"\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0122\7 \2\2\u0119\u011d\7\37\2\2\u011a"+
		"\u011c\5 \21\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0122\b\20\1\2\u0121\u0111\3\2\2\2\u0121\u0119\3\2\2\2\u0122\37\3\2\2"+
		"\2\u0123\u0129\5\"\22\2\u0124\u0129\5&\24\2\u0125\u0126\5D#\2\u0126\u0127"+
		"\b\21\1\2\u0127\u0129\3\2\2\2\u0128\u0123\3\2\2\2\u0128\u0124\3\2\2\2"+
		"\u0128\u0125\3\2\2\2\u0129!\3\2\2\2\u012a\u012b\5$\23\2\u012b\u012c\7"+
		"#\2\2\u012c\u0131\3\2\2\2\u012d\u012e\5$\23\2\u012e\u012f\b\22\1\2\u012f"+
		"\u0131\3\2\2\2\u0130\u012a\3\2\2\2\u0130\u012d\3\2\2\2\u0131#\3\2\2\2"+
		"\u0132\u0134\5\4\3\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135"+
		"\3\2\2\2\u0135\u0136\5\24\13\2\u0136\u0137\5\f\7\2\u0137\u013e\3\2\2\2"+
		"\u0138\u0139\7=\2\2\u0139\u013a\5\24\13\2\u013a\u013b\5\f\7\2\u013b\u013c"+
		"\b\23\1\2\u013c\u013e\3\2\2\2\u013d\u0133\3\2\2\2\u013d\u0138\3\2\2\2"+
		"\u013e%\3\2\2\2\u013f\u0170\5\36\20\2\u0140\u0170\5\64\33\2\u0141\u0170"+
		"\5\62\32\2\u0142\u0143\5\60\31\2\u0143\u0144\7#\2\2\u0144\u0170\3\2\2"+
		"\2\u0145\u0170\5(\25\2\u0146\u0147\5\66\34\2\u0147\u0148\7#\2\2\u0148"+
		"\u0170\3\2\2\2\u0149\u014a\5\66\34\2\u014a\u014b\b\24\1\2\u014b\u0170"+
		"\3\2\2\2\u014c\u014e\7\24\2\2\u014d\u014f\5D#\2\u014e\u014d\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0170\7#\2\2\u0151\u0152\7\24"+
		"\2\2\u0152\u0153\5\24\13\2\u0153\u0154\7#\2\2\u0154\u0155\b\24\1\2\u0155"+
		"\u0170\3\2\2\2\u0156\u0157\7\f\2\2\u0157\u0170\7#\2\2\u0158\u0159\7\r"+
		"\2\2\u0159\u0170\7#\2\2\u015a\u0170\7#\2\2\u015b\u015c\5<\37\2\u015c\u015d"+
		"\7#\2\2\u015d\u0170\3\2\2\2\u015e\u015f\5<\37\2\u015f\u0160\b\24\1\2\u0160"+
		"\u0170\3\2\2\2\u0161\u0162\58\35\2\u0162\u0163\7#\2\2\u0163\u0170\3\2"+
		"\2\2\u0164\u0165\58\35\2\u0165\u0166\b\24\1\2\u0166\u0170\3\2\2\2\u0167"+
		"\u0168\7=\2\2\u0168\u016a\t\3\2\2\u0169\u016b\t\3\2\2\u016a\u0169\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u0170\b\24\1\2\u016f\u013f\3\2\2\2\u016f\u0140\3"+
		"\2\2\2\u016f\u0141\3\2\2\2\u016f\u0142\3\2\2\2\u016f\u0145\3\2\2\2\u016f"+
		"\u0146\3\2\2\2\u016f\u0149\3\2\2\2\u016f\u014c\3\2\2\2\u016f\u0151\3\2"+
		"\2\2\u016f\u0156\3\2\2\2\u016f\u0158\3\2\2\2\u016f\u015a\3\2\2\2\u016f"+
		"\u015b\3\2\2\2\u016f\u015e\3\2\2\2\u016f\u0161\3\2\2\2\u016f\u0164\3\2"+
		"\2\2\u016f\u0167\3\2\2\2\u0170\'\3\2\2\2\u0171\u0172\5*\26\2\u0172\u0173"+
		"\5\36\20\2\u0173)\3\2\2\2\u0174\u0175\7\21\2\2\u0175\u0176\5,\27\2\u0176"+
		"\u0177\7\27\2\2\u0177\u0178\5D#\2\u0178\u0190\3\2\2\2\u0179\u017a\7\21"+
		"\2\2\u017a\u017b\5,\27\2\u017b\u017c\7\30\2\2\u017c\u017d\5D#\2\u017d"+
		"\u0190\3\2\2\2\u017e\u017f\7\21\2\2\u017f\u0188\5,\27\2\u0180\u0189\7"+
		"\34\2\2\u0181\u0186\7=\2\2\u0182\u0183\7!\2\2\u0183\u0184\5D#\2\u0184"+
		"\u0185\7\"\2\2\u0185\u0187\3\2\2\2\u0186\u0182\3\2\2\2\u0186\u0187\3\2"+
		"\2\2\u0187\u0189\3\2\2\2\u0188\u0180\3\2\2\2\u0188\u0181\3\2\2\2\u0189"+
		"\u018a\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2"+
		"\2\2\u018c\u018d\5D#\2\u018d\u018e\b\26\1\2\u018e\u0190\3\2\2\2\u018f"+
		"\u0174\3\2\2\2\u018f\u0179\3\2\2\2\u018f\u017e\3\2\2\2\u0190+\3\2\2\2"+
		"\u0191\u0193\7\23\2\2\u0192\u0191\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194"+
		"\3\2\2\2\u0194\u0195\7=\2\2\u0195\u01a4\5.\30\2\u0196\u0197\7=\2\2\u0197"+
		"\u0198\7!\2\2\u0198\u0199\5D#\2\u0199\u019a\7\"\2\2\u019a\u019b\5.\30"+
		"\2\u019b\u01a4\3\2\2\2\u019c\u01a1\7=\2\2\u019d\u019e\7!\2\2\u019e\u019f"+
		"\5D#\2\u019f\u01a0\7\"\2\2\u01a0\u01a2\3\2\2\2\u01a1\u019d\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u0192\3\2\2\2\u01a3\u0196\3\2"+
		"\2\2\u01a3\u019c\3\2\2\2\u01a4-\3\2\2\2\u01a5\u01a6\7%\2\2\u01a6\u01a9"+
		"\5D#\2\u01a7\u01a9\b\30\1\2\u01a8\u01a5\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9"+
		"/\3\2\2\2\u01aa\u01ab\7\16\2\2\u01ab\u01ac\5\36\20\2\u01ac\u01ad\7\26"+
		"\2\2\u01ad\u01b2\7=\2\2\u01ae\u01af\7!\2\2\u01af\u01b0\5D#\2\u01b0\u01b1"+
		"\7\"\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01ae\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"\u01b4\3\2\2\2\u01b4\u01b5\7\27\2\2\u01b5\u01b6\5D#\2\u01b6\u01de\3\2"+
		"\2\2\u01b7\u01b8\7\16\2\2\u01b8\u01b9\5\36\20\2\u01b9\u01ba\7\26\2\2\u01ba"+
		"\u01bf\7=\2\2\u01bb\u01bc\7!\2\2\u01bc\u01bd\5D#\2\u01bd\u01be\7\"\2\2"+
		"\u01be\u01c0\3\2\2\2\u01bf\u01bb\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1"+
		"\3\2\2\2\u01c1\u01c2\7\30\2\2\u01c2\u01c3\5D#\2\u01c3\u01de\3\2\2\2\u01c4"+
		"\u01c5\7\16\2\2\u01c5\u01c6\5\36\20\2\u01c6\u01c7\7\26\2\2\u01c7\u01cc"+
		"\7=\2\2\u01c8\u01c9\7!\2\2\u01c9\u01ca\5D#\2\u01ca\u01cb\7\"\2\2\u01cb"+
		"\u01cd\3\2\2\2\u01cc\u01c8\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d6\3\2"+
		"\2\2\u01ce\u01d7\7\34\2\2\u01cf\u01d4\7=\2\2\u01d0\u01d1\7!\2\2\u01d1"+
		"\u01d2\5D#\2\u01d2\u01d3\7\"\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d0\3\2\2"+
		"\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01ce\3\2\2\2\u01d6\u01cf"+
		"\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01da\3\2\2\2\u01da\u01db\5D#\2\u01db\u01dc\b\31\1\2\u01dc\u01de\3\2"+
		"\2\2\u01dd\u01aa\3\2\2\2\u01dd\u01b7\3\2\2\2\u01dd\u01c4\3\2\2\2\u01de"+
		"\61\3\2\2\2\u01df\u01e0\7\26\2\2\u01e0\u01e5\7=\2\2\u01e1\u01e2\7!\2\2"+
		"\u01e2\u01e3\5D#\2\u01e3\u01e4\7\"\2\2\u01e4\u01e6\3\2\2\2\u01e5\u01e1"+
		"\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\7\27\2\2"+
		"\u01e8\u01e9\5D#\2\u01e9\u01ea\5\36\20\2\u01ea\u020e\3\2\2\2\u01eb\u01ec"+
		"\7\26\2\2\u01ec\u01f1\7=\2\2\u01ed\u01ee\7!\2\2\u01ee\u01ef\5D#\2\u01ef"+
		"\u01f0\7\"\2\2\u01f0\u01f2\3\2\2\2\u01f1\u01ed\3\2\2\2\u01f1\u01f2\3\2"+
		"\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\7\30\2\2\u01f4\u01f5\5D#\2\u01f5"+
		"\u01f6\5\36\20\2\u01f6\u020e\3\2\2\2\u01f7\u01f8\7\26\2\2\u01f8\u01fd"+
		"\7=\2\2\u01f9\u01fa\7!\2\2\u01fa\u01fb\5D#\2\u01fb\u01fc\7\"\2\2\u01fc"+
		"\u01fe\3\2\2\2\u01fd\u01f9\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0205\3\2"+
		"\2\2\u01ff\u0206\7\34\2\2\u0200\u0201\7=\2\2\u0201\u0202\7!\2\2\u0202"+
		"\u0203\5D#\2\u0203\u0204\7\"\2\2\u0204\u0206\3\2\2\2\u0205\u01ff\3\2\2"+
		"\2\u0205\u0200\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0205\3\2\2\2\u0207\u0208"+
		"\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a\5D#\2\u020a\u020b\5\36\20\2\u020b"+
		"\u020c\b\32\1\2\u020c\u020e\3\2\2\2\u020d\u01df\3\2\2\2\u020d\u01eb\3"+
		"\2\2\2\u020d\u01f7\3\2\2\2\u020e\63\3\2\2\2\u020f\u0210\7\22\2\2\u0210"+
		"\u0211\7\35\2\2\u0211\u0212\5@!\2\u0212\u0213\7\36\2\2\u0213\u0214\7\n"+
		"\2\2\u0214\u021b\5\36\20\2\u0215\u0219\7\17\2\2\u0216\u0217\7\n\2\2\u0217"+
		"\u021a\5\36\20\2\u0218\u021a\5\64\33\2\u0219\u0216\3\2\2\2\u0219\u0218"+
		"\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0215\3\2\2\2\u021b\u021c\3\2\2\2\u021c"+
		"\65\3\2\2\2\u021d\u021e\7\3\2\2\u021e\u021f\7\35\2\2\u021f\u0220\5D#\2"+
		"\u0220\u0221\7\36\2\2\u0221\u024b\3\2\2\2\u0222\u0223\7\3\2\2\u0223\u0224"+
		"\7\35\2\2\u0224\u0225\5D#\2\u0225\u0226\7\63\2\2\u0226\u0227\7\36\2\2"+
		"\u0227\u0228\b\34\1\2\u0228\u024b\3\2\2\2\u0229\u022a\7\3\2\2\u022a\u0234"+
		"\7\35\2\2\u022b\u0235\7\34\2\2\u022c\u0235\n\4\2\2\u022d\u0232\7=\2\2"+
		"\u022e\u022f\7!\2\2\u022f\u0230\5D#\2\u0230\u0231\7\"\2\2\u0231\u0233"+
		"\3\2\2\2\u0232\u022e\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0235\3\2\2\2\u0234"+
		"\u022b\3\2\2\2\u0234\u022c\3\2\2\2\u0234\u022d\3\2\2\2\u0235\u023f\3\2"+
		"\2\2\u0236\u0240\7\34\2\2\u0237\u0240\n\4\2\2\u0238\u023d\7=\2\2\u0239"+
		"\u023a\7!\2\2\u023a\u023b\5D#\2\u023b\u023c\7\"\2\2\u023c\u023e\3\2\2"+
		"\2\u023d\u0239\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240\3\2\2\2\u023f\u0236"+
		"\3\2\2\2\u023f\u0237\3\2\2\2\u023f\u0238\3\2\2\2\u0240\u0241\3\2\2\2\u0241"+
		"\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243\3\2\2\2\u0243\u0244\7\36"+
		"\2\2\u0244\u024b\b\34\1\2\u0245\u0246\7\3\2\2\u0246\u0247\7\35\2\2\u0247"+
		"\u0248\n\4\2\2\u0248\u0249\7\36\2\2\u0249\u024b\b\34\1\2\u024a\u021d\3"+
		"\2\2\2\u024a\u0222\3\2\2\2\u024a\u0229\3\2\2\2\u024a\u0245\3\2\2\2\u024b"+
		"\67\3\2\2\2\u024c\u024d\7\4\2\2\u024d\u024e\7\35\2\2\u024e\u024f\5D#\2"+
		"\u024f\u0250\7$\2\2\u0250\u0251\7=\2\2\u0251\u0252\7\36\2\2\u0252\u025e"+
		"\3\2\2\2\u0253\u0254\7\4\2\2\u0254\u0255\7\35\2\2\u0255\u0256\5D#\2\u0256"+
		"\u0257\7$\2\2\u0257\u0258\7=\2\2\u0258\u0259\7!\2\2\u0259\u025a\5D#\2"+
		"\u025a\u025b\7\"\2\2\u025b\u025c\7\36\2\2\u025c\u025e\3\2\2\2\u025d\u024c"+
		"\3\2\2\2\u025d\u0253\3\2\2\2\u025e9\3\2\2\2\u025f\u0260\b\36\1\2\u0260"+
		"\u0265\5D#\2\u0261\u0262\7$\2\2\u0262\u0264\5D#\2\u0263\u0261\3\2\2\2"+
		"\u0264\u0267\3\2\2\2\u0265\u0263\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0281"+
		"\3\2\2\2\u0267\u0265\3\2\2\2\u0268\u026d\5D#\2\u0269\u026a\7$\2\2\u026a"+
		"\u026c\5D#\2\u026b\u0269\3\2\2\2\u026c\u026f\3\2\2\2\u026d\u026b\3\2\2"+
		"\2\u026d\u026e\3\2\2\2\u026e\u0271\3\2\2\2\u026f\u026d\3\2\2\2\u0270\u0268"+
		"\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0273\5D#\2\u0273"+
		"\u0274\5:\36\6\u0274\u0275\b\36\1\2\u0275\u0281\3\2\2\2\u0276\u0278\7"+
		"$\2\2\u0277\u0276\3\2\2\2\u0278\u027b\3\2\2\2\u0279\u0277\3\2\2\2\u0279"+
		"\u027a\3\2\2\2\u027a\u027c\3\2\2\2\u027b\u0279\3\2\2\2\u027c\u027d\7$"+
		"\2\2\u027d\u027e\5:\36\5\u027e\u027f\b\36\1\2\u027f\u0281\3\2\2\2\u0280"+
		"\u025f\3\2\2\2\u0280\u0270\3\2\2\2\u0280\u0279\3\2\2\2\u0281\u0299\3\2"+
		"\2\2\u0282\u0283\f\3\2\2\u0283\u0284\7$\2\2\u0284\u0288\7$\2\2\u0285\u0287"+
		"\7$\2\2\u0286\u0285\3\2\2\2\u0287\u028a\3\2\2\2\u0288\u0286\3\2\2\2\u0288"+
		"\u0289\3\2\2\2\u0289\u028b\3\2\2\2\u028a\u0288\3\2\2\2\u028b\u028c\5:"+
		"\36\4\u028c\u028d\b\36\1\2\u028d\u0298\3\2\2\2\u028e\u028f\f\4\2\2\u028f"+
		"\u0293\7$\2\2\u0290\u0292\7$\2\2\u0291\u0290\3\2\2\2\u0292\u0295\3\2\2"+
		"\2\u0293\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u0296\3\2\2\2\u0295\u0293"+
		"\3\2\2\2\u0296\u0298\b\36\1\2\u0297\u0282\3\2\2\2\u0297\u028e\3\2\2\2"+
		"\u0298\u029b\3\2\2\2\u0299\u0297\3\2\2\2\u0299\u029a\3\2\2\2\u029a;\3"+
		"\2\2\2\u029b\u0299\3\2\2\2\u029c\u029f\5B\"\2\u029d\u029f\5> \2\u029e"+
		"\u029c\3\2\2\2\u029e\u029d\3\2\2\2\u029f=\3\2\2\2\u02a0\u02a1\7=\2\2\u02a1"+
		"\u02a3\7\35\2\2\u02a2\u02a4\5:\36\2\u02a3\u02a2\3\2\2\2\u02a3\u02a4\3"+
		"\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02bf\7\36\2\2\u02a6\u02a7\7=\2\2\u02a7"+
		"\u02a9\7\35\2\2\u02a8\u02aa\5:\36\2\u02a9\u02a8\3\2\2\2\u02a9\u02aa\3"+
		"\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02ac\7\36\2\2\u02ac\u02ae\7\35\2\2\u02ad"+
		"\u02af\5:\36\2\u02ae\u02ad\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b0\3\2"+
		"\2\2\u02b0\u02b1\7\36\2\2\u02b1\u02bf\b \1\2\u02b2\u02b3\7=\2\2\u02b3"+
		"\u02b5\7\35\2\2\u02b4\u02b6\5:\36\2\u02b5\u02b4\3\2\2\2\u02b5\u02b6\3"+
		"\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02bf\b \1\2\u02b8\u02ba\7=\2\2\u02b9"+
		"\u02bb\5:\36\2\u02ba\u02b9\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02bc\3\2"+
		"\2\2\u02bc\u02bd\7\36\2\2\u02bd\u02bf\b \1\2\u02be\u02a0\3\2\2\2\u02be"+
		"\u02a6\3\2\2\2\u02be\u02b2\3\2\2\2\u02be\u02b8\3\2\2\2\u02bf?\3\2\2\2"+
		"\u02c0\u02c5\5D#\2\u02c1\u02c2\5B\"\2\u02c2\u02c3\b!\1\2\u02c3\u02c5\3"+
		"\2\2\2\u02c4\u02c0\3\2\2\2\u02c4\u02c1\3\2\2\2\u02c5A\3\2\2\2\u02c6\u02c7"+
		"\7=\2\2\u02c7\u02c8\7%\2\2\u02c8\u02d1\5D#\2\u02c9\u02ca\7=\2\2\u02ca"+
		"\u02cb\7!\2\2\u02cb\u02cc\5D#\2\u02cc\u02cd\7\"\2\2\u02cd\u02ce\7%\2\2"+
		"\u02ce\u02cf\5D#\2\u02cf\u02d1\3\2\2\2\u02d0\u02c6\3\2\2\2\u02d0\u02c9"+
		"\3\2\2\2\u02d1C\3\2\2\2\u02d2\u02d3\b#\1\2\u02d3\u0304\5H%\2\u02d4\u02d5"+
		"\7=\2\2\u02d5\u02d6\7!\2\2\u02d6\u02d7\5D#\2\u02d7\u02d8\7\"\2\2\u02d8"+
		"\u0304\3\2\2\2\u02d9\u02da\7=\2\2\u02da\u02dc\7\35\2\2\u02db\u02dd\5:"+
		"\36\2\u02dc\u02db\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd\u02de\3\2\2\2\u02de"+
		"\u0304\7\36\2\2\u02df\u02e0\7)\2\2\u02e0\u0304\5F$\2\u02e1\u02e2\5H%\2"+
		"\u02e2\u02e3\7\35\2\2\u02e3\u02e4\7\36\2\2\u02e4\u02e5\b#\1\2\u02e5\u0304"+
		"\3\2\2\2\u02e6\u02e7\5H%\2\u02e7\u02e8\7\36\2\2\u02e8\u02e9\b#\1\2\u02e9"+
		"\u0304\3\2\2\2\u02ea\u02eb\5H%\2\u02eb\u02ec\7\35\2\2\u02ec\u02ed\b#\1"+
		"\2\u02ed\u0304\3\2\2\2\u02ee\u02ef\7\35\2\2\u02ef\u02f0\7\36\2\2\u02f0"+
		"\u02f1\5H%\2\u02f1\u02f2\b#\1\2\u02f2\u0304\3\2\2\2\u02f3\u02f4\7\36\2"+
		"\2\u02f4\u02f5\5H%\2\u02f5\u02f6\b#\1\2\u02f6\u0304\3\2\2\2\u02f7\u02f8"+
		"\7\35\2\2\u02f8\u02f9\5H%\2\u02f9\u02fa\b#\1\2\u02fa\u0304\3\2\2\2\u02fb"+
		"\u02fd\5F$\2\u02fc\u02fe\5F$\2\u02fd\u02fc\3\2\2\2\u02fe\u02ff\3\2\2\2"+
		"\u02ff\u02fd\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0302"+
		"\b#\1\2\u0302\u0304\3\2\2\2\u0303\u02d2\3\2\2\2\u0303\u02d4\3\2\2\2\u0303"+
		"\u02d9\3\2\2\2\u0303\u02df\3\2\2\2\u0303\u02e1\3\2\2\2\u0303\u02e6\3\2"+
		"\2\2\u0303\u02ea\3\2\2\2\u0303\u02ee\3\2\2\2\u0303\u02f3\3\2\2\2\u0303"+
		"\u02f7\3\2\2\2\u0303\u02fb\3\2\2\2\u0304\u0326\3\2\2\2\u0305\u0306\f\21"+
		"\2\2\u0306\u0307\t\5\2\2\u0307\u0325\5D#\22\u0308\u0309\f\20\2\2\u0309"+
		"\u030a\t\6\2\2\u030a\u0325\5D#\21\u030b\u030c\f\17\2\2\u030c\u030d\t\7"+
		"\2\2\u030d\u0325\5D#\20\u030e\u030f\f\16\2\2\u030f\u0310\t\b\2\2\u0310"+
		"\u0325\5D#\17\u0311\u0312\f\r\2\2\u0312\u0313\7\61\2\2\u0313\u0325\5D"+
		"#\16\u0314\u0315\f\f\2\2\u0315\u0316\7\62\2\2\u0316\u0325\5D#\r\u0317"+
		"\u0318\f\4\2\2\u0318\u031a\t\3\2\2\u0319\u031b\t\3\2\2\u031a\u0319\3\2"+
		"\2\2\u031b\u031c\3\2\2\2\u031c\u031a\3\2\2\2\u031c\u031d\3\2\2\2\u031d"+
		"\u031e\3\2\2\2\u031e\u031f\5D#\5\u031f\u0320\b#\1\2\u0320\u0325\3\2\2"+
		"\2\u0321\u0322\f\3\2\2\u0322\u0323\t\3\2\2\u0323\u0325\b#\1\2\u0324\u0305"+
		"\3\2\2\2\u0324\u0308\3\2\2\2\u0324\u030b\3\2\2\2\u0324\u030e\3\2\2\2\u0324"+
		"\u0311\3\2\2\2\u0324\u0314\3\2\2\2\u0324\u0317\3\2\2\2\u0324\u0321\3\2"+
		"\2\2\u0325\u0328\3\2\2\2\u0326\u0324\3\2\2\2\u0326\u0327\3\2\2\2\u0327"+
		"E\3\2\2\2\u0328\u0326\3\2\2\2\u0329\u0336\5H%\2\u032a\u032b\7=\2\2\u032b"+
		"\u032c\7!\2\2\u032c\u032d\5D#\2\u032d\u032e\7\"\2\2\u032e\u0336\3\2\2"+
		"\2\u032f\u0330\7=\2\2\u0330\u0332\7\35\2\2\u0331\u0333\5:\36\2\u0332\u0331"+
		"\3\2\2\2\u0332\u0333\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u0336\7\36\2\2"+
		"\u0335\u0329\3\2\2\2\u0335\u032a\3\2\2\2\u0335\u032f\3\2\2\2\u0336G\3"+
		"\2\2\2\u0337\u0338\7\35\2\2\u0338\u0339\5D#\2\u0339\u033a\7\36\2\2\u033a"+
		"\u033e\3\2\2\2\u033b\u033e\5\34\17\2\u033c\u033e\7=\2\2\u033d\u0337\3"+
		"\2\2\2\u033d\u033b\3\2\2\2\u033d\u033c\3\2\2\2\u033eI\3\2\2\2aMTcpx}\u0082"+
		"\u0087\u008e\u0093\u0097\u009e\u00a4\u00a9\u00ad\u00b1\u00bc\u00c6\u00ce"+
		"\u00d1\u00da\u00e1\u00e9\u00f4\u00f8\u00fa\u0105\u010f\u0115\u011d\u0121"+
		"\u0128\u0130\u0133\u013d\u014e\u016c\u016f\u0186\u0188\u018a\u018f\u0192"+
		"\u01a1\u01a3\u01a8\u01b2\u01bf\u01cc\u01d4\u01d6\u01d8\u01dd\u01e5\u01f1"+
		"\u01fd\u0205\u0207\u020d\u0219\u021b\u0232\u0234\u023d\u023f\u0241\u024a"+
		"\u025d\u0265\u026d\u0270\u0279\u0280\u0288\u0293\u0297\u0299\u029e\u02a3"+
		"\u02a9\u02ae\u02b5\u02ba\u02be\u02c4\u02d0\u02dc\u02ff\u0303\u031c\u0324"+
		"\u0326\u0332\u0335\u033d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}