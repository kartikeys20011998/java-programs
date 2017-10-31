//make frames at run times and add some buttons on form to do work
//we can run this frames from gel directly

//import java.applet.*;
import java.awt.*;
import javax.swing.*;//import  to call events
import java.awt.event.*;//import  to call events
//Swing->java foundation classes
//we can use swing class in form also
//public class Swingform extends JApplets implements ActionListener{
//rest is same
public class SwingFrame extends JFrame implements ActionListener{
	
	public static void main(String ar[]) //in frames add main prog //constructor called
	{
		new SwingFrame();
	}
	//we have to write J before each class name
	JLabel lb1=new JLabel("enter first number:"); //to give labels
	JLabel lb2=new JLabel("enter second number:");
	JLabel lb3=new JLabel("");
	
	JTextField t1=new JTextField();//for writing any text in the labels
	JTextField t2=new JTextField();
	
	ButtonGroup group =new ButtonGroup();
	//for option buttons make it as group
	
	JRadioButton addchk=new JRadioButton("Addition",true);
	JRadioButton subchk=new JRadioButton("subtraction",false);
	JRadioButton mulchk=new JRadioButton("multiplication",false);
	JRadioButton divchk=new JRadioButton("division",false);


	//Checkbox chk=new Checkbox();
	JCheckBox chk=new JCheckBox("addition",true);//write here single check box
	JButton showbt=new JButton("Result"); //we can make a button here by this
	JButton exitbt=new JButton("Exit");
	
	
	JLabel resultlb=new JLabel(""); //last label where result is abtained
	
	public SwingFrame(){
		group.add(addchk);
		group.add(subchk);
		group.add(mulchk);
		group.add(divchk);
		
			setSize(400,400);
			setLocation(10,10);
			setLayout(null);
			
		lb1.setBounds(30,30,150,20);
	//	lb1.setBackground(Color.BLUE);
		t1.setBounds(200,30,150,20);
		lb2.setBounds(30,60,150,20);
	//	lb2.setBackground(Color.CYAN);
		t2.setBounds(200,60,150,20);
		lb3.setBounds(30,310,150,20);
	//	lb3.setBackground(Color.GREEN);
		
		addchk.setBounds(30,90,150,20);
		subchk.setBounds(30,120,150,20);
		mulchk.setBounds(30,150,150,20);
		divchk.setBounds(30,180,150,20);
		
		showbt.setBounds(30,210,150,20);
	//	showbt.setBackground(Color.BLACK);
	//	showbt.setForeground(Color.CYAN);
		
		 exitbt.setBounds(30,240,150,20);
	//	 exitbt.setBackground(Color.DARK_GRAY);
	//	 showbt.setForeground(Color.CYAN);
			
		 
		 resultlb.setBounds(30,280,150,20);
	//	 exitbt.setBackground(Color.DARK_GRAY);
	//	 showbt.setForeground(Color.CYAN);
		
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
		 
		 
		 setVisible(true);//set visibility of frame true by default fame 
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				if(addchk.isSelected())
					resultlb.setText(""+(x+y));
				else if(subchk.isSelected())
					resultlb.setText(""+(x-y));
				else if(mulchk.isSelected())
					resultlb.setText(""+(x*y));
				else if(divchk.isSelected()){
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
	
	
		