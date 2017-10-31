import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Main_Form extends JFrame implements ActionListener{
public static Main_Form myselfMain_Form=null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Main_Form.myselfMain_Form=new Main_Form();
	}
	Connection con=null;//interface to conect with data
	Statement st=null;//interface to execute queries on table
	ResultSet rs=null;//interface to read data from table
	
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
	JLabel lb1=new JLabel("User Id");
	JLabel lb2=new JLabel("Password");
	JLabel lb3=new JLabel("Designation");
	
	JTextField t1=new JTextField();
//	JTextField t2=new JTextField();
	JPasswordField t2=new JPasswordField();
	JTextField t3=new JTextField();
	
	JButton okbt=new JButton("OK");
	JButton exitbt=new JButton("EXIT");
	JButton checkinbt=new JButton("CHECK IN");
	JButton checkoutbt=new JButton("CHECK OUT");
	JButton roombt=new JButton("ROOM ENTRY");
	JButton searchbt=new JButton("SEARCHING");
	JButton newempbt=new JButton("NEW EMPLOYEE");
	 public Main_Form()
	    {
	    	
	    	setSize(700,700);
	    	setLocation(10,10);
	    	setLayout(null);

	    	lb1.setBounds(20,20,100,20);
	    	lb2.setBounds(20,60,100,20);
	    	lb3.setBounds(20,100,100,20);
	    	t1.setBounds(140,20,100,20);
	    	t2.setBounds(140,60,100,20);
	    	t3.setBounds(140,100,100,20);
	        t2.setEchoChar('*');
	        t2.addActionListener(this);	
	    	okbt.setBounds(200,150,100,20);
	    	exitbt.setBounds(200,200,100,20);
	     	checkinbt.setBounds(350,150,100,20);
	    	checkoutbt.setBounds(350,200,100,20);
	    	roombt.setBounds(350,150,150,20);
	    	newempbt.setBounds(350,100,150,20);
	    	searchbt.setBounds(350,200,150,20);
	    	add(lb1);
	    	add(lb2);
	    	add(lb3);
	    	add(t3);
	    	add(t1);
	    	add(t2);
	    	add(okbt);
	    	add(exitbt);
	    	add(checkinbt);
	    	add(checkoutbt);
	    	add(roombt);
	    	add(searchbt);
	    	add(newempbt);
	    	  
	    	okbt.addActionListener(this);
	    	exitbt.addActionListener(this);
	    	checkinbt.addActionListener(this);
	    	checkoutbt.addActionListener(this);
	    	roombt.addActionListener(this);
	    	searchbt.addActionListener(this);
	    	newempbt.addActionListener(this);
	    	 checkinbt.setVisible(false);
		       
	    	 
	    	    checkoutbt.setVisible(false);
		        roombt.setVisible(false);
		        searchbt.setVisible(false);
		        newempbt.setVisible(false);
	        setVisible(true);
	       
	    }
	 public void actionPerformed(ActionEvent e){
			
		 if(e.getActionCommand().equals("EXIT"))
			{
			 System.exit(0);
			}
		 if(e.getActionCommand().equals("OK"))
			{
			 String uid=t1.getText().trim();
			 char []aa=t2.getPassword();//to collect values in char array
			 String pw=new String(aa);//to convert into string
			 String desig=t3.getText().toUpperCase().trim();
			
			 try
		    	{
		    		openConnection();
		    		st=con.createStatement();
		    		rs=st.executeQuery("select * from empdet where desig='"+desig+"' and  uid='"+uid+"' and  pwd='"+pw+"' and status='Y'");
		    		if(rs.next())
		    		{
		    			
		    			 if(desig.equals("MANAGER"))
		    			 {
		    				 
		    			           roombt.setVisible(false);
		    			           searchbt.setVisible(false);
		    					   checkinbt.setVisible(true);
		    					   checkoutbt.setVisible(true);
		    			 }	
		    			 if(desig.equals("ADMINISTRATOR"))
		    			 {
		    				     checkinbt.setVisible(false);
		    			         checkoutbt.setVisible(false);
		    					 roombt.setVisible(true);
		    					 searchbt.setVisible(true);
		    					 newempbt.setVisible(true);
		    			 }
		    			
		    		}
		    		closeConnection();
		    	}
		    	catch(Exception ee){
		    	}
			}
			 if(e.getActionCommand().equals("ROOM ENTRY"))
			 {
				 if(roomdir.myselfroomdir==null)
				 {
					 roomdir.myselfroomdir=new roomdir();
					 roomdir.myselfroomdir.setVisible(true);
					 Main_Form.myselfMain_Form.setVisible(false);
				 }
				 else
				 {
					 roomdir.myselfroomdir.setVisible(true);
					 Main_Form.myselfMain_Form.setVisible(false); 
				 }
			 }
			 if(e.getActionCommand().equals("SEARCHING"))
			 {
				 
				 if(search.myselfsearch==null)
				 {
					 search.myselfsearch=new search();
					 search.myselfsearch.setVisible(true);
					 Main_Form.myselfMain_Form.setVisible(false);
				 }
				 else
				 {
					 search.myselfsearch.setVisible(true);
					 Main_Form.myselfMain_Form.setVisible(false); 
				 }
			
			 }
			if(e.getActionCommand().equals("NEW EMPLOYEE"))
			{
				if(employee_form.myselfemployee_form==null)
				{
					employee_form.myselfemployee_form=new employee_form();
					employee_form.myselfemployee_form.setVisible(true);
					 Main_Form.myselfMain_Form.setVisible(false);
					
				}
				else
				{
					employee_form.myselfemployee_form.setVisible(true);
					 Main_Form.myselfMain_Form.setVisible(false); 	
				}
			}
				
		 if(e.getActionCommand().equals("CHECK OUT"))
			{
		 
			 if(checkout.myselfcheckout==null)
			 {
				 checkout.myselfcheckout=new checkout();
				 checkout.myselfcheckout.setVisible(true);
				 Main_Form.myselfMain_Form.setVisible(false);
			 }
			 else
			 {
				 checkout.myselfcheckout.setVisible(true);
				 Main_Form.myselfMain_Form.setVisible(false); 
			 }
			 
		 } 
		 
		 if(e.getActionCommand().equals("CHECK IN"))
			{
		 
			 if(customer1.myselfcustomer1==null)
			 {
				 customer1.myselfcustomer1=new customer1();
				 customer1.myselfcustomer1.setVisible(true);
				 Main_Form.myselfMain_Form.setVisible(false);
			 }
			 else
			 {
				 customer1.myselfcustomer1.setVisible(true);
				 Main_Form.myselfMain_Form.setVisible(false); 
			 }
			 
		 } 
	 }

	 }

