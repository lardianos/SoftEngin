package AdminPackage;

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


public class LoginAdminGUI {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

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
		frame.setLocationRelativeTo(null);
		
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
		panel.setPreferredSize(new Dimension(10, 40));
		panel.setBackground(new Color(255, 102, 51));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setForeground(Color.WHITE);
		lblLoginForm.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblLoginForm);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 102, 51));
		panel_2.setPreferredSize(new Dimension(250, 10));
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
		
		textField = new JTextField();
		textField.setBounds(251, 138, 174, 22);
		textField.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField.setMinimumSize(new Dimension(150, 25));
		textField.setPreferredSize(new Dimension(1, 1));
		textField.setForeground(new Color(255, 255, 255));
		textField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField.setCaretColor(new Color(255, 255, 255));
		textField.setBackground(new Color(47, 79, 79));
		textField.setMaximumSize(new Dimension(1, 1));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(96, 212, 104, 22);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		panel_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(251, 210, 174, 25);
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setCaretColor(new Color(255, 255, 255));
		passwordField.setBackground(new Color(47, 79, 79));
		passwordField.setPreferredSize(new Dimension(1, 1));
		passwordField.setMaximumSize(new Dimension(1, 1));
		passwordField.setMinimumSize(new Dimension(150, 25));
		panel_1.add(passwordField);
		
		JButton btnLogin = new JButton("Cancel");
		btnLogin.setFocusPainted(false);
		btnLogin.setPreferredSize(new Dimension(1, 1));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(178, 34, 34));
		btnLogin.setBounds(150, 270, 87, 30);
		panel_1.add(btnLogin);
		
		JButton button = new JButton("Login");
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusPainted(false);
		button.setPreferredSize(new Dimension(1, 1));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(270, 270, 87, 30);
		panel_1.add(button);
	}
}
