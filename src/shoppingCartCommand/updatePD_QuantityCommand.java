package shoppingCartCommand;

import DAO.cartDAO;

public class updatePD_QuantityCommand implements command{
	private int Shop_ID;
	private int totalProduct;
	public updatePD_QuantityCommand(int Shop_ID,int totalProduct){
		this.Shop_ID=Shop_ID;
		this.totalProduct=totalProduct;
	}
	 public void execute(){
		 cartDAO.updatePD_Quantity(Shop_ID,totalProduct);
	   }
}
