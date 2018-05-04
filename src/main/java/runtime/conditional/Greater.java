package runtime.conditional;

public class Greater extends Conditional {
    public Greater(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public Boolean operate() {
        return operand2 > operand1;
    }
}
