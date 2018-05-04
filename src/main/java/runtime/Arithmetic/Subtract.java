package runtime.Arithmetic;

public class Subtract extends Arithmetic {
    public Subtract(int operand1, int operand2) {
        super(operand1, operand2);
    }


    @Override
    public Integer operate() {
        return operand2 - operand1;
    }
}
