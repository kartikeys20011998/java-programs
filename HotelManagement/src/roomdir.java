
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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class roomdir extends JFrame implements ActionListener,ItemListener 
{
	public static roomdir myselfroomdir=null;
	FileWriter fw=null;
	BufferedWriter bw=null;
/*
	public static void main(String[] args) {
		new roomdir();
	}
	*/
	Connection con=null;//interface to conect with data
	Statement st=null;//interface to execute queries on table
	ResultSet rs=null;//interface to read data from table
	String txt=null;
	////////////////

String[] cols={"ID","Cateogory","Beds","TotalRooms","PerDayCharges"};
DefaultTableModel model=new DefaultTableModel(cols,0);
JTable table=new JTable(model);

int tr=0,charges=0,id=0,occupied=0;
String troom="";
String tbed="";

////////

	
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	 
	
	
	 JButton listbt=new JButton("PrintList");
	 JButton backkbt=new JButton("BACK");
	 
	JLabel lb1=new JLabel(" NEW ENTRY FORM");
	JLabel lb2=new JLabel("Select the type of room:");
	JLabel lb3=new JLabel("Select the Beds needed:");
	JLabel lb4=new JLabel("Total number of room available:");
	JLabel lb5=new JLabel("Per day charges:");
	/////
	JLabel lb6=new JLabel("EDIT FORM");
	JLabel lb7=new JLabel("Select any room to Edit");
	JLabel lb8=new JLabel("Select any ID to Edit:");
	JLabel lb9=new JLabel("Select the type of room:");			
	JLabel lb10=new JLabel("Select thr beds needed:");
	JLabel lb11=new JLabel("Total number of room available:");
	JLabel lb12=new JLabel("Per day charges:");
	JLabel lb13=new JLabel("Occupied:");
	////////
	JLabel lb14=new JLabel("DELETE FORM");
    JLabel lb15=new JLabel("Select Id :");
	JLabel lb16=new JLabel("");
	JLabel lb17=new JLabel("");
	JLabel lb18=new JLabel("");
	JLabel lb19=new JLabel("");
	JLabel lb20=new JLabel("");
	
////////
 
	
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	
	JComboBox comboroom=new JComboBox();
	JComboBox combobed=new JComboBox();
	JComboBox comboroome=new JComboBox();
	JComboBox combobede=new JComboBox();
	JComboBox comboide=new JComboBox();
	JComboBox comidd=new JComboBox();

	
	ButtonGroup group =new ButtonGroup();
	JButton addbt=new JButton("ADD");
	JButton backbt=new JButton("BACK");
	////
	JButton showdetailsbt=new JButton("SHOW DETAILS");
	JButton showallbt=new JButton("SHOW ALL");
	JButton removeallbt=new JButton("REMOVE ALL");
	JButton updatebt=new JButton("UPDATE");
	/////
	JButton showalldatabt=new JButton("BACK");
	JButton showidbt=new JButton("SHOW DETAIL");
	JButton deletebt=new JButton("DELETE");
	///////
	
	JTextArea jta=new JTextArea();


 public roomdir ()
 
 {
	 setTitle("ROOM DIRECTORY FORM");
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
	 tabbedPane=new JTabbedPane();
	 tabbedPane.addTab("New Entry", panel1);
	 tabbedPane.addTab("Edit", panel2);
	 tabbedPane.addTab("Delete", panel3);
	 tabbedPane.addTab("Listing", panel4);
	 
	 //panel1.setVisible(true);
	//panel2.setVisible(true);
	//panel3.setVisible(true);
	//panel4.setVisible(true);
	 //in the outer panel add inner panel with all sub panels
	 topPanel.add(tabbedPane,BorderLayout.CENTER);
	 tabbedPane.setVisible(true);
	 
	
	 
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
		
 
 public void createPage1()
 {
	 panel1=new JPanel();
	 panel1.setLayout(null);

	
		comboroom.setBounds(250,30,150,20);
		combobed.setBounds(250,60,150,20);
		lb1.setBounds(390,3,150,30);
		t1.setBounds(250,90,150,20);
		lb2.setBounds(30,30,150,20);
        t2.setBounds(250,120,150,20);
		lb3.setBounds(30,60,150,20);
		lb4.setBounds(30,90,200,20);
		lb5.setBounds(30,120,150,20);
		addbt.setBounds(30,210,150,20);
		backbt.setBounds(200,210,150,20);
		
		
		comboroom.addItem("AC");
		comboroom.addItem("Non AC");
		comboroom.addItem("Delux");
		comboroom.addItem("Super Delux");
		comboroom.addItem("V.I.P");
		
		combobed.addItem("Single Bed");
		combobed.addItem("Double Bed");
		combobed.addItem("Family Suit");
		
		comboroom.addItemListener(this);
		combobed.addItemListener(this);
		comboroom.setSelectedIndex(0);
		combobed.setSelectedIndex(0);
	 
		
		
		addbt.addActionListener(this);
		backbt.addActionListener(this);
		panel1.add(addbt);
		panel1.add(backbt);
		panel1.add(lb1);
		panel1.add(lb2);
		panel1.add(lb3);
		panel1.add(lb4);
		panel1.add(lb5);
		panel1.add(comboroom);
		panel1.add(combobed);
		
		panel1.add(t1);
		panel1.add(t2);
		
		 t1.requestFocus();
		 //addbt.addActionListener(this);
		 //backbt.addActionListener(this);
			
			
	
	
 }
 
 public void createPage2()
 {
	 panel2=new JPanel();
	 panel2.setLayout(null);
	 lb6.setBounds(390,3,150,30);
		lb7.setBounds(30,30,150,40);
		///
		lb8.setBounds(10,400,150,20);
		lb9.setBounds(10,440,150,20);
		lb10.setBounds(10,480,150,20);
		lb11.setBounds(10,520,180,20);
		lb12.setBounds(10,560,150,20);
		lb13.setBounds(10,600,150,20);
		t3.setBounds(200,520,150,20);
		t4.setBounds(200,560,150,20);
		t5.setBounds(200,600,150,20);
		t5.setEditable(false);
		comboide.setBounds(200,400,150,20);
		comboroome.setBounds(200,440,150,20);
		combobede.setBounds(200,480,150,20);
		showdetailsbt.setBounds(450,400,150,30);
		showallbt.setBounds(600,110,150,20);
		removeallbt.setBounds(600,150,150,20);
		updatebt.setBounds(600,190,150,20);
		
		
		showallbt.addActionListener(this);
		showdetailsbt.addActionListener(this);
		updatebt.addActionListener(this);
		removeallbt.addActionListener(this);
		
		
		
		comboroome.addItem("AC");
		comboroome.addItem("Non AC");
		comboroome.addItem("Delux");
		comboroome.addItem("Super Delux");
		comboroome.addItem("V.I.P");
		
		combobede.addItem("Single Bed");
		combobede.addItem("Double Bed");
		combobede.addItem("Family Suit");
		
		
		comboroome.addItemListener(this);
		combobede.addItemListener(this);
		comboide.addItemListener(this);
		comboroome.setSelectedIndex(0);
		combobede.setSelectedIndex(0);

		
		
		panel2.add(showdetailsbt);
		panel2.add(showallbt);
		panel2.add(removeallbt);
		panel2.add(updatebt);
		panel2.add(lb6);
		panel2.add(lb7);
		panel2.add(lb7);
		panel2.add(lb8);
		panel2.add(lb9);
		panel2.add(lb10);
		panel2.add(lb11);
		panel2.add(lb12);
		panel2.add(lb13);
		panel2.add(comboroome);
		panel2.add(combobede);
		panel2.add(comboide);
		panel2.add(t3);
		panel2.add(t4);
		panel2.add(t5);
		
		
		
	///
		
		//table.setBackground(Color.green);
//		table.setGridColor(Color.MAGENTA);
		
		JScrollPane scrollPane=new JScrollPane(table);
		 scrollPane.setBounds(5,100,500,280);
		// scrollPane.setBackground(Color.CYAN);
		 scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		 scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel2.add(scrollPane);

		
		  try
	    	{
	    		openConnection();
	    		st=con.createStatement();
	    		rs=st.executeQuery("select * from room");
	    		if(rs.next())
	    		{
	    			do
	    			{
	    				
	    				id=rs.getInt("Id");
	    				comboide.addItem(""+id);
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
	    lb14.setBounds(290,20,100,20);
        lb15.setBounds(20,70,150,20);
        
        lb16.setBounds(20,110,200,20);
        lb17.setBounds(20,140,200,20);
        lb18.setBounds(20,180,200,20);
        lb19.setBounds(20,220,200,20);
        lb20.setBounds(20,260,200,20);
       
        
        comidd.setBounds(200,70,150,20);
        showalldatabt.setBounds(30,280,150,20);
    	showidbt.setBounds(200,280,150,20);
    	deletebt.setBounds(370,280,150,20);
	
    	panel3.add(lb14);
    	panel3.add(lb15);
        panel3.add(lb16);
    	panel3.add(lb17);
    	panel3.add(lb18);
    	panel3.add(lb19);
    	panel3.add(lb20);
    
        panel3.add(comidd);
        panel3.add(showalldatabt);
    	panel3.add(showidbt);
    	panel3.add(deletebt);
 	   try
	    	{
	    		openConnection();
	    		st=con.createStatement();
	    		rs=st.executeQuery("select * from room");
	    		if(rs.next())
	    		{
	    			do
	    			{
	    				
	    				id=rs.getInt("id");
	    				comidd.addItem(""+id);
	    			}while(rs.next());
	    		}
	    		closeConnection();
	    	}
	    	catch(Exception ee){
   }
    	comidd.addItemListener(this);
        showalldatabt.addActionListener(this);
    	showidbt.addActionListener(this);
    	deletebt.addActionListener(this);  
    	deletebt.setVisible(false);
        setVisible(true);
 }
	 
	 public void createPage4()
	 {
		 panel4=new JPanel();
		 panel4.setLayout(null);
		 listbt.setBounds(10,120,150,20);
		 backkbt.setBounds(10,150,150,20);
		 panel4.add(listbt);
		 panel4.add(backkbt);
		 listbt.addActionListener(this);
		 backkbt.addActionListener(this);
 
}
	 
	 public void actionPerformed(ActionEvent e){
		 if(e.getActionCommand().equals("BACK"))
		 {
			 roomdir.myselfroomdir.dispose();
			 Main_Form.myselfMain_Form.setVisible(true);
			// System.exit(0);
		 }
			
		 
		 
		 if(e.getActionCommand().equals("PrintList"))
			{
			 try
			 {
			 		 fw=new FileWriter("list.txt",false);
			 		 bw=new BufferedWriter(fw);
			 		bw.write(String.format("%4s %-2s %-15s %-20s %4s %4s %12s %n","ID","  ","Cat.Of Room","Type Of Bed","Tot.","Occ.","Rate"));
			 		bw.write(String.format("%70s %n","____________________________________________________________________"));
		 			 
			 		 openConnection();
			 		 st=con.createStatement();
			 		 rs=st.executeQuery("select * from room");
			 		 if(rs.next())
			 		 {
			 			 do
			 			 {
			 				id=rs.getInt("id");
		 					troom=rs.getString("catofroom");
		 					tbed=rs.getString("bed");
		 					tr=rs.getInt("totalrooms");
		 					charges=rs.getInt("charges"); 
		 					occupied=rs.getInt("occupied");
		 					bw.write(String.format("%4s %-2s %-15s %-20s %4s %4s %12s %n",id,". ",troom,tbed,tr,occupied,charges));
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
		 if(e.getActionCommand().equals("ADD"))
			{
			int f=1; 
			try{
			 tr=Integer.parseInt(t1.getText().trim());
			 charges=Integer.parseInt(t2.getText().trim());
			 troom=comboroom.getSelectedItem().toString().trim();
			 tbed=combobed.getSelectedItem().toString();
			}
			catch(Exception ee)
			{
				f=0;
				System.out.println("Entered data is not appropriate"+ee.getMessage());
			}
			if(f==1)
			{
				System.out.println(troom+"  "+tbed);
			
				try
				{
					openConnection();
				st=con.createStatement();
				String qry="insert into room values(0,'"+troom+"','"+tbed+"',"+tr+",0,"+charges+")";
				//System.out.print(qry);//to print qry on screen
				st.executeUpdate(qry); //for insert,update,delete
				System.out.println(troom+"  "+tbed);
				closeConnection();
				}
				catch(Exception ee)
				{
					System.out.println("Entered data is not appropriate"+ee.getMessage());
				}
				   comboide.removeAllItems();
				   comidd.removeAllItems();
	    		   try
	   	    	{
	   	    		openConnection();
	   	    		st=con.createStatement();
	   	    		rs=st.executeQuery("select * from room");
	   	    		if(rs.next())
	   	    		{
	   	    			do
	   	    			{
	   	    				
	   	    				id=rs.getInt("id");
	   	    				comboide.addItem(""+id);
	   	    				comidd.addItem(""+id);
	   	    			}while(rs.next());
	   	    		}
	   	    		closeConnection();
	   	    	}
	   	    	catch(Exception ee){
	        }
	 	
			}
			}
	 	if(e.getActionCommand().equals("SHOW ALL"))
	 	{
	     
	 		
	 		int c=table.getRowCount();
	 		for(int i=0;i<c;i++)
	 		{
	 		model.removeRow(0);
	 	    }
	 	
	 		try
	 		{
	 			openConnection();
	 			st=con.createStatement();
	 			rs=st.executeQuery("select * from room");
	 			if(rs.next())
	 			{
	 				do
	 				{
	 					id=rs.getInt("id");
	 					troom=rs.getString("catofroom");
	 					tbed=rs.getString("bed");
	 					tr=rs.getInt("totalrooms");
	 					charges=rs.getInt("charges");
	
	 					Object[] row={id,troom,tbed,tr,charges};
	 					model.addRow(row);
	 			
	 				}while(rs.next());
	 			}
	 			closeConnection();
	 		}
	 		catch(Exception ee)
	 		{
	 	}
	 		
	 	}
	 	
	 	
	 		if(e.getActionCommand().equals("REMOVE ALL"))
	 		{
	 			int a=table.getRowCount();
	 			for(int i=0;i<a;i++)
	 			{
	 				model.removeRow(0);
	 			}
	 			jta.setText("");
	 			t3.setText("");
	 			t4.setText("");
	 			t5.setText("");
	 	
	 		}
	
	 	
	 	
	 	//////////////
	 	
	 	
		 if(e.getActionCommand().equals("UPDATE"))
      	 {
			 id=Integer.parseInt(comboide.getSelectedItem().toString());
			 tr=Integer.parseInt(t3.getText().trim());
			 charges=Integer.parseInt(t4.getText().trim());
			 troom=comboroome.getSelectedItem().toString().trim();
			 tbed=combobede.getSelectedItem().toString();
			 occupied=Integer.parseInt(t5.getText());
			 int f=0;
			 if(tr>=occupied)
			 {
				 f=1;
			 }
			 if(f==1)
			 {
			 try
			 {
				 openConnection();
					st=con.createStatement();
					String qry="update room set catofroom='"+troom+"',bed='"+tbed+"', totalrooms="+tr+", charges="+charges+" where id="+id+"";
					st.executeUpdate(qry);
	
					closeConnection();
			 }
			catch(Exception ee)
			 {
			System.out.println("ee"+ee.getMessage()); 
			 }
			//	txt=(String)com1.getSelectedItem();
			//	lb4.setText(txt);
			
				int a=table.getRowCount();
	 			for(int i=0;i<a;i++)
	 			{
	 				model.removeRow(0);
	 			}
			 }
			 else
					System.out.println("Total Rooms Must Be Greater Then Occupied Rooms");  
      	 }
    
	      if(e.getActionCommand().equals("BACK"))
	    		{
	    	  roomdir.myselfroomdir.dispose();
				 Main_Form.myselfMain_Form.setVisible(true);
	    		//	deleteform.myselfdeleteform.dispose();
	    		//	entryform.myselfentryform.setVisible(true);	
	    		}
	       
	    	   if(e.getActionCommand().equals("DELETE"))
	        	 {
	    		   try
	    		   {
	    			openConnection();
					st=con.createStatement();
					
					st.executeUpdate("delete from room where id="+id+" and occupied=0");
					closeConnection();
					st=null;
	    		   }
	    		   catch(Exception ee)
	   			{
	   		} 
	    		  // comId.removeAll();
	    		   comidd.removeAllItems();
	    		   try
	   	    	{
	   	    		openConnection();
	   	    		st=con.createStatement();
	   	    		rs=st.executeQuery("select * from room");
	   	    		if(rs.next())
	   	    		{
	   	    			do
	   	    			{
	   	    				
	   	    				id=rs.getInt("id");
	   	    				comidd.addItem(""+id);
	   	    			}while(rs.next());
	   	    		}
	   	    		closeConnection();
	   	    	}
	   	    	catch(Exception ee){
	        }
	    		   lb16.setText("");
					lb17.setText("");
					lb18.setText("");
					lb19.setText("");
					lb20.setText("");
					 
	        	 }
	    	   ////delete form
	      	 if(e.getActionCommand().equals("SHOW DETAIL"))
	      	 {
	      		try
				{	id=Integer.parseInt(comidd.getSelectedItem().toString());
					openConnection();
					st=con.createStatement();
					rs=st.executeQuery("select * from room where id="+id+"");
					if(rs.next())
					{
						
						id=rs.getInt("id");
	 					troom=rs.getString("catofroom");
	 					tbed=rs.getString("bed");
	 					tr=rs.getInt("totalrooms");
	 					charges=rs.getInt("charges");
	 					occupied=rs.getInt("occupied");
							lb16.setText("Type of room     :"+troom);
							lb17.setText("Beds needed      :"+tbed);
							lb18.setText("Number of rooms  :"+tr);
							lb19.setText("Per day charges  :"+charges);
							lb20.setText("Occupied         :"+occupied);
						if(occupied>0)
						{
							deletebt.setVisible(false);
						}
						else
						{
							deletebt.setVisible(true);
						}
				
					}
					closeConnection();
					st=null;
				}
				catch(Exception ee)
				{
			} 
	      	 }
	       ///////////////edit form
		 if(e.getActionCommand().equals("SHOW DETAILS"))
      	 {
		
      		try
			{	id=Integer.parseInt(comboide.getSelectedItem().toString());
				openConnection();
				st=con.createStatement();
				rs=st.executeQuery("select * from room where id="+id+"");
				if(rs.next())
				{
				id=rs.getInt("id");
 					troom=rs.getString("catofroom");
 					tbed=rs.getString("bed");
 					tr=rs.getInt("totalrooms");
 					charges=rs.getInt("charges");
 					occupied=rs.getInt("occupied");
						
						 }
	combobede.setSelectedItem(tbed);
	comboroome.setSelectedItem(troom);
						t3.setText(""+tr);
						t4.setText(""+charges);
						t5.setText(""+occupied);
					
						
				
				closeConnection();
				st=null;
			}
			catch(Exception ee)
			{
		} 
      	 }


	 			if(e.getActionCommand().equals("BACK"))
	 			{
	 				roomdir.myselfroomdir.dispose();
	 				 Main_Form.myselfMain_Form.setVisible(true);
	 			//System.exit(0);	
	 			}
	 		}
		public void itemStateChanged(ItemEvent ie){
			
		}
}		
	 		


				
		 
		 

		 

