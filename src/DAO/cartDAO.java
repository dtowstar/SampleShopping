package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.cart;//8
//2
public class cartDAO {
	
	public static ArrayList<cart> getCartByUser_ID(int User_ID){
		String sql = "select * from Cart where User_ID = "+User_ID+" ";
		int count = 0;
		ArrayList<cart> cartlist = new ArrayList<cart>();
		try {
		ResultSet rs = databaseDAO.getResult(sql);
		while(rs.next()){
			count+=1;
			cart getcart = new cart();
			getcart.setShop_ID(rs.getInt("Shop_ID"));
			getcart.setUser_ID(rs.getInt("User_ID"));
			getcart.setPD_ID(rs.getInt("PD_ID"));
			getcart.setShop_Quantity(rs.getInt("Shop_Quantity"));
			cartlist.add(getcart);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return cartlist;
	}
	public static String getSelectCase(int PD_ID,int Shop_Quantity) {
		String sql = "select * from Products where PD_ID = "+PD_ID+" ";
		String str = "";
		try {
			ResultSet rs = databaseDAO.getResult(sql);
			while(rs.next()){
				for (int i=1;i<=rs.getInt("PD_Quantity");i++){
					if (i == Shop_Quantity) {
						str +="<option value='"+ i +"' selected>"+ i +"</option> ";
					}else {
						str +="<option value='"+ i +"'>"+ i +"</option> ";
					}
    				
    			}
			}
			}catch(Exception e) {
				System.out.println(e);
			}
		return str;
	}
	
	public static cart getCartByShop_ID(int Shop_ID){
		  String sql = "select * from Cart where Shop_ID = "+Shop_ID+" ";
		  cart getcart = new cart();
		  try {
		  ResultSet rs = databaseDAO.getResult(sql);
		  while(rs.next()){
		   getcart.setShop_ID(rs.getInt("Shop_ID"));
		   getcart.setUser_ID(rs.getInt("User_ID"));
		   getcart.setPD_ID(rs.getInt("PD_ID"));
		   getcart.setShop_Quantity(rs.getInt("Shop_Quantity"));
		  }
		  }catch(Exception e) {
		   System.out.println(e);
		  }
		  return getcart; 
		 }
	public static int getUserIDByShopID(int Shop_ID) {
		String sql = "select User_ID from Cart where Shop_ID = "+Shop_ID+" ";
		int userID=0;
		try {
			  ResultSet rs = databaseDAO.getResult(sql);
			  while(rs.next()){
				  userID=rs.getInt("User_ID");
			  }
			  }catch(Exception e) {
			   System.out.println(e);
			  }
		return userID;
	}
	public static void addcart(String User_ID,String PD_ID,String Quantity) {
		String sql = String.format("insert into Cart(User_ID,PD_ID,Shop_Quantity) values ('%d','%d','%d')",Integer.parseInt(User_ID),Integer.parseInt(PD_ID),Integer.parseInt(Quantity));
		try {
			databaseDAO.useUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void updatePD_Quantity(int Shop_ID,int totalProduct) {
		String sql = String.format("update Cart set Shop_Quantity = '%d' where Shop_ID = '%d' ",totalProduct,Shop_ID);
		try {
			System.out.println("有使用資料庫");
			databaseDAO.useUpdate(sql);
			System.out.println("有使用資料庫1");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void deleteCart(int Shop_ID) {
		String sql = String.format("delete from Cart where Shop_ID = \'"+Shop_ID+"\' ");
		try {
			databaseDAO.useUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void deletebyUserID(int User_ID) {
		String sql = String.format("delete from Cart where User_ID = \'"+User_ID+"\' ");
		try {
			databaseDAO.useUpdate(sql);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static int getSumPrice(cart cart){
		int SumPrice = 0;
		try {
			SumPrice += Integer.parseInt(productsDAO.getPD_Infor(String.valueOf(cart.getPD_ID()), "PD_Price"))*cart.getShop_Quantity();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return SumPrice; 
	}
	
	public static int getTotalPrice(ArrayList<cart> cartlists){
		int TotalPrice = 0;
		try {
			for (cart cartlist:cartlists) {
				TotalPrice += Integer.parseInt(productsDAO.getPD_Infor(String.valueOf(cartlist.getPD_ID()), "PD_Price"))*cartlist.getShop_Quantity();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return TotalPrice; 
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
