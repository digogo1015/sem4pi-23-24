// Generated from C:/Users/tiago/IdeaProjects/sem4pi-23-24-2dl1/jobs4u.core/src/main/java/lapr4/jobs4u/lprog/requirementsSpecifications/requirementSpecification.g4 by ANTLR 4.13.1
package lapr4.jobs4u.lprog.requirementsSpecifications;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link requirementSpecificationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface requirementSpecificationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(requirementSpecificationParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#requirements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirements(requirementSpecificationParser.RequirementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswers(requirementSpecificationParser.AnswersContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#reqOptionInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReqOptionInt(requirementSpecificationParser.ReqOptionIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#ansOptionInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnsOptionInt(requirementSpecificationParser.AnsOptionIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#reqOneOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReqOneOption(requirementSpecificationParser.ReqOneOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#ansOneOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnsOneOption(requirementSpecificationParser.AnsOneOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#reqMultipleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReqMultipleOption(requirementSpecificationParser.ReqMultipleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#ansMultipleOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnsMultipleOption(requirementSpecificationParser.AnsMultipleOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(requirementSpecificationParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#choices}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoices(requirementSpecificationParser.ChoicesContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#requirement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequirement(requirementSpecificationParser.RequirementContext ctx);
	/**
	 * Visit a parse tree produced by {@link requirementSpecificationParser#answerField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerField(requirementSpecificationParser.AnswerFieldContext ctx);
}