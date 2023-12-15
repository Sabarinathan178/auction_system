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
@WebServlet("/sell")
public class SellPageServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, jakarta.servlet.ServletException 
		   {
			req.getRequestDispatcher("/profile.html").forward(req, resp);
		   }
	       public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, jakarta.servlet.ServletException
	       {
	    	    String productName=(req.getParameter("pname"));
	     	    String description=(req.getParameter("desc"));
	     	    String email=(req.getParameter("email"));
	     	    String prod_price=(req.getParameter("pro_price"));
               System.out.println(productName);
	    	   try
	   		{
	   		Class.forName("com.mysql.jdbc.Driver");
	   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","root");
	   		PreparedStatement stmt=con.prepareStatement("insert into product_details values(?,?,?,?)");
	 		 ((PreparedStatement) stmt).setString(1,productName);
	 		 ((PreparedStatement) stmt).setString(2,description);
	 		 ((PreparedStatement) stmt).setString(3,email);
	 		 ((PreparedStatement) stmt).setString(4,prod_price);
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
