package DAO;

public class orderDAO {
	
	public static void addorder(String User_ID,String PD_ID,String Quantity,String paymethod,String Invoice) {
		String sql = String.format("insert into Orders (User_ID,PD_ID,Order_Quantity,Order_Payment,Order_Invoice) values ('%d','%d','%d','%s','%s')",Integer.parseInt(User_ID),Integer.parseInt(PD_ID),Integer.parseInt(Quantity),paymethod,Invoice);
		System.out.println(sql);
		try {
			databaseDAO.useUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
