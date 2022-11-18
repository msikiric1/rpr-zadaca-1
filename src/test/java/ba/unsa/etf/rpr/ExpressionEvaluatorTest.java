package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for ExpressionEvaluator class
 */
public class ExpressionEvaluatorTest
{
    ExpressionEvaluator ee = new ExpressionEvaluator();
    /**
     * Integer expression test
     */
    @Test
    public void evaluate1() {
        String input = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(101, ee.evaluate(input));
    }

    /**
     * Integer and double expression test
     */
    @Test
    public void evaluate2() {
        String input = "( ( ( 1 + 8 ) / 2 ) * ( 2 - ( 0.5 * 7 ) ) )";
        assertEquals(-6.75, ee.evaluate(input));
    }

    /**
     * Expression inside sqrt operator test
     */
    @Test
    public void evaluate3() {
        String input = "( sqrt ( ( 18 / 2 ) ) * ( ( 3 + 2 ) - 1 ) )";
        assertEquals(12, ee.evaluate(input));
    }

    /**
     * Double expression test
     */
    @Test
    public void evaluate4() {
        String input = "( ( ( 4.25 * 3.8 ) / 4 ) - ( ( 3.5 / 2.5 ) * ( 2.34 - ( 1.2 * 1.2 ) ) ) )";
        assertEquals(2.7775, ee.evaluate(input));
    }

    /**
     * Complex  expression test
     */
    @Test
    public void evaluate5() {
        String input = "( ( 5 / ( 100 - 123 ) ) * ( ( ( 6 * ( 5.5 - sqrt ( 225 ) ) ) * 3.14 ) + ( 42 / ( 1234 / sqrt ( ( 64 * 16 ) ) ) ) ) )";
        assertEquals(38.67192586850821, ee.evaluate(input));
    }

    /**
     * Sqrt operator test
     */
    @Test
    public void sqrt() {
        String input = "( ( sqrt ( 49 ) * sqrt ( 121 ) ) / sqrt ( 4 ) )";
        assertEquals(38.5, ee.evaluate(input));
    }

    /**
     * More operators than expected test
     */
    @Test
    public void extraOperators() {
        String input = "( ( 5 * ( 3 / - 5 ) ) + 1 )";
        assertThrows(RuntimeException.class, () -> ee.evaluate(input));
    }

    /**
     * Division by zero test
     */
    @Test
    public void divisionByZero() {
        String input = "( 5 * ( 2 / 0 ) )";
        assertThrows(IllegalArgumentException.class, () -> ee.evaluate(input));
    }

    /**
     * Not surrounded by parentheses test
     */
    @Test
    public void notSurroundedByParentheses() {
        String input = "1 + 2 + 3 + 4 + 5";
        assertThrows(RuntimeException.class, () -> ee.evaluate(input));
    }

    /**
     * Invalid character test
     */
    @Test
    public void invalidCharacter() {
        String input = "( 1.7 + ( 25 % 5 ) )";
        assertThrows(RuntimeException.class, () -> ee.evaluate(input));
    }
}
