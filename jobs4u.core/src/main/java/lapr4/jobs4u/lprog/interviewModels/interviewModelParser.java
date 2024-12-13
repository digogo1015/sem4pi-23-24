// Generated from C:/Users/tiago/IdeaProjects/sem4pi-23-24-2dl1/jobs4u.core/src/main/java/lapr4/jobs4u/lprog/interviewModels/interviewModel.g4 by ANTLR 4.13.1
package lapr4.jobs4u.lprog.interviewModels;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class interviewModelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, TK_TRUE=16, 
		TK_FALSE=17, TK_TEXT=18, TK_LETTER=19, TK_DIGIT=20, TK_DATE=21, TK_TIME=22, 
		TK_QUEST=23, NEWLINE=24, WS=25, TEXT=26;
	public static final int
		RULE_start = 0, RULE_questions = 1, RULE_answers = 2, RULE_qtruefalse = 3, 
		RULE_atruefalse = 4, RULE_rtruefalse = 5, RULE_qshorttextanswer = 6, RULE_ashorttextanswer = 7, 
		RULE_rshorttextanswer = 8, RULE_qchoicesingle = 9, RULE_achoicesingle = 10, 
		RULE_rchoicesingle = 11, RULE_qchoicemultiple = 12, RULE_achoicemultiple = 13, 
		RULE_rchoicemultiple = 14, RULE_qintegernumber = 15, RULE_aintegernumber = 16, 
		RULE_rintegernumber = 17, RULE_qdecimalnumber = 18, RULE_adecimalnumber = 19, 
		RULE_rdecimalnumber = 20, RULE_qdate = 21, RULE_adate = 22, RULE_rdate = 23, 
		RULE_qtime = 24, RULE_atime = 25, RULE_rtime = 26, RULE_qnumericscale = 27, 
		RULE_anumericscale = 28, RULE_rnumericscale = 29, RULE_question = 30, 
		RULE_phrase = 31, RULE_choices = 32, RULE_choiceNumber = 33, RULE_choice = 34, 
		RULE_answerField = 35, RULE_mark = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "questions", "answers", "qtruefalse", "atruefalse", "rtruefalse", 
			"qshorttextanswer", "ashorttextanswer", "rshorttextanswer", "qchoicesingle", 
			"achoicesingle", "rchoicesingle", "qchoicemultiple", "achoicemultiple", 
			"rchoicemultiple", "qintegernumber", "aintegernumber", "rintegernumber", 
			"qdecimalnumber", "adecimalnumber", "rdecimalnumber", "qdate", "adate", 
			"rdate", "qtime", "atime", "rtime", "qnumericscale", "anumericscale", 
			"rnumericscale", "question", "phrase", "choices", "choiceNumber", "choice", 
			"answerField", "mark"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'[TRUE/FALSE]'", "'-'", "'[LIMIT OF ANSWER SIZE: '", "' CHARS]'", 
			"'[SINGLE CHOICE]'", "'[MULTIPLE CHOICE]'", "','", "'[INTEGER ANSWER]'", 
			"'[DECIMAL ANSWER WITH TWO DECIMAL PLACES]'", "'.'", "'[DATE ANSWER WITH FORMAT: DD/MM/YYYY]'", 
			"'[TIME ANSWER WITH FORMAT: hh:mm]'", "'[ANSWER BETWEEN:'", "']'", "':'", 
			null, null, null, null, null, null, null, "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "TK_TRUE", "TK_FALSE", "TK_TEXT", "TK_LETTER", 
			"TK_DIGIT", "TK_DATE", "TK_TIME", "TK_QUEST", "NEWLINE", "WS", "TEXT"
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
	public String getGrammarFileName() { return "interviewModel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    int totalMarks = 0;

	    public int getTotalMarks() {
	            return totalMarks;
	        }

	public interviewModelParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(interviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(interviewModelParser.NEWLINE, i);
		}
		public List<QuestionsContext> questions() {
			return getRuleContexts(QuestionsContext.class);
		}
		public QuestionsContext questions(int i) {
			return getRuleContext(QuestionsContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitStart(this);
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
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TK_TEXT || _la==TK_DIGIT) {
					{
					setState(74);
					questions();
					}
				}

				setState(77);
				match(NEWLINE);
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 18087936L) != 0) );
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
	public static class QuestionsContext extends ParserRuleContext {
		public QshorttextanswerContext qshorttextanswer() {
			return getRuleContext(QshorttextanswerContext.class,0);
		}
		public QchoicemultipleContext qchoicemultiple() {
			return getRuleContext(QchoicemultipleContext.class,0);
		}
		public QchoicesingleContext qchoicesingle() {
			return getRuleContext(QchoicesingleContext.class,0);
		}
		public QdateContext qdate() {
			return getRuleContext(QdateContext.class,0);
		}
		public QtruefalseContext qtruefalse() {
			return getRuleContext(QtruefalseContext.class,0);
		}
		public QtimeContext qtime() {
			return getRuleContext(QtimeContext.class,0);
		}
		public QintegernumberContext qintegernumber() {
			return getRuleContext(QintegernumberContext.class,0);
		}
		public QnumericscaleContext qnumericscale() {
			return getRuleContext(QnumericscaleContext.class,0);
		}
		public QdecimalnumberContext qdecimalnumber() {
			return getRuleContext(QdecimalnumberContext.class,0);
		}
		public QuestionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQuestions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQuestions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQuestions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionsContext questions() throws RecognitionException {
		QuestionsContext _localctx = new QuestionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_questions);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				qshorttextanswer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				qchoicemultiple();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				qchoicesingle();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				qdate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				qtruefalse();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(87);
				qtime();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(88);
				qintegernumber();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(89);
				qnumericscale();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(90);
				qdecimalnumber();
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
		public AshorttextanswerContext ashorttextanswer() {
			return getRuleContext(AshorttextanswerContext.class,0);
		}
		public AchoicemultipleContext achoicemultiple() {
			return getRuleContext(AchoicemultipleContext.class,0);
		}
		public AchoicesingleContext achoicesingle() {
			return getRuleContext(AchoicesingleContext.class,0);
		}
		public AdateContext adate() {
			return getRuleContext(AdateContext.class,0);
		}
		public AtruefalseContext atruefalse() {
			return getRuleContext(AtruefalseContext.class,0);
		}
		public AtimeContext atime() {
			return getRuleContext(AtimeContext.class,0);
		}
		public AintegernumberContext aintegernumber() {
			return getRuleContext(AintegernumberContext.class,0);
		}
		public AnumericscaleContext anumericscale() {
			return getRuleContext(AnumericscaleContext.class,0);
		}
		public AdecimalnumberContext adecimalnumber() {
			return getRuleContext(AdecimalnumberContext.class,0);
		}
		public AnswersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAnswers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAnswers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAnswers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswersContext answers() throws RecognitionException {
		AnswersContext _localctx = new AnswersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_answers);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				ashorttextanswer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				achoicemultiple();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				achoicesingle();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				adate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				atruefalse();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(98);
				atime();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
				aintegernumber();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(100);
				anumericscale();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(101);
				adecimalnumber();
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
	public static class QtruefalseContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(interviewModelParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AtruefalseContext atruefalse() {
			return getRuleContext(AtruefalseContext.class,0);
		}
		public QtruefalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qtruefalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQtruefalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQtruefalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQtruefalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QtruefalseContext qtruefalse() throws RecognitionException {
		QtruefalseContext _localctx = new QtruefalseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_qtruefalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			question();
			setState(105);
			match(T__0);
			setState(106);
			match(NEWLINE);
			setState(107);
			answerField();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_TRUE || _la==TK_FALSE) {
				{
				setState(108);
				atruefalse();
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
	public static class AtruefalseContext extends ParserRuleContext {
		public RtruefalseContext rtruefalse() {
			return getRuleContext(RtruefalseContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public AtruefalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atruefalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAtruefalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAtruefalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAtruefalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtruefalseContext atruefalse() throws RecognitionException {
		AtruefalseContext _localctx = new AtruefalseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atruefalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(111);
			rtruefalse();
			}
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(112);
				match(T__1);
				setState(113);
				mark();
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
	public static class RtruefalseContext extends ParserRuleContext {
		public TerminalNode TK_TRUE() { return getToken(interviewModelParser.TK_TRUE, 0); }
		public TerminalNode TK_FALSE() { return getToken(interviewModelParser.TK_FALSE, 0); }
		public RtruefalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rtruefalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterRtruefalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitRtruefalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitRtruefalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RtruefalseContext rtruefalse() throws RecognitionException {
		RtruefalseContext _localctx = new RtruefalseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rtruefalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if ( !(_la==TK_TRUE || _la==TK_FALSE) ) {
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
	public static class QshorttextanswerContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(interviewModelParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AshorttextanswerContext ashorttextanswer() {
			return getRuleContext(AshorttextanswerContext.class,0);
		}
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public QshorttextanswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qshorttextanswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQshorttextanswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQshorttextanswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQshorttextanswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QshorttextanswerContext qshorttextanswer() throws RecognitionException {
		QshorttextanswerContext _localctx = new QshorttextanswerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_qshorttextanswer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			question();
			setState(119);
			match(T__2);
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(121); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(120);
						match(TK_DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(123); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_DIGIT );
			setState(129);
			match(T__3);
			setState(130);
			match(NEWLINE);
			setState(131);
			answerField();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_TEXT || _la==TK_DIGIT) {
				{
				setState(132);
				ashorttextanswer();
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
	public static class AshorttextanswerContext extends ParserRuleContext {
		public RshorttextanswerContext rshorttextanswer() {
			return getRuleContext(RshorttextanswerContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public AshorttextanswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ashorttextanswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAshorttextanswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAshorttextanswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAshorttextanswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AshorttextanswerContext ashorttextanswer() throws RecognitionException {
		AshorttextanswerContext _localctx = new AshorttextanswerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ashorttextanswer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			rshorttextanswer();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(136);
				match(T__1);
				setState(137);
				mark();
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
	public static class RshorttextanswerContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public RshorttextanswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rshorttextanswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterRshorttextanswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitRshorttextanswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitRshorttextanswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RshorttextanswerContext rshorttextanswer() throws RecognitionException {
		RshorttextanswerContext _localctx = new RshorttextanswerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rshorttextanswer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
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
	public static class QchoicesingleContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(interviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(interviewModelParser.NEWLINE, i);
		}
		public ChoicesContext choices() {
			return getRuleContext(ChoicesContext.class,0);
		}
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AchoicesingleContext achoicesingle() {
			return getRuleContext(AchoicesingleContext.class,0);
		}
		public QchoicesingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qchoicesingle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQchoicesingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQchoicesingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQchoicesingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QchoicesingleContext qchoicesingle() throws RecognitionException {
		QchoicesingleContext _localctx = new QchoicesingleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_qchoicesingle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			question();
			setState(143);
			match(T__4);
			setState(144);
			match(NEWLINE);
			setState(145);
			choices();
			setState(146);
			match(NEWLINE);
			setState(147);
			answerField();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_DIGIT) {
				{
				setState(148);
				achoicesingle();
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
	public static class AchoicesingleContext extends ParserRuleContext {
		public RchoicesingleContext rchoicesingle() {
			return getRuleContext(RchoicesingleContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public AchoicesingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_achoicesingle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAchoicesingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAchoicesingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAchoicesingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AchoicesingleContext achoicesingle() throws RecognitionException {
		AchoicesingleContext _localctx = new AchoicesingleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_achoicesingle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			rchoicesingle();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(152);
				match(T__1);
				setState(153);
				mark();
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
	public static class RchoicesingleContext extends ParserRuleContext {
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public RchoicesingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rchoicesingle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterRchoicesingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitRchoicesingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitRchoicesingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RchoicesingleContext rchoicesingle() throws RecognitionException {
		RchoicesingleContext _localctx = new RchoicesingleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rchoicesingle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				match(TK_DIGIT);
				}
				}
				setState(159); 
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
	public static class QchoicemultipleContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(interviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(interviewModelParser.NEWLINE, i);
		}
		public ChoicesContext choices() {
			return getRuleContext(ChoicesContext.class,0);
		}
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AchoicemultipleContext achoicemultiple() {
			return getRuleContext(AchoicemultipleContext.class,0);
		}
		public QchoicemultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qchoicemultiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQchoicemultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQchoicemultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQchoicemultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QchoicemultipleContext qchoicemultiple() throws RecognitionException {
		QchoicemultipleContext _localctx = new QchoicemultipleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_qchoicemultiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			question();
			setState(162);
			match(T__5);
			setState(163);
			match(NEWLINE);
			setState(164);
			choices();
			setState(165);
			match(NEWLINE);
			setState(166);
			answerField();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_DIGIT) {
				{
				setState(167);
				achoicemultiple();
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
	public static class AchoicemultipleContext extends ParserRuleContext {
		public List<RchoicemultipleContext> rchoicemultiple() {
			return getRuleContexts(RchoicemultipleContext.class);
		}
		public RchoicemultipleContext rchoicemultiple(int i) {
			return getRuleContext(RchoicemultipleContext.class,i);
		}
		public List<MarkContext> mark() {
			return getRuleContexts(MarkContext.class);
		}
		public MarkContext mark(int i) {
			return getRuleContext(MarkContext.class,i);
		}
		public AchoicemultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_achoicemultiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAchoicemultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAchoicemultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAchoicemultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AchoicemultipleContext achoicemultiple() throws RecognitionException {
		AchoicemultipleContext _localctx = new AchoicemultipleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_achoicemultiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			rchoicemultiple();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(171);
				match(T__1);
				setState(172);
				mark();
				}
			}

			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(175);
				match(T__6);
				setState(176);
				rchoicemultiple();
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(177);
					match(T__1);
					setState(178);
					mark();
					}
				}

				}
				}
				setState(185);
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
	public static class RchoicemultipleContext extends ParserRuleContext {
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public RchoicemultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rchoicemultiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterRchoicemultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitRchoicemultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitRchoicemultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RchoicemultipleContext rchoicemultiple() throws RecognitionException {
		RchoicemultipleContext _localctx = new RchoicemultipleContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rchoicemultiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(186);
				match(TK_DIGIT);
				}
				}
				setState(189); 
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
	public static class QintegernumberContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(interviewModelParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AintegernumberContext aintegernumber() {
			return getRuleContext(AintegernumberContext.class,0);
		}
		public QintegernumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qintegernumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQintegernumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQintegernumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQintegernumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QintegernumberContext qintegernumber() throws RecognitionException {
		QintegernumberContext _localctx = new QintegernumberContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_qintegernumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			question();
			setState(192);
			match(T__7);
			setState(193);
			match(NEWLINE);
			setState(194);
			answerField();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_DIGIT) {
				{
				setState(195);
				aintegernumber();
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
	public static class AintegernumberContext extends ParserRuleContext {
		public RintegernumberContext rintegernumber() {
			return getRuleContext(RintegernumberContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public AintegernumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aintegernumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAintegernumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAintegernumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAintegernumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AintegernumberContext aintegernumber() throws RecognitionException {
		AintegernumberContext _localctx = new AintegernumberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_aintegernumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			rintegernumber();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(199);
				match(T__1);
				setState(200);
				mark();
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
	public static class RintegernumberContext extends ParserRuleContext {
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public RintegernumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rintegernumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterRintegernumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitRintegernumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitRintegernumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RintegernumberContext rintegernumber() throws RecognitionException {
		RintegernumberContext _localctx = new RintegernumberContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rintegernumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(203);
				match(TK_DIGIT);
				}
				}
				setState(206); 
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
	public static class QdecimalnumberContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(interviewModelParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AdecimalnumberContext adecimalnumber() {
			return getRuleContext(AdecimalnumberContext.class,0);
		}
		public QdecimalnumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qdecimalnumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQdecimalnumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQdecimalnumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQdecimalnumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QdecimalnumberContext qdecimalnumber() throws RecognitionException {
		QdecimalnumberContext _localctx = new QdecimalnumberContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_qdecimalnumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			question();
			setState(209);
			match(T__8);
			setState(210);
			match(NEWLINE);
			setState(211);
			answerField();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_DIGIT) {
				{
				setState(212);
				adecimalnumber();
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
	public static class AdecimalnumberContext extends ParserRuleContext {
		public RdecimalnumberContext rdecimalnumber() {
			return getRuleContext(RdecimalnumberContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public AdecimalnumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adecimalnumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAdecimalnumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAdecimalnumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAdecimalnumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdecimalnumberContext adecimalnumber() throws RecognitionException {
		AdecimalnumberContext _localctx = new AdecimalnumberContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_adecimalnumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			rdecimalnumber();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(216);
				match(T__1);
				setState(217);
				mark();
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
	public static class RdecimalnumberContext extends ParserRuleContext {
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public RdecimalnumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rdecimalnumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterRdecimalnumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitRdecimalnumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitRdecimalnumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RdecimalnumberContext rdecimalnumber() throws RecognitionException {
		RdecimalnumberContext _localctx = new RdecimalnumberContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_rdecimalnumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(220);
				match(TK_DIGIT);
				}
				}
				setState(223); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_DIGIT );
			setState(225);
			match(T__9);
			setState(226);
			match(TK_DIGIT);
			setState(227);
			match(TK_DIGIT);
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
	public static class QdateContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(interviewModelParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AdateContext adate() {
			return getRuleContext(AdateContext.class,0);
		}
		public QdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QdateContext qdate() throws RecognitionException {
		QdateContext _localctx = new QdateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_qdate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			question();
			setState(230);
			match(T__10);
			setState(231);
			match(NEWLINE);
			setState(232);
			answerField();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_DATE) {
				{
				setState(233);
				adate();
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
	public static class AdateContext extends ParserRuleContext {
		public RdateContext rdate() {
			return getRuleContext(RdateContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public AdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdateContext adate() throws RecognitionException {
		AdateContext _localctx = new AdateContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_adate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			rdate();
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(237);
				match(T__1);
				setState(238);
				mark();
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
	public static class RdateContext extends ParserRuleContext {
		public TerminalNode TK_DATE() { return getToken(interviewModelParser.TK_DATE, 0); }
		public RdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterRdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitRdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitRdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RdateContext rdate() throws RecognitionException {
		RdateContext _localctx = new RdateContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_rdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(TK_DATE);
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
	public static class QtimeContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(interviewModelParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AtimeContext atime() {
			return getRuleContext(AtimeContext.class,0);
		}
		public QtimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qtime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQtime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQtime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQtime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QtimeContext qtime() throws RecognitionException {
		QtimeContext _localctx = new QtimeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_qtime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			question();
			setState(244);
			match(T__11);
			setState(245);
			match(NEWLINE);
			setState(246);
			answerField();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_TIME) {
				{
				setState(247);
				atime();
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
	public static class AtimeContext extends ParserRuleContext {
		public RtimeContext rtime() {
			return getRuleContext(RtimeContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public AtimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAtime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAtime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAtime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtimeContext atime() throws RecognitionException {
		AtimeContext _localctx = new AtimeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_atime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			rtime();
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(251);
				match(T__1);
				setState(252);
				mark();
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
	public static class RtimeContext extends ParserRuleContext {
		public TerminalNode TK_TIME() { return getToken(interviewModelParser.TK_TIME, 0); }
		public RtimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rtime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterRtime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitRtime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitRtime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RtimeContext rtime() throws RecognitionException {
		RtimeContext _localctx = new RtimeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_rtime);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(TK_TIME);
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
	public static class QnumericscaleContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(interviewModelParser.NEWLINE, 0); }
		public AnswerFieldContext answerField() {
			return getRuleContext(AnswerFieldContext.class,0);
		}
		public AnumericscaleContext anumericscale() {
			return getRuleContext(AnumericscaleContext.class,0);
		}
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public QnumericscaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qnumericscale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQnumericscale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQnumericscale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQnumericscale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QnumericscaleContext qnumericscale() throws RecognitionException {
		QnumericscaleContext _localctx = new QnumericscaleContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_qnumericscale);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			question();
			setState(258);
			match(T__12);
			setState(264); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(260); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(259);
						match(TK_DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(262); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(266); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_DIGIT );
			setState(268);
			match(T__1);
			setState(274); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(270); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(269);
						match(TK_DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(272); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(276); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_DIGIT );
			setState(278);
			match(T__13);
			setState(279);
			match(NEWLINE);
			setState(280);
			answerField();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_DIGIT) {
				{
				setState(281);
				anumericscale();
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
	public static class AnumericscaleContext extends ParserRuleContext {
		public RnumericscaleContext rnumericscale() {
			return getRuleContext(RnumericscaleContext.class,0);
		}
		public MarkContext mark() {
			return getRuleContext(MarkContext.class,0);
		}
		public AnumericscaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anumericscale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAnumericscale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAnumericscale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAnumericscale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnumericscaleContext anumericscale() throws RecognitionException {
		AnumericscaleContext _localctx = new AnumericscaleContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_anumericscale);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			rnumericscale();
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(285);
				match(T__1);
				setState(286);
				mark();
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
	public static class RnumericscaleContext extends ParserRuleContext {
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public RnumericscaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rnumericscale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterRnumericscale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitRnumericscale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitRnumericscale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RnumericscaleContext rnumericscale() throws RecognitionException {
		RnumericscaleContext _localctx = new RnumericscaleContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_rnumericscale);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(289);
				match(TK_DIGIT);
				}
				}
				setState(292); 
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
	public static class QuestionContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TerminalNode TK_QUEST() { return getToken(interviewModelParser.TK_QUEST, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			phrase();
			setState(295);
			match(TK_QUEST);
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
		public List<TerminalNode> TK_TEXT() { return getTokens(interviewModelParser.TK_TEXT); }
		public TerminalNode TK_TEXT(int i) {
			return getToken(interviewModelParser.TK_TEXT, i);
		}
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public List<TerminalNode> WS() { return getTokens(interviewModelParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(interviewModelParser.WS, i);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_phrase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TK_TEXT:
				{
				setState(297);
				match(TK_TEXT);
				}
				break;
			case TK_DIGIT:
				{
				setState(299); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(298);
						match(TK_DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(301); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34865152L) != 0)) {
				{
				{
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(305);
					match(WS);
					}
				}

				setState(314);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TK_TEXT:
					{
					setState(308);
					match(TK_TEXT);
					}
					break;
				case TK_DIGIT:
					{
					setState(310); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(309);
							match(TK_DIGIT);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(312); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(320);
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
		public List<ChoiceNumberContext> choiceNumber() {
			return getRuleContexts(ChoiceNumberContext.class);
		}
		public ChoiceNumberContext choiceNumber(int i) {
			return getRuleContext(ChoiceNumberContext.class,i);
		}
		public List<ChoiceContext> choice() {
			return getRuleContexts(ChoiceContext.class);
		}
		public ChoiceContext choice(int i) {
			return getRuleContext(ChoiceContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(interviewModelParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(interviewModelParser.NEWLINE, i);
		}
		public ChoicesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choices; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterChoices(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitChoices(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitChoices(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoicesContext choices() throws RecognitionException {
		ChoicesContext _localctx = new ChoicesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_choices);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(321);
				choiceNumber();
				setState(322);
				choice();
				setState(324);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(323);
					match(NEWLINE);
					}
					break;
				}
				}
				}
				setState(328); 
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
	public static class ChoiceNumberContext extends ParserRuleContext {
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public ChoiceNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choiceNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterChoiceNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitChoiceNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitChoiceNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceNumberContext choiceNumber() throws RecognitionException {
		ChoiceNumberContext _localctx = new ChoiceNumberContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_choiceNumber);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(335); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(331); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(330);
						match(TK_DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(333); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(337); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_DIGIT );
			setState(339);
			match(T__9);
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
	public static class ChoiceContext extends ParserRuleContext {
		public TerminalNode TK_TEXT() { return getToken(interviewModelParser.TK_TEXT, 0); }
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceContext choice() throws RecognitionException {
		ChoiceContext _localctx = new ChoiceContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_choice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(TK_TEXT);
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
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterAnswerField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitAnswerField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitAnswerField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerFieldContext answerField() throws RecognitionException {
		AnswerFieldContext _localctx = new AnswerFieldContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_answerField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			phrase();
			setState(344);
			match(T__14);
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
	public static class MarkContext extends ParserRuleContext {
		public Token TK_DIGIT;
		public List<TerminalNode> TK_DIGIT() { return getTokens(interviewModelParser.TK_DIGIT); }
		public TerminalNode TK_DIGIT(int i) {
			return getToken(interviewModelParser.TK_DIGIT, i);
		}
		public MarkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).enterMark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof interviewModelListener ) ((interviewModelListener)listener).exitMark(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof interviewModelVisitor ) return ((interviewModelVisitor<? extends T>)visitor).visitMark(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkContext mark() throws RecognitionException {
		MarkContext _localctx = new MarkContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_mark);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(346);
				((MarkContext)_localctx).TK_DIGIT = match(TK_DIGIT);
				}
				}
				setState(349); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_DIGIT );
			 totalMarks += Integer.parseInt((((MarkContext)_localctx).TK_DIGIT!=null?((MarkContext)_localctx).TK_DIGIT.getText():null)); 
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
		"\u0004\u0001\u001a\u0162\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0001\u0000\u0003\u0000L\b\u0000\u0001"+
		"\u0000\u0004\u0000O\b\u0000\u000b\u0000\f\u0000P\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\\\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002g\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003n\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004s\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0004\u0006z\b\u0006\u000b\u0006\f\u0006{\u0004\u0006~\b"+
		"\u0006\u000b\u0006\f\u0006\u007f\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u0086\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u008b\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u0096\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u009b"+
		"\b\n\u0001\u000b\u0004\u000b\u009e\b\u000b\u000b\u000b\f\u000b\u009f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00a9\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00ae\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00b4\b\r\u0005\r\u00b6\b\r\n\r\f\r\u00b9\t\r\u0001\u000e\u0004\u000e"+
		"\u00bc\b\u000e\u000b\u000e\f\u000e\u00bd\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00c5\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00ca\b\u0010\u0001\u0011\u0004\u0011\u00cd"+
		"\b\u0011\u000b\u0011\f\u0011\u00ce\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00d6\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00db\b\u0013\u0001\u0014\u0004\u0014\u00de\b"+
		"\u0014\u000b\u0014\f\u0014\u00df\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u00eb\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00f0"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u00f9\b\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u00fe\b\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0004\u001b\u0105\b\u001b\u000b\u001b\f\u001b\u0106"+
		"\u0004\u001b\u0109\b\u001b\u000b\u001b\f\u001b\u010a\u0001\u001b\u0001"+
		"\u001b\u0004\u001b\u010f\b\u001b\u000b\u001b\f\u001b\u0110\u0004\u001b"+
		"\u0113\b\u001b\u000b\u001b\f\u001b\u0114\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0003\u001b\u011b\b\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u0120\b\u001c\u0001\u001d\u0004\u001d\u0123\b\u001d"+
		"\u000b\u001d\f\u001d\u0124\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0004\u001f\u012c\b\u001f\u000b\u001f\f\u001f\u012d\u0003"+
		"\u001f\u0130\b\u001f\u0001\u001f\u0003\u001f\u0133\b\u001f\u0001\u001f"+
		"\u0001\u001f\u0004\u001f\u0137\b\u001f\u000b\u001f\f\u001f\u0138\u0003"+
		"\u001f\u013b\b\u001f\u0005\u001f\u013d\b\u001f\n\u001f\f\u001f\u0140\t"+
		"\u001f\u0001 \u0001 \u0001 \u0003 \u0145\b \u0004 \u0147\b \u000b \f "+
		"\u0148\u0001!\u0004!\u014c\b!\u000b!\f!\u014d\u0004!\u0150\b!\u000b!\f"+
		"!\u0151\u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0004"+
		"$\u015c\b$\u000b$\f$\u015d\u0001$\u0001$\u0001$\u0000\u0000%\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFH\u0000\u0001\u0001\u0000\u0010\u0011\u0178\u0000"+
		"N\u0001\u0000\u0000\u0000\u0002[\u0001\u0000\u0000\u0000\u0004f\u0001"+
		"\u0000\u0000\u0000\u0006h\u0001\u0000\u0000\u0000\bo\u0001\u0000\u0000"+
		"\u0000\nt\u0001\u0000\u0000\u0000\fv\u0001\u0000\u0000\u0000\u000e\u0087"+
		"\u0001\u0000\u0000\u0000\u0010\u008c\u0001\u0000\u0000\u0000\u0012\u008e"+
		"\u0001\u0000\u0000\u0000\u0014\u0097\u0001\u0000\u0000\u0000\u0016\u009d"+
		"\u0001\u0000\u0000\u0000\u0018\u00a1\u0001\u0000\u0000\u0000\u001a\u00aa"+
		"\u0001\u0000\u0000\u0000\u001c\u00bb\u0001\u0000\u0000\u0000\u001e\u00bf"+
		"\u0001\u0000\u0000\u0000 \u00c6\u0001\u0000\u0000\u0000\"\u00cc\u0001"+
		"\u0000\u0000\u0000$\u00d0\u0001\u0000\u0000\u0000&\u00d7\u0001\u0000\u0000"+
		"\u0000(\u00dd\u0001\u0000\u0000\u0000*\u00e5\u0001\u0000\u0000\u0000,"+
		"\u00ec\u0001\u0000\u0000\u0000.\u00f1\u0001\u0000\u0000\u00000\u00f3\u0001"+
		"\u0000\u0000\u00002\u00fa\u0001\u0000\u0000\u00004\u00ff\u0001\u0000\u0000"+
		"\u00006\u0101\u0001\u0000\u0000\u00008\u011c\u0001\u0000\u0000\u0000:"+
		"\u0122\u0001\u0000\u0000\u0000<\u0126\u0001\u0000\u0000\u0000>\u012f\u0001"+
		"\u0000\u0000\u0000@\u0146\u0001\u0000\u0000\u0000B\u014f\u0001\u0000\u0000"+
		"\u0000D\u0155\u0001\u0000\u0000\u0000F\u0157\u0001\u0000\u0000\u0000H"+
		"\u015b\u0001\u0000\u0000\u0000JL\u0003\u0002\u0001\u0000KJ\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0005"+
		"\u0018\u0000\u0000NK\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000"+
		"PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000Q\u0001\u0001\u0000"+
		"\u0000\u0000R\\\u0003\f\u0006\u0000S\\\u0003\u0018\f\u0000T\\\u0003\u0012"+
		"\t\u0000U\\\u0003*\u0015\u0000V\\\u0003\u0006\u0003\u0000W\\\u00030\u0018"+
		"\u0000X\\\u0003\u001e\u000f\u0000Y\\\u00036\u001b\u0000Z\\\u0003$\u0012"+
		"\u0000[R\u0001\u0000\u0000\u0000[S\u0001\u0000\u0000\u0000[T\u0001\u0000"+
		"\u0000\u0000[U\u0001\u0000\u0000\u0000[V\u0001\u0000\u0000\u0000[W\u0001"+
		"\u0000\u0000\u0000[X\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"[Z\u0001\u0000\u0000\u0000\\\u0003\u0001\u0000\u0000\u0000]g\u0003\u000e"+
		"\u0007\u0000^g\u0003\u001a\r\u0000_g\u0003\u0014\n\u0000`g\u0003,\u0016"+
		"\u0000ag\u0003\b\u0004\u0000bg\u00032\u0019\u0000cg\u0003 \u0010\u0000"+
		"dg\u00038\u001c\u0000eg\u0003&\u0013\u0000f]\u0001\u0000\u0000\u0000f"+
		"^\u0001\u0000\u0000\u0000f_\u0001\u0000\u0000\u0000f`\u0001\u0000\u0000"+
		"\u0000fa\u0001\u0000\u0000\u0000fb\u0001\u0000\u0000\u0000fc\u0001\u0000"+
		"\u0000\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000g\u0005"+
		"\u0001\u0000\u0000\u0000hi\u0003<\u001e\u0000ij\u0005\u0001\u0000\u0000"+
		"jk\u0005\u0018\u0000\u0000km\u0003F#\u0000ln\u0003\b\u0004\u0000ml\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0007\u0001\u0000\u0000"+
		"\u0000or\u0003\n\u0005\u0000pq\u0005\u0002\u0000\u0000qs\u0003H$\u0000"+
		"rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\t\u0001\u0000\u0000"+
		"\u0000tu\u0007\u0000\u0000\u0000u\u000b\u0001\u0000\u0000\u0000vw\u0003"+
		"<\u001e\u0000w}\u0005\u0003\u0000\u0000xz\u0005\u0014\u0000\u0000yx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000\u0000}y\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0005\u0004\u0000\u0000\u0082\u0083\u0005\u0018\u0000\u0000\u0083"+
		"\u0085\u0003F#\u0000\u0084\u0086\u0003\u000e\u0007\u0000\u0085\u0084\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\r\u0001\u0000"+
		"\u0000\u0000\u0087\u008a\u0003\u0010\b\u0000\u0088\u0089\u0005\u0002\u0000"+
		"\u0000\u0089\u008b\u0003H$\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0001\u0000\u0000\u0000\u008b\u000f\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0003>\u001f\u0000\u008d\u0011\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0003<\u001e\u0000\u008f\u0090\u0005\u0005\u0000\u0000\u0090\u0091\u0005"+
		"\u0018\u0000\u0000\u0091\u0092\u0003@ \u0000\u0092\u0093\u0005\u0018\u0000"+
		"\u0000\u0093\u0095\u0003F#\u0000\u0094\u0096\u0003\u0014\n\u0000\u0095"+
		"\u0094\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096"+
		"\u0013\u0001\u0000\u0000\u0000\u0097\u009a\u0003\u0016\u000b\u0000\u0098"+
		"\u0099\u0005\u0002\u0000\u0000\u0099\u009b\u0003H$\u0000\u009a\u0098\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0015\u0001"+
		"\u0000\u0000\u0000\u009c\u009e\u0005\u0014\u0000\u0000\u009d\u009c\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u009d\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u0017\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0003<\u001e\u0000\u00a2\u00a3\u0005\u0006"+
		"\u0000\u0000\u00a3\u00a4\u0005\u0018\u0000\u0000\u00a4\u00a5\u0003@ \u0000"+
		"\u00a5\u00a6\u0005\u0018\u0000\u0000\u00a6\u00a8\u0003F#\u0000\u00a7\u00a9"+
		"\u0003\u001a\r\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a9\u0019\u0001\u0000\u0000\u0000\u00aa\u00ad\u0003"+
		"\u001c\u000e\u0000\u00ab\u00ac\u0005\u0002\u0000\u0000\u00ac\u00ae\u0003"+
		"H$\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b7\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0007\u0000"+
		"\u0000\u00b0\u00b3\u0003\u001c\u000e\u0000\u00b1\u00b2\u0005\u0002\u0000"+
		"\u0000\u00b2\u00b4\u0003H$\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5"+
		"\u00af\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8"+
		"\u001b\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bc\u0005\u0014\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0001\u0000\u0000\u0000\u00be\u001d\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0003<\u001e\u0000\u00c0\u00c1\u0005\b\u0000\u0000\u00c1\u00c2"+
		"\u0005\u0018\u0000\u0000\u00c2\u00c4\u0003F#\u0000\u00c3\u00c5\u0003 "+
		"\u0010\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c5\u001f\u0001\u0000\u0000\u0000\u00c6\u00c9\u0003\"\u0011"+
		"\u0000\u00c7\u00c8\u0005\u0002\u0000\u0000\u00c8\u00ca\u0003H$\u0000\u00c9"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca"+
		"!\u0001\u0000\u0000\u0000\u00cb\u00cd\u0005\u0014\u0000\u0000\u00cc\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cc"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf#\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0003<\u001e\u0000\u00d1\u00d2\u0005\t"+
		"\u0000\u0000\u00d2\u00d3\u0005\u0018\u0000\u0000\u00d3\u00d5\u0003F#\u0000"+
		"\u00d4\u00d6\u0003&\u0013\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d6%\u0001\u0000\u0000\u0000\u00d7\u00da"+
		"\u0003(\u0014\u0000\u00d8\u00d9\u0005\u0002\u0000\u0000\u00d9\u00db\u0003"+
		"H$\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000"+
		"\u0000\u00db\'\u0001\u0000\u0000\u0000\u00dc\u00de\u0005\u0014\u0000\u0000"+
		"\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000"+
		"\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\n\u0000\u0000\u00e2"+
		"\u00e3\u0005\u0014\u0000\u0000\u00e3\u00e4\u0005\u0014\u0000\u0000\u00e4"+
		")\u0001\u0000\u0000\u0000\u00e5\u00e6\u0003<\u001e\u0000\u00e6\u00e7\u0005"+
		"\u000b\u0000\u0000\u00e7\u00e8\u0005\u0018\u0000\u0000\u00e8\u00ea\u0003"+
		"F#\u0000\u00e9\u00eb\u0003,\u0016\u0000\u00ea\u00e9\u0001\u0000\u0000"+
		"\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb+\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ef\u0003.\u0017\u0000\u00ed\u00ee\u0005\u0002\u0000\u0000\u00ee"+
		"\u00f0\u0003H$\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f0-\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005\u0015"+
		"\u0000\u0000\u00f2/\u0001\u0000\u0000\u0000\u00f3\u00f4\u0003<\u001e\u0000"+
		"\u00f4\u00f5\u0005\f\u0000\u0000\u00f5\u00f6\u0005\u0018\u0000\u0000\u00f6"+
		"\u00f8\u0003F#\u0000\u00f7\u00f9\u00032\u0019\u0000\u00f8\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f91\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fd\u00034\u001a\u0000\u00fb\u00fc\u0005\u0002\u0000"+
		"\u0000\u00fc\u00fe\u0003H$\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd"+
		"\u00fe\u0001\u0000\u0000\u0000\u00fe3\u0001\u0000\u0000\u0000\u00ff\u0100"+
		"\u0005\u0016\u0000\u0000\u01005\u0001\u0000\u0000\u0000\u0101\u0102\u0003"+
		"<\u001e\u0000\u0102\u0108\u0005\r\u0000\u0000\u0103\u0105\u0005\u0014"+
		"\u0000\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000"+
		"\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000"+
		"\u0000\u0000\u0107\u0109\u0001\u0000\u0000\u0000\u0108\u0104\u0001\u0000"+
		"\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000"+
		"\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000"+
		"\u0000\u0000\u010c\u0112\u0005\u0002\u0000\u0000\u010d\u010f\u0005\u0014"+
		"\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000"+
		"\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000"+
		"\u0000\u0000\u0111\u0113\u0001\u0000\u0000\u0000\u0112\u010e\u0001\u0000"+
		"\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000"+
		"\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0005\u000e\u0000\u0000\u0117\u0118\u0005\u0018"+
		"\u0000\u0000\u0118\u011a\u0003F#\u0000\u0119\u011b\u00038\u001c\u0000"+
		"\u011a\u0119\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000"+
		"\u011b7\u0001\u0000\u0000\u0000\u011c\u011f\u0003:\u001d\u0000\u011d\u011e"+
		"\u0005\u0002\u0000\u0000\u011e\u0120\u0003H$\u0000\u011f\u011d\u0001\u0000"+
		"\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u01209\u0001\u0000\u0000"+
		"\u0000\u0121\u0123\u0005\u0014\u0000\u0000\u0122\u0121\u0001\u0000\u0000"+
		"\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000"+
		"\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125;\u0001\u0000\u0000\u0000"+
		"\u0126\u0127\u0003>\u001f\u0000\u0127\u0128\u0005\u0017\u0000\u0000\u0128"+
		"=\u0001\u0000\u0000\u0000\u0129\u0130\u0005\u0012\u0000\u0000\u012a\u012c"+
		"\u0005\u0014\u0000\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c\u012d"+
		"\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e"+
		"\u0001\u0000\u0000\u0000\u012e\u0130\u0001\u0000\u0000\u0000\u012f\u0129"+
		"\u0001\u0000\u0000\u0000\u012f\u012b\u0001\u0000\u0000\u0000\u0130\u013e"+
		"\u0001\u0000\u0000\u0000\u0131\u0133\u0005\u0019\u0000\u0000\u0132\u0131"+
		"\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u013a"+
		"\u0001\u0000\u0000\u0000\u0134\u013b\u0005\u0012\u0000\u0000\u0135\u0137"+
		"\u0005\u0014\u0000\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137\u0138"+
		"\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u0001\u0000\u0000\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0134"+
		"\u0001\u0000\u0000\u0000\u013a\u0136\u0001\u0000\u0000\u0000\u013b\u013d"+
		"\u0001\u0000\u0000\u0000\u013c\u0132\u0001\u0000\u0000\u0000\u013d\u0140"+
		"\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0001\u0000\u0000\u0000\u013f?\u0001\u0000\u0000\u0000\u0140\u013e\u0001"+
		"\u0000\u0000\u0000\u0141\u0142\u0003B!\u0000\u0142\u0144\u0003D\"\u0000"+
		"\u0143\u0145\u0005\u0018\u0000\u0000\u0144\u0143\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0147\u0001\u0000\u0000\u0000"+
		"\u0146\u0141\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000"+
		"\u0148\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000"+
		"\u0149A\u0001\u0000\u0000\u0000\u014a\u014c\u0005\u0014\u0000\u0000\u014b"+
		"\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d"+
		"\u014b\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e"+
		"\u0150\u0001\u0000\u0000\u0000\u014f\u014b\u0001\u0000\u0000\u0000\u0150"+
		"\u0151\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151"+
		"\u0152\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153"+
		"\u0154\u0005\n\u0000\u0000\u0154C\u0001\u0000\u0000\u0000\u0155\u0156"+
		"\u0005\u0012\u0000\u0000\u0156E\u0001\u0000\u0000\u0000\u0157\u0158\u0003"+
		">\u001f\u0000\u0158\u0159\u0005\u000f\u0000\u0000\u0159G\u0001\u0000\u0000"+
		"\u0000\u015a\u015c\u0005\u0014\u0000\u0000\u015b\u015a\u0001\u0000\u0000"+
		"\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015b\u0001\u0000\u0000"+
		"\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000"+
		"\u0000\u015f\u0160\u0006$\uffff\uffff\u0000\u0160I\u0001\u0000\u0000\u0000"+
		".KP[fmr{\u007f\u0085\u008a\u0095\u009a\u009f\u00a8\u00ad\u00b3\u00b7\u00bd"+
		"\u00c4\u00c9\u00ce\u00d5\u00da\u00df\u00ea\u00ef\u00f8\u00fd\u0106\u010a"+
		"\u0110\u0114\u011a\u011f\u0124\u012d\u012f\u0132\u0138\u013a\u013e\u0144"+
		"\u0148\u014d\u0151\u015d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}