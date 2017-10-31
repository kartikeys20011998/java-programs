import java.applet.Applet;
import java.awt.*; //abstract window toolkit
/*
 * <applet code='FirtApplet' width='400' height='400'>
 * <\applet>
 */

public class DrawApplet extends Applet{
	public void init(){
		Color c=new Color(123,200,100); //this gives its default 
		//color by its own combinations given by us
		this.setBackground(c); //this is fr bckground
	}
	//called whenevr window needs to b repainted 
	public void paint(Graphics g) //this is the imp fn 
	{
		g.setColor(Color.GREEN); //to pik up the color in memory
		g.fillRect(30 ,30,100,100);//x,y,w,h //to fill the shape
		
		g.setColor(Color.RED);
		g.drawRect(30 ,30,100,100);//draw only boundary
		g.drawLine(40,40,200,200); //x1,y1,x2,y2
		g.setColor(Color.BLUE);
		g.drawString("hello",100,100); //string,x,y //to write the text
		g.fillOval(200,200,100,150);
		g.setColor(Color.BLACK);
		g.drawOval(200,200,100,150 );
		int[]x={300,350,325,300};//this is used to declare the polygon of 
		//any of the sides
		int[]y={300,300,275,300};
		//to draw triangle we have to declare arrays for x and y
		g.setColor(Color.RED);
		g.fillPolygon(x,y,4);
		//x-array ,y-array,number of points
		g.setColor(Color.GREEN);
		g.drawPolygon(x,y,4);//x-array,y-array,numberof points
		g.drawArc(300, 300, 100, 100, 0, -90); //rectangle coordinates,
		//startangle .endangle //(centr coordinates x,y ;width and 
		//lenght;angle that is started frm 0;angle to which arc is drwn)
		g.drawArc(200, 200, 50, 50, 0, 100); //rectangle coordinates,
		//startangle .endangle
		
		
		
		
		}
		
		
}
