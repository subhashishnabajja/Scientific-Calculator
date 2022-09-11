package Calculator.Operators;

import java.util.Stack;

public interface OperatorFunc {
    String calculate(Stack<String> operands);
    int getPrecedence();
    String getAssociativity();
    String getToken();
}
