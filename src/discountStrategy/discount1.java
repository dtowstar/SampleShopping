package discountStrategy;

public class discount1 extends discountParent{
	public void doDiscount() {
		int afterPrice=0;
		int price;
		super.calculateSumPrice();
		price = super.getPrice();
		afterPrice = (price/100)*95;
		super.setAfterDiscountPrice(afterPrice);
	}
}
