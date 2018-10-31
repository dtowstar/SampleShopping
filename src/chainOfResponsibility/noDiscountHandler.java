package chainOfResponsibility;
import java.util.ArrayList;

import discountStrategy.noDiscount;
import discountStrategy.discountParent;
import model.cart;
import model.choseDiscountModel;

public class noDiscountHandler extends Handler{
	discountParent choseDiscount = null;
	ArrayList<cart> cartlist;
	 public discountParent handlerRequest(choseDiscountModel CORM) {
		 cartlist = CORM.getCartlist();
		 if(super.getSuccessor()==null) {
				choseDiscount=new noDiscount();
				choseDiscount.setcartlist(cartlist);
		} 
		 return choseDiscount;
    }
}
