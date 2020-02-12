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
