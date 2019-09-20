/*INSTRUCTIONS:
We're going to look at and edit the area called public void myPaint(Graphics g).  Don't worry about the rest.
Download and save this code as picture.java.
If you've never used command prompt, look at Tutorial 2a.
Don't open Tutorial 2b until you've tried this assignment and want to check your answers.
Compile and run this code.  Figure out how to debug it.
Delete the line that says g.drawRect, compile, and re-run it.  What does g.drawRect do?
What about g.drawOval, g.fillOval, and g.fillRect?  Suppose there's a g.drawLine?  g.fillLine?
Add 100 to the first number in g.drawRect.  What happens to the picture?  What if that first number is 0?  What if the second number is 0?
What do the first two numbers in g.drawRect indicate?  The second two?
What corner is the origin in g.drawRect?
What corner is the origin in g.drawOval?  You have to imagine the oval is inscribed in a rectangle.
How does your picture change if you switch the g.drawRect and g.fillRect lines?  Does order matter?
Instead of g.setColor(Color.black); instead, type g.setColor(c);    What line do you think tells the computer what c is?
Try initializing c to different colors.  What colors work?  Can you find a color that doesn't work?
What happens if you remove the // before g.drawString?
What if you start g.drawString and g.drawRect at the same coordinates?  What corner is the origin for g.drawString?

HOMEWORK:
Draw me a picture.  It should use at least one draw and at least one fill statement, two or more colors, and text.
*/
import javax.swing.*;
import java.awt.*;

public class Picture {
	JFrame window = new JFrame("Picture");
	JPanel pane;
	
	public static void main(String [] args) {
		Picture pic = new Picture();
	}
	
	public Picture() {
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
		window.add(pane);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public void myPaint(Graphics g) {
		Color c = Color.yellow;
		g.setColor(Color.red);
		g.drawRect(10, 20, 30, 40);
		g.setColor(Color.blue)
		g.drawOval(115, 225, 300, 40);
		g.setColor(Color.black);
		g.fillRect(25, 35, 30, 40);

		//g.drawString("Hello, world!", 80, 5);
	}
}
