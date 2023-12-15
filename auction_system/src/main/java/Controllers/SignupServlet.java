package Controllers;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, jakarta.servlet.ServletException 
		   {
			req.getRequestDispatcher("/account.html").forward(req, resp);
		   }
	       public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, jakarta.servlet.ServletException
	       {
	    	   String user=(req.getParameter("Uname"));
	    	   String email=(req.getParameter("email"));
	    	   String pass=(req.getParameter("pwd"));
	    	   System.out.println(user+email+pass);
	    	   try
	   		{
	   		Class.forName("com.mysql.jdbc.Driver");
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
	   		PreparedStatement stmt=con.prepareStatement("insert into signup values(?,?,?)");
	   		((PreparedStatement) stmt).setString(1,user);
	   		((PreparedStatement) stmt).setString(2,email);
	   		((PreparedStatement) stmt).setString(3,pass);
             stmt.executeUpdate();
    	   		}
	   		catch(Exception e)
	   		{
	   			System.out.println(e);
	   		}
	    	  /* PrintWriter out=resp.getWriter();
	           out.println("Welcome to online bidding");  */
	       
	        req.getRequestDispatcher("/index.html").forward(req, resp);
	       }
}
