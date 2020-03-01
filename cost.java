package epam.log;

import org.apache.logging.log4j.*;

    
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cost extends Applet implements ActionListener
{
    private static final Logger LOGGER=LogManager.getLogger(cost.class);
    private static final long serialVersionUID = 1L;
    JButton B_1;
    JTextField T_1,T_2,T_3,T_4;
    JLabel L_1,L_2,L_3;
    JPanel P;
    public void init()
      {
          L_1=new JLabel("material standard");
          L_2=new JLabel("total area");
          L_3=new JLabel("fully automated");
          B_1=new JButton("calculate cost");

          T_1=new JTextField();
          T_2=new JTextField();
          T_3=new JTextField();
          T_4=new JTextField();

          this.setLayout(new GridLayout(4,2));
          this.add(L_1);
          this.add(T_1);
          this.add(L_2);
          this.add(T_2);
          this.add(L_3);
          this.add(T_3);
          this.add(B_1);
          this.add(T_4);
          B_1.addActionListener(this);
     }
    
    public void actionPerformed(ActionEvent ae)
     {
          String materialstandard;
          double totalarea,totalcost=0.0;
          int constructioncost;
    
          String automated;
          materialstandard=T_1.getText();
          totalarea=Double.parseDouble(T_2.getText());
          automated=T_3.getText().toLowerCase();

          if (ae.getSource()==B_1)
          {
             if(materialstandard.equals("standard")) 
             {
                 constructioncost=1200;
                 totalcost=constructioncost*totalarea;
             }
             else if(materialstandard.equals("above standard")) 
             {
                 constructioncost=1500;
                 totalcost=constructioncost*totalarea;
             }
             else if(materialstandard.equals("high standard")) 
             {
                 constructioncost=1800;
                 totalcost=constructioncost*totalarea;
             }
             else if(materialstandard.equals("high standard") && (automated.equals("yes") || automated.equals("true"))) 
             {
                 constructioncost=2500;
                 totalcost=constructioncost*totalarea;
             }
            T_4.setText(Double.toString(totalcost));
       }
       LOGGER.info("MATERIAL STANDARD: "+T_1.getText());
       LOGGER.info("TOTAL AREA: "+T_2.getText());
       LOGGER.info("FULLY AUTOMATED: "+T_3.getText());
       LOGGER.info("TOTAL COST: "+T_4.getText());
    }
}