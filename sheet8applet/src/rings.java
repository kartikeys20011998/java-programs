import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Line2D;
public class rings extends Applet{
	public void init(){
		Color c=new Color(100,230,250); //this gives its default 
		//color by its own combinations given by us
		this.setBackground(c); //this is fr bckground
	}
		public void paint(Graphics g) //this is the imp fn 
		{
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(10));
		
		g.setColor(Color.BLUE);
		g.drawOval(500,300,120,120 );
		
		g.setColor(Color.BLACK);
		g.drawOval(650,300,120,120 );
		g.setColor(Color.RED);
		g.drawOval(800,300,120,120 );
		g.setColor(Color.YELLOW);
		g.drawOval(575,350,120,120 );
		g.setColor(Color.GREEN);
		g.drawOval(730,350,120,120 );
		g.setColor(Color.BLUE);
		g.drawArc(500, 300, 120, 120, 0, 60);
		g.setColor(Color.BLACK);
		g.drawArc(650, 300, 120, 120, 100, 80);
	}
	}


