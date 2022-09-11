/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator.Operators;

import java.util.Stack;

/**
 *
 * @author pcmn
 */
public class Division implements OperatorFunc{

    public String token = "/";
     public int precedence = 3;
    public String associativity = "LTR";

    @Override
    public String calculate(Stack<String> operands) {
        String operandOne = operands.pop();
        String operandTwo = operands.pop();

        if (operandOne.contains(".") || operandTwo.contains(".")) {
            double result = Double.parseDouble(operandTwo) / Double.parseDouble(operandOne);
            System.out.println(result);
            return String.valueOf(result);
        } else {
            int result = Integer.parseInt(operandTwo) / Integer.parseInt(operandOne);
            return String.valueOf(result);
        }
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
