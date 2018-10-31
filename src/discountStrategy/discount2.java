package discountStrategy;

import DAO.productsDAO;

public class discount2 extends discountParent{
	public void doDiscount() {
		int productQ;
		int productPrice;
		int sumPrice=0;
			for(int i=0; i<super.getCartlist().size(); i++)
			{
				productQ = Integer.valueOf(super.getCartlist().get(i).getShop_Quantity());
				int PD_ID = super.getCartlist().get(i).getPD_ID();
				String PD_IDS = String.valueOf(PD_ID);
				productPrice = Integer.parseInt(productsDAO.getPD_Infor(PD_IDS,"PD_Price"));
				if(productQ>=100) {
					sumPrice+=(productQ*productPrice)*0.85;
				}else {
				sumPrice+=(productQ*productPrice);
				}
			}
			super.setAfterDiscountPrice(sumPrice);
	}
}
