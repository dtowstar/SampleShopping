package shoppingCartCommand;

import java.util.ArrayList;

import DAO.cartDAO;//12
import model.cart;
import memento.cartlistMemento;
import memento.originator;
import memento.caretaker;

public class deletecartCommand implements command{
	private int Shop_ID;
	private int UserID;
	public deletecartCommand(String Shop_ID){
		this.Shop_ID=Integer.parseInt(Shop_ID);
	}
	
	public void execute(){
		if(caretaker.firstinit()) {
			UserID=cartDAO.getUserIDByShopID(Shop_ID);
			originator.set(cartDAO.getCartByUser_ID(UserID));
			caretaker.addMemento(originator.saveToMemento());
		}
		cartDAO.deleteCart(Shop_ID);
		UserID=cartDAO.getUserIDByShopID(Shop_ID);
		originator.set(cartDAO.getCartByUser_ID(UserID));
		caretaker.addMemento(originator.saveToMemento());
	}
	public int getUserID() {
		return UserID;
	}
	 
}
