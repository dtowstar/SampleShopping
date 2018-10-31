package shoppingCartCommand;
import java.util.*;
public class invoker {
	 private List<command> history = new ArrayList<command>();
	 private static invoker Instance = null;

	   public invoker() {

	   }
	   
	   public static invoker createInvoker() {
		   if(Instance==null) {
			   Instance=new invoker();
			   return Instance;
		   }else {
			   return Instance;
		   }
	   }
	   
	   public void storeAndExecute(command cmd) {
	      this.history.add(cmd); // optional 
	      cmd.execute();        
	   }
}
