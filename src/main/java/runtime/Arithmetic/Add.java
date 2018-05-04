package runtime.Arithmetic;

public class Add extends Arithmetic {
    public Add(int operand1, int operand2) {
        super(operand1, operand2);
    }

    public Integer operate() {
        return operand1 + operand2;
    }
}
