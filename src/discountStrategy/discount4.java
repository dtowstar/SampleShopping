package discountStrategy;

import DAO.*;
import java.util.ArrayList;

import model.cart;
public class discount4 extends discountParent{
	private ArrayList<cart> cartlist;
	private int productQ;
	private int freeProduct;
	private int sumProductY=0;
	private int User_ID;
	public void doDiscount() {
		cartlist=super.getcartlist();
		for(int i=0; i<cartlist.size(); i++)
		 {
			productQ = Integer.valueOf(cartlist.get(i).getShop_Quantity());
			User_ID = cartlist.get(i).getUser_ID();
			if(productQ>=2)
			{
				freeProduct=productQ/2;
				sumProductY += freeProduct;		
			}
		 }
		if(sumProductY!=0) {
			//增加一個購物車有多少PRODUCTY 產品
			cartDAO.addFreeCart(User_ID,sumProductY);
		}
		int price;
		super.calculateSumPrice();
		price=super.getPrice();
		super.setAfterDiscountPrice(price);
	}
	
}
