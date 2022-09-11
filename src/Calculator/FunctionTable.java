/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

import Calculator.Functions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class FunctionTable {

    public List<String> functionREG = new ArrayList();
    public HashMap<String, FunctionInterface> functionTable = new HashMap();

    public FunctionTable() {
        this.registerFunction("sin", new Sin());
        this.registerFunction("sinInv", new SinInverse());
        this.registerFunction("cos", new Cos());
        this.registerFunction("tan", new Tan());
        this.registerFunction("ln", new NaturalLog());
        this.registerFunction("log", new LogBaseTen());
        this.registerFunction("sqr", new Square());
        this.registerFunction("fact", new Factorial());
        this.registerFunction("cosInv", new CosInverse());
        this.registerFunction("tanInv", new TanInverse());
        this.registerFunction("sqrt", new SquareRoot());
    }

    public boolean isTokenValid(String token) {

        for (String re : this.functionREG) {

            if (token.equals(re)) {
                return true;
            }
        }

        return false;
    }

    public void registerFunction(String regex, FunctionInterface function) {
        this.functionREG.add(regex);
        this.functionTable.put(regex, function);
    }

    public FunctionInterface getFunction(String token) {
        return this.functionTable.get(token);
    }

    public String performFunction(Stack<String> operands, String function) {
        return String.valueOf(this.functionTable.get(function).calculate(operands));
    }

}
