/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Calculator.Functions;

import java.util.Stack;

public interface FunctionInterface {

    String calculate(Stack<String> operands);

    int getPrecedence();

    String getAssociativity();

    String getToken();

}
