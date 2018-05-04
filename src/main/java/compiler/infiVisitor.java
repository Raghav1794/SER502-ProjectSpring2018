package compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link infiParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface infiVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link infiParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(infiParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(infiParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(infiParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(infiParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(infiParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(infiParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(infiParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#ifcondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfcondition(infiParser.IfconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#elsecondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsecondition(infiParser.ElseconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#display}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay(infiParser.DisplayContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(infiParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(infiParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link infiParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(infiParser.StringContext ctx);
}
