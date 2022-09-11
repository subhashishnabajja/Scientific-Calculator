/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Calculator;

import Calculator.Functions.FunctionInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Calculator.FunctionTable;
import Calculator.OperatorTable;

// OperatorTable.operate(operator, stack)
public class Calculator {

    private FunctionTable functionTable = new FunctionTable();
    private OperatorTable operatorTable = new OperatorTable();

    public List<String> parse(String expression) {
        /*
        Implement shunting yard algorithm to parse the input infix notation to postfix notation
         */

        String[] exp = expression.replaceAll("(?<=[\\d\\)]).\\(", " * (").split(" ");
        Stack<String> output = new Stack();
        Stack<String> operator = new Stack();

        for (String token : exp) {

            if (token.equals(" ") || token.equals("")) {
                continue;
            }

            if (functionTable.isTokenValid(token)) {
                System.out.println("is function");
                operator.push(token);

            } else if (token.matches("^\\d*\\.?\\d*$")) {
                System.out.println("is operand");
                output.push(token);

            } else if (this.operatorTable.isValidOperator(token)) {

                if (!operator.isEmpty() && functionTable.isTokenValid(operator.peek())) {
                    output.push(operator.pop());
                }
                while (!operator.isEmpty()
                        && !operator.peek().equals("(")
                        && (this.operatorTable.getPrecedence(operator.peek()) > this.operatorTable.getPrecedence(token) || this.operatorTable.getPrecedence(operator.peek()) == this.operatorTable.getPrecedence(token) && this.operatorTable.getAssociativity(token).equals("LTR"))) {

                    output.push(operator.pop());
                }

                operator.push(token);
            } else if (token.matches("\\(")) {
                operator.push(token);
            } else if (token.matches("\\)")) {
                while (!operator.peek().equals("(")) {
                    output.push(operator.pop());

                }

                operator.pop();
            }
        }

        while (!operator.isEmpty()) {
            output.push(operator.pop());
        }

        return new ArrayList(output);
    }

    public String calculate(List<String> ast) {
        System.out.println(ast);

        Stack<String> operands = new Stack();
        Stack<String> operator = new Stack();

        for (String token : ast) {

            if (token.equals(" ") || token.equals("")) {
                continue;
            }
            // If the token is operand
            if (token.matches("^\\d*\\.?\\d*$")) {
                operands.push(token);
            }

            if (this.operatorTable.isValidOperator(token)) {
                System.out.println(operator);
                operands.push(this.operatorTable.performOperation(operands, token));

            }

            if (functionTable.isTokenValid(token)) {
                operands.push(functionTable.performFunction(operands, token));
            }
        }

        System.out.println(operands);

        return operands.pop();
    }

}
