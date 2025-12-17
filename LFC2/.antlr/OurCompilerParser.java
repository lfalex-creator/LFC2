// Generated from c:/Users/gheor/Desktop/Facultate/Anul II/LFC/LFC2/LFC2/OurCompiler.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class OurCompilerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINECOMMENT=1, BIGCOMMENT=2, INT=3, FLOAT=4, DOUBLE=5, STRING=6, CONST=7, 
		VOID=8, IF=9, ELSE=10, FOR=11, WHILE=12, RETURN=13, PLUS=14, MINUS=15, 
		TIMES=16, DIVIDED=17, MODULO=18, AND=19, OR=20, NOT=21, ASGN=22, ASGN_PLUS=23, 
		ASGN_MINUS=24, ASGN_TIMES=25, ASGN_DIVIDED=26, ASGN_MODULO=27, LESS=28, 
		GREAT=29, EQ=30, NEQ=31, LESSOREQ=32, GREATOREQ=33, INCREMENT=34, DECREMENT=35, 
		LPAR=36, RPAR=37, LGROUP=38, RGROUP=39, EOL=40, COMMA=41, WS=42, VARIABLE_NAME=43, 
		INT_NUMBER=44, DOUBLE_NUMBER=45, FLOAT_NUMBER=46, STRING_LITERAL=47;
	public static final int
		RULE_pure_data = 0, RULE_data_type = 1, RULE_any_math_operator = 2, RULE_math_expr = 3, 
		RULE_comp_val = 4, RULE_comparer = 5, RULE_logic_link = 6, RULE_logic_expr = 7, 
		RULE_crement_expr = 8, RULE_program = 9, RULE_function = 10, RULE_expression_generator = 11, 
		RULE_expression = 12, RULE_var_declar_expr = 13, RULE_var_assign_expr = 14, 
		RULE_var_decl_assg_expr = 15, RULE_if_expr = 16, RULE_for_expr = 17, RULE_while_expr = 18, 
		RULE_return_expr = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"pure_data", "data_type", "any_math_operator", "math_expr", "comp_val", 
			"comparer", "logic_link", "logic_expr", "crement_expr", "program", "function", 
			"expression_generator", "expression", "var_declar_expr", "var_assign_expr", 
			"var_decl_assg_expr", "if_expr", "for_expr", "while_expr", "return_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'int'", "'float'", "'double'", "'string'", "'const'", 
			"'void'", "'if'", "'else'", "'for'", "'while'", "'return'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'='", "'+='", "'-='", "'*='", 
			"'/='", "'%='", "'<'", "'>'", "'=='", "'!='", "'<='", "'>='", "'++'", 
			"'--'", "'('", "')'", "'{'", "'}'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINECOMMENT", "BIGCOMMENT", "INT", "FLOAT", "DOUBLE", "STRING", 
			"CONST", "VOID", "IF", "ELSE", "FOR", "WHILE", "RETURN", "PLUS", "MINUS", 
			"TIMES", "DIVIDED", "MODULO", "AND", "OR", "NOT", "ASGN", "ASGN_PLUS", 
			"ASGN_MINUS", "ASGN_TIMES", "ASGN_DIVIDED", "ASGN_MODULO", "LESS", "GREAT", 
			"EQ", "NEQ", "LESSOREQ", "GREATOREQ", "INCREMENT", "DECREMENT", "LPAR", 
			"RPAR", "LGROUP", "RGROUP", "EOL", "COMMA", "WS", "VARIABLE_NAME", "INT_NUMBER", 
			"DOUBLE_NUMBER", "FLOAT_NUMBER", "STRING_LITERAL"
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
	public String getGrammarFileName() { return "OurCompiler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OurCompilerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pure_dataContext extends ParserRuleContext {
		public TerminalNode INT_NUMBER() { return getToken(OurCompilerParser.INT_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(OurCompilerParser.FLOAT_NUMBER, 0); }
		public TerminalNode DOUBLE_NUMBER() { return getToken(OurCompilerParser.DOUBLE_NUMBER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(OurCompilerParser.STRING_LITERAL, 0); }
		public Pure_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pure_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterPure_data(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitPure_data(this);
		}
	}

	public final Pure_dataContext pure_data() throws RecognitionException {
		Pure_dataContext _localctx = new Pure_dataContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pure_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 263882790666240L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Data_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(OurCompilerParser.INT, 0); }
		public TerminalNode STRING() { return getToken(OurCompilerParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(OurCompilerParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(OurCompilerParser.DOUBLE, 0); }
		public TerminalNode CONST() { return getToken(OurCompilerParser.CONST, 0); }
		public Data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterData_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitData_type(this);
		}
	}

	public final Data_typeContext data_type() throws RecognitionException {
		Data_typeContext _localctx = new Data_typeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_data_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(42);
				match(CONST);
				}
			}

			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 120L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Any_math_operatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(OurCompilerParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(OurCompilerParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(OurCompilerParser.TIMES, 0); }
		public TerminalNode DIVIDED() { return getToken(OurCompilerParser.DIVIDED, 0); }
		public TerminalNode MODULO() { return getToken(OurCompilerParser.MODULO, 0); }
		public Any_math_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_math_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterAny_math_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitAny_math_operator(this);
		}
	}

	public final Any_math_operatorContext any_math_operator() throws RecognitionException {
		Any_math_operatorContext _localctx = new Any_math_operatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_any_math_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 507904L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Math_exprContext extends ParserRuleContext {
		public List<Any_math_operatorContext> any_math_operator() {
			return getRuleContexts(Any_math_operatorContext.class);
		}
		public Any_math_operatorContext any_math_operator(int i) {
			return getRuleContext(Any_math_operatorContext.class,i);
		}
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(OurCompilerParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(OurCompilerParser.VARIABLE_NAME, i);
		}
		public List<Pure_dataContext> pure_data() {
			return getRuleContexts(Pure_dataContext.class);
		}
		public Pure_dataContext pure_data(int i) {
			return getRuleContext(Pure_dataContext.class,i);
		}
		public Math_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterMath_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitMath_expr(this);
		}
	}

	public final Math_exprContext math_expr() throws RecognitionException {
		Math_exprContext _localctx = new Math_exprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_math_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_NAME:
				{
				setState(49);
				match(VARIABLE_NAME);
				}
				break;
			case INT_NUMBER:
			case DOUBLE_NUMBER:
			case FLOAT_NUMBER:
			case STRING_LITERAL:
				{
				setState(50);
				pure_data();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(53);
			any_math_operator();
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_NAME:
				{
				setState(54);
				match(VARIABLE_NAME);
				}
				break;
			case INT_NUMBER:
			case DOUBLE_NUMBER:
			case FLOAT_NUMBER:
			case STRING_LITERAL:
				{
				setState(55);
				pure_data();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 507904L) != 0)) {
				{
				{
				setState(58);
				any_math_operator();
				setState(61);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VARIABLE_NAME:
					{
					setState(59);
					match(VARIABLE_NAME);
					}
					break;
				case INT_NUMBER:
				case DOUBLE_NUMBER:
				case FLOAT_NUMBER:
				case STRING_LITERAL:
					{
					setState(60);
					pure_data();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(67);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Comp_valContext extends ParserRuleContext {
		public TerminalNode VARIABLE_NAME() { return getToken(OurCompilerParser.VARIABLE_NAME, 0); }
		public Pure_dataContext pure_data() {
			return getRuleContext(Pure_dataContext.class,0);
		}
		public Comp_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterComp_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitComp_val(this);
		}
	}

	public final Comp_valContext comp_val() throws RecognitionException {
		Comp_valContext _localctx = new Comp_valContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_comp_val);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(VARIABLE_NAME);
				}
				break;
			case INT_NUMBER:
			case DOUBLE_NUMBER:
			case FLOAT_NUMBER:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				pure_data();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComparerContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(OurCompilerParser.LESS, 0); }
		public TerminalNode GREAT() { return getToken(OurCompilerParser.GREAT, 0); }
		public TerminalNode EQ() { return getToken(OurCompilerParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(OurCompilerParser.NEQ, 0); }
		public TerminalNode LESSOREQ() { return getToken(OurCompilerParser.LESSOREQ, 0); }
		public TerminalNode GREATOREQ() { return getToken(OurCompilerParser.GREATOREQ, 0); }
		public ComparerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterComparer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitComparer(this);
		}
	}

	public final ComparerContext comparer() throws RecognitionException {
		ComparerContext _localctx = new ComparerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comparer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16911433728L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_linkContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(OurCompilerParser.AND, 0); }
		public TerminalNode OR() { return getToken(OurCompilerParser.OR, 0); }
		public Logic_linkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_link; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterLogic_link(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitLogic_link(this);
		}
	}

	public final Logic_linkContext logic_link() throws RecognitionException {
		Logic_linkContext _localctx = new Logic_linkContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_logic_link);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_exprContext extends ParserRuleContext {
		public List<Comp_valContext> comp_val() {
			return getRuleContexts(Comp_valContext.class);
		}
		public Comp_valContext comp_val(int i) {
			return getRuleContext(Comp_valContext.class,i);
		}
		public ComparerContext comparer() {
			return getRuleContext(ComparerContext.class,0);
		}
		public Logic_linkContext logic_link() {
			return getRuleContext(Logic_linkContext.class,0);
		}
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(OurCompilerParser.NOT, 0); }
		public TerminalNode LPAR() { return getToken(OurCompilerParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(OurCompilerParser.RPAR, 0); }
		public Logic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterLogic_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitLogic_expr(this);
		}
	}

	public final Logic_exprContext logic_expr() throws RecognitionException {
		Logic_exprContext _localctx = new Logic_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_logic_expr);
		int _la;
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_NAME:
			case INT_NUMBER:
			case DOUBLE_NUMBER:
			case FLOAT_NUMBER:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(76);
				comp_val();
				setState(77);
				comparer();
				setState(78);
				comp_val();
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AND || _la==OR) {
					{
					setState(79);
					logic_link();
					setState(80);
					logic_expr();
					}
				}

				}
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(84);
				match(NOT);
				setState(85);
				match(LPAR);
				setState(86);
				comp_val();
				setState(87);
				comparer();
				setState(88);
				comp_val();
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AND || _la==OR) {
					{
					setState(89);
					logic_link();
					setState(90);
					logic_expr();
					}
				}

				setState(94);
				match(RPAR);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Crement_exprContext extends ParserRuleContext {
		public TerminalNode VARIABLE_NAME() { return getToken(OurCompilerParser.VARIABLE_NAME, 0); }
		public TerminalNode INCREMENT() { return getToken(OurCompilerParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(OurCompilerParser.DECREMENT, 0); }
		public Crement_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crement_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterCrement_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitCrement_expr(this);
		}
	}

	public final Crement_exprContext crement_expr() throws RecognitionException {
		Crement_exprContext _localctx = new Crement_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_crement_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(VARIABLE_NAME);
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==INCREMENT || _la==DECREMENT) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(OurCompilerParser.EOF, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<Var_declar_exprContext> var_declar_expr() {
			return getRuleContexts(Var_declar_exprContext.class);
		}
		public Var_declar_exprContext var_declar_expr(int i) {
			return getRuleContext(Var_declar_exprContext.class,i);
		}
		public List<TerminalNode> EOL() { return getTokens(OurCompilerParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(OurCompilerParser.EOL, i);
		}
		public List<Var_decl_assg_exprContext> var_decl_assg_expr() {
			return getRuleContexts(Var_decl_assg_exprContext.class);
		}
		public Var_decl_assg_exprContext var_decl_assg_expr(int i) {
			return getRuleContext(Var_decl_assg_exprContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(101);
					function();
					}
					break;
				case 2:
					{
					{
					setState(102);
					var_declar_expr();
					setState(103);
					match(EOL);
					}
					}
					break;
				case 3:
					{
					{
					setState(105);
					var_decl_assg_expr();
					setState(106);
					match(EOL);
					}
					}
					break;
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 504L) != 0) );
			setState(112);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(OurCompilerParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(OurCompilerParser.VARIABLE_NAME, i);
		}
		public TerminalNode LPAR() { return getToken(OurCompilerParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(OurCompilerParser.RPAR, 0); }
		public TerminalNode LGROUP() { return getToken(OurCompilerParser.LGROUP, 0); }
		public Expression_generatorContext expression_generator() {
			return getRuleContext(Expression_generatorContext.class,0);
		}
		public TerminalNode RGROUP() { return getToken(OurCompilerParser.RGROUP, 0); }
		public List<Data_typeContext> data_type() {
			return getRuleContexts(Data_typeContext.class);
		}
		public Data_typeContext data_type(int i) {
			return getRuleContext(Data_typeContext.class,i);
		}
		public TerminalNode VOID() { return getToken(OurCompilerParser.VOID, 0); }
		public TerminalNode COMMA() { return getToken(OurCompilerParser.COMMA, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case CONST:
				{
				setState(114);
				data_type();
				}
				break;
			case VOID:
				{
				setState(115);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(118);
			match(VARIABLE_NAME);
			setState(119);
			match(LPAR);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 248L) != 0)) {
				{
				setState(120);
				data_type();
				setState(121);
				match(VARIABLE_NAME);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(122);
					match(COMMA);
					setState(123);
					data_type();
					setState(124);
					match(VARIABLE_NAME);
					}
				}

				}
			}

			setState(130);
			match(RPAR);
			setState(131);
			match(LGROUP);
			setState(132);
			expression_generator();
			setState(133);
			match(RGROUP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_generatorContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Expression_generatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_generator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterExpression_generator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitExpression_generator(this);
		}
	}

	public final Expression_generatorContext expression_generator() throws RecognitionException {
		Expression_generatorContext _localctx = new Expression_generatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression_generator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093037304L) != 0)) {
				{
				{
				setState(135);
				expression();
				}
				}
				setState(140);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode EOL() { return getToken(OurCompilerParser.EOL, 0); }
		public Var_declar_exprContext var_declar_expr() {
			return getRuleContext(Var_declar_exprContext.class,0);
		}
		public Var_assign_exprContext var_assign_expr() {
			return getRuleContext(Var_assign_exprContext.class,0);
		}
		public Var_decl_assg_exprContext var_decl_assg_expr() {
			return getRuleContext(Var_decl_assg_exprContext.class,0);
		}
		public Crement_exprContext crement_expr() {
			return getRuleContext(Crement_exprContext.class,0);
		}
		public Return_exprContext return_expr() {
			return getRuleContext(Return_exprContext.class,0);
		}
		public If_exprContext if_expr() {
			return getRuleContext(If_exprContext.class,0);
		}
		public For_exprContext for_expr() {
			return getRuleContext(For_exprContext.class,0);
		}
		public While_exprContext while_expr() {
			return getRuleContext(While_exprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case CONST:
			case RETURN:
			case VARIABLE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(141);
					var_declar_expr();
					}
					break;
				case 2:
					{
					setState(142);
					var_assign_expr();
					}
					break;
				case 3:
					{
					setState(143);
					var_decl_assg_expr();
					}
					break;
				case 4:
					{
					setState(144);
					crement_expr();
					}
					break;
				case 5:
					{
					setState(145);
					return_expr();
					}
					break;
				}
				setState(148);
				match(EOL);
				}
				break;
			case IF:
			case FOR:
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IF:
					{
					setState(150);
					if_expr();
					}
					break;
				case FOR:
					{
					setState(151);
					for_expr();
					}
					break;
				case WHILE:
					{
					setState(152);
					while_expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declar_exprContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode VARIABLE_NAME() { return getToken(OurCompilerParser.VARIABLE_NAME, 0); }
		public Var_declar_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declar_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterVar_declar_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitVar_declar_expr(this);
		}
	}

	public final Var_declar_exprContext var_declar_expr() throws RecognitionException {
		Var_declar_exprContext _localctx = new Var_declar_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_var_declar_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			data_type();
			setState(158);
			match(VARIABLE_NAME);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Var_assign_exprContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(OurCompilerParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(OurCompilerParser.VARIABLE_NAME, i);
		}
		public TerminalNode ASGN() { return getToken(OurCompilerParser.ASGN, 0); }
		public Pure_dataContext pure_data() {
			return getRuleContext(Pure_dataContext.class,0);
		}
		public Math_exprContext math_expr() {
			return getRuleContext(Math_exprContext.class,0);
		}
		public Var_assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterVar_assign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitVar_assign_expr(this);
		}
	}

	public final Var_assign_exprContext var_assign_expr() throws RecognitionException {
		Var_assign_exprContext _localctx = new Var_assign_exprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_var_assign_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(VARIABLE_NAME);
			setState(161);
			match(ASGN);
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(162);
				pure_data();
				}
				break;
			case 2:
				{
				setState(163);
				match(VARIABLE_NAME);
				}
				break;
			case 3:
				{
				setState(164);
				math_expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Var_decl_assg_exprContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(OurCompilerParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(OurCompilerParser.VARIABLE_NAME, i);
		}
		public TerminalNode ASGN() { return getToken(OurCompilerParser.ASGN, 0); }
		public Pure_dataContext pure_data() {
			return getRuleContext(Pure_dataContext.class,0);
		}
		public Math_exprContext math_expr() {
			return getRuleContext(Math_exprContext.class,0);
		}
		public Var_decl_assg_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl_assg_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterVar_decl_assg_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitVar_decl_assg_expr(this);
		}
	}

	public final Var_decl_assg_exprContext var_decl_assg_expr() throws RecognitionException {
		Var_decl_assg_exprContext _localctx = new Var_decl_assg_exprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_var_decl_assg_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			data_type();
			setState(168);
			match(VARIABLE_NAME);
			setState(169);
			match(ASGN);
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(170);
				pure_data();
				}
				break;
			case 2:
				{
				setState(171);
				match(VARIABLE_NAME);
				}
				break;
			case 3:
				{
				setState(172);
				math_expr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class If_exprContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(OurCompilerParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(OurCompilerParser.LPAR, 0); }
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(OurCompilerParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> LGROUP() { return getTokens(OurCompilerParser.LGROUP); }
		public TerminalNode LGROUP(int i) {
			return getToken(OurCompilerParser.LGROUP, i);
		}
		public List<Expression_generatorContext> expression_generator() {
			return getRuleContexts(Expression_generatorContext.class);
		}
		public Expression_generatorContext expression_generator(int i) {
			return getRuleContext(Expression_generatorContext.class,i);
		}
		public List<TerminalNode> RGROUP() { return getTokens(OurCompilerParser.RGROUP); }
		public TerminalNode RGROUP(int i) {
			return getToken(OurCompilerParser.RGROUP, i);
		}
		public TerminalNode ELSE() { return getToken(OurCompilerParser.ELSE, 0); }
		public If_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterIf_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitIf_expr(this);
		}
	}

	public final If_exprContext if_expr() throws RecognitionException {
		If_exprContext _localctx = new If_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_if_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(IF);
			setState(176);
			match(LPAR);
			setState(177);
			logic_expr();
			setState(178);
			match(RPAR);
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case CONST:
			case IF:
			case FOR:
			case WHILE:
			case RETURN:
			case VARIABLE_NAME:
				{
				setState(179);
				expression();
				}
				break;
			case LGROUP:
				{
				setState(180);
				match(LGROUP);
				setState(181);
				expression_generator();
				setState(182);
				match(RGROUP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(186);
				match(ELSE);
				setState(192);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
				case FLOAT:
				case DOUBLE:
				case STRING:
				case CONST:
				case IF:
				case FOR:
				case WHILE:
				case RETURN:
				case VARIABLE_NAME:
					{
					setState(187);
					expression();
					}
					break;
				case LGROUP:
					{
					setState(188);
					match(LGROUP);
					setState(189);
					expression_generator();
					setState(190);
					match(RGROUP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class For_exprContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(OurCompilerParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(OurCompilerParser.LPAR, 0); }
		public List<TerminalNode> EOL() { return getTokens(OurCompilerParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(OurCompilerParser.EOL, i);
		}
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(OurCompilerParser.RPAR, 0); }
		public List<Var_assign_exprContext> var_assign_expr() {
			return getRuleContexts(Var_assign_exprContext.class);
		}
		public Var_assign_exprContext var_assign_expr(int i) {
			return getRuleContext(Var_assign_exprContext.class,i);
		}
		public Var_decl_assg_exprContext var_decl_assg_expr() {
			return getRuleContext(Var_decl_assg_exprContext.class,0);
		}
		public Crement_exprContext crement_expr() {
			return getRuleContext(Crement_exprContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LGROUP() { return getToken(OurCompilerParser.LGROUP, 0); }
		public Expression_generatorContext expression_generator() {
			return getRuleContext(Expression_generatorContext.class,0);
		}
		public TerminalNode RGROUP() { return getToken(OurCompilerParser.RGROUP, 0); }
		public For_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterFor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitFor_expr(this);
		}
	}

	public final For_exprContext for_expr() throws RecognitionException {
		For_exprContext _localctx = new For_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_for_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(FOR);
			setState(197);
			match(LPAR);
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE_NAME:
				{
				setState(198);
				var_assign_expr();
				}
				break;
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case CONST:
				{
				setState(199);
				var_decl_assg_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(202);
			match(EOL);
			setState(203);
			logic_expr();
			setState(204);
			match(EOL);
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(205);
				crement_expr();
				}
				break;
			case 2:
				{
				setState(206);
				var_assign_expr();
				}
				break;
			}
			setState(209);
			match(RPAR);
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case CONST:
			case IF:
			case FOR:
			case WHILE:
			case RETURN:
			case VARIABLE_NAME:
				{
				setState(210);
				expression();
				}
				break;
			case LGROUP:
				{
				setState(211);
				match(LGROUP);
				setState(212);
				expression_generator();
				setState(213);
				match(RGROUP);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class While_exprContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(OurCompilerParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(OurCompilerParser.LPAR, 0); }
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(OurCompilerParser.RPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LGROUP() { return getToken(OurCompilerParser.LGROUP, 0); }
		public Expression_generatorContext expression_generator() {
			return getRuleContext(Expression_generatorContext.class,0);
		}
		public TerminalNode RGROUP() { return getToken(OurCompilerParser.RGROUP, 0); }
		public While_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterWhile_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitWhile_expr(this);
		}
	}

	public final While_exprContext while_expr() throws RecognitionException {
		While_exprContext _localctx = new While_exprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_while_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(WHILE);
			setState(218);
			match(LPAR);
			setState(219);
			logic_expr();
			setState(220);
			match(RPAR);
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case CONST:
			case IF:
			case FOR:
			case WHILE:
			case RETURN:
			case VARIABLE_NAME:
				{
				setState(221);
				expression();
				}
				break;
			case LGROUP:
				{
				setState(222);
				match(LGROUP);
				setState(223);
				expression_generator();
				setState(224);
				match(RGROUP);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Return_exprContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(OurCompilerParser.RETURN, 0); }
		public Pure_dataContext pure_data() {
			return getRuleContext(Pure_dataContext.class,0);
		}
		public TerminalNode VARIABLE_NAME() { return getToken(OurCompilerParser.VARIABLE_NAME, 0); }
		public Math_exprContext math_expr() {
			return getRuleContext(Math_exprContext.class,0);
		}
		public Return_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).enterReturn_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OurCompilerListener ) ((OurCompilerListener)listener).exitReturn_expr(this);
		}
	}

	public final Return_exprContext return_expr() throws RecognitionException {
		Return_exprContext _localctx = new Return_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_return_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(RETURN);
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(229);
				pure_data();
				}
				break;
			case 2:
				{
				setState(230);
				match(VARIABLE_NAME);
				}
				break;
			case 3:
				{
				setState(231);
				math_expr();
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

	public static final String _serializedATN =
		"\u0004\u0001/\u00eb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0001\u0003\u0001"+
		",\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0003\u00034\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00039\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		">\b\u0003\u0005\u0003@\b\u0003\n\u0003\f\u0003C\t\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004G\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007S\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007]\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007a\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\tm\b"+
		"\t\u000b\t\f\tn\u0001\t\u0001\t\u0001\n\u0001\n\u0003\nu\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u007f\b\n\u0003"+
		"\n\u0081\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0005"+
		"\u000b\u0089\b\u000b\n\u000b\f\u000b\u008c\t\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0093\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u009a\b\f\u0003\f\u009c\b\f\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00a6\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00ae\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00b9\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00c1\b\u0010\u0003\u0010\u00c3\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00c9\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00d0"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u00d8\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u00e3\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00e9\b\u0013\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000"+
		"\u0006\u0001\u0000,/\u0001\u0000\u0003\u0006\u0001\u0000\u000e\u0012\u0001"+
		"\u0000\u001c!\u0001\u0000\u0013\u0014\u0001\u0000\"#\u00fa\u0000(\u0001"+
		"\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000"+
		"\u0000\u00063\u0001\u0000\u0000\u0000\bF\u0001\u0000\u0000\u0000\nH\u0001"+
		"\u0000\u0000\u0000\fJ\u0001\u0000\u0000\u0000\u000e`\u0001\u0000\u0000"+
		"\u0000\u0010b\u0001\u0000\u0000\u0000\u0012l\u0001\u0000\u0000\u0000\u0014"+
		"t\u0001\u0000\u0000\u0000\u0016\u008a\u0001\u0000\u0000\u0000\u0018\u009b"+
		"\u0001\u0000\u0000\u0000\u001a\u009d\u0001\u0000\u0000\u0000\u001c\u00a0"+
		"\u0001\u0000\u0000\u0000\u001e\u00a7\u0001\u0000\u0000\u0000 \u00af\u0001"+
		"\u0000\u0000\u0000\"\u00c4\u0001\u0000\u0000\u0000$\u00d9\u0001\u0000"+
		"\u0000\u0000&\u00e4\u0001\u0000\u0000\u0000()\u0007\u0000\u0000\u0000"+
		")\u0001\u0001\u0000\u0000\u0000*,\u0005\u0007\u0000\u0000+*\u0001\u0000"+
		"\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0007"+
		"\u0001\u0000\u0000.\u0003\u0001\u0000\u0000\u0000/0\u0007\u0002\u0000"+
		"\u00000\u0005\u0001\u0000\u0000\u000014\u0005+\u0000\u000024\u0003\u0000"+
		"\u0000\u000031\u0001\u0000\u0000\u000032\u0001\u0000\u0000\u000045\u0001"+
		"\u0000\u0000\u000058\u0003\u0004\u0002\u000069\u0005+\u0000\u000079\u0003"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u000087\u0001\u0000\u0000\u0000"+
		"9A\u0001\u0000\u0000\u0000:=\u0003\u0004\u0002\u0000;>\u0005+\u0000\u0000"+
		"<>\u0003\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=<\u0001\u0000\u0000"+
		"\u0000>@\u0001\u0000\u0000\u0000?:\u0001\u0000\u0000\u0000@C\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B\u0007"+
		"\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DG\u0005+\u0000\u0000"+
		"EG\u0003\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000"+
		"\u0000G\t\u0001\u0000\u0000\u0000HI\u0007\u0003\u0000\u0000I\u000b\u0001"+
		"\u0000\u0000\u0000JK\u0007\u0004\u0000\u0000K\r\u0001\u0000\u0000\u0000"+
		"LM\u0003\b\u0004\u0000MN\u0003\n\u0005\u0000NR\u0003\b\u0004\u0000OP\u0003"+
		"\f\u0006\u0000PQ\u0003\u000e\u0007\u0000QS\u0001\u0000\u0000\u0000RO\u0001"+
		"\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000Sa\u0001\u0000\u0000\u0000"+
		"TU\u0005\u0015\u0000\u0000UV\u0005$\u0000\u0000VW\u0003\b\u0004\u0000"+
		"WX\u0003\n\u0005\u0000X\\\u0003\b\u0004\u0000YZ\u0003\f\u0006\u0000Z["+
		"\u0003\u000e\u0007\u0000[]\u0001\u0000\u0000\u0000\\Y\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0005%\u0000"+
		"\u0000_a\u0001\u0000\u0000\u0000`L\u0001\u0000\u0000\u0000`T\u0001\u0000"+
		"\u0000\u0000a\u000f\u0001\u0000\u0000\u0000bc\u0005+\u0000\u0000cd\u0007"+
		"\u0005\u0000\u0000d\u0011\u0001\u0000\u0000\u0000em\u0003\u0014\n\u0000"+
		"fg\u0003\u001a\r\u0000gh\u0005(\u0000\u0000hm\u0001\u0000\u0000\u0000"+
		"ij\u0003\u001e\u000f\u0000jk\u0005(\u0000\u0000km\u0001\u0000\u0000\u0000"+
		"le\u0001\u0000\u0000\u0000lf\u0001\u0000\u0000\u0000li\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0005\u0000\u0000\u0001q\u0013"+
		"\u0001\u0000\u0000\u0000ru\u0003\u0002\u0001\u0000su\u0005\b\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vw\u0005+\u0000\u0000w\u0080\u0005$\u0000\u0000xy\u0003\u0002\u0001"+
		"\u0000y~\u0005+\u0000\u0000z{\u0005)\u0000\u0000{|\u0003\u0002\u0001\u0000"+
		"|}\u0005+\u0000\u0000}\u007f\u0001\u0000\u0000\u0000~z\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000"+
		"\u0080x\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0005%\u0000\u0000\u0083\u0084"+
		"\u0005&\u0000\u0000\u0084\u0085\u0003\u0016\u000b\u0000\u0085\u0086\u0005"+
		"\'\u0000\u0000\u0086\u0015\u0001\u0000\u0000\u0000\u0087\u0089\u0003\u0018"+
		"\f\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000"+
		"\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000"+
		"\u0000\u008b\u0017\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008d\u0093\u0003\u001a\r\u0000\u008e\u0093\u0003\u001c\u000e\u0000"+
		"\u008f\u0093\u0003\u001e\u000f\u0000\u0090\u0093\u0003\u0010\b\u0000\u0091"+
		"\u0093\u0003&\u0013\u0000\u0092\u008d\u0001\u0000\u0000\u0000\u0092\u008e"+
		"\u0001\u0000\u0000\u0000\u0092\u008f\u0001\u0000\u0000\u0000\u0092\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0005(\u0000\u0000\u0095\u009c\u0001"+
		"\u0000\u0000\u0000\u0096\u009a\u0003 \u0010\u0000\u0097\u009a\u0003\""+
		"\u0011\u0000\u0098\u009a\u0003$\u0012\u0000\u0099\u0096\u0001\u0000\u0000"+
		"\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000"+
		"\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u0092\u0001\u0000\u0000"+
		"\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u0019\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0003\u0002\u0001\u0000\u009e\u009f\u0005+\u0000\u0000"+
		"\u009f\u001b\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005+\u0000\u0000\u00a1"+
		"\u00a5\u0005\u0016\u0000\u0000\u00a2\u00a6\u0003\u0000\u0000\u0000\u00a3"+
		"\u00a6\u0005+\u0000\u0000\u00a4\u00a6\u0003\u0006\u0003\u0000\u00a5\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a6\u001d\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0003\u0002\u0001\u0000\u00a8\u00a9\u0005+\u0000\u0000\u00a9\u00ad\u0005"+
		"\u0016\u0000\u0000\u00aa\u00ae\u0003\u0000\u0000\u0000\u00ab\u00ae\u0005"+
		"+\u0000\u0000\u00ac\u00ae\u0003\u0006\u0003\u0000\u00ad\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ae\u001f\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\t\u0000"+
		"\u0000\u00b0\u00b1\u0005$\u0000\u0000\u00b1\u00b2\u0003\u000e\u0007\u0000"+
		"\u00b2\u00b8\u0005%\u0000\u0000\u00b3\u00b9\u0003\u0018\f\u0000\u00b4"+
		"\u00b5\u0005&\u0000\u0000\u00b5\u00b6\u0003\u0016\u000b\u0000\u00b6\u00b7"+
		"\u0005\'\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000\u0000\u00b9\u00c2\u0001"+
		"\u0000\u0000\u0000\u00ba\u00c0\u0005\n\u0000\u0000\u00bb\u00c1\u0003\u0018"+
		"\f\u0000\u00bc\u00bd\u0005&\u0000\u0000\u00bd\u00be\u0003\u0016\u000b"+
		"\u0000\u00be\u00bf\u0005\'\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c0\u00bb\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00ba\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3!\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0005\u000b\u0000\u0000\u00c5\u00c8\u0005$\u0000\u0000\u00c6\u00c9"+
		"\u0003\u001c\u000e\u0000\u00c7\u00c9\u0003\u001e\u000f\u0000\u00c8\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005(\u0000\u0000\u00cb\u00cc\u0003"+
		"\u000e\u0007\u0000\u00cc\u00cf\u0005(\u0000\u0000\u00cd\u00d0\u0003\u0010"+
		"\b\u0000\u00ce\u00d0\u0003\u001c\u000e\u0000\u00cf\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d7\u0005%\u0000\u0000\u00d2\u00d8\u0003\u0018\f\u0000"+
		"\u00d3\u00d4\u0005&\u0000\u0000\u00d4\u00d5\u0003\u0016\u000b\u0000\u00d5"+
		"\u00d6\u0005\'\u0000\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d3\u0001\u0000\u0000\u0000\u00d8#\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0005\f\u0000\u0000\u00da\u00db\u0005$"+
		"\u0000\u0000\u00db\u00dc\u0003\u000e\u0007\u0000\u00dc\u00e2\u0005%\u0000"+
		"\u0000\u00dd\u00e3\u0003\u0018\f\u0000\u00de\u00df\u0005&\u0000\u0000"+
		"\u00df\u00e0\u0003\u0016\u000b\u0000\u00e0\u00e1\u0005\'\u0000\u0000\u00e1"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e2\u00dd\u0001\u0000\u0000\u0000\u00e2"+
		"\u00de\u0001\u0000\u0000\u0000\u00e3%\u0001\u0000\u0000\u0000\u00e4\u00e8"+
		"\u0005\r\u0000\u0000\u00e5\u00e9\u0003\u0000\u0000\u0000\u00e6\u00e9\u0005"+
		"+\u0000\u0000\u00e7\u00e9\u0003\u0006\u0003\u0000\u00e8\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e9\'\u0001\u0000\u0000\u0000\u001c+38=AFR\\`lnt~\u0080"+
		"\u008a\u0092\u0099\u009b\u00a5\u00ad\u00b8\u00c0\u00c2\u00c8\u00cf\u00d7"+
		"\u00e2\u00e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}