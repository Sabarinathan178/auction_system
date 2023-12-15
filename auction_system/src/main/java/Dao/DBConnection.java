package Dao;
import java.util.*;
import java.io.*;
import java.sql.*;
public class DBConnection{
	public static Connection createConnection()
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/mini";
		String user="root";
		String pass="root";
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

}
