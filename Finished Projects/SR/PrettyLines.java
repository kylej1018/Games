import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrettyLines extends Applet implements MouseListener, KeyListener { //use appletviewer to run
	int x = 0; //circle variables declared and initialized
	int y = 0;
	int r = 0;
	int xlast = 0;
	int ylast = 0;
	String shape = "circle";

	public void init() {
		addMouseListener(this);
		addKeyListener(this);
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		if(shape == "circle") {
			g.drawOval(x-r, y-r, r*2, r*2); //draw circle
			g.drawLine(xlast, ylast, x, y);
		}
		if(shape == "square") {
			g.drawRect(x-r, y-r, r*2, r*2); //draw square
			g.drawLine(xlast, ylast, x, y);
		}
	}

	public void mouseClicked(MouseEvent e) { //x and y update when you click the mouse somewhere
		xlast = x;
		ylast = y;
		x = e.getX();
		y = e.getY();
		r=30;
		repaint();
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void keyTyped(KeyEvent e) { //shape updates when you type the correct letter
		if (e.getKeyChar() == 's') {
			shape = "square";
		}
		if (e.getKeyChar() == 'c') {
			shape = "circle";
		}
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void update(Graphics g) {
		paint(g);
	}

}
/*<applet code="PrettyLines" width=1300 height=800>
</applet>*/
