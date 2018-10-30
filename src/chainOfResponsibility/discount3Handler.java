package chainOfResponsibility;

import java.util.ArrayList;
import discountStrategy.*;
import model.cart;
import model.choseDiscountModel;

public class discount3Handler extends Handler{
	discountParent choseDiscount = null;
	ArrayList<cart> cartlist;
	 public discountParent handlerRequest(choseDiscountModel CORM) {
		 cartlist = CORM.getCartlist();
        if (CORM.getLastYearCost()>100000) {
        	choseDiscount=new discount3();
			choseDiscount.setcartlist(cartlist);
			return choseDiscount;
        } else {
        	Handler next = new discount2Handler();
        	setSuccessor(next);
           return getSuccessor().handlerRequest(CORM);
        }
    }
}
