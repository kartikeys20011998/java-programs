
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

class search extends JFrame implements ActionListener,ItemListener  {
	public static search myselfsearch=null;
	/*
	public static void main(String[] args) {
		new search();

}
	*/
	
	Connection con=null;//interface to conect with data
	Statement st=null;//interface to execute queries on table
	ResultSet rs=null;//interface to read data from table
	

String[] cols={"NAME","ADDRESS","MOB","VEHINO","INDATE","OUTDATE","STATUS"};
DefaultTableModel model=new DefaultTableModel(cols,0);
JTable table=new JTable(model);
	
	
	String name="";
	String add="";
	long mob;
	String vno="";
    String indate="";
    String outdate="";
    String status="";
	
	JLabel lb1=new JLabel("SEARCHING FORM");
	JLabel lb2=new JLabel("Search on Name Basis:");
	JLabel lb3=new JLabel("Search on MobileNo. Basis:");
	JLabel lb4=new JLabel("Search on VehicleNo. Basis:");
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JButton bt2=new JButton("SEARCH_1");
	JButton bt3=new JButton("SEARCH_2");
	JButton bt4=new JButton("SEARCH_3");
	JButton bt5=new JButton("BACK");
	//public static employee_form myselfemployee_form=null;

	
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
	
	
	public search()
    {
    	
    	setSize(700,700);
    	setLocation(10,10);
    	setLayout(null);

    	lb1.setBounds(20,20,150,20);
    	lb2.setBounds(20,60,180,30);
    	t2.setBounds(20,100,180,20);	
    	bt2.setBounds(20,160,180,20);
    	
    	lb3.setBounds(200,60,180,30);
    	t3.setBounds(220,100,180,20);
    	bt3.setBounds(220,160,180,20);
    	
    	
    	lb4.setBounds(380,60,180,30);
    	t4.setBounds(420,100,180,20);
    	bt4.setBounds(420,160,180,20);
    	bt5.setBounds(220,540,180,20);
    	
	
add(lb1);
add(lb2);
add(t2);
add(bt2);
add(lb3);
add(t3);
add(bt3);
add(lb4);
add(t4);
add(bt4);
add(bt5);

bt2.addActionListener(this);
bt3.addActionListener(this);
bt4.addActionListener(this);
bt5.addActionListener(this);



JScrollPane scrollPane=new JScrollPane(table);
	 scrollPane.setBounds(5,220,500,280);
	 scrollPane.setBackground(Color.CYAN);
	 scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	add(scrollPane);
	
/*
	
	try
		{
			openConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from details");
		
			if(rs.next())
			{
				do
				{
					name=rs.getString("name");
					add=rs.getString("address");
					mob=rs.getInt("mobileno");
					vno=rs.getString("vehicleno");
					indate=rs.getString("indate");
					outdate=rs.getString("outdate");
					status=rs.getString("status");
					Object[] row={name,add,mob,vno,indate,outdate,status};
					model.addRow(row);
			
				}while(rs.next());
			}
			closeConnection();
		}
		catch(Exception ee)
		{
	}
		
*/

setVisible(true);

    
	}
	 public void actionPerformed(ActionEvent e){
		 
		 if(e.getActionCommand().equals("SEARCH_1"))
		 {
		
	   	
	   	
 	
 			int a=table.getRowCount();
 			for(int i=0;i<a;i++)
 			{
 				model.removeRow(0);
 			}
 			name=(t2.getText().toUpperCase().trim());
	   		try
	 		{
	 			openConnection();
	 			st=con.createStatement();
	 			rs=st.executeQuery("select * from details where name='"+name+"'");
	 		
	 			 System.out.println(""+name);
	 			if(rs.next())
	 			{
 				do
	 				{
	 					
	 					name=rs.getString("name");
	 					add=rs.getString("address");
	 			
	 					mob=rs.getLong("mobileno");
	 					
	 					vno=rs.getString("vehicleno");
	 					indate=rs.getString("indate");
	 					outdate=rs.getString("outdate");
	 					status=rs.getString("status");
	 					
	 				
	 				
	 					
	 				
		 					Object[] row={name,add,mob,vno,indate,outdate,status};
	 					model.addRow(row);
			
	 				}while(rs.next());
	 			}
	 		
	 			closeConnection();
	 		}
	 		catch(Exception ee)
	 		{
	 			 System.out.println("mmm"+ee.getMessage());
	 		}
				 
		 }
		 if(e.getActionCommand().equals("SEARCH_2"))
		 {

 			int a=table.getRowCount();
 			for(int i=0;i<a;i++)
 			{
 				model.removeRow(0);
 			}
 			mob=Long.parseLong(t3.getText().trim());
	   		try
	 		{
	 			openConnection();
	 			st=con.createStatement();
	 			rs=st.executeQuery("select * from details where mobileno="+mob+"");
	 		
	 		if(rs.next())
	 			{
 				do
	 				{
	 					
	 					name=rs.getString("name");
	 					add=rs.getString("address");
	 			
	 					mob=rs.getLong("mobileno");
	 					
	 					vno=rs.getString("vehicleno");
	 					indate=rs.getString("indate");
	 					outdate=rs.getString("outdate");
	 					status=rs.getString("status");
	 					
	 				
	 				
	 					
	 				
		 					Object[] row={name,add,mob,vno,indate,outdate,status};
	 					model.addRow(row);
			
	 				}while(rs.next());
	 			}
	 		
	 			closeConnection();
	 		}
	 		catch(Exception ee)
	 		{
	 			 System.out.println("mmm"+ee.getMessage());
	 		}
				 
		 }
		 if(e.getActionCommand().equals("SEARCH_3"))
		 {

 			int a=table.getRowCount();
 			for(int i=0;i<a;i++)
 			{
 				model.removeRow(0);
 			}
 			vno=(t4.getText().toUpperCase().trim());
	   		try
	 		{
	 			openConnection();
	 			st=con.createStatement();
	 			rs=st.executeQuery("select * from details where vehicleno='"+vno+"'");
	 		
	 		if(rs.next())
	 			{
 				do
	 				{
	 					
	 					name=rs.getString("name");
	 					add=rs.getString("address");
	 			
	 					mob=rs.getLong("mobileno");
	 					
	 					vno=rs.getString("vehicleno");
	 					indate=rs.getString("indate");
	 					outdate=rs.getString("outdate");
	 					status=rs.getString("status");
	 					
	 				
	 				
	 					
	 				
		 					Object[] row={name,add,mob,vno,indate,outdate,status};
	 					model.addRow(row);
			
	 				}while(rs.next());
	 			}
	 		
	 			closeConnection();
	 		}
	 		catch(Exception ee)
	 		{
	 			 System.out.println("mmm"+ee.getMessage());
	 		}
				 
		 }
		 if(e.getActionCommand().equals("BACK"))
		 {
			 search.myselfsearch.dispose();
			 Main_Form.myselfMain_Form.setVisible(true);
		 }

	 }
	
public void itemStateChanged(ItemEvent ie){
	repaint();
		
	}
	
	
}
	
