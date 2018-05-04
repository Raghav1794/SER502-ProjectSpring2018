package runtime.Logical;

/**
 * Created by dixith on 4/23/17.
 */
public class And extends Logical {
    public And(Boolean operand1, Boolean operand2) {
        super(operand1, operand2);
    }

    @Override
    public Boolean operate() {
        return operand1 && operand2;
    }
}
