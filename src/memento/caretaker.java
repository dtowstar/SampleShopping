package memento;

import java.util.ArrayList;

public class caretaker {
	private static ArrayList<cartlistMemento> savedStates = new ArrayList<cartlistMemento>();
	private static int index;
	public static void addMemento(cartlistMemento m) {
		index= Integer.valueOf(savedStates.size()-1);
		savedStates.add(m);
	}
	
	public static cartlistMemento undoAddMemento() {
		if(index>0) {
		index= index-1;
		}
		addMemento(getMemento(index));
		return getMemento(index);
	}
	
	public static cartlistMemento redoAddMemento() {
		if(index<savedStates.size()) {
			index= index+1;
		}
		addMemento(getMemento(index));
		return getMemento(index);
	}

	public static cartlistMemento getMemento(int index) {
		return savedStates.get(index);
	}
	
	public static Boolean firstinit() {
		if(savedStates.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
}
