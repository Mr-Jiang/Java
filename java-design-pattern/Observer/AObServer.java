package observer;

public class AObServer extends ObServer {

	public AObServer(Subject subject) {
		this.subject = subject;
		subject.register(this);
	}

	@Override
	public void update() {
		System.out.println("AObServer state : " + subject.getState());
	}

}
