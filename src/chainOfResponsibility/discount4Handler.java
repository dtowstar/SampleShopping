package chainOfResponsibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import discountStrategy.discount4;
import discountStrategy.discountParent;
import model.cart;
import model.choseDiscountModel;

public class discount4Handler extends Handler{
	discountParent choseDiscount = null;
	ArrayList<cart> cartlist;
	 public discountParent handlerRequest(choseDiscountModel CORM) {
		 cartlist = CORM.getCartlist();
        if (whetherHoliday(CORM.getDateNowStr())) {
           return choseDiscount;
        } else {
        	Handler next = new discount3Handler();
        	setSuccessor(next);
           return getSuccessor().handlerRequest(CORM);
        }
    }
	 public boolean whetherHoliday(String dateNowStr) {
			List<String> lawHolidays = new ArrayList<String>(Arrays.asList(
		            "2017-01-01", "2017-01-02", "2017-01-27", "2017-01-28",
		            "2017-01-29", "2017-01-30", "2017-01-31", "2017-02-01",
		            "2017-02-02", "2017-04-02", "2017-04-03", "2017-04-04",
		            "2017-04-29", "2017-04-30", "2017-05-01", "2017-05-28",
		            "2017-05-29", "2017-05-30", "2017-10-01", "2017-10-02",
		            "2017-10-03", "2017-10-04", "2017-10-05", "2017-10-06",
		            "2017-10-07", "2017-10-08"));
			 for(int i=0; i<lawHolidays.size(); i++)
				{
				 	String holiday = lawHolidays.get(i);
					if(dateNowStr.equals(holiday))
							{
								choseDiscount=new discount4();
								choseDiscount.setcartlist(cartlist);
								return true;
							}
				}
			 return false;
		}
}
