package AdminPackage;

import java.awt.EventQueue;

//import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


public class LoginAdminGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdminGUI window = new LoginAdminGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginAdminGUI() {
		initialize();
		//this.setLocationRelativeTo(null);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 60));
		panel.setBackground(new Color(255, 102, 51));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 51));
		panel_1.setForeground(new Color(0, 51, 51));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
	}
}
