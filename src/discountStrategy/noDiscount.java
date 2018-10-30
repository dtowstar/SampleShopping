package discountStrategy;

public class noDiscount extends discountParent{
	public void doDiscount() {
		int afterPrice=0;
		super.calculateSumPrice();
		super.setAfterDiscountPrice(afterPrice);
	}
}
