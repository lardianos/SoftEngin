package AdminLoginPackage;

import java.sql.ResultSet;

public class LoginCheck {
	private String theusername= null;
	private String thepassword= null;
	
	public void query_login(String username,String password) {
		ResultSet rs = null;
		try {
			String firstUsername= null;
			String firstPassword = null;
			//rs = stmt.executeQuery("SELECT username,password FROM login where username='"+username+"' and password='"+password+"'");
			while (rs.next())
			{
				firstUsername = rs.getString("username");
				firstPassword = rs.getString("password");
			}
			if( username.equals(firstUsername) && password.equals(firstPassword) ) {
				theusername=firstUsername;
				thepassword=firstPassword;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public String get_username() {
		
		return theusername;
	}
	public String get_password() {
		
		return thepassword;
	}
	
	public int selectdb_query() {
		
		return 0;
	}
	
	public int add_category_query() {
		
		return 0;
	}	
	public int add_point_query() {
		
		return 0;
	}

}
