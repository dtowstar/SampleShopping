package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class singletonConnection {
	private static singletonConnection Instance = new singletonConnection();
	private singletonConnection() {}
	public static singletonConnection getInstance() {
		return Instance;
	}
	public Connection getConnection() {
		Connection conn = null;
		String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String URL="jdbc:sqlserver://localhost:1433;databaseName=SampleShop";
		String USERNAME="sa";
		String PASSWORD="sa";
			 try
			    {
				 	Class.forName(DRIVER);
			        conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			        } catch (Exception e) {
			        	System.out.println("db disconnect");
			            e.printStackTrace();
			        }        
		 return conn;
		} 
}
