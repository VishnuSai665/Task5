package epamTask.task5;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/*
<applet code=”InterestCalc” width=450 height=300>
</applet>
*/
@SuppressWarnings("deprecation")
public class Interest extends Applet implements ActionListener
{
	private static final Logger logger = LogManager.getLogger(Interest.class);
	private static final long serialVersionUID = 1L;
	JButton b1,b2;
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3;
	JPanel panel;
	public void init()
	{
		l1=new JLabel("Principle Amount:");
		l2=new JLabel("Time Period:");
		l3=new JLabel("Rate of Interest:");
		b1=new JButton("Simple Interest:");
		b2=new JButton("Compound Interest:");
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		this.setLayout(new GridLayout(5,2));
		this.add(l1);
		this.add(t1);
		this.add(l2);
		this.add(t2);
		this.add(l3);
		this.add(t3);
		this.add(b1);
		this.add(t4);
		this.add(b2);
		this.add(t5);
		b1.addActionListener(this);
		b2.addActionListener(this);

	}
	public void actionPerformed(ActionEvent ae)
	{
		double pamount,time,interestRate,si,ci;
		pamount=Double.parseDouble(t1.getText());
		time=Double.parseDouble(t2.getText());
		interestRate=Double.parseDouble(t3.getText());
		
		if (ae.getSource()==b1)
		{
			si=(pamount*time*interestRate)/100.0;
			t4.setText(String.valueOf(si));
		}
		else if(ae.getSource()==b2)
		{
			ci=(pamount*(Math.pow((1+(interestRate/100.0)),time)));
			t5.setText(String.valueOf(ci));
		}
		logger.info("Principle Amount:"+t1.getText());
		logger.info("Time Period:"+t2.getText());
		logger.info("Rate of Interest:"+t3.getText());
		logger.info("Simple Interest:"+t4.getText());
		logger.info("Compound Interest:"+t5.getText());
	}
		
}
