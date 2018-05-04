package compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link infiParser}.
 */
public interface infiListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link infiParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(infiParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(infiParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(infiParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(infiParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(infiParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(infiParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(infiParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(infiParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(infiParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(infiParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(infiParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(infiParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(infiParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(infiParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#ifcondition}.
	 * @param ctx the parse tree
	 */
	void enterIfcondition(infiParser.IfconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#ifcondition}.
	 * @param ctx the parse tree
	 */
	void exitIfcondition(infiParser.IfconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#elsecondition}.
	 * @param ctx the parse tree
	 */
	void enterElsecondition(infiParser.ElseconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#elsecondition}.
	 * @param ctx the parse tree
	 */
	void exitElsecondition(infiParser.ElseconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#display}.
	 * @param ctx the parse tree
	 */
	void enterDisplay(infiParser.DisplayContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#display}.
	 * @param ctx the parse tree
	 */
	void exitDisplay(infiParser.DisplayContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(infiParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(infiParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(infiParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(infiParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link infiParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(infiParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link infiParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(infiParser.StringContext ctx);
}
