package discountStrategy;

import java.util.ArrayList;
import DAO.productsDAO;
import model.cart;

public abstract class discountParent {
	private int sumPrice;
	private  ArrayList<cart> cartlist;
	int afterDiscountPrice=0;
	public int getAfterDiscountPrice() {
		return afterDiscountPrice;
	}

	public void setAfterDiscountPrice(int afterDiscountPrice) {
		this.afterDiscountPrice = afterDiscountPrice;
	}

	public ArrayList<cart> getcartlist() {
		return cartlist;
	}

	public void setcartlist(ArrayList<cart> cartlist) {
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
		 int sumPrice=0;
		 for(int i=0; i<cartlist.size(); i++)
		 {
			productQ = Integer.valueOf(cartlist.get(i).getShop_Quantity());
			int PD_ID = cartlist.get(i).getPD_ID();
			productPrice = Integer.parseInt(productsDAO.getPD_Infor(Integer.toString(PD_ID),"PD_Price"));
			sumPrice+=(productQ*productPrice);
		 }
		 setPrice(sumPrice);
	}
	public abstract void doDiscount();

}
