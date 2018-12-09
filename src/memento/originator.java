package memento;

import java.util.ArrayList;

import model.cart;

public class originator {
	private static ArrayList<cart> originatorState;

	public static void set(ArrayList<cart> state) {
		originatorState = state;
	}

	public static cartlistMemento saveToMemento() {
		return new cartlistMemento(originatorState);
	}

	public static void restoreFromMemento(cartlistMemento cm) {
		originatorState = cm.getSavedState();
	}
}
