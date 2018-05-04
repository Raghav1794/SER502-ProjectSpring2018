package compiler;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Stack;


/**
 * This class provides an empty implementation of {@link infiListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
//Array list to store intermediate code.
// stacks to store the line numbers so as to implement the jump conditions.
public class infiBaseListener implements infiListener {


	ArrayList<String> intermediate = new ArrayList<>();
	Stack<Integer> ifCond = new Stack<Integer>();
	Stack<Integer> elseCond = new Stack<Integer>();
	Stack<Integer> while_cond = new Stack<Integer>();

	//line number to keep track of the line numbers.
	int line_no = 1;



	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */

	@Override public void enterProgram(infiParser.ProgramContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	// push END at the end of the program.
	@Override public void exitProgram(infiParser.ProgramContext ctx) {

		intermediate.add("END");

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(infiParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(infiParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignment(infiParser.AssignmentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignment(infiParser.AssignmentContext ctx) {


		line_no++;
		intermediate.add("STORE " + ctx.IDENTIFIER());

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEquality(infiParser.EqualityContext ctx) {

		if(ctx.IDENTIFIER()!=null){
			line_no++;
			intermediate.add("PUSH "+ ctx.IDENTIFIER());
		}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEquality(infiParser.EqualityContext ctx) {

		if(ctx.GT() !=null )
		{

			line_no++;
			intermediate.add("GREATER");
		}
		else if(ctx.LT()!=null)
		{
			line_no++;
			intermediate.add("LESSER");
		}
		else if(ctx.LE() !=null)
		{
			line_no++;
			intermediate.add("LESSEREQUAL");
		}
		else if(ctx.EQ()!=null)
		{
			line_no++;
			intermediate.add("EQUALS");
		}
		else if(ctx.NE()!=null)
		{
			line_no++;
			intermediate.add("NOTEQUALS");
		}

		else if(ctx.GE()!=null)
		{
			line_no++;
			intermediate.add("GREATEREQUAL");
		}
		elseCond.push(line_no);

		line_no++;
		intermediate.add("TESTFGOTO ");


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLoop(infiParser.LoopContext ctx) {

		while_cond.push(line_no);



	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLoop(infiParser.LoopContext ctx) {

		line_no++;
		intermediate.add("PUSH True");
		line_no++;
		int temp = while_cond.pop();
		intermediate.add("TESTTGOTO " +temp);
		int position_while = elseCond.pop();
		String previous_while = intermediate.get(position_while - 1);
		previous_while += (line_no);
		intermediate.set(position_while - 1,previous_while);

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariable(infiParser.VariableContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariable(infiParser.VariableContext ctx) {

		line_no++;
		intermediate.add("STORE " + ctx.IDENTIFIER());



	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCondition(infiParser.ConditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCondition(infiParser.ConditionContext ctx) {
		int position = ifCond.pop();
		String previous = intermediate.get(position - 1);
		previous +=(line_no);
		intermediate.set(position - 1,previous);


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfcondition(infiParser.IfconditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfcondition(infiParser.IfconditionContext ctx) {

		line_no++;
		intermediate.add("PUSH True");
		ifCond.push(line_no);
		line_no++;
		intermediate.add("TESTTGOTO ");
		int position_else = elseCond.pop();

		String previous_else = intermediate.get(position_else - 1);
		previous_else += (line_no);
		intermediate.set(position_else - 1,previous_else);



	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElsecondition(infiParser.ElseconditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElsecondition(infiParser.ElseconditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDisplay(infiParser.DisplayContext ctx) {
		if(ctx.IDENTIFIER() != null) {
			line_no++;
			intermediate.add("PUSH " + ctx.IDENTIFIER());
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDisplay(infiParser.DisplayContext ctx) {
		line_no++;
		intermediate.add("PRINT");

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRead(infiParser.ReadContext ctx) {
		line_no++;
		intermediate.add("READ");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRead(infiParser.ReadContext ctx) {

		line_no++;
		intermediate.add("STORE " +ctx.IDENTIFIER());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(infiParser.ExpressionContext ctx) {

		if(ctx.INTEGER()!=null){
			line_no++;
			intermediate.add("PUSH "+ ctx.INTEGER());
		} else if(ctx.IDENTIFIER()!=null){
			line_no++;
			intermediate.add("PUSH "+ ctx.IDENTIFIER());
		}
		else if(ctx.BOOL()!=null) {
			line_no++;
			intermediate.add("PUSH " + ctx.BOOL());
		}


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpression(infiParser.ExpressionContext ctx) {
		if(ctx.ADD() !=null )
		{

			line_no++;
			intermediate.add("ADD");
		}
		else if(ctx.SUB()!=null)
		{
			line_no++;
			intermediate.add("SUB");
		}
		else if(ctx.MUL() !=null)
		{
			line_no++;
			intermediate.add("MUL");
		}
		else if(ctx.DIV()!=null)
		{
			line_no++;
			intermediate.add("DIV");
		}
		else if(ctx.MOD()!=null)
		{
			line_no++;
			intermediate.add("MOD");
		}
		else if(ctx.NOT()!=null)
		{
			line_no++;
			intermediate.add("NOT");
		}
		else if(ctx.AND()!=null)
		{
			line_no++;
			intermediate.add("AND");
		}
		else if(ctx.OR()!=null)
		{
			line_no++;
			intermediate.add("OR");
		}


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterString(infiParser.StringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitString(infiParser.StringContext ctx) {

		if(ctx.IDENTIFIER() != null) {
			line_no++;
			intermediate.add("PUSH $" + ctx.IDENTIFIER());
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}
