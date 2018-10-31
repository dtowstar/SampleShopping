package shoppingCartCommand;

import DAO.cartDAO;
import model.cart;
import java.util.ArrayList;
public class deletecartCommand implements command{
	private int Shop_ID;
	private static ArrayList<cart> DC = new ArrayList<cart>();
	public deletecartCommand(String Shop_ID){
		this.Shop_ID=Integer.parseInt(Shop_ID);
	}
	
	 public void execute(){
		 DC.add(cartDAO.getCartByShop_ID(Shop_ID));
		 System.out.println("DL"+" "+DC);
		 cartDAO.deleteCart(Shop_ID);
	 }
	 
	 public static ArrayList<cart> getDC(){
		 return DC;
	 }
	 
	 public static void setDC(ArrayList<cart> in){
		 DC=in;
	 }
	 
	 
}
