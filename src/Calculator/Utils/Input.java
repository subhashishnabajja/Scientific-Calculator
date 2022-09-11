/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator.Utils;

import java.util.Iterator;
import java.util.Stack;
import javax.swing.JTextField;

/**
 *
 * @author pcmn
 */
public class Input {

    private Stack<String> stack = new Stack();
    private JTextField inputField;

    public Input(JTextField inputField) {

        this.inputField = inputField;

    }

    public void addToken(String token) {
        this.stack.push(token);
        this.updateOutputField();
    }

    public void addNumber(String number) {

        this.addToken(number);
    }

    public void addFunction(String function) {
        if (!stack.isEmpty() && stack.peek().matches("\\d")) {
            this.addToken(" * ");
        }

        this.addToken(function);
    }

    public void removeToken() {
        stack.pop();
        this.updateOutputField();
    }

    public void clearStack() {
        while (!stack.isEmpty()) {
            stack.pop();
        }

        this.clearField();
    }

    public String lastOperand() {
        String[] operands = this.inputField.getText().split(" ");

        return operands[operands.length - 1];

    }

    public void updateOutputField() {

        Iterator tokens = stack.iterator();
        this.clearField();
        while (tokens.hasNext()) {
            this.inputField.setText(this.inputField.getText() + tokens.next());
        }
    }

    public void clearField() {

        this.inputField.setText("");
    }

    public String toString() {
        return this.inputField.getText();
    }
}
