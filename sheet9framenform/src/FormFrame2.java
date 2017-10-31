//make frames at run times and add some buttons on form and do work
//we can run this frames from gel directly
//handling windows and mouse events
import java.applet.*;
import java.awt.*;
import java.awt.event.*;//import  to call events

public class FormFrame2 extends Frame implements ActionListener,WindowListener,MouseListener{
	//we add here WindowListener and MouseListener in this class
	public static void main(String ar[]) //in frames add main prog //constructor called
	{
		new FormFrame2();
	}
	Label lb1=new Label("enter first number:"); //to give labels
	Label lb2=new Label("enter second number:");
	Label lb3=new Label("");
	
	TextField t1=new TextField();//for writing any text in the labels
	TextField t2=new TextField();
	
	
	CheckboxGroup group=new CheckboxGroup(); //group is added to make radio buttons 
	//finally for option button make it as group
	Checkbox addchk=new Checkbox("Addition",false,group);//we cn also write true
	// here to put the selcted cusor on the desired radio button

	Checkbox subchk=new Checkbox("subtraction",false,group);
	Checkbox mulchk=new Checkbox("multiplication",false,group);
	Checkbox divchk=new Checkbox("division",false,group);
	//Checkbox chk=new Checkbox();
	Checkbox chk=new Checkbox("addition",true);//write here single check box
	Button showbt=new Button("Result"); //we can make a button here by this
	Button exitbt=new Button("Exit");
	
	
	Label resultlb=new Label(""); //last label where result is abtained
	
	public FormFrame2(){
		setSize(400,400);
		setLayout(null);
		setLocation(10,10);
		
		
		lb1.setBounds(30,30,150,20);
		lb1.setBackground(Color.CYAN);
		lb1.setForeground(Color.BLUE);
		t1.setBounds(200,30,150,20);
		lb2.setBounds(30,60,150,20);
		t2.setBounds(200,60,150,20);
		lb3.setBounds(30,310,150,20);
		
		addchk.setBounds(30,90,150,20);
		subchk.setBounds(30,120,150,20);
		mulchk.setBounds(30,150,150,20);
		divchk.setBounds(30,180,150,20);
		
		showbt.setBounds(30,210,150,20);
		
		 exitbt.setBounds(30,240,150,20);
		 exitbt.setBackground(Color.RED);
		 exitbt.setForeground(Color.CYAN);
		 resultlb.setBounds(30,280,150,20);
		
		 chk.setBounds(30,350,150,20);
		
		 add(lb1);
		 add(t1);
		 add(lb2);
		 add(t2);
		 add(lb3);
		 add(addchk);
		 add(subchk);
		 add(mulchk);
		 add(divchk);
		 add(chk);
		
		 add(showbt);
		 add(exitbt);
		 add(resultlb);
		
		 t1.requestFocus(); //to focus or to show the blinking cursor
		 // on the desired txtbx
		
		 showbt.addActionListener(this);
		
		 exitbt.addActionListener(this);
		 this.addWindowListener(this);
		 this.addMouseListener(this);
		 setVisible(true);//set visibility of frame true by default fame 
	}
	public void actionPerformed(ActionEvent e){ //for the result button
		if(e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		
		else 
		if(e.getActionCommand().equals("Result")){
			try{
				double x=Double.parseDouble(t1.getText());//to take the text 
				//frm the text box
				double y=Double.parseDouble(t2.getText());
				if(group.getSelectedCheckbox()==addchk)
					resultlb.setText(""+(x+y));
				else if(group.getSelectedCheckbox()==subchk)
					resultlb.setText(""+(x-y));
				else if(group.getSelectedCheckbox()==mulchk)
					resultlb.setText(""+(x*y));
				else if(group.getSelectedCheckbox()==divchk){
					if(y==0){
						resultlb.setText("denominator cannot be 0");
					
					}
					else{
						resultlb.setText(""+(x/y));
					}
				}
			}
			catch(Exception ex){
				resultlb.setText("error in input"); //this is fr showing on applet
				
			}
		}
	}
		//by this method we have to write all events of window
		public void windowOpened(WindowEvent e){
			this.setTitle("welcome");
			
		}
		public void windowClosing(WindowEvent e){
			System.exit(0);
			//by this when we click on window x then we can exit frm here 
			//rest of the events are not used
			
		}
		public void windowClosed(WindowEvent e){
			System.exit(0);
			//by this when we click on window x then we can exit frm here 
			//rest of the events are not used
			
		}
		public void windowIconified(WindowEvent e){
			this.setTitle("Iconified");
			
			
		}
		public void windowDeiconified(WindowEvent e){
			this.setTitle("Welcome   Deiconified");
	}
		public void windowActivated(WindowEvent e){
		//	this.setTitle("Activated");
}
		
		public void windowDeactivated(WindowEvent e){
		//	this.setTitle("Deactivated");
		}	

//above seven are window events
		//by this method we have to write all the events of mouse
		public void mouseClicked(MouseEvent e){ //frst butn of mouse
			if(e.getButton()==e.BUTTON1){
				String msg="Mouse clicked at:"+e.getX() +"," + e.getY();
				resultlb.setText(msg);
				//when mouse button frst is clicked any where on frame it 
				//will give its coordinates
				//on label
				//if we clicked on any object no coordinates are shown on label1
			}
			
				
			}
		public void mousePressed(MouseEvent e){
	setBackground(Color.BLUE);	
		}
public void mouseReleased(MouseEvent e){
	setBackground(Color.RED);	
		}
public void mouseEntered(MouseEvent e){
	setBackground(Color.YELLOW);	
}
public void mouseExited(MouseEvent e){
	setBackground(Color.GREEN);	
}
//there are five events of mouse clicking
		
		}
		
