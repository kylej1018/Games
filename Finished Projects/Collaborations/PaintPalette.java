import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintPalette implements MouseListener, MouseMotionListener, KeyListener {
	int x = -50; 
	int y = -50;
	int r = 25;
	int scrollx = 8;
	int scrolly = 275;
	boolean onscroll = false;
	boolean isFilled = true;
	Color rainbow = Color.black;
	boolean splash = true;
	boolean clear = false; //for clearing screen under certain conditions
	String shape = "circle"; //shape can be circle, square, triangle, or star
	boolean buttonupdate = false; //if a key is pressed, repaint buttons but don't actually draw the shape
	Font myFont = new Font("Helvetica", Font.BOLD, 20); //name of font, Font.BOLD or PLAIN or ITALIC, font size

	JFrame window;
	JPanel pane;
	Dimension screen;
	Image buffImg; //these four variables are for double buffering
	Graphics g2;
	int screenwidth, screenheight; //screenwidth and height keep track of user's computer screen size

	int[] trix = new int[3]; //all these []s are for drawing triangles and stars
	int[] triy = new int[3];
	int[] tributtonx;
	int[] tributtony;
	int[] starx = new int[10];
	int[] stary = new int[10];
	int[] starbuttonx;
	int[] starbuttony;
	int z; //for painting shape buttons. Note all buttons are 30x30

	public static void main(String[] args) {
		PaintPalette game = new PaintPalette();
	}

	public PaintPalette() { //constructor
		preInit();
		init();
	}

	public void preInit() {
		window = new JFrame("PaintPalette");
		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				if(buffImg == null) { //for double-buffering
					buffImg = createImage(screenwidth, screenheight);
				}
				myPaint(buffImg.getGraphics()); //don't override paint(), it produces errors
				g.drawImage(buffImg, 0, 0, pane);
			}
		};
		screen = Toolkit.getDefaultToolkit().getScreenSize(); //resizes applet to computer screen size
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

	public void init() {
		//a bunch of variables to make drawing shape-changing buttons easier
		z = 30*17; //x-coordinate for triangle button
		tributtonx = new int[]{z+15, z+5, z+25};
		tributtony = new int[]{5, 25, 25};
		z = z+30; //x-coordinate for star button
		starbuttonx = new int[]{z+15, z+12, z, z+9, z+6, z+15, z+24, z+21, z+30, z+18};
		starbuttony = new int[]{0, 12, 12, 18, 30, 22, 30, 18, 12, 12};
		z = z-90; //x-coordinate for cirle button
	}

	public void myPaint(Graphics g) {
		//An outline of paint() method, in this order:
		//1. Set things like font, color
		//2. Draw "paint smears" according to where user clicks
		//3. Clear screen if applicable
		//4. Draw buttons for user to click
		//5. Draw splash screen

		g.setFont(myFont);
		g.setColor(rainbow);

		if(shape.equals("circle") && x>30 && y>30 && !buttonupdate) { //draw circle at x,y
			if (isFilled && y>30 && onscroll == false) { 
				g.fillOval(x-r, y-r, r*2, r*2);
			}
			if (!isFilled && y>30 && onscroll == false) { 
				g.drawOval(x-r, y-r, r*2, r*2);
			}
		}
		if(shape.equals("square") && x>30 && y>30 && !buttonupdate) { //draw square at x,y
			if (isFilled && y>30 && onscroll == false) { 
				g.fillRect(x-r, y-r, r*2, r*2);
			}
			if (!isFilled && y>30 && onscroll == false) { 
				g.drawRect(x-r, y-r, r*2, r*2);	
			}
		}
		if(shape.equals("triangle") && x>30 && y>30 && !buttonupdate) { //draw triangle at x,y
			trix[0] = x;
			trix[1] = x-r;
			trix[2] = x+r;
			triy[0] = y-r;
			triy[1] = y+r;
			triy[2] = y+r;
			if (isFilled && y>30 && onscroll == false) { 
				g.fillPolygon(trix, triy, 3);
			}
			if (!isFilled && y>30 && onscroll == false) { 
				g.drawPolygon(trix, triy, 3);
			}
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
			if (isFilled && y>30 && onscroll == false) { 
				g.fillPolygon(starx, stary, 10);
			}
			if (!isFilled && y>30 && onscroll == false) { 
				g.drawPolygon(starx, stary, 10);
			}
		}

		if(clear) { //clears screen
			g.setColor(Color.white);
			g.fillRect(0, 0, screenwidth+1, screenheight+1);
			clear = false;
		}

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

			g.setColor(Color.gray); //draw color buttons
			g.fillRect(70, 0, 270, 30);
			g.setColor(Color.white); //draw active color button
			if(rainbow == Color.white) {
				g.fillRect(70, 0, 30, 30);
			}
			if(rainbow == Color.red) {
				g.fillRect(100, 0, 30, 30);
			}
			if(rainbow == Color.orange) {
				g.fillRect(130, 0, 30, 30);
			}
			if(rainbow == Color.yellow) {
				g.fillRect(160, 0, 30, 30);
			}
			if(rainbow == Color.green) {
				g.fillRect(190, 0, 30, 30);
			}
			if(rainbow == Color.blue) {
				g.fillRect(220, 0, 30, 30);
			}
			if(rainbow == Color.magenta) {
				g.fillRect(250, 0, 30, 30);
			}
			if(rainbow == Color.gray) {
				g.fillRect(280, 0, 30, 30);
			}
			if(rainbow == Color.black) {
				g.fillRect(310, 0, 30, 30);
			}
			g.setColor(Color.black); //draw black circles in color buttons
			g.drawRect(70, 0, 30, 30);
			g.drawOval(70, 0, 30, 30);
			g.drawRect(100, 0, 30, 30);
			g.drawOval(100, 0, 30, 30);
			g.drawRect(130, 0, 30, 30);
			g.drawOval(130, 0, 30, 30);
			g.drawRect(160, 0, 30, 30);
			g.drawOval(160, 0, 30, 30);
			g.drawRect(190, 0, 30, 30);
			g.drawOval(190, 0, 30, 30);
			g.drawRect(220, 0, 30, 30);
			g.drawOval(220, 0, 30, 30);
			g.drawRect(250, 0, 30, 30);
			g.drawOval(250, 0, 30, 30);
			g.drawRect(280, 0, 30, 30);
			g.drawOval(280, 0, 30, 30);
			g.drawRect(310, 0, 30, 30);
			g.drawOval(310, 0, 30, 30);
			g.setColor(Color.white); //draw colors in color buttons
			g.fillOval(70, 0, 30, 30);
			g.setColor(Color.red);
			g.fillOval(100, 0, 30, 30);
			g.setColor(Color.orange);
			g.fillOval(130, 0, 30, 30);
			g.setColor(Color.yellow);
			g.fillOval(160, 0, 30, 30);
			g.setColor(Color.green);
			g.fillOval(190, 0, 30, 30);
			g.setColor(Color.blue);
			g.fillOval(220, 0, 30, 30);
			g.setColor(Color.magenta);
			g.fillOval(250, 0, 30, 30);
			g.setColor(Color.gray);
			g.fillOval(280, 0, 30, 30);
			g.setColor(Color.black);
			g.fillOval(310, 0, 30, 30);

			if(isFilled) {
				g.setColor(Color.white);
			}
			if(!isFilled) {
				g.setColor(Color.gray);
			}
			g.fillRect(400, 0, 30, 30);
			g.setColor(Color.black);
			g.drawRect(400, 0, 30, 30);
			g.drawString("FILL", 403, 20);
		
			g.setColor(Color.gray); //scroll bar
			g.fillRect(0, 65, 30, 315);
			g.setColor(Color.black);
			g.drawLine(15, 80, 15, 365);
			g.fillRect(scrollx, scrolly, 16, 15);
			g.drawString("1", 0, 347);
			g.drawString("2", 0, 317);
			g.drawString("3", 0, 287);
			g.drawString("4", 0, 257);
			g.drawString("5", 0, 227);
			g.drawString("6", 0, 197);
			g.drawString("7", 0, 167);
			g.drawString("8", 0, 137);
			g.drawString("9", 0, 107);
			if(onscroll) {
				g.setColor(Color.white);
				g.drawRect(scrollx, scrolly, 16, 15);
			}
		}

		if(splash) { //draws splashscreen on first time paint is called
			int h = (int)screen.getHeight(); //bisects the screen
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
		
	public void mousePressed(MouseEvent e) {
		splash = false;
		if(x < 0 && y < 0) { //for first click
			clear = true;
			shape = "circle";
			myFont = new Font("Helvetica", Font.PLAIN, 12);
		}
		x = e.getX();
		y = e.getY();
		if(x >= scrollx && x<= scrollx + 18 && y >= scrolly && y <= scrolly + 14) {
			onscroll = true;
		}

		if(x>70 && x<100 && y<30) { 
			rainbow = Color.white;
		}		
		if(x>100 && x<130 && y<30) { 
			rainbow = Color.red;
		}
		if(x>130 && x<160 && y<30) { 
			rainbow = Color.orange;
		}
		if(x>160 && x<190 && y<30) { 
			rainbow = Color.yellow;
		}
		if(x>190 && x<220 && y<30) { 
			rainbow = Color.green;
		}
		if(x>220 && x<250 && y<30) { 
			rainbow = Color.blue;
		}
		if(x>250 && x<280 && y<30) { 
			rainbow = Color.magenta;
		}
		if(x>280 && x<310 && y<30) { 
			rainbow = Color.gray;
		}
		if(x>310 && x<340 && y<30) { 
			rainbow = Color.black;
		}

		if(x > 400 && x < 430 && y < 30) {
			isFilled = !isFilled;
		}

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
		pane.repaint();
	}

	public void mouseReleased(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(onscroll) {
			buttonupdate = true;
			onscroll = false;
			pane.repaint();
		}
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if (onscroll == true) {
			scrolly = y;
			if (scrolly < 80) {
				scrolly = 80;
			}
			if (scrolly > 350) {
				scrolly = 350;
			}

			if (scrolly > 320) {
				r = 3;
			}
		    	else if (scrolly > 290) {
				r = 10;
			}
		   	else if (scrolly > 260) {
				r = 25;
			}
		    	else if (scrolly > 230) {
				r = 40;
			}
		    	else if (scrolly > 200) {
				r = 50;
			}
		   	else if (scrolly > 170) {
				r = 65;
			}
		    	else if (scrolly > 140) {
				r = 80;
			}
		    	else if (scrolly > 110) {
				r = 90;
			}
		    	else {
				r = 100;
			}
		}
		pane.repaint();
	}

	public void mouseMoved(MouseEvent e) {}

	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == '1') {
			r = 3;
			scrolly = 335;
		}
		if (e.getKeyChar() == '2') {
			r = 10;
			scrolly = 305;
		}
		if (e.getKeyChar() == '3') {
			r = 25;
			scrolly = 275;
		}
		if (e.getKeyChar() == '4') {
			r = 40;
			scrolly = 245;
		}
		if (e.getKeyChar() == '5') {
			r = 50;
			scrolly = 215;
		}
		if (e.getKeyChar() == '6') {
			r = 65;
			scrolly = 185;
		}
		if (e.getKeyChar() == '7') {
			r = 80;
			scrolly = 155;
		}
		if (e.getKeyChar() == '8') {
			r = 90;
			scrolly = 125;
		}
		if (e.getKeyChar() == '9') {
			r = 100;
			scrolly = 95;
		}

		if(Character.toLowerCase(e.getKeyChar()) == 'f') { //change fill status
			isFilled = !isFilled;
		}

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
		pane.repaint();
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
