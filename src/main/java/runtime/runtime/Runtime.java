package runtime.runtime;

import runtime.Arithmetic.Arithmetic;
import runtime.Logical.Logical;
import runtime.conditional.Conditional;
import runtime.ds.Stack;
import runtime.ds.SymbolTable;
import runtime.utility.StdIn;

import static runtime.constants.Constants.*;

public class Runtime {

    public int process(String[] tokens, Stack<String> stack, SymbolTable<String, String> env, int eip) {
        String op = tokens[0];
        if(op.contains(READ)) {
            System.out.println("Pass Args to Infi:");
            String s1 = StdIn.readString();
            stack.push(s1);
        }
        else if(op.contains(STORE)) {
            env.put(tokens[1], stack.pop());
        } else if (op.contains(PUSH)) {
            if(env.contains(tokens[1])) {
                stack.push(env.get(tokens[1]));
            } else {
                stack.push(tokens[1]);
            }
        }
        else if(op.contains(TESTFGOTO)) {
            String contionalStatementReturnedValue = stack.pop();
            if("-1".equals(contionalStatementReturnedValue) || contionalStatementReturnedValue.equals("False")) {
                return Integer.parseInt(tokens[1]) - 1 ;
            }
        }

        else if(op.contains(TESTTGOTO)) {
            String contionalStatementReturnedValue = stack.pop();
            if("1".equals(contionalStatementReturnedValue) || contionalStatementReturnedValue.equals("True")) {
                return Integer.parseInt(tokens[1]) - 1;
            }
        }

        else if(op.contains(PRINT)) {
            /*printing value on the stack*/
            String popped_value = stack.pop();
            if (popped_value.contains("$") && popped_value.contains("newLine")) {
                System.out.print("\n");
            } else if(popped_value.contains("$")) {
                String substring = popped_value.substring(1);
                System.out.print(substring);
            } else {
                System.out.println(popped_value);
            }
        } else if(isAArithmeticCommand(op)) {
            Integer execute = Arithmetic.execute(op, Integer.parseInt(stack.pop()), Integer.parseInt(stack.pop()));
            stack.push(execute.toString());
        }

        else if(isAConditionalCommand(op)) {
            Boolean return_value = Conditional.execute(op, Integer.parseInt(stack.pop()), Integer.parseInt(stack.pop()));
            stack.push(return_value ? "1" : "-1");
        }

        else if(isALogicalOperator(op)) {
            Boolean return_value = Logical.execute(op, stack.pop(), stack.pop());
            stack.push(return_value ? "1" : "-1");
        }

        return ++eip;
    }

    private static boolean isALogicalOperator(String op) {
        return op.contains(OR)
                || op.contains(AND);
    }

    private static boolean isAArithmeticCommand(String op) {
        return op.contains(ADD)
                || op.contains(SUBTRACT)
                || op.contains(MULTIPLY)
                || op.contains(DIVIDE)
                || op.contains(MODULUS);
    }

    private static boolean isAConditionalCommand(String op) {
        return op.contains(LESSER)
                || op.contains(GREATER)
                || op.contains(LESSEREQUAL)
                || op.contains(GREATEREQUAL)
                || op.contains(EQUALS)
                || op.contains(NOTEQUALS);
    }
}
