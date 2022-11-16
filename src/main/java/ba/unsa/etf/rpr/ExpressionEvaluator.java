package ba.unsa.etf.rpr;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Muaz Sikiric
 * @version 0.1
 */
public class ExpressionEvaluator {
    /**
     * Evaluates given expression and returns final value if it can be calculated
     * @param expression string expression that should be validated and evaluated
     * @return value
     */
    public Double evaluate(String expression) throws RuntimeException {
        Stack<Double> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        if(!checkIfSurroundedByParentheses(expression))
            throw new RuntimeException("Izraz nije okružen zagradama!");
        for(String s : expression.split(" ")) {
            if(s.equals("(")) {}
            else if((s.length() == 1 && "*/+-".contains(s)) || s.equals("sqrt")) {
                operators.push(s);
            } else if(s.equals(")")) {
                try {
                    String operator = operators.pop();
                    Double operand = operands.pop();
                    if(operator.equals("sqrt"))
                        operands.push(Math.sqrt(operand));
                    else
                        operands.push(expressionToValue(operator, operands.pop(), operand));
                } catch(EmptyStackException e) {
                    throw new RuntimeException("Izraz nije aritmetički validan!");
                }
            } else {
                // checking if string can be parsed to double
                try {
                    operands.push(Double.parseDouble(s));
                } catch(NumberFormatException e) {
                    throw new RuntimeException("Izraz nije aritmetički validan!");
                }
            }
        }
        return operands.pop();
    }

    /**
     * Calculates result of a 'operator' b (assumes that 'operator' is a valid operator)
     * @param operator operator
     * @param a first number
     * @param b second number
     * @return value that is equal to a 'operator' b
     */
    private Double expressionToValue(String operator, Double a, Double b) throws IllegalArgumentException {
        switch(operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if(b == 0)
                    throw new IllegalArgumentException("Zabranjeno je dijeljenje nulom!");
                return a / b;
        }
        return null;
    }

    private boolean checkIfSurroundedByParentheses(String s) {
        s.trim();
        return s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')';
    }
}
