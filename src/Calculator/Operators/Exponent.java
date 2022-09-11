package Calculator.Operators;

import java.util.Stack;

public class Exponent implements OperatorFunc {

    public String token = "^";
    public int precedence = 4;
    public String associativity = "RTL";

    @Override
    public String calculate(Stack<String> operands) {
        String operandOne = operands.pop();
        String operandTwo = operands.pop();

        double result = Math.pow(Double.parseDouble(operandTwo), Double.parseDouble(operandOne));
        System.out.println(result);
        return String.valueOf(result);

    }

    @Override
    public int getPrecedence() {
        return this.precedence;
    }

    @Override
    public String getAssociativity() {
        return this.associativity;
    }

    @Override
    public String getToken() {
        return this.token;
    }
}
