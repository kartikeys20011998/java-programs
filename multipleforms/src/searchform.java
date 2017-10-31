import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table;
public class searchform extends JFrame implements ActionListener,ItemListener
{
	public static searchform myselfsearchform=null;
	//FileReader fr=null;
//	BufferedReader br=null;
	FileWriter fw=null;
	BufferedWriter bw=null;

/*
	public static void main(String []arr)
	{
		new searchform();
	}	
*/
Connection con=null;
Statement st=null;
ResultSet rs=null;

String[] cols={"name","dob","id","sex","salary"};
DefaultTableModel model=new DefaultTableModel(cols,0);
JTable table=new JTable(model);
String name="";
String dob="";
int id=0;
String sex="";
int d=1,m=1,y=1950;
double salary=0;

JLabel lb=new JLabel("SEARCH FORM");

JComboBox comId=new JComboBox();
JLabel lb1=new JLabel("Select Id :");

JButton showalldatabt=new JButton("SHOW ALL DATA");
JButton showidbt=new JButton("SHOW ID");
JButton removeallbt=new JButton("REMOVE ALL");
JButton backbt=new JButton("BACK");
JTextArea jta=new JTextArea();
void openConnection()
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
	}
	catch(ClassNotFoundException e)
	{
		System.out.println("Invalid driver"+e.getMessage());
		System.exit(0);
	}
	catch (SQLException e)
	{
        System.out.println("Invalid dsn"+e.getMessage());
		System.exit(0);	
	}
}
void closeConnection()
{
	try{
	
		con.close();
	}
	catch(Exception e)
	{
	
	}
}

public searchform()
{
	setSize(700,600);
	setLocation(100,100);
	setLayout(null);
	
	lb.setBounds(290,20,100,20);
	lb1.setBounds(20,70,150,20); 
	
	comId.setBounds(200,70,150,20);
	showalldatabt.setBounds(30,360,150,20);
	showidbt.setBounds(200,360,150,20);
	removeallbt.setBounds(370,360,150,20);
	backbt.setBounds(30,400,150,20);
	
	//table.setBackground(Color.green);
//	table.setGridColor(Color.MAGENTA);
	JScrollPane scrollPane=new JScrollPane(table);
	 scrollPane.setBounds(5,110,300,200);
	// scrollPane.setBackground(Color.CYAN);
	 scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	add(scrollPane);
	
	JScrollPane scrollPane1=new JScrollPane(jta);
	 scrollPane1.setBounds(310,110,300,200);
	 scrollPane1.setBackground(Color.CYAN);
	 scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	 jta.setBackground(Color.PINK);
	 jta.setForeground(Color.BLUE);
	add(scrollPane1);
	add(lb);
	add(lb1);
	add(comId);
	
	add(showalldatabt);
	add(showidbt);
	add(removeallbt);
	add(backbt);
	try
	{
		openConnection();
		st=con.createStatement();
		rs=st.executeQuery("select * from emp");
		if(rs.next())
		{
			do
			{
				
				id=rs.getInt("Id");
				comId.addItem(""+id);
			}while(rs.next());
		}
		closeConnection();
	}
	catch(Exception ee)
	{
}
	
	showalldatabt.addActionListener(this);
	showidbt.addActionListener(this);
	backbt.addActionListener(this);
	removeallbt.addActionListener(this);
	
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
public void actionPerformed(ActionEvent e)
{
	if(e.getActionCommand().equals("BACK"))
	{
	searchform.myselfsearchform.dispose();
	entryform.myselfentryform.setVisible(true);	
	}
	if(e.getActionCommand().equals("SHOW ALL DATA"))
	{
		try
    	{
    	 fw=new FileWriter("list.txt");
    	 bw=new BufferedWriter(fw);
    	}
		catch(Exception ee)
		{
		}
    	/*
    			bw.write("name"+name);
    			bw.newLine();
    			bw.write("dob"+dob);
    			bw.newLine();
    			bw.write("id"+id);
    			bw.newLine();
    			bw.write("sex"+sex);
    			bw.newLine();
    			bw.write("salary"+salary);
    			bw.newLine();
    		*/	
 
		int c=table.getRowCount();
		jta.setText("");
		jta.append("name"+"\t"+"dob"+"\t"+"id"+"\t"+"sex"+"\t"+"salary"+"\n");
		try
		{
		bw.write("name"+"\t"+"dob"+"\t"+"id"+"\t"+"sex"+"\t"+"salary"+"\n");
		bw.newLine();
		}
		catch(Exception ee)
		{
			
		}
		for(int i=0;i<c;i++)
		{
		model.removeRow(0);
	    }
		try
		{
			openConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from emp");
			if(rs.next())
			{
				do
				{
					name=rs.getString("name");
					id=rs.getInt("Id");
					dob=rs.getDate("dob").toString();
					sex=rs.getString("sex");
					salary=rs.getDouble("salary");
					Object[] row={name,dob,id,sex,salary};
					model.addRow(row);
					jta.append(name+"\t"+id+"\t"+dob+"\t"+sex+"\t"+salary+"\n");
					bw.write(String.format("%20s %12s %3s %8s %12s %n",name,id,dob,sex,salary));
					/*
					bw.write("name     "+name);
	    			bw.newLine();
	    			bw.write("dob      "+dob);
	    			bw.newLine();
	    			bw.write("id       "+id);
	    			bw.newLine();
	    			bw.write("sex      "+sex);
	    			bw.newLine();
	    			bw.write("salary   "+salary);
	    			bw.newLine();
	    			*/
				}while(rs.next());
			}
			closeConnection();
		}
		catch(Exception ee)
		{
	}
		try
		{
			bw.close();
			fw.close();
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
		}
			if(e.getActionCommand().equals("SHOW ID"))
			{
				int a=table.getRowCount();
				for(int i=0;i<a;i++)
				{
					model.removeRow(0);
				}
				jta.setText("");
			try
			{	id=Integer.parseInt(comId.getSelectedItem().toString());
				openConnection();
				st=con.createStatement();
				rs=st.executeQuery("select * from emp where id="+id+"");
				if(rs.next())
				{
					
						name=rs.getString("name");
						id=rs.getInt("Id");
						dob=rs.getDate("dob").toString();
						sex=rs.getString("sex");
						salary=rs.getDouble("salary");
						Object[] row={name,dob,id,sex,salary};
						model.addRow(row);
				}
				closeConnection();
			}
			catch(Exception ee)
			{
		
			}
			}
			if(e.getActionCommand().equals("BACK"))
			{
				
			}
		}
			
		

public void itemStateChanged(ItemEvent ie)
{
	repaint();
}
}
