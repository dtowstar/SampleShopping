package chainOfResponsibility;
import discountStrategy.*;
import model.choseDiscountModel;
public abstract class Handler {
	protected Handler successor = null;
    
    public Handler getSuccessor() {
        return successor;
    }
   
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
  
    public abstract discountParent handlerRequest(choseDiscountModel CORM);

}
