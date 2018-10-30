package discountStrategy;

public class discount3 extends discountParent{
	public void doDiscount() {
		int afterPrice=0;
		int price;
		super.calculateSumPrice();
		price=super.getPrice();
		afterPrice=(price/100)*80;
		super.setAfterDiscountPrice(afterPrice);
	}
}
