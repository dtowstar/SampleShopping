package DAO;

import java.sql.ResultSet;

public class usersDAO {
	private static int lastYearSpend;
	private static int User_ID;
	private static String User_Name;
	private static String User_Email;
	private static String User_Address;
	private static String User_Type;
	private static String User_Certification;
	private static String User_LastSpend;
	private static String User_SubcribePD;
	
	public static String getUser_Infor(String account,String password,String column) {
		String sql = "select * from users where User_Acc = \'"+account+"\' AND User_Pwd = \'"+password+"\' ";
		try {
			ResultSet rs = databaseDAO.getResult(sql);
			while(rs.next()){
				User_ID = rs.getInt("User_ID");
				User_Name = rs.getString("User_Name");
				User_Email = rs.getString("User_Email");
				User_Address = rs.getString("User_Address");
				User_Type = rs.getString("User_Type");
				User_Certification = rs.getString("User_Certification");
				User_LastSpend = rs.getString("User_LastSpend");
				User_SubcribePD = rs.getString("User_SubcribePD");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		switch(column){
			case"User_ID":
				return String.valueOf(User_ID);
			case"User_Name":
				return User_Name;
			case"User_Email":
				return User_Email;
			case"User_Address":
				return User_Address;
			case"User_Type":
				return User_Type;
			case"User_Certification":
				return User_Certification;
			case"User_LastSpend":
				return User_LastSpend;
			case"User_SubcribePD":
				return User_SubcribePD;
			default:
				return "";
		}
	}
	public static String getUser_Infor_With_UserID(String User_ID,String column) {
		String sql = "select * from Users where User_ID = \'"+User_ID+"\' ";
		try {
			ResultSet rs = databaseDAO.getResult(sql);
			while(rs.next()){
				User_Name = rs.getString("User_Name");
				User_Email = rs.getString("User_Email");
				User_Address = rs.getString("User_Address");
				User_Type = rs.getString("User_Type");
				User_Certification = rs.getString("User_Certification");
				User_LastSpend = rs.getString("User_LastSpend");
				User_SubcribePD = rs.getString("User_SubcribePD");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		switch(column){
			case"User_ID":
				return String.valueOf(User_ID);
			case"User_Name":
				return User_Name;
			case"User_Email":
				return User_Email;
			case"User_Address":
				return User_Address;
			case"User_Type":
				return User_Type;
			case"User_Certification":
				return User_Certification;
			case"User_LastSpend":
				return User_LastSpend;
			case"User_SubcribePD":
				return User_SubcribePD;
			default:
				return "";
		}
	}
	public static int getLastYearSpend(int User_ID) {
		String sql = "select User_LastSpend from Users where User_ID = \'"+User_ID+"\' ";
		try {
		ResultSet rs = databaseDAO.getResult(sql);
		while(rs.next()){
			lastYearSpend=rs.getInt(1);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return lastYearSpend;
	}
	public static boolean confirmUserLogin(String account,String password) {
		int count = 0 ;
		try {
			String sql= "select * from users where User_Acc = \'"+account+"\' AND User_Pwd = \'"+password+"\' ";
			ResultSet rs = databaseDAO.getResult(sql);
			int User_ID = 0;
			String User_Name = "";
			while(rs.next()){
				count++;
				User_ID = rs.getInt("User_ID");
				User_Name = rs.getString("User_Name");
			}
			rs.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		if(count == 0)
		{
			return false;
		}else {
			return true;
		}
	}
}
