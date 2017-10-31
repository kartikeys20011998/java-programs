//make frames at run times and add some buttons on form and do work
//we can run this frames from gel directly
//using inner class to handle window events as well as mouse events 
//now we use two class as inner class
import java.applet.*;
import java.awt.*;
import java.awt.event.*;//import  to call events

public class FormFrame3 extends Frame{
	
	public static void main(String ar[]) //in frames add main prog //constructor called
	{
		new FormFrame3();
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
	
	public FormFrame3(){
		setSize(400,400);
		setLayout(null);
		setLocation(10,10);
		
		
		lb1.setBounds(30,30,150,20);
		lb1.setBackground(Color.BLUE);
		t1.setBounds(200,30,150,20);
		lb2.setBounds(30,60,150,20);
		lb2.setBackground(Color.CYAN);
		t2.setBounds(200,60,150,20);
		lb3.setBounds(30,310,150,20);
		lb3.setBackground(Color.GREEN);
		
		addchk.setBounds(30,90,150,20);
		subchk.setBounds(30,120,150,20);
		mulchk.setBounds(30,150,150,20);
		divchk.setBounds(30,180,150,20);
		
		showbt.setBounds(30,210,150,20);
		showbt.setBackground(Color.BLACK);
		showbt.setForeground(Color.CYAN);
		
		 exitbt.setBounds(30,240,150,20);
		 exitbt.setBackground(Color.DARK_GRAY);
		 showbt.setForeground(Color.CYAN);
			
		 
		 resultlb.setBounds(30,280,150,20);
		 exitbt.setBackground(Color.DARK_GRAY);
		 showbt.setForeground(Color.CYAN);
		
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
		
		 showbt.addActionListener(new HandleButton());//use this pointer in the same 
		 //block to
		
		 exitbt.addActionListener(new HandleButton());
		 //object is made so that it passes to it directly
		 this.addWindowListener(new HandleWindow());
		 this.addMouseListener(new HandleMouse());
		 setVisible(true);//set visibility of frame true by default fame 
	}
	//inner class first
	class HandleButton implements ActionListener{
		//we made a class here for using only 1 or more commnds of window n mouse listener
		//rather then whole at a time
	
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
	}
		//here is second inner class
	class HandleWindow extends WindowAdapter{ //it is a class whch is extended n 
		//evry fn is nt abstracted here thats y we can use only one at a time  
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
		public void windowOpened(WindowEvent e){
			setTitle("welcome");
			
		}
	}
	//hre is the third class
	class HandleMouse extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getButton()==e.BUTTON1){
				String msg="Mouse clicked at:"+e.getX() +"," + e.getY();
				resultlb.setText(msg);
		}
	}
		public void mousePressed(MouseEvent e){
			setBackground(Color.BLUE);	
				}
	}
	
	}
			