import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PaintPalette extends Applet implements MouseListener, MouseMotionListener, KeyListener { //use appletviewer to run
	int x = -100; //x and y are mouse locations
	int y = -100;
	int r = 25; //size

	boolean splash = true;
	boolean clear = false; //for clearing screen under certain conditions
	String shape = "circle"; //shape can be circle, square, triangle, or star
	boolean buttonupdate = false; //if a key is pressed, repaint buttons but don't actually draw the shape
	Font myFont = new Font("Helvetica", Font.BOLD, 20); //name of font, Font.BOLD or PLAIN or ITALIC, font size

	Image buff; //these four variables are for double buffering
	Graphics g2;
	int screenwidth; //screenwidth and height keep track of user's computer screen size
	int screenheight;

	int[] trix = new int[3]; //all these []s are for drawing triangles and stars
	int[] triy = new int[3];
	int[] tributtonx;
	int[] tributtony;
	int[] starx = new int[10];
	int[] stary = new int[10];
	int[] starbuttonx;
	int[] starbuttony;
	int z; //for painting shape buttons. Note all buttons are 30x30

	public void init() {
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); //resizes applet to computer screen size
		screenwidth = (int)screen.getWidth();
		screenheight = (int)screen.getHeight();
		resize(screenwidth, screenheight);

		//a bunch of variables to make drawing shape-changing buttons easier
		z = 30*17; //x-coordinate for triangle button
		tributtonx = new int[]{z+15, z+5, z+25};
		tributtony = new int[]{5, 25, 25};
		z = z+30; //x-coordinate for star button
		starbuttonx = new int[]{z+15, z+12, z, z+9, z+6, z+15, z+24, z+21, z+30, z+18};
		starbuttony = new int[]{0, 12, 12, 18, 30, 22, 30, 18, 12, 12};
		z = z-90; //x-coordinate for cirle button
	}

	public void paint(Graphics g) {
		//An outline of paint() method, in this order:
		//1. Set things like font, color
		//2. Draw "paint smears" according to where user clicks
		//3. Clear screen if applicable
		//4. Draw buttons for user to click
		//5. Draw splash screen

		g.setFont(myFont);

		g.setColor(Color.black); //user paints black shapes

		if(shape.equals("circle") && x>30 && y>30 && !buttonupdate) { //draw circle at x,y
			g.fillOval(x-r, y-r, r*2, r*2);
		}
		if(shape.equals("square") && x>30 && y>30 && !buttonupdate) { //draw square at x,y
			g.fillRect(x-r, y-r, r*2, r*2);
		}
		if(shape.equals("triangle") && x>30 && y>30 && !buttonupdate) { //draw triangle at x,y
			trix[0] = x;
			trix[1] = x-r;
			trix[2] = x+r;
			triy[0] = y-r;
			triy[1] = y+r;
			triy[2] = y+r;
			g.fillPolygon(trix, triy, 3);
		}
		if(shape.equals("star") && x>30 && y>30 && !buttonupdate) { //draw star at x,y
			starx[0] = x;
			starx[1] = x-(r/5);
			starx[2] = x-r;
			starx[3] = x-(2*r/5);
			starx[4] = x-(3*r/5);
			starx[5] = x;
			starx[6] = x+(3*r/5);
			starx[7] = x+(2*r/5);
			starx[8] = x+r;
			starx[9] = x+(r/5);
			stary[0] = y-r;
			stary[1] = y-(r/5);
			stary[2] = y-(r/5);
			stary[3] = y+(r/5);
			stary[4] = y+r;
			stary[5] = y+(r/2);
			stary[6] = y+r;
			stary[7] = y+(r/5);
			stary[8] = y-(r/5);
			stary[9] = y-(r/5);
			g.fillPolygon(starx, stary, 10);
		}

		if(clear) { //clears screen
			g.setColor(Color.white);
			g.fillRect(0, 0, screenwidth+1, screenheight+1);
			clear = false;
		}

		g.drawImage(buff, 0, 0, this); //I was having issues with drawing not repainting upon size change, or minimizing. Adding this line to paint transfers the buffered image when, paint for some reason is called by the computer and not through update()

		if(!splash) { //buttons were appearing before splash screen
			g.setColor(Color.gray); //draw buttons
			g.fillRect(0,0,35,30);
			g.fillRect(z,0,120,30);
			g.setColor(Color.white);
			if(shape.equals("circle")) { //paint "selected" shape button white
				g.fillRect(z, 0, 30, 30);
			}
			if(shape.equals("square")) {
				g.fillRect(z+30, 0, 30, 30);
			}
			if(shape.equals("triangle")) {
				g.fillRect(z+60, 0, 30, 30);
			}
			if(shape.equals("star")) {
				g.fillRect(z+90, 0, 30, 30);
			}
			g.setColor(Color.black); //draw outlines
			g.drawRect(0,0,35,30);
			g.drawRect(z,0,30,30);
			g.drawRect(z+30,0,30,30);
			g.drawRect(z+60,0,30,30);
			g.drawRect(z+90,0,30,30);
			g.fillOval(z+5,5,20,20); //put shapes on shape changing buttons
			g.fillRect(z+35,5,20,20);
			g.fillPolygon(tributtonx, tributtony, 3);
			g.fillPolygon(starbuttonx, starbuttony, 10);
			g.setColor(Color.white);
			g.drawString("Clear",1,20);
			g.drawString("q", z+11, 18);
			g.drawString("w", z+41, 18);
			g.drawString("e", z+72, 20);
			g.drawString("r", z+103, 20);
		}

		if(splash) { //draws splashscreen on first time paint is called
			int h = this.getSize().height; //bisects the screen
			g.setColor(Color.black);
			g.fillRect(0, 0, screenwidth, h/2);
			g.setColor(Color.white);
			g.fillRect(0, h/2, screenwidth, h/2);
			g.drawString("paint palette", 180, h/2-3);
			g.setColor(Color.black);
			g.drawString("make your masterpiece", 230, h/2+14);
			g.drawString("a game by Sofia & Kyle", 730, h/2+150);
			g.drawString("click anywhere to begin", 750, h/2+190);

			int rad = 150;
			g.setColor(Color.red); //draws colored circles on splashscreen
			g.fillOval(100, h/2-175, rad, rad);
			g.setColor(Color.orange);
			g.fillOval(275, h/2-275, rad, rad);
			g.setColor(Color.yellow);
			g.fillOval(400, h/2-rad, rad, rad);
			g.setColor(Color.green);
			g.fillOval(325, h/2+25, rad, rad);
			g.setColor(Color.blue);
			g.fillOval(150, h/2+125, rad, rad);
			g.setColor(Color.magenta);
			g.fillOval(25, h/2, rad, rad);
		}
		buttonupdate = false;
	}

	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		splash = false;
		if(x < 0 && y < 0) { //for first click
			clear = true;
			shape = "circle";
			myFont = new Font("Helvetica", Font.PLAIN, 12);
		}

		x = e.getX(); //updating mouse coordinates
		y = e.getY();

		if(x < 30 && y < 30) { //clicking clear button
			clear = true;
		}

		if(y < 30) { //changing shape
			if(z < x && x < z+30) {
				shape = "circle";
			}
			if(z+30 < x && x < z+60) {
				shape = "square";
			}
			if(z+60 < x && x < z+90) {
				shape = "triangle";
			}
			if(z+90 < x && x < z+120) {
				shape = "star";
			}
		}

		repaint();
	}

	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {
		if(splash == false) {
			x = e.getX(); //updating mouse coordinates only available after first click
			y = e.getY();
			repaint();
		}
	}

	public void mouseMoved(MouseEvent e) {}

	public void keyTyped(KeyEvent e) {
		if(Character.toLowerCase(e.getKeyChar()) == 'q') { //change shape with keyboard
			shape = "circle";
		}
		if(Character.toLowerCase(e.getKeyChar()) == 'w') {
			shape = "square";
		}
		if(Character.toLowerCase(e.getKeyChar()) == 'e') {
			shape = "triangle";
		}
		if(Character.toLowerCase(e.getKeyChar()) == 'r') {
			shape = "star";
		}
		buttonupdate = true;
		repaint();
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void update(Graphics g) {
		if(buff == null) { //for double-buffering
			buff = createImage(screenwidth, screenheight);
			g2 = buff.getGraphics();
		}
		paint(g2);
		g.drawImage(buff, 0, 0, this);
	}
}
/*<applet code="PaintPalette" width=1300 height=800>
</applet>*/