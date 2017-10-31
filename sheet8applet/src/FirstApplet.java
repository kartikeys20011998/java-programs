//applets runs on internet
//testing applet life cycle
//we can also run applets on appletviewer tool provided with java 
//to compile at dos promt
//c:\yk130907\gui\javac FirstApplet.java
import java.applet.Applet; //inbuilt Applet class whch packages use 
import java.awt.*;//to draw on internet explorer import this file 
//and use this method   public void paint(Graphics g){
//g.drawString(""+a,100,50);
/*
 * <applet code='FirtApplet' width='400' height='400'>
 * <\applet>
 */
public class FirstApplet extends Applet{
	int a=10;
	//for life cycle methods
	public void init(){ //compulsary function for memory for applet
		System.out.println("init");
	}
	public void start(){
		System.out.println(","+a);
		System.out.println("start");
		
	}
	public void stop(){
		System.out.println("stop");
		
	}
	public void destroy(){
		System.out.println("destroy");
		
	}
	public void paint (Graphics g){
		g.drawString(""+a, 100, 50);
	}

	

	}


