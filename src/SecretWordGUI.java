import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class to provide a GUI interface that lets the user make repeated guesses at
 * the letters contained in a secret word. Each time the user makes a guess, the
 * GUI reports whether the guess is correct or not and displays the updated
 * version of the secret word.
 *
 * @author Bhavyai Gupta
 * @version 1.0
 * @since May 28, 2021
 */
public class SecretWordGUI extends JFrame implements ActionListener {
    /**
     * The input field to fetch the guess made by the user
     */
    private JTextField inputField;

    /**
     * Display area to print if the guess made by the user was correct or wrong, along
     * with the updated version of the secret word to be guessed
     */
    private JTextArea display;

    /**
     * The String to store the user guess fetched from the inputField
     */
    private String inputString;

    /**
     * variable of type SecretWord, which holds the logic of this program and
     * provides instance methods of SecretWord
     */
    private SecretWord secret;

    /**
     * Constructs the GUI interface to interact with the user
     *
     * @param title The title to show on the title bar of the windows
     */
    public SecretWordGUI(String title) {
        secret = new SecretWord();

        JLabel prompt = new JLabel("Input a single character to guess the secret word (hit ENTER):");

        inputField = new JTextField(5);
        inputField.setText("");
        inputField.addActionListener(this);

        display = new JTextArea(10, 30);
        display.append("The secret word: " + secret.getDisplayedWord() + "\n");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        panel.add(prompt);
        panel.add(inputField);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        contentPane.add("Center", panel);
        contentPane.add("South", display);

        setTitle(title);
        pack();
        setVisible(true);

    }

    /**
     * Catches the events by the ActionListener as a result of user interaction with
     * the GUI interface
     *
     * @param evt The action caught by the GUI
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == inputField) {
            inputString = inputField.getText();
            inputField.setText("");
            boolean guess = secret.makeGuess(inputString.charAt(0));

            // Process the user's guess
            if (guess == true)
                display.append("That Guess Was Right " + secret.getDisplayedWord() + "\n");
            else
                display.append("That Guess Was Wrong " + secret.getDisplayedWord() + "\n");
        }
    }

    /**
     * Method to create the GUI by calling the constructor SecretWordGUI
     *
     * @param args not used
     */
    public static void main(String[] args) {
        // Starting the GUI application
        new SecretWordGUI("Guess the secret word");
    }
}
