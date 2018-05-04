package runtime.Logical;

import static runtime.constants.Constants.*;

public abstract class Logical {

    public Boolean operand2;
    public Boolean operand1;

    public Logical(Boolean operand) {
        this.operand1 = operand;
    }

    public Logical(Boolean operand1, Boolean operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }


    public abstract Boolean operate();

    public static Boolean execute(String op, String value1, String value2) {
        Logical logical = null;
        Boolean operand1;
        Boolean operand2;
        operand1 = getBoolValue(value1);

        operand2 = getBoolValue(value2);

        if(AND.equals(op)) {
            logical = new And(operand1, operand2);
        } else if(OR.equals(op)) {
            logical = new Or(operand1, operand2);
        } else if(NOT.equals(op)) {
            logical = new Not(operand1, operand2);
        }

        assert logical != null;
        return logical.operate();
    }

    private static Boolean getBoolValue(String value1) {
        Boolean operand1;

        if("True".equals(value1) || convertToInteger(value1)) {
            operand1 = true;
        } else if("False".equals(value1)) {
            operand1 = false;
        } else {
            operand1 = false;
        }
        return operand1;
    }

    private static boolean convertToInteger(String value1) {
        try {
            return Integer.parseInt(value1) > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
