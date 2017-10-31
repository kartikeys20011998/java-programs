
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class spinner extends JFrame implements ActionListener{
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	new spinner();

	}
	JSpinner s;
	 SpinnerNumberModel model;
	  JTextField stepText=new JTextField(10);
	  JButton bStepSet=new JButton("Set Step");
	  
	  spinner()
	  {
		  setSize(790,710);
		  setLocation(50,10);
		  setLayout(null);
		  
		  setResizable(false);
		  stepText.setBounds(5,30,100,20);
		  add(stepText);
		  bStepSet.setBounds(110,30,100,20);
		  add(bStepSet);
		  bStepSet.addActionListener(this);
		  
		  model=new SpinnerNumberModel(0.0,0.0,20,0.0);
		  s=new JSpinner(model);
		  model.setStepSize(.05);
		  s.setBounds(5,60,100,20);
		  add(s);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  setVisible(true);
		  
	  }
	  public void actionPerformed(ActionEvent ev)
	  {
		  if(ev.getActionCommand().equals("Set Step"))
		  {
			  double value=(Double)model.getValue();
			  
			  value=Math.round(value* 100.0)/100.0;
			  System.out.println("value  "+value);
			  
		  }
	  }

}
