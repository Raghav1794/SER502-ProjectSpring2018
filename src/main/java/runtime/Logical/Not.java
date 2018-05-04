package runtime.Logical;

/**
 * Created by dixith on 4/23/17.
 */
public class Not extends Logical {
    public Not(Boolean operand1, Boolean operand2) {
        super(operand1, operand2);
    }

    public Not(Boolean operand) {
        super(operand);
    }

    @Override
    public Boolean operate() {
        return !operand1;
    }
}
