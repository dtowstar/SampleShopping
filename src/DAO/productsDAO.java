package DAO;

import java.sql.ResultSet;

public class productsDAO {
	private static String PD_Name;
	private static String PD_Brand;
	private static String PD_Type;
	private static String PD_Price;
	private static String PD_Quantity;
	private static String PD_Photo;
	private static String PD_Desc;
	
	public static String getPD_Infor(String PD_ID,String column) {
		String sql = "select * from Products where PD_ID = \'"+PD_ID+"\' ";
		try {
			ResultSet rs = databaseDAO.getResult(sql);
			while(rs.next()){
				PD_Name = rs.getString(2);
				PD_Brand = rs.getString(3);
				PD_Type = rs.getString(4);
				PD_Price = rs.getString(5);
				PD_Quantity = rs.getString(6);
				PD_Photo = rs.getString(7);
				PD_Desc = rs.getString(8);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		switch(column){
			case"PD_Name":
				return PD_Name;
			case"PD_Brand":
				return PD_Brand;
			case"PD_Type":
				return PD_Type;
			case"PD_Price":
				return PD_Price;
			case"PD_Quantity":
				return PD_Quantity;
			case"PD_Photo":
				return PD_Photo;
			case"PD_Desc":
				return PD_Desc;
			default:
				return "";
		}
	}
}
