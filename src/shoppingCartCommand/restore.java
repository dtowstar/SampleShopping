package shoppingCartCommand;

import java.util.List;

import DAO.databaseDAO;
import DAO.cartDAO;
import java.util.ArrayList;
import model.cart;

public class restore {
	public static void useRestore() {
		 List<command> history = invoker.getCommandList();
		 ArrayList<cart> DC = deletecartCommand.getDC();
		 ArrayList<cart> UCQ = updatePD_QuantityCommand.getUPQL();
		 int historyL = history.size();
		 int DCL = DC.size();
		 int UCQL = UCQ.size();
		 if(historyL!=0) {
			 command RC = history.get(historyL-1);
			 history.remove(historyL-1);
			 invoker.setCommandList(history);
			 if(RC instanceof deletecartCommand) {
				 cart gDC = DC.get(DCL-1);
				 DC.remove(DCL-1);
				 deletecartCommand.setDC(DC);
				 System.out.println("有執行DRESTORE");
				 cartDAO.addcart(String.valueOf(gDC.getUser_ID()),String.valueOf(gDC.getPD_ID()),String.valueOf(gDC.getShop_Quantity()));
				 System.out.println("執行DRESTOREDB成功");
			 }
			 else {
				 cart gUCQ = UCQ.get(UCQL-1);
				 UCQ.remove(UCQL-1);
				 updatePD_QuantityCommand.setUPQL(UCQ);
				 cartDAO.updatePD_Quantity(gUCQ.getShop_ID(),gUCQ.getShop_Quantity());
			 }
		 }
	}
}
