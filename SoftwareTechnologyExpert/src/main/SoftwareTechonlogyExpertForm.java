package main;

import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*; 
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SoftwareTechonlogyExpertForm extends JFrame  implements ActionListener,ChangeListener  {
	JSlider slider1, slider2, slider3,slider4,slider5; 
	JTextField tf; 
	JLabel titlelabel1, valueLabel1, titlelabel2,valueLabel2,titlelabel3, valueLabel3,titlelabel4, valueLabel4,titlelabel5, valueLabel5, l, typeLabel, output1, output2, output3, output4, output5, output6, output7, output8, output9, output10; 
	JButton b;  
	FIS fis;
	JPanel outputPanel ;
	
	SoftwareTechonlogyExpertForm() {
		fis = FIS.load("rules/rules.fcl");
		
		if (fis == null) {
			System.out.println("Something went wrong");
			return;
		}
		//JFuzzyChart.get().chart(fis);
		//fis.setVariable("relevant_experience", relevantExperience);
		//fis.evaluate();
		//System.out.println("Python suggestion: " + fis.getVariable("python").defuzzify());
		
		setTitle("Software Techonology Expert Form");
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
        setSize(450,600);  
        //setLayout(null);  
        setVisible(true);  
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        typeLabel = new JLabel("Type of application");
        typeLabel.setBounds(450,250,300,50);
        typeLabel.setToolTipText("Tooltip text for Application Performance");
        add(typeLabel);
	}
	
	
	private void addOutputLabel(String name, double value, String tooltip) {
        JLabel label = new JLabel(name + " - (" + value + ")");
        label.setToolTipText("Tooltip for " + name);
        label.setHorizontalAlignment(JLabel.CENTER);

        // Set the text color based on the value
        if (value > 3.5) {
            label.setForeground(Color.GREEN);
        } else if (value > 1.5) {
            label.setForeground(Color.BLACK);
        } else {
            label.setForeground(Color.GRAY);
        }

        outputPanel.add(label);
    }
	
	private int roundUporDownResult(double result) {
		if (result > 0) {
			return (int)Math.round(result);
		} else return -1;
	}
	 private void sortOutputLabels() {
        List<Component> labels = new ArrayList<>();
        for (Component component : outputPanel.getComponents()) {
            labels.add(component);
        }

        // Sort the labels based on value in descending order
        Collections.sort(labels, new Comparator<Component>() {
            @Override
            public int compare(Component c1, Component c2) {
            	 JLabel label1 = (JLabel) c1;
            	 JLabel label2 = (JLabel) c2;
            	String value1 = label1.getText().substring(label1.getText().indexOf("(") + 1, label1.getText().indexOf(")"));
                String value2 = label2.getText().substring(label2.getText().indexOf("(") + 1, label2.getText().indexOf(")"));
                return roundUporDownResult( Double.parseDouble(value2) - Double.parseDouble(value1));
            }
        });

        // Clear the output panel
        outputPanel.removeAll();

        // Add the sorted labels back to the output panel
        for (Component label : labels) {
            outputPanel.add(label);
        }
	 }
    public void actionPerformed(ActionEvent e) {  
        try{
        	int value1 = slider1.getValue();
        	
        	int value2 = slider2.getValue();
        	int value3 = slider3.getValue();
        	int value4 = slider4.getValue();
        	int value5 = slider5.getValue();
        	
        	fis.setVariable("relevant_experience", value1);
        	fis.setVariable("visual_representation", value2);
        	fis.setVariable("application_complexity", value3);
        	fis.setVariable("application_performance", value4);
        	fis.setVariable("data_size", value5);
        	
        	fis.evaluate();
        	
        	setSize(1000, 600);
        	
        	outputPanel = new JPanel();
            outputPanel.setLayout(new GridLayout(0, 1));
            outputPanel.setBounds(750,50,200,200);
            
            addOutputLabel("Python", fis.getVariable("python").defuzzify(), "A versatile programming language known for its simplicity and readability, widely used in various domains including web development, data analysis, and artificial intelligence.");
            addOutputLabel("JSON", fis.getVariable("json").defuzzify(), "A lightweight data interchange format commonly used for storing and transferring structured data, often used in web applications and APIs.");
            addOutputLabel("XML", fis.getVariable("xml").defuzzify(), " A markup language designed to store and transport data, widely used for representing structured information in a human-readable format.");
            addOutputLabel("SQL", fis.getVariable("sql").defuzzify(), "A standard language for managing and manipulating relational databases, used for tasks such as querying data, defining database structures, and performing data operations.");
            addOutputLabel("Powershell or Batch", fis.getVariable("powershell_batch").defuzzify(), "Powershell is a scripting language used primarily for task automation and configuration management in Windows environments. Batch scripting is a simple scripting language used for executing sequences of commands in Windows.");
            addOutputLabel("Java or C#", fis.getVariable("java_csharp").defuzzify(), "Java and C# are both object-oriented programming languages used for developing a wide range of applications, including desktop, web, and mobile applications.");
            addOutputLabel("HTML and CSS", fis.getVariable("html_css").defuzzify(), "HTML is the standard markup language for creating web pages, defining the structure and content. CSS is used to describe the presentation and styling of the HTML elements.");
            addOutputLabel("Angular or React", fis.getVariable("angular_react").defuzzify(), "Angular and React are popular JavaScript frameworks used for building dynamic and interactive web applications, providing tools and components for efficient development.");
            addOutputLabel("JavaScript", fis.getVariable("javascript").defuzzify(), " A widely-used scripting language that enables dynamic and interactive functionality on web pages, often used for client-side development.");
            addOutputLabel("TypeScript", fis.getVariable("typescript").defuzzify(), "A superset of JavaScript that adds static typing and additional features, providing enhanced tooling and scalability for larger JavaScript projects.");
            add(outputPanel, BorderLayout.CENTER);
            sortOutputLabels();
            
            //System.out.println(value1 + " " + value2 + " " + value3 + " " + value4 + " " + value5);
            var general_type_value= fis.getVariable("general_type").defuzzify();
            var type_value= fis.getVariable("type").defuzzify();
            String type = "General Programming";
            if (type_value<3) type = "Data Science";
            if (general_type_value<3.5) type = "FullStack development";
            if (general_type_value<1.5) type = "Front-end developemnt";
            
            
            typeLabel.setText("Type of application: "+ type);
            
    		//fis.setVariable("relevant_experience", relevantExperience);
    		//fis.evaluate();
    		//System.out.println("Python suggestion: " + fis.getVariable("python").defuzzify());
            
            
        //String host=tf.getText();  
        //String ip=java.net.InetAddress.getByName(host).getHostAddress();  
        //l.setText("IP of "+host+" is: "+ip);  
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
            }
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
