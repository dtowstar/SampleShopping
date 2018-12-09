package shoppingCartCommand;

import java.util.Iterator;

import DAO.cartDAO;
import memento.caretaker;
import memento.cartlistMemento;
import model.cart;

public class undoCommand implements command{
	cartlistMemento redoMemento;
	public void execute(){
		redoMemento=caretaker.redoAddMemento();
		cart c=(cart)redoMemento.getSavedState().get(0);
		cartDAO.deletebyUserID(c.getUser_ID());
		Iterator i= (redoMemento.getSavedState()).iterator();
		while (i.hasNext()) {  
			c=(cart)i.next();
			cartDAO.addcart(String.valueOf(c.getUser_ID()), String.valueOf(c.getPD_ID()), String.valueOf(c.getShop_Quantity()));
		}
	}
}
