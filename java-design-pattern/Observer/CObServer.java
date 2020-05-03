package observer;

public class CObServer extends ObServer {

	public CObServer(Subject subject) {
		this.subject = subject;
		subject.register(this);
	}

	@Override
	public void update() {
		System.out.println("CObServer state : " + subject.getState());
	}

}
