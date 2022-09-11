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
public class CosInverse implements FunctionInterface {

    public String token = "cosInv";
    public int precedence = 5;
    public String associativity = "LTR";

    @Override
    public String calculate(Stack<String> parameters) {
        return String.valueOf(Math.acos(Double.parseDouble(parameters.pop())));
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
