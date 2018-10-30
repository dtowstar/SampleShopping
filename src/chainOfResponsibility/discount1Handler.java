package chainOfResponsibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import discountStrategy.*;
import model.choseDiscountModel;
import model.cart;

public class discount1Handler extends Handler{
	discountParent choseDiscount = null;
	ArrayList<cart> cartlist;
	 public discountParent handlerRequest(choseDiscountModel CORM) {
		 cartlist = CORM.getCartlist();
		 if(cartlist.size()==3 && choseDiscount==null) {
				choseDiscount=new discount1();
				choseDiscount.setcartlist(cartlist);
				return choseDiscount;
		} else {
			Handler next = new noDiscountHandler();
			setSuccessor(next);
			return getSuccessor().handlerRequest(CORM);
        }
    }
}
