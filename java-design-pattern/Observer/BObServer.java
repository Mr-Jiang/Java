package observer;

public class BObServer extends ObServer {

	public BObServer(Subject subject) {
		this.subject = subject;
		subject.register(this);
	}

	@Override
	public void update() {
		System.out.println("BObServer state : " + subject.getState());
	}

}
