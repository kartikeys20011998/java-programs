//to display image
import java.applet.Applet;  
import java.awt.*;
/*
 * <applet code='EventApplet' width='400' height='400'>
 * <\applet>
 */
public class ImageApplet extends Applet{
	Image img;
	
	//getDocumentBase() get the location of html file
//getCodeBase() get loacation of the class file
	public void init(){
		//img=getImage(getDocument.Base(),"yy.jpg");
		//img=getImage(getCodeBase(),"yy.jpg");
		img=getImage(getDocumentBase(),"yy.jpg");
//image must be in current base directory
		//bmp not supported
		
	}
	
	public  void paint (Graphics g){
		g.drawImage(img,40,40,200,200,this);
	}

}
