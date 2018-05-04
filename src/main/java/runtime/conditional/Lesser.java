package runtime.conditional;

/**
 * Created by dixith on 4/23/17.
 */
public class Lesser extends Conditional {
    public Lesser(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public Boolean operate() {
        return operand2  < operand1;
    }
}
