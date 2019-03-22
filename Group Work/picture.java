import java.applet.*;
import java.awt.*;

public class picture extends Applet {

	public void init() {}

	public void paint(Graphics g) {
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
/*<applet code="picture" width=300 height=300>
</applet>*/
//dir, debugging, applet, new methods, quitting, order, comments, variable dec/init, failed colors, spaces and syntax
