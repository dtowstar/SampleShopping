package observer;

import java.util.*;

public abstract class Subject {
	private List<Observer> observers=new ArrayList<Observer>();
	public void attach(Observer observer){    
	observers.add(observer);
	}
	public void detach(Observer observer){    
	observers.remove(observer);
	}
	public void notifyObservers(){ 
		//use iterator
		Iterator<Observer> t=observers.iterator();
        while (t.hasNext()){
        	Observer o=t.next();
        	o.update(this);
        }
	}

}
