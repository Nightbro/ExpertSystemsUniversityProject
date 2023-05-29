package main;

import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*; 
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

class SoftwareTechonlogyExpertForm extends JFrame  implements ActionListener,ChangeListener  {
	JSlider slider1, slider2, slider3,slider4,slider5; 
	JTextField tf; 
	JLabel titlelabel1, valueLabel1, titlelabel2,valueLabel2,titlelabel3, valueLabel3,titlelabel4, valueLabel4,titlelabel5, valueLabel5, l; 
	JButton b;  
	
	
	SoftwareTechonlogyExpertForm() {
		setTitle("Software Techonology Expert Form");
		//setLayout(new FlowLayout());
		setLayout(null);
		
		b=new JButton("Make a suggestion");  
        b.setBounds(100,500,200,50);  
        b.addActionListener(this);  
        
        titlelabel1 = new JLabel("Prior Experience");
        titlelabel1.setBounds(50,20,200,30);
        add(titlelabel1);
        
        slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider1.addChangeListener(this);
        slider1.setBounds(50,50,200,50);
        
        valueLabel1 = new JLabel("Non Existing");
        valueLabel1.setBounds(301,50,200,50);
        add(valueLabel1);
        
        titlelabel2 = new JLabel("Visual Representation");
        titlelabel2.setBounds(50,120,200,30);
        add(titlelabel2);
        
        slider2 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider2.addChangeListener(this);
        slider2.setBounds(50,150,200,50);
        
        valueLabel2 = new JLabel("Irrelevant");
        valueLabel2.setBounds(301,150,200,50);
        add(valueLabel2);
        
        titlelabel3 = new JLabel("Application Complexity");
        titlelabel3.setBounds(50,220,200,30);
        add(titlelabel3);
        
        slider3 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider3.addChangeListener(this);
        slider3.setBounds(50,250,200,50);
        
        valueLabel3 = new JLabel("Simple");
        valueLabel3.setBounds(301,250,200,50);
        add(valueLabel3);
        
        
        titlelabel4 = new JLabel("Application Performance");
        titlelabel4.setBounds(50,320,200,30);
        add(titlelabel4);
        
        slider4 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider4.addChangeListener(this);
        slider4.setBounds(50,350,200,50);
        
        valueLabel4 = new JLabel("Irrelevant");
        valueLabel4.setBounds(301,350,200,50);
        add(valueLabel4);
        
        titlelabel5 = new JLabel("Data size");
        titlelabel5.setBounds(50,420,200,30);
        add(titlelabel5);
        
        slider5 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider5.addChangeListener(this);
        slider5.setBounds(50,450,200,50);
        
        valueLabel5 = new JLabel("Small Database");
        valueLabel5.setBounds(301,450,200,50);
        add(valueLabel5);
        
        
       // b.addActionListener(this);    
        add(slider1);
        add(slider2);
        add(slider3);
        add(slider4);
        add(slider5);
        add(b);
        setSize(1200,600);  
        //setLayout(null);  
        setVisible(true);  
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
    public void actionPerformed(ActionEvent e) {  
        try{  
        String host=tf.getText();  
        String ip=java.net.InetAddress.getByName(host).getHostAddress();  
        l.setText("IP of "+host+" is: "+ip);  
        }catch(Exception ex){System.out.println(ex);}  
    }  
    
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();

        if (source == slider1) {
            int value1 = slider1.getValue();


            if (value1 >= 0 && value1 <= 5) {
            	valueLabel1.setText("Non Existing");
            }else if (value1 >= 6 && value1 <= 35) {
            	valueLabel1.setText("Begginer");
            }else if (value1 >= 36 && value1 <= 65) {
            	valueLabel1.setText("Intermediate");
            }else if (value1 >= 66 && value1 <= 85) {
            	valueLabel1.setText("Advanced");
            } else if (value1 >= 86 && value1 <= 100) {
            	valueLabel1.setText("Expert");
        } else if (source == slider2) {
            int value2 = slider2.getValue();

            if (value2 >= 0 && value2 <= 25) {
                valueLabel2.setText("Irrelevant");
            } else if (value2 >= 26 && value2 <= 74) {
                valueLabel2.setText("Required");
            } else if (value2 >= 75 && value2 <= 100) {
                valueLabel2.setText("Highly Required");
            }
        } else if (source == slider3) {
            int value3 = slider3.getValue();

            if (value3 >= 0 && value3 <= 25) {
                valueLabel3.setText("Simple");
            } else if (value3 >= 26 && value3 <= 74) {
                valueLabel3.setText("Irrelevant");
            } else if (value3 >= 75 && value3 <= 100) {
                valueLabel3.setText("Complex");
            }
        } else if (source == slider4) {
            int value4 = slider2.getValue();

            if (value4 >= 0 && value4 <= 25) {
                valueLabel4.setText("Irrelevant");
            } else if (value4 >= 26 && value4 <= 74) {
                valueLabel4.setText("Somehow relevant");
            } else if (value4 >= 75 && value4 <= 100) {
                valueLabel4.setText("Required");
            }
        } else if (source == slider5) {
            int value5 = slider3.getValue();

            if (value5 >= 0 && value5 <= 25) {
                valueLabel5.setText("Small Database");
            } else if (value5 >= 26 && value5 <= 74) {
                valueLabel5.setText("Usual Size");
            } else if (value5 >= 75 && value5 <= 100) {
                valueLabel3.setText("Big Database");
            }
        }
    }
    }


}
