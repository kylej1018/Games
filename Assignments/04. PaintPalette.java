/* INSTRUCTIONS
 * Make a drawing game.  You should be able to click and drag the mouse and draw a "smear of paint" across your screen.  This is not a small assignment.
 * Suggested features:
 * ~Design an original splash screen (look up what a splash screen is on Google)
 * ~Change colors
 * ~Change brush sizes
 * ~Switch from circle to square
 * ~Switch from filled in to outline
 * ~Be able to clear screen to blank
 * ~Procreate and similar games have "buttons" on the screen to help the user facilitate these features.  If the user clicks inside those buttons, it changes a variable.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintPalette implements MouseListener, MouseMotionListener, KeyListener {
	JFrame window;
	JPanel pane;
	Dimension screen;
	Image buffImg; // for double buffering
	int screenwidth, screenheight; // screenwidth and height keep track of user's computer screen size

	public static void main(String[] args) {
		new PaintPalette();
	}
	
	public PaintPalette() {
		preinit();
		init();
	}
	
	public void preInit() {
		window = new JFrame("PaintPalette");
		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (buffImg == null) { // for double-buffering
					buffImg = createImage(screenwidth, screenheight);
				}
				myPaint(buffImg.getGraphics()); // don't override paint(), it produces errors
				g.drawImage(buffImg, 0, 0, pane);
			}
		};
		screen = Toolkit.getDefaultToolkit().getScreenSize(); // resizes applet to computer screen size
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
