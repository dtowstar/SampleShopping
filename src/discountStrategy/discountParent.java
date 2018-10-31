package discountStrategy;

import java.util.ArrayList;
import DAO.productsDAO;
import model.cart;

public abstract class discountParent {
	private int sumPrice;
	private ArrayList<cart> cartlist;
	int afterDiscountPrice=0;
	
	public int getAfterDiscountPrice() {
		return afterDiscountPrice;
	}

	public void setAfterDiscountPrice(int afterDiscountPrice) {
		this.afterDiscountPrice = afterDiscountPrice;
	}

	public ArrayList<cart> getCartlist() {
		return cartlist;
	}

	public void setCartlist(ArrayList<cart> cartlist) {
		this.cartlist = cartlist;
	}

	public void setPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getPrice() {
	
		return sumPrice;
		
	}
	public void calculateSumPrice() {
		 int productQ;
		 int productPrice;
		 int totalPrice=0;
		 for(int i = 0; i < cartlist.size(); i++)
		 {
			productQ = cartlist.get(i).getShop_Quantity();
			int PD_ID = cartlist.get(i).getPD_ID();
			productPrice = Integer.parseInt(productsDAO.getPD_Infor(Integer.toString(PD_ID), "PD_Price"));
			totalPrice += (productQ * productPrice);
		 }
		 
		 setPrice(totalPrice);
	}
	public abstract void doDiscount();

}
