//make frames at run times and add some buttons on form to do work
//we can run this frames from gel directly

//import java.applet.*;
import java.awt.*;
import javax.swing.*;//import  to call events
import java.awt.event.*;//import  to call events
//Swing->java foundation classes
//we can use swing class in form also
//public class Swingform extends JApplets implements ActionListener{
//rest is same
public class SwingFrame13 extends JFrame implements ActionListener,ItemListener{
	

	public static void main(String[] args) {
		new SwingFrame13();
	}
	String txt=null;
	JLabel lb1=new JLabel("enter first number:"); //to give labels
	JLabel lb2=new JLabel("enter second number:");
	JLabel lb3=new JLabel("");
	JLabel lb4=new JLabel("");
	JLabel lb5=new JLabel("");
	
	DefaultListModel model=new DefaultListModel();
	JTextField t1=new JTextField();//for writing any text in the labels
	JTextField t2=new JTextField();
	JComboBox com1=new JComboBox();
	JList list1=new JList (model);
	
	ButtonGroup group =new ButtonGroup();
	//for option buttons make it as group
	
	JRadioButton addchk=new JRadioButton("Addition",true);
	JRadioButton subchk=new JRadioButton("subtraction",false);
	JRadioButton mulchk=new JRadioButton("multiplication",false);
	JRadioButton divchk=new JRadioButton("division",false);
	JCheckBox chk=new JCheckBox("nnnn"); //write single chckbx here
	JButton combobt=new JButton("combo selection");
	JButton listbt=new JButton("list selection");
	JButton showbt=new JButton("Result"); //we can make a button here by this
	JButton exitbt=new JButton("Exit");
	
	
	JLabel resultlb=new JLabel("");
	public SwingFrame13(){
		group.add(addchk);
		group.add(subchk);
		group.add(mulchk);
		group.add(divchk);
		
			setSize(600,600);
			setLocation(10,10);
			setLayout(null);
			com1.setBounds(30, 300, 150, 20);
			combobt.setBounds(200, 300, 150, 20);
			lb4.setBounds(200, 330, 150, 20);
			listbt.setBounds(400, 300, 150, 20);
			lb5.setBounds(400, 330, 150, 20);
			
			com1.addItem("Windows 98");
			com1.addItem("Windows nt");
			com1.addItem("Windows 200");
			com1.addItem("Windows xp");
			com1.addItem("Windows vista");
			com1.addItem("Windows 7");
			
			com1.setSelectedIndex(3);
			
			model.add(0,"Arial");
			model.add(1,"Arial Black");
			model.add(2,"Impact");
			model.add(3,"MS Sans Serif");
			model.add(4,"Roman");
			model.add(5,"Symbol");
			model.add(6,"System");
			list1.setBounds(30, 350, 150, 150);
			lb1.setBounds(30,30,150,20);
			
			t1.setBounds(200,30,150,20);
			lb2.setBounds(30,60,150,20);
		//	lb2.setBackground(Color.CYAN);
			t2.setBounds(200,60,150,20);
			lb3.setBounds(30,310,150,20);
		//	lb3.setBackground(Color.GREEN);
			
			addchk.setBounds(30,90,150,20);
			subchk.setBounds(30,120,150,20);
			mulchk.setBounds(30,150,150,20);
			divchk.setBounds(30,180,150,20);
			
			showbt.setBounds(30,210,150,20);
		//	showbt.setBackground(Color.BLACK);
		//	showbt.setForeground(Color.CYAN);
			
			 exitbt.setBounds(30,240,150,20);
		//	 exitbt.setBackground(Color.DARK_GRAY);
		//	 showbt.setForeground(Color.CYAN);
				
			 
			 resultlb.setBounds(30,280,150,20);
		//	 exitbt.setBackground(Color.DARK_GRAY);
		//	 showbt.setForeground(Color.CYAN);
			
			 chk.setBounds(30,350,150,20);
			 showbt.setBackground(Color.BLUE);
			// list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//	 list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			 
			add(combobt);
			add(listbt);
			add(lb4);
			add(lb5);
			add(com1);
			add(list1);
			
			 add(lb1);
			 add(t1);
			 add(lb2);
			 add(t2);
			 add(lb3);
			 add(addchk);
			 add(subchk);
			 add(mulchk);
			 add(divchk);
			 add(chk);
			
			 add(showbt);
			 add(exitbt);
			 add(resultlb);
			
			 t1.requestFocus();
			 //list1.addItemListener(this);
			 //list1.addActionListener(this);
			 //model.addItemListener(this);
			 showbt.addActionListener(this);
			 
				
			 exitbt.addActionListener(this);
			 combobt.addActionListener(this);
			 
				
			 listbt.addActionListener(this);
			 com1.addItemListener(this);
			 //list1.addInputMethodListener(this);
			 setVisible(true);
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){ //for the result button
		if(e.getActionCommand().equals("combo selection"))
		{
			txt=(String)com1.getSelectedItem();
			lb4.setText(txt); }
		
			else if(e.getActionCommand().equals("list selection"))
			{String selfont="";
		//		selfont=(String)list1.getSelectedValue();//if select more than 
			//	lb5.setText(selfont);
				//one value
				//System.out.println(selfont);
				
				Object txt1[]=list1.getSelectedValues();//if select more then one value
				
				//in txt1[] store selected value 
				int ttxt1[]=list1.getSelectedIndices();
				//in ttxt1[] store selected value index nos
			//	lb5.setText(selfont+" "+ttxt1[0]);
				for(int i=0;i<ttxt1.length;i++)
				{
					System.out.println(""+ttxt1[i]); //print index no
					System.out.println(""+txt1[i]); //print values string wrtn in list
					}
					
				}
			else 
				if(e.getActionCommand().equals("Result")){
					try{
						double x=Double.parseDouble(t1.getText());//to take the text 
						//frm the text box
						double y=Double.parseDouble(t2.getText());
						if(addchk.isSelected())
							resultlb.setText(""+(x+y));
						else if(subchk.isSelected())
							resultlb.setText(""+(x-y));
						else if(mulchk.isSelected())
							resultlb.setText(""+(x*y));
						else if(divchk.isSelected()){
							if(y==0){
								resultlb.setText("denominator cannot be 0");
							
							}
							else{
								resultlb.setText(""+(x/y));
							}
						}
					}
					catch(Exception ex){
						resultlb.setText("error in input"); //this is fr showing on applet
					}
				}
		if(e.getActionCommand().equals("exit"))
		{
			System.exit(0);
		}
	}
	public void itemStateChanged(ItemEvent ie){
		repaint();


	}

}
