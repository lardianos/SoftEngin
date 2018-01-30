package UserPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import database.MySQL;
import java.awt.Button;
import javax.swing.JTextArea;

public class UserGUI {

	private JFrame frame;

	//Category Combobox
	private JComboBox CategoryComboBox = new JComboBox();	
	//Point Combobox
	JComboBox PointComboBox = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI window = new UserGUI();
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
	public UserGUI() {
		initialize();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MySQL db = new MySQL();
		db.dbconnect();
		frame = new JFrame();
		frame.setUndecorated(true);		
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
		lblLoginForm.setLocation(20, 0);
		lblLoginForm.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForm.setSize(302, 40);
		lblLoginForm.setForeground(Color.WHITE);
		lblLoginForm.setFont(new Font("Dialog", Font.BOLD, 24));

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
		panel_4.setLayout(null);
		
		JLabel lblWelcomeLoginTo = new JLabel("Welcome! To Info-Kiosk.");
		lblWelcomeLoginTo.setBounds(0, 0, (int) width, 103);
		lblWelcomeLoginTo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblWelcomeLoginTo);
		lblWelcomeLoginTo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeLoginTo.setForeground(new Color(255, 255, 255));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(51, 51, 51));
		panel_5.setBounds(0, 100, (int)width, (int)height-200);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setVisible(false);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(0, 128, 128));
		panel_11.setBounds(0, 100, (int)width, (int)height-200);
		panel_1.add(panel_11);
		panel_11.setLayout(null);
		
		JButton btnWelcome = new JButton("Welcome");
		btnWelcome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_11.setVisible(false);
				panel_5.setVisible(true);
			}
		});
		btnWelcome.setFocusPainted(false);
		btnWelcome.setForeground(new Color(255, 255, 255));
		btnWelcome.setBackground(new Color(139, 0, 0));
		btnWelcome.setBounds(( ( ( int ) width/2)-125), 240, 250, 90);
		panel_11.add(btnWelcome);
		
		JLabel lblSelectCategory = new JLabel("Select Category");
		lblSelectCategory.setForeground(new Color(245, 245, 245));
		lblSelectCategory.setBounds(( (450/2)-93), 60, 186, 30);
		panel_5.add(lblSelectCategory);
		
		JLabel lblSelectPoint = new JLabel("Select Point");
		lblSelectPoint.setForeground(new Color(245, 245, 245));
		lblSelectPoint.setBounds(( (450/2)-93), 180, 186, 30);
		panel_5.add(lblSelectPoint);
		
		JLabel lblTextArea = new JLabel("Description Point");
		lblTextArea.setForeground(new Color(245, 245, 245));
		lblTextArea.setBounds(((int)width+450+200)/2, 210, 186, 30);
		lblTextArea.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_5.add(lblTextArea);
		lblTextArea.setVisible(false);
		
		JLabel lblPointName = new JLabel("Point Name");
		lblPointName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPointName.setForeground(new Color(245, 245, 245));
		lblPointName.setBounds((((int)width-450)/2)+450-125, 10, 250, 30);
		panel_5.add(lblPointName);
		lblPointName.setVisible(false);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Dialog", Font.BOLD, 14));
		lblArea.setForeground(new Color(245, 245, 245));
		lblArea.setBounds(((int)width-450+200)/2, 210, 186, 30);
		panel_5.add(lblArea);
		lblArea.setVisible(false);
		
		JLabel lblArea2 = new JLabel("");
		lblArea2.setBackground(new Color(255, 255, 255));
		lblArea2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblArea2.setForeground(new Color(245, 245, 245));
		lblArea2.setBounds(((int)width-450+200)/2, 240, 186, 30);
		panel_5.add(lblArea2);
		lblArea2.setVisible(false);
		
		JTextPane txtrArea= new JTextPane();
		txtrArea.setText("");
		txtrArea.setBounds(((int)width+450+200)/2, 240, 400, 180);
		panel_5.add(txtrArea);
		txtrArea.setVisible(false);
		
	//Main Menu Buttons	
		//Create Category Button
		db.select_query_categories(CategoryComboBox);
		CategoryComboBox.setBounds(( (450/2)-93), 120, 186, 30);
		panel_5.add(CategoryComboBox);
		
		PointComboBox.setBounds(( (450/2)-93), 240, 186, 30);
		panel_5.add(PointComboBox);
		PointComboBox.setVisible(false);
		lblSelectPoint.setVisible(false);
		
		CategoryComboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	PointComboBox.setVisible(true);		
				lblSelectPoint.setVisible(true);
				lblArea2.setVisible(true);
		    	lblArea.setVisible(true);
		    	lblPointName.setVisible(true);
		    	txtrArea.setVisible(true);
		    	lblTextArea.setVisible(true);
				String category = (String) CategoryComboBox.getSelectedItem();				
				db.select_points_of_category(PointComboBox,category);
		    }
		});
		
		PointComboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {		    	
				String point = (String) PointComboBox.getSelectedItem();				
				db.select_point_data_of_category(point,lblArea2,lblPointName,txtrArea);
		    }
		});
		
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(47, 79, 79));
		panel_13.setBounds(0, 0, 450, 880);
		panel_5.add(panel_13);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(0, 128, 128));
		panel_12.setBounds(450, 0,(int)width-450, (int)height-200);
		panel_5.add(panel_12);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 979, (int)width, 34);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCcKodikasMe = new JLabel("CC Kodikas Me To Tsouvali AE");
		lblCcKodikasMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCcKodikasMe.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_2.add(lblCcKodikasMe, BorderLayout.CENTER);
		
	}
}
