import java.applet.*;
import java.awt.*;

public class picture extends Applet {

	public void init() {}

	public void paint(Graphics g) {
		Color c = Color.yellow;
		
		g.setColor(Color.black);
		g.drawOval(150,175,10,10);
		g.fillOval(150,175,10,10);
		g.drawOval(200,175,10,10);
		g.fillOval(200,175,10,10);
		g.setColor(Color.blue);
		g.drawOval(125,125,100,100);
		g.drawLine(175,225,175,350);
		g.drawLine(175,350,125,400);		
		g.drawLine(175,350,225,400);	
		g.setColor(Color.green);
		g.drawLine(0,450,100,400);
		g.drawLine(75,450,100,400);
		g.drawLine(75,450,175,400);
		g.drawLine(150,450,175,400);
		g.drawLine(150,450,250,400);
		g.drawLine(225,450,250,400);
		g.drawLine(225,450,325,400);
		g.drawLine(300,450,325,400);
		g.drawLine(300,450,400,400);
		g.drawLine(375,450,400,400);
		g.setColor(Color.red);

		g.drawString("Hi, I'm nobody. Who are you? Are you a nobody too?", 80, 80);
	}
}
/*<applet code="picture" width=600 height=600>
</applet>*/
//dir, debugging, applet, new methods, quitting, order, comments, variable dec/init, failed colors, spaces and syntax
