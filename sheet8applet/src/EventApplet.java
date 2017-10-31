import java.applet.Applet; //inbuilt Applet class whch packages use 
import java.awt.*;
import java.awt.event.*;//import to call events
/*
 <applet code='EventApplet' width='400' height='400'>
  <\applet>
 */
public class EventApplet extends Applet implements ActionListener{ //to clck d btton
	//n then wat to wrk next 
	Button redbt=new Button("red");
	Button greenbt=new Button("green");
	Button bluebt=new Button("blue");
	public void init(){
		//setLayout(new BorderLayout.NORTH);
		//add(redbt,BorderLayout.NORTH);
		//add(greenbt,BorderLayout.EAST);
		//add(bluebt,BorderLayout.SOUTH);
		//setLayout(new FlowLayout());//it will make three command buttons on top
		//setLayout(new GridLayout(1,3)); //row column
		add(redbt);//add is used for every type of layout
		add(greenbt);
		add(bluebt); // objcts drwn are added to the applet
		setLayout(null); //row,column
		redbt.setBounds(20, 20, 80, 20);
		greenbt.setBounds(20, 80, 80, 20);
		bluebt.setBounds(20, 120, 80, 20);
    redbt.addActionListener(this);
    //tell which object to use to call action performed
    bluebt.addActionListener(this);
    greenbt.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){ //all the actions v need to pefrmed
		//after button being clicked
		if(e.getActionCommand().equals("red")){
			setBackground(Color.RED);
		}
		
			else if(e.getActionCommand().equals("green")){
				setBackground(Color.GREEN);
			}
				else if(e.getActionCommand().equals("blue")){
					setBackground(Color.BLUE);
		}
	}


    
		
		
		
		
	}
