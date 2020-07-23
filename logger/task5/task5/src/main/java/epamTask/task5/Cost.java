package epamTask.task5;

import org.apache.logging.log4j.*;   
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code=”ConstructionCost” width=450 height=300>
</applet>
*/
@SuppressWarnings("deprecation")

public class Cost extends Applet implements ActionListener
{
	private static final Logger logger = LogManager.getLogger(Cost.class);
	private static final long serialVersionUID = 1L;
	JButton b1;
	JTextField t1,t2,t3,t4;
	JLabel l1,l2,l3;
	JPanel panel;
	public void init()
	{
		l1=new JLabel("Material Standard: ");
		l2=new JLabel("Total Area: ");
		l3=new JLabel("Fully Automated:");
		b1=new JButton("Calculate Cost");
	
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
	
		this.setLayout(new GridLayout(4,2));
		this.add(l1);
		this.add(t1);
		this.add(l2);
		this.add(t2);
		this.add(l3);
		this.add(t3);
		this.add(b1);
		this.add(t4);
		b1.addActionListener(this);


	}
	public void actionPerformed(ActionEvent ae)
	{

		String matStandard;
		double area,tcost=0.0;
		int conCost;
		String automated;
		matStandard=t1.getText();
		area=Double.parseDouble(t2.getText());
		automated=t3.getText().toLowerCase();
	
		if (ae.getSource()==b1)
		{
			if(matStandard.equals("Standard")) {
				conCost=1200;
				tcost=conCost*area;
			}
			else if(matStandard.equals("Above Standard")) 
			{
				conCost=1500;
				tcost=conCost*area;
			}
			else if(matStandard.equals("High Standard")) 
			{
				conCost=1800;
				tcost=conCost*area;
			}
			else if(matStandard.equals("High Standard") && (automated.equals("yes") || automated.equals("true"))) 
			{
				conCost=2500;
				tcost=conCost*area;
			}
			t4.setText(Double.toString(tcost));

		}
		logger.info("standard:"+t1.getText());
		logger.info("total area:"+t2.getText());
		logger.info("automated:"+t3.getText());  
		logger.info("total cost:"+t4.getText());  
	 
	}
}
