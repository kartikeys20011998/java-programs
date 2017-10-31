import java.net.*;
import java.io.*;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.applet*;
import java.sql.*;
//import java.io.*;
public class serversql {

		public static Connection  con = null;
		public static Statement  st= null;
		ResultSet rs= null;
		public static void openConnection()
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
		
		public static void closeConnection()
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				
			}
		}
	public static void main(String[] args) throws Exception
	{
		ServerSocket server=new ServerSocket(1956);
		System.out.println("server started.....");
		Socket client =server.accept();
		System.out.println("Connection accepted ....");
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter pw= new PrintWriter(client.getOutputStream());
	//	int x= Integer.parseInt(br.readLine());
	//	int y=Integer.parseInt(br.readLine());
	//	pw.println(x+y);
	//	pw.flush();
		int a1,b1,c1,d1;
		try
		{
			do
			{
				a1=Integer.parseInt(br.readLine());
				b1=Integer.parseInt(br.readLine());
				c1=Integer.parseInt(br.readLine());
				openConnection();
				String qry="insert into datastore values("+a1+","+b1+","+c1+")";
				st=con.createStatement();
				st.executeUpdate(qry);
				closeConnection();
				switch(c1)
				{
				case 1: d1=a1+b1;
					pw.println(d1);
					pw.flush();
					break;
				case 2: d1=a1-b1;
					pw.println(d1);
					pw.flush();
					break;
				case 3: d1=a1*b1;
				    pw.println(d1);
				    pw.flush();
				    break;
				case 4: d1=a1/b1;
					pw.println(d1);
					pw.flush();
					break;
				case 5: 
					pw.println(c1);
					pw.flush();
					System.exit(0);
				}
			}while(c1!=5);
		}
		catch(IOException e)
		{
			System.out.println("error in input "+e.getMessage());
			System.exit(0);
		}
		catch(NumberFormatException e)
		{
			System.out.println("error in number input "+e.getMessage());
			System.exit(0);
		}
	

	}

}


