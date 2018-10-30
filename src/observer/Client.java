package observer;

public class Client {

	public static void main(String[] args) {
		ConcreteSubject s=new ConcreteSubject();
		Observer A=new ConcreteObserver();
		A.setName("A");
		Observer B=new ConcreteObserver();
		B.setName("B");
		Observer C=new ConcreteObserver();
		C.setName("C");
		
		s.attach(A);
		s.attach(B);
		s.attach(C);
		
		s.setSubjectState("message  ya ya ya!");

	}

}
