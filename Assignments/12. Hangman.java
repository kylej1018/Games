/* INSTRUCTIONS
 * Create a Hangman game for users to play.
 * Download the hangman_prompts.txt file in the "Extras" section of this Github, or write your own list of hangman prompts.
 * Fix the FIXME line to reflect where you saved it.
 
 * When the game starts, ask user to choose between inputting an Answer or a "Random" option.
 * If random, select a random element from hangman_prompts to be the Answer.
 * Present a series of blank lines representing the letters in Answer - leave punctuation intact.
 *   hint: String has a method str.isLetter())
 * It should display nicely on the screen - if it's more than 75 chars, start a new line at the next space.
 * Allow the user to guess a letter using KeyListener.  Make sure it's a letter, or it doesn't count.
 * For each letter guessed, if it's correct, it should fill in all the places where Answer contains that letter.
 *   Capital or lowercase should both be filled.
 * If it doesn't appear in Answer, it is displayed in another area and a body part is drawn on the noose.
 * If they guess the same letter twice, it doesn't register as a guess.
 * If they guess all the letters before the hanged man is completely drawn, they win.
 * If the hanged man is completely drawn before they guess all the letters, they lose.
 * The program offers to play again.
 */

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import javax.swing.*;

public class Hangman implements KeyListener {
	JFrame window;
	JPanel pane;
	int screenWidth, screenHeight;
	Random r;

	ArrayList<String> possibleAnswers = populate();

	public static void main(String[] args) {
		new Hangman();
	}

	public Hangman() {
		init();
	}

	public void init() {
		r = new Random();

		window = new JFrame("Memory");
		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				myPaint(g); // don't override paint(), it produces errors
			}
		};
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); // resizes applet to computer screen size
		screenWidth = (int) screen.getWidth();
		screenHeight = (int) screen.getHeight();
		window.setSize(screenWidth, screenHeight);
		pane.setFocusable(true);
		window.add(pane);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		reset();
	}

	public void reset() {

	}

	public void myPaint(Graphics g) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public static ArrayList<String> populate() { // this reads a txt file into an ArrayList.
		String loc = "C:\\Users\\kylej\\Desktop\\Games\\Java\\Eclipse\\Hangman\\hangman_prompts.txt"; // FIXME
		ArrayList<String> arr = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(loc)));
			String input = br.readLine();
			while (input != null) {
				arr.add(input);
				input = br.readLine();
			}
			br.close();
		} catch (Exception ex) {
		}
		return arr;
	}
}
