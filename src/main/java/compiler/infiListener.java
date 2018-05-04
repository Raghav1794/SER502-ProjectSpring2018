package compiler;// Generated from /Users/Pramod/Documents/SER502--Spring2017-Team2/src/infinity.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link infinityParser}.
 */
public interface infinityListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link infinityParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(infinityParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(infinityParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(infinityParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(infinityParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(infinityParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(infinityParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(infinityParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(infinityParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(infinityParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(infinityParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(infinityParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(infinityParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(infinityParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(infinityParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#ifcondition}.
	 * @param ctx the parse tree
	 */
	void enterIfcondition(infinityParser.IfconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#ifcondition}.
	 * @param ctx the parse tree
	 */
	void exitIfcondition(infinityParser.IfconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#elsecondition}.
	 * @param ctx the parse tree
	 */
	void enterElsecondition(infinityParser.ElseconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#elsecondition}.
	 * @param ctx the parse tree
	 */
	void exitElsecondition(infinityParser.ElseconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#display}.
	 * @param ctx the parse tree
	 */
	void enterDisplay(infinityParser.DisplayContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#display}.
	 * @param ctx the parse tree
	 */
	void exitDisplay(infinityParser.DisplayContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(infinityParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(infinityParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(infinityParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(infinityParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link infinityParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(infinityParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link infinityParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(infinityParser.StringContext ctx);
}