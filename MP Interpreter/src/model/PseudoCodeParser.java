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
		ASSIGN=35, GT=36, LT=37, BANG=38, TILDE=39, QUESTION=40, COLON=41, EQUAL=42, 
		LE=43, GE=44, NOTEQUAL=45, AND=46, OR=47, ADD=48, SUB=49, MUL=50, DIV=51, 
		BITAND=52, BITOR=53, CARET=54, MOD=55, Identifier=56, WS=57, COMMENT=58, 
		LINE_COMMENT=59;
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
			"'}'", "'['", "']'", "';'", "','", "'='", "'>'", "'<'", "'!'", "'~'", 
			"'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'+'", 
			"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'"
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
			"NOTEQUAL", "AND", "OR", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", 
			"CARET", "MOD", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
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
		public TerminalNode IntegerLiteral() { return getToken(PseudoCodeParser.IntegerLiteral, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral))) != 0)) ) {
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
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(LBRACE);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << SCAN) | (1L << STRING) | (1L << CONSTANT) | (1L << BOOL) | (1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << WHILE) | (1L << LBRACE) | (1L << SEMI) | (1L << Identifier))) != 0)) {
				{
				{
				setState(264);
				blockStatement();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			match(RBRACE);
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
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				localVariableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				statement();
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
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				localVariableDeclaration();
				setState(277);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
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
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case CONSTANT:
			case BOOL:
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONSTANT) {
					{
					setState(284);
					variableModifier();
					}
				}

				setState(287);
				result();
				setState(288);
				variableDeclaratorList();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(Identifier);
				setState(291);
				result();
				setState(292);
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
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public PrintInvocationContext printInvocation() {
			return getRuleContext(PrintInvocationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PseudoCodeParser.SEMI, 0); }
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
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				ifThenStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				whileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				doStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(302);
				printInvocation();
				setState(303);
				match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(305);
				printInvocation();
				notifyErrorListeners("lacking ';' at the end of line");
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(308);
				match(RETURN);
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << LPAREN) | (1L << RPAREN) | (1L << BANG) | (1L << Identifier))) != 0)) {
					{
					setState(309);
					expression(0);
					}
				}

				setState(312);
				match(SEMI);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(313);
				match(RETURN);
				setState(314);
				result();
				setState(315);
				match(SEMI);
				notifyErrorListeners("cannot return data type");
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(318);
				match(BREAK);
				setState(319);
				match(SEMI);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(320);
				match(CONTINUE);
				setState(321);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(322);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(323);
				statementExpression();
				setState(324);
				match(SEMI);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(326);
				statementExpression();
				notifyErrorListeners("lacking ';' at the end of line");
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(329);
				scanInvocation();
				setState(330);
				match(SEMI);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(332);
				scanInvocation();
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
			setState(337);
			forheader();
			setState(338);
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
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				match(FOR);
				setState(341);
				forinitializer();
				setState(342);
				match(UPTO);
				setState(343);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				match(FOR);
				setState(346);
				forinitializer();
				setState(347);
				match(DOWNTO);
				setState(348);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				match(FOR);
				setState(351);
				forinitializer();
				setState(360); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(360);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case StringLiteral:
							{
							setState(352);
							match(StringLiteral);
							}
							break;
						case Identifier:
							{
							setState(353);
							match(Identifier);
							setState(358);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LBRACK) {
								{
								setState(354);
								match(LBRACK);
								setState(355);
								expression(0);
								setState(356);
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
					setState(362); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(364);
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
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
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
			setState(387);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT))) != 0)) {
					{
					setState(369);
					unannType();
					}
				}

				setState(372);
				match(Identifier);
				setState(373);
				customAssignError();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(374);
				match(Identifier);
				setState(375);
				match(LBRACK);
				setState(376);
				expression(0);
				setState(377);
				match(RBRACK);
				setState(378);
				customAssignError();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
				match(Identifier);
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(381);
					match(LBRACK);
					setState(382);
					expression(0);
					setState(383);
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
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
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
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				match(ASSIGN);
				setState(390);
				variableInitializer();
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
			setState(445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				match(DO);
				setState(395);
				block();
				setState(396);
				match(WHILE);
				setState(397);
				match(Identifier);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(398);
					match(LBRACK);
					setState(399);
					expression(0);
					setState(400);
					match(RBRACK);
					}
				}

				setState(404);
				match(UPTO);
				setState(405);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				match(DO);
				setState(408);
				block();
				setState(409);
				match(WHILE);
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

				setState(417);
				match(DOWNTO);
				setState(418);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(420);
				match(DO);
				setState(421);
				block();
				setState(422);
				match(WHILE);
				setState(423);
				match(Identifier);
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(424);
					match(LBRACK);
					setState(425);
					expression(0);
					setState(426);
					match(RBRACK);
					}
				}

				setState(438); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(438);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case StringLiteral:
							{
							setState(430);
							match(StringLiteral);
							}
							break;
						case Identifier:
							{
							setState(431);
							match(Identifier);
							setState(436);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LBRACK) {
								{
								setState(432);
								match(LBRACK);
								setState(433);
								expression(0);
								setState(434);
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
					setState(440); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(442);
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
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(447);
				match(WHILE);
				setState(448);
				match(Identifier);
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(449);
					match(LBRACK);
					setState(450);
					expression(0);
					setState(451);
					match(RBRACK);
					}
				}

				setState(455);
				match(UPTO);
				setState(456);
				expression(0);
				setState(457);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(459);
				match(WHILE);
				setState(460);
				match(Identifier);
				setState(465);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(461);
					match(LBRACK);
					setState(462);
					expression(0);
					setState(463);
					match(RBRACK);
					}
				}

				setState(467);
				match(DOWNTO);
				setState(468);
				expression(0);
				setState(469);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(471);
				match(WHILE);
				setState(472);
				match(Identifier);
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(473);
					match(LBRACK);
					setState(474);
					expression(0);
					setState(475);
					match(RBRACK);
					}
				}

				setState(485); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(485);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case StringLiteral:
							{
							setState(479);
							match(StringLiteral);
							}
							break;
						case Identifier:
							{
							setState(480);
							match(Identifier);
							{
							setState(481);
							match(LBRACK);
							setState(482);
							expression(0);
							setState(483);
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
					setState(487); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(489);
				expression(0);
				setState(490);
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
		public List<TerminalNode> IF() { return getTokens(PseudoCodeParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(PseudoCodeParser.IF, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(PseudoCodeParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(PseudoCodeParser.LPAREN, i);
		}
		public List<ConditionalExpressionContext> conditionalExpression() {
			return getRuleContexts(ConditionalExpressionContext.class);
		}
		public ConditionalExpressionContext conditionalExpression(int i) {
			return getRuleContext(ConditionalExpressionContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(PseudoCodeParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PseudoCodeParser.RPAREN, i);
		}
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
		public List<TerminalNode> ELSE() { return getTokens(PseudoCodeParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(PseudoCodeParser.ELSE, i);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(IF);
			setState(496);
			match(LPAREN);
			setState(497);
			conditionalExpression();
			setState(498);
			match(RPAREN);
			setState(499);
			match(THEN);
			setState(500);
			block();
			setState(511);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(501);
					match(ELSE);
					setState(502);
					match(IF);
					setState(503);
					match(LPAREN);
					setState(504);
					conditionalExpression();
					setState(505);
					match(RPAREN);
					setState(506);
					match(THEN);
					setState(507);
					block();
					}
					} 
				}
				setState(513);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			}
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(514);
				match(ELSE);
				setState(515);
				match(THEN);
				setState(516);
				block();
				}
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
			setState(564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				match(PRINT);
				setState(520);
				match(LPAREN);
				setState(521);
				expression(0);
				setState(522);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(524);
				match(PRINT);
				setState(525);
				match(LPAREN);
				setState(526);
				expression(0);
				setState(527);
				match(ADD);
				setState(528);
				match(RPAREN);
				notifyErrorListeners("additional ‘+’ sign at end of print");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(531);
				match(PRINT);
				setState(532);
				match(LPAREN);
				{
				setState(542);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case StringLiteral:
					{
					setState(533);
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
				case BITAND:
				case BITOR:
				case CARET:
				case MOD:
				case WS:
				case COMMENT:
				case LINE_COMMENT:
					{
					setState(534);
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
					setState(535);
					match(Identifier);
					setState(540);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						setState(536);
						match(LBRACK);
						setState(537);
						expression(0);
						setState(538);
						match(RBRACK);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(553); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(553);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case StringLiteral:
						{
						setState(544);
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
					case BITAND:
					case BITOR:
					case CARET:
					case MOD:
					case WS:
					case COMMENT:
					case LINE_COMMENT:
						{
						setState(545);
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
						setState(546);
						match(Identifier);
						setState(551);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
						case 1:
							{
							setState(547);
							match(LBRACK);
							setState(548);
							expression(0);
							setState(549);
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
					setState(555); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << SCAN) | (1L << FUNC) | (1L << MAIN) | (1L << STRING) | (1L << CONSTANT) | (1L << CREATE) | (1L << THEN) | (1L << BOOL) | (1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << ELSE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << VOID) | (1L << WHILE) | (1L << UPTO) | (1L << DOWNTO) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << RBRACE) | (1L << LBRACK) | (1L << RBRACK) | (1L << SEMI) | (1L << COMMA) | (1L << ASSIGN) | (1L << GT) | (1L << LT) | (1L << BANG) | (1L << TILDE) | (1L << QUESTION) | (1L << COLON) | (1L << EQUAL) | (1L << LE) | (1L << GE) | (1L << NOTEQUAL) | (1L << AND) | (1L << OR) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << BITAND) | (1L << BITOR) | (1L << CARET) | (1L << MOD) | (1L << Identifier) | (1L << WS) | (1L << COMMENT) | (1L << LINE_COMMENT))) != 0) );
				}
				setState(557);
				match(RPAREN);
				notifyErrorListeners("lacking 'double quotes' in print statement");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(559);
				match(PRINT);
				setState(560);
				match(LPAREN);
				setState(561);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << RPAREN) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(562);
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
			setState(583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(566);
				match(SCAN);
				setState(567);
				match(LPAREN);
				setState(568);
				expression(0);
				setState(569);
				match(COMMA);
				setState(570);
				match(Identifier);
				setState(571);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(573);
				match(SCAN);
				setState(574);
				match(LPAREN);
				setState(575);
				expression(0);
				setState(576);
				match(COMMA);
				setState(577);
				match(Identifier);
				setState(578);
				match(LBRACK);
				setState(579);
				expression(0);
				setState(580);
				match(RBRACK);
				setState(581);
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
			setState(618);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(586);
				expression(0);
				setState(591);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(587);
						match(COMMA);
						setState(588);
						expression(0);
						}
						} 
					}
					setState(593);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(602);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(594);
					expression(0);
					setState(599);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(595);
						match(COMMA);
						setState(596);
						expression(0);
						}
						}
						setState(601);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(604);
				expression(0);
				setState(605);
				expressionList(4);
				notifyErrorListeners("no separator found in parameters");
				}
				break;
			case 3:
				{
				setState(611);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(608);
						match(COMMA);
						}
						} 
					}
					setState(613);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
				}
				setState(614);
				match(COMMA);
				setState(615);
				expressionList(3);
				notifyErrorListeners("lacking parameter");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(643);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(641);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionListContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionList);
						setState(620);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(621);
						match(COMMA);
						setState(622);
						match(COMMA);
						setState(626);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(623);
								match(COMMA);
								}
								} 
							}
							setState(628);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
						}
						setState(629);
						expressionList(2);
						notifyErrorListeners("lacking parameter");
						}
						break;
					case 2:
						{
						_localctx = new ExpressionListContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionList);
						setState(632);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(633);
						match(COMMA);
						setState(637);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(634);
								match(COMMA);
								}
								} 
							}
							setState(639);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
						}
						notifyErrorListeners("lacking parameter");
						}
						break;
					}
					} 
				}
				setState(645);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
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
			setState(648);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(646);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(647);
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
			setState(680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(650);
				match(Identifier);
				setState(651);
				match(LPAREN);
				setState(653);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
				case 1:
					{
					setState(652);
					expressionList(0);
					}
					break;
				}
				setState(655);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(656);
				match(Identifier);
				setState(657);
				match(LPAREN);
				setState(659);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
				case 1:
					{
					setState(658);
					expressionList(0);
					}
					break;
				}
				setState(661);
				match(RPAREN);
				setState(662);
				match(LPAREN);
				setState(664);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(663);
					expressionList(0);
					}
					break;
				}
				setState(666);
				match(RPAREN);
				notifyErrorListeners("redundant parentheses");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(668);
				match(Identifier);
				setState(669);
				match(LPAREN);
				setState(671);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(670);
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
				setState(674);
				match(Identifier);
				setState(676);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					setState(675);
					expressionList(0);
					}
					break;
				}
				setState(678);
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
			setState(686);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(682);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(683);
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
			setState(698);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(688);
				match(Identifier);
				setState(689);
				match(ASSIGN);
				setState(690);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(691);
				match(Identifier);
				setState(692);
				match(LBRACK);
				setState(693);
				expression(0);
				setState(694);
				match(RBRACK);
				setState(695);
				match(ASSIGN);
				setState(696);
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
		public TerminalNode BANG() { return getToken(PseudoCodeParser.BANG, 0); }
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
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
			setState(749);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(701);
				primary();
				}
				break;
			case 2:
				{
				setState(702);
				match(Identifier);
				setState(703);
				match(LBRACK);
				setState(704);
				expression(0);
				setState(705);
				match(RBRACK);
				}
				break;
			case 3:
				{
				setState(707);
				match(Identifier);
				setState(708);
				match(LPAREN);
				setState(710);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(709);
					expressionList(0);
					}
					break;
				}
				setState(712);
				match(RPAREN);
				}
				break;
			case 4:
				{
				{
				setState(713);
				match(BANG);
				}
				setState(714);
				expression(16);
				}
				break;
			case 5:
				{
				setState(715);
				primary();
				setState(716);
				match(LPAREN);
				setState(717);
				match(RPAREN);
				notifyErrorListeners("redundant parenthesis");
				}
				break;
			case 6:
				{
				setState(720);
				primary();
				setState(721);
				match(RPAREN);
				notifyErrorListeners("uneven parenthesis, lacking '('");
				}
				break;
			case 7:
				{
				setState(724);
				primary();
				setState(725);
				match(LPAREN);
				notifyErrorListeners("uneven parenthesis, lacking ')'");
				}
				break;
			case 8:
				{
				setState(728);
				match(LPAREN);
				setState(729);
				match(RPAREN);
				setState(730);
				primary();
				notifyErrorListeners("redundant parenthesis");
				}
				break;
			case 9:
				{
				setState(733);
				match(RPAREN);
				setState(734);
				primary();
				notifyErrorListeners("uneven parenthesis, lacking '('");
				}
				break;
			case 10:
				{
				setState(737);
				match(LPAREN);
				setState(738);
				primary();
				notifyErrorListeners("uneven parenthesis, lacking ')'");
				}
				break;
			case 11:
				{
				setState(741);
				unaryExpression();
				setState(743); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(742);
						unaryExpression();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(745); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				notifyErrorListeners("no operators found");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(784);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(782);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(751);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(752);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(753);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(754);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(755);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(756);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(757);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(758);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(759);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(760);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(761);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(762);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(763);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(764);
						match(AND);
						setState(765);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(766);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(767);
						match(OR);
						setState(768);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(769);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(770);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(772); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(771);
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
							setState(774); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0) );
						setState(776);
						expression(3);
						notifyErrorListeners("redundant arithmetic operator symbol found");
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(779);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(780);
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
				setState(786);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
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
			setState(799);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(787);
				primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(788);
				match(Identifier);
				setState(789);
				match(LBRACK);
				setState(790);
				expression(0);
				setState(791);
				match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(793);
				match(Identifier);
				setState(794);
				match(LPAREN);
				setState(796);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(795);
					expressionList(0);
					}
					break;
				}
				setState(798);
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
			setState(807);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(801);
				match(LPAREN);
				setState(802);
				expression(0);
				setState(803);
				match(RPAREN);
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(805);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(806);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u032c\4\2\t\2\4"+
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
		"\u0106\n\16\3\17\3\17\3\20\3\20\7\20\u010c\n\20\f\20\16\20\u010f\13\20"+
		"\3\20\3\20\3\21\3\21\5\21\u0115\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u011d\n\22\3\23\5\23\u0120\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\5\23\u012a\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0139\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0152\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0169\n\26"+
		"\6\26\u016b\n\26\r\26\16\26\u016c\3\26\3\26\3\26\5\26\u0172\n\26\3\27"+
		"\5\27\u0175\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u0184\n\27\5\27\u0186\n\27\3\30\3\30\3\30\5\30\u018b\n"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0195\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01a2\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01af\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u01b7\n\31\6\31\u01b9\n\31\r\31\16\31\u01ba"+
		"\3\31\3\31\3\31\5\31\u01c0\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01c8"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01d4\n\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u01e0\n\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\6\32\u01e8\n\32\r\32\16\32\u01e9\3\32\3\32\3"+
		"\32\3\32\5\32\u01f0\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\7\33\u0200\n\33\f\33\16\33\u0203\13\33\3\33"+
		"\3\33\3\33\5\33\u0208\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u021f"+
		"\n\34\5\34\u0221\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u022a\n"+
		"\34\6\34\u022c\n\34\r\34\16\34\u022d\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u0237\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u024a\n\35\3\36\3\36\3\36\3\36\7\36"+
		"\u0250\n\36\f\36\16\36\u0253\13\36\3\36\3\36\3\36\7\36\u0258\n\36\f\36"+
		"\16\36\u025b\13\36\5\36\u025d\n\36\3\36\3\36\3\36\3\36\3\36\7\36\u0264"+
		"\n\36\f\36\16\36\u0267\13\36\3\36\3\36\3\36\3\36\5\36\u026d\n\36\3\36"+
		"\3\36\3\36\3\36\7\36\u0273\n\36\f\36\16\36\u0276\13\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\7\36\u027e\n\36\f\36\16\36\u0281\13\36\3\36\7\36\u0284"+
		"\n\36\f\36\16\36\u0287\13\36\3\37\3\37\5\37\u028b\n\37\3 \3 \3 \5 \u0290"+
		"\n \3 \3 \3 \3 \5 \u0296\n \3 \3 \3 \5 \u029b\n \3 \3 \3 \3 \3 \5 \u02a2"+
		"\n \3 \3 \3 \5 \u02a7\n \3 \3 \5 \u02ab\n \3!\3!\3!\3!\5!\u02b1\n!\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u02bd\n\"\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\5#\u02c9\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\6#\u02ea\n#\r#\16#\u02eb"+
		"\3#\3#\5#\u02f0\n#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\6#\u0307\n#\r#\16#\u0308\3#\3#\3#\3#\3#\3#\7#\u0311\n#\f"+
		"#\16#\u0314\13#\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u031f\n$\3$\5$\u0322\n$"+
		"\3%\3%\3%\3%\3%\3%\5%\u032a\n%\3%\2\5\30:D&\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\n\6\2\7\7\13\13\20\20\23"+
		"\23\3\2\31\34\5\2\34\34\36\36::\4\2\64\6599\3\2\62\63\4\2&\'-.\4\2,,/"+
		"/\4\2\62\6599\2\u0392\2M\3\2\2\2\4Y\3\2\2\2\6[\3\2\2\2\b}\3\2\2\2\n\u0097"+
		"\3\2\2\2\f\u0099\3\2\2\2\16\u00ad\3\2\2\2\20\u00b1\3\2\2\2\22\u00b3\3"+
		"\2\2\2\24\u00b9\3\2\2\2\26\u00be\3\2\2\2\30\u00e1\3\2\2\2\32\u0105\3\2"+
		"\2\2\34\u0107\3\2\2\2\36\u0109\3\2\2\2 \u0114\3\2\2\2\"\u011c\3\2\2\2"+
		"$\u0129\3\2\2\2&\u0151\3\2\2\2(\u0153\3\2\2\2*\u0171\3\2\2\2,\u0185\3"+
		"\2\2\2.\u018a\3\2\2\2\60\u01bf\3\2\2\2\62\u01ef\3\2\2\2\64\u01f1\3\2\2"+
		"\2\66\u0236\3\2\2\28\u0249\3\2\2\2:\u026c\3\2\2\2<\u028a\3\2\2\2>\u02aa"+
		"\3\2\2\2@\u02b0\3\2\2\2B\u02bc\3\2\2\2D\u02ef\3\2\2\2F\u0321\3\2\2\2H"+
		"\u0329\3\2\2\2JL\5\b\5\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2"+
		"\2\2OM\3\2\2\2PT\5\6\4\2QS\5\b\5\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2"+
		"\2\2UW\3\2\2\2VT\3\2\2\2WX\7\2\2\3X\3\3\2\2\2YZ\7\b\2\2Z\5\3\2\2\2[\\"+
		"\7\6\2\2\\]\7\35\2\2]^\7\36\2\2^_\5\36\20\2_\7\3\2\2\2`c\7\5\2\2ad\5\24"+
		"\13\2bd\7\25\2\2ca\3\2\2\2cb\3\2\2\2de\3\2\2\2ef\5\n\6\2fg\5\36\20\2g"+
		"~\3\2\2\2hi\7\5\2\2ij\5\n\6\2jk\5\36\20\2kl\b\5\1\2l~\3\2\2\2mp\7\5\2"+
		"\2nq\5\24\13\2oq\7\25\2\2pn\3\2\2\2po\3\2\2\2qr\3\2\2\2rs\5\n\6\2st\b"+
		"\5\1\2t~\3\2\2\2ux\7\5\2\2vy\5\24\13\2wy\7\25\2\2xv\3\2\2\2xw\3\2\2\2"+
		"yz\3\2\2\2z{\5\36\20\2{|\b\5\1\2|~\3\2\2\2}`\3\2\2\2}h\3\2\2\2}m\3\2\2"+
		"\2}u\3\2\2\2~\t\3\2\2\2\177\u0080\7:\2\2\u0080\u0082\7\35\2\2\u0081\u0083"+
		"\5\30\r\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2"+
		"\u0084\u0098\7\36\2\2\u0085\u0087\7\35\2\2\u0086\u0088\5\30\r\2\u0087"+
		"\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7\36"+
		"\2\2\u008a\u0098\b\6\1\2\u008b\u008c\7:\2\2\u008c\u008e\7\35\2\2\u008d"+
		"\u008f\5\30\r\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3"+
		"\2\2\2\u0090\u0098\b\6\1\2\u0091\u0093\7:\2\2\u0092\u0094\5\30\r\2\u0093"+
		"\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\36"+
		"\2\2\u0096\u0098\b\6\1\2\u0097\177\3\2\2\2\u0097\u0085\3\2\2\2\u0097\u008b"+
		"\3\2\2\2\u0097\u0091\3\2\2\2\u0098\13\3\2\2\2\u0099\u009e\5\16\b\2\u009a"+
		"\u009b\7$\2\2\u009b\u009d\5\16\b\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\r\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00a4\7:\2\2\u00a2\u00a3\7%\2\2\u00a3\u00a5\5\20\t\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00ae\3\2\2\2\u00a6\u00a9\5\26"+
		"\f\2\u00a7\u00a8\7%\2\2\u00a8\u00aa\5\20\t\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\b\1\2\u00ac\u00ae\3\2"+
		"\2\2\u00ad\u00a1\3\2\2\2\u00ad\u00a6\3\2\2\2\u00ae\17\3\2\2\2\u00af\u00b2"+
		"\5\22\n\2\u00b0\u00b2\5D#\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2"+
		"\21\3\2\2\2\u00b3\u00b4\7\t\2\2\u00b4\u00b5\5\26\f\2\u00b5\u00b6\7!\2"+
		"\2\u00b6\u00b7\5D#\2\u00b7\u00b8\7\"\2\2\u00b8\23\3\2\2\2\u00b9\u00bc"+
		"\5\26\f\2\u00ba\u00bb\7!\2\2\u00bb\u00bd\7\"\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\25\3\2\2\2\u00be\u00bf\t\2\2\2\u00bf\27\3\2\2\2\u00c0"+
		"\u00c1\b\r\1\2\u00c1\u00c6\5\32\16\2\u00c2\u00c3\7$\2\2\u00c3\u00c5\5"+
		"\32\16\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00e2\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ce\5\32"+
		"\16\2\u00ca\u00cb\7$\2\2\u00cb\u00cd\5\32\16\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00c9\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\5\32\16\2\u00d4\u00d5\5\30\r\6\u00d5\u00d6"+
		"\b\r\1\2\u00d6\u00e2\3\2\2\2\u00d7\u00d9\7$\2\2\u00d8\u00d7\3\2\2\2\u00d9"+
		"\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2"+
		"\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7$\2\2\u00de\u00df\5\30\r\5\u00df"+
		"\u00e0\b\r\1\2\u00e0\u00e2\3\2\2\2\u00e1\u00c0\3\2\2\2\u00e1\u00d1\3\2"+
		"\2\2\u00e1\u00da\3\2\2\2\u00e2\u00fa\3\2\2\2\u00e3\u00e4\f\3\2\2\u00e4"+
		"\u00e5\7$\2\2\u00e5\u00e9\7$\2\2\u00e6\u00e8\7$\2\2\u00e7\u00e6\3\2\2"+
		"\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec"+
		"\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\5\30\r\4\u00ed\u00ee\b\r\1\2"+
		"\u00ee\u00f9\3\2\2\2\u00ef\u00f0\f\4\2\2\u00f0\u00f4\7$\2\2\u00f1\u00f3"+
		"\7$\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\b\r"+
		"\1\2\u00f8\u00e3\3\2\2\2\u00f8\u00ef\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa"+
		"\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\31\3\2\2\2\u00fc\u00fa\3\2\2"+
		"\2\u00fd\u00fe\5\24\13\2\u00fe\u00ff\7:\2\2\u00ff\u0106\3\2\2\2\u0100"+
		"\u0101\7:\2\2\u0101\u0106\b\16\1\2\u0102\u0103\5\24\13\2\u0103\u0104\b"+
		"\16\1\2\u0104\u0106\3\2\2\2\u0105\u00fd\3\2\2\2\u0105\u0100\3\2\2\2\u0105"+
		"\u0102\3\2\2\2\u0106\33\3\2\2\2\u0107\u0108\t\3\2\2\u0108\35\3\2\2\2\u0109"+
		"\u010d\7\37\2\2\u010a\u010c\5 \21\2\u010b\u010a\3\2\2\2\u010c\u010f\3"+
		"\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0111\7 \2\2\u0111\37\3\2\2\2\u0112\u0115\5\"\22"+
		"\2\u0113\u0115\5&\24\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115!"+
		"\3\2\2\2\u0116\u0117\5$\23\2\u0117\u0118\7#\2\2\u0118\u011d\3\2\2\2\u0119"+
		"\u011a\5$\23\2\u011a\u011b\b\22\1\2\u011b\u011d\3\2\2\2\u011c\u0116\3"+
		"\2\2\2\u011c\u0119\3\2\2\2\u011d#\3\2\2\2\u011e\u0120\5\4\3\2\u011f\u011e"+
		"\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\5\24\13\2"+
		"\u0122\u0123\5\f\7\2\u0123\u012a\3\2\2\2\u0124\u0125\7:\2\2\u0125\u0126"+
		"\5\24\13\2\u0126\u0127\5\f\7\2\u0127\u0128\b\23\1\2\u0128\u012a\3\2\2"+
		"\2\u0129\u011f\3\2\2\2\u0129\u0124\3\2\2\2\u012a%\3\2\2\2\u012b\u0152"+
		"\5\36\20\2\u012c\u0152\5\64\33\2\u012d\u0152\5\62\32\2\u012e\u0152\5\60"+
		"\31\2\u012f\u0152\5(\25\2\u0130\u0131\5\66\34\2\u0131\u0132\7#\2\2\u0132"+
		"\u0152\3\2\2\2\u0133\u0134\5\66\34\2\u0134\u0135\b\24\1\2\u0135\u0152"+
		"\3\2\2\2\u0136\u0138\7\24\2\2\u0137\u0139\5D#\2\u0138\u0137\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0152\7#\2\2\u013b\u013c\7\24"+
		"\2\2\u013c\u013d\5\24\13\2\u013d\u013e\7#\2\2\u013e\u013f\b\24\1\2\u013f"+
		"\u0152\3\2\2\2\u0140\u0141\7\f\2\2\u0141\u0152\7#\2\2\u0142\u0143\7\r"+
		"\2\2\u0143\u0152\7#\2\2\u0144\u0152\7#\2\2\u0145\u0146\5<\37\2\u0146\u0147"+
		"\7#\2\2\u0147\u0152\3\2\2\2\u0148\u0149\5<\37\2\u0149\u014a\b\24\1\2\u014a"+
		"\u0152\3\2\2\2\u014b\u014c\58\35\2\u014c\u014d\7#\2\2\u014d\u0152\3\2"+
		"\2\2\u014e\u014f\58\35\2\u014f\u0150\b\24\1\2\u0150\u0152\3\2\2\2\u0151"+
		"\u012b\3\2\2\2\u0151\u012c\3\2\2\2\u0151\u012d\3\2\2\2\u0151\u012e\3\2"+
		"\2\2\u0151\u012f\3\2\2\2\u0151\u0130\3\2\2\2\u0151\u0133\3\2\2\2\u0151"+
		"\u0136\3\2\2\2\u0151\u013b\3\2\2\2\u0151\u0140\3\2\2\2\u0151\u0142\3\2"+
		"\2\2\u0151\u0144\3\2\2\2\u0151\u0145\3\2\2\2\u0151\u0148\3\2\2\2\u0151"+
		"\u014b\3\2\2\2\u0151\u014e\3\2\2\2\u0152\'\3\2\2\2\u0153\u0154\5*\26\2"+
		"\u0154\u0155\5\36\20\2\u0155)\3\2\2\2\u0156\u0157\7\21\2\2\u0157\u0158"+
		"\5,\27\2\u0158\u0159\7\27\2\2\u0159\u015a\5D#\2\u015a\u0172\3\2\2\2\u015b"+
		"\u015c\7\21\2\2\u015c\u015d\5,\27\2\u015d\u015e\7\30\2\2\u015e\u015f\5"+
		"D#\2\u015f\u0172\3\2\2\2\u0160\u0161\7\21\2\2\u0161\u016a\5,\27\2\u0162"+
		"\u016b\7\34\2\2\u0163\u0168\7:\2\2\u0164\u0165\7!\2\2\u0165\u0166\5D#"+
		"\2\u0166\u0167\7\"\2\2\u0167\u0169\3\2\2\2\u0168\u0164\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u0162\3\2\2\2\u016a\u0163\3\2\2\2\u016b"+
		"\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2"+
		"\2\2\u016e\u016f\5D#\2\u016f\u0170\b\26\1\2\u0170\u0172\3\2\2\2\u0171"+
		"\u0156\3\2\2\2\u0171\u015b\3\2\2\2\u0171\u0160\3\2\2\2\u0172+\3\2\2\2"+
		"\u0173\u0175\5\26\f\2\u0174\u0173\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176"+
		"\3\2\2\2\u0176\u0177\7:\2\2\u0177\u0186\5.\30\2\u0178\u0179\7:\2\2\u0179"+
		"\u017a\7!\2\2\u017a\u017b\5D#\2\u017b\u017c\7\"\2\2\u017c\u017d\5.\30"+
		"\2\u017d\u0186\3\2\2\2\u017e\u0183\7:\2\2\u017f\u0180\7!\2\2\u0180\u0181"+
		"\5D#\2\u0181\u0182\7\"\2\2\u0182\u0184\3\2\2\2\u0183\u017f\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0174\3\2\2\2\u0185\u0178\3\2"+
		"\2\2\u0185\u017e\3\2\2\2\u0186-\3\2\2\2\u0187\u0188\7%\2\2\u0188\u018b"+
		"\5\20\t\2\u0189\u018b\b\30\1\2\u018a\u0187\3\2\2\2\u018a\u0189\3\2\2\2"+
		"\u018b/\3\2\2\2\u018c\u018d\7\16\2\2\u018d\u018e\5\36\20\2\u018e\u018f"+
		"\7\26\2\2\u018f\u0194\7:\2\2\u0190\u0191\7!\2\2\u0191\u0192\5D#\2\u0192"+
		"\u0193\7\"\2\2\u0193\u0195\3\2\2\2\u0194\u0190\3\2\2\2\u0194\u0195\3\2"+
		"\2\2\u0195\u0196\3\2\2\2\u0196\u0197\7\27\2\2\u0197\u0198\5D#\2\u0198"+
		"\u01c0\3\2\2\2\u0199\u019a\7\16\2\2\u019a\u019b\5\36\20\2\u019b\u019c"+
		"\7\26\2\2\u019c\u01a1\7:\2\2\u019d\u019e\7!\2\2\u019e\u019f\5D#\2\u019f"+
		"\u01a0\7\"\2\2\u01a0\u01a2\3\2\2\2\u01a1\u019d\3\2\2\2\u01a1\u01a2\3\2"+
		"\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\7\30\2\2\u01a4\u01a5\5D#\2\u01a5"+
		"\u01c0\3\2\2\2\u01a6\u01a7\7\16\2\2\u01a7\u01a8\5\36\20\2\u01a8\u01a9"+
		"\7\26\2\2\u01a9\u01ae\7:\2\2\u01aa\u01ab\7!\2\2\u01ab\u01ac\5D#\2\u01ac"+
		"\u01ad\7\"\2\2\u01ad\u01af\3\2\2\2\u01ae\u01aa\3\2\2\2\u01ae\u01af\3\2"+
		"\2\2\u01af\u01b8\3\2\2\2\u01b0\u01b9\7\34\2\2\u01b1\u01b6\7:\2\2\u01b2"+
		"\u01b3\7!\2\2\u01b3\u01b4\5D#\2\u01b4\u01b5\7\"\2\2\u01b5\u01b7\3\2\2"+
		"\2\u01b6\u01b2\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b0"+
		"\3\2\2\2\u01b8\u01b1\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba"+
		"\u01bb\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\5D#\2\u01bd\u01be\b\31"+
		"\1\2\u01be\u01c0\3\2\2\2\u01bf\u018c\3\2\2\2\u01bf\u0199\3\2\2\2\u01bf"+
		"\u01a6\3\2\2\2\u01c0\61\3\2\2\2\u01c1\u01c2\7\26\2\2\u01c2\u01c7\7:\2"+
		"\2\u01c3\u01c4\7!\2\2\u01c4\u01c5\5D#\2\u01c5\u01c6\7\"\2\2\u01c6\u01c8"+
		"\3\2\2\2\u01c7\u01c3\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"\u01ca\7\27\2\2\u01ca\u01cb\5D#\2\u01cb\u01cc\5\36\20\2\u01cc\u01f0\3"+
		"\2\2\2\u01cd\u01ce\7\26\2\2\u01ce\u01d3\7:\2\2\u01cf\u01d0\7!\2\2\u01d0"+
		"\u01d1\5D#\2\u01d1\u01d2\7\"\2\2\u01d2\u01d4\3\2\2\2\u01d3\u01cf\3\2\2"+
		"\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\7\30\2\2\u01d6"+
		"\u01d7\5D#\2\u01d7\u01d8\5\36\20\2\u01d8\u01f0\3\2\2\2\u01d9\u01da\7\26"+
		"\2\2\u01da\u01df\7:\2\2\u01db\u01dc\7!\2\2\u01dc\u01dd\5D#\2\u01dd\u01de"+
		"\7\"\2\2\u01de\u01e0\3\2\2\2\u01df\u01db\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"\u01e7\3\2\2\2\u01e1\u01e8\7\34\2\2\u01e2\u01e3\7:\2\2\u01e3\u01e4\7!"+
		"\2\2\u01e4\u01e5\5D#\2\u01e5\u01e6\7\"\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01e1"+
		"\3\2\2\2\u01e7\u01e2\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9"+
		"\u01ea\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\5D#\2\u01ec\u01ed\5\36"+
		"\20\2\u01ed\u01ee\b\32\1\2\u01ee\u01f0\3\2\2\2\u01ef\u01c1\3\2\2\2\u01ef"+
		"\u01cd\3\2\2\2\u01ef\u01d9\3\2\2\2\u01f0\63\3\2\2\2\u01f1\u01f2\7\22\2"+
		"\2\u01f2\u01f3\7\35\2\2\u01f3\u01f4\5@!\2\u01f4\u01f5\7\36\2\2\u01f5\u01f6"+
		"\7\n\2\2\u01f6\u0201\5\36\20\2\u01f7\u01f8\7\17\2\2\u01f8\u01f9\7\22\2"+
		"\2\u01f9\u01fa\7\35\2\2\u01fa\u01fb\5@!\2\u01fb\u01fc\7\36\2\2\u01fc\u01fd"+
		"\7\n\2\2\u01fd\u01fe\5\36\20\2\u01fe\u0200\3\2\2\2\u01ff\u01f7\3\2\2\2"+
		"\u0200\u0203\3\2\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0207"+
		"\3\2\2\2\u0203\u0201\3\2\2\2\u0204\u0205\7\17\2\2\u0205\u0206\7\n\2\2"+
		"\u0206\u0208\5\36\20\2\u0207\u0204\3\2\2\2\u0207\u0208\3\2\2\2\u0208\65"+
		"\3\2\2\2\u0209\u020a\7\3\2\2\u020a\u020b\7\35\2\2\u020b\u020c\5D#\2\u020c"+
		"\u020d\7\36\2\2\u020d\u0237\3\2\2\2\u020e\u020f\7\3\2\2\u020f\u0210\7"+
		"\35\2\2\u0210\u0211\5D#\2\u0211\u0212\7\62\2\2\u0212\u0213\7\36\2\2\u0213"+
		"\u0214\b\34\1\2\u0214\u0237\3\2\2\2\u0215\u0216\7\3\2\2\u0216\u0220\7"+
		"\35\2\2\u0217\u0221\7\34\2\2\u0218\u0221\n\4\2\2\u0219\u021e\7:\2\2\u021a"+
		"\u021b\7!\2\2\u021b\u021c\5D#\2\u021c\u021d\7\"\2\2\u021d\u021f\3\2\2"+
		"\2\u021e\u021a\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0221\3\2\2\2\u0220\u0217"+
		"\3\2\2\2\u0220\u0218\3\2\2\2\u0220\u0219\3\2\2\2\u0221\u022b\3\2\2\2\u0222"+
		"\u022c\7\34\2\2\u0223\u022c\n\4\2\2\u0224\u0229\7:\2\2\u0225\u0226\7!"+
		"\2\2\u0226\u0227\5D#\2\u0227\u0228\7\"\2\2\u0228\u022a\3\2\2\2\u0229\u0225"+
		"\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022c\3\2\2\2\u022b\u0222\3\2\2\2\u022b"+
		"\u0223\3\2\2\2\u022b\u0224\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022b\3\2"+
		"\2\2\u022d\u022e\3\2\2\2\u022e\u022f\3\2\2\2\u022f\u0230\7\36\2\2\u0230"+
		"\u0237\b\34\1\2\u0231\u0232\7\3\2\2\u0232\u0233\7\35\2\2\u0233\u0234\n"+
		"\4\2\2\u0234\u0235\7\36\2\2\u0235\u0237\b\34\1\2\u0236\u0209\3\2\2\2\u0236"+
		"\u020e\3\2\2\2\u0236\u0215\3\2\2\2\u0236\u0231\3\2\2\2\u0237\67\3\2\2"+
		"\2\u0238\u0239\7\4\2\2\u0239\u023a\7\35\2\2\u023a\u023b\5D#\2\u023b\u023c"+
		"\7$\2\2\u023c\u023d\7:\2\2\u023d\u023e\7\36\2\2\u023e\u024a\3\2\2\2\u023f"+
		"\u0240\7\4\2\2\u0240\u0241\7\35\2\2\u0241\u0242\5D#\2\u0242\u0243\7$\2"+
		"\2\u0243\u0244\7:\2\2\u0244\u0245\7!\2\2\u0245\u0246\5D#\2\u0246\u0247"+
		"\7\"\2\2\u0247\u0248\7\36\2\2\u0248\u024a\3\2\2\2\u0249\u0238\3\2\2\2"+
		"\u0249\u023f\3\2\2\2\u024a9\3\2\2\2\u024b\u024c\b\36\1\2\u024c\u0251\5"+
		"D#\2\u024d\u024e\7$\2\2\u024e\u0250\5D#\2\u024f\u024d\3\2\2\2\u0250\u0253"+
		"\3\2\2\2\u0251\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u026d\3\2\2\2\u0253"+
		"\u0251\3\2\2\2\u0254\u0259\5D#\2\u0255\u0256\7$\2\2\u0256\u0258\5D#\2"+
		"\u0257\u0255\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u0257\3\2\2\2\u0259\u025a"+
		"\3\2\2\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2\2\u025c\u0254\3\2\2\2\u025c"+
		"\u025d\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u025f\5D#\2\u025f\u0260\5:\36"+
		"\6\u0260\u0261\b\36\1\2\u0261\u026d\3\2\2\2\u0262\u0264\7$\2\2\u0263\u0262"+
		"\3\2\2\2\u0264\u0267\3\2\2\2\u0265\u0263\3\2\2\2\u0265\u0266\3\2\2\2\u0266"+
		"\u0268\3\2\2\2\u0267\u0265\3\2\2\2\u0268\u0269\7$\2\2\u0269\u026a\5:\36"+
		"\5\u026a\u026b\b\36\1\2\u026b\u026d\3\2\2\2\u026c\u024b\3\2\2\2\u026c"+
		"\u025c\3\2\2\2\u026c\u0265\3\2\2\2\u026d\u0285\3\2\2\2\u026e\u026f\f\3"+
		"\2\2\u026f\u0270\7$\2\2\u0270\u0274\7$\2\2\u0271\u0273\7$\2\2\u0272\u0271"+
		"\3\2\2\2\u0273\u0276\3\2\2\2\u0274\u0272\3\2\2\2\u0274\u0275\3\2\2\2\u0275"+
		"\u0277\3\2\2\2\u0276\u0274\3\2\2\2\u0277\u0278\5:\36\4\u0278\u0279\b\36"+
		"\1\2\u0279\u0284\3\2\2\2\u027a\u027b\f\4\2\2\u027b\u027f\7$\2\2\u027c"+
		"\u027e\7$\2\2\u027d\u027c\3\2\2\2\u027e\u0281\3\2\2\2\u027f\u027d\3\2"+
		"\2\2\u027f\u0280\3\2\2\2\u0280\u0282\3\2\2\2\u0281\u027f\3\2\2\2\u0282"+
		"\u0284\b\36\1\2\u0283\u026e\3\2\2\2\u0283\u027a\3\2\2\2\u0284\u0287\3"+
		"\2\2\2\u0285\u0283\3\2\2\2\u0285\u0286\3\2\2\2\u0286;\3\2\2\2\u0287\u0285"+
		"\3\2\2\2\u0288\u028b\5B\"\2\u0289\u028b\5> \2\u028a\u0288\3\2\2\2\u028a"+
		"\u0289\3\2\2\2\u028b=\3\2\2\2\u028c\u028d\7:\2\2\u028d\u028f\7\35\2\2"+
		"\u028e\u0290\5:\36\2\u028f\u028e\3\2\2\2\u028f\u0290\3\2\2\2\u0290\u0291"+
		"\3\2\2\2\u0291\u02ab\7\36\2\2\u0292\u0293\7:\2\2\u0293\u0295\7\35\2\2"+
		"\u0294\u0296\5:\36\2\u0295\u0294\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0297"+
		"\3\2\2\2\u0297\u0298\7\36\2\2\u0298\u029a\7\35\2\2\u0299\u029b\5:\36\2"+
		"\u029a\u0299\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d"+
		"\7\36\2\2\u029d\u02ab\b \1\2\u029e\u029f\7:\2\2\u029f\u02a1\7\35\2\2\u02a0"+
		"\u02a2\5:\36\2\u02a1\u02a0\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\3\2"+
		"\2\2\u02a3\u02ab\b \1\2\u02a4\u02a6\7:\2\2\u02a5\u02a7\5:\36\2\u02a6\u02a5"+
		"\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9\7\36\2\2"+
		"\u02a9\u02ab\b \1\2\u02aa\u028c\3\2\2\2\u02aa\u0292\3\2\2\2\u02aa\u029e"+
		"\3\2\2\2\u02aa\u02a4\3\2\2\2\u02ab?\3\2\2\2\u02ac\u02b1\5D#\2\u02ad\u02ae"+
		"\5B\"\2\u02ae\u02af\b!\1\2\u02af\u02b1\3\2\2\2\u02b0\u02ac\3\2\2\2\u02b0"+
		"\u02ad\3\2\2\2\u02b1A\3\2\2\2\u02b2\u02b3\7:\2\2\u02b3\u02b4\7%\2\2\u02b4"+
		"\u02bd\5D#\2\u02b5\u02b6\7:\2\2\u02b6\u02b7\7!\2\2\u02b7\u02b8\5D#\2\u02b8"+
		"\u02b9\7\"\2\2\u02b9\u02ba\7%\2\2\u02ba\u02bb\5D#\2\u02bb\u02bd\3\2\2"+
		"\2\u02bc\u02b2\3\2\2\2\u02bc\u02b5\3\2\2\2\u02bdC\3\2\2\2\u02be\u02bf"+
		"\b#\1\2\u02bf\u02f0\5H%\2\u02c0\u02c1\7:\2\2\u02c1\u02c2\7!\2\2\u02c2"+
		"\u02c3\5D#\2\u02c3\u02c4\7\"\2\2\u02c4\u02f0\3\2\2\2\u02c5\u02c6\7:\2"+
		"\2\u02c6\u02c8\7\35\2\2\u02c7\u02c9\5:\36\2\u02c8\u02c7\3\2\2\2\u02c8"+
		"\u02c9\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02f0\7\36\2\2\u02cb\u02cc\7"+
		"(\2\2\u02cc\u02f0\5D#\22\u02cd\u02ce\5H%\2\u02ce\u02cf\7\35\2\2\u02cf"+
		"\u02d0\7\36\2\2\u02d0\u02d1\b#\1\2\u02d1\u02f0\3\2\2\2\u02d2\u02d3\5H"+
		"%\2\u02d3\u02d4\7\36\2\2\u02d4\u02d5\b#\1\2\u02d5\u02f0\3\2\2\2\u02d6"+
		"\u02d7\5H%\2\u02d7\u02d8\7\35\2\2\u02d8\u02d9\b#\1\2\u02d9\u02f0\3\2\2"+
		"\2\u02da\u02db\7\35\2\2\u02db\u02dc\7\36\2\2\u02dc\u02dd\5H%\2\u02dd\u02de"+
		"\b#\1\2\u02de\u02f0\3\2\2\2\u02df\u02e0\7\36\2\2\u02e0\u02e1\5H%\2\u02e1"+
		"\u02e2\b#\1\2\u02e2\u02f0\3\2\2\2\u02e3\u02e4\7\35\2\2\u02e4\u02e5\5H"+
		"%\2\u02e5\u02e6\b#\1\2\u02e6\u02f0\3\2\2\2\u02e7\u02e9\5F$\2\u02e8\u02ea"+
		"\5F$\2\u02e9\u02e8\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02e9\3\2\2\2\u02eb"+
		"\u02ec\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed\u02ee\b#\1\2\u02ee\u02f0\3\2"+
		"\2\2\u02ef\u02be\3\2\2\2\u02ef\u02c0\3\2\2\2\u02ef\u02c5\3\2\2\2\u02ef"+
		"\u02cb\3\2\2\2\u02ef\u02cd\3\2\2\2\u02ef\u02d2\3\2\2\2\u02ef\u02d6\3\2"+
		"\2\2\u02ef\u02da\3\2\2\2\u02ef\u02df\3\2\2\2\u02ef\u02e3\3\2\2\2\u02ef"+
		"\u02e7\3\2\2\2\u02f0\u0312\3\2\2\2\u02f1\u02f2\f\21\2\2\u02f2\u02f3\t"+
		"\5\2\2\u02f3\u0311\5D#\22\u02f4\u02f5\f\20\2\2\u02f5\u02f6\t\6\2\2\u02f6"+
		"\u0311\5D#\21\u02f7\u02f8\f\17\2\2\u02f8\u02f9\t\7\2\2\u02f9\u0311\5D"+
		"#\20\u02fa\u02fb\f\16\2\2\u02fb\u02fc\t\b\2\2\u02fc\u0311\5D#\17\u02fd"+
		"\u02fe\f\r\2\2\u02fe\u02ff\7\60\2\2\u02ff\u0311\5D#\16\u0300\u0301\f\f"+
		"\2\2\u0301\u0302\7\61\2\2\u0302\u0311\5D#\r\u0303\u0304\f\4\2\2\u0304"+
		"\u0306\t\t\2\2\u0305\u0307\t\t\2\2\u0306\u0305\3\2\2\2\u0307\u0308\3\2"+
		"\2\2\u0308\u0306\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u030a\3\2\2\2\u030a"+
		"\u030b\5D#\5\u030b\u030c\b#\1\2\u030c\u0311\3\2\2\2\u030d\u030e\f\3\2"+
		"\2\u030e\u030f\t\t\2\2\u030f\u0311\b#\1\2\u0310\u02f1\3\2\2\2\u0310\u02f4"+
		"\3\2\2\2\u0310\u02f7\3\2\2\2\u0310\u02fa\3\2\2\2\u0310\u02fd\3\2\2\2\u0310"+
		"\u0300\3\2\2\2\u0310\u0303\3\2\2\2\u0310\u030d\3\2\2\2\u0311\u0314\3\2"+
		"\2\2\u0312\u0310\3\2\2\2\u0312\u0313\3\2\2\2\u0313E\3\2\2\2\u0314\u0312"+
		"\3\2\2\2\u0315\u0322\5H%\2\u0316\u0317\7:\2\2\u0317\u0318\7!\2\2\u0318"+
		"\u0319\5D#\2\u0319\u031a\7\"\2\2\u031a\u0322\3\2\2\2\u031b\u031c\7:\2"+
		"\2\u031c\u031e\7\35\2\2\u031d\u031f\5:\36\2\u031e\u031d\3\2\2\2\u031e"+
		"\u031f\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0322\7\36\2\2\u0321\u0315\3"+
		"\2\2\2\u0321\u0316\3\2\2\2\u0321\u031b\3\2\2\2\u0322G\3\2\2\2\u0323\u0324"+
		"\7\35\2\2\u0324\u0325\5D#\2\u0325\u0326\7\36\2\2\u0326\u032a\3\2\2\2\u0327"+
		"\u032a\5\34\17\2\u0328\u032a\7:\2\2\u0329\u0323\3\2\2\2\u0329\u0327\3"+
		"\2\2\2\u0329\u0328\3\2\2\2\u032aI\3\2\2\2]MTcpx}\u0082\u0087\u008e\u0093"+
		"\u0097\u009e\u00a4\u00a9\u00ad\u00b1\u00bc\u00c6\u00ce\u00d1\u00da\u00e1"+
		"\u00e9\u00f4\u00f8\u00fa\u0105\u010d\u0114\u011c\u011f\u0129\u0138\u0151"+
		"\u0168\u016a\u016c\u0171\u0174\u0183\u0185\u018a\u0194\u01a1\u01ae\u01b6"+
		"\u01b8\u01ba\u01bf\u01c7\u01d3\u01df\u01e7\u01e9\u01ef\u0201\u0207\u021e"+
		"\u0220\u0229\u022b\u022d\u0236\u0249\u0251\u0259\u025c\u0265\u026c\u0274"+
		"\u027f\u0283\u0285\u028a\u028f\u0295\u029a\u02a1\u02a6\u02aa\u02b0\u02bc"+
		"\u02c8\u02eb\u02ef\u0308\u0310\u0312\u031e\u0321\u0329";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}