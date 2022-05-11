// Generated from /home/max/synced/uwu-lang/src/main/kotlin/UwULang.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UwULangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, INTEGER=4, FLOAT=5, WS=6, OPEN_PAREN=7, CLOSE_PAREN=8, 
		OPEN_BRACE=9, CLOSE_BRACE=10, SEMICOLON=11, COLON=12, STRING_LITERAL=13, 
		STRUCT=14, FUN=15, STATIC=16, NEW=17, IF=18, WHILE=19, FOR=20, LET=21, 
		MUT=22, IMPORT=23, RETURN=24, PACKAGE=25, AS=26, IDENTIFIER=27, KEYWORD=28, 
		PLUS=29, MINUS=30, TIMES=31, DIVIDE=32, LESSTHANEQUALS=33, GREATERTHANEQUALS=34, 
		LESSTHAN=35, GREATERTHAN=36, EQUALS=37;
	public static final int
		RULE_nameTypePair = 0, RULE_struct = 1, RULE_fieldAccess = 2, RULE_functionInvocation = 3, 
		RULE_methodInvocation = 4, RULE_addOp = 5, RULE_mulOp = 6, RULE_compOp = 7, 
		RULE_expression = 8, RULE_statement = 9, RULE_fieldAssign = 10, RULE_ifStatement = 11, 
		RULE_whileLoop = 12, RULE_braceBlock = 13, RULE_forLoop = 14, RULE_variableAssign = 15, 
		RULE_multiStatement = 16, RULE_fun = 17, RULE_impt = 18, RULE_new = 19, 
		RULE_qualifiedName = 20, RULE_packageStatement = 21, RULE_file = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"nameTypePair", "struct", "fieldAccess", "functionInvocation", "methodInvocation", 
			"addOp", "mulOp", "compOp", "expression", "statement", "fieldAssign", 
			"ifStatement", "whileLoop", "braceBlock", "forLoop", "variableAssign", 
			"multiStatement", "fun", "impt", "new", "qualifiedName", "packageStatement", 
			"file"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'.'", "'='", null, null, null, "'('", "')'", "'{'", "'}'", 
			"';'", "':'", null, "'stwuct'", "'fuwn'", "'static'", "'new'", "'if'", 
			"'whiwe'", "'fow'", "'wet'", "'mewt'", "'impowt'", "'wetuwn'", "'package'", 
			"'as'", null, null, "'+'", "'-'", "'*'", "'/'", "'<='", "'>='", "'<'", 
			"'>'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "INTEGER", "FLOAT", "WS", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_BRACE", "CLOSE_BRACE", "SEMICOLON", "COLON", "STRING_LITERAL", 
			"STRUCT", "FUN", "STATIC", "NEW", "IF", "WHILE", "FOR", "LET", "MUT", 
			"IMPORT", "RETURN", "PACKAGE", "AS", "IDENTIFIER", "KEYWORD", "PLUS", 
			"MINUS", "TIMES", "DIVIDE", "LESSTHANEQUALS", "GREATERTHANEQUALS", "LESSTHAN", 
			"GREATERTHAN", "EQUALS"
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
	public String getGrammarFileName() { return "UwULang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UwULangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class NameTypePairContext extends ParserRuleContext {
		public Token name;
		public Token type;
		public TerminalNode COLON() { return getToken(UwULangParser.COLON, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public NameTypePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameTypePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterNameTypePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitNameTypePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitNameTypePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameTypePairContext nameTypePair() throws RecognitionException {
		NameTypePairContext _localctx = new NameTypePairContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_nameTypePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			((NameTypePairContext)_localctx).name = match(IDENTIFIER);
			setState(47);
			match(COLON);
			setState(48);
			((NameTypePairContext)_localctx).type = match(IDENTIFIER);
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

	public static class StructContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(UwULangParser.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<NameTypePairContext> nameTypePair() {
			return getRuleContexts(NameTypePairContext.class);
		}
		public NameTypePairContext nameTypePair(int i) {
			return getRuleContext(NameTypePairContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(UwULangParser.SEMICOLON, 0); }
		public List<FunContext> fun() {
			return getRuleContexts(FunContext.class);
		}
		public FunContext fun(int i) {
			return getRuleContext(FunContext.class,i);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_struct);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(STRUCT);
			setState(51);
			match(IDENTIFIER);
			setState(52);
			match(OPEN_BRACE);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(53);
					nameTypePair();
					setState(54);
					match(T__0);
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(61);
				nameTypePair();
				setState(62);
				match(SEMICOLON);
				}
			}

			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN || _la==STATIC) {
				{
				{
				setState(66);
				fun();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(CLOSE_BRACE);
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

	public static class FieldAccessContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public FieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFieldAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFieldAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFieldAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccessContext fieldAccess() throws RecognitionException {
		FieldAccessContext _localctx = new FieldAccessContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fieldAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__1);
			setState(75);
			match(IDENTIFIER);
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

	public static class FunctionInvocationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionInvocation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(IDENTIFIER);
			setState(78);
			match(OPEN_PAREN);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(79);
					expression(0);
					setState(80);
					match(T__0);
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(87);
				expression(0);
				}
			}

			setState(90);
			match(CLOSE_PAREN);
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
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitMethodInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__1);
			setState(93);
			functionInvocation();
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

	public static class AddOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(UwULangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(UwULangParser.MINUS, 0); }
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitAddOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitAddOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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

	public static class MulOpContext extends ParserRuleContext {
		public TerminalNode TIMES() { return getToken(UwULangParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(UwULangParser.DIVIDE, 0); }
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterMulOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitMulOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitMulOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !(_la==TIMES || _la==DIVIDE) ) {
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

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode LESSTHAN() { return getToken(UwULangParser.LESSTHAN, 0); }
		public TerminalNode GREATERTHAN() { return getToken(UwULangParser.GREATERTHAN, 0); }
		public TerminalNode LESSTHANEQUALS() { return getToken(UwULangParser.LESSTHANEQUALS, 0); }
		public TerminalNode GREATERTHANEQUALS() { return getToken(UwULangParser.GREATERTHANEQUALS, 0); }
		public TerminalNode EQUALS() { return getToken(UwULangParser.EQUALS, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESSTHANEQUALS) | (1L << GREATERTHANEQUALS) | (1L << LESSTHAN) | (1L << GREATERTHAN) | (1L << EQUALS))) != 0)) ) {
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

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public TerminalNode INTEGER() { return getToken(UwULangParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(UwULangParser.FLOAT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(UwULangParser.STRING_LITERAL, 0); }
		public NewContext new_() {
			return getRuleContext(NewContext.class,0);
		}
		public MulOpContext mulOp() {
			return getRuleContext(MulOpContext.class,0);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public TerminalNode AS() { return getToken(UwULangParser.AS, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(102);
				match(IDENTIFIER);
				}
				break;
			case 2:
				{
				setState(103);
				functionInvocation();
				}
				break;
			case 3:
				{
				setState(104);
				match(OPEN_PAREN);
				setState(105);
				expression(0);
				setState(106);
				match(CLOSE_PAREN);
				}
				break;
			case 4:
				{
				setState(108);
				match(INTEGER);
				}
				break;
			case 5:
				{
				setState(109);
				match(FLOAT);
				}
				break;
			case 6:
				{
				setState(110);
				match(STRING_LITERAL);
				}
				break;
			case 7:
				{
				setState(111);
				new_();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(133);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(114);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(115);
						mulOp();
						setState(116);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(118);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(119);
						addOp();
						setState(120);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(123);
						compOp();
						setState(124);
						expression(4);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(127);
						fieldAccess();
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(128);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(129);
						methodInvocation();
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(130);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(131);
						match(AS);
						setState(132);
						match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public VariableAssignContext variableAssign() {
			return getRuleContext(VariableAssignContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(UwULangParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(UwULangParser.RETURN, 0); }
		public FieldAssignContext fieldAssign() {
			return getRuleContext(FieldAssignContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				whileLoop();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				forLoop();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(141);
				variableAssign();
				setState(142);
				match(SEMICOLON);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(144);
				expression(0);
				setState(145);
				match(SEMICOLON);
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(147);
				match(RETURN);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(148);
					expression(0);
					}
				}

				setState(151);
				match(SEMICOLON);
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(152);
				fieldAssign();
				setState(153);
				match(SEMICOLON);
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

	public static class FieldAssignContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public FieldAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFieldAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFieldAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFieldAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAssignContext fieldAssign() throws RecognitionException {
		FieldAssignContext _localctx = new FieldAssignContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fieldAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			expression(0);
			setState(158);
			match(T__1);
			setState(159);
			match(IDENTIFIER);
			setState(160);
			match(T__2);
			setState(161);
			expression(0);
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(UwULangParser.IF, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(IF);
			setState(164);
			match(OPEN_PAREN);
			setState(165);
			expression(0);
			setState(166);
			match(CLOSE_PAREN);
			setState(167);
			match(OPEN_BRACE);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(168);
				statement();
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
			match(CLOSE_BRACE);
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

	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(UwULangParser.WHILE, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whileLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(WHILE);
			setState(177);
			match(OPEN_PAREN);
			setState(178);
			expression(0);
			setState(179);
			match(CLOSE_PAREN);
			setState(180);
			match(OPEN_BRACE);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(181);
				statement();
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			match(CLOSE_BRACE);
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

	public static class BraceBlockContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BraceBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braceBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterBraceBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitBraceBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitBraceBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BraceBlockContext braceBlock() throws RecognitionException {
		BraceBlockContext _localctx = new BraceBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_braceBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(OPEN_BRACE);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(190);
				statement();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(CLOSE_BRACE);
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

	public static class ForLoopContext extends ParserRuleContext {
		public StatementContext init;
		public ExpressionContext condition;
		public StatementContext each;
		public TerminalNode FOR() { return getToken(UwULangParser.FOR, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(UwULangParser.SEMICOLON, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public BraceBlockContext braceBlock() {
			return getRuleContext(BraceBlockContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(FOR);
			setState(199);
			match(OPEN_PAREN);
			setState(200);
			((ForLoopContext)_localctx).init = statement();
			setState(201);
			((ForLoopContext)_localctx).condition = expression(0);
			setState(202);
			match(SEMICOLON);
			setState(203);
			((ForLoopContext)_localctx).each = statement();
			setState(204);
			match(CLOSE_PAREN);
			setState(205);
			braceBlock();
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

	public static class VariableAssignContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LET() { return getToken(UwULangParser.LET, 0); }
		public TerminalNode MUT() { return getToken(UwULangParser.MUT, 0); }
		public VariableAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterVariableAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitVariableAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitVariableAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignContext variableAssign() throws RecognitionException {
		VariableAssignContext _localctx = new VariableAssignContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variableAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET || _la==MUT) {
				{
				setState(207);
				_la = _input.LA(1);
				if ( !(_la==LET || _la==MUT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(210);
			match(IDENTIFIER);
			setState(211);
			match(T__2);
			setState(212);
			expression(0);
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

	public static class MultiStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MultiStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterMultiStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitMultiStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitMultiStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiStatementContext multiStatement() throws RecognitionException {
		MultiStatementContext _localctx = new MultiStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_multiStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << LET) | (1L << MUT) | (1L << RETURN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(214);
				statement();
				}
				}
				setState(219);
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

	public static class FunContext extends ParserRuleContext {
		public Token name;
		public Token returnType;
		public TerminalNode FUN() { return getToken(UwULangParser.FUN, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(UwULangParser.OPEN_BRACE, 0); }
		public MultiStatementContext multiStatement() {
			return getRuleContext(MultiStatementContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(UwULangParser.CLOSE_BRACE, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public TerminalNode STATIC() { return getToken(UwULangParser.STATIC, 0); }
		public List<NameTypePairContext> nameTypePair() {
			return getRuleContexts(NameTypePairContext.class);
		}
		public NameTypePairContext nameTypePair(int i) {
			return getRuleContext(NameTypePairContext.class,i);
		}
		public TerminalNode COLON() { return getToken(UwULangParser.COLON, 0); }
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fun);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(220);
				match(STATIC);
				}
			}

			setState(223);
			match(FUN);
			setState(224);
			((FunContext)_localctx).name = match(IDENTIFIER);
			setState(225);
			match(OPEN_PAREN);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(226);
					nameTypePair();
					setState(227);
					match(T__0);
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(234);
				nameTypePair();
				}
			}

			setState(237);
			match(CLOSE_PAREN);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(238);
				match(COLON);
				setState(239);
				((FunContext)_localctx).returnType = match(IDENTIFIER);
				}
			}

			setState(242);
			match(OPEN_BRACE);
			setState(243);
			multiStatement();
			setState(244);
			match(CLOSE_BRACE);
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

	public static class ImptContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(UwULangParser.IMPORT, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public TerminalNode SEMICOLON() { return getToken(UwULangParser.SEMICOLON, 0); }
		public ImptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterImpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitImpt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitImpt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImptContext impt() throws RecognitionException {
		ImptContext _localctx = new ImptContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_impt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(IMPORT);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(247);
					match(IDENTIFIER);
					setState(248);
					match(T__1);
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(254);
			match(IDENTIFIER);
			setState(255);
			match(SEMICOLON);
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

	public static class NewContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(UwULangParser.NEW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(UwULangParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(UwULangParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(UwULangParser.CLOSE_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewContext new_() throws RecognitionException {
		NewContext _localctx = new NewContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_new);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(NEW);
			setState(258);
			match(IDENTIFIER);
			setState(259);
			match(OPEN_PAREN);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(260);
					expression(0);
					setState(261);
					match(T__0);
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << FLOAT) | (1L << OPEN_PAREN) | (1L << STRING_LITERAL) | (1L << NEW) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(268);
				expression(0);
				}
			}

			setState(271);
			match(CLOSE_PAREN);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(UwULangParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(UwULangParser.IDENTIFIER, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(273);
					match(IDENTIFIER);
					setState(274);
					match(T__1);
					}
					} 
				}
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(280);
			match(IDENTIFIER);
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

	public static class PackageStatementContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(UwULangParser.PACKAGE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(UwULangParser.SEMICOLON, 0); }
		public PackageStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterPackageStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitPackageStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitPackageStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageStatementContext packageStatement() throws RecognitionException {
		PackageStatementContext _localctx = new PackageStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_packageStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(PACKAGE);
			setState(283);
			qualifiedName();
			setState(284);
			match(SEMICOLON);
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

	public static class FileContext extends ParserRuleContext {
		public PackageStatementContext packageStatement() {
			return getRuleContext(PackageStatementContext.class,0);
		}
		public List<ImptContext> impt() {
			return getRuleContexts(ImptContext.class);
		}
		public ImptContext impt(int i) {
			return getRuleContext(ImptContext.class,i);
		}
		public List<StructContext> struct() {
			return getRuleContexts(StructContext.class);
		}
		public StructContext struct(int i) {
			return getRuleContext(StructContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UwULangListener ) ((UwULangListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UwULangVisitor ) return ((UwULangVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			packageStatement();
			setState(288); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(287);
				impt();
				}
				}
				setState(290); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IMPORT );
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRUCT) {
				{
				{
				setState(292);
				struct();
				}
				}
				setState(297);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u012b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00019\b\u0001\n\u0001\f\u0001<\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001A\b\u0001\u0001\u0001\u0005\u0001D\b\u0001\n\u0001"+
		"\f\u0001G\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003S\b\u0003\n\u0003\f\u0003V\t\u0003\u0001\u0003\u0003\u0003Y\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\bq\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u0086\b\b\n\b\f\b\u0089\t\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0096\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u009c"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00aa"+
		"\b\u000b\n\u000b\f\u000b\u00ad\t\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00b7\b\f\n\f\f\f\u00ba"+
		"\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005\r\u00c0\b\r\n\r\f\r\u00c3\t"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0003"+
		"\u000f\u00d1\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0005\u0010\u00d8\b\u0010\n\u0010\f\u0010\u00db\t\u0010\u0001\u0011"+
		"\u0003\u0011\u00de\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u00e6\b\u0011\n\u0011\f\u0011\u00e9"+
		"\t\u0011\u0001\u0011\u0003\u0011\u00ec\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00f1\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00fa\b\u0012"+
		"\n\u0012\f\u0012\u00fd\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005"+
		"\u0013\u0108\b\u0013\n\u0013\f\u0013\u010b\t\u0013\u0001\u0013\u0003\u0013"+
		"\u010e\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u0114\b\u0014\n\u0014\f\u0014\u0117\t\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0004"+
		"\u0016\u0121\b\u0016\u000b\u0016\f\u0016\u0122\u0001\u0016\u0005\u0016"+
		"\u0126\b\u0016\n\u0016\f\u0016\u0129\t\u0016\u0001\u0016\u0000\u0001\u0010"+
		"\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,\u0000\u0004\u0001\u0000\u001d\u001e\u0001\u0000"+
		"\u001f \u0001\u0000!%\u0001\u0000\u0015\u0016\u013a\u0000.\u0001\u0000"+
		"\u0000\u0000\u00022\u0001\u0000\u0000\u0000\u0004J\u0001\u0000\u0000\u0000"+
		"\u0006M\u0001\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000\n_\u0001\u0000"+
		"\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000\u0000"+
		"\u0010p\u0001\u0000\u0000\u0000\u0012\u009b\u0001\u0000\u0000\u0000\u0014"+
		"\u009d\u0001\u0000\u0000\u0000\u0016\u00a3\u0001\u0000\u0000\u0000\u0018"+
		"\u00b0\u0001\u0000\u0000\u0000\u001a\u00bd\u0001\u0000\u0000\u0000\u001c"+
		"\u00c6\u0001\u0000\u0000\u0000\u001e\u00d0\u0001\u0000\u0000\u0000 \u00d9"+
		"\u0001\u0000\u0000\u0000\"\u00dd\u0001\u0000\u0000\u0000$\u00f6\u0001"+
		"\u0000\u0000\u0000&\u0101\u0001\u0000\u0000\u0000(\u0115\u0001\u0000\u0000"+
		"\u0000*\u011a\u0001\u0000\u0000\u0000,\u011e\u0001\u0000\u0000\u0000."+
		"/\u0005\u001b\u0000\u0000/0\u0005\f\u0000\u000001\u0005\u001b\u0000\u0000"+
		"1\u0001\u0001\u0000\u0000\u000023\u0005\u000e\u0000\u000034\u0005\u001b"+
		"\u0000\u00004:\u0005\t\u0000\u000056\u0003\u0000\u0000\u000067\u0005\u0001"+
		"\u0000\u000079\u0001\u0000\u0000\u000085\u0001\u0000\u0000\u00009<\u0001"+
		"\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";@\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0003\u0000\u0000"+
		"\u0000>?\u0005\u000b\u0000\u0000?A\u0001\u0000\u0000\u0000@=\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AE\u0001\u0000\u0000\u0000BD\u0003"+
		"\"\u0011\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000HI\u0005\n\u0000\u0000I\u0003\u0001\u0000\u0000"+
		"\u0000JK\u0005\u0002\u0000\u0000KL\u0005\u001b\u0000\u0000L\u0005\u0001"+
		"\u0000\u0000\u0000MN\u0005\u001b\u0000\u0000NT\u0005\u0007\u0000\u0000"+
		"OP\u0003\u0010\b\u0000PQ\u0005\u0001\u0000\u0000QS\u0001\u0000\u0000\u0000"+
		"RO\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000WY\u0003\u0010\b\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0005\b\u0000\u0000[\u0007\u0001"+
		"\u0000\u0000\u0000\\]\u0005\u0002\u0000\u0000]^\u0003\u0006\u0003\u0000"+
		"^\t\u0001\u0000\u0000\u0000_`\u0007\u0000\u0000\u0000`\u000b\u0001\u0000"+
		"\u0000\u0000ab\u0007\u0001\u0000\u0000b\r\u0001\u0000\u0000\u0000cd\u0007"+
		"\u0002\u0000\u0000d\u000f\u0001\u0000\u0000\u0000ef\u0006\b\uffff\uffff"+
		"\u0000fq\u0005\u001b\u0000\u0000gq\u0003\u0006\u0003\u0000hi\u0005\u0007"+
		"\u0000\u0000ij\u0003\u0010\b\u0000jk\u0005\b\u0000\u0000kq\u0001\u0000"+
		"\u0000\u0000lq\u0005\u0004\u0000\u0000mq\u0005\u0005\u0000\u0000nq\u0005"+
		"\r\u0000\u0000oq\u0003&\u0013\u0000pe\u0001\u0000\u0000\u0000pg\u0001"+
		"\u0000\u0000\u0000ph\u0001\u0000\u0000\u0000pl\u0001\u0000\u0000\u0000"+
		"pm\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000po\u0001\u0000\u0000"+
		"\u0000q\u0087\u0001\u0000\u0000\u0000rs\n\u0005\u0000\u0000st\u0003\f"+
		"\u0006\u0000tu\u0003\u0010\b\u0006u\u0086\u0001\u0000\u0000\u0000vw\n"+
		"\u0004\u0000\u0000wx\u0003\n\u0005\u0000xy\u0003\u0010\b\u0005y\u0086"+
		"\u0001\u0000\u0000\u0000z{\n\u0003\u0000\u0000{|\u0003\u000e\u0007\u0000"+
		"|}\u0003\u0010\b\u0004}\u0086\u0001\u0000\u0000\u0000~\u007f\n\f\u0000"+
		"\u0000\u007f\u0086\u0003\u0004\u0002\u0000\u0080\u0081\n\u000b\u0000\u0000"+
		"\u0081\u0086\u0003\b\u0004\u0000\u0082\u0083\n\u0001\u0000\u0000\u0083"+
		"\u0084\u0005\u001a\u0000\u0000\u0084\u0086\u0005\u001b\u0000\u0000\u0085"+
		"r\u0001\u0000\u0000\u0000\u0085v\u0001\u0000\u0000\u0000\u0085z\u0001"+
		"\u0000\u0000\u0000\u0085~\u0001\u0000\u0000\u0000\u0085\u0080\u0001\u0000"+
		"\u0000\u0000\u0085\u0082\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000"+
		"\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000"+
		"\u0000\u0000\u0088\u0011\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000"+
		"\u0000\u0000\u008a\u009c\u0003\u0016\u000b\u0000\u008b\u009c\u0003\u0018"+
		"\f\u0000\u008c\u009c\u0003\u001c\u000e\u0000\u008d\u008e\u0003\u001e\u000f"+
		"\u0000\u008e\u008f\u0005\u000b\u0000\u0000\u008f\u009c\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0003\u0010\b\u0000\u0091\u0092\u0005\u000b\u0000\u0000"+
		"\u0092\u009c\u0001\u0000\u0000\u0000\u0093\u0095\u0005\u0018\u0000\u0000"+
		"\u0094\u0096\u0003\u0010\b\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097"+
		"\u009c\u0005\u000b\u0000\u0000\u0098\u0099\u0003\u0014\n\u0000\u0099\u009a"+
		"\u0005\u000b\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u008a"+
		"\u0001\u0000\u0000\u0000\u009b\u008b\u0001\u0000\u0000\u0000\u009b\u008c"+
		"\u0001\u0000\u0000\u0000\u009b\u008d\u0001\u0000\u0000\u0000\u009b\u0090"+
		"\u0001\u0000\u0000\u0000\u009b\u0093\u0001\u0000\u0000\u0000\u009b\u0098"+
		"\u0001\u0000\u0000\u0000\u009c\u0013\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0003\u0010\b\u0000\u009e\u009f\u0005\u0002\u0000\u0000\u009f\u00a0\u0005"+
		"\u001b\u0000\u0000\u00a0\u00a1\u0005\u0003\u0000\u0000\u00a1\u00a2\u0003"+
		"\u0010\b\u0000\u00a2\u0015\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0012"+
		"\u0000\u0000\u00a4\u00a5\u0005\u0007\u0000\u0000\u00a5\u00a6\u0003\u0010"+
		"\b\u0000\u00a6\u00a7\u0005\b\u0000\u0000\u00a7\u00ab\u0005\t\u0000\u0000"+
		"\u00a8\u00aa\u0003\u0012\t\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\n\u0000\u0000\u00af\u0017"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u0013\u0000\u0000\u00b1\u00b2"+
		"\u0005\u0007\u0000\u0000\u00b2\u00b3\u0003\u0010\b\u0000\u00b3\u00b4\u0005"+
		"\b\u0000\u0000\u00b4\u00b8\u0005\t\u0000\u0000\u00b5\u00b7\u0003\u0012"+
		"\t\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0005\n\u0000\u0000\u00bc\u0019\u0001\u0000\u0000\u0000"+
		"\u00bd\u00c1\u0005\t\u0000\u0000\u00be\u00c0\u0003\u0012\t\u0000\u00bf"+
		"\u00be\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0005\n\u0000\u0000\u00c5\u001b\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\u0005\u0014\u0000\u0000\u00c7\u00c8\u0005\u0007\u0000\u0000\u00c8\u00c9"+
		"\u0003\u0012\t\u0000\u00c9\u00ca\u0003\u0010\b\u0000\u00ca\u00cb\u0005"+
		"\u000b\u0000\u0000\u00cb\u00cc\u0003\u0012\t\u0000\u00cc\u00cd\u0005\b"+
		"\u0000\u0000\u00cd\u00ce\u0003\u001a\r\u0000\u00ce\u001d\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d1\u0007\u0003\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d3\u0005\u001b\u0000\u0000\u00d3\u00d4\u0005\u0003\u0000"+
		"\u0000\u00d4\u00d5\u0003\u0010\b\u0000\u00d5\u001f\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d8\u0003\u0012\t\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8"+
		"\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da!\u0001\u0000\u0000\u0000\u00db\u00d9"+
		"\u0001\u0000\u0000\u0000\u00dc\u00de\u0005\u0010\u0000\u0000\u00dd\u00dc"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u000f\u0000\u0000\u00e0\u00e1"+
		"\u0005\u001b\u0000\u0000\u00e1\u00e7\u0005\u0007\u0000\u0000\u00e2\u00e3"+
		"\u0003\u0000\u0000\u0000\u00e3\u00e4\u0005\u0001\u0000\u0000\u00e4\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e2\u0001\u0000\u0000\u0000\u00e6\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8"+
		"\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7"+
		"\u0001\u0000\u0000\u0000\u00ea\u00ec\u0003\u0000\u0000\u0000\u00eb\u00ea"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ed\u00f0\u0005\b\u0000\u0000\u00ee\u00ef\u0005"+
		"\f\u0000\u0000\u00ef\u00f1\u0005\u001b\u0000\u0000\u00f0\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0005\t\u0000\u0000\u00f3\u00f4\u0003 \u0010"+
		"\u0000\u00f4\u00f5\u0005\n\u0000\u0000\u00f5#\u0001\u0000\u0000\u0000"+
		"\u00f6\u00fb\u0005\u0017\u0000\u0000\u00f7\u00f8\u0005\u001b\u0000\u0000"+
		"\u00f8\u00fa\u0005\u0002\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fe\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005\u001b\u0000\u0000"+
		"\u00ff\u0100\u0005\u000b\u0000\u0000\u0100%\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0005\u0011\u0000\u0000\u0102\u0103\u0005\u001b\u0000\u0000\u0103"+
		"\u0109\u0005\u0007\u0000\u0000\u0104\u0105\u0003\u0010\b\u0000\u0105\u0106"+
		"\u0005\u0001\u0000\u0000\u0106\u0108\u0001\u0000\u0000\u0000\u0107\u0104"+
		"\u0001\u0000\u0000\u0000\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107"+
		"\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010d"+
		"\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010e"+
		"\u0003\u0010\b\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010d\u010e\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0110\u0005"+
		"\b\u0000\u0000\u0110\'\u0001\u0000\u0000\u0000\u0111\u0112\u0005\u001b"+
		"\u0000\u0000\u0112\u0114\u0005\u0002\u0000\u0000\u0113\u0111\u0001\u0000"+
		"\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0118\u0001\u0000"+
		"\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u001b"+
		"\u0000\u0000\u0119)\u0001\u0000\u0000\u0000\u011a\u011b\u0005\u0019\u0000"+
		"\u0000\u011b\u011c\u0003(\u0014\u0000\u011c\u011d\u0005\u000b\u0000\u0000"+
		"\u011d+\u0001\u0000\u0000\u0000\u011e\u0120\u0003*\u0015\u0000\u011f\u0121"+
		"\u0003$\u0012\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001"+
		"\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001"+
		"\u0000\u0000\u0000\u0123\u0127\u0001\u0000\u0000\u0000\u0124\u0126\u0003"+
		"\u0002\u0001\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0126\u0129\u0001"+
		"\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001"+
		"\u0000\u0000\u0000\u0128-\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000"+
		"\u0000\u0000\u0019:@ETXp\u0085\u0087\u0095\u009b\u00ab\u00b8\u00c1\u00d0"+
		"\u00d9\u00dd\u00e7\u00eb\u00f0\u00fb\u0109\u010d\u0115\u0122\u0127";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}