package discountStrategy;

import DAO.*;
import java.util.ArrayList;

import model.cart;
public class discount4 extends discountParent{
	private ArrayList<cart> cartlist;
	private int productQ;
	private int freeProduct;
	private int sumProductY = 0;
	private int userId;
	public void doDiscount() {
		cartlist = super.getCartlist();
		for(int i = 0; i < cartlist.size(); i++)
		 {
			productQ = cartlist.get(i).getShop_Quantity();
			userId = cartlist.get(i).getUser_ID();
			if(productQ >= 2)
			{
				freeProduct = productQ / 2;
				sumProductY += freeProduct;		
			}
		 }
		if(sumProductY!=0) {
			//增加一個購物車有多少產品 Y
			cartDAO.addFreeCart(userId,sumProductY);
		}
		int price;
		super.calculateSumPrice();
		price = super.getPrice();
		super.setAfterDiscountPrice(price);
	}
	
}
