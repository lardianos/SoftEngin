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
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminGUI {

	private JFrame frame;
	private JTextField usernametxt;
	private JPasswordField passwordtxt;

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
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 40));
		panel.setBackground(new Color(255, 102, 51));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblLoginForm = new JLabel("Info-Kiosk Managment");
		lblLoginForm.setForeground(Color.WHITE);
		lblLoginForm.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblLoginForm);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 102, 51));
		panel_2.setPreferredSize(new Dimension(400, 10));
		panel_2.setMinimumSize(new Dimension(100, 100));
		panel.add(panel_2);
		
		JLabel lblMin = new JLabel("-");
		lblMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblMin.setForeground(new Color(255, 255, 255));
		lblMin.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblMin);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(20, 10));
		panel_3.setMinimumSize(new Dimension(100, 100));
		panel_3.setBackground(new Color(255, 102, 51));
		panel.add(panel_3);
		
		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblClose.setForeground(new Color(255, 255, 255));
		lblClose.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblClose);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 51));
		panel_1.setForeground(new Color(0, 51, 51));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setBounds(96, 138, 110, 22);
		lblUserName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUserName.setForeground(new Color(255, 255, 255));
		panel_1.add(lblUserName);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(251, 138, 174, 22);
		usernametxt.setFont(new Font("Dialog", Font.PLAIN, 18));
		usernametxt.setMinimumSize(new Dimension(150, 25));
		usernametxt.setPreferredSize(new Dimension(1, 1));
		usernametxt.setForeground(new Color(255, 255, 255));
		usernametxt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		usernametxt.setCaretColor(new Color(255, 255, 255));
		usernametxt.setBackground(new Color(47, 79, 79));
		usernametxt.setMaximumSize(new Dimension(1, 1));
		panel_1.add(usernametxt);
		usernametxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(96, 212, 104, 22);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		panel_1.add(lblPassword);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(251, 210, 174, 25);
		passwordtxt.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordtxt.setForeground(new Color(255, 255, 255));
		passwordtxt.setCaretColor(new Color(255, 255, 255));
		passwordtxt.setBackground(new Color(47, 79, 79));
		passwordtxt.setPreferredSize(new Dimension(1, 1));
		passwordtxt.setMaximumSize(new Dimension(1, 1));
		passwordtxt.setMinimumSize(new Dimension(150, 25));
		panel_1.add(passwordtxt);
		
		JButton btnLogin = new JButton("Cancel");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnLogin.setFocusPainted(false);
		btnLogin.setPreferredSize(new Dimension(1, 1));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(178, 34, 34));
		btnLogin.setBounds(150, 270, 87, 30);
		panel_1.add(btnLogin);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String password = 
			}
		});
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusPainted(false);
		button.setPreferredSize(new Dimension(1, 1));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(270, 270, 87, 30);
		panel_1.add(button);
		
		JLabel lblWelcomeLoginTo = new JLabel("Welcome! Login to Manage Info-Kiosk.");
		lblWelcomeLoginTo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeLoginTo.setForeground(new Color(255, 255, 255));
		lblWelcomeLoginTo.setBounds(51, 51, 398, 38);
		panel_1.add(lblWelcomeLoginTo);
		
		JLabel lblCopyrightTriakilakodikaae = new JLabel("Copyright 2018 Tria-Kila-Kodika-AE.");
		lblCopyrightTriakilakodikaae.setFont(new Font("Dialog", Font.BOLD, 9));
		lblCopyrightTriakilakodikaae.setForeground(new Color(255, 255, 255));
		lblCopyrightTriakilakodikaae.setBounds(162, 333, 184, 15);
		panel_1.add(lblCopyrightTriakilakodikaae);
	}
}
