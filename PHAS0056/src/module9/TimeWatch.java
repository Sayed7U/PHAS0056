package module9;

import java.util.concurrent.TimeUnit;

public class TimeWatch {    
	long starts;
	long paused = 0;
	boolean isPaused;

	public static TimeWatch start() {
		return new TimeWatch();
	}

	private TimeWatch() {
		reset();
	}

	public TimeWatch reset() {
		starts = System.currentTimeMillis();
		return this;
	}
	public void pause() {
		paused = System.currentTimeMillis();
		isPaused = true;
	}
	public void play() {
		if (isPaused) {
			starts = starts + (System.currentTimeMillis() - paused);
			isPaused = false;
		}
	}

	public long time() {
		long ends = System.currentTimeMillis();
		return ends - starts;
	}

	public long time(TimeUnit unit) {
		return unit.convert(time(), TimeUnit.MILLISECONDS);
	}
}
