package ba.unsa.etf.rpr;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Class with single public method 'evaluate' that validates and returns result of a string expression
 * @author Muaz Sikiric
 * @version 0.1
 */
public class ExpressionEvaluator {
    /**
     * Evaluates given expression and returns final value if it can be calculated
     * @param expression string expression that should be validated and evaluated
     * @return value result of an expression, if valid
     */
    public Double evaluate(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        checkIfSurroundedByParentheses(expression);
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
        if(operands.size() != 1 || !operators.empty())
            throw new RuntimeException("Izraz nije aritmetički validan!");
        return operands.pop();
    }

    /**
     * Calculates result of a 'operator' b (assumes that 'operator' is a valid operator)
     * @param operator operator
     * @param a first number
     * @param b second number
     * @return value that is equal to a 'operator' b
     */
    private Double expressionToValue(String operator, Double a, Double b) {
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

    /**
     * Check if given string has a pair of parenthesis that surrounds everything
     * @param s string
     * @throws RuntimeException exception is thrown if the input string is not surrounded by parentheses
     */
    private void checkIfSurroundedByParentheses(String s) {
        s = s.trim();
        if(!(s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')'))
            throw new RuntimeException("Izraz nije okružen zagradama!");
    }
}
