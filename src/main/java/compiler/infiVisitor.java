package compiler;// Generated from /Users/Pramod/Documents/SER502--Spring2017-Team2/src/infinity.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link infinityParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface infinityVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link infinityParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(infinityParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(infinityParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(infinityParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(infinityParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(infinityParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(infinityParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(infinityParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#ifcondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfcondition(infinityParser.IfconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#elsecondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsecondition(infinityParser.ElseconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#display}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay(infinityParser.DisplayContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(infinityParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(infinityParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link infinityParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(infinityParser.StringContext ctx);
}