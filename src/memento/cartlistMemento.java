package memento;

import java.util.ArrayList;

import model.cart;

public class cartlistMemento {
	private ArrayList<cart> state;
	public cartlistMemento(ArrayList<cart> inputState) {
		
		state = inputState;
	}

	public ArrayList<cart> getSavedState() {
		return state;
	}
}
