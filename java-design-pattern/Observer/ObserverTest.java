package observer;

public class ObserverTest {

	public static void main(String[] args) {
		
		Subject subject = new Subject();
		
		new AObServer(subject);
		new BObServer(subject);
		new CObServer(subject);
		
		subject.setState(7);
	}
}
