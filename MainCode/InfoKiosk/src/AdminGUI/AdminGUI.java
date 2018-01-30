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

import database.MySQL;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class AdminGUI {

	private JFrame frame;

	//Category Combobox
	private JComboBox CategoryComboBox1 = new JComboBox();
	private JComboBox CategoryComboBox = new JComboBox();
	private JComboBox comboBox = new JComboBox();
	
	private JComboBox EditCategoryComboBox = new JComboBox();	
	//Point Combobox
	JComboBox PointComboBox = new JComboBox();
	JComboBox EditPointCombobox = new JComboBox();
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
		MySQL db = new MySQL();
		db.dbconnect();
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
		
		JLabel lblWelcomeLoginTo = new JLabel("Welcome! Login to Manage Info-Kiosk.");
		lblWelcomeLoginTo.setBounds(0, 0, (int) width, 103);
		lblWelcomeLoginTo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblWelcomeLoginTo);
		lblWelcomeLoginTo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeLoginTo.setForeground(new Color(255, 255, 255));
		
		JLabel lblWelcomeCreatePoint = new JLabel("Create A New Point!");
		lblWelcomeCreatePoint.setBounds(0, 0, (int) width, 103);
		lblWelcomeCreatePoint.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblWelcomeCreatePoint);
		lblWelcomeCreatePoint.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeCreatePoint.setForeground(new Color(255, 255, 255));
		lblWelcomeCreatePoint.setVisible(false);
		
		JLabel lblWelcomeCreateCategory = new JLabel("Create A New Category!");
		lblWelcomeCreateCategory.setBounds(0, 0, (int) width, 103);
		lblWelcomeCreateCategory.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblWelcomeCreateCategory);
		lblWelcomeCreateCategory.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeCreateCategory.setForeground(new Color(255, 255, 255));
		lblWelcomeCreateCategory.setVisible(false);
		
		JLabel lblWelcomeDeletePoint = new JLabel("Delete One Point!");
		lblWelcomeDeletePoint.setBounds(0, 0, (int) width, 103);
		lblWelcomeDeletePoint.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblWelcomeDeletePoint);
		lblWelcomeDeletePoint.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeDeletePoint.setForeground(new Color(255, 255, 255));
		lblWelcomeDeletePoint.setVisible(false);
		
		JLabel lblWelcomeDeleteCategory = new JLabel("Delete One Category!");
		lblWelcomeDeleteCategory.setBounds(0, 0, (int) width, 103);
		lblWelcomeDeleteCategory.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblWelcomeDeleteCategory);
		lblWelcomeDeleteCategory.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeDeleteCategory.setForeground(new Color(255, 255, 255));
		lblWelcomeDeleteCategory.setVisible(false);
		
		JLabel lblWelcomeEditPoint = new JLabel("Edit One Point!");
		lblWelcomeEditPoint.setBounds(0, 0, (int) width, 103);
		lblWelcomeEditPoint.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblWelcomeEditPoint);
		lblWelcomeEditPoint.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeEditPoint.setForeground(new Color(255, 255, 255));
		lblWelcomeEditPoint.setVisible(false);
		
		JLabel lblWelcomeEditCategory = new JLabel("Edit One Category!");
		lblWelcomeEditCategory.setBounds(0, 0, (int) width, 103);
		lblWelcomeEditCategory.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblWelcomeEditCategory);
		lblWelcomeEditCategory.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWelcomeEditCategory.setForeground(new Color(255, 255, 255));
		lblWelcomeEditCategory.setVisible(false);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.desktop);
		panel_3.setBounds(0, 100, (int)width,(int)height-200);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.desktop);
		panel_6.setBounds(0, 100, (int)width,(int)height-200);
		panel_1.add(panel_6);
		panel_6.setVisible(false);
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.desktop);
		panel_7.setBounds(0, 100, (int)width,(int)height-200);
		panel_1.add(panel_7);
		panel_7.setLayout(null);	
		panel_7.setVisible(false);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.desktop);
		panel_8.setBounds(0, 100, (int)width,(int)height-200);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		panel_8.setVisible(false);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 218, 185));
		panel_9.setBounds(0, 100, (int)width,(int)height-200);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		panel_9.setVisible(false);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 127, 80));
		panel_10.setBounds(0, 100, (int)width,(int)height-200);
		panel_1.add(panel_10);
		panel_10.setLayout(null);
		panel_10.setVisible(false);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(51, 51, 51));
		panel_5.setBounds(0, 100, (int)width, (int)height-200);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
	//Back Buttons
		//Back Button 1
		JButton btnBack1 = new JButton("Back");
		btnBack1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_3.setVisible(false);
				panel_5.setVisible(true);
				lblWelcomeCreateCategory.setVisible(false);
				lblWelcomeLoginTo.setVisible(true);
				
				db.select_query_categories(CategoryComboBox1);
				db.select_query_categories(CategoryComboBox);
				db.select_query_categories(comboBox);
				db.select_query_categories(EditCategoryComboBox);	
				db.select_query_points_of_category(PointComboBox);
				db.select_query_points_of_category(EditPointCombobox);
				db.select_query_categories(comboBox);
			}
		});
		btnBack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBack1.setBounds(90, 50, 110, 25);
		btnBack1.setForeground(Color.WHITE);
		btnBack1.setBackground(Color.RED);
		panel_3.add(btnBack1);
		
		JButton btnCreateCategory_1 = new JButton("Create Category");		
		
		btnCreateCategory_1.setBounds(( ( ( int ) width/2)-93), 240, 186, 30);
		btnCreateCategory_1.setForeground(Color.WHITE);
		btnCreateCategory_1.setBackground(new Color(0, 51, 51));
		panel_3.add(btnCreateCategory_1);
		
		JTextField CrateCategorytextField = new JTextField();
		CrateCategorytextField.setBounds(( ( ( int ) width/2)-93), 180, 186, 30);
		CrateCategorytextField.setText(null);
		panel_3.add(CrateCategorytextField);
		CrateCategorytextField.setColumns(10);
		
		JLabel lblCategoryName = new JLabel("Category Name:");
		lblCategoryName.setBounds(( ( ( int ) width/2)-93-130), 180, 186, 30);
		panel_3.add(lblCategoryName);
		
		btnCreateCategory_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String category = CrateCategorytextField.getText();
					db.add_category_query(category);				
					CrateCategorytextField.setText(null);	
			}
		});

		
		
		//Back Button 2
		JButton btnBack2 = new JButton("Back");
		btnBack2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_6.setVisible(false);
				panel_5.setVisible(true);
				lblWelcomeCreatePoint.setVisible(false);
				lblWelcomeLoginTo.setVisible(true);
				db.select_query_categories(CategoryComboBox1);
				db.select_query_categories(CategoryComboBox);
				db.select_query_categories(comboBox);
				db.select_query_categories(EditCategoryComboBox);
				db.select_query_points_of_category(PointComboBox);
				db.select_query_points_of_category(EditPointCombobox);
				db.select_query_categories(comboBox);
			}
		});
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_6.setLayout(null);
		btnBack2.setBounds(90, 50, 110, 25);
		btnBack2.setForeground(Color.WHITE);
		btnBack2.setBackground(Color.RED);
		panel_6.add(btnBack2);
		
		
		//Point text
		JTextField PointTextField = new JTextField();
		PointTextField.setBounds(( ( ( int ) width/2)-93), 180, 186, 30);
		panel_6.add(PointTextField);
		PointTextField.setColumns(10);
		
		//Area text
		JTextField AreaTextField = new JTextField();
		AreaTextField.setBounds(( ( ( int ) width/2)-93), 240, 186, 30);
		panel_6.add(AreaTextField);
		AreaTextField.setColumns(10);
		
		
		CategoryComboBox1.setBounds(( ( ( int ) width/2)-93), 300, 186, 30);
		panel_6.add(CategoryComboBox1);
		CategoryComboBox1.insertItemAt("-none-", 0);		
		db.select_query_categories(CategoryComboBox1);
		
		//Description text
		JTextPane PointDescriptionTextPane = new JTextPane();
		PointDescriptionTextPane.setBounds(( ( ( int ) width/2)-150), 360, 300, 120);
		panel_6.add(PointDescriptionTextPane);
		
		//Button Category create
		JButton btnCreatePoint = new JButton("Create Point");
		
		btnCreatePoint.setBounds(( ( ( int ) width/2)-93), 540, 186, 30);
		btnCreatePoint.setForeground(Color.WHITE);
		btnCreatePoint.setBackground(new Color(0, 51, 51));		
		panel_6.add(btnCreatePoint);
		
		JLabel lblPointCreate = new JLabel("Write Point:");
		lblPointCreate.setBounds(( ( ( int ) width/2)-93-100), 180, 186, 30);
		panel_6.add(lblPointCreate);
		
		JLabel lblAreaCreate = new JLabel("Write Area :");
		lblAreaCreate.setBounds(( ( ( int ) width/2)-93-100), 240, 186, 30);
		panel_6.add(lblAreaCreate);
		
		JLabel lblCategoryPointCreate = new JLabel("Select Category:");
		lblCategoryPointCreate.setBounds(( ( ( int ) width/2)-93-130), 300, 186, 30);
		panel_6.add(lblCategoryPointCreate);
		
		JLabel lblDescriptionCreate = new JLabel("Write Description :");
		lblDescriptionCreate.setBounds(( ( ( int ) width/2)-93-200), 390, 186, 30);
		panel_6.add(lblDescriptionCreate);
		
		
		
		btnCreatePoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String pointcreate = PointTextField.getText();
				String areacreate = AreaTextField.getText();
				String categorycreate = (String) CategoryComboBox1.getSelectedItem();
				String descriptioncreate = PointDescriptionTextPane.getText();				
				db.add_point_query(pointcreate,areacreate,categorycreate,descriptioncreate);	
			}
		});
		
		//Back Button 3
		JButton btnBack3 = new JButton("Back");
		btnBack3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_7.setVisible(false);
				panel_5.setVisible(true);
				lblWelcomeLoginTo.setVisible(true);
				lblWelcomeDeleteCategory.setVisible(false);	
				
				db.select_query_categories(CategoryComboBox1);
				db.select_query_categories(CategoryComboBox);
				db.select_query_categories(comboBox);
				db.select_query_categories(EditCategoryComboBox);
				db.select_query_points_of_category(PointComboBox);
				db.select_query_points_of_category(EditPointCombobox);
				db.select_query_categories(comboBox);
			}
		});
		btnBack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		CategoryComboBox.setBounds(( ( ( int ) width/2)-93), 240, 186, 30);
		panel_7.add(CategoryComboBox);
		panel_3.setVisible(false);			
		db.select_query_categories(CategoryComboBox);
		CategoryComboBox.setSelectedIndex(0);
		
		btnBack3.setBounds(90, 50, 110, 25);
		btnBack3.setForeground(Color.WHITE);
		btnBack3.setBackground(Color.RED);
		panel_7.add(btnBack3);
		
		JButton btnDeleteCategory_1 = new JButton("Delete Category");
		btnDeleteCategory_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String category= (String)CategoryComboBox.getSelectedItem();
				db.delete_category_query(category);				
				db.select_query_categories(CategoryComboBox);				
			}
		});
		btnDeleteCategory_1.setBounds(( ( ( int ) width/2)-93), 360, 186, 30);
		btnDeleteCategory_1.setForeground(Color.WHITE);		
		btnDeleteCategory_1.setBackground(new Color(0, 51, 51));
		panel_7.add(btnDeleteCategory_1);		
		panel_7.setVisible(false);
		
		JLabel lblCategoryDelete = new JLabel("Select Category :");
		lblCategoryDelete.setBounds(( ( ( int ) width/2)-93-130), 240, 186, 30);
		panel_7.add(lblCategoryDelete);

		//Back Button 4
		JButton btnBack4 = new JButton("Back");		
		btnBack4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_8.setVisible(false);
				panel_5.setVisible(true);
				lblWelcomeDeletePoint.setVisible(false);
				lblWelcomeLoginTo.setVisible(true);
				
				db.select_query_categories(CategoryComboBox1);
				db.select_query_categories(CategoryComboBox);
				db.select_query_categories(comboBox);
				db.select_query_categories(EditCategoryComboBox);
				db.select_query_points_of_category(PointComboBox);
				db.select_query_points_of_category(EditPointCombobox);
				db.select_query_categories(comboBox);
				
			}
		});
		btnBack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBack4.setBounds(90, 50, 110, 25);
		btnBack4.setForeground(Color.WHITE);
		btnBack4.setBackground(Color.RED);
		panel_8.add(btnBack4);
		
		JButton btnDeleteThisPoint = new JButton("Delete Point");
		
		btnDeleteThisPoint.setBounds(( ( ( int ) width/2)-93), 360, 186, 30);
		btnDeleteThisPoint.setForeground(Color.WHITE);		
		btnDeleteThisPoint.setBackground(new Color(0, 51, 51));
		panel_8.add(btnDeleteThisPoint);
		
		JLabel lblSelectPoint = new JLabel("Select Point:");
		lblSelectPoint.setBounds(( ( ( int ) width/2)-93-130), 240, 186, 30);
		panel_8.add(lblSelectPoint);
		
		
		PointComboBox.setBounds(( ( ( int ) width/2)-93), 240, 186, 30);
		panel_8.add(PointComboBox);
		panel_8.setVisible(false);
		db.select_query_points_of_category(PointComboBox);
		
		btnDeleteThisPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String Point = (String) PointComboBox.getSelectedItem();
				db.delete_point_query(Point);
				db.select_query_points_of_category(PointComboBox);
			}
		});
		
		//Back Button 5
		JButton btnBack5 = new JButton("Back");		
		btnBack5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_9.setVisible(false);
				panel_5.setVisible(true);
				lblWelcomeEditPoint.setVisible(false);
				lblWelcomeLoginTo.setVisible(true);
				
				db.select_query_categories(CategoryComboBox1);
				db.select_query_categories(CategoryComboBox);
				db.select_query_categories(comboBox);
				db.select_query_categories(EditCategoryComboBox);
				db.select_query_points_of_category(PointComboBox);
				db.select_query_points_of_category(EditPointCombobox);
				db.select_query_categories(comboBox);
				
			}
		});
		btnBack5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
				
		btnBack5.setBounds(90, 50, 110, 25);
		btnBack5.setForeground(Color.WHITE);
		btnBack5.setBackground(Color.RED);
		panel_9.add(btnBack5);

		
		JTextField EditPointTextField = new JTextField();
		EditPointTextField.setColumns(10);
		EditPointTextField.setBounds(( ( ( int ) width/2)-93), 180, 186, 30);
		panel_9.add(EditPointTextField);
		
		JTextField EditAreaTextField = new JTextField();
		EditAreaTextField.setColumns(10);
		EditAreaTextField.setBounds(( ( ( int ) width/2)-93), 240, 186, 30);
		panel_9.add(EditAreaTextField);
			
		
		comboBox.setBounds(( ( ( int ) width/2)-93), 300, 186, 30);
		panel_9.add(comboBox);		
		db.select_query_categories(comboBox);
		
		JTextPane EditDescriptionTextPane = new JTextPane();
		EditDescriptionTextPane.setBounds(( ( ( int ) width/2)-93-110), 360, 400, 180);
		panel_9.add(EditDescriptionTextPane);
		
		JButton btnEditPoint1 = new JButton("Edit Point");
		
		btnEditPoint1.setForeground(Color.WHITE);
		btnEditPoint1.setBackground(new Color(0, 51, 51));
		btnEditPoint1.setBounds(( ( ( int ) width/2)-93), 570, 186, 30);
		panel_9.add(btnEditPoint1);
		
		JLabel label = new JLabel("Write Point:");
		label.setBounds(( ( ( int ) width/2)-93-130), 180, 186, 30);
		panel_9.add(label);
		
		JLabel label_1 = new JLabel("Write Area :");
		label_1.setBounds(( ( ( int ) width/2)-93-130), 240, 186, 30);
		panel_9.add(label_1);
		
		JLabel label_2 = new JLabel("Select Category:");
		label_2.setBounds(( ( ( int ) width/2)-93-130), 300, 186, 30);
		panel_9.add(label_2);
		
		JLabel label_3 = new JLabel("Write Description :");
		label_3.setBounds(( ( ( int ) width/2)-93-250), 430, 186, 30);
		panel_9.add(label_3);
		
		JLabel label_4 = new JLabel("Select Point:");
		label_4.setBounds(( ( ( int ) width/2)-93 - 130), 120, 186, 30);
		panel_9.add(label_4);
		

		EditPointCombobox.setBounds(( ( ( int ) width/2)-93), 120, 186, 30);
		panel_9.add(EditPointCombobox);
		panel_9.setVisible(false);
		db.select_query_points_of_category(EditPointCombobox);
		
		EditPointCombobox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	String point = (String) EditPointCombobox.getSelectedItem();		    	
		    	db.select_query_data_of_point(point,EditPointTextField,EditAreaTextField,comboBox,EditDescriptionTextPane);
		        
		    }
		});
		btnEditPoint1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				db.edit_point_query((String)EditPointCombobox.getSelectedItem(),EditPointTextField.getText(),EditAreaTextField.getText(),(String)comboBox.getSelectedItem(),EditDescriptionTextPane.getText());
			}
		});
		//Back Button 6
		JButton btnBack6 = new JButton("Back");		
		btnBack6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_10.setVisible(false);
				panel_5.setVisible(true);
				lblWelcomeEditCategory.setVisible(false);
				lblWelcomeLoginTo.setVisible(true);
				
				db.select_query_categories(CategoryComboBox1);
				db.select_query_categories(CategoryComboBox);
				db.select_query_categories(comboBox);
				db.select_query_categories(EditCategoryComboBox);
				db.select_query_points_of_category(PointComboBox);
				db.select_query_points_of_category(EditPointCombobox);
				db.select_query_categories(comboBox);
				
			}
		});
		btnBack6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnBack6.setBounds(90, 50, 110, 25);
		btnBack6.setForeground(Color.WHITE);
		btnBack6.setBackground(Color.RED);
		panel_10.add(btnBack6);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(0, 0, 114, 19);
		panel_10.add(textField_2);
		textField_2.setColumns(10);
		panel_10.setVisible(false);
				
		
		EditCategoryComboBox.setBounds(337, 112, 101, 25);
		panel_10.add(EditCategoryComboBox);		
		EditCategoryComboBox.insertItemAt("-none-", 0);		
		db.select_query_categories(EditCategoryComboBox);
		

	//Main Menu Buttons	
		//Create Category Button
		JButton btnCreateNewCategory = new JButton("Create New Category");
		btnCreateNewCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_5.setVisible(false);
				panel_3.setVisible(true);
				lblWelcomeLoginTo.setVisible(false);
				lblWelcomeCreateCategory.setVisible(true);
			}
		});
		btnCreateNewCategory.setFocusTraversalKeysEnabled(false);
		btnCreateNewCategory.setFocusPainted(false);
		btnCreateNewCategory.setForeground(new Color(255, 255, 255));
		btnCreateNewCategory.setBackground(new Color(0, 51, 51));
		btnCreateNewCategory.setHorizontalAlignment(SwingConstants.LEFT);
		btnCreateNewCategory.setBounds( ( ( ( int ) width/2)-93), 120, 186, 30);
		btnCreateNewCategory.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_5.add(btnCreateNewCategory);
		//Create Point Button		
		JButton btnCreateNewPoint = new JButton("Create New Point");
		btnCreateNewPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_5.setVisible(false);
				panel_6.setVisible(true);
				lblWelcomeLoginTo.setVisible(false);
				lblWelcomeCreatePoint.setVisible(true);
			}
		});
		btnCreateNewPoint.setBackground(new Color(0, 51, 51));
		btnCreateNewPoint.setForeground(new Color(255, 255, 255));
		btnCreateNewPoint.setFocusPainted(false);
		btnCreateNewPoint.setFocusTraversalKeysEnabled(false);
		btnCreateNewPoint.setPreferredSize(new Dimension(186, 25));
		btnCreateNewPoint.setMinimumSize(new Dimension(186, 25));
		btnCreateNewPoint.setMaximumSize(new Dimension(186, 25));
		btnCreateNewPoint.setBounds(( ( ( int ) width/2)-93), 180, 186, 30);
		btnCreateNewPoint.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCreateNewPoint.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(btnCreateNewPoint);
		//Delete Category Button		
		JButton btnDeleteCategory = new JButton("Delete Category");
		btnDeleteCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_5.setVisible(false);
				panel_7.setVisible(true);
				lblWelcomeLoginTo.setVisible(false);
				lblWelcomeDeleteCategory.setVisible(true);
			}
		});
		btnDeleteCategory.setBackground(new Color(0, 51, 51));
		btnDeleteCategory.setForeground(new Color(255, 255, 255));
		btnDeleteCategory.setFocusPainted(false);
		btnDeleteCategory.setFocusTraversalKeysEnabled(false);
		btnDeleteCategory.setPreferredSize(new Dimension(186, 25));
		btnDeleteCategory.setMinimumSize(new Dimension(186, 25));
		btnDeleteCategory.setMaximumSize(new Dimension(186, 25));
		btnDeleteCategory.setBounds(( ( ( int ) width/2)-93), 240, 186, 30);
		panel_5.add(btnDeleteCategory);
		//Delete Point Button		
		JButton btnDeletePoint = new JButton("Delete Point");
		btnDeletePoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_5.setVisible(false);
				panel_8.setVisible(true);
				lblWelcomeLoginTo.setVisible(false);
				lblWelcomeDeletePoint.setVisible(true);
			}
		});
		btnDeletePoint.setBackground(new Color(0, 51, 51));
		btnDeletePoint.setForeground(new Color(255, 255, 255));
		btnDeletePoint.setFocusPainted(false);
		btnDeletePoint.setFocusTraversalKeysEnabled(false);
		btnDeletePoint.setPreferredSize(new Dimension(186, 25));
		btnDeletePoint.setMinimumSize(new Dimension(186, 25));
		btnDeletePoint.setMaximumSize(new Dimension(186, 25));
		btnDeletePoint.setBounds(( ( ( int ) width/2)-93), 300, 186, 30);
		panel_5.add(btnDeletePoint);
		//Edit Point Button		
		JButton btnEditPoint = new JButton("Edit Point");
		btnEditPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_5.setVisible(false);
				panel_9.setVisible(true);
				lblWelcomeLoginTo.setVisible(false);
				lblWelcomeEditPoint.setVisible(true);
			}
		});
		btnEditPoint.setBackground(new Color(0, 51, 51));
		btnEditPoint.setForeground(new Color(255, 255, 255));
		btnEditPoint.setFocusPainted(false);
		btnEditPoint.setFocusTraversalKeysEnabled(false);
		btnEditPoint.setPreferredSize(new Dimension(186, 25));
		btnEditPoint.setMinimumSize(new Dimension(186, 25));
		btnEditPoint.setMaximumSize(new Dimension(186, 25));
		btnEditPoint.setBounds(( ( ( int ) width/2)-93), 360, 186, 30);
		panel_5.add(btnEditPoint);
		//Edit Category Button
		JButton btnEditCategory = new JButton("Edit Category");
		btnEditCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_5.setVisible(false);
				panel_10.setVisible(true);
				lblWelcomeLoginTo.setVisible(false);
				lblWelcomeEditCategory.setVisible(true);
				lblWelcomeLoginTo.setVisible(false);
			}
		});
		btnEditCategory.setBackground(new Color(0, 51, 51));
		btnEditCategory.setForeground(new Color(255, 255, 255));
		btnEditCategory.setFocusPainted(false);
		btnEditCategory.setFocusTraversalKeysEnabled(false);
		btnEditCategory.setPreferredSize(new Dimension(186, 25));
		btnEditCategory.setMinimumSize(new Dimension(186, 25));
		btnEditCategory.setMaximumSize(new Dimension(186, 25));
		btnEditCategory.setBounds(( ( ( int ) width/2)-93), 420, 186, 30);
		panel_5.add(btnEditCategory);
		
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
