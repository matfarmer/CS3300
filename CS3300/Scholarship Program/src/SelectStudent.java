import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class SelectStudent {
	
	public static JFrame frame;
	
	public SelectStudent(JFrame frame, int x, int y) {
		this.frame = frame;
		JPanel panel = new JPanel();
		
		Dimension dim;
		
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		JButton back = new JButton("Back");
		panel.add(back);
		
		frame.setContentPane(panel);
		frame.setSize(x, y);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		back.addActionListener(new BackListener());
	}
	
	public static class BackListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {	
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			AdminUI aui = new AdminUI();
		}
		
	}

}
