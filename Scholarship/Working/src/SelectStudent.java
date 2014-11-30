import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class SelectStudent {
	
	public static JFrame frame;
	static int x;
	static int y;
	private SaveControl save;
	private static LinkedList<String> studentSelect;
	private static LinkedList<Integer> placeHolder;
	private static JComboBox cmbStudent;
	private static JList lstStudent;
	private static JPanel panel;
	
	public SelectStudent(JFrame frame, int x, int y) {
		this.frame = frame;
		this.x = x;
		this.y = y;
		save = new SaveControl();
		studentSelect = save.setStudentSelect();
		createStudentBox();
		panel = new JPanel(new BorderLayout());
		lstStudent = new JList();
		JButton back = new JButton("Back");
		panel.add(cmbStudent, BorderLayout.NORTH);
		panel.add(lstStudent, BorderLayout.CENTER);
		panel.add(back, BorderLayout.SOUTH);
		
		frame.setContentPane(panel);
		back.addActionListener(new BackListener());
		cmbStudent.addActionListener(new ComboBoxListener());
	}
	
	public static class BackListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {	
			frame.getContentPane().setVisible(false);
			frame.remove(frame.getContentPane());
			new AdminUI(frame, x, y);
		}
	}
	public void createStudentBox() {
		LinkedList<String> cmbName = new LinkedList<String>();
		placeHolder = new LinkedList<Integer>();
		for(int i = 0; i < studentSelect.size(); i++) {
			if(studentSelect.get(i).equals("Name")) {
				cmbName.add(studentSelect.get(i + 1));
				placeHolder.add(i + 1);
			}
		}
		String[] name = new String[cmbName.size()];
		for(int i = 0; i < name.length; i++)
			name[i] = cmbName.get(i);
		cmbStudent = new JComboBox(name);		
	}
	public static class ComboBoxListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			LinkedList<String> cmbName = new LinkedList<String>();
			for(int i = placeHolder.get(cmbStudent.getSelectedIndex());
				i < studentSelect.size(); i++) {
				if(studentSelect.get(i).equals("$"))
					break;
				else
					cmbName.add(studentSelect.get(i));
			}			
			cmbName.removeFirst();
			String[] nameString = new String[cmbName.size()];
			for(int i = 0; i < nameString.length; i++) {
				nameString[i] = cmbName.get(i);
			}
			lstStudent.setListData(nameString);
		}		
	}
}
