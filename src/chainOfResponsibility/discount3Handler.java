package chainOfResponsibility;

import java.util.ArrayList;

import discountStrategy.*;
import model.cart;
import model.choseDiscountModel;

public class discount3Handler extends Handler{//3
	discountParent choseDiscount = null;//8
	ArrayList<cart> cartlist;//8
	 public discountParent handlerRequest(choseDiscountModel CORM) {//7
		 cartlist = CORM.getCartlist();
        if (CORM.getLastYearCost()>100000) {
        	choseDiscount=new discount3();
			choseDiscount.setcartlist(cartlist);
			return choseDiscount;
        } else {
        	Handler next = new discount2Handler();//3
        	setSuccessor(next);
           return getSuccessor().handlerRequest(CORM);
        }
    }
}
