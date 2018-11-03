package chainOfResponsibility;

import java.util.ArrayList;

import discountStrategy.*;
import model.choseDiscountModel;
import model.cart;

public class discount1Handler extends Handler{//3
	discountParent choseDiscount = null;//8
	ArrayList<cart> cartlist;//8
	 public discountParent handlerRequest(choseDiscountModel CORM) {
		 cartlist = CORM.getCartlist();
		 if(cartlist.size()==3 && choseDiscount==null) {
				choseDiscount=new discount1();
				choseDiscount.setcartlist(cartlist);
				return choseDiscount;
		} else {
			Handler next = new noDiscountHandler();//3
			setSuccessor(next);
			return getSuccessor().handlerRequest(CORM);
        }
    }
}
