package Controllers;

import java.sql.*;

import Models.UserLogin;
import Dao.DBConnection;

public class LoginDao {

	public String authenticate(UserLogin userlogin) {
		String username=userlogin.getUsername();
		String email=userlogin.getEmail();
		String password=userlogin.getPassword();
		String usernameDB="";
		String emailDB="";
		String passwordDB="";
		try
		{
			Connection con=DBConnection.createConnection();
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery("Select userName,email,password from user");
			while(res.next())
			{
				usernameDB=res.getString("userName");
				emailDB=res.getString("email");
				passwordDB=res.getString("password");
				if(username.equals(usernameDB) && email.equals(emailDB) && password.equals(passwordDB))
				{
					return "valid";
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Invalid user credentials";
		
	}

}
