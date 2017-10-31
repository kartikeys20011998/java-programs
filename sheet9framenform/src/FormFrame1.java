//at run time make the form and some buttons to do work on it
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class FormFrame1 extends Frame implements ActionListener{
	public static void main(String ar[])
	{
		new FormFrame1();
	}
	Label lb1=new Label("enter first number:"); //to give labels
	Label lb2=new Label("enter second number:");
	
	TextField t1=new TextField();//for writing any text in the labels
	TextField t2=new TextField();
	TextField t3=new TextField();
	
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
	Button showcheckboxbt=new Button("show checkbox");
	
	Label resultlb=new Label(""); //last label where result is abtained
	Label lb3=new Label("");
	FormFrame1(){
		setSize(400,400);
		setLayout(null);
		setLocation(10,10);
		t3.setEchoChar('+'); //this fields is used in field like in passwrd
		lb1.setBounds(30,30,150,20);
		t1.setBounds(200,30,150,20);
		lb2.setBounds(30,60,150,20);
		t2.setBounds(200,60,150,20);
		t3.setBounds(200,90,150,20);
		

		addchk.setBounds(30,90,150,20);
		subchk.setBounds(30,120,150,20);
		mulchk.setBounds(30,150,150,20);
		divchk.setBounds(30,180,150,20);
		
		showbt.setBounds(30,210,150,20);
		 showcheckboxbt.setBounds(200,210,150,20);
		 exitbt.setBounds(30,240,150,20);
		 resultlb.setBounds(30,280,150,20);
		 lb3.setBounds(30,310,150,30);
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
		 add(t3);
		 add(showbt);
		 add(exitbt);
		 add(resultlb);
		 add(showcheckboxbt);
		 t1.requestFocus(); //to focus or to show the blinking cursor
		 // on the desired txtbx
		 t3.addActionListener(this);
		 showbt.addActionListener(this);
		 showcheckboxbt.addActionListener(this);
		 exitbt.addActionListener(this);
		 setVisible(true);
	}
	public void actionPerformed(ActionEvent e){ //for the result button
		if(e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		if(e.getActionCommand().equals("show checkbox"))
		{
			if(chk.getState()==true)
			{
				lb3.setText("checkbox is true");
			}
			else 
				lb3.setText("checkbox is false");
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


		
	
			//if(e.getActionCommand().equals("exit")){} //we can nt exitfrm form 
			//directly
				
				
	
