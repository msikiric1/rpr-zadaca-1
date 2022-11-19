package ba.unsa.etf.rpr;

/**
 * Zadaca 1
 * @author Muaz Sikiric
 * @version 1.0
 */
public class App {
    /**
     * Main method
     * @param args input arguments from console
     */
    public static void main( String[] args ) {
        if(args.length == 0)
            System.out.println("Niste unijeli dovoljan broj argumenata!");
        else if(args.length > 1)
            System.out.println("Unijeli ste previše argumenata!");
        else {
            try {
                ExpressionEvaluator ee = new ExpressionEvaluator();
                double result = ee.evaluate(args[0]);
                System.out.println(args[0] + " = " + result);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
