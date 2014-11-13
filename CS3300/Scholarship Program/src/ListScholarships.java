import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListScholarships {
	
	private static JFrame frame;
	private String[] columnNames = {"Scholarship",
									"Major", 
									"Min. GPA", 
									"Min. Hours",
									"Amount",
									"MaxAward"};
	Object[][] data = {
	        {"Kathy", "Smith",
	         "Snowboarding", new Integer(5), new Boolean(false), " "},															
	        {"John", "Doe", 
	         "Rowing", new Integer(3), new Boolean(true), " "},
	        {"Sue", "Black",
	         "Knitting", new Integer(2), new Boolean(false), " "},
	        {"Jane", "White",
	         "Speed reading", new Integer(20), new Boolean(true), " "},
	        {"Joe", "Brown",
	         "Pool", new Integer(10), new Boolean(false), " "}
	        };
	
	public ListScholarships(JFrame frame, int x, int y) {
		
		this.frame = frame;
		JPanel panel = new JPanel();
		JTable table = new JTable(data,columnNames);
		table.setSize(x * (5/8), y* (5/6));
		table.setEnabled(false);
		JScrollPane jsb = new JScrollPane(table);
		Dimension dim = new Dimension(800, 500);
		panel.add(jsb);
		jsb.setPreferredSize(dim);
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		JButton back = new JButton("Back");
		panel.add(back);
		
		frame.setContentPane(panel);
		frame.setSize(x,y);
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
