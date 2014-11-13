import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddScholarship {
	
	private static JFrame frame;
	
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
	
	private JLabel lblName = new JLabel("Scholarship Name");
	private JLabel lblMajor = new JLabel("Required Major");
	private JLabel lblGPA = new JLabel("Minimum GPA");	
	private JLabel lblHours = new JLabel("Minimum Hours");	
	private JLabel lblAmount = new JLabel("Award Amount");	
	private JLabel lblMaxAwardees = new JLabel("Maximum Awardees");
	private static JTextField txtMaxAwardees = new JTextField();
	private static JTextField txtName = new JTextField();
	private static JTextField txtGPA = new JTextField();
	private static JTextField txtHours = new JTextField();
	private static JTextField txtAmount = new JTextField();
	private static JComboBox cmbMajor = new JComboBox(majorsString);
	private JButton btnSave = new JButton("Save");
	private JButton btnBack = new JButton("Back");
	
	public AddScholarship(JFrame frame, int x, int y) {
		this.frame = frame;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7,2));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
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
		frame.setSize(x, y);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}
	public static class BackListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {	
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			AdminUI aui = new AdminUI();
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
													amount, maxAward);
			scholarship.save();
			}			
		}
	}
}
