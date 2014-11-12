import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddScholarship {
	
	private static JFrame frame;
	
	public AddScholarship(JFrame frame) {
		this.frame = frame;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7,2));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		JLabel lblName = new JLabel("Scholarship Name");
		JTextField txtName = new JTextField();
		JLabel lblMajor = new JLabel("Required Major");
		JTextField txtMajor = new JTextField();
		JLabel lblGPA = new JLabel("Minimum GPA");
		JTextField txtGPA = new JTextField();
		JLabel lblHours = new JLabel("Minimum Hours");
		JTextField txtHours = new JTextField();
		JLabel lblAmount = new JLabel("Award Amount");
		JTextField txtAmount = new JTextField();
		JLabel lblMaxAwardees = new JLabel("Maximum Awardees");
		JTextField txtMaxAwardees = new JTextField();
		JButton btnSave = new JButton("Save");
		JButton btnBack = new JButton("Back");
		panel.add(lblName);
		panel.add(txtName);
		panel.add(lblMajor);
		panel.add(txtMajor);
		panel.add(lblGPA);
		panel.add(txtGPA);
		panel.add(lblHours);
		panel.add(txtHours);
		panel.add(lblAmount);
		panel.add(txtAmount);
		panel.add(lblMaxAwardees);
		panel.add(txtMaxAwardees);
		panel.add(btnSave);
		panel.add(btnBack);
		btnBack.addActionListener(new BackListener());
		
		frame.setContentPane(panel);
		frame.setSize(500, 500);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}
	public static class BackListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {	
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			AdminUI aui = new AdminUI();
		}
		
	}
}
