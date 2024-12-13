// Generated from C:/Users/tiago/IdeaProjects/sem4pi-23-24-2dl1/jobs4u.core/src/main/java/lapr4/jobs4u/lprog/interviewModels/interviewModel.g4 by ANTLR 4.13.1
package lapr4.jobs4u.lprog.interviewModels;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link interviewModelParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface interviewModelVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(interviewModelParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(interviewModelParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswers(interviewModelParser.AnswersContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#qtruefalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQtruefalse(interviewModelParser.QtruefalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#atruefalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtruefalse(interviewModelParser.AtruefalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#rtruefalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtruefalse(interviewModelParser.RtruefalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#qshorttextanswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQshorttextanswer(interviewModelParser.QshorttextanswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#ashorttextanswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAshorttextanswer(interviewModelParser.AshorttextanswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#rshorttextanswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRshorttextanswer(interviewModelParser.RshorttextanswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#qchoicesingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQchoicesingle(interviewModelParser.QchoicesingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#achoicesingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAchoicesingle(interviewModelParser.AchoicesingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#rchoicesingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRchoicesingle(interviewModelParser.RchoicesingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#qchoicemultiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQchoicemultiple(interviewModelParser.QchoicemultipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#achoicemultiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAchoicemultiple(interviewModelParser.AchoicemultipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#rchoicemultiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRchoicemultiple(interviewModelParser.RchoicemultipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#qintegernumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQintegernumber(interviewModelParser.QintegernumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#aintegernumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAintegernumber(interviewModelParser.AintegernumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#rintegernumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRintegernumber(interviewModelParser.RintegernumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#qdecimalnumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQdecimalnumber(interviewModelParser.QdecimalnumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#adecimalnumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdecimalnumber(interviewModelParser.AdecimalnumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#rdecimalnumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRdecimalnumber(interviewModelParser.RdecimalnumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#qdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQdate(interviewModelParser.QdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#adate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdate(interviewModelParser.AdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#rdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRdate(interviewModelParser.RdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#qtime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQtime(interviewModelParser.QtimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#atime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtime(interviewModelParser.AtimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#rtime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtime(interviewModelParser.RtimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#qnumericscale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQnumericscale(interviewModelParser.QnumericscaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#anumericscale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnumericscale(interviewModelParser.AnumericscaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#rnumericscale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRnumericscale(interviewModelParser.RnumericscaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(interviewModelParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(interviewModelParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#choices}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoices(interviewModelParser.ChoicesContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#choiceNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoiceNumber(interviewModelParser.ChoiceNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(interviewModelParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#answerField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerField(interviewModelParser.AnswerFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link interviewModelParser#mark}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMark(interviewModelParser.MarkContext ctx);
}