package runtime.Arithmetic;

import static runtime.constants.Constants.*;

public  abstract class Arithmetic {

    public int operand2;
    public int operand1;

    public Arithmetic(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public abstract Integer operate();

    public static int execute(String op, int operand1, int operand2) {
        Arithmetic arithmetic = null;

        if(ADD.equals(op)) {
            arithmetic = new Add(operand1, operand2);
        } else if(SUBTRACT.equals(op)) {
            arithmetic = new Subtract(operand1, operand2);
        } else if(MULTIPLY.equals(op)) {
            arithmetic = new Multiply(operand1, operand2);
        } else if(DIVIDE.equals(op)) {
            arithmetic = new Divide(operand1, operand2);
        } else if(MODULUS.equals(op)) {
            arithmetic = new Modulus(operand1, operand2);
        }
        assert arithmetic != null;
        return arithmetic.operate();
}
}
