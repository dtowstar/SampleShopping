package shoppingCartCommand;

import DAO.cartDAO;

public class deletecartCommand implements command{
	private int Shop_ID;
	public deletecartCommand(String Shop_ID){
		this.Shop_ID=Integer.parseInt(Shop_ID);
	}
	 public void execute(){
		 cartDAO.deleteCart(Shop_ID);
	   }
}
