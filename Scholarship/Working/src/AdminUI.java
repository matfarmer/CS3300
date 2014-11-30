import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminUI extends JFrame {
	
	private static JFrame frame;
	private static int WINDOW_WIDTH, WINDOW_HEIGHT;
	private JLabel lblTitle;
	private JButton addScholarship;
	private JButton listScholarship;
	private JButton selectStudent;
	private JButton back;
	
	public AdminUI(JFrame frame, int x, int y) {
		this.frame = frame;
		this.WINDOW_WIDTH = x;
		this.WINDOW_HEIGHT = y;
		lblTitle = new JLabel("Welcome administrator, please select an option:");
		addScholarship = new JButton("Add Scholarship");
		listScholarship = new JButton("List Scholarships");
		selectStudent = new JButton("Select a Student");
		back = new JButton("Back");
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(5,1));
		panel.add(lblTitle);
		panel.add(addScholarship);
		panel.add(listScholarship);
		panel.add(selectStudent);
		panel.add(back);
		frame.setContentPane(panel);
		addScholarship.addActionListener(new ButtonListener());
		listScholarship.addActionListener(new ButtonListener());
		selectStudent.addActionListener(new ButtonListener());
		back.addActionListener(new ButtonListener());
	}
	public static class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			if(actionCommand.equals("Add Scholarship")){
				new AddScholarship(frame, WINDOW_WIDTH, WINDOW_HEIGHT);
			}
			if(actionCommand.equals("List Scholarships")) {
				new ListScholarships(frame, WINDOW_WIDTH, WINDOW_HEIGHT);
			}
			if(actionCommand.equals("Select a Student")) {
				
				new SelectStudent(frame, WINDOW_WIDTH, WINDOW_HEIGHT);
			}
			if(actionCommand.equals("Back")) {
				new GUImain();
			}
		}
	}
	
/*	public static void main(String[] args) {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		AdminUI mainWindow = new AdminUI();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setVisible(true);

	}	*/
}
