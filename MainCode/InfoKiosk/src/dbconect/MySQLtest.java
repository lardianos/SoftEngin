package dbconect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLtest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			// Main code here
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://192.168.2.4:3306/infodb";
			String connectionUser = "root";
			String connectionPassword = "kisamitis2";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,connectionPassword);
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery("SELECT * FROM πίνακας");
			
			while (rs.next())
			{
				String id = rs.getString("id");
				String firstName = rs.getString("name");
				String lastName = rs.getString("surname");
				System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName);
			}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			// Finally code here
		}
		
	}
}