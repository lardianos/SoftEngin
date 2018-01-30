package database;

import com.mysql.*;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MySQL {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	private String theusername= null;
	private String thepassword= null;

// Method For Conection with database	
	public void dbconnect() {
		try
		{
			// Main code here
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://127.0.0.1:3306/infodb";
			String connectionUser = "root";
			String connectionPassword = "kisamitis2";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,connectionPassword);		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
	
// Method For Checking login data	
	public boolean check_login(String username,String password) {
		try {
			String firstUsername= null;
			String firstPassword = null;
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("SELECT username,password FROM login where username='"+username+"' and password='"+password+"'");
			while (rs.next())
			{
				firstUsername = rs.getString("username");
				firstPassword = rs.getString("password");
			}
			if( username.equals(firstUsername) && password.equals(firstPassword) ) {
				theusername=firstUsername;
				thepassword=firstPassword;
				return true;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;		
	}
	
// Method For Select all suported categories
	public int select_query_categories(JComboBox comboBox) {
		try {
			comboBox.removeAllItems();
			comboBox.insertItemAt("-none-", 0);
			
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("SELECT * FROM Categories");
			while (rs.next())
			{
				comboBox.addItem(rs.getString("Category"));
			}
			comboBox.setSelectedIndex(0);
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
		
		return 0;
	}
	
// Method For Select All Points of one Category
	public int select_query_points_of_category(JComboBox comboBox) {
		try {
			comboBox.removeAllItems();
			comboBox.insertItemAt("-none-", 0);
			
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("SELECT * FROM Points");
			while (rs.next())
			{
				comboBox.addItem(rs.getString("Point"));
			}
			comboBox.setSelectedIndex(0);
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
		
		return 0;

	}
	
// Method For Select All Data From One Point
	public int select_query_data_of_point(String point, JTextField editPointTextField, JTextField editAreaTextField, JComboBox comboBox, JTextPane editDescriptionTextPane) {
		try {
			
			comboBox.removeAllItems();	
			select_query_categories(comboBox);
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("SELECT * FROM Points INNER JOIN Categories ON Categories.Category_ID = Points.Category_ID WHERE Point='"+point+"'");

			while (rs.next())
			{
				editPointTextField.setText(rs.getString("Point"));
				editAreaTextField.setText(rs.getString("Area"));
				comboBox.insertItemAt(rs.getString("Category"), 0);
				editDescriptionTextPane.setText(rs.getString("Point_Description"));
			}
			
			comboBox.setSelectedIndex(0);
			
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
		return 0;		
	}
	
// Method For adding new category	
	public int add_category_query(String category) {
		try {
			
		    if(!category.equals("") && category_exist_query(category)==0) {		    	  
		    	// the mysql insert statement
			    String query = " INSERT INTO Categories (Category) VALUES(?)";
			    // create the mysql insert preparedstatement
			    PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
			    preparedStmt.setString (1, category);
			    // execute the preparedstatement
			    preparedStmt.execute();
			    if(category_exist_query(category)==1) {
			    	JOptionPane.showMessageDialog(null, "Successful Crate Category!","Successful!",JOptionPane.INFORMATION_MESSAGE);
			    }			     									
		    }
		    else {
		    	JOptionPane.showMessageDialog(null, "Invalid Category Details","Create Category Error",JOptionPane.ERROR_MESSAGE);
		    }
		} 
		catch (Exception e) {
			e.printStackTrace();	
			JOptionPane.showMessageDialog(null, "Invalid Category Details","Create Category Error",JOptionPane.ERROR_MESSAGE);
		}
		
		return 0;
	}
	
// Method For adding new point	
	public int add_point_query(String pointcreate, String areacreate, String categorycreate, String descriptioncreate) {
		try {
			if(!pointcreate.equals("") && !areacreate.equals("") && !categorycreate.equals("") && !categorycreate.equals(null) && point_exist_query(pointcreate)==0) {
				int categoryid=get_category_id(categorycreate);	
				// the mysql insert statement
				String query = " INSERT INTO Points (Point,Point_Description,Popularity,Category_ID,Area) VALUES(?,?,?,?,?)";
				// create the mysql insert preparedstatement
				PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
				preparedStmt.setString (1, pointcreate);
				preparedStmt.setString (2, descriptioncreate);
				preparedStmt.setInt (3, 0);
				preparedStmt.setInt (4, categoryid);
				preparedStmt.setString (5, areacreate);
				// execute the preparedstatement
				preparedStmt.execute();
				if(point_exist_query(pointcreate)==1) {
					JOptionPane.showMessageDialog(null, "Successful Crate Point!","Successful!",JOptionPane.INFORMATION_MESSAGE);
				}			     									
				}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Point Details","Create Point Error",JOptionPane.ERROR_MESSAGE);
			}	
		}
		catch (Exception e){
			e.printStackTrace();	
			JOptionPane.showMessageDialog(null, "Invalid Point Details","Create Point Error",JOptionPane.ERROR_MESSAGE);			
		}
		return 0;
	}
	
// Method For getting category id	
	public int get_category_id(String categorycreate) {
		int categoryid = 0;		
		try {			
			if(categorycreate!=null) {
				stmt = conn.createStatement(); 
				rs = stmt.executeQuery("SELECT Category_ID FROM Categories Where Category='"+categorycreate+"'");
				if(rs.next()) {
					categoryid = rs.getInt("Category_ID");
				}
				else {
					categoryid=0;
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
		return categoryid;			
	}

// Method For deleting category
	public int delete_category_query(String category) {
		try {
			// the mysql insert statement
			String query = " DELETE FROM Categories WHERE Category = ?";
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);			
			preparedStmt.setString (1, category);
			// execute the preparedstatement
			preparedStmt.execute();
			if(category_exist_query(category)==0) {
				JOptionPane.showMessageDialog(null, "Successful Delete Category!","Successful!",JOptionPane.INFORMATION_MESSAGE);				
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Delete Details","Delete Point Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e) {
			e.printStackTrace();	
			JOptionPane.showMessageDialog(null, "Invalid Delete Details","Delete Point Error",JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
// Method For deleting point
	public int delete_point_query(String point){
		try {
			// the mysql insert statement
			String query = " DELETE FROM Points WHERE Point = ?";
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);			
			preparedStmt.setString (1, point);
			// execute the preparedstatement
			preparedStmt.execute();
			if(point_exist_query(point)==0) {
				JOptionPane.showMessageDialog(null, "Successful Delete Category!","Successful!",JOptionPane.INFORMATION_MESSAGE);				
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Delete Details","Delete Point Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e) {
			e.printStackTrace();	
			JOptionPane.showMessageDialog(null, "Invalid Delete Details","Delete Point Error",JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	
// Method For Category check, Return 0 if category dose not exist and Return 1 if exist 
	public int category_exist_query(String category) {
		String cat = null;
		try {
			
			if(category!=null&&category!="") {
				stmt = conn.createStatement(); 
				rs = stmt.executeQuery("SELECT Category FROM Categories Where Category='"+category+"'");
				if(rs.next()) {
					cat = rs.getString("Category");
				}
				else {
					cat=null;
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
		if( category.equals(cat) && cat!=null ) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
// Method For Point check, Return 0 if point dose not exist and Return 1 if exist 
	public int point_exist_query(String point) {
		String pnt = null;
		try {
			
			if(point!=null&&point!="") {
				stmt = conn.createStatement(); 
				rs = stmt.executeQuery("SELECT Point FROM Points Where Point='"+point+"'");
				if(rs.next()) {
					pnt = rs.getString("Point");
				}
				else {
					pnt=null;
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
		if( point.equals(pnt) && pnt!=null ) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
// Method For Edit Points
	public void edit_point_query(String point, String edpoint, String edarea, String edcategory, String eddescription) {
		try {		
			int cat_id=0;
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("SELECT * FROM Categories WHERE Category='"+edcategory+"'");
			while (rs.next())
			{
				cat_id=rs.getInt("Category_ID");
			}
			
			// the mysql insert statement
			String query = " UPDATE Points SET Point = ?,Point_Description = ?,Category_ID = ?,Area = ? WHERE Point =?";
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);			
			preparedStmt.setString (1,edpoint);
			preparedStmt.setString (2,eddescription);
			preparedStmt.setInt (3,cat_id);
			preparedStmt.setString (4,edarea);
			preparedStmt.setString (5,point);			
			// execute the preparedstatement
			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Successful Edited Point!","Successful!",JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}		
	}
	public void edit_category_query(String selectedItem, String text) {		
		try {		
			
			// the mysql insert statement
			String query = " UPDATE Categories SET Category = ? WHERE Category =?";
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);			
			preparedStmt.setString (1,text);
			preparedStmt.setString (2,selectedItem);
			
			// execute the preparedstatement
			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Successful Edited Category!","Successful!",JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
	}

	public void select_point_data_of_category(String point, JLabel lblArea2, JLabel lblPointName, JTextPane txtrArea) {
		try {			
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("SELECT * FROM Points WHERE Point='"+point+"'");
			
			while (rs.next())
			{
				lblArea2.setText(rs.getString("Area"));
				lblPointName.setText(rs.getString("Point"));
				txtrArea.setText(rs.getString("Point_Description"));
			}
			

		} 
		catch (Exception e) {
			e.printStackTrace();			
		}	
		
	}

	public void select_points_of_category(JComboBox pointComboBox, String category) {
		try {			
			pointComboBox.removeAllItems();	
			pointComboBox.insertItemAt("none", 0);
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("SELECT * FROM Points INNER JOIN Categories ON Categories.Category_ID = Points.Category_ID WHERE Category='"+category+"'");
			
			while (rs.next())
			{
				pointComboBox.addItem(rs.getString("Point"));
			}
			
			pointComboBox.setSelectedIndex(0);
			
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}		
	}
}

