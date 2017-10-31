import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class menu1 extends JFrame implements ActionListener {
private JMenuBar menuBar;
private JMenu employeemenu;//main menu employee
private JMenuItem addemployee;//employee menu item
private JMenuItem editemployee;//employee menu item
private JMenuItem edituidemployee;//employee menu item
private JMenuItem deleteemployee;
private JMenuItem exitemployee;
private JMenuItem listemployee;
/////
private JMenu databasemenu;//main menu for database creation
private JMenuItem createdatabase;//create database
//
private JMenu financemenu;
private JMenuItem expenditure;
private JMenuItem collection;
private JMenuItem preparesalary;
private JMenuItem account;

JLabel lb1=new JLabel(new ImageIcon("C:\\kriti\\menu\\pic1.jpg"));
//JLabel employeelb=newJLabel("");
	JLabel employeelb=new JLabel(new ImageIcon("C:\\kriti\\menu\\pic2.jpg"));
	JLabel employeelb1=new JLabel(new ImageIcon("C:\\kriti\\menu\\pic1.jpg"));
	
	

		


JLabel elb1=new JLabel("enter name");
JLabel elb2=new JLabel("enter salary");
JButton ebt1=new JButton("show");
JButton ebt2=new JButton("back");
 

JLabel accountslb=new JLabel("");



	public static void main(String[] args) {
		new menu1();
		

	}
	
	menu1()
	{
	setSize(790,710);
	setLocation(50,10);
	setLayout(null);
	
	setResizable(false);
	lb1.setBounds(50, 50, 500, 120);
   employeelb.setBounds(20,20,300,200);
	employeelb1.setBounds(20,20,300,200);
	elb1.setBounds(15, 10, 150, 20);

	elb2.setBounds(15, 40, 150, 20);

	ebt1.setBounds(15, 70, 150, 20);

	ebt2.setBounds(15, 100, 150, 20);

	employeelb.add(elb1);
	employeelb.add(elb2);
	employeelb.add(ebt1);
employeelb.add(ebt2);
add(employeelb);
add(employeelb1);

accountslb.setBounds(20,20,300,200);
//Date today=new Date();
add(lb1);
menuBar=new JMenuBar();
employeemenu=new JMenu("Employees");
addemployee=new JMenuItem("Add Employees");
editemployee=new JMenuItem("Edit Employees");
edituidemployee=new JMenuItem("Edit UID/PW ");

deleteemployee=new JMenuItem("Retire Employees");

listemployee=new JMenuItem("List Employees");
exitemployee=new JMenuItem("Exit");

employeemenu.add(addemployee);
employeemenu.add(editemployee);
employeemenu.add(edituidemployee);
employeemenu.add(deleteemployee);
employeemenu.add(listemployee);
employeemenu.add(exitemployee);

employeemenu.addActionListener(this);
addemployee.addActionListener(this);
editemployee.addActionListener(this);
edituidemployee.addActionListener(this);
deleteemployee.addActionListener(this);
listemployee.addActionListener(this);
exitemployee.addActionListener(this);

/////////
financemenu=new JMenu("Accounts");
expenditure=new JMenuItem("Daily Expenditure");
collection=new JMenuItem("Daily Collection");
preparesalary=new JMenuItem("Prepare Salary");
account=new JMenuItem("Balance sheet");

financemenu.add(expenditure);
financemenu.add(collection);
financemenu.add(preparesalary);
financemenu.add(account);

financemenu.add(exitemployee);
financemenu.addActionListener(this);
expenditure.addActionListener(this);
collection.addActionListener(this);
preparesalary.addActionListener(this);
account.addActionListener(this);


//build the Data base menu

databasemenu=new JMenu("Database");//
createdatabase=new JMenuItem("Create DataBase & Tables"); //
databasemenu.add(createdatabase);//
createdatabase.addActionListener(this);//
createdatabase.addActionListener(this);

//add menus to menubar
menuBar.add(financemenu);
menuBar.add(employeemenu);
menuBar.add(databasemenu);

//menuBar.add(roomlistmenu);
//menuBar.add(databasemenu);//
setJMenuBar(menuBar);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
employeelb.setVisible(false);
employeelb1.setVisible(false);
setVisible(true);
}
public void actionPerformed(ActionEvent ev){
	if(ev.getActionCommand().equals("Exit"))
	
	{
		System.exit(0);
		
	}
	if(ev.getActionCommand().equals("Add Employees"))
	{
		employeelb.setVisible(true);
		
	}
	if(ev.getActionCommand().equals("Edit Employees"))
	{
		employeelb.setVisible(false);
		employeelb1.setVisible(true);
	}
}
}
		
	


