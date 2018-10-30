package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.cart;

public class cartDAO {
	
	private static ArrayList<cart> cartlist;
	public static ArrayList<cart> getCartByUser_ID(int User_ID){
		String sql = "select * from Cart where User_ID = \'"+User_ID+"\' ";
		try {
		ResultSet rs = databaseDAO.getResult(sql);
		while(rs.next()){
			cart getcart = new cart();
			getcart.setShop_ID(rs.getInt(1));
			getcart.setUser_ID(rs.getInt(2));
			getcart.setPD_ID(rs.getInt(3));
			getcart.setShop_Quantity(rs.getInt(4));
			cartlist.add(getcart);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return cartlist; 
	}
	public static int getTotalPrice(ArrayList<cart> cartlists){
		try {
		while(rs.next()){
			cart getcart = new cart();
			getcart.setShop_ID(rs.getInt(1));
			getcart.setUser_ID(rs.getInt(2));
			getcart.setPD_ID(rs.getInt(3));
			getcart.setShop_Quantity(rs.getInt(4));
			cartlist.add(getcart);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return cartlist; 
	}
	public static int countcart(String User_ID) {
		int count = 0;
		String sql = "select * from Cart where User_ID = \'"+User_ID+"\' ";
		try {
			ResultSet rs = databaseDAO.getResult(sql);
			while(rs.next()){
				count++;
			}
			}catch(Exception e) {
				System.out.println(e);
			}
		return count;
		
	}
	public static void addcart(String User_ID,String PD_ID,String Quantity) {
		String sql = String.format("insert into Cart(User_ID,PD_ID,Shop_Quantity) values ('%d','%d','%d')",Integer.parseInt(User_ID),Integer.parseInt(PD_ID),Integer.parseInt(Quantity));
		try {
			databaseDAO.useUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static boolean ishascart(String User_ID,String PD_ID) {
		int UID = Integer.parseInt(User_ID);
		int PID = Integer.parseInt(PD_ID);
		String sql = String.format("select * from Cart where User_ID = '%d' AND PD_ID ='%d'",UID,PID);
		System.out.println("comfirm sql do");
		try {
			ResultSet rs = databaseDAO.getResult(sql);
			if (rs.next()) {
				System.out.println("comfirm return true");
				return true;
			}else {
				System.out.println("comfirm return false");
				return false;
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("comfirm return out false");
		return false;
	}
	public static void updatePD_Quantity(int Shop_ID,int totalProduct) {
		String sql = String.format("update Cart set Shop_Quantity = '%d' where PD_ID = \'"+Shop_ID+"\' ",totalProduct);
		try {
			databaseDAO.useUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void addFreeCart(int User_ID,int productY) {
		String sql = String.format("insert into Cart(User_ID,PD_ID,Shop_Quantity) values ('%d',666,'%d')",User_ID,productY);
		try {
			databaseDAO.useUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void deleteFreeCart() {
		String sql = String.format("delete from Cart where PD_ID = 666");
		try {
		databaseDAO.useUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
