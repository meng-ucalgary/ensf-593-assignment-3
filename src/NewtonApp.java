/**
 * Class providing the command-line interface to compute the square-root of a
 * number using Newton's method of calculating square root.
 *
 * @author Bhavyai Gupta
 * @version 1.0
 * @since May 27, 2021
 */
public class NewtonApp {
    /**
     * An instance variable of NewtonTester to create object of NewtonTester
     */
    private NewtonTester newton;

    /**
     * An instance variable of KeyboardReader to facilitate reading user input
     */
    private KeyboardReader reader;

    /**
     * Constructs an object of class NewtonApp and assigns default value to the
     * reader instance variable
     */
    public NewtonApp() {
        reader = new KeyboardReader();
    }

    /**
     * Provides TUI for interaction with user. Receives required inputs from the
     * user and initialize the NewtonTester object with the inputs. Prints the
     * square root of the desired number and the number of iterations performed to
     * compute the square root.
     */
    public void run() {
        reader.display("\n");
        reader.display("Welcome to Newton's Square Root\n");
        reader.display("-------------------------------\n\n");

        reader.prompt("Enter a non-zero positive number whose square root you want to find (eg enter 27362.75): ");
        double N = reader.getKeyboardDouble();

        reader.prompt("Enter a non-zero guess for the possible square root (eg 100): ");
        double guess = reader.getKeyboardDouble();

        reader.prompt("Enter a non-zero tolerance level (eg 0.0001): ");
        double tolerance = reader.getKeyboardDouble();

        this.newton = new NewtonTester(N, guess, tolerance);
        reader.display(String.format("%n%nThe square root for %f within tolerance %f is %f", N, tolerance, newton.sqrt()));
        reader.display(String.format("%n%nNumber of iterations performed for the calculation = %d\n",
                newton.getNumberOfIterations()));

        reader.display("\nBye!\n");
    }

    /**
     * Function to call the instance method run()
     *
     * @param args not used
     */
    public static void main(String[] args) {
        NewtonApp app = new NewtonApp();
        app.run();
    }
}
