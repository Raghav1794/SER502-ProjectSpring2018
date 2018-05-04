package runtime.conditional;


import static runtime.constants.Constants.*;

/**
 * Created by dixith on 4/23/17.
 */
public abstract class Conditional {

    public int operand2;
    public int operand1;

    public Conditional(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2  = operand2;

    }



    public abstract Boolean operate();

    public static Boolean execute(String op, int operand1, int operand2) {
        Conditional arithmetic = null;

        if(GREATER.equals(op)) {
            arithmetic = new Greater(operand1, operand2);
        } else if(LESSER.equals(op)) {
            arithmetic = new Lesser(operand1, operand2);
        } else if(GREATEREQUAL.equals(op)) {
            arithmetic = new GreaterThanEqual(operand1, operand2);
        } else if(LESSEREQUAL.equals(op)) {
            arithmetic = new LesserThanEqual(operand1, operand2);
        } else if(EQUALS.equals(op)) {
            arithmetic = new EqualTo(operand1, operand2);
        } else if(NOTEQUALS.equals(op)) {
            arithmetic = new NotEqualsTo(operand1, operand2);
        }

        assert arithmetic != null;
        return arithmetic.operate();
    }
}
