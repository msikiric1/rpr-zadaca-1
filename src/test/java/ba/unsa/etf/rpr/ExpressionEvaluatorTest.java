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
     * Test 1
     */
    @Test
    public void evaluate1() {
        String input = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(101, ee.evaluate(input));
    }

    /**
     * Test 2
     */
    @Test
    public void evaluate2() {
        String input = "( ( ( 1 + 8 ) / 2 ) * ( 2 - ( 0.5 * 7 ) ) )";
        assertEquals(-6.75, ee.evaluate(input));
    }
}
