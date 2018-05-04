package runtime.conditional;

public class EqualTo extends Conditional {
    public EqualTo(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public Boolean operate() {
        return operand1 == operand2;
    }
}
