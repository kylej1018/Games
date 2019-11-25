/*
Make a Memory game, where a player turns over two of many facedown cards and tries to find the match.
It should have the following components:

At startup:
Splashscreen.
Ask if easy (3x4) or hard (5x5).
Start a game.
Computer shuffles and distributes 12 or 25 cards, facedown, in a grid.
Player chooses a card, it flips over.
Player chooses a second card, if flips over.
If they match, cards "exit" the game (stay flipped over or move to side?)
If they don't match, the next click by the player, regardless of where, reverts the cards.

The player has a sequence of three clicks - first card, second card, revert.  Computer needs to track which we're on.
Each card has one of three values: Faceup (additional values based on size), Facedown, or Exited.

Scoring:
When a player makes a match, score +10.
Game should keep track of how many times a cards is turned over.  If >2, score -5.

Button to side for rules.
Reset button: ask if easy or hard.
If hard mode, Joker card: exits game but reveals all surrounding cards until next click.

Tasks:
~Splash & initial prompt
~Game display & initialization
~Drawing of all the faceup cards
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
	Image buffImg; //for double buffering
	int screenwidth, screenheight; //screenwidth and height keep track of user's computer screen size

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
				buffer(g);
			}

			public void buffer(Graphics g) {
				if(buffImg == null) { //for double-buffering
					buffImg = createImage(screenwidth, screenheight);
				}
				myPaint(buffImg.getGraphics()); //don't override paint(), it produces errors
				g.drawImage(buffImg, 0, 0, pane);
			}
		};
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); //resizes applet to computer screen size
		screenwidth = (int)screen.getWidth();
		screenheight = (int)screen.getHeight();
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

	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
}
