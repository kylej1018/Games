/*Assignment: Make a drawing game like Procreate.  You should be able to click and drag the mouse and draw a "smear of paint" across your screen.
You will use lots of conditionals.
Suggested features:
~Design an original splash screen (look up what that is if you don't know)
~Change colors
~Change brush sizes
~Switch from circle to square
~Switch from filled in to outline
~Be able to clear screen to blank (or just draw a huge rectangle that "looks" blank)
~Set the font to Heveltica or something that doesn't look lame for g.drawString (might want to look up how - it's not that hard)
~Procreate and similar games have "buttons" to help the user facilitate these features.  You should too.

Questions to answer before you start:
How many "buttons" will you need?  How big should they be?  Where will they go?
Could any of these have keyboard shortcuts, like brush sizes changed when the user types a number?
Would your buttons look nicer with a black outline?
What can you put in your buttons so it's obvious to your user what it does?
What can you do so that the user knows what choice is selected?  Should the active choice be a different color from the rest of the buttons?

Now design what you want your screen to look like before you start coding.  Actually write down the x and y coordinates of your buttons.
Once you start coding, go in small spurts.  First, get a black circle around your mouse where you click (reference PrettyLines).
Then make it follow when you drag your mouse.
Maybe next change a color or something when you type the correct key.
Maybe next draw one button and change a color or something if the mouse clicks inside it.
Comment your code.  Don't learn the hard way that commenting is not optional.

Some suggestions on buttons:
Make a rectangle area and test if x is between the two bounds (or, should I say, farther than the left side && less far than the right side).  Same for y.
If mouse is in the button boundaries when clicked, change a global variable.  Then in myPaint, if variable is...whatever, then paint the smear or set the color.

One final note...I've built double-buffering into this outline.  Let me explain what that is so you can use it in future projects.
Odds are, your myPaint method is going to get very very large.
In fact, your computer may call pane.repaint() before myPaint even finishes.
That will make your computer flicker.  It looks bad.  But here's the secret.
Instead of painting on your screen, we're going to paint on a secret invisible image I've named buffImg, like buffered image.
If that finishes, then it will transfer the finished buffImg  to your screen.  See where it says g.drawImage?
So the thing happening on your screen is now only one line long: "Transfer" instead of "everything in myPaint".  Flickering avoided.
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintPalette implements MouseListener, MouseMotionListener, KeyListener {
	JFrame window;
	JPanel pane;
	Dimension screen;
	Image buffImg; //for double buffering
	Graphics g2; // for double buffering
	int screenwidth, screenheight; //screenwidth and height keep track of user's computer screen size

	public static void main(String[] args) {
		PaintPalette game = new PaintPalette();
	}
	
	public void init() {
		window = new JFrame("PaintPalette");
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
		screen = Toolkit.getDefaultToolkit().getScreenSize(); //resizes window to computer screen size
		screenwidth = (int)screen.getWidth();
		screenheight = (int)screen.getHeight();
		window.setSize(screenwidth, screenheight);
		pane.addMouseListener(this);
		pane.addMouseMotionListener(this);
		pane.addKeyListener(this);
		pane.setFocusable(true);
		window.add(pane);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public void myPaint(Graphics g) {}

	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}

	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
