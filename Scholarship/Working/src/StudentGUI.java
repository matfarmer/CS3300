/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author gabriel
 */
public class StudentGUI extends JFrame 
{
	private static String[] majorsString = { "",
 
 									 "Aviation", 
 									 "Agriculture", 
 									 "Architecture", 
 									 "Business", 
 									 "Communications", 
 									 "Computer Science",  
 									 "Computer Engineering", 
 									 "Construction", 
 									 "Educations", 
 									 "Engineering", 
 									 "English", 
 									 "Foreign Languages", 
 									 "Health Professions", 
 									 "History", 
 									 "Mathematics", 
 									 "Philosopy" 
									}; 
	private static String[] listFields;
	private static JTextField nameTextLabel = new JTextField(10);
	private JTextField degreeTextLabel = new JTextField(10);
    private static JTextField GPATextLabel = new JTextField(10);
    private static JTextField hoursTextLabel = new JTextField(10);
    private static JComboBox cmbMajor = new JComboBox(majorsString);
    private static JComboBox cmbScholarship;
    private JLabel lblScholarship = new JLabel("Scholarship");
    private JButton backButton = new JButton ("Back") ;
    private JButton clearButton = new JButton ("Clear");
    private JButton submitButton = new JButton ("Submit");
    private JLabel nameLabel  = new JLabel("What is your name?");
    private JLabel degreeLabel = new JLabel("What is your degree?");
    private JLabel GPALabel = new JLabel("What is your GPA?");
    private JLabel hoursLabel = new JLabel ("How many hours do you have?");
    private JPanel panel = new JPanel();
    private static Object[][] data;
    private static SaveControl save;
    private static LinkedList<Scholarship> myList;
	
	private static JFrame frame; 
    private static int x, y;
    public StudentGUI(JFrame frame, int x, int y)
    {
    	this.frame = frame;
    	this.x = x;
    	this.y = y;
    	save = new SaveControl();
    	myList = new LinkedList<Scholarship>();
    	myList = save.getList();
    	data = new Object[myList.size()][7];
    	initializeData();
    	CreateScholarshipComboBox();
    	JLabel lblBlank = new JLabel("");
        
        panel.setLayout(new GridLayout(7,2));
        panel.add(nameLabel);
        panel.add(nameTextLabel);
        panel.add(lblScholarship);
        panel.add(cmbScholarship);
        panel.add(degreeLabel);
        panel.add(cmbMajor);
        panel.add(GPALabel);
        panel.add(GPATextLabel);
        panel.add(hoursLabel);
        panel.add(hoursTextLabel);
        panel.add(clearButton);
        panel.add(lblBlank);
        panel.add(backButton);
        panel.add(submitButton);
        frame.setContentPane(panel);
        backButton.addActionListener(new BackButtonListener());
        submitButton.addActionListener(new SubmitButtonListener());
        clearButton.addActionListener(new ClearButtonListener());
        
    }
    private static class BackButtonListener implements ActionListener {   
        
    	public void actionPerformed(ActionEvent e) {
    		frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
    		new GUImain();

    	}

    }
    private static class SubmitButtonListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		String nameStudent = nameTextLabel.getText();
            String hours = hoursTextLabel.getText();
            String sMajor =(String) cmbMajor.getSelectedItem();
            String GPA = GPATextLabel.getText();
            double GPAFinal = 0;
            int hoursFinal = 0;
            boolean pass, pass1, pass2, pass3, pass4;
           if (nameStudent.equals ("")) 
           {
               pass2 = false;
                JOptionPane.showMessageDialog(null,"Please enter your name",
                        "Error", JOptionPane.ERROR_MESSAGE);
           }
           else
              pass2 = true;
           
           if((String)cmbMajor.getSelectedItem() == "") 
           {
                 pass3 = false;
                JOptionPane.showMessageDialog(null,"You have to select a degree",
                        "Error", JOptionPane.ERROR_MESSAGE);
           }
           else 
        	   pass3 = true;
           
           if (cmbMajor.equals(0))
               JOptionPane.showMessageDialog(null,"Hola",
                        "Error", JOptionPane.ERROR_MESSAGE);
           try 
            {
             GPAFinal = Double.parseDouble
            		 (GPA); 
             pass1 = true;
             if (GPAFinal > 4 || GPAFinal <0 )
            {
                pass1 = false;
                JOptionPane.showMessageDialog(null,"GPA most be between 0-4",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            catch (Exception a)
                    {
                JOptionPane.showMessageDialog(null," Your GPA is incorrect",
                        "Error", JOptionPane.ERROR_MESSAGE);
                pass1 = false;
            }
        
        try 
            {
             hoursFinal = Integer.parseInt(hours);  
             pass = true;
             if (hoursFinal < 0 )
            {
                pass = false;
                JOptionPane.showMessageDialog(null,"Hours cannot be less than 0",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
            catch (Exception a)
                    {
                JOptionPane.showMessageDialog(null," Your hours are incorrect",
                        "Error", JOptionPane.ERROR_MESSAGE);
                pass = false;
            }
            if (pass == true && pass1 ==true && pass2 == true && pass3 == true)
            {
            	Student student = new Student(nameStudent, sMajor, GPAFinal, hoursFinal);
            	Scholarship scholarship = getScholarship(cmbScholarship.getSelectedIndex() -1);
            	if(student.awardScholarship(scholarship))
            		myList.get(cmbScholarship.getSelectedIndex() -1).accepted();
            	save.save(myList);
            	save.saveAwarded(student, scholarship);
            }          
    	}
    }
    private static class ClearButtonListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		nameTextLabel.setText("");
            GPATextLabel.setText("");
            cmbMajor.setSelectedIndex(0);
            hoursTextLabel.setText("");
            nameTextLabel.requestFocus();
            cmbMajor.setSelectedIndex(0);

    	}
    }
    private static void CreateScholarshipComboBox() {
    	
    	listFields = new String[myList.size() + 1];
    	listFields[0] = "";
    	for(int i = 0; i < myList.size(); i++) {
    		listFields[i + 1] = (String) data[i][0] + " (" 
    							+ (String)data[i][1] + ")";
    		
    	}
    	 cmbScholarship = new JComboBox(listFields);
    	
    }
    private static void initializeData() {
    	for(int i = 0; i < myList.size(); i++) {
			data[i][0] = myList.get(i).getName();
			data[i][1] = myList.get(i).getMajor();
			data[i][2] = myList.get(i).getGPA();
			data[i][3] = myList.get(i).getHours();
			data[i][4] = myList.get(i).getAmount();
			data[i][5] = myList.get(i).getMax();
			data[i][6] = myList.get(i).getCurrent();
    	}
    }
    private static Scholarship getScholarship(int selected) {
    	
    	String name = new String((String) data[selected][0]);
    	String major = new String((String) data[selected][1]);
    	double gpa= ((double) data[selected][2]);
    	int hours = ((int) data[selected][3]);
    	double amount = ((double) data[selected][4]);
    	int max = ((int) data[selected][5]);
    	int current = ((int) data[selected][6]);

    	return new Scholarship(name, major, gpa, hours, amount, max, current);
    	
    }
}