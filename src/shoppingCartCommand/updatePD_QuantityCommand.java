package shoppingCartCommand;

import java.util.ArrayList;

import DAO.cartDAO;
import model.cart;

public class updatePD_QuantityCommand implements command{
	private static ArrayList<cart> UPQL = new ArrayList<cart>();
	private int Shop_ID;
	private int totalProduct;
	public updatePD_QuantityCommand(int Shop_ID,int totalProduct){
		this.Shop_ID=Shop_ID;
		this.totalProduct=totalProduct;
	}
	 public void execute(){
		 cart helfCart = new cart();
		 helfCart.setShop_ID(Shop_ID);
		 helfCart.setShop_Quantity(totalProduct);
		 UPQL.add(helfCart);
		 cartDAO.updatePD_Quantity(Shop_ID,totalProduct);
	   }
	 public static ArrayList<cart> getUPQL(){
		 return UPQL;
	 }
	 
	 public static void setUPQL(ArrayList<cart> in){
		 UPQL=in;
	 }
}
