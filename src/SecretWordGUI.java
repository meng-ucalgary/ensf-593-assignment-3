import javax.swing.*; 
import java.awt.*;
import java .awt. event .*;
	
/**
 * @author 
 *
 */
public class SecretWordGUI extends JFrame implements ActionListener{

	private JTextField inputField; 
	private JTextArea display;
    private String inputString;
    private SecretWord secret;

	public SecretWordGUI(String title)  {
		secret = new SecretWord();
		
		JLabel prompt = new JLabel("Input a single character to guess the secret word (hit ENTER):");

		inputField = new JTextField(5); 
		inputField.setText("");
		inputField.addActionListener( this ); 

		display = new JTextArea (10 ,30);
		display.append("The secret word: " + secret.getDisplayedWord() +"\n");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
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

	public void actionPerformed(ActionEvent evt)  { 
		if ( evt.getSource() == inputField) { 
			inputString = inputField.getText();
	        inputField.setText("");
	        boolean guess = secret.makeGuess(inputString.charAt(0));

	                            // Process the user's guess
	        if (guess == true) 
	            display.append ("That Guess Was Right " + secret.getDisplayedWord() + "\n");
	        else 
	            display.append ("That Guess Was Wrong " + secret.getDisplayedWord() + "\n");

		}
	}

	public static void main(String[] args) {

		//Starting the GUI application
		new SecretWordGUI("Guess the secret word");

	}

}

