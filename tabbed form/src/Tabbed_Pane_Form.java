import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Tabbed_Pane_Form extends JFrame implements ActionListener {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Tabbed_Pane_Form();

	}
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
 JButton exitbt1=new JButton("Exit_1");
 JButton exitbt2=new JButton("Exit_2");
 JButton exitbt3=new JButton("Exit_3");
 JButton exitbt4=new JButton("Exit_4");
 
 
 public Tabbed_Pane_Form()
 
 {
	 setTitle("Kriti Sharma");
	 setSize(1000,650);
	 setLocation(50,10);
	 setBackground(Color.gray);
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
	 tabbedPane.addTab("Employee Entry Form", panel1);
	 tabbedPane.addTab("Employee Search Form", panel2);
	 tabbedPane.addTab("Employee Update Form", panel3);
	 tabbedPane.addTab("Employee Delete Form", panel4);
	 
	 //panel1.setVisible(true);
	//panel2.setVisible(true);
	//panel3.setVisible(true);
	//panel4.setVisible(true);
	 //in the outer panel add inner panel with all sub panels
	 topPanel.add(tabbedPane,BorderLayout.CENTER);
	 tabbedPane.setVisible(true);
	 setVisible(true);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 
 }
 public void createPage1()
 {
	 panel1=new JPanel();
	 panel1.setLayout(null);
	 exitbt1.setBounds(10,20,150,20);
	 panel1.add(exitbt1);
	 exitbt1.addActionListener(this);
	 
 }
 
 public void createPage2()
 {
	 panel2=new JPanel();
	 panel2.setLayout(null);
	 exitbt2.setBounds(10,50,150,20);
	 panel2.add(exitbt2);
	 exitbt2.addActionListener(this);
	 
 }
 public void createPage3()
 {
	 panel3=new JPanel();
	 panel3.setLayout(null);
	 exitbt3.setBounds(10,90,150,20);
	 panel3.add(exitbt3);
	 exitbt3.addActionListener(this);
 }
	 
	 public void createPage4()
	 {
		 panel4=new JPanel();
		 panel4.setLayout(null);
		 exitbt4.setBounds(10,120,150,20);
		 panel4.add(exitbt4);
		 exitbt4.addActionListener(this);
 
}
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getActionCommand().equals("Exit_1"))
		 {
			 System.exit(0);
		 }
	 }
}