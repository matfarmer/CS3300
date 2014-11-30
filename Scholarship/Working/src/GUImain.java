/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUImain extends JFrame 
{
private static JFrame frame = new JFrame("Scholarship Program");
private static int WINDOW_WIDTH = 800;
private static int WINDOW_HEIGHT= 600;

 private class ButtonListener implements ActionListener
 {   

      @Override
        public void actionPerformed(ActionEvent e) {
    	  frame.getContentPane().setVisible(false);
		  frame.remove(frame.getContentPane());  
		  String actionCommand = e.getActionCommand();
    	  if(actionCommand.equals("Student"))
            {
               StudentGUI student = new StudentGUI(frame, WINDOW_WIDTH, WINDOW_HEIGHT);
            }
            if(actionCommand.equals("Administrator")) 
            {
                AdminLogin admin = new AdminLogin(frame, WINDOW_WIDTH, WINDOW_HEIGHT);
            }
            if(actionCommand.equals("Exit"
            		+ "")) 
            {
                System.exit(0);
            }
        }   
 }
 
 public GUImain()
 {
	 JLabel messageLabel;
	 JButton studentButton;
	 JButton adminButton;
	 JButton exitButton;
	 JPanel panel;
     messageLabel = new JLabel ("                    ****Welcome to the Scholarship system****"
              );
     adminButton = new JButton("Administrator");
     studentButton = new JButton ("Student");
     exitButton = new JButton("Exit");
     panel =  new JPanel();
     panel.setLayout(new GridLayout(4,0));
     panel.add(messageLabel);      
     panel.add(adminButton);
     panel.add(studentButton);
     panel.add(exitButton);
     frame.setContentPane(panel);
     adminButton.addActionListener(new ButtonListener());
     studentButton.addActionListener(new ButtonListener());
     exitButton.addActionListener(new ButtonListener()); 
        
 }    
 
 public static void main(String[] args) throws FileNotFoundException {
	 
	 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	 SaveControl save = new SaveControl();
     new GUImain();
	 frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
     frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
     frame.setVisible(true);
     frame.setResizable(false);
	 
 } 
}
