package shoppingCartCommand;
import memento.cartlistMemento;
import memento.originator;
import DAO.cartDAO;
import memento.caretaker;
import model.cart;
import java.util.Iterator;
public class redoCommand implements command{
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
