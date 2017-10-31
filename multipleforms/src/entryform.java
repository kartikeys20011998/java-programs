import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class entryform extends JFrame implements ActionListener,ItemListener {
	public static entryform myselfentryform;
	public static void main(String[] args) {
		myselfentryform=new entryform();
	}
	Connection con=null;//interface to conect with data
	Statement st=null;//interface to execute queries on table
	//ResultSet rs=null;//interface to read data from table
	String txt=null;
	
	JLabel lb1=new JLabel("ENTRY FORM");
	JLabel lb2=new JLabel("Enter name:");
	JLabel lb3=new JLabel("Enter Salary:");
	JLabel lb4=new JLabel("Select date:");
	JLabel lb5=new JLabel("Select Gender:");
	JLabel lb6=new JLabel("Your id is:");
	JLabel lb7=new JLabel("");
	
	JTextField t1=new JTextField();//for writing any text in the labels
	JTextField t2=new JTextField();
	JComboBox comboyear=new JComboBox();
	JComboBox combomonth=new JComboBox();
	JComboBox combo28=new JComboBox();
	JComboBox combo29=new JComboBox();
	JComboBox combo30=new JComboBox();
	JComboBox combo31=new JComboBox();
	JComboBox combogender=new JComboBox();
	
	ButtonGroup group =new ButtonGroup();
	
	
	
	JButton addbt=new JButton("Add");
	JButton searchbt=new JButton("Search");
	JButton updatebt=new JButton("Update");
	JButton deletebt=new JButton("Delete");
	JButton exitbt=new JButton("Exit");
	String name="";
		int id=0;
		double salary=0;
		String sex="FEMALE";
		String dob="";
		int y=1950,m=1,d=1,f=0;
		
	void openConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			}
			catch (ClassNotFoundException e){
				System.out.println("Invalid Driver" +e.getMessage());
				System.exit(0);
				
			}
			catch (SQLException e){
				System.out.println("Invalid Dsn" +e.getMessage());
				System.exit(0);
				
				
			}	
	}
	void closeConnection()
	{
		try{
			con.close();
			}
			catch(SQLException e){
				}
	}
	
	public entryform()
	{

		setSize(900,600);
		setLocation(10,10);
		setLayout(null);
		comboyear.setBounds(200, 90, 80, 20);
		combomonth.setBounds(300, 90, 60, 20);
		combo28.setBounds(380, 90, 50, 20);
		combo29.setBounds(380, 90, 50, 20);
		combo30.setBounds(380, 90, 50, 20);
		combo31.setBounds(380, 90, 50, 20);
		
		combogender.setBounds(200,120,150,20);
		
		for(int i=1950;i<=2050;i++)
			comboyear.addItem(""+i);
		for(int i=1;i<=12;i++)
			combomonth.addItem(""+i);
		for(int i=1;i<=28;i++)
			combo28.addItem(""+i);
		for(int i=1;i<=29;i++)
			combo29.addItem(""+i);
		for(int i=1;i<=30;i++)
			combo30.addItem(""+i);
		for(int i=1;i<=31;i++)
			combo31.addItem(""+i);
		
		
		
		combogender.addItem("FEMALE");
		combogender.addItem("MALE");
		combogender.addItem("TRANSGENDER");
		comboyear.setSelectedIndex(0);
		combomonth.setSelectedIndex(0);
		combo28.setSelectedIndex(0);
		combo29.setSelectedIndex(0);
		combo30.setSelectedIndex(0);
		combo31.setSelectedIndex(0);
		combogender.setSelectedIndex(0);
		

		
		lb1.setBounds(375,20,150,30);
		
		t1.setBounds(200,30,150,20);
		lb2.setBounds(30,30,150,20);
	
		t2.setBounds(200,60,150,20);
		lb3.setBounds(30,60,150,20);
		
		lb4.setBounds(30,90,150,20);
		
		
		
		lb5.setBounds(30,120,150,20);
		lb6.setBounds(30,150,120,20);
		lb7.setBounds(170,150,90,20);
		
		addbt.setBounds(30,210,150,20);
		searchbt.setBounds(200,210,150,20);
		updatebt.setBounds(370,210,150,20);
		deletebt.setBounds(540,210,150,20);
		exitbt.setBounds(30,250,150,20);
		
		

		 add(lb1);
		 add(t1);
		 add(lb2);
		 add(t2);
		 add(lb3);
		 add(comboyear);
		 add(combomonth);
		 add(combo28);
		 add(combo29);
		 add(combo30);
		 add(combo31);
		 add(combogender);
		 add(lb4);
		 add(lb5);
		 add(lb6);
		 add(lb7);
		 add(addbt);
		 add(searchbt);
		 add(updatebt);
		 add(deletebt);
		 add(exitbt);
		 t1.requestFocus();
		 
		 
		 
		 
		 addbt.addActionListener(this);
		 searchbt.addActionListener(this);
		 updatebt.addActionListener(this);
		 deletebt.addActionListener(this);
		 exitbt.addActionListener(this);
		 
		 comboyear.addItemListener(this);
		 combomonth.addItemListener(this);
		 combo28.addItemListener(this);
		 combo29.addItemListener(this);
		 combo30.addItemListener(this);
		 combo31.addItemListener(this);
		 combogender.addItemListener(this);
		 combo28.setVisible(false);
		 combo29.setVisible(false);
		 combo30.setVisible(false);
		 combo31.setVisible(true);
		 
		 setVisible(true);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public void actionPerformed(ActionEvent e){
		
		if(e.getActionCommand().equals("Add"))
		{
			name=t1.getText().toUpperCase().trim();
			salary=Double.parseDouble(t2.getText().trim());
			try
			{
				openConnection();
			st=con.createStatement();
			String qry="insert into emp values(0,'"+name+"','"+dob+"',"+salary+",'"+sex+"')";
			//System.out.print(qry);//to print qry on screen
			st.executeUpdate(qry); //for insert,update,delete
			closeConnection();
			}
			catch(Exception ee)
			{
				System.out.println("bbb"+ee.getMessage());
			}
		}
		if(e.getActionCommand().equals("Search"))
		{
			if(searchform.myselfsearchform==null)
			{
			searchform.myselfsearchform=new searchform();
			searchform.myselfsearchform.setVisible(true);
			myselfentryform.setVisible(false);
			}
			
		}
		if(e.getActionCommand().equals("Update"))
		{
			
				updateform.myselfupdateform=new updateform();
				updateform.myselfupdateform.setVisible(true);
				myselfentryform.setVisible(false);
		}
		if(e.getActionCommand().equals("Delete"))
		{
			if(deleteform.myselfdeleteform==null)
			{
			deleteform.myselfdeleteform=new deleteform();
			deleteform.myselfdeleteform.setVisible(true);
			myselfentryform.setVisible(false);
			}
			
		}
		if(e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
	}
	public void itemStateChanged(ItemEvent ie){
		y=Integer.parseInt(comboyear.getSelectedItem().toString());
		m=Integer.parseInt(combomonth.getSelectedItem().toString());
		sex=combogender.getSelectedItem().toString();
		if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
			
		{
			combo28.setVisible(false);
			 combo29.setVisible(false);
			 combo30.setVisible(false);
			 combo31.setVisible(true);
			 d=Integer.parseInt(combo31.getSelectedItem().toString());
		}
		else
			if (m==4||m==6||m==9||m==11)
		{
				combo28.setVisible(false);
				 combo29.setVisible(false);
				 combo31.setVisible(false);
				 combo30.setVisible(true);
				 d=Integer.parseInt(combo30.getSelectedItem().toString());
		}
			else
				if (m==2&&y%100==0&&y%400==0||y%100!=0&&y%4==0)
			{
					combo28.setVisible(false);
					 combo30.setVisible(false);
					 combo31.setVisible(false);
					 combo29.setVisible(true);
					 d=Integer.parseInt(combo29.getSelectedItem().toString());
			}
				else
					if (m==2)
				{
						combo29.setVisible(false);
						 combo30.setVisible(false);
						 combo31.setVisible(false);
						 combo28.setVisible(true);
						 d=Integer.parseInt(combo28.getSelectedItem().toString());
				}
		dob=y+"-"+m+"-"+d;
		System.out.println(dob+sex);
		repaint();


	}


	}



