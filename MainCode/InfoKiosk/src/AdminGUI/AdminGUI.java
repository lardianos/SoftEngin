package AdminGUI;

import java.awt.EventQueue;

//import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout.Alignment;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI window = new AdminGUI();
					
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
	public AdminGUI() {
		initialize();
		frame.setLocationRelativeTo(null);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		//frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		/*dimensions*/
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		Dimension frontbar=new Dimension(); 

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 40));
		panel.setBackground(new Color(255, 102, 51));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		
		JLabel lblLoginForm = new JLabel("Info-Kiosk Managment");
		lblLoginForm.setForeground(Color.WHITE);
		lblLoginForm.setFont(new Font("Dialog", Font.BOLD, 24));
		lblLoginForm.setLocation(10, 5);
		panel.add(lblLoginForm);
		
		
				
		JLabel lblMin = new JLabel("-");
		lblMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblMin.setForeground(new Color(255, 255, 255));
		lblMin.setFont(new Font("Dialog", Font.BOLD, 24));
		
		
		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblClose.setForeground(new Color(255, 255, 255));
		lblClose.setFont(new Font("Dialog", Font.BOLD, 24));

		
		frontbar.setSize((width/1.3)-(lblLoginForm.getWidth()+lblClose.getWidth()+lblMin.getWidth()), 10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 102, 51));		
		panel_2.setPreferredSize(frontbar);
		panel_2.setMinimumSize(new Dimension(100, 100));
		panel.add(panel_2);
		
		panel.add(lblMin);
		
				
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(20, 10));
		panel_3.setMinimumSize(new Dimension(100, 100));
		panel_3.setBackground(new Color(255, 102, 51));
		panel.add(panel_3);
		panel.add(lblClose);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 51));
		panel_1.setForeground(new Color(0, 51, 51));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, (int) width, 103);
		panel_4.setBackground(new Color(0, 51, 51));
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWelcomeLoginTo = new JLabel("Welcome! Login to Manage Info-Kiosk.");
		lblWelcomeLoginTo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblWelcomeLoginTo, BorderLayout.CENTER);
		lblWelcomeLoginTo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeLoginTo.setForeground(new Color(255, 255, 255));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 102, 1920, 911);
		panel_1.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
	}
}
