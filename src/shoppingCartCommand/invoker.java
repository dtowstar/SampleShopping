package shoppingCartCommand;
import java.util.*;
public class invoker {
	 private List<command> history = new ArrayList<command>();

	   public invoker() {
	   }

	   public void storeAndExecute(command cmd) {
	      this.history.add(cmd); // optional 
	      cmd.execute();        
	   }
}
