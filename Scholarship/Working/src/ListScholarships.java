import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.text.DecimalFormat;
import java.util.LinkedList;

public class ListScholarships {

	
	private static JFrame frame;
	private static int x, y;
	private int counter;
	private String[] columnNames = {"Scholarship",
									"Major", 
									"Min. GPA", 
									"Min. Hours",
									"Amount",
									"MaxAward",
									"CurAwards"};
	
	
	private Object[][] data;
	private JTable table; 
	JScrollPane jsb;
	public void initializeData()
	{
		SaveControl save = new SaveControl();
		LinkedList<Scholarship> myList = new LinkedList<Scholarship>();
		myList = save.getList();
		data = new Object[myList.size()][7];
		for(int i =0; i < myList.size(); i++) {
			data[i][0] = myList.get(i).getName();
			data[i][1] = myList.get(i).getMajor();
			data[i][2] = myList.get(i).getGPA();
			data[i][3] = myList.get(i).getHours();
			data[i][4] = "$" + myList.get(i).getAmount();
			data[i][5] = myList.get(i).getMax();
			data[i][6] = myList.get(i).getCurrent();
		}
	}
	public ListScholarships(JFrame frame, int x, int y) {
		initializeData();
		this.frame = frame;
		this.x = x;
		this.y = y;
		JPanel panel = new JPanel();
		table= new JTable(data,columnNames);
		table.setSize(x * (5/8), y* (5/6));
		table.setEnabled(false);
		jsb = new JScrollPane(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(175);
		table.getColumnModel().getColumn(1).setPreferredWidth(175);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(75);
		table.getColumnModel().getColumn(6).setPreferredWidth(75);
		Dimension dim = new Dimension(775, 500);
		panel.add(jsb);
		jsb.setPreferredSize(dim);
		JButton back = new JButton("Back");
		panel.add(back);
		
		frame.setContentPane(panel);
		back.addActionListener(new BackListener());
		
	}
	public static class BackListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {	
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			new AdminUI(frame, x, y);
		}
		
	}

}
