//1. I want to click anywhere in my Applet window and draw a circle perfectly around that point.
//2. I want to to draw a line from my point to my previous point.  How can you retain the previous x and y values after clicking?
//3. I want to to type "s" and "c" and have it switch between drawing a square and circle.  Still want the line though.

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrettyLines extends Applet implements MouseListener, KeyListener { //use appletviewer to run
	int x = 0; //circle variables declared and initialized
	int y = 0;
	int r = 0;
	String shape = "circle";

	public void init() {
		addMouseListener(this);
		addKeyListener(this);
	}

	public void paint(Graphics g) {
		g.setColor(color.black);
		if(shape == "circle") {
			g.drawOval(x, y, r*2, r*2); //draw circle
			g.drawLine(0, 0, x, y);
		}
		//add code here for square
	}

	public void mouseClicked(MouseEvent e) { //x and y update when you click the mouse somewhere
		x = e.getX();
		y = e.getY();
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
		//add code here for circle
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void update(Graphics g) {
		paint(g);
	}

}
/*<applet code="PrettyLines" width=1300 height=800>
</applet>*/

//Homework: Add something cool to this code.
//Another shape or color is cool.
//A circle radius that changes size with each click is cool.
//Text/titles/instructions is cool.
//Can you think of anything else?
