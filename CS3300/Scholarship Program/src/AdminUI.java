import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminUI extends JFrame {
	
	private static JFrame frame = new JFrame("Scholarship Program");
	private static int WINDOW_WIDTH = 800, WINDOW_HEIGHT= 600;
	
	public AdminUI() {
		JButton addScholarship = new JButton("Add Scholarship");
		JButton listScholarship = new JButton("List Scholarships");
		JButton selectStudent = new JButton("Select a Student");
		JButton exit = new JButton("Exit");
		JPanel panel;
			
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0));
		panel.add(addScholarship);
		panel.add(listScholarship);
		panel.add(selectStudent);
		panel.add(exit);
		frame.setContentPane(panel);
		addScholarship.addActionListener(new ButtonListener());
		listScholarship.addActionListener(new ButtonListener());
		selectStudent.addActionListener(new ButtonListener());
		exit.addActionListener(new ButtonListener());
	}
	public static class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			if(actionCommand.equals("Add Scholarship")){
				AddScholarship as = new AddScholarship(frame, WINDOW_WIDTH, WINDOW_HEIGHT);
			}
			if(actionCommand.equals("List Scholarships")) {
				ListScholarships ls = new ListScholarships(frame, WINDOW_WIDTH, WINDOW_HEIGHT);
			}
			if(actionCommand.equals("Select a Student")) {
				SelectStudent ss = new SelectStudent(frame, WINDOW_WIDTH, WINDOW_HEIGHT);
			}
			if(actionCommand.equals("Exit")) {
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		AdminUI mainWindow = new AdminUI();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);

	}	
}
