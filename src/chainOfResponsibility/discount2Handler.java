package chainOfResponsibility;

import java.util.ArrayList;

import discountStrategy.discount3;
import discountStrategy.discount4;
import discountStrategy.discount2;
import discountStrategy.discountParent;
import model.cart;
import model.choseDiscountModel;

public class discount2Handler extends Handler{
	discountParent choseDiscount = null;
	ArrayList<cart> cartlist;
	int productQ;
	 public discountParent handlerRequest(choseDiscountModel CORM) {
		 cartlist = CORM.getCartlist();
		 for(int i=0;i<cartlist.size();i++)
		 	{
		 		productQ = cartlist.get(i).getShop_Quantity();
		 		if(productQ>=100) {
		 			choseDiscount=new discount2();
		 			choseDiscount.setCartlist(cartlist);
		 		}
		 	}
        if (choseDiscount==null) {
        	Handler next = new discount1Handler();
        	setSuccessor(next);
            return getSuccessor().handlerRequest(CORM);
        }else {
        	return choseDiscount;
        }
    }
}
