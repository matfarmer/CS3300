import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddScholarship {
	
	private static JFrame frame;
	static int x, y;
	
	private static String[] majorsString;	
	private JLabel lblName;
	private JLabel lblMajor;
	private JLabel lblGPA;	
	private JLabel lblHours;	
	private JLabel lblAmount;	
	private JLabel lblMaxAwardees;
	private static JTextField txtMaxAwardees;
	private static JTextField txtName;
	private static JTextField txtGPA;
	private static JTextField txtHours;
	private static JTextField txtAmount;
	private static JComboBox cmbMajor;
	private JButton btnSave;
	private JButton btnBack;
	
	public AddScholarship(JFrame frame, int x, int y) {
		this.frame = frame;
		this.x = x;
		this.y = y;
		setMajors();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7,2));
		
		lblName = new JLabel("Scholarship Name");
		lblMajor = new JLabel("Required Major");
		lblGPA = new JLabel("Minimum GPA");	
		lblHours = new JLabel("Minimum Hours");	
		lblAmount = new JLabel("Award Amount");	
		lblMaxAwardees = new JLabel("Maximum Awardees");
		txtMaxAwardees = new JTextField();
		txtName = new JTextField();
		txtGPA = new JTextField();
		txtHours = new JTextField();
		txtAmount = new JTextField();
		cmbMajor = new JComboBox(majorsString);
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		
		panel.add(lblName);
		panel.add(txtName);
		panel.add(lblMajor);
		panel.add(cmbMajor);
		panel.add(lblGPA);
		panel.add(txtGPA);
		panel.add(lblHours);
		panel.add(txtHours);
		panel.add(lblAmount);
		panel.add(txtAmount);
		panel.add(lblMaxAwardees);
		panel.add(txtMaxAwardees);
		panel.add(btnBack);
		panel.add(btnSave);
		btnBack.addActionListener(new BackListener());
		btnSave.addActionListener(new SaveListener());
		
		frame.setContentPane(panel);
	}
	public static class BackListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {	
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			new AdminUI(frame, x, y);
		}
		
	}
	public static class SaveListener implements ActionListener  {
		public void actionPerformed(ActionEvent e) {
						
			String name = null, major = null;
			float  GPA = 0;
			int hours = 0, amount = 0, maxAward = 0;
			try{
				if(txtName.getText().length() == 0) 
					throw new Exception();
				else 
					name = txtName.getText();				
			}
			catch(Exception message){
				JOptionPane.showMessageDialog(null, "Please input a value for "
						+ "Scholarship name");
			}
			try{
				if((String)cmbMajor.getSelectedItem() == "") 
					throw new Exception();
				else		
					major = (String)cmbMajor.getSelectedItem();
			}
			catch(Exception message) {
				JOptionPane.showMessageDialog(null, "Please input a value for "
						+ "Required Major");
			}
			try{
				GPA = Float.parseFloat(txtGPA.getText());
				
			}
			catch(NumberFormatException message){
				JOptionPane.showMessageDialog(null, "Invalid GPA value! Please "
						+ "enter a number");				
			}
			try{
				hours = Integer.parseInt(txtHours.getText());
				
			}
			catch(NumberFormatException message){
				JOptionPane.showMessageDialog(null, "Invalid Hours value! Please"
						+ "enter a number");				
			}
			try{
				amount = Integer.parseInt(txtAmount.getText());
				
			}
			catch(NumberFormatException message){
				JOptionPane.showMessageDialog(null, "Invalid Amount value! Please"
						+ "enter a number");				
			}
			try{
				maxAward = Integer.parseInt(txtMaxAwardees.getText());
				
			}
			catch(NumberFormatException message){
				JOptionPane.showMessageDialog(null, "Invalid Max Awardees value"
						+ "Please enter an integer value");				
			}
			finally{
			Scholarship scholarship = new Scholarship(name, major, GPA, hours,
													amount, maxAward,0);
			SaveControl mySave = new SaveControl();
			mySave.saveScholarship(scholarship);
			JOptionPane.showMessageDialog(null, "Scholarship Saved.");
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			new AdminUI(frame, x, y);
			}			
		}
	}
	private static void setMajors() {
    	
    	LinkedList<String> myList = new LinkedList<String>();
    	try {
    		File file = new File("MajorsText.txt");
    		Scanner input = new Scanner(file);
    		while(input.hasNext()) {
    			myList.add(input.nextLine());
    		}
    		input.close();
    	} catch(FileNotFoundException e) {}
    	majorsString = new String[myList.size()];
    	for(int i = 0; i < majorsString.length; i++) {
    		majorsString[i] = myList.get(i);
    	}
    }
}
