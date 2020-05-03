package observer;

import java.util.LinkedList;
import java.util.List;

public class Subject {

	private List<ObServer> Observers = new LinkedList<ObServer>();

	private int state;

	public void setState(int state) {
		this.state = state;
		notifyAllObserver();
	}

	public int getState() {
		return state;
	}

	private void notifyAllObserver() {
		if (Observers.size() > 0) {
			for (ObServer observer : Observers) {
				observer.update();
			}
		}
	}

	public void register(ObServer observer) {
		if (!Observers.contains(observer)) {
			Observers.add(observer);
		}
	}

	public void unregister(ObServer observer) {
		if (Observers.contains(observer)) {
			Observers.remove(observer);
		}
	}

}
