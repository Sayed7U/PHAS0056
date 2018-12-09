package module8;

public class CountdownTask implements Runnable {

	private int sec;

	public CountdownTask(int seconds) {
		this.sec = seconds;
	}

	public void run() {
		try {
			while (sec >= 0) {
				System.out.println(sec);
				wait(1000);
				sec--;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
