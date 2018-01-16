package dbconect;

import com.mysql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {
	Connection conn = null;
	Statement stmt = null;
	//ResultSet rs = null;
	private String theusername= null;
	private String thepassword= null;
	
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
	
	
}
