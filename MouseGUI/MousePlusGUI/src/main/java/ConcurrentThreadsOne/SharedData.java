package ConcurrentThreadsOne;

public class SharedData {
	// It is the shared data according to wich the threads are working with
	private volatile boolean flag = false;

	//  Only one thread can call it
	// Setting the flag as true
	public synchronized void setFlag() {
		this.flag = true;
		notify();
	}

	public synchronized void removeFlag(){
		this.flag = false;
		notify();
	}

	// This is to just get the flag variable
	public synchronized boolean getFlag() {
		return flag;
	}

	// Thread B waits for the flag to become true
	public synchronized void waitForFlag() throws InterruptedException {
		while (!flag) {
			wait();
		}
	}
}
