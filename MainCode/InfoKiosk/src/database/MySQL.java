package database;

import com.mysql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public int select_query_categories() {
		
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
	
	public int add_category_query() {
		
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
	
}
