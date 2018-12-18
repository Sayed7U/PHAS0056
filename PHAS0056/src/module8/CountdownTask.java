package module8;

/**
 * Countsdown to zero seconds from a given time
 * @author sayed
 */
public class CountdownTask implements Runnable {

	private int sec;

	//setting the constructor
	public CountdownTask(int seconds) throws Exception {
		if (seconds < 0) {
			throw new Exception("Time given must be greater than 0.");
		}
		this.sec = seconds;
	}

	public void run() {
		System.out.println("Running CountdownTask...");
		try { //exception handling for thread.sleep
			while (sec >= 0) {
				System.out.println(sec);
				if (sec != 0) { //dont want the thread to sleep once it reaches 0 seconds
					Thread.sleep(1000);
				}
				sec--;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
