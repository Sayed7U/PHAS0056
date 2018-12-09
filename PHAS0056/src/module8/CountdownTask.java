package module8;

public class CountdownTask implements Runnable {

	private int sec;

	public CountdownTask(int seconds) throws Exception {
		if (seconds < 0) {
			throw new Exception("Time given must be greater than 0.");
		}
		this.sec = seconds;
	}

	public void run() {
		System.out.println("Running CountdownTask...");
		try {
			while (sec >= 0) {
				System.out.println(sec);
				if (sec != 0) {
					Thread.sleep(1000);
				}
				sec--;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
