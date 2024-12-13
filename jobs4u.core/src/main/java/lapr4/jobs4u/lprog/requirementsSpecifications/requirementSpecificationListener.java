// Generated from C:/Users/tiago/IdeaProjects/sem4pi-23-24-2dl1/jobs4u.core/src/main/java/lapr4/jobs4u/lprog/requirementsSpecifications/requirementSpecification.g4 by ANTLR 4.13.1
package lapr4.jobs4u.lprog.requirementsSpecifications;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link requirementSpecificationParser}.
 */
public interface requirementSpecificationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(requirementSpecificationParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(requirementSpecificationParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#requirements}.
	 * @param ctx the parse tree
	 */
	void enterRequirements(requirementSpecificationParser.RequirementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#requirements}.
	 * @param ctx the parse tree
	 */
	void exitRequirements(requirementSpecificationParser.RequirementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#answers}.
	 * @param ctx the parse tree
	 */
	void enterAnswers(requirementSpecificationParser.AnswersContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#answers}.
	 * @param ctx the parse tree
	 */
	void exitAnswers(requirementSpecificationParser.AnswersContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#reqOptionInt}.
	 * @param ctx the parse tree
	 */
	void enterReqOptionInt(requirementSpecificationParser.ReqOptionIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#reqOptionInt}.
	 * @param ctx the parse tree
	 */
	void exitReqOptionInt(requirementSpecificationParser.ReqOptionIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#ansOptionInt}.
	 * @param ctx the parse tree
	 */
	void enterAnsOptionInt(requirementSpecificationParser.AnsOptionIntContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#ansOptionInt}.
	 * @param ctx the parse tree
	 */
	void exitAnsOptionInt(requirementSpecificationParser.AnsOptionIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#reqOneOption}.
	 * @param ctx the parse tree
	 */
	void enterReqOneOption(requirementSpecificationParser.ReqOneOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#reqOneOption}.
	 * @param ctx the parse tree
	 */
	void exitReqOneOption(requirementSpecificationParser.ReqOneOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#ansOneOption}.
	 * @param ctx the parse tree
	 */
	void enterAnsOneOption(requirementSpecificationParser.AnsOneOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#ansOneOption}.
	 * @param ctx the parse tree
	 */
	void exitAnsOneOption(requirementSpecificationParser.AnsOneOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#reqMultipleOption}.
	 * @param ctx the parse tree
	 */
	void enterReqMultipleOption(requirementSpecificationParser.ReqMultipleOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#reqMultipleOption}.
	 * @param ctx the parse tree
	 */
	void exitReqMultipleOption(requirementSpecificationParser.ReqMultipleOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#ansMultipleOption}.
	 * @param ctx the parse tree
	 */
	void enterAnsMultipleOption(requirementSpecificationParser.AnsMultipleOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#ansMultipleOption}.
	 * @param ctx the parse tree
	 */
	void exitAnsMultipleOption(requirementSpecificationParser.AnsMultipleOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(requirementSpecificationParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(requirementSpecificationParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#choices}.
	 * @param ctx the parse tree
	 */
	void enterChoices(requirementSpecificationParser.ChoicesContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#choices}.
	 * @param ctx the parse tree
	 */
	void exitChoices(requirementSpecificationParser.ChoicesContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#requirement}.
	 * @param ctx the parse tree
	 */
	void enterRequirement(requirementSpecificationParser.RequirementContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#requirement}.
	 * @param ctx the parse tree
	 */
	void exitRequirement(requirementSpecificationParser.RequirementContext ctx);
	/**
	 * Enter a parse tree produced by {@link requirementSpecificationParser#answerField}.
	 * @param ctx the parse tree
	 */
	void enterAnswerField(requirementSpecificationParser.AnswerFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link requirementSpecificationParser#answerField}.
	 * @param ctx the parse tree
	 */
	void exitAnswerField(requirementSpecificationParser.AnswerFieldContext ctx);
}