/*
 * INSTRUCTIONS:
 * We're going to learn how to make a program draw a picture today.
 * To do so, we're going to look at and edit the area just after the line public void myPaint(Graphics g).
 * The rest of the code will help it run, and you'll learn another piece with each new assignment.
 * For today, don't worry about anything except what's inside the curly brackets after public void myPaint(Graphics g).
 *
 * Read Tutorial 2a.
 * Copy-paste this code into an Eclipse class named Picture.
 * Read Tutorial 2b.
 * Try the assignment below.
 * Don't open Tutorial 2c until you've tried this assignment and want to check your answers.
 * 
 * Try to run this code as it is.  Errors?  What kind of error?  What line is the error?  Can you figure out how to debug it?
 * Okay, now it's time to experiment.  I'm not going to tell you what each line of the code in myPaint does, but I'm going to teach you how to figure it out yourself.
 * We're going to add new lines and delete existing lines of code.  That's how we figure out what each piece does.
 * Feel free to experiment beyond what this guide says once you get the hang of it.
 * 
 * Run the code.  Delete the line that says g.drawRect and re-run it.  What does g.drawRect do?
 * Add g.drawRect(10, 20, 30, 40) back in.  Now, replace g.drawRect with g.fillRect.  What's the difference between drawRect and fillRect?
 * What about g.drawOval and g.fillOval?  What do they do?
 * Try replacing a g.drawOval with g.drawLine.  What does that do?  Is there a g.fillLine?
 * Add 100 to the first number in g.drawRect.  What happens to the picture?
 * Add 100 to each of the other numbers in g.drawRect and run it after each one changes.  What does each number mean?
 * Set the first two numbers to 0 and 0.  What corner is the origin in g.drawRect?
 * Set g.drawOval and g.drawRect to the same four numbers.  What is the relationship between a rectangle and an oval with the same coordinates?
 * What do you suppose g.setColor does, based on the name?  Try changing what's inside the parentheses.  Were you right?  If you delete the line, what is the default color?
 * Instead of g.setColor(Color.black); instead, type g.setColor(c);    What is c?  What line tells the computer what c is?
 * Try initializing c to different colors.  What colors work?  Can you find a color that doesn't work?
 * Try setting the color to green and then on the very next line of code, setting the color to black.  Then fill an oval.  Which color wins?
 * Now set the color to black, then to green, then fill an oval.  Does order matter in programming?
 * Try drawing an oval that overlaps with a different color rectangle, which overlaps with a different color line.  Which has to be written first?
 * What happens if you remove the // before g.drawString?  What does // do?
 * Change what's in the quotes for g.drawString.  What happens?
 * Add 100 to the numbers in g.drawString.  What do the numbers mean?
 * What if you start g.drawString and g.drawRect at the same coordinates?  What corner is the origin for g.drawString?
 * Does the text change color like rectangles and ovals?
 * Try changing g.drawRect to g.drawrect.  Do capitals matter in programming?  If you put two spaces instead of one somewhere, does that matter?  Or an extra blank line?
 * 
 * HOMEWORK:
 * Read Tutorial 2c if you haven't already.
 * Draw me a picture.  It should use at least one draw and at least one fill statement, two or more colors, and text in the form of g.drawString.
 */

import javax.swing.*;
import java.awt.*;

public class Picture {
	JFrame window = new JFrame();
	JPanel pane;
	
	public static void main(String [] args) {
		new Picture();
	}
	
	public Picture() {
		preInit();
		init();
	}
	
	public void preInit() {
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
	
	public void init() {}

	public void myPaint(Graphics g) {
		Color c = Color.yellow;
		g.setColor(Color.red);
		g.drawRect(10, 20, 30, 40);
		g.setColor(Color.blue)
		g.drawOval(115, 225, 300, 40);
		g.setColor(Color.black);
		g.fillRect(25, 35, 30, 40);

		// g.drawString("Hello, world!", 80, 5);
	}
}
