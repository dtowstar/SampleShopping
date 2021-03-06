package discountStrategy;

import java.text.SimpleDateFormat;
import java.util.*;
import DAO.cartDAO;//12
import DAO.usersDAO;//8
import model.cart;//8
import model.choseDiscountModel;//7
import chainOfResponsibility.Handler;//2
import chainOfResponsibility.discount4Handler;//3
public class determine {
	private  int afterDiscountPrice;
	private  discountParent choseDiscount=null;
	private  String dateNowStr;
	private  int lastYearCost;
	private  ArrayList<cart> cartlist;
	
	public determine(int User_ID){
		
		//找出自己購物車有幾筆
		cartlist = cartDAO.getCartByUser_ID(User_ID);
		//找出自己去年消費
		lastYearCost = usersDAO.getLastYearSpend(User_ID);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateNowStr = sdf.format(date);
		choseDiscountModel CORM = new choseDiscountModel(dateNowStr,lastYearCost,cartlist);
		//使用chainOfResponsibility
		Handler doHandler = new discount4Handler();
		choseDiscount = doHandler.handlerRequest(CORM);
		useDiscount(choseDiscount);
	}
	
	public void useDiscount(discountParent discount) {
		discountOrder usediscountOrder = new discountOrder();
		usediscountOrder.process(discount);
		afterDiscountPrice = discount.getAfterDiscountPrice();
	}

	public int getAfterDiscountPrice() {
		return afterDiscountPrice;
	}
	
}
