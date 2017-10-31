import java.net.*;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import  java.awt.*;
import java.awt.event.*;
public class clientsql  extends Frame implements ActionListener 
{
	JButton exitbt=new JButton("Exit");
	JButton submitbt= new JButton("Submit");
	JLabel lb1= new JLabel("enter first no");
	JLabel lb2= new JLabel("enter second no");
	JLabel lb3=new JLabel("1. sum   2.diff   3. mul   4.div   5. exit");
	JLabel lb4= new JLabel("");
	JTextField tf1= new JTextField();
	JTextField tf2= new JTextField();
	JTextField tf3=new  JTextField();
	 int a=0,b=0,c=0,d=0,result=0;
	 public static Socket client = null;
	 public static BufferedReader br= null;
	 public static PrintWriter pw= null;
	public static void main(String[] args) throws Exception  
	{
		new clientsql();
		client= new Socket("127.0.0.1",1956);
		br= new BufferedReader(new InputStreamReader(client.getInputStream()));
		pw= new PrintWriter(client.getOutputStream());
	//	pw.println(4);
	//	pw.println(6);
	//	pw.flush();
	//	int result=Integer.parseInt(br.readLine());
	//	System.out.println("Result  ="+result);
	}
	 public clientsql()
	 {
		 setSize(600,600);
		 setLocation(10,10);
		 setLayout(null);
	//	 System.out.println("Result ="+result);
		 lb1.setBounds(30,50,250,20);
		 lb2.setBounds(30,80,250,20);
		 lb3.setBounds(30,110,250,20);
		 
		 tf1.setBounds(300,50,250,20);
		 tf2.setBounds(300,80,250,20);
		 tf3.setBounds(300,110,250,20);
		 
		 exitbt.setBounds(30,140,100,20);
		 submitbt.setBounds(150,140,100,20);
		 lb4.setBounds(30,180,300,20);
		 
		 add(lb1);
		 add(lb2);
		 add(lb3);
		 add(lb4);
		 
		 add(tf1);
		 add(tf2);
		 add(tf3);
		 
		 add(exitbt);
		 add(submitbt);
		 
		 exitbt.addActionListener(this);
		 submitbt.addActionListener(this);
		 
		 setVisible(true);
		 System.out.println("Connected to server.....");
		 
		 
	 }
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getActionCommand().equals("Submit"))
		 {
			 try
			 {
				 a=Integer.parseInt(tf1.getText().trim());
				 b=Integer.parseInt(tf2.getText().trim());
				 c=Integer.parseInt(tf3.getText().trim());
				 pw.println(a);
				 pw.println(b);
				 pw.println(c);
				 pw.flush();
				 result=Integer.parseInt(br.readLine());
				 lb4.setText("result" +result);
				 if(result==5)
					 System.exit(0);
			 }
			 catch(Exception ee)
			 {
				 
			 }
		 }
		 else 
			 if(e.getActionCommand().equals("Exit"))
			 {
				 System.exit(0);
			 }
	 }
}

