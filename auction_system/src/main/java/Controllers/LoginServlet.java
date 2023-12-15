package Controllers;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Dao.DBConnection;
import Models.UserLogin;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		req.getRequestDispatcher("/products.html").forward(req, res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
 
    {
	   String user=(req.getParameter("Uname"));
 	   String email=(req.getParameter("email"));
 	   String pass=(req.getParameter("pwd"));
 	   String usernameDB="";
	   String emailDB="";
	   String passwordDB="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("Select userName,email,password from signup");
			while(result.next())
			{
				usernameDB=result.getString("userName");
				emailDB=result.getString("email");
				passwordDB=result.getString("password");
				if(user.equals(usernameDB) && email.equals(emailDB) && pass.equals(passwordDB))
				{
					req.getRequestDispatcher("/products.html").forward(req, res);
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/account.html").forward(req, res);
		return;
		
	}
       
	  /* if(userValidate.equals("Valid"))
	   {
		   HttpSession session=req.getSession();
		   session.setAttribute("username",user);
		   System.out.println("\nSession created successfully");
	   }
	   else
	   {
		   System.out.println("Invalid user");
	   }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
       
    }*/

}
