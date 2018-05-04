package compiler;// Generated from /Users/Pramod/Documents/SER502--Spring2017-Team2/src/infinity.g4 by ANTLR 4.7

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Stack;


/**
 * This class provides an empty implementation of {@link infinityListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
//Array list to store intermediate code.
// stacks to store the line numbers so as to implement the jump conditions.
public class infinityBaseListener implements infinityListener {


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
// we will parse through each and every token and based on that we will write the intermediate code.
// at the entry and exit of every rule in the grammer based on the tokens we write the necessary intermediate code and push it into the array list.
	// we are using the values in the stack to either print the line number to where the programs needs to jump.
	// using the functionality of array list we are updating the jump statement with the correct line number at the time of parsing the tree.
	@Override public void enterProgram(infinityParser.ProgramContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	// push END at the end of the program.
	@Override public void exitProgram(infinityParser.ProgramContext ctx) {

		intermediate.add("END");

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(infinityParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(infinityParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignment(infinityParser.AssignmentContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignment(infinityParser.AssignmentContext ctx) {


		line_no++;
		intermediate.add("STORE " + ctx.IDENTIFIER());

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEquality(infinityParser.EqualityContext ctx) {

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
	@Override public void exitEquality(infinityParser.EqualityContext ctx) {

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
	@Override public void enterLoop(infinityParser.LoopContext ctx) {

		while_cond.push(line_no);



	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLoop(infinityParser.LoopContext ctx) {

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
	@Override public void enterVariable(infinityParser.VariableContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariable(infinityParser.VariableContext ctx) {

		line_no++;
		intermediate.add("STORE " + ctx.IDENTIFIER());



	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCondition(infinityParser.ConditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCondition(infinityParser.ConditionContext ctx) {
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
	@Override public void enterIfcondition(infinityParser.IfconditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfcondition(infinityParser.IfconditionContext ctx) {

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
	@Override public void enterElsecondition(infinityParser.ElseconditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElsecondition(infinityParser.ElseconditionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDisplay(infinityParser.DisplayContext ctx) {
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
	@Override public void exitDisplay(infinityParser.DisplayContext ctx) {
		line_no++;
		intermediate.add("PRINT");

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRead(infinityParser.ReadContext ctx) {
		line_no++;
		intermediate.add("READ");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRead(infinityParser.ReadContext ctx) {

		line_no++;
		intermediate.add("STORE " +ctx.IDENTIFIER());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(infinityParser.ExpressionContext ctx) {

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
	@Override public void exitExpression(infinityParser.ExpressionContext ctx) {
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
	@Override public void enterString(infinityParser.StringContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitString(infinityParser.StringContext ctx) {

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