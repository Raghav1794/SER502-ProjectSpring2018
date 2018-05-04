package runtime.Arithmetic;

public class Modulus extends Arithmetic {
    public Modulus(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public Integer operate() {
        return operand1 % operand2;
    }
}
