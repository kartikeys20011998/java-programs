import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class snack extends JFrame implements ActionListener,ItemListener {
	JLabel lb1=new JLabel("SNACK POINT");
	JLabel lb2=new JLabel("120 Rs");
	JLabel lb3=new JLabel("60 Rs");
	JLabel lb4=new JLabel("40 Rs");
	JLabel lb5=new JLabel("30 Rs");
	JLabel lb6=new JLabel("Enter Quantity");
	JLabel lb7=new JLabel("You did your payment by credit card");
	JLabel lb8=new JLabel("You did your payement through cash");
	JLabel lb9=new JLabel("THANK YOU");
	
	JTextField t1=new JTextField();//for writing any text in the labels
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();//for writing any text in the labels
	JTextField t4=new JTextField();
	JCheckBox chk1=new JCheckBox("PIZZA");
	JCheckBox chk2=new JCheckBox("BURGER");
	JCheckBox chk3=new JCheckBox("SPRING ROLL");
	JCheckBox chk4=new JCheckBox("DRY MANCHURIAN");
 
	

	ButtonGroup group =new ButtonGroup();
	
	JButton totalamountbt=new JButton("Total Amount");
	JButton submitbt=new JButton("Submit");
	JButton exitbt=new JButton("Exit");
	public snack(){

		setSize(800,600);
		setLocation(10,10);
		setLayout(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void actionPerformed(ActionEvent e){
		
		int tq;
			if(e.getActionCommand().equals("Total Amount"))
			{
				try{
					int x=Integer.parseInt(t1.getText())
							
			}
	
	}

}
