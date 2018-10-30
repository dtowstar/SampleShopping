package observer;
import java.util.*;
public class ConcreteObserver implements Observer{
	private String observerState;
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public void update(Subject subject){
		observerState=((ConcreteSubject)subject).getSubjectState();
		System.out.println(name+" get "+observerState);
	}
}
