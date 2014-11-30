import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AdminLogin {
	
	JLabel lblLoginName, lblPassword;
	static JTextField txtLoginName;
	static JPasswordField password;
	JButton btnBack, btnLogin;
	
	private static JFrame frame;
	private static int WINDOW_WIDTH, WINDOW_HEIGHT;

	public AdminLogin(JFrame frame, int x, int y) {
		this.frame = frame;
		this.WINDOW_WIDTH = x;
		this.WINDOW_HEIGHT = y;
		lblLoginName = new JLabel("User Name: ");
		lblPassword = new JLabel("Password: ");
		txtLoginName = new JTextField();
		password = new JPasswordField();
		btnBack = new JButton("Back");
		btnLogin = new JButton("Login");
		JLabel lblBlank = new JLabel(""); 
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel right = new JPanel(new GridLayout(6,2));
		JPanel panel = new JPanel(new GridLayout(2,1));
		
		right.add(lblLoginName);
		right.add(txtLoginName);
		right.add(lblBlank); right.add(lblBlank);
		right.add(lblBlank); right.add(lblBlank);
		right.add(lblPassword);
		right.add(password);
		right.add(lblBlank); right.add(lblBlank);
		right.add(lblBlank); right.add(lblBlank);
		panel.add(btnLogin);
		panel.add(btnBack);
		mainPanel.add(right, BorderLayout.NORTH);
		mainPanel.add(panel, BorderLayout.SOUTH);
		frame.setContentPane(mainPanel);
		btnBack.addActionListener(new ButtonListener());
		btnLogin.addActionListener(new ButtonListener());		
	}
	public static class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();			
			if(actionCommand.equals("Back")) {
				frame.getContentPane().setVisible(false);
				frame.remove(frame.getContentPane());
				new GUImain();
			}
			if(actionCommand.equals("Login")) {
				if(txtLoginName.getText().equals("admin") && password.getText().equals("password")){
					frame.getContentPane().setVisible(false);
					frame.remove(frame.getContentPane());
					AdminUI au = new AdminUI(frame, WINDOW_WIDTH, WINDOW_HEIGHT);
				}
				else
					JOptionPane.showMessageDialog(null, "Incorrect Password!");
			}			
		}		
	}
}
