import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class employee_form extends JFrame implements ActionListener,ItemListener 
{
	public static employee_form myselfemployee_form=null;
	public static void main(String[] args) {
		new employee_form();
	}
	Connection con=null;//interface to conect with data
	Statement st=null;//interface to execute queries on table
	ResultSet rs=null;
	//Statement st1=null;//
	
	
	String name="";
	String deg="";
	String sel="";
	
	int id;
	String uid="";
	String pwd="";
	
	String uid1=""; //for new uid/pwd
	String pwd1="";
	
	String  i; //comboid
	
	
	
	
	
	
	
	private JTabbedPane tabbedpane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	
	//panel1
	JLabel lb1= new JLabel("NEW ENTRY FORM");
	JLabel lb2=new JLabel("Name of the employee:");
	JLabel lb3=new JLabel("Designation:");
	JLabel lb4=new JLabel("Select:");
	
	//panel2
	JLabel lb5= new JLabel("EDIT  UID/PASSWORD");
	JLabel lb6= new JLabel("Select id to change user id and password:");
	JLabel lb7= new JLabel("Current Uid/pwd");
	JLabel lb8= new JLabel("New Uid/pwd");
	
	//panel3
	JLabel lb9= new JLabel("DELETE  UID/PASSWORD");
	JLabel lb10= new JLabel("Select id to delete user id and password:");
	JLabel lb11= new JLabel("Current Uid/pwd");
	JLabel lb12= new JLabel("Current Uid/pwd");
	JLabel lb13= new JLabel("Current Uid/pwd");
	
	
	
	
	
	//panel1
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	
	//panel2
	JTextField t7=new JTextField();
	JTextField t71=new JTextField();
	JTextField t8=new JTextField();
	JTextField t81=new JTextField();
	
	//panel3
	JTextField t11=new JTextField();
	JTextField t111=new JTextField();
	
	
	
	//panel1
	JButton addbt=new JButton("ADD");
	JButton backbt=new JButton("BACK");
	//panel2
	JButton okbt=new JButton("OK");
	JButton updatebt=new JButton("UPDATE");
    JButton backkbt=new JButton("BACK");
    //panel3
    JButton okkbt=new JButton("OK");
	JButton deletebt=new JButton("DELETE");
    JButton backkkbt=new JButton("BACK");
    //panel4
   JButton showbt=new JButton("PRINT LIST");
   JButton backkkkbt=new JButton("BACK");
   
    
	
	
	JComboBox comboselect=new JComboBox();
	JComboBox comboid=new JComboBox(); //for edit
	JComboBox comboid1=new JComboBox(); //for delelete
	
	
	
	
	//public static void main(String[] args) {
	//	new employee_form();
//	}
	
	public employee_form ()
	 
	 {
		 setTitle("Employee Form");
		 setSize(1000,700);
		 setLocation(50,10);
		 setBackground(Color.BLUE);
		 setResizable(false);
		 //setLayout(null);
		 JPanel topPanel=new JPanel();//it is outer panel
		 //in inner panel add all panel with tab captions
		 topPanel.setLayout(new BorderLayout());
		 getContentPane().add(topPanel);
		 createPage1();
		 createPage2();
		 createPage3();
		 createPage4();
		 tabbedpane=new JTabbedPane();
		 tabbedpane.addTab("Add", panel1);
		 tabbedpane.addTab("Edit", panel2);
		 tabbedpane.addTab("Delete", panel3);
		 tabbedpane.addTab("List", panel4);
	
		 topPanel.add(tabbedpane,BorderLayout.CENTER);
		 tabbedpane.setVisible(true);
		 
		
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setVisible(true);
	 }
	
	void openConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hmanage","root","");
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
		
 
	
	public void createPage1(){
		panel1=new JPanel();
		panel1.setLayout(null);
		 
		lb1.setBounds(390,3,150,30);
		lb2.setBounds(30,30,150,20);
        t2.setBounds(200,30,150,20);
		lb3.setBounds(30,60,150,20);
		t3.setBounds(200,60,150,20);
		lb4.setBounds(30,90,150,20);
		comboselect.setBounds(200,90,150,20);
		addbt.setBounds(30,210,150,20);
		backbt.setBounds(200,210,150,20);
		
		
		comboselect.addItem("Allot uid/pw");
		comboselect.addItem("No uid/pw");
		comboselect.addItemListener(this);
	    comboselect.setSelectedIndex(0);
		addbt.addActionListener(this);
		backbt.addActionListener(this);
		
		panel1.add(addbt);
		panel1.add(backbt);
		panel1.add(lb1);
		panel1.add(lb2);
		panel1.add(lb3);
		panel1.add(lb4);
		panel1.add(comboselect);
	    panel1.add(t2);
		panel1.add(t3);
		t2.requestFocus();
		
	}
	public void createPage2()
	 {
		     panel2=new JPanel();
		     panel2.setLayout(null);
		     lb5.setBounds(390,2,150,30);
			 lb6.setBounds(10,30,250,20);
			 comboid.setBounds(280,30,150,20);
			 lb7.setBounds(10,80,150,20);
			 t7.setBounds(180,80,150,20);
			 t71.setBounds(350,80,150,20);
		     lb8.setBounds(10,120,150,20);
		     t8.setBounds(180,120,150,20);
			 t81.setBounds(350,120,150,20);
			
			okbt.setBounds(10,170,90,20);
			updatebt.setBounds(180,170,90,20);
			backkbt.setBounds(350,170,90,20);
			comboid.addItemListener(this);
			//comboid.setSelectedIndex(0);
			   // comboid.setSelectedIndex(0);
				okbt.addActionListener(this);
				updatebt.addActionListener(this);
				backkbt.addActionListener(this);
				
				panel2.add(okbt);
				panel2.add(backkbt);
				panel2.add(updatebt);
				panel2.add(lb5);
				panel2.add(lb6);
				panel2.add(lb7);
				panel2.add(lb8);
				panel2.add(comboid);
			    panel2.add(t7);
			    panel2.add(t71);
			    panel2.add(t8);
			    panel2.add(t81);
				
			    t7.requestFocus();
			    setVisible(true);
			    
				  try
			    	{
			    		openConnection();
			    		st=con.createStatement();
			    		rs=st.executeQuery("select * from empdet where NOT(uid)='"+uid+"' AND NOT(pwd)='"+pwd+"' and (status)='y'");
			    			
			    		if(rs.next())
			    		{
			    			do
			    			{
			    				
			    				
			    				id=rs.getInt("id");
			    				comboid.addItem(""+id);
			    			}while(rs.next());
			    		}
			    		closeConnection();
			    	}
			    	catch(Exception ee){
		   }
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
		 }

	public void createPage3()
	 {
		 panel3=new JPanel();
		 panel3.setLayout(null);
		 lb9.setBounds(390,2,150,30);
		 lb10.setBounds(10,30,250,20);
		 comboid1.setBounds(280,30,150,20);
		 lb11.setBounds(10,80,150,20);
		 t11.setBounds(180,80,150,20);
		 t111.setBounds(350,80,150,20);
		 okkbt.setBounds(10,170,90,20);
			deletebt.setBounds(180,170,90,20);
			backkkbt.setBounds(350,170,90,20);
			comboid1.addItemListener(this);
			
				okkbt.addActionListener(this);
				deletebt.addActionListener(this);
				backkkbt.addActionListener(this);
				
				panel3.add(okkbt);
				panel3.add(backkkbt);
				panel3.add(deletebt);
				panel3.add(lb9);
				panel3.add(lb10);
				panel3.add(lb11);
				
				panel3.add(comboid1);
			    panel3.add(t11);
			    panel3.add(t111);
			
				
			    t11.requestFocus();
			    setVisible(true);
			    
			    
			    try
		    	{
		    		openConnection();
		    		st=con.createStatement();
		    		rs=st.executeQuery("select * from empdet where NOT(uid)='"+uid+"' AND NOT(pwd)='"+pwd+"' and (status)='y'");
		    		if(rs.next())
		    		{
		    			do
		    			{
		    				
		    				
		    				id=rs.getInt("id");
		    				comboid1.addItem(""+id);
		    			}while(rs.next());
		    		}
		    		closeConnection();
		    	}
		    	catch(Exception ee){
	   }
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
	 }
		 
	 
	public void createPage4()
	 {
		 panel4=new JPanel();
		 panel4.setLayout(null);
		 
		 showbt.setBounds(390,3,150,30);
		 showbt.addActionListener(this);
		 backkkkbt.setBounds(30,60,150,20);
		 panel4.add(showbt);
		 panel4.add(backkkkbt);
	 }
	 public void actionPerformed(ActionEvent e){
		 
	 if(e.getActionCommand().equals("PRINT LIST"))
			{
			 FileWriter fw=null;
 			BufferedWriter bw=null;
 			try
  			 {
  			 		 fw=new FileWriter("list.txt",false);
  			 		 bw=new BufferedWriter(fw);
  			 	 bw.write("*************List Of Employees************** ");
			 		 bw.newLine();
			 	 bw.newLine();
  			 }
 			catch(Exception ee)
			{
				
			
				System.out.println(ee.getMessage());
			}
 			try
			{
				openConnection();
				st=con.createStatement();
				rs=st.executeQuery("select * from empdet where status='Y' order by name");
				if(rs.next())
				{
					do
					{
						bw.write("Name Of Employee :"+rs.getString("name"));
		    			bw.newLine();
		    			bw.newLine();
		    			bw.write("Designation      :"+rs.getString("desig"));
		    			bw.newLine();
		    			bw.newLine();
		    		//	bw.write("Status           :"+rs.getLong("status"));
		    		//	bw.newLine();
		    		//	bw.newLine();	
					}while(rs.next());
				}
				bw.close();
    			fw.close();
    			ProcessBuilder pb=new ProcessBuilder("Notepad.exe","list.txt");
    			pb.start();	
				
			}
 			catch(Exception ee)
			{
				
			
				System.out.println(ee.getMessage());
			}
			
			}
		
		 /*
		 	 if(e.getActionCommand().equals("PRINT LIST"))
			{
			 try
			 {
				 FileWriter fw=null;
		 			BufferedWriter bw=null;
	
				 fw=new FileWriter("list.txt",false);
			 		 bw=new BufferedWriter(fw);
			 		bw.write(String.format("%4s %-2s %-15s %n","NAME","  ","DESIGNATION"));
			 		bw.write(String.format("%70s %n","____________________________________________________________________"));
		 			 
			 		 openConnection();
			 		 st=con.createStatement();
			 		 rs=st.executeQuery("select * from details");
			 		 if(rs.next())
			 		 {
			 			 do
			 			 {
			 				
		 					name=rs.getString("name");
		 					designation=rs.getString("desig");
		 					
		 					bw.write(String.format("%4s %-2s %-15s ,%n".",name,designation));
			 			 }while(rs.next());
			 		 }
			 		 closeConnection();
			 		 bw.close();
			 		 fw.close();
			 		ProcessBuilder pb=new ProcessBuilder("Notepad.exe","list.txt");
	    			pb.start();
			 	}
			 catch(Exception ee)
			 {
				 
			 }
			 
			 
			}
			*/
		  
	 
		 if(e.getActionCommand().equals("ADD"))
			{
			int f=1; 
			try{
				name=(t2.getText().toString().toUpperCase().trim());
				deg=(t3.getText().toString().toUpperCase().trim());
				sel=(comboselect.getSelectedItem().toString().trim());	
			
			}
			catch(Exception ee)
			{
				f=0;
				System.out.println("Entered data is not appropriate"+ee.getMessage());
			}
			
			
				try
				{
					openConnection();
				st=con.createStatement();
				String qry="insert into empdet values(0,'"+name+"','"+deg+"','N','N','Y')";
			
				st.executeUpdate(qry); 
				st=null;
				if(sel.equals("Allot uid/pw"))
				{
				st=con.createStatement();
				rs=st.executeQuery("select * from empdet order by id desc limit 1");
				if(rs.next())
				{
				int id=rs.getInt("id");
				String uid="uid"+id;
				String pw="pwd"+id;
				st=null;
				st=con.createStatement();
				String qry1="update empdet set uid='"+uid+"',pwd='"+pw+"' where id="+id+"";
				st.executeUpdate(qry1);
				}
				}	
				
				closeConnection();
				}
				catch(Exception ee)
				{
					System.out.println("Entered data is not appropriate"+ee.getMessage());
				}
			}
		 if(e.getActionCommand().equals("OK")) //edit valaa ok
		 {
		
			 i=comboid.getSelectedItem().toString();
			 try
			 {
				 openConnection();
					st=con.createStatement();
					rs=st.executeQuery("select * from empdet where id="+i+"");
					if(rs.next())
					{
						id=rs.getInt("id");
	 					uid=rs.getString("uid");
	 					pwd=rs.getString("pwd");
						
	 					
	 					
					} 
					comboid.setSelectedItem(i);
					t7.setText(""+uid);
					t71.setText(""+pwd);	
			 
					closeConnection();
					st=null;
				}
				catch(Exception ee)
				{
		      }
			}

		 if(e.getActionCommand().equals("UPDATE"))
			{
			 i=comboid.getSelectedItem().toString();
			 uid1=t8.getText().trim();
			 pwd1=t81.getText().trim();
			 try
			 {
				 openConnection();
					st=con.createStatement();
					String qry="update empdet set uid='"+uid1+"', pwd='"+pwd1+"'where id="+i+"";
					st.executeUpdate(qry);
					
					uid1="";
					pwd="";
					closeConnection();
				
			 }
			 catch(Exception ee)
			 {
			System.out.println("ee"+ee.getMessage()); 
			 }
			 t7.setText("");
			 t71.setText("");
			 t8.setText("");
			 t81.setText("");
		 }
		 if(e.getActionCommand().equals("DELETE"))
		 {
			 i=comboid1.getSelectedItem().toString();
			 uid=t11.getText().trim();
			 pwd=t111.getText().trim();
			 try
			 {
				 openConnection();
					st=con.createStatement();
					String qry="update empdet set uid='N', pwd='N',status='N' where id="+i+"";
					st.executeUpdate(qry);
					
					closeConnection();
			 }
			 catch(Exception ee)
			 {
			System.out.println("ee"+ee.getMessage()); 
			 }
			 t11.setText("");
			 t111.setText("");
		 }
		 
		 //////////////////for delete tab
		 
		 if(e.getActionCommand().equals("OK")) //DELETE valaa ok
		 {
		
			 i=comboid1.getSelectedItem().toString();
			 try
			 {
				 openConnection();
					st=con.createStatement();
					rs=st.executeQuery("select * from empdet where id="+i+"");
					if(rs.next())
					{
						name=rs.getString("name");
						deg=rs.getString("desig");
						id=rs.getInt("id");
	 					uid=rs.getString("uid");
	 					pwd=rs.getString("pwd");
						
	 					
	 					
					}
					comboid1.setSelectedItem(i);
					t11.setText(""+uid);
					t111.setText(""+pwd);	
			 
					closeConnection();
					st=null;
				}
				catch(Exception ee)
				{
		      }
			}
		 if(e.getActionCommand().equals("BACK"))
		 {
			 employee_form.myselfemployee_form.dispose();
			 Main_Form.myselfMain_Form.setVisible(true);
		 }

			 
		 }
		  
	public void itemStateChanged(ItemEvent ie){
		
	}
}
