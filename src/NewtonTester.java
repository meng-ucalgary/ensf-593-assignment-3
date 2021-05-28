/**
 * Class to provide methods for calculating the Newton's square root of a number
 * and getting the number of iterations performed for the computation of the
 * square root.
 *
 * @author Bhavyai Gupta
 * @version 1.0
 * @since May 27, 2021
 */
public class NewtonTester {
    /**
     * The number of iterations performed to calculate the square root
     */
    private int numberOfIterations;

    /**
     * The number whose square root is to be computed
     */
    private double N;

    /**
     * The initial wild guess for the square root
     */
    private double guess;

    /**
     * The maximum error that can be tolerated with the answer
     */
    private double tolerance;

    /**
     * Constructs an object of NewtonTester and initializes the arguments with
     * supplied parameter values. Also sets the number of iteration to be 0
     *
     * @param N         the number whose square root is to be computed
     * @param guess     an initial wild guess for the square root
     * @param tolerance max error that can be tolerated with the answer
     */
    public NewtonTester(double N, double guess, double tolerance) {
        this.numberOfIterations = 0;
        this.N = N;
        this.guess = guess;
        this.tolerance = tolerance;
    }

    /**
     * Computes the square root of a number with Newton's algorithm for finding the
     * square root of a number
     *
     * @return the square root of the instance variable N
     */
    public double sqrt() {
        // creating a local variable to hide the instance variable
        double guess = this.guess;
        double prevGuess = guess;

        while (true) {
            this.numberOfIterations++;

            prevGuess = guess;
            guess = ((this.N / guess) + guess) / 2;

            // making guesses only until new guess are closer to previous guess
            if (Math.abs(guess - prevGuess) < this.tolerance) {
                break;
            }
        }

        return guess;
    }

    /**
     * Getter method for the numberOfIterations
     *
     * @return the number of iterations performed to get the newton's square root
     */
    public int getNumberOfIterations() {
        return numberOfIterations;
    }
}
