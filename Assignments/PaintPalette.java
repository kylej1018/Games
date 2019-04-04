//Splash screen
//Change colors
//Change brush sizes
//Switch from circle to square and others
//Switch from filled in to outline
//Erase button

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintPalette extends Applet implements MouseListener, MouseMotionListener, KeyListener { //use appletviewer to run

	public void init() {
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}

	public void paint(Graphics g) {}

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

	public void update(Graphics g) {
		paint(g);
	}

}
/*<applet code="PaintPalette" width=1300 height=800>
</applet>*/
