/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator.Functions;

import java.util.Stack;

/**
 *
 * @author pcmn
 */
public class Factorial implements FunctionInterface {

    public String token = "cos";
    public int precedence = 5;
    public String associativity = "LTR";
    
    public int factorial(int number){
        if (number <= 1){
            return 1;
        }
        
        return number * factorial(number - 1);
    }

    @Override
    public String calculate(Stack<String> parameters) {
        return String.valueOf(this.factorial(Integer.parseInt(parameters.pop())));
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
