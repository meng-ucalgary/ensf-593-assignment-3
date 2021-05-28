/**
 * Class to provide methods for calculating the Newton's square root of a number
 * and getting the number of iterations performed for the computation of the
 * square root.
 *
 * @author Bhavyai Gupta
 * @version 1.0
 * @since May 28, 2021
 */
public class SecretWord {
    /**
     * String to store the secret word to be guessed by the user
     */
    private String secretWord;

    /**
     * String to display the masked secretWord, showing what all letters still needs
     * to be guessed. After each user guess, this string basically holds the updated
     * version of the secret word to be displayed
     */
    private String displayedWord;

    /**
     * Getter for the displayedWord
     *
     * @return the string to be displayed to the user
     */
    public String getDisplayedWord() {
        return this.displayedWord;
    }

    /**
     * Getter for the secretWord
     *
     * @return the string holding the secret word to be guessed by the user
     */
    public String getSecretWord() {
        return this.secretWord;
    }

    /**
     * String to mask the secret word completely, which is used when starting the
     * guessing game
     *
     * @param str the string to be masked
     * @param c   the masking character which replaces all the alphabets in the
     *            string
     * @return the masked string
     */
    public String replaceChars(String str, char c) {
        String temp = str.replaceAll("[a-z]", String.valueOf(c));
        return temp;
    }

    /**
     * Constructor to initialize the secretWord with hard-coded string and
     * initialize the displayedWord with all characters of secretWord masked
     */
    public SecretWord() {
        // hard coding the secret word
        this.secretWord = "Calgary".toLowerCase();
        this.displayedWord = this.replaceChars(this.getSecretWord(), '*');

        // below lines are for debug only
        // System.out.println("Secret = " + this.getSecretWord());
        // System.out.println("Masked = " + this.getDisplayedWord());
    }

    /**
     * Method to replace in <code>s2</code> every occurrence of <code>ch</code> in
     * <code>s1</code>
     *
     * @param s1 the string against which ch is checked
     * @param s2 the string in which replacements of ch needs to be done
     * @param ch the character which is replacing the masked asteriks
     */
    public void replaceChars(String s1, String s2, char ch) {
        // creating a mutable string to unmask the correctly guessed characters
        StringBuilder sb = new StringBuilder(s2);

        // loop to unmask the correctly guessed character 'ch' from all indexes
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == ch) {
                sb.setCharAt(i, ch);
            }

            else
                continue;
        }

        // converting mutable string back to immutable for storing in instance variable
        this.displayedWord = sb.toString();
    }

    /**
     * Method to check if for the guess made by the user was correct and update the
     * masked word displayed by calling the method replaceChars
     *
     * @param charAt
     * @return
     */
    public boolean makeGuess(char charAt) {

        if (this.getSecretWord().contains(String.valueOf(charAt))) {
            this.replaceChars(this.getSecretWord(), this.getDisplayedWord(), charAt);

            return true;
        }

        else {
            return false;
        }
    }
}
