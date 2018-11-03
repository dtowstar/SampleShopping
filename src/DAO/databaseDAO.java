package DAO;

import java.sql.*;

public class databaseDAO {
	
	private static Connection conn = null;

	public static ResultSet getResult(String SQL) throws SQLException,ClassNotFoundException{
			if(conn == null )
			{
				singletonConnection  one = null ;
				one = one.getInstance();
				conn = one.getConnection();
			}
			Statement stm = conn.createStatement();
			ResultSet re = stm.executeQuery(SQL);
			return re;
		}
	
	public static void useUpdate(String SQL) throws SQLException,
	ClassNotFoundException{
		if(conn == null )
		{
			singletonConnection  one = null ;
			one = one.getInstance();
			conn = one.getConnection();
		}
		Statement stm = conn.createStatement();
		stm.executeUpdate(SQL);
	}
	
}
