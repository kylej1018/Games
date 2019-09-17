/*Last time, we worked only in the myPaint area.  We'll do some myPaint() this time, but now you'll also be looking at global variables and input areas.
You'll need to know some things before trying to debug this code.

Variables!  There are a few different types of variables to know.
int = an integer number.  Could be 1, 15, -3, or 0.
double = a decimal number.  Could be 1.0, -5.893.
char = a character, surrounded by single quotes.  Could be 'a', 'g', 'A', '.', '#', or ' '.
String = a bunch of text, surrounded by double quotes.  Could be "mytext", "this is not a string", or " ".  String is capitalized.
boolean = literally only can have the values true, false.  Sometimes you can have an expression that is essentially a boolean, like "a > 3" or "b < c".  These expressions are either true or false.
They're used to help different parts of your code communicate...like input & paint.
If they're delcared in curly brackets, they're local variables and other parts of your code can't use them.
The opposite of local variables is global variables.  Can you see where these global variables are?

Input!  Sometimes you want your user to have some say over the code.
There are two inputs used in this code: MouseListener and KeyListener.
These are implemented in the same line as class.  They make the computer ready to take input.
If you implement a Listener, you need to have some methods, even if they're blank:
If you implement MouseListener, you need: mousePressed, mouseReleased, mouseEntered, mouseExited, mouseClicked
If you implement KeyListener, you need: keyTyped, keyPressed, keyReleased
I've already added these methods - can you find where each one is?  Any missing?  Can you guess what activates each one?
It is also common to use MouseMotionListener, for which you need: mouseMoved, mouseDragged.  You don't need it for PrettyLines.
When a mouse or keyboard action happens, it activates the code in the appropriate brackets.
You can get some information about each action.
In KeyListener, e.getKeyChar() tells you what button got pressed.  You can assign it to a char variable.
In MouseListener and MouseMotionListener, e.getX() and e.getY() respectively return the X and Y coordinates of the mouse event.  You can assign them to int variables.
You'll nearly always want a pane.repaint() in every mouse or key method where you have code.  Otherwise, how would you know if anything changed?
Look in the code for where it says pane.addMouseListener(this) and pane.addKeyListener(this).  That's absolutely essential for this to work.
You also need a pane.setFocusable(true) if you want KeyListener to work.  You don't really need to know what it does for now.

Conditionals!  Sometimes you only want things to happen "if" a statement is true.
Inside the parentheses is a boolean or a boolean expression (see Variables! above).
You can use < or >, or == for equal to.  You need 2 equals signs, otherwise, it thinks you're ASSIGNING a variable to a value rather than comparing.
If you want to use "not" greater than, you use != to say it.  >= is greater than or equal to, <= is less than or equal to.
If you have a boolean b, you can even say if(b) or if(!b).
If this condition is met, the code below it will execute.  If not, it will skip that code.
Can you find an example of a conditional in this code?
You may also want to test if two things are true - check these examples!
if(a == 3 && b < 1) "If a is 3 and b is less than 1"
if(a == 3 || b < 1) "If a is 3 or b is less than 1"
if(a != 3 && !(b < 1)) "If a is not 3 and not-(b is less than 1)"

Assignment:
1. I want to click anywhere in my window and draw a circle perfectly around that point.
2. I want to draw a line from my point to my previous point.  How can you retain the previous x and y values after clicking?
3. I want to type "s" and "c" and have it switch between drawing a square and circle.  Still want the line though.
4. Add something cool to this code.
Another shape or color is cool.
A circle radius that changes size with each click is cool.
Text, titles, instructions is cool.
Can you think of anything else?
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrettyLines implements MouseListener, KeyListener {
	JFrame window = new JFrame("PrettyLines");
	JPanel pane;
	
	int x = 0; //global variables declared and initialized
	int y = 0;
	int r = 0;
	String shape = "circle";
	
	public static void main(String[] args) {
		PrettyLines program = new PrettyLines();	
	}
	
	public PrettyLines() {
		init();
	}

	public void init() {
		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				myPaint(g);
			}
		};
		pane.addMouseListener(this);
		pane.addKeyListener(this);
		pane.setFocusable(true);
		
		window.add(pane);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public void myPaint(Graphics g) {
		g.setColor(color.black);
		if(shape == "circle") {
			g.drawOval(x, y, r*2, r*2); //draw circle
			g.drawLine(0, 0, x, y);
		}
		//For part 3, add code here for square
	}

	public void mouseClicked(MouseEvent e) { //x and y update when you click the mouse somewhere
		x = e.getX();
		y = e.getY();
		pane.repaint();
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	public void keyTyped(KeyEvent e) { //shape updates when you type the correct letter
		if (e.getKeyChar() == 's') {
			shape = "square";
		}
		//For part 3, add code here for circle
		pane.repaint();
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
