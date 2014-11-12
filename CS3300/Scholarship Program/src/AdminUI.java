import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AdminUI extends JFrame {
	
	private static JFrame frame = new JFrame("Scholarship Program");	
	
	public AdminUI() {
		JButton addScholarship = new JButton("Add Scholarship");
		JButton listScholarship = new JButton("List Scholarships");
		JButton selectStudent = new JButton("Select a Student");
		JPanel panel;
			
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,0));
		panel.add(addScholarship);
		panel.add(listScholarship);
		panel.add(selectStudent);
		frame.setContentPane(panel);
		addScholarship.addActionListener(new AddScholarshipListener());
	}
	public static class AddScholarshipListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			AddScholarship as = new AddScholarship(frame);
		}
	}
	
	
	public static void main(String[] args) {
		
		int WINDOW_WIDTH = 500,
		    WINDOW_HEIGHT= 500;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		AdminUI mainWindow = new AdminUI();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);

	}	
}
