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
		
		JLabel label = new JLabel("-");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(20, 10));
		panel_3.setMinimumSize(new Dimension(100, 100));
		panel_3.setBackground(new Color(255, 102, 51));
		panel.add(panel_3);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Dialog", Font.BOLD, 24));
		panel.add(lblX);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 51));
		panel_1.setForeground(new Color(0, 51, 51));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{60, 110, 35, 0, 0, 295, 0};
		gbl_panel_1.rowHeights = new int[]{138, 22, 35, 22, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUserName.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.gridx = 1;
		gbc_lblUserName.gridy = 1;
		panel_1.add(lblUserName, gbc_lblUserName);
		
		textField = new JTextField();
		textField.setMinimumSize(new Dimension(150, 20));
		textField.setPreferredSize(new Dimension(1, 1));
		textField.setForeground(new Color(255, 255, 255));
		textField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField.setCaretColor(new Color(255, 255, 255));
		textField.setBackground(new Color(47, 79, 79));
		textField.setMaximumSize(new Dimension(1, 1));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.NORTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		panel_1.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setCaretColor(new Color(255, 255, 255));
		passwordField.setBackground(new Color(47, 79, 79));
		passwordField.setPreferredSize(new Dimension(1, 1));
		passwordField.setMaximumSize(new Dimension(1, 1));
		passwordField.setMinimumSize(new Dimension(150, 20));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 3;
		panel_1.add(passwordField, gbc_passwordField);
	}
}
