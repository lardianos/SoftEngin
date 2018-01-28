package database;

import com.mysql.*;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
			
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("SELECT * FROM Categories");
			while (rs.next())
			{
				comboBox.addItem(rs.getString("Category"));
			}			
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
		
		return 0;
	}
// Method For Select All Points of one Category
	public int select_query_points_of_category() {
		
		
		return 0;
	}
// Method For Select All Data From One Point
	public int select_query_data_of_point() {
		
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
	public int add_point_query() {
		
		return 0;
	}
// Method For deleting category
	public int delete_category_query() {
		return 0;
	}
// Method For deleting point
	public int delete_point_query(){
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
}
