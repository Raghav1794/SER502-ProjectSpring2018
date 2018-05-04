package runtime.conditional;


public class NotEqualsTo extends Conditional{

    public NotEqualsTo(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public Boolean operate() {
        return operand1 != operand2;
    }
}
