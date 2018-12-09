package shoppingCartCommand;
import java.util.*;

import DAO.cartDAO;
import memento.caretaker;
import memento.originator;
public class invoker {
	 private static List<command> history = new ArrayList<command>();//1
	 private static invoker Instance = null;
	 
	   public static invoker createInvoker() {
		   if(Instance==null) {
			   Instance=new invoker();
			   return Instance;
		   }else {
			   return Instance;
		   }
	   }
	   
	   public void storeAndExecute(command cmd) {
	      history.add(cmd); // optional
	      cmd.execute();        
	   }
	   
	   public static List<command> getCommandList(){
		   return history;
	   }
	   
	   public static void setCommandList(List<command> in){
		   history=in;
	   }
	   
}
