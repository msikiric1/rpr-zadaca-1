package ba.unsa.etf.rpr;

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
    public Double evaluate(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        boolean shouldBeSpace = false, hasNumberToAdd = false;
        Double number = 0.;
        for(Character c : expression.toCharArray()) {
            if("*/+-".indexOf(c) != -1) {
                operators.push(c);
            } else if(c.equals('s')) {
                // TODO
                operators.push('s');
            } else if(Character.isDigit(c)) {
                number = number * 10 + Character.getNumericValue(c);
                hasNumberToAdd = true;
            } else if(hasNumberToAdd && c.equals(' ')) {
                operands.push(number);
                hasNumberToAdd = false;
                number = 0.;
            } else if(c.equals(')')) {

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
    private Double expressionToValue(Character operator, Double a, Double b) {
        switch(operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if(b == 0) throw new IllegalArgumentException("Zabranjeno je dijeljenje nulom!");
                return a / b;
        }
        return null;
    }
}
