package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for ExpressionEvaluator class
 */
public class ExpressionEvaluatorTest
{
    ExpressionEvaluator ee = new ExpressionEvaluator();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void evaluate1() {
        String input = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(101, ee.evaluate(input));
    }
}
