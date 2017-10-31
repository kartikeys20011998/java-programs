//at run time make the form and some buttons to do work on it
//it will run on dos prompt
//using swing in running applets at dos prompt or in interenet explorer
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingFormApplet extends JApplet implements ActionListener{
	Label lb1=new Label("enter first number:"); //to give labels
	Label lb2=new Label("enter second number:");
	
	JTextField t1=new JTextField();//for writing any text in the labels
	JTextField t2=new JTextField();
	
	ButtonGroup group=new ButtonGroup(); 
	
	
	//finally for option button make it as group
	JRadioButton addchk=new JRadioButton("Addition",true);
	JRadioButton subchk=new JRadioButton("subtraction",false);
	JRadioButton mulchk=new JRadioButton("multiplication",false);
	JRadioButton divchk=new JRadioButton("division",false);
	//Checkbox chk=new Checkbox();
		JCheckBox chk=new JCheckBox("addition",true);//write here single check box
		JButton showbt=new JButton("Result"); //we can make a button here by this
		JButton exitbt=new JButton("Exit");
		
		
		JLabel resultlb=new JLabel(""); //last label where result is abtained

	public void init(){
		setLayout(null);
		group.add(addchk);
		group.add(subchk);
		group.add(mulchk);
		group.add(divchk);
		
		
		lb1.setBounds(30,30,150,20);
		t1.setBounds(200,30,150,20);
		lb2.setBounds(30,60,150,20);
		t2.setBounds(200,60,150,20);
		

		addchk.setBounds(30,90,150,20);
		subchk.setBounds(30,120,150,20);
		mulchk.setBounds(30,150,150,20);
		divchk.setBounds(30,180,150,20);
		
		showbt.setBounds(30,210,150,20);
		
		 exitbt.setBounds(30,240,150,20);
		 resultlb.setBounds(30,280,150,20);
		 
		 chk.setBounds(30,350,150,20);
		
		 add(lb1);
		 add(t1);
		 add(lb2);
		 add(t2);
		 
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
	
	
		