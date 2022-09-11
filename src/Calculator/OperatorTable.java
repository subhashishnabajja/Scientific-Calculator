package Calculator;

import Calculator.Operators.Addition;
import Calculator.Operators.Division;
import Calculator.Operators.Exponent;
import Calculator.Operators.Multiplication;
import Calculator.Operators.OperatorFunc;
import Calculator.Operators.Subtraction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class OperatorTable {

    public List<String> operatorRegex = new ArrayList();
    public HashMap<String, OperatorFunc> operatorTable = new HashMap();

    public OperatorTable() {
        this.registerOperator("+", new Addition());
        this.registerOperator("-", new Subtraction());
        this.registerOperator("*", new Multiplication());
        this.registerOperator("/", new Division());
        this.registerOperator("^", new Exponent());
    }

    public final void registerOperator(String token, OperatorFunc operator) {
        this.operatorRegex.add(token);
        this.operatorTable.put(token, operator);
    }

    public boolean isValidOperator(String token) {
        for (String re : this.operatorRegex) {

            if (token.equals(re)) {
                return true;
            }
        }
        return false;
    }

    public String performOperation(Stack<String> operands, String operator) {
        return this.operatorTable.get(operator).calculate(operands);
    }
    
    public int getPrecedence(String operator){
        
        return this.operatorTable.get(operator).getPrecedence();
    }
    
    public String getAssociativity(String operator){
        return this.operatorTable.get(operator).getAssociativity();
    }

}
