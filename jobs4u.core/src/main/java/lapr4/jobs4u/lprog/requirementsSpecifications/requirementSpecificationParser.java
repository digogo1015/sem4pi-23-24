// Generated from C:/Users/tiago/IdeaProjects/sem4pi-23-24-2dl1/jobs4u.core/src/main/java/lapr4/jobs4u/lprog/requirementsSpecifications/requirementSpecification.g4 by ANTLR 4.13.1
package lapr4.jobs4u.lprog.requirementsSpecifications;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class requirementSpecificationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, TK_TEXT=8, TK_LETTER=9, 
		TK_DIGIT=10, NEWLINE=11, WS=12, TEXT=13;
	public static final int
		RULE_start = 0, RULE_requirements = 1, RULE_answers = 2, RULE_reqOptionInt = 3, 
		RULE_ansOptionInt = 4, RULE_reqOneOption = 5, RULE_ansOneOption = 6, RULE_reqMultipleOption = 7, 
		RULE_ansMultipleOption = 8, RULE_phrase = 9, RULE_choices = 10, RULE_requirement = 11, 
		RULE_answerField = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "requirements", "answers", "reqOptionInt", "ansOptionInt", "reqOneOption", 
			"ansOneOption", "reqMultipleOption", "ansMultipleOption", "phrase", "choices", 
			"requirement", "answerField"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'(integer)'", "'('", "')'", "', '", "'; '", "'# '", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "TK_TEXT", "TK_LETTER", 
			"TK_DIGIT", "NEWLINE", "WS", "TEXT"
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
	public String getGrammarFileName() { return "requirementSpecification.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public requirementSpecificationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(requirementSpecificationParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(requirementSpecificationParser.NEWLINE, i);
		}
		public List<RequirementsContext> requirements() {
			return getRuleContexts(RequirementsContext.class);
		}
		public RequirementsContext requirements(int i) {
			return getRuleContext(RequirementsContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(26);
					requirements();
					}
				}

				setState(29);
				match(NEWLINE);
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 || _la==NEWLINE );
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
	public static class RequirementsContext extends ParserRuleContext {
		public ReqOptionIntContext reqOptionInt() {
			return getRuleContext(ReqOptionIntContext.class,0);
		}
		public ReqOneOptionContext reqOneOption() {
			return getRuleContext(ReqOneOptionContext.class,0);
		}
		public ReqMultipleOptionContext reqMultipleOption() {
			return getRuleContext(ReqMultipleOptionContext.class,0);
		}
		public RequirementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterRequirements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitRequirements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitRequirements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementsContext requirements() throws RecognitionException {
		RequirementsContext _localctx = new RequirementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_requirements);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				reqOptionInt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				reqOneOption();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				reqMultipleOption();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnswersContext extends ParserRuleContext {
		public AnsOptionIntContext ansOptionInt() {
			return getRuleContext(AnsOptionIntContext.class,0);
		}
		public AnsOneOptionContext ansOneOption() {
			return getRuleContext(AnsOneOptionContext.class,0);
		}
		public AnsMultipleOptionContext ansMultipleOption() {
			return getRuleContext(AnsMultipleOptionContext.class,0);
		}
		public AnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitAnswers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitAnswers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswersContext answers() throws RecognitionException {
		AnswersContext _localctx = new AnswersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_answers);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				ansOptionInt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				ansOneOption();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				ansMultipleOption();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReqOptionIntContext extends ParserRuleContext {
		public RequirementContext requirement() {
			return getRuleContext(RequirementContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(requirementSpecificationParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AnsOptionIntContext ansOptionInt() {
			return getRuleContext(AnsOptionIntContext.class,0);
		}
		public ReqOptionIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reqOptionInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterReqOptionInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitReqOptionInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitReqOptionInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReqOptionIntContext reqOptionInt() throws RecognitionException {
		ReqOptionIntContext _localctx = new ReqOptionIntContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_reqOptionInt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			requirement();
			setState(45);
			match(T__0);
			setState(46);
			match(NEWLINE);
			setState(47);
			answerField();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_DIGIT) {
				{
				setState(48);
				ansOptionInt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnsOptionIntContext extends ParserRuleContext {
		public List<TerminalNode> TK_DIGIT() { return getTokens(requirementSpecificationParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(requirementSpecificationParser.TK_DIGIT, i);
		}
		public AnsOptionIntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ansOptionInt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterAnsOptionInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitAnsOptionInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitAnsOptionInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnsOptionIntContext ansOptionInt() throws RecognitionException {
		AnsOptionIntContext _localctx = new AnsOptionIntContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ansOptionInt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51);
				match(TK_DIGIT);
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_DIGIT );
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
	public static class ReqOneOptionContext extends ParserRuleContext {
		public RequirementContext requirement() {
			return getRuleContext(RequirementContext.class,0);
		}
		public ChoicesContext choices() {
			return getRuleContext(ChoicesContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(requirementSpecificationParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AnsOneOptionContext ansOneOption() {
			return getRuleContext(AnsOneOptionContext.class,0);
		}
		public ReqOneOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reqOneOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterReqOneOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitReqOneOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitReqOneOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReqOneOptionContext reqOneOption() throws RecognitionException {
		ReqOneOptionContext _localctx = new ReqOneOptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_reqOneOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			requirement();
			setState(57);
			match(T__1);
			setState(58);
			choices();
			setState(59);
			match(T__2);
			setState(60);
			match(NEWLINE);
			setState(61);
			answerField();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_TEXT || _la==TK_DIGIT) {
				{
				setState(62);
				ansOneOption();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnsOneOptionContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public AnsOneOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ansOneOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterAnsOneOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitAnsOneOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitAnsOneOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnsOneOptionContext ansOneOption() throws RecognitionException {
		AnsOneOptionContext _localctx = new AnsOneOptionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ansOneOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			phrase();
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
	public static class ReqMultipleOptionContext extends ParserRuleContext {
		public RequirementContext requirement() {
			return getRuleContext(RequirementContext.class,0);
		}
		public ChoicesContext choices() {
			return getRuleContext(ChoicesContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(requirementSpecificationParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AnsMultipleOptionContext ansMultipleOption() {
			return getRuleContext(AnsMultipleOptionContext.class,0);
		}
		public ReqMultipleOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reqMultipleOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterReqMultipleOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitReqMultipleOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitReqMultipleOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReqMultipleOptionContext reqMultipleOption() throws RecognitionException {
		ReqMultipleOptionContext _localctx = new ReqMultipleOptionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_reqMultipleOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			requirement();
			setState(68);
			match(T__1);
			setState(69);
			choices();
			setState(70);
			match(T__2);
			setState(71);
			match(NEWLINE);
			setState(72);
			answerField();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_TEXT || _la==TK_DIGIT) {
				{
				setState(73);
				ansMultipleOption();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnsMultipleOptionContext extends ParserRuleContext {
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public AnsMultipleOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ansMultipleOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterAnsMultipleOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitAnsMultipleOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitAnsMultipleOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnsMultipleOptionContext ansMultipleOption() throws RecognitionException {
		AnsMultipleOptionContext _localctx = new AnsMultipleOptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ansMultipleOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			phrase();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(77);
				match(T__3);
				setState(78);
				phrase();
				}
				}
				setState(83);
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
	public static class PhraseContext extends ParserRuleContext {
		public List<TerminalNode> TK_TEXT() { return getTokens(requirementSpecificationParser.TK_TEXT); }
		public TerminalNode TK_TEXT(int i) {
			return getToken(requirementSpecificationParser.TK_TEXT, i);
		}
		public List<TerminalNode> TK_DIGIT() { return getTokens(requirementSpecificationParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(requirementSpecificationParser.TK_DIGIT, i);
		}
		public List<TerminalNode> WS() { return getTokens(requirementSpecificationParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(requirementSpecificationParser.WS, i);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_phrase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TK_TEXT:
				{
				setState(84);
				match(TK_TEXT);
				}
				break;
			case TK_DIGIT:
				{
				setState(86); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(85);
						match(TK_DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(88); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5376L) != 0)) {
				{
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(92);
					match(WS);
					}
				}

				setState(101);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TK_TEXT:
					{
					setState(95);
					match(TK_TEXT);
					}
					break;
				case TK_DIGIT:
					{
					setState(97); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(96);
							match(TK_DIGIT);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(99); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(107);
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
	public static class ChoicesContext extends ParserRuleContext {
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public ChoicesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choices; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterChoices(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitChoices(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitChoices(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoicesContext choices() throws RecognitionException {
		ChoicesContext _localctx = new ChoicesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_choices);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			phrase();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(109);
				match(T__4);
				setState(110);
				phrase();
				}
				}
				setState(115);
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
	public static class RequirementContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public RequirementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requirement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterRequirement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitRequirement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitRequirement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequirementContext requirement() throws RecognitionException {
		RequirementContext _localctx = new RequirementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_requirement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__5);
			setState(117);
			phrase();
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
	public static class AnswerFieldContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public AnswerFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).enterAnswerField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof requirementSpecificationListener ) ((requirementSpecificationListener)listener).exitAnswerField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof requirementSpecificationVisitor ) return ((requirementSpecificationVisitor<? extends T>)visitor).visitAnswerField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerFieldContext answerField() throws RecognitionException {
		AnswerFieldContext _localctx = new AnswerFieldContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_answerField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			phrase();
			setState(120);
			match(T__6);
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
		"\u0004\u0001\r{\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0003\u0000\u001c\b\u0000\u0001\u0000\u0004\u0000"+
		"\u001f\b\u0000\u000b\u0000\f\u0000 \u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001&\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"+\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00032\b\u0003\u0001\u0004\u0004\u00045\b\u0004\u000b\u0004\f\u0004"+
		"6\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005@\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007K\b\u0007\u0001\b\u0001\b\u0001\b\u0005\bP\b\b\n\b\f\bS\t"+
		"\b\u0001\t\u0001\t\u0004\tW\b\t\u000b\t\f\tX\u0003\t[\b\t\u0001\t\u0003"+
		"\t^\b\t\u0001\t\u0001\t\u0004\tb\b\t\u000b\t\f\tc\u0003\tf\b\t\u0005\t"+
		"h\b\t\n\t\f\tk\t\t\u0001\n\u0001\n\u0001\n\u0005\np\b\n\n\n\f\ns\t\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0000\u0000"+
		"\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000"+
		"\u0000\u007f\u0000\u001e\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000"+
		"\u0000\u0004*\u0001\u0000\u0000\u0000\u0006,\u0001\u0000\u0000\u0000\b"+
		"4\u0001\u0000\u0000\u0000\n8\u0001\u0000\u0000\u0000\fA\u0001\u0000\u0000"+
		"\u0000\u000eC\u0001\u0000\u0000\u0000\u0010L\u0001\u0000\u0000\u0000\u0012"+
		"Z\u0001\u0000\u0000\u0000\u0014l\u0001\u0000\u0000\u0000\u0016t\u0001"+
		"\u0000\u0000\u0000\u0018w\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0002"+
		"\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001f\u0005\u000b"+
		"\u0000\u0000\u001e\u001b\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000"+
		"\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0001"+
		"\u0001\u0000\u0000\u0000\"&\u0003\u0006\u0003\u0000#&\u0003\n\u0005\u0000"+
		"$&\u0003\u000e\u0007\u0000%\"\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000"+
		"\u0000%$\u0001\u0000\u0000\u0000&\u0003\u0001\u0000\u0000\u0000\'+\u0003"+
		"\b\u0004\u0000(+\u0003\f\u0006\u0000)+\u0003\u0010\b\u0000*\'\u0001\u0000"+
		"\u0000\u0000*(\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000\u0000+\u0005"+
		"\u0001\u0000\u0000\u0000,-\u0003\u0016\u000b\u0000-.\u0005\u0001\u0000"+
		"\u0000./\u0005\u000b\u0000\u0000/1\u0003\u0018\f\u000002\u0003\b\u0004"+
		"\u000010\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0007\u0001"+
		"\u0000\u0000\u000035\u0005\n\u0000\u000043\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"7\t\u0001\u0000\u0000\u000089\u0003\u0016\u000b\u00009:\u0005\u0002\u0000"+
		"\u0000:;\u0003\u0014\n\u0000;<\u0005\u0003\u0000\u0000<=\u0005\u000b\u0000"+
		"\u0000=?\u0003\u0018\f\u0000>@\u0003\f\u0006\u0000?>\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@\u000b\u0001\u0000\u0000\u0000AB\u0003"+
		"\u0012\t\u0000B\r\u0001\u0000\u0000\u0000CD\u0003\u0016\u000b\u0000DE"+
		"\u0005\u0002\u0000\u0000EF\u0003\u0014\n\u0000FG\u0005\u0003\u0000\u0000"+
		"GH\u0005\u000b\u0000\u0000HJ\u0003\u0018\f\u0000IK\u0003\u0010\b\u0000"+
		"JI\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u000f\u0001\u0000"+
		"\u0000\u0000LQ\u0003\u0012\t\u0000MN\u0005\u0004\u0000\u0000NP\u0003\u0012"+
		"\t\u0000OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000R\u0011\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000T[\u0005\b\u0000\u0000UW\u0005\n\u0000\u0000"+
		"VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000ZT\u0001\u0000"+
		"\u0000\u0000ZV\u0001\u0000\u0000\u0000[i\u0001\u0000\u0000\u0000\\^\u0005"+
		"\f\u0000\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^e"+
		"\u0001\u0000\u0000\u0000_f\u0005\b\u0000\u0000`b\u0005\n\u0000\u0000a"+
		"`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000"+
		"\u0000cd\u0001\u0000\u0000\u0000df\u0001\u0000\u0000\u0000e_\u0001\u0000"+
		"\u0000\u0000ea\u0001\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000g]\u0001"+
		"\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000j\u0013\u0001\u0000\u0000\u0000ki\u0001\u0000"+
		"\u0000\u0000lq\u0003\u0012\t\u0000mn\u0005\u0005\u0000\u0000np\u0003\u0012"+
		"\t\u0000om\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000"+
		"\u0000\u0000qr\u0001\u0000\u0000\u0000r\u0015\u0001\u0000\u0000\u0000"+
		"sq\u0001\u0000\u0000\u0000tu\u0005\u0006\u0000\u0000uv\u0003\u0012\t\u0000"+
		"v\u0017\u0001\u0000\u0000\u0000wx\u0003\u0012\t\u0000xy\u0005\u0007\u0000"+
		"\u0000y\u0019\u0001\u0000\u0000\u0000\u0010\u001b %*16?JQXZ]ceiq";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}