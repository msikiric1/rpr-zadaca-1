package ba.unsa.etf.rpr;

/**
 * Zadaca 1
 * @author Muaz Sikiric
 * @version 0.1
 */
public class App {
    /**
     * Main method
     * @param args input arguments from console
     */
    public static void main( String[] args ) {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        double result = evaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        System.out.println(result);
    }
}
