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
		RULE_localVariableDeclaration = 17, RULE_statement = 18, RULE_errorInvocation = 19, 
		RULE_forStatement = 20, RULE_forheader = 21, RULE_forinitializer = 22, 
		RULE_customAssignError = 23, RULE_doStatement = 24, RULE_whileStatement = 25, 
		RULE_ifThenStatement = 26, RULE_printInvocation = 27, RULE_scanInvocation = 28, 
		RULE_expressionList = 29, RULE_statementExpression = 30, RULE_methodInvocation = 31, 
		RULE_conditionalExpression = 32, RULE_assignment = 33, RULE_invalidAssignment = 34, 
		RULE_expression = 35, RULE_unaryExpression = 36, RULE_primary = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "variableModifier", "mainDeclaration", "methodDeclaration", 
			"methodDeclarator", "variableDeclaratorList", "variableDeclarator", "variableInitializer", 
			"arrayInitializer", "result", "unannType", "formalParameters", "formalParameter", 
			"literal", "block", "blockStatement", "localVariableDeclarationStatement", 
			"localVariableDeclaration", "statement", "errorInvocation", "forStatement", 
			"forheader", "forinitializer", "customAssignError", "doStatement", "whileStatement", 
			"ifThenStatement", "printInvocation", "scanInvocation", "expressionList", 
			"statementExpression", "methodInvocation", "conditionalExpression", "assignment", 
			"invalidAssignment", "expression", "unaryExpression", "primary"
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(76);
				methodDeclaration();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			mainDeclaration();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(83);
				methodDeclaration();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
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
			setState(91);
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
			setState(93);
			match(MAIN);
			setState(94);
			match(LPAREN);
			setState(95);
			match(RPAREN);
			setState(96);
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
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(FUNC);
				setState(101);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case BOOL:
				case FLOAT:
				case INT:
					{
					setState(99);
					result();
					}
					break;
				case VOID:
					{
					setState(100);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(103);
				methodDeclarator();
				setState(104);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(FUNC);
				setState(107);
				methodDeclarator();
				setState(108);
				block();
				notifyErrorListeners("lacking return type");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(FUNC);
				setState(114);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case BOOL:
				case FLOAT:
				case INT:
					{
					setState(112);
					result();
					}
					break;
				case VOID:
					{
					setState(113);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(116);
				methodDeclarator();
				notifyErrorListeners("lacking function body");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				match(FUNC);
				setState(122);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case BOOL:
				case FLOAT:
				case INT:
					{
					setState(120);
					result();
					}
					break;
				case VOID:
					{
					setState(121);
					match(VOID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(124);
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
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(Identifier);
				setState(130);
				match(LPAREN);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT) | (1L << COMMA) | (1L << Identifier))) != 0)) {
					{
					setState(131);
					formalParameters(0);
					}
				}

				setState(134);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(LPAREN);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT) | (1L << COMMA) | (1L << Identifier))) != 0)) {
					{
					setState(136);
					formalParameters(0);
					}
				}

				setState(139);
				match(RPAREN);
				notifyErrorListeners("can't find function name");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				match(Identifier);
				setState(142);
				match(LPAREN);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT) | (1L << COMMA) | (1L << Identifier))) != 0)) {
					{
					setState(143);
					formalParameters(0);
					}
				}

				notifyErrorListeners("uneven parenthesis, lacking ')'");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				match(Identifier);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << BOOL) | (1L << FLOAT) | (1L << INT) | (1L << COMMA) | (1L << Identifier))) != 0)) {
					{
					setState(148);
					formalParameters(0);
					}
				}

				setState(151);
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
			setState(155);
			variableDeclarator();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(156);
				match(COMMA);
				setState(157);
				variableDeclarator();
				}
				}
				setState(162);
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
		public List<TerminalNode> ASSIGN() { return getTokens(PseudoCodeParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(PseudoCodeParser.ASSIGN, i);
		}
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<InvalidAssignmentContext> invalidAssignment() {
			return getRuleContexts(InvalidAssignmentContext.class);
		}
		public InvalidAssignmentContext invalidAssignment(int i) {
			return getRuleContext(InvalidAssignmentContext.class,i);
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
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(Identifier);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(164);
					match(ASSIGN);
					setState(165);
					variableInitializer();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(Identifier);
				setState(169);
				match(ASSIGN);
				setState(170);
				variableInitializer();
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(171);
					match(ASSIGN);
					setState(172);
					variableInitializer();
					}
					}
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ASSIGN );
				notifyErrorListeners("multiple assignment operators found");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				match(Identifier);
				setState(180);
				invalidAssignment();
				setState(181);
				variableInitializer();
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) {
					{
					{
					setState(182);
					invalidAssignment();
					setState(183);
					variableInitializer();
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				notifyErrorListeners("invalid operation found, multiple assignment operators found");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				unannType();
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(193);
					match(ASSIGN);
					setState(194);
					variableInitializer();
					}
				}

				notifyErrorListeners("declaring keyword as variable name");
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
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
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
				setState(202);
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
			setState(205);
			match(CREATE);
			setState(206);
			unannType();
			setState(207);
			match(LBRACK);
			setState(208);
			expression(0);
			setState(209);
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
			setState(211);
			unannType();
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(212);
				match(LBRACK);
				setState(213);
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
			setState(216);
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
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(219);
				formalParameter();
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(220);
						match(COMMA);
						setState(221);
						formalParameter();
						}
						} 
					}
					setState(226);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(235);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(227);
					formalParameter();
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(228);
						match(COMMA);
						setState(229);
						formalParameter();
						}
						}
						setState(234);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(237);
				formalParameter();
				setState(238);
				formalParameters(4);
				notifyErrorListeners("no separator found in parameters");
				}
				break;
			case 3:
				{
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(241);
						match(COMMA);
						}
						} 
					}
					setState(246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				setState(247);
				match(COMMA);
				setState(248);
				formalParameters(3);
				notifyErrorListeners("lacking parameter");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new FormalParametersContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formalParameters);
						setState(253);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(254);
						match(COMMA);
						setState(255);
						match(COMMA);
						setState(259);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(256);
								match(COMMA);
								}
								} 
							}
							setState(261);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
						}
						setState(262);
						formalParameters(2);
						notifyErrorListeners("lacking parameter");
						}
						break;
					case 2:
						{
						_localctx = new FormalParametersContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_formalParameters);
						setState(265);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(266);
						match(COMMA);
						setState(270);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(267);
								match(COMMA);
								}
								} 
							}
							setState(272);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
						}
						notifyErrorListeners("lacking parameter");
						}
						break;
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				result();
				setState(280);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(Identifier);
				notifyErrorListeners("no specified data type");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
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
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(IntegerLiteral);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(IntegerLiteral);
				setState(291);
				match(DOT);
				setState(292);
				match(IntegerLiteral);
				notifyErrorListeners("invalid format for 'FLOAT', must have 'f' at the end");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(294);
				match(FloatingPointLiteral);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(295);
				match(StringLiteral);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(296);
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
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				match(LBRACE);
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << SCAN) | (1L << STRING) | (1L << CONSTANT) | (1L << BOOL) | (1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << WHILE) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << LPAREN) | (1L << RPAREN) | (1L << LBRACE) | (1L << SEMI) | (1L << BANG) | (1L << Identifier))) != 0)) {
					{
					{
					setState(300);
					blockStatement();
					}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(306);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(LBRACE);
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(308);
						blockStatement();
						}
						} 
					}
					setState(313);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				localVariableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
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
			setState(330);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				localVariableDeclaration();
				setState(325);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
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
			setState(343);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
			case CONSTANT:
			case BOOL:
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONSTANT) {
					{
					setState(332);
					variableModifier();
					}
				}

				setState(335);
				result();
				setState(336);
				variableDeclaratorList();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				match(Identifier);
				setState(339);
				result();
				setState(340);
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
		public ErrorInvocationContext errorInvocation() {
			return getRuleContext(ErrorInvocationContext.class,0);
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
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				ifThenStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(347);
				whileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(348);
				doStatement();
				setState(349);
				match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(351);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(352);
				printInvocation();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(353);
				match(RETURN);
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << LPAREN) | (1L << RPAREN) | (1L << BANG) | (1L << Identifier))) != 0)) {
					{
					setState(354);
					expression(0);
					}
				}

				setState(357);
				match(SEMI);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(358);
				match(RETURN);
				setState(359);
				result();
				setState(360);
				match(SEMI);
				notifyErrorListeners("cannot return data type");
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(363);
				match(BREAK);
				setState(364);
				match(SEMI);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(365);
				match(CONTINUE);
				setState(366);
				match(SEMI);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(367);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(368);
				statementExpression();
				setState(369);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(371);
				statementExpression();
				notifyErrorListeners("lacking ';' at the end of line");
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(374);
				scanInvocation();
				setState(375);
				match(SEMI);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(377);
				scanInvocation();
				notifyErrorListeners("lacking ';' at the end of line");
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(380);
				errorInvocation();
				setState(381);
				match(SEMI);
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

	public static class ErrorInvocationContext extends ParserRuleContext {
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
		public ErrorInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterErrorInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitErrorInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitErrorInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorInvocationContext errorInvocation() throws RecognitionException {
		ErrorInvocationContext _localctx = new ErrorInvocationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_errorInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(Identifier);
			setState(386);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(388); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(387);
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
				setState(390); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0) );
			notifyErrorListeners("redundant arithmetic operator symbol found");
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
		enterRule(_localctx, 40, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			forheader();
			setState(395);
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
		enterRule(_localctx, 42, RULE_forheader);
		int _la;
		try {
			int _alt;
			setState(424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				match(FOR);
				setState(398);
				forinitializer();
				setState(399);
				match(UPTO);
				setState(400);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				match(FOR);
				setState(403);
				forinitializer();
				setState(404);
				match(DOWNTO);
				setState(405);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(407);
				match(FOR);
				setState(408);
				forinitializer();
				setState(417); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(417);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case StringLiteral:
							{
							setState(409);
							match(StringLiteral);
							}
							break;
						case Identifier:
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
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(419); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(421);
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
		enterRule(_localctx, 44, RULE_forinitializer);
		int _la;
		try {
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INT) {
					{
					setState(426);
					match(INT);
					}
				}

				setState(429);
				match(Identifier);
				setState(430);
				customAssignError();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				match(Identifier);
				setState(432);
				match(LBRACK);
				setState(433);
				expression(0);
				setState(434);
				match(RBRACK);
				setState(435);
				customAssignError();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(437);
				match(Identifier);
				setState(442);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(438);
					match(LBRACK);
					setState(439);
					expression(0);
					setState(440);
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
		enterRule(_localctx, 46, RULE_customAssignError);
		try {
			setState(449);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				match(ASSIGN);
				setState(447);
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
		enterRule(_localctx, 48, RULE_doStatement);
		int _la;
		try {
			int _alt;
			setState(502);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(451);
				match(DO);
				setState(452);
				block();
				setState(453);
				match(WHILE);
				setState(454);
				match(Identifier);
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(455);
					match(LBRACK);
					setState(456);
					expression(0);
					setState(457);
					match(RBRACK);
					}
				}

				setState(461);
				match(UPTO);
				setState(462);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(464);
				match(DO);
				setState(465);
				block();
				setState(466);
				match(WHILE);
				setState(467);
				match(Identifier);
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(468);
					match(LBRACK);
					setState(469);
					expression(0);
					setState(470);
					match(RBRACK);
					}
				}

				setState(474);
				match(DOWNTO);
				setState(475);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(477);
				match(DO);
				setState(478);
				block();
				setState(479);
				match(WHILE);
				setState(480);
				match(Identifier);
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(481);
					match(LBRACK);
					setState(482);
					expression(0);
					setState(483);
					match(RBRACK);
					}
				}

				setState(495); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(495);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case StringLiteral:
							{
							setState(487);
							match(StringLiteral);
							}
							break;
						case Identifier:
							{
							setState(488);
							match(Identifier);
							setState(493);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LBRACK) {
								{
								setState(489);
								match(LBRACK);
								setState(490);
								expression(0);
								setState(491);
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
					setState(497); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(499);
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
		enterRule(_localctx, 50, RULE_whileStatement);
		int _la;
		try {
			int _alt;
			setState(550);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(504);
				match(WHILE);
				setState(505);
				match(Identifier);
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(506);
					match(LBRACK);
					setState(507);
					expression(0);
					setState(508);
					match(RBRACK);
					}
				}

				setState(512);
				match(UPTO);
				setState(513);
				expression(0);
				setState(514);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(516);
				match(WHILE);
				setState(517);
				match(Identifier);
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(518);
					match(LBRACK);
					setState(519);
					expression(0);
					setState(520);
					match(RBRACK);
					}
				}

				setState(524);
				match(DOWNTO);
				setState(525);
				expression(0);
				setState(526);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(528);
				match(WHILE);
				setState(529);
				match(Identifier);
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(530);
					match(LBRACK);
					setState(531);
					expression(0);
					setState(532);
					match(RBRACK);
					}
				}

				setState(542); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(542);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case StringLiteral:
							{
							setState(536);
							match(StringLiteral);
							}
							break;
						case Identifier:
							{
							setState(537);
							match(Identifier);
							{
							setState(538);
							match(LBRACK);
							setState(539);
							expression(0);
							setState(540);
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
					setState(544); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(546);
				expression(0);
				setState(547);
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
		enterRule(_localctx, 52, RULE_ifThenStatement);
		try {
			setState(597);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(552);
				match(IF);
				setState(553);
				match(LPAREN);
				setState(554);
				conditionalExpression();
				setState(555);
				match(RPAREN);
				setState(556);
				match(THEN);
				setState(557);
				block();
				setState(564);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(558);
					match(ELSE);
					setState(562);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case THEN:
						{
						setState(559);
						match(THEN);
						setState(560);
						block();
						}
						break;
					case IF:
						{
						setState(561);
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
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(566);
				match(IF);
				setState(567);
				match(LPAREN);
				setState(568);
				conditionalExpression();
				setState(569);
				match(RPAREN);
				setState(570);
				block();
				setState(577);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
				case 1:
					{
					setState(571);
					match(ELSE);
					setState(575);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case THEN:
						{
						setState(572);
						match(THEN);
						setState(573);
						block();
						}
						break;
					case IF:
						{
						setState(574);
						ifThenStatement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				notifyErrorListeners("lacking 'then' keyword to if statement");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(581);
				match(IF);
				setState(582);
				match(LPAREN);
				setState(583);
				conditionalExpression();
				setState(584);
				match(RPAREN);
				setState(585);
				match(THEN);
				setState(586);
				block();
				setState(593);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(587);
					match(ELSE);
					setState(591);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case THEN:
						{
						setState(588);
						match(THEN);
						setState(589);
						block();
						}
						break;
					case IF:
						{
						setState(590);
						ifThenStatement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				notifyErrorListeners("lacking 'then' keyword to else statement");
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
		public List<TerminalNode> SEMI() { return getTokens(PseudoCodeParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PseudoCodeParser.SEMI, i);
		}
		public TerminalNode ADD() { return getToken(PseudoCodeParser.ADD, 0); }
		public TerminalNode DQUOTE() { return getToken(PseudoCodeParser.DQUOTE, 0); }
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
		enterRule(_localctx, 54, RULE_printInvocation);
		int _la;
		try {
			setState(684);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(599);
				match(PRINT);
				setState(600);
				match(LPAREN);
				setState(601);
				expression(0);
				setState(602);
				match(RPAREN);
				setState(603);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(605);
				match(PRINT);
				setState(606);
				match(LPAREN);
				setState(607);
				expression(0);
				setState(608);
				match(RPAREN);
				notifyErrorListeners("lacking ';' at the end of line");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(611);
				match(PRINT);
				setState(612);
				match(LPAREN);
				setState(613);
				expression(0);
				setState(614);
				match(ADD);
				setState(615);
				match(RPAREN);
				setState(616);
				match(SEMI);
				notifyErrorListeners("additional ‘+’ sign at end of print");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(619);
				match(PRINT);
				setState(620);
				match(LPAREN);
				setState(621);
				match(DQUOTE);
				{
				setState(631);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case StringLiteral:
					{
					setState(622);
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
					setState(623);
					_la = _input.LA(1);
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << RPAREN) | (1L << SEMI) | (1L << Identifier))) != 0)) ) {
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
					setState(624);
					match(Identifier);
					setState(629);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
					case 1:
						{
						setState(625);
						match(LBRACK);
						setState(626);
						expression(0);
						setState(627);
						match(RBRACK);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(642); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(642);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case StringLiteral:
						{
						setState(633);
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
						setState(634);
						_la = _input.LA(1);
						if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << RPAREN) | (1L << SEMI) | (1L << Identifier))) != 0)) ) {
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
						setState(635);
						match(Identifier);
						setState(640);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
						case 1:
							{
							setState(636);
							match(LBRACK);
							setState(637);
							expression(0);
							setState(638);
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
					setState(644); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << SCAN) | (1L << FUNC) | (1L << MAIN) | (1L << STRING) | (1L << CONSTANT) | (1L << CREATE) | (1L << THEN) | (1L << BOOL) | (1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << ELSE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << VOID) | (1L << WHILE) | (1L << UPTO) | (1L << DOWNTO) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << RBRACE) | (1L << LBRACK) | (1L << RBRACK) | (1L << COMMA) | (1L << ASSIGN) | (1L << DOT) | (1L << GT) | (1L << LT) | (1L << BANG) | (1L << TILDE) | (1L << QUESTION) | (1L << COLON) | (1L << EQUAL) | (1L << LE) | (1L << GE) | (1L << NOTEQUAL) | (1L << AND) | (1L << OR) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << BSLASH) | (1L << BITAND) | (1L << BITOR) | (1L << CARET) | (1L << MOD) | (1L << DQUOTE) | (1L << Identifier) | (1L << WS) | (1L << COMMENT) | (1L << LINE_COMMENT))) != 0) );
				}
				setState(646);
				match(RPAREN);
				setState(647);
				match(SEMI);
				notifyErrorListeners("lacking 'double quotes' in print statement");
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(649);
				match(PRINT);
				setState(650);
				match(LPAREN);
				{
				setState(660);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case StringLiteral:
					{
					setState(651);
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
					setState(652);
					_la = _input.LA(1);
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << RPAREN) | (1L << SEMI) | (1L << Identifier))) != 0)) ) {
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
					setState(653);
					match(Identifier);
					setState(658);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
					case 1:
						{
						setState(654);
						match(LBRACK);
						setState(655);
						expression(0);
						setState(656);
						match(RBRACK);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(671); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(671);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case StringLiteral:
						{
						setState(662);
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
						setState(663);
						_la = _input.LA(1);
						if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << RPAREN) | (1L << SEMI) | (1L << Identifier))) != 0)) ) {
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
						setState(664);
						match(Identifier);
						setState(669);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
						case 1:
							{
							setState(665);
							match(LBRACK);
							setState(666);
							expression(0);
							setState(667);
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
					setState(673); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PRINT) | (1L << SCAN) | (1L << FUNC) | (1L << MAIN) | (1L << STRING) | (1L << CONSTANT) | (1L << CREATE) | (1L << THEN) | (1L << BOOL) | (1L << BREAK) | (1L << CONTINUE) | (1L << DO) | (1L << ELSE) | (1L << FLOAT) | (1L << FOR) | (1L << IF) | (1L << INT) | (1L << RETURN) | (1L << VOID) | (1L << WHILE) | (1L << UPTO) | (1L << DOWNTO) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << BooleanLiteral) | (1L << StringLiteral) | (1L << LPAREN) | (1L << LBRACE) | (1L << RBRACE) | (1L << LBRACK) | (1L << RBRACK) | (1L << COMMA) | (1L << ASSIGN) | (1L << DOT) | (1L << GT) | (1L << LT) | (1L << BANG) | (1L << TILDE) | (1L << QUESTION) | (1L << COLON) | (1L << EQUAL) | (1L << LE) | (1L << GE) | (1L << NOTEQUAL) | (1L << AND) | (1L << OR) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << BSLASH) | (1L << BITAND) | (1L << BITOR) | (1L << CARET) | (1L << MOD) | (1L << DQUOTE) | (1L << Identifier) | (1L << WS) | (1L << COMMENT) | (1L << LINE_COMMENT))) != 0) );
				}
				setState(675);
				match(RPAREN);
				setState(676);
				match(SEMI);
				notifyErrorListeners("lacking 'double quotes' in print statement");
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(678);
				match(PRINT);
				setState(679);
				match(LPAREN);
				setState(680);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << StringLiteral) | (1L << RPAREN) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(681);
				match(RPAREN);
				setState(682);
				match(SEMI);
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
		enterRule(_localctx, 56, RULE_scanInvocation);
		try {
			setState(703);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(686);
				match(SCAN);
				setState(687);
				match(LPAREN);
				setState(688);
				expression(0);
				setState(689);
				match(COMMA);
				setState(690);
				match(Identifier);
				setState(691);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(693);
				match(SCAN);
				setState(694);
				match(LPAREN);
				setState(695);
				expression(0);
				setState(696);
				match(COMMA);
				setState(697);
				match(Identifier);
				setState(698);
				match(LBRACK);
				setState(699);
				expression(0);
				setState(700);
				match(RBRACK);
				setState(701);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expressionList, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(738);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(706);
				expression(0);
				setState(711);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(707);
						match(COMMA);
						setState(708);
						expression(0);
						}
						} 
					}
					setState(713);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(722);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(714);
					expression(0);
					setState(719);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(715);
						match(COMMA);
						setState(716);
						expression(0);
						}
						}
						setState(721);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(724);
				expression(0);
				setState(725);
				expressionList(4);
				notifyErrorListeners("no separator found in parameters");
				}
				break;
			case 3:
				{
				setState(731);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(728);
						match(COMMA);
						}
						} 
					}
					setState(733);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				}
				setState(734);
				match(COMMA);
				setState(735);
				expressionList(3);
				notifyErrorListeners("lacking parameter");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(763);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(761);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionListContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionList);
						setState(740);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(741);
						match(COMMA);
						setState(742);
						match(COMMA);
						setState(746);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(743);
								match(COMMA);
								}
								} 
							}
							setState(748);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
						}
						setState(749);
						expressionList(2);
						notifyErrorListeners("lacking parameter");
						}
						break;
					case 2:
						{
						_localctx = new ExpressionListContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressionList);
						setState(752);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(753);
						match(COMMA);
						setState(757);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(754);
								match(COMMA);
								}
								} 
							}
							setState(759);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
						}
						notifyErrorListeners("lacking parameter");
						}
						break;
					}
					} 
				}
				setState(765);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
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
		enterRule(_localctx, 60, RULE_statementExpression);
		try {
			setState(768);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(766);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(767);
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
		enterRule(_localctx, 62, RULE_methodInvocation);
		try {
			setState(800);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(770);
				match(Identifier);
				setState(771);
				match(LPAREN);
				setState(773);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(772);
					expressionList(0);
					}
					break;
				}
				setState(775);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(776);
				match(Identifier);
				setState(777);
				match(LPAREN);
				setState(779);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(778);
					expressionList(0);
					}
					break;
				}
				setState(781);
				match(RPAREN);
				setState(782);
				match(LPAREN);
				setState(784);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
				case 1:
					{
					setState(783);
					expressionList(0);
					}
					break;
				}
				setState(786);
				match(RPAREN);
				notifyErrorListeners("redundant parentheses");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(788);
				match(Identifier);
				setState(789);
				match(LPAREN);
				setState(791);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(790);
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
				setState(794);
				match(Identifier);
				setState(796);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(795);
					expressionList(0);
					}
					break;
				}
				setState(798);
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
		enterRule(_localctx, 64, RULE_conditionalExpression);
		try {
			setState(806);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(802);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(803);
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
		public List<TerminalNode> ASSIGN() { return getTokens(PseudoCodeParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(PseudoCodeParser.ASSIGN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(PseudoCodeParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(PseudoCodeParser.RBRACK, 0); }
		public List<InvalidAssignmentContext> invalidAssignment() {
			return getRuleContexts(InvalidAssignmentContext.class);
		}
		public InvalidAssignmentContext invalidAssignment(int i) {
			return getRuleContext(InvalidAssignmentContext.class,i);
		}
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
		enterRule(_localctx, 66, RULE_assignment);
		int _la;
		try {
			setState(842);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(808);
				match(Identifier);
				setState(809);
				match(ASSIGN);
				setState(810);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(811);
				match(Identifier);
				setState(812);
				match(LBRACK);
				setState(813);
				expression(0);
				setState(814);
				match(RBRACK);
				setState(815);
				match(ASSIGN);
				setState(816);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(818);
				match(Identifier);
				setState(819);
				match(ASSIGN);
				setState(820);
				expression(0);
				setState(823); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(821);
					match(ASSIGN);
					setState(822);
					expression(0);
					}
					}
					setState(825); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ASSIGN );
				notifyErrorListeners("multiple assignment operators found");
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(829);
				match(Identifier);
				setState(830);
				invalidAssignment();
				setState(831);
				expression(0);
				setState(837);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) {
					{
					{
					setState(832);
					invalidAssignment();
					setState(833);
					expression(0);
					}
					}
					setState(839);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				notifyErrorListeners("invalid operation found, multiple assignment operators found");
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

	public static class InvalidAssignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(PseudoCodeParser.ASSIGN, 0); }
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
		public InvalidAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invalidAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).enterInvalidAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PseudoCodeListener ) ((PseudoCodeListener)listener).exitInvalidAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PseudoCodeVisitor ) return ((PseudoCodeVisitor<? extends T>)visitor).visitInvalidAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvalidAssignmentContext invalidAssignment() throws RecognitionException {
		InvalidAssignmentContext _localctx = new InvalidAssignmentContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_invalidAssignment);
		int _la;
		try {
			setState(868);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(845); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(844);
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
					setState(847); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0) );
				setState(849);
				match(ASSIGN);
				setState(853);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) {
					{
					{
					setState(850);
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
					setState(855);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(859);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) {
					{
					{
					setState(856);
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
					setState(861);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(862);
				match(ASSIGN);
				setState(864); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(863);
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
					setState(866); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0) );
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(922);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				{
				setState(871);
				primary();
				}
				break;
			case 2:
				{
				setState(872);
				match(Identifier);
				setState(873);
				match(LBRACK);
				setState(874);
				expression(0);
				setState(875);
				match(RBRACK);
				}
				break;
			case 3:
				{
				setState(877);
				match(Identifier);
				setState(878);
				match(LPAREN);
				setState(880);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
				case 1:
					{
					setState(879);
					expressionList(0);
					}
					break;
				}
				setState(882);
				match(RPAREN);
				}
				break;
			case 4:
				{
				{
				setState(883);
				match(BANG);
				}
				setState(884);
				match(LPAREN);
				setState(885);
				expression(0);
				setState(886);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(888);
				primary();
				setState(889);
				match(LPAREN);
				setState(890);
				match(RPAREN);
				notifyErrorListeners("redundant parenthesis");
				}
				break;
			case 6:
				{
				setState(893);
				primary();
				setState(894);
				match(RPAREN);
				notifyErrorListeners("uneven parenthesis, lacking '('");
				}
				break;
			case 7:
				{
				setState(897);
				primary();
				setState(898);
				match(LPAREN);
				notifyErrorListeners("uneven parenthesis, lacking ')'");
				}
				break;
			case 8:
				{
				setState(901);
				match(LPAREN);
				setState(902);
				match(RPAREN);
				setState(903);
				primary();
				notifyErrorListeners("redundant parenthesis");
				}
				break;
			case 9:
				{
				setState(906);
				match(RPAREN);
				setState(907);
				primary();
				notifyErrorListeners("uneven parenthesis, lacking '('");
				}
				break;
			case 10:
				{
				setState(910);
				match(LPAREN);
				setState(911);
				primary();
				notifyErrorListeners("uneven parenthesis, lacking ')'");
				}
				break;
			case 11:
				{
				setState(914);
				unaryExpression();
				setState(916); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(915);
						unaryExpression();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(918); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				notifyErrorListeners("no operators found between identifiers/functions");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(957);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(955);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(924);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(925);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(926);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(927);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(928);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(929);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(930);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(931);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(932);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(933);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(934);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(935);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(936);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(937);
						match(AND);
						setState(938);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(939);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(940);
						match(OR);
						setState(941);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(942);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(943);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(945); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(944);
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
							setState(947); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0) );
						setState(949);
						expression(3);
						notifyErrorListeners("redundant arithmetic operator symbol found");
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(952);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(953);
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
				setState(959);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
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
		enterRule(_localctx, 72, RULE_unaryExpression);
		try {
			setState(972);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(960);
				primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(961);
				match(Identifier);
				setState(962);
				match(LBRACK);
				setState(963);
				expression(0);
				setState(964);
				match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(966);
				match(Identifier);
				setState(967);
				match(LPAREN);
				setState(969);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
				case 1:
					{
					setState(968);
					expressionList(0);
					}
					break;
				}
				setState(971);
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
		enterRule(_localctx, 74, RULE_primary);
		try {
			setState(980);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(974);
				match(LPAREN);
				setState(975);
				expression(0);
				setState(976);
				match(RPAREN);
				}
				break;
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(978);
				literal();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(979);
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
		case 29:
			return expressionList_sempred((ExpressionListContext)_localctx, predIndex);
		case 35:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u03d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\7\2P\n\2\f\2\16\2S\13"+
		"\2\3\2\3\2\7\2W\n\2\f\2\16\2Z\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\5\5h\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"u\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5}\n\5\3\5\3\5\3\5\5\5\u0082\n\5\3\6\3"+
		"\6\3\6\5\6\u0087\n\6\3\6\3\6\3\6\5\6\u008c\n\6\3\6\3\6\3\6\3\6\3\6\5\6"+
		"\u0093\n\6\3\6\3\6\3\6\5\6\u0098\n\6\3\6\3\6\5\6\u009c\n\6\3\7\3\7\3\7"+
		"\7\7\u00a1\n\7\f\7\16\7\u00a4\13\7\3\b\3\b\3\b\5\b\u00a9\n\b\3\b\3\b\3"+
		"\b\3\b\3\b\6\b\u00b0\n\b\r\b\16\b\u00b1\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\7\b\u00bc\n\b\f\b\16\b\u00bf\13\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c6\n\b"+
		"\3\b\3\b\5\b\u00ca\n\b\3\t\3\t\5\t\u00ce\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\5\13\u00d9\n\13\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00e1\n\r\f"+
		"\r\16\r\u00e4\13\r\3\r\3\r\3\r\7\r\u00e9\n\r\f\r\16\r\u00ec\13\r\5\r\u00ee"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u00f5\n\r\f\r\16\r\u00f8\13\r\3\r\3\r\3\r"+
		"\3\r\5\r\u00fe\n\r\3\r\3\r\3\r\3\r\7\r\u0104\n\r\f\r\16\r\u0107\13\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\7\r\u010f\n\r\f\r\16\r\u0112\13\r\3\r\7\r\u0115"+
		"\n\r\f\r\16\r\u0118\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u0122\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u012c\n\17\3"+
		"\20\3\20\7\20\u0130\n\20\f\20\16\20\u0133\13\20\3\20\3\20\3\20\7\20\u0138"+
		"\n\20\f\20\16\20\u013b\13\20\3\20\5\20\u013e\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u0145\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u014d\n\22\3"+
		"\23\5\23\u0150\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u015a"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0166\n\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0182"+
		"\n\24\3\25\3\25\3\25\6\25\u0187\n\25\r\25\16\25\u0188\3\25\3\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\5\27\u01a2\n\27\6\27\u01a4\n\27\r\27\16\27"+
		"\u01a5\3\27\3\27\3\27\5\27\u01ab\n\27\3\30\5\30\u01ae\n\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01bd\n\30"+
		"\5\30\u01bf\n\30\3\31\3\31\3\31\5\31\u01c4\n\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u01ce\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\5\32\u01db\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\5\32\u01e8\n\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32"+
		"\u01f0\n\32\6\32\u01f2\n\32\r\32\16\32\u01f3\3\32\3\32\3\32\5\32\u01f9"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0201\n\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u020d\n\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u0219\n\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\6\33\u0221\n\33\r\33\16\33\u0222\3\33\3\33\3\33\3\33\5\33\u0229\n\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0235\n\34\5\34"+
		"\u0237\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0242\n"+
		"\34\5\34\u0244\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u0252\n\34\5\34\u0254\n\34\3\34\3\34\5\34\u0258\n\34\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\5\35\u0278\n\35\5\35\u027a\n\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\5\35\u0283\n\35\6\35\u0285\n\35\r\35\16\35\u0286\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0295\n\35\5\35\u0297"+
		"\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u02a0\n\35\6\35\u02a2\n"+
		"\35\r\35\16\35\u02a3\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u02af\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\5\36\u02c2\n\36\3\37\3\37\3\37\3\37\7\37\u02c8"+
		"\n\37\f\37\16\37\u02cb\13\37\3\37\3\37\3\37\7\37\u02d0\n\37\f\37\16\37"+
		"\u02d3\13\37\5\37\u02d5\n\37\3\37\3\37\3\37\3\37\3\37\7\37\u02dc\n\37"+
		"\f\37\16\37\u02df\13\37\3\37\3\37\3\37\3\37\5\37\u02e5\n\37\3\37\3\37"+
		"\3\37\3\37\7\37\u02eb\n\37\f\37\16\37\u02ee\13\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\7\37\u02f6\n\37\f\37\16\37\u02f9\13\37\3\37\7\37\u02fc\n\37"+
		"\f\37\16\37\u02ff\13\37\3 \3 \5 \u0303\n \3!\3!\3!\5!\u0308\n!\3!\3!\3"+
		"!\3!\5!\u030e\n!\3!\3!\3!\5!\u0313\n!\3!\3!\3!\3!\3!\5!\u031a\n!\3!\3"+
		"!\3!\5!\u031f\n!\3!\3!\5!\u0323\n!\3\"\3\"\3\"\3\"\5\"\u0329\n\"\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\6#\u033a\n#\r#\16#\u033b\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\7#\u0346\n#\f#\16#\u0349\13#\3#\3#\5#\u034d\n#\3$"+
		"\6$\u0350\n$\r$\16$\u0351\3$\3$\7$\u0356\n$\f$\16$\u0359\13$\3$\7$\u035c"+
		"\n$\f$\16$\u035f\13$\3$\3$\6$\u0363\n$\r$\16$\u0364\5$\u0367\n$\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0373\n%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\6%\u0397\n%\r%\16%\u0398\3%\3%\5%\u039d\n%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\6%\u03b4\n%\r%\16%\u03b5\3%\3%\3"+
		"%\3%\3%\3%\7%\u03be\n%\f%\16%\u03c1\13%\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&"+
		"\u03cc\n&\3&\5&\u03cf\n&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u03d7\n\'\3\'\2\5"+
		"\30<H(\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BDFHJL\2\n\6\2\7\7\13\13\20\20\23\23\4\2\63\66;;\6\2\34\34\36\36##="+
		"=\5\2\34\34\36\36==\4\2\65\66;;\3\2\63\64\4\2\'(./\4\2--\60\60\2\u0461"+
		"\2Q\3\2\2\2\4]\3\2\2\2\6_\3\2\2\2\b\u0081\3\2\2\2\n\u009b\3\2\2\2\f\u009d"+
		"\3\2\2\2\16\u00c9\3\2\2\2\20\u00cd\3\2\2\2\22\u00cf\3\2\2\2\24\u00d5\3"+
		"\2\2\2\26\u00da\3\2\2\2\30\u00fd\3\2\2\2\32\u0121\3\2\2\2\34\u012b\3\2"+
		"\2\2\36\u013d\3\2\2\2 \u0144\3\2\2\2\"\u014c\3\2\2\2$\u0159\3\2\2\2&\u0181"+
		"\3\2\2\2(\u0183\3\2\2\2*\u018c\3\2\2\2,\u01aa\3\2\2\2.\u01be\3\2\2\2\60"+
		"\u01c3\3\2\2\2\62\u01f8\3\2\2\2\64\u0228\3\2\2\2\66\u0257\3\2\2\28\u02ae"+
		"\3\2\2\2:\u02c1\3\2\2\2<\u02e4\3\2\2\2>\u0302\3\2\2\2@\u0322\3\2\2\2B"+
		"\u0328\3\2\2\2D\u034c\3\2\2\2F\u0366\3\2\2\2H\u039c\3\2\2\2J\u03ce\3\2"+
		"\2\2L\u03d6\3\2\2\2NP\5\b\5\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2"+
		"RT\3\2\2\2SQ\3\2\2\2TX\5\6\4\2UW\5\b\5\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2"+
		"XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\2\2\3\\\3\3\2\2\2]^\7\b\2\2^\5\3\2"+
		"\2\2_`\7\6\2\2`a\7\35\2\2ab\7\36\2\2bc\5\36\20\2c\7\3\2\2\2dg\7\5\2\2"+
		"eh\5\24\13\2fh\7\25\2\2ge\3\2\2\2gf\3\2\2\2hi\3\2\2\2ij\5\n\6\2jk\5\36"+
		"\20\2k\u0082\3\2\2\2lm\7\5\2\2mn\5\n\6\2no\5\36\20\2op\b\5\1\2p\u0082"+
		"\3\2\2\2qt\7\5\2\2ru\5\24\13\2su\7\25\2\2tr\3\2\2\2ts\3\2\2\2uv\3\2\2"+
		"\2vw\5\n\6\2wx\b\5\1\2x\u0082\3\2\2\2y|\7\5\2\2z}\5\24\13\2{}\7\25\2\2"+
		"|z\3\2\2\2|{\3\2\2\2}~\3\2\2\2~\177\5\36\20\2\177\u0080\b\5\1\2\u0080"+
		"\u0082\3\2\2\2\u0081d\3\2\2\2\u0081l\3\2\2\2\u0081q\3\2\2\2\u0081y\3\2"+
		"\2\2\u0082\t\3\2\2\2\u0083\u0084\7=\2\2\u0084\u0086\7\35\2\2\u0085\u0087"+
		"\5\30\r\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2"+
		"\u0088\u009c\7\36\2\2\u0089\u008b\7\35\2\2\u008a\u008c\5\30\r\2\u008b"+
		"\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\36"+
		"\2\2\u008e\u009c\b\6\1\2\u008f\u0090\7=\2\2\u0090\u0092\7\35\2\2\u0091"+
		"\u0093\5\30\r\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u009c\b\6\1\2\u0095\u0097\7=\2\2\u0096\u0098\5\30\r\2\u0097"+
		"\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\36"+
		"\2\2\u009a\u009c\b\6\1\2\u009b\u0083\3\2\2\2\u009b\u0089\3\2\2\2\u009b"+
		"\u008f\3\2\2\2\u009b\u0095\3\2\2\2\u009c\13\3\2\2\2\u009d\u00a2\5\16\b"+
		"\2\u009e\u009f\7$\2\2\u009f\u00a1\5\16\b\2\u00a0\u009e\3\2\2\2\u00a1\u00a4"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\r\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u00a8\7=\2\2\u00a6\u00a7\7%\2\2\u00a7\u00a9\5\20"+
		"\t\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ca\3\2\2\2\u00aa"+
		"\u00ab\7=\2\2\u00ab\u00ac\7%\2\2\u00ac\u00af\5\20\t\2\u00ad\u00ae\7%\2"+
		"\2\u00ae\u00b0\5\20\t\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\b\b"+
		"\1\2\u00b4\u00ca\3\2\2\2\u00b5\u00b6\7=\2\2\u00b6\u00b7\5F$\2\u00b7\u00bd"+
		"\5\20\t\2\u00b8\u00b9\5F$\2\u00b9\u00ba\5\20\t\2\u00ba\u00bc\3\2\2\2\u00bb"+
		"\u00b8\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\b\b\1\2\u00c1"+
		"\u00ca\3\2\2\2\u00c2\u00c5\5\26\f\2\u00c3\u00c4\7%\2\2\u00c4\u00c6\5\20"+
		"\t\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c8\b\b\1\2\u00c8\u00ca\3\2\2\2\u00c9\u00a5\3\2\2\2\u00c9\u00aa\3\2"+
		"\2\2\u00c9\u00b5\3\2\2\2\u00c9\u00c2\3\2\2\2\u00ca\17\3\2\2\2\u00cb\u00ce"+
		"\5\22\n\2\u00cc\u00ce\5H%\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\21\3\2\2\2\u00cf\u00d0\7\t\2\2\u00d0\u00d1\5\26\f\2\u00d1\u00d2\7!\2"+
		"\2\u00d2\u00d3\5H%\2\u00d3\u00d4\7\"\2\2\u00d4\23\3\2\2\2\u00d5\u00d8"+
		"\5\26\f\2\u00d6\u00d7\7!\2\2\u00d7\u00d9\7\"\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\25\3\2\2\2\u00da\u00db\t\2\2\2\u00db\27\3\2\2\2\u00dc"+
		"\u00dd\b\r\1\2\u00dd\u00e2\5\32\16\2\u00de\u00df\7$\2\2\u00df\u00e1\5"+
		"\32\16\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00fe\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00ea\5\32"+
		"\16\2\u00e6\u00e7\7$\2\2\u00e7\u00e9\5\32\16\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ee\3\2"+
		"\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00e5\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f0\5\32\16\2\u00f0\u00f1\5\30\r\6\u00f1\u00f2"+
		"\b\r\1\2\u00f2\u00fe\3\2\2\2\u00f3\u00f5\7$\2\2\u00f4\u00f3\3\2\2\2\u00f5"+
		"\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2"+
		"\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\7$\2\2\u00fa\u00fb\5\30\r\5\u00fb"+
		"\u00fc\b\r\1\2\u00fc\u00fe\3\2\2\2\u00fd\u00dc\3\2\2\2\u00fd\u00ed\3\2"+
		"\2\2\u00fd\u00f6\3\2\2\2\u00fe\u0116\3\2\2\2\u00ff\u0100\f\3\2\2\u0100"+
		"\u0101\7$\2\2\u0101\u0105\7$\2\2\u0102\u0104\7$\2\2\u0103\u0102\3\2\2"+
		"\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108"+
		"\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\5\30\r\4\u0109\u010a\b\r\1\2"+
		"\u010a\u0115\3\2\2\2\u010b\u010c\f\4\2\2\u010c\u0110\7$\2\2\u010d\u010f"+
		"\7$\2\2\u010e\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0115\b\r"+
		"\1\2\u0114\u00ff\3\2\2\2\u0114\u010b\3\2\2\2\u0115\u0118\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\31\3\2\2\2\u0118\u0116\3\2\2"+
		"\2\u0119\u011a\5\24\13\2\u011a\u011b\7=\2\2\u011b\u0122\3\2\2\2\u011c"+
		"\u011d\7=\2\2\u011d\u0122\b\16\1\2\u011e\u011f\5\24\13\2\u011f\u0120\b"+
		"\16\1\2\u0120\u0122\3\2\2\2\u0121\u0119\3\2\2\2\u0121\u011c\3\2\2\2\u0121"+
		"\u011e\3\2\2\2\u0122\33\3\2\2\2\u0123\u012c\7\31\2\2\u0124\u0125\7\31"+
		"\2\2\u0125\u0126\7&\2\2\u0126\u0127\7\31\2\2\u0127\u012c\b\17\1\2\u0128"+
		"\u012c\7\32\2\2\u0129\u012c\7\34\2\2\u012a\u012c\7\33\2\2\u012b\u0123"+
		"\3\2\2\2\u012b\u0124\3\2\2\2\u012b\u0128\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012a\3\2\2\2\u012c\35\3\2\2\2\u012d\u0131\7\37\2\2\u012e\u0130\5 \21"+
		"\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132"+
		"\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u013e\7 \2\2\u0135"+
		"\u0139\7\37\2\2\u0136\u0138\5 \21\2\u0137\u0136\3\2\2\2\u0138\u013b\3"+
		"\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013e\b\20\1\2\u013d\u012d\3\2\2\2\u013d\u0135\3"+
		"\2\2\2\u013e\37\3\2\2\2\u013f\u0145\5\"\22\2\u0140\u0145\5&\24\2\u0141"+
		"\u0142\5H%\2\u0142\u0143\b\21\1\2\u0143\u0145\3\2\2\2\u0144\u013f\3\2"+
		"\2\2\u0144\u0140\3\2\2\2\u0144\u0141\3\2\2\2\u0145!\3\2\2\2\u0146\u0147"+
		"\5$\23\2\u0147\u0148\7#\2\2\u0148\u014d\3\2\2\2\u0149\u014a\5$\23\2\u014a"+
		"\u014b\b\22\1\2\u014b\u014d\3\2\2\2\u014c\u0146\3\2\2\2\u014c\u0149\3"+
		"\2\2\2\u014d#\3\2\2\2\u014e\u0150\5\4\3\2\u014f\u014e\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152\5\24\13\2\u0152\u0153\5\f\7\2"+
		"\u0153\u015a\3\2\2\2\u0154\u0155\7=\2\2\u0155\u0156\5\24\13\2\u0156\u0157"+
		"\5\f\7\2\u0157\u0158\b\23\1\2\u0158\u015a\3\2\2\2\u0159\u014f\3\2\2\2"+
		"\u0159\u0154\3\2\2\2\u015a%\3\2\2\2\u015b\u0182\5\36\20\2\u015c\u0182"+
		"\5\66\34\2\u015d\u0182\5\64\33\2\u015e\u015f\5\62\32\2\u015f\u0160\7#"+
		"\2\2\u0160\u0182\3\2\2\2\u0161\u0182\5*\26\2\u0162\u0182\58\35\2\u0163"+
		"\u0165\7\24\2\2\u0164\u0166\5H%\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2"+
		"\2\2\u0166\u0167\3\2\2\2\u0167\u0182\7#\2\2\u0168\u0169\7\24\2\2\u0169"+
		"\u016a\5\24\13\2\u016a\u016b\7#\2\2\u016b\u016c\b\24\1\2\u016c\u0182\3"+
		"\2\2\2\u016d\u016e\7\f\2\2\u016e\u0182\7#\2\2\u016f\u0170\7\r\2\2\u0170"+
		"\u0182\7#\2\2\u0171\u0182\7#\2\2\u0172\u0173\5> \2\u0173\u0174\7#\2\2"+
		"\u0174\u0182\3\2\2\2\u0175\u0176\5> \2\u0176\u0177\b\24\1\2\u0177\u0182"+
		"\3\2\2\2\u0178\u0179\5:\36\2\u0179\u017a\7#\2\2\u017a\u0182\3\2\2\2\u017b"+
		"\u017c\5:\36\2\u017c\u017d\b\24\1\2\u017d\u0182\3\2\2\2\u017e\u017f\5"+
		"(\25\2\u017f\u0180\7#\2\2\u0180\u0182\3\2\2\2\u0181\u015b\3\2\2\2\u0181"+
		"\u015c\3\2\2\2\u0181\u015d\3\2\2\2\u0181\u015e\3\2\2\2\u0181\u0161\3\2"+
		"\2\2\u0181\u0162\3\2\2\2\u0181\u0163\3\2\2\2\u0181\u0168\3\2\2\2\u0181"+
		"\u016d\3\2\2\2\u0181\u016f\3\2\2\2\u0181\u0171\3\2\2\2\u0181\u0172\3\2"+
		"\2\2\u0181\u0175\3\2\2\2\u0181\u0178\3\2\2\2\u0181\u017b\3\2\2\2\u0181"+
		"\u017e\3\2\2\2\u0182\'\3\2\2\2\u0183\u0184\7=\2\2\u0184\u0186\t\3\2\2"+
		"\u0185\u0187\t\3\2\2\u0186\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0186"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\b\25\1\2"+
		"\u018b)\3\2\2\2\u018c\u018d\5,\27\2\u018d\u018e\5\36\20\2\u018e+\3\2\2"+
		"\2\u018f\u0190\7\21\2\2\u0190\u0191\5.\30\2\u0191\u0192\7\27\2\2\u0192"+
		"\u0193\5H%\2\u0193\u01ab\3\2\2\2\u0194\u0195\7\21\2\2\u0195\u0196\5.\30"+
		"\2\u0196\u0197\7\30\2\2\u0197\u0198\5H%\2\u0198\u01ab\3\2\2\2\u0199\u019a"+
		"\7\21\2\2\u019a\u01a3\5.\30\2\u019b\u01a4\7\34\2\2\u019c\u01a1\7=\2\2"+
		"\u019d\u019e\7!\2\2\u019e\u019f\5H%\2\u019f\u01a0\7\"\2\2\u01a0\u01a2"+
		"\3\2\2\2\u01a1\u019d\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3"+
		"\u019b\3\2\2\2\u01a3\u019c\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a3\3\2"+
		"\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\5H%\2\u01a8\u01a9"+
		"\b\27\1\2\u01a9\u01ab\3\2\2\2\u01aa\u018f\3\2\2\2\u01aa\u0194\3\2\2\2"+
		"\u01aa\u0199\3\2\2\2\u01ab-\3\2\2\2\u01ac\u01ae\7\23\2\2\u01ad\u01ac\3"+
		"\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\7=\2\2\u01b0"+
		"\u01bf\5\60\31\2\u01b1\u01b2\7=\2\2\u01b2\u01b3\7!\2\2\u01b3\u01b4\5H"+
		"%\2\u01b4\u01b5\7\"\2\2\u01b5\u01b6\5\60\31\2\u01b6\u01bf\3\2\2\2\u01b7"+
		"\u01bc\7=\2\2\u01b8\u01b9\7!\2\2\u01b9\u01ba\5H%\2\u01ba\u01bb\7\"\2\2"+
		"\u01bb\u01bd\3\2\2\2\u01bc\u01b8\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf"+
		"\3\2\2\2\u01be\u01ad\3\2\2\2\u01be\u01b1\3\2\2\2\u01be\u01b7\3\2\2\2\u01bf"+
		"/\3\2\2\2\u01c0\u01c1\7%\2\2\u01c1\u01c4\5H%\2\u01c2\u01c4\b\31\1\2\u01c3"+
		"\u01c0\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4\61\3\2\2\2\u01c5\u01c6\7\16\2"+
		"\2\u01c6\u01c7\5\36\20\2\u01c7\u01c8\7\26\2\2\u01c8\u01cd\7=\2\2\u01c9"+
		"\u01ca\7!\2\2\u01ca\u01cb\5H%\2\u01cb\u01cc\7\"\2\2\u01cc\u01ce\3\2\2"+
		"\2\u01cd\u01c9\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0"+
		"\7\27\2\2\u01d0\u01d1\5H%\2\u01d1\u01f9\3\2\2\2\u01d2\u01d3\7\16\2\2\u01d3"+
		"\u01d4\5\36\20\2\u01d4\u01d5\7\26\2\2\u01d5\u01da\7=\2\2\u01d6\u01d7\7"+
		"!\2\2\u01d7\u01d8\5H%\2\u01d8\u01d9\7\"\2\2\u01d9\u01db\3\2\2\2\u01da"+
		"\u01d6\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\7\30"+
		"\2\2\u01dd\u01de\5H%\2\u01de\u01f9\3\2\2\2\u01df\u01e0\7\16\2\2\u01e0"+
		"\u01e1\5\36\20\2\u01e1\u01e2\7\26\2\2\u01e2\u01e7\7=\2\2\u01e3\u01e4\7"+
		"!\2\2\u01e4\u01e5\5H%\2\u01e5\u01e6\7\"\2\2\u01e6\u01e8\3\2\2\2\u01e7"+
		"\u01e3\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01f1\3\2\2\2\u01e9\u01f2\7\34"+
		"\2\2\u01ea\u01ef\7=\2\2\u01eb\u01ec\7!\2\2\u01ec\u01ed\5H%\2\u01ed\u01ee"+
		"\7\"\2\2\u01ee\u01f0\3\2\2\2\u01ef\u01eb\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01f2\3\2\2\2\u01f1\u01e9\3\2\2\2\u01f1\u01ea\3\2\2\2\u01f2\u01f3\3\2"+
		"\2\2\u01f3\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5"+
		"\u01f6\5H%\2\u01f6\u01f7\b\32\1\2\u01f7\u01f9\3\2\2\2\u01f8\u01c5\3\2"+
		"\2\2\u01f8\u01d2\3\2\2\2\u01f8\u01df\3\2\2\2\u01f9\63\3\2\2\2\u01fa\u01fb"+
		"\7\26\2\2\u01fb\u0200\7=\2\2\u01fc\u01fd\7!\2\2\u01fd\u01fe\5H%\2\u01fe"+
		"\u01ff\7\"\2\2\u01ff\u0201\3\2\2\2\u0200\u01fc\3\2\2\2\u0200\u0201\3\2"+
		"\2\2\u0201\u0202\3\2\2\2\u0202\u0203\7\27\2\2\u0203\u0204\5H%\2\u0204"+
		"\u0205\5\36\20\2\u0205\u0229\3\2\2\2\u0206\u0207\7\26\2\2\u0207\u020c"+
		"\7=\2\2\u0208\u0209\7!\2\2\u0209\u020a\5H%\2\u020a\u020b\7\"\2\2\u020b"+
		"\u020d\3\2\2\2\u020c\u0208\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020e\3\2"+
		"\2\2\u020e\u020f\7\30\2\2\u020f\u0210\5H%\2\u0210\u0211\5\36\20\2\u0211"+
		"\u0229\3\2\2\2\u0212\u0213\7\26\2\2\u0213\u0218\7=\2\2\u0214\u0215\7!"+
		"\2\2\u0215\u0216\5H%\2\u0216\u0217\7\"\2\2\u0217\u0219\3\2\2\2\u0218\u0214"+
		"\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u0220\3\2\2\2\u021a\u0221\7\34\2\2"+
		"\u021b\u021c\7=\2\2\u021c\u021d\7!\2\2\u021d\u021e\5H%\2\u021e\u021f\7"+
		"\"\2\2\u021f\u0221\3\2\2\2\u0220\u021a\3\2\2\2\u0220\u021b\3\2\2\2\u0221"+
		"\u0222\3\2\2\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0224\3\2"+
		"\2\2\u0224\u0225\5H%\2\u0225\u0226\5\36\20\2\u0226\u0227\b\33\1\2\u0227"+
		"\u0229\3\2\2\2\u0228\u01fa\3\2\2\2\u0228\u0206\3\2\2\2\u0228\u0212\3\2"+
		"\2\2\u0229\65\3\2\2\2\u022a\u022b\7\22\2\2\u022b\u022c\7\35\2\2\u022c"+
		"\u022d\5B\"\2\u022d\u022e\7\36\2\2\u022e\u022f\7\n\2\2\u022f\u0236\5\36"+
		"\20\2\u0230\u0234\7\17\2\2\u0231\u0232\7\n\2\2\u0232\u0235\5\36\20\2\u0233"+
		"\u0235\5\66\34\2\u0234\u0231\3\2\2\2\u0234\u0233\3\2\2\2\u0235\u0237\3"+
		"\2\2\2\u0236\u0230\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0258\3\2\2\2\u0238"+
		"\u0239\7\22\2\2\u0239\u023a\7\35\2\2\u023a\u023b\5B\"\2\u023b\u023c\7"+
		"\36\2\2\u023c\u0243\5\36\20\2\u023d\u0241\7\17\2\2\u023e\u023f\7\n\2\2"+
		"\u023f\u0242\5\36\20\2\u0240\u0242\5\66\34\2\u0241\u023e\3\2\2\2\u0241"+
		"\u0240\3\2\2\2\u0242\u0244\3\2\2\2\u0243\u023d\3\2\2\2\u0243\u0244\3\2"+
		"\2\2\u0244\u0245\3\2\2\2\u0245\u0246\b\34\1\2\u0246\u0258\3\2\2\2\u0247"+
		"\u0248\7\22\2\2\u0248\u0249\7\35\2\2\u0249\u024a\5B\"\2\u024a\u024b\7"+
		"\36\2\2\u024b\u024c\7\n\2\2\u024c\u0253\5\36\20\2\u024d\u0251\7\17\2\2"+
		"\u024e\u024f\7\n\2\2\u024f\u0252\5\36\20\2\u0250\u0252\5\66\34\2\u0251"+
		"\u024e\3\2\2\2\u0251\u0250\3\2\2\2\u0252\u0254\3\2\2\2\u0253\u024d\3\2"+
		"\2\2\u0253\u0254\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0256\b\34\1\2\u0256"+
		"\u0258\3\2\2\2\u0257\u022a\3\2\2\2\u0257\u0238\3\2\2\2\u0257\u0247\3\2"+
		"\2\2\u0258\67\3\2\2\2\u0259\u025a\7\3\2\2\u025a\u025b\7\35\2\2\u025b\u025c"+
		"\5H%\2\u025c\u025d\7\36\2\2\u025d\u025e\7#\2\2\u025e\u02af\3\2\2\2\u025f"+
		"\u0260\7\3\2\2\u0260\u0261\7\35\2\2\u0261\u0262\5H%\2\u0262\u0263\7\36"+
		"\2\2\u0263\u0264\b\35\1\2\u0264\u02af\3\2\2\2\u0265\u0266\7\3\2\2\u0266"+
		"\u0267\7\35\2\2\u0267\u0268\5H%\2\u0268\u0269\7\63\2\2\u0269\u026a\7\36"+
		"\2\2\u026a\u026b\7#\2\2\u026b\u026c\b\35\1\2\u026c\u02af\3\2\2\2\u026d"+
		"\u026e\7\3\2\2\u026e\u026f\7\35\2\2\u026f\u0279\7<\2\2\u0270\u027a\7\34"+
		"\2\2\u0271\u027a\n\4\2\2\u0272\u0277\7=\2\2\u0273\u0274\7!\2\2\u0274\u0275"+
		"\5H%\2\u0275\u0276\7\"\2\2\u0276\u0278\3\2\2\2\u0277\u0273\3\2\2\2\u0277"+
		"\u0278\3\2\2\2\u0278\u027a\3\2\2\2\u0279\u0270\3\2\2\2\u0279\u0271\3\2"+
		"\2\2\u0279\u0272\3\2\2\2\u027a\u0284\3\2\2\2\u027b\u0285\7\34\2\2\u027c"+
		"\u0285\n\4\2\2\u027d\u0282\7=\2\2\u027e\u027f\7!\2\2\u027f\u0280\5H%\2"+
		"\u0280\u0281\7\"\2\2\u0281\u0283\3\2\2\2\u0282\u027e\3\2\2\2\u0282\u0283"+
		"\3\2\2\2\u0283\u0285\3\2\2\2\u0284\u027b\3\2\2\2\u0284\u027c\3\2\2\2\u0284"+
		"\u027d\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0284\3\2\2\2\u0286\u0287\3\2"+
		"\2\2\u0287\u0288\3\2\2\2\u0288\u0289\7\36\2\2\u0289\u028a\7#\2\2\u028a"+
		"\u02af\b\35\1\2\u028b\u028c\7\3\2\2\u028c\u0296\7\35\2\2\u028d\u0297\7"+
		"\34\2\2\u028e\u0297\n\4\2\2\u028f\u0294\7=\2\2\u0290\u0291\7!\2\2\u0291"+
		"\u0292\5H%\2\u0292\u0293\7\"\2\2\u0293\u0295\3\2\2\2\u0294\u0290\3\2\2"+
		"\2\u0294\u0295\3\2\2\2\u0295\u0297\3\2\2\2\u0296\u028d\3\2\2\2\u0296\u028e"+
		"\3\2\2\2\u0296\u028f\3\2\2\2\u0297\u02a1\3\2\2\2\u0298\u02a2\7\34\2\2"+
		"\u0299\u02a2\n\4\2\2\u029a\u029f\7=\2\2\u029b\u029c\7!\2\2\u029c\u029d"+
		"\5H%\2\u029d\u029e\7\"\2\2\u029e\u02a0\3\2\2\2\u029f\u029b\3\2\2\2\u029f"+
		"\u02a0\3\2\2\2\u02a0\u02a2\3\2\2\2\u02a1\u0298\3\2\2\2\u02a1\u0299\3\2"+
		"\2\2\u02a1\u029a\3\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a3"+
		"\u02a4\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a6\7\36\2\2\u02a6\u02a7\7"+
		"#\2\2\u02a7\u02af\b\35\1\2\u02a8\u02a9\7\3\2\2\u02a9\u02aa\7\35\2\2\u02aa"+
		"\u02ab\n\5\2\2\u02ab\u02ac\7\36\2\2\u02ac\u02ad\7#\2\2\u02ad\u02af\b\35"+
		"\1\2\u02ae\u0259\3\2\2\2\u02ae\u025f\3\2\2\2\u02ae\u0265\3\2\2\2\u02ae"+
		"\u026d\3\2\2\2\u02ae\u028b\3\2\2\2\u02ae\u02a8\3\2\2\2\u02af9\3\2\2\2"+
		"\u02b0\u02b1\7\4\2\2\u02b1\u02b2\7\35\2\2\u02b2\u02b3\5H%\2\u02b3\u02b4"+
		"\7$\2\2\u02b4\u02b5\7=\2\2\u02b5\u02b6\7\36\2\2\u02b6\u02c2\3\2\2\2\u02b7"+
		"\u02b8\7\4\2\2\u02b8\u02b9\7\35\2\2\u02b9\u02ba\5H%\2\u02ba\u02bb\7$\2"+
		"\2\u02bb\u02bc\7=\2\2\u02bc\u02bd\7!\2\2\u02bd\u02be\5H%\2\u02be\u02bf"+
		"\7\"\2\2\u02bf\u02c0\7\36\2\2\u02c0\u02c2\3\2\2\2\u02c1\u02b0\3\2\2\2"+
		"\u02c1\u02b7\3\2\2\2\u02c2;\3\2\2\2\u02c3\u02c4\b\37\1\2\u02c4\u02c9\5"+
		"H%\2\u02c5\u02c6\7$\2\2\u02c6\u02c8\5H%\2\u02c7\u02c5\3\2\2\2\u02c8\u02cb"+
		"\3\2\2\2\u02c9\u02c7\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02e5\3\2\2\2\u02cb"+
		"\u02c9\3\2\2\2\u02cc\u02d1\5H%\2\u02cd\u02ce\7$\2\2\u02ce\u02d0\5H%\2"+
		"\u02cf\u02cd\3\2\2\2\u02d0\u02d3\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d1\u02d2"+
		"\3\2\2\2\u02d2\u02d5\3\2\2\2\u02d3\u02d1\3\2\2\2\u02d4\u02cc\3\2\2\2\u02d4"+
		"\u02d5\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d7\5H%\2\u02d7\u02d8\5<\37"+
		"\6\u02d8\u02d9\b\37\1\2\u02d9\u02e5\3\2\2\2\u02da\u02dc\7$\2\2\u02db\u02da"+
		"\3\2\2\2\u02dc\u02df\3\2\2\2\u02dd\u02db\3\2\2\2\u02dd\u02de\3\2\2\2\u02de"+
		"\u02e0\3\2\2\2\u02df\u02dd\3\2\2\2\u02e0\u02e1\7$\2\2\u02e1\u02e2\5<\37"+
		"\5\u02e2\u02e3\b\37\1\2\u02e3\u02e5\3\2\2\2\u02e4\u02c3\3\2\2\2\u02e4"+
		"\u02d4\3\2\2\2\u02e4\u02dd\3\2\2\2\u02e5\u02fd\3\2\2\2\u02e6\u02e7\f\3"+
		"\2\2\u02e7\u02e8\7$\2\2\u02e8\u02ec\7$\2\2\u02e9\u02eb\7$\2\2\u02ea\u02e9"+
		"\3\2\2\2\u02eb\u02ee\3\2\2\2\u02ec\u02ea\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed"+
		"\u02ef\3\2\2\2\u02ee\u02ec\3\2\2\2\u02ef\u02f0\5<\37\4\u02f0\u02f1\b\37"+
		"\1\2\u02f1\u02fc\3\2\2\2\u02f2\u02f3\f\4\2\2\u02f3\u02f7\7$\2\2\u02f4"+
		"\u02f6\7$\2\2\u02f5\u02f4\3\2\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2"+
		"\2\2\u02f7\u02f8\3\2\2\2\u02f8\u02fa\3\2\2\2\u02f9\u02f7\3\2\2\2\u02fa"+
		"\u02fc\b\37\1\2\u02fb\u02e6\3\2\2\2\u02fb\u02f2\3\2\2\2\u02fc\u02ff\3"+
		"\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe=\3\2\2\2\u02ff\u02fd"+
		"\3\2\2\2\u0300\u0303\5D#\2\u0301\u0303\5@!\2\u0302\u0300\3\2\2\2\u0302"+
		"\u0301\3\2\2\2\u0303?\3\2\2\2\u0304\u0305\7=\2\2\u0305\u0307\7\35\2\2"+
		"\u0306\u0308\5<\37\2\u0307\u0306\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0309"+
		"\3\2\2\2\u0309\u0323\7\36\2\2\u030a\u030b\7=\2\2\u030b\u030d\7\35\2\2"+
		"\u030c\u030e\5<\37\2\u030d\u030c\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u030f"+
		"\3\2\2\2\u030f\u0310\7\36\2\2\u0310\u0312\7\35\2\2\u0311\u0313\5<\37\2"+
		"\u0312\u0311\3\2\2\2\u0312\u0313\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0315"+
		"\7\36\2\2\u0315\u0323\b!\1\2\u0316\u0317\7=\2\2\u0317\u0319\7\35\2\2\u0318"+
		"\u031a\5<\37\2\u0319\u0318\3\2\2\2\u0319\u031a\3\2\2\2\u031a\u031b\3\2"+
		"\2\2\u031b\u0323\b!\1\2\u031c\u031e\7=\2\2\u031d\u031f\5<\37\2\u031e\u031d"+
		"\3\2\2\2\u031e\u031f\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0321\7\36\2\2"+
		"\u0321\u0323\b!\1\2\u0322\u0304\3\2\2\2\u0322\u030a\3\2\2\2\u0322\u0316"+
		"\3\2\2\2\u0322\u031c\3\2\2\2\u0323A\3\2\2\2\u0324\u0329\5H%\2\u0325\u0326"+
		"\5D#\2\u0326\u0327\b\"\1\2\u0327\u0329\3\2\2\2\u0328\u0324\3\2\2\2\u0328"+
		"\u0325\3\2\2\2\u0329C\3\2\2\2\u032a\u032b\7=\2\2\u032b\u032c\7%\2\2\u032c"+
		"\u034d\5H%\2\u032d\u032e\7=\2\2\u032e\u032f\7!\2\2\u032f\u0330\5H%\2\u0330"+
		"\u0331\7\"\2\2\u0331\u0332\7%\2\2\u0332\u0333\5H%\2\u0333\u034d\3\2\2"+
		"\2\u0334\u0335\7=\2\2\u0335\u0336\7%\2\2\u0336\u0339\5H%\2\u0337\u0338"+
		"\7%\2\2\u0338\u033a\5H%\2\u0339\u0337\3\2\2\2\u033a\u033b\3\2\2\2\u033b"+
		"\u0339\3\2\2\2\u033b\u033c\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033e\b#"+
		"\1\2\u033e\u034d\3\2\2\2\u033f\u0340\7=\2\2\u0340\u0341\5F$\2\u0341\u0347"+
		"\5H%\2\u0342\u0343\5F$\2\u0343\u0344\5H%\2\u0344\u0346\3\2\2\2\u0345\u0342"+
		"\3\2\2\2\u0346\u0349\3\2\2\2\u0347\u0345\3\2\2\2\u0347\u0348\3\2\2\2\u0348"+
		"\u034a\3\2\2\2\u0349\u0347\3\2\2\2\u034a\u034b\b#\1\2\u034b\u034d\3\2"+
		"\2\2\u034c\u032a\3\2\2\2\u034c\u032d\3\2\2\2\u034c\u0334\3\2\2\2\u034c"+
		"\u033f\3\2\2\2\u034dE\3\2\2\2\u034e\u0350\t\3\2\2\u034f\u034e\3\2\2\2"+
		"\u0350\u0351\3\2\2\2\u0351\u034f\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0353"+
		"\3\2\2\2\u0353\u0357\7%\2\2\u0354\u0356\t\3\2\2\u0355\u0354\3\2\2\2\u0356"+
		"\u0359\3\2\2\2\u0357\u0355\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u0367\3\2"+
		"\2\2\u0359\u0357\3\2\2\2\u035a\u035c\t\3\2\2\u035b\u035a\3\2\2\2\u035c"+
		"\u035f\3\2\2\2\u035d\u035b\3\2\2\2\u035d\u035e\3\2\2\2\u035e\u0360\3\2"+
		"\2\2\u035f\u035d\3\2\2\2\u0360\u0362\7%\2\2\u0361\u0363\t\3\2\2\u0362"+
		"\u0361\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u0362\3\2\2\2\u0364\u0365\3\2"+
		"\2\2\u0365\u0367\3\2\2\2\u0366\u034f\3\2\2\2\u0366\u035d\3\2\2\2\u0367"+
		"G\3\2\2\2\u0368\u0369\b%\1\2\u0369\u039d\5L\'\2\u036a\u036b\7=\2\2\u036b"+
		"\u036c\7!\2\2\u036c\u036d\5H%\2\u036d\u036e\7\"\2\2\u036e\u039d\3\2\2"+
		"\2\u036f\u0370\7=\2\2\u0370\u0372\7\35\2\2\u0371\u0373\5<\37\2\u0372\u0371"+
		"\3\2\2\2\u0372\u0373\3\2\2\2\u0373\u0374\3\2\2\2\u0374\u039d\7\36\2\2"+
		"\u0375\u0376\7)\2\2\u0376\u0377\7\35\2\2\u0377\u0378\5H%\2\u0378\u0379"+
		"\7\36\2\2\u0379\u039d\3\2\2\2\u037a\u037b\5L\'\2\u037b\u037c\7\35\2\2"+
		"\u037c\u037d\7\36\2\2\u037d\u037e\b%\1\2\u037e\u039d\3\2\2\2\u037f\u0380"+
		"\5L\'\2\u0380\u0381\7\36\2\2\u0381\u0382\b%\1\2\u0382\u039d\3\2\2\2\u0383"+
		"\u0384\5L\'\2\u0384\u0385\7\35\2\2\u0385\u0386\b%\1\2\u0386\u039d\3\2"+
		"\2\2\u0387\u0388\7\35\2\2\u0388\u0389\7\36\2\2\u0389\u038a\5L\'\2\u038a"+
		"\u038b\b%\1\2\u038b\u039d\3\2\2\2\u038c\u038d\7\36\2\2\u038d\u038e\5L"+
		"\'\2\u038e\u038f\b%\1\2\u038f\u039d\3\2\2\2\u0390\u0391\7\35\2\2\u0391"+
		"\u0392\5L\'\2\u0392\u0393\b%\1\2\u0393\u039d\3\2\2\2\u0394\u0396\5J&\2"+
		"\u0395\u0397\5J&\2\u0396\u0395\3\2\2\2\u0397\u0398\3\2\2\2\u0398\u0396"+
		"\3\2\2\2\u0398\u0399\3\2\2\2\u0399\u039a\3\2\2\2\u039a\u039b\b%\1\2\u039b"+
		"\u039d\3\2\2\2\u039c\u0368\3\2\2\2\u039c\u036a\3\2\2\2\u039c\u036f\3\2"+
		"\2\2\u039c\u0375\3\2\2\2\u039c\u037a\3\2\2\2\u039c\u037f\3\2\2\2\u039c"+
		"\u0383\3\2\2\2\u039c\u0387\3\2\2\2\u039c\u038c\3\2\2\2\u039c\u0390\3\2"+
		"\2\2\u039c\u0394\3\2\2\2\u039d\u03bf\3\2\2\2\u039e\u039f\f\21\2\2\u039f"+
		"\u03a0\t\6\2\2\u03a0\u03be\5H%\22\u03a1\u03a2\f\20\2\2\u03a2\u03a3\t\7"+
		"\2\2\u03a3\u03be\5H%\21\u03a4\u03a5\f\17\2\2\u03a5\u03a6\t\b\2\2\u03a6"+
		"\u03be\5H%\20\u03a7\u03a8\f\16\2\2\u03a8\u03a9\t\t\2\2\u03a9\u03be\5H"+
		"%\17\u03aa\u03ab\f\r\2\2\u03ab\u03ac\7\61\2\2\u03ac\u03be\5H%\16\u03ad"+
		"\u03ae\f\f\2\2\u03ae\u03af\7\62\2\2\u03af\u03be\5H%\r\u03b0\u03b1\f\4"+
		"\2\2\u03b1\u03b3\t\3\2\2\u03b2\u03b4\t\3\2\2\u03b3\u03b2\3\2\2\2\u03b4"+
		"\u03b5\3\2\2\2\u03b5\u03b3\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03b7\3\2"+
		"\2\2\u03b7\u03b8\5H%\5\u03b8\u03b9\b%\1\2\u03b9\u03be\3\2\2\2\u03ba\u03bb"+
		"\f\3\2\2\u03bb\u03bc\t\3\2\2\u03bc\u03be\b%\1\2\u03bd\u039e\3\2\2\2\u03bd"+
		"\u03a1\3\2\2\2\u03bd\u03a4\3\2\2\2\u03bd\u03a7\3\2\2\2\u03bd\u03aa\3\2"+
		"\2\2\u03bd\u03ad\3\2\2\2\u03bd\u03b0\3\2\2\2\u03bd\u03ba\3\2\2\2\u03be"+
		"\u03c1\3\2\2\2\u03bf\u03bd\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0I\3\2\2\2"+
		"\u03c1\u03bf\3\2\2\2\u03c2\u03cf\5L\'\2\u03c3\u03c4\7=\2\2\u03c4\u03c5"+
		"\7!\2\2\u03c5\u03c6\5H%\2\u03c6\u03c7\7\"\2\2\u03c7\u03cf\3\2\2\2\u03c8"+
		"\u03c9\7=\2\2\u03c9\u03cb\7\35\2\2\u03ca\u03cc\5<\37\2\u03cb\u03ca\3\2"+
		"\2\2\u03cb\u03cc\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03cf\7\36\2\2\u03ce"+
		"\u03c2\3\2\2\2\u03ce\u03c3\3\2\2\2\u03ce\u03c8\3\2\2\2\u03cfK\3\2\2\2"+
		"\u03d0\u03d1\7\35\2\2\u03d1\u03d2\5H%\2\u03d2\u03d3\7\36\2\2\u03d3\u03d7"+
		"\3\2\2\2\u03d4\u03d7\5\34\17\2\u03d5\u03d7\7=\2\2\u03d6\u03d0\3\2\2\2"+
		"\u03d6\u03d4\3\2\2\2\u03d6\u03d5\3\2\2\2\u03d7M\3\2\2\2tQXgt|\u0081\u0086"+
		"\u008b\u0092\u0097\u009b\u00a2\u00a8\u00b1\u00bd\u00c5\u00c9\u00cd\u00d8"+
		"\u00e2\u00ea\u00ed\u00f6\u00fd\u0105\u0110\u0114\u0116\u0121\u012b\u0131"+
		"\u0139\u013d\u0144\u014c\u014f\u0159\u0165\u0181\u0188\u01a1\u01a3\u01a5"+
		"\u01aa\u01ad\u01bc\u01be\u01c3\u01cd\u01da\u01e7\u01ef\u01f1\u01f3\u01f8"+
		"\u0200\u020c\u0218\u0220\u0222\u0228\u0234\u0236\u0241\u0243\u0251\u0253"+
		"\u0257\u0277\u0279\u0282\u0284\u0286\u0294\u0296\u029f\u02a1\u02a3\u02ae"+
		"\u02c1\u02c9\u02d1\u02d4\u02dd\u02e4\u02ec\u02f7\u02fb\u02fd\u0302\u0307"+
		"\u030d\u0312\u0319\u031e\u0322\u0328\u033b\u0347\u034c\u0351\u0357\u035d"+
		"\u0364\u0366\u0372\u0398\u039c\u03b5\u03bd\u03bf\u03cb\u03ce\u03d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}