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
	private JTextField txtCcKodikasMe;

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
		panel.setLayout(null);
		
		
		JLabel lblLoginForm = new JLabel("Info-Kiosk Managment");
		lblLoginForm.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLoginForm.setSize(302, 29);
		lblLoginForm.setForeground(Color.WHITE);
		lblLoginForm.setFont(new Font("Dialog", Font.BOLD, 24));
		lblLoginForm.setLocation(774, 5);
		panel.add(lblLoginForm);
		
		
				
		JLabel lblMin = new JLabel("-");
		lblMin.setBounds(((int)width-65), 5, 10, 29);
		lblMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblMin.setForeground(new Color(255, 255, 255));
		lblMin.setFont(new Font("Dialog", Font.BOLD, 24));
		
		
		JLabel lblClose = new JLabel("X");
		lblClose.setBounds(((int)width-40), 5, 19, 29);
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblClose.setForeground(new Color(255, 255, 255));
		lblClose.setFont(new Font("Dialog", Font.BOLD, 24));

		
		frontbar.setSize((width/1.3)-(lblLoginForm.getWidth()+lblClose.getWidth()+lblMin.getWidth()), 10);
		
		panel.add(lblMin);
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
		panel_5.setBackground(new Color(51, 51, 51));
		panel_5.setBounds(0, 100, (int) width, 911);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnCreateNewCategory = new JButton("Create New Category");
		btnCreateNewCategory.setFocusTraversalKeysEnabled(false);
		btnCreateNewCategory.setFocusPainted(false);
		btnCreateNewCategory.setForeground(new Color(255, 255, 255));
		btnCreateNewCategory.setBackground(new Color(0, 51, 51));
		btnCreateNewCategory.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreateNewCategory.setBounds(860, 120, 186, 30);
		btnCreateNewCategory.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_5.add(btnCreateNewCategory);
		
		JButton btnCreateNewPoint = new JButton("Create New Point");
		btnCreateNewPoint.setBackground(new Color(0, 51, 51));
		btnCreateNewPoint.setForeground(new Color(255, 255, 255));
		btnCreateNewPoint.setFocusPainted(false);
		btnCreateNewPoint.setFocusTraversalKeysEnabled(false);
		btnCreateNewPoint.setPreferredSize(new Dimension(186, 25));
		btnCreateNewPoint.setMinimumSize(new Dimension(186, 25));
		btnCreateNewPoint.setMaximumSize(new Dimension(186, 25));
		btnCreateNewPoint.setBounds(860, 180, 186, 30);
		btnCreateNewPoint.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCreateNewPoint.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(btnCreateNewPoint);
		
		JButton btnDeleteCategory = new JButton("Delete Category");
		btnDeleteCategory.setBackground(new Color(0, 51, 51));
		btnDeleteCategory.setForeground(new Color(255, 255, 255));
		btnDeleteCategory.setFocusPainted(false);
		btnDeleteCategory.setFocusTraversalKeysEnabled(false);
		btnDeleteCategory.setPreferredSize(new Dimension(186, 25));
		btnDeleteCategory.setMinimumSize(new Dimension(186, 25));
		btnDeleteCategory.setMaximumSize(new Dimension(186, 25));
		btnDeleteCategory.setBounds(860, 240, 186, 30);
		panel_5.add(btnDeleteCategory);
		
		JButton btnDeletePoint = new JButton("Delete Point");
		btnDeletePoint.setBackground(new Color(0, 51, 51));
		btnDeletePoint.setForeground(new Color(255, 255, 255));
		btnDeletePoint.setFocusPainted(false);
		btnDeletePoint.setFocusTraversalKeysEnabled(false);
		btnDeletePoint.setPreferredSize(new Dimension(186, 25));
		btnDeletePoint.setMinimumSize(new Dimension(186, 25));
		btnDeletePoint.setMaximumSize(new Dimension(186, 25));
		btnDeletePoint.setBounds(860, 300, 186, 30);
		panel_5.add(btnDeletePoint);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 860,(int) width, 51);
		panel_5.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		txtCcKodikasMe = new JTextField();
		txtCcKodikasMe.setHorizontalAlignment(SwingConstants.CENTER);
		txtCcKodikasMe.setText("CC Kodikas Me To Tsouvali AE");
		panel_6.add(txtCcKodikasMe, BorderLayout.CENTER);
		txtCcKodikasMe.setColumns(10);
	}
}
