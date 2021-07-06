package youtunes.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcManager 
{
	private String jdbcUrl;
	private String jdbcUserName; 
	private String jdbcPassword;
	
	public JdbcManager() 
	{
		jdbcUrl = "jdbc:mysql://localhost:3306/youtunes?useSSL=false";
		jdbcUserName = "youtunes_user";
		jdbcPassword = "MySQL5IsGreat!";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println(ex.toString());
		}
	}
	
	public Connection getConn() 
	{
		Connection conn = null;
		
		System.out.println("jdbcUrl: " + jdbcUrl + "; jdbcUserName: " + jdbcUserName + "; jdbcPassword: " + jdbcPassword);
		
		try 
		{
			conn = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
		}
		catch (SQLException ex) 
		{
			System.out.println("Inside catch block of JdbcManager class");
			System.out.println("Could not connect to DB: " + ex.getMessage());
		}
		
		return conn;
	}
	
	public void closeConn(Connection conn) 
	{
		if (conn != null) 
		{
			try 
			{
				conn.close();
			}
			catch (SQLException ex)
			{
				System.out.println("Could not close DB connection: " + ex.getMessage());
			}
		}
	}
}
