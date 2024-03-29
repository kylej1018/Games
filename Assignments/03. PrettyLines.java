/* Last time, we worked only in the myPaint area.  We'll do some myPaint this time, but now you'll also be looking at global variables and Listener interfaces.
 * Read through the instructions, and then all the tutorials for section 3 before starting.
 * 
 * INSTRUCTIONS:
 * Debug as needed until it runs.  Once it runs, you'll find it doesn't work so great.  Solve each of these problems, one at a time.
 * 1. I want to click anywhere in my window and draw a circle perfectly around that point. (hint: Tutorial 3a)
 * 2. I want to draw a line from my point to my previous point.  How can you retain the previous x and y values after clicking? (hint: Tutorial 3c)
 * 3. I want to type "s" and "c" and have it switch between drawing a square and circle.  Still want the line though. (hint: Tutorial 3d)
 * 4. Add something cool to this code.
 * Another color is cool.
 * A circle radius that changes size with each click is cool.
 * Text, a title, instructions are cool.
 * Can you think of anything else?
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrettyLines implements MouseListener, KeyListener {
	JFrame window = new JFrame("PrettyLines");
	JPanel pane;
	
	int x = 0; // global variables declared and initialized
	int y = 0;
	int r = 0;
	String shape = "circle";
	
	public static void main(String[] args) {
		new PrettyLines();	
	}
	
	public PrettyLines() {
		init();
	}

	public void init() {
		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				myPaint(g);
			}
		};
		pane.addMouseListener(this);
		pane.addKeyListener(this);
		pane.setFocusable(true);
		window.setSize(300, 300);
		window.add(pane);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		reset();
	}
	
	public void reset() {}
	
	public void myPaint(Graphics g) {
		g.setColor(color.black);
		if(shape == "circle") {
			g.drawOval(x, y, r*2, r*2); // draw circle
			g.drawLine(0, 0, x, y);
		}
		// For part 3, add code here for square
	}

	public void mouseClicked(MouseEvent e) { // x and y update when you click the mouse somewhere
		x = e.getX();
		y = e.getY();
		pane.repaint();
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void keyTyped(KeyEvent e) { // shape updates when you type the correct letter
		if(e.getKeyChar() == 's') {
			shape = "square";
		}
		// For part 3, add code here for circle
		pane.repaint();
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
