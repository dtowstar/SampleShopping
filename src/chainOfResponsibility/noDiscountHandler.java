package chainOfResponsibility;
import java.util.ArrayList;

import discountStrategy.noDiscount;
import discountStrategy.discountParent;
import model.cart;
import model.choseDiscountModel;

public class noDiscountHandler extends Handler{//3
	discountParent choseDiscount = null;//8
	ArrayList<cart> cartlist;//8
	 public discountParent handlerRequest(choseDiscountModel CORM) {
		 cartlist = CORM.getCartlist();
		 if(super.getSuccessor()==null) {
				choseDiscount=new noDiscount();//3
				choseDiscount.setcartlist(cartlist);
		} 
		 return choseDiscount;
    }
}
