/*Make a memory matching game.  It should include the following:

Splashscreen.
Start a game.
Computer shuffles and distributes cards, facedown, in a grid.
Player chooses a card, it flips over.
Player chooses a second card, if flips over.
If they match, cards "exit" the game (stay flipped over or move to side?)
If they don't match, the next click by the player, regardless of where, reverts the cards.

The player has a sequence of three clicks - first card, second card, revert.  Computer needs to track which we're on.
Each card has one of three values: Faceup (additional values based on size), Facedown, or Exited.

Extra optional things to add:
~Easy/hard mode.  Hard mode has more cards.
~Scoring.
	When a player makes a match, score +10.
	Game could keep track of how many times a cards is turned over.  If >2, score -5.
~Button to side for rules.
~Reset button: ask if easy or hard.
~If hard mode, add a Joker card.  If clicked, it is removed from game but reveals all surrounding cards until next click.

Make sure to break this down into about 6-7 smaller tasks, such as
~Splash & initial prompt
~Initialization of arrays
~Game display w/ score, rules, drawing cards
~The actual design of faceup cards
~Clicking cards to turn over
~Evaluate match and possible exit
~Joker card
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Memory implements MouseListener {
	JFrame window;
	JPanel pane;

	public static void main(String [] args) {
		Memory game = new Memory();
	}

	public Memory() { //constructor
		preInit();
		init();
	}

	public void preInit() {
		window = new JFrame("MemoryGame");
		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				myPaint(g);
			}
		};
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); //resizes applet to computer screen size
		int screenwidth = (int)screen.getWidth();
		int screenheight = (int)screen.getHeight();
		window.setSize(screenwidth, screenheight);

		pane.addMouseListener(this);
		pane.setFocusable(true);
		window.add(pane);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public void init() { //initializes program
		//FIXME: Add initialization settings
	}

	public void myPaint(Graphics g) {
		//FIXME: Additional paint code here;
	}

	public void mousePressed(MouseEvent e) {} //FIXME: Add mouse effects.  Don't forget to add pane.repaint()
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
