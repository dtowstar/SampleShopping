package shoppingCartCommand;


import DAO.cartDAO;//12
import memento.caretaker;
import memento.originator;
//4
public class updatePD_QuantityCommand implements command{
	private int Shop_ID;
	private int totalProduct;
	private int UserID;
	public updatePD_QuantityCommand(int Shop_ID,int totalProduct){
		this.Shop_ID=Shop_ID;
		this.totalProduct=totalProduct;
	}
	public void execute(){
		if(caretaker.firstinit()) {
			UserID=cartDAO.getUserIDByShopID(Shop_ID);
			originator.set(cartDAO.getCartByUser_ID(UserID));
			caretaker.addMemento(originator.saveToMemento());
		}
		cartDAO.updatePD_Quantity(Shop_ID,totalProduct);
		if(caretaker.firstinit()) {
			UserID=cartDAO.getUserIDByShopID(Shop_ID);
			originator.set(cartDAO.getCartByUser_ID(UserID));
			caretaker.addMemento(originator.saveToMemento());
		}
	}
	public int getUserID() {
		return UserID;
	}
	 
}
