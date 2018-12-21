package module9;

import java.util.concurrent.TimeUnit;

/**
 * Allows us to pause, play and reset the time elapsed
 * acts like a stopwatch
 */
public class TimeWatch {    
	long starts; //starting time
	long paused = 0; //time when paused
	boolean isPaused;

	/**constructor*/
	public static TimeWatch start() {
		return new TimeWatch();
	}

	private TimeWatch() {
		reset();
	}

	/**resets watch*/
	public TimeWatch reset() {
		starts = System.currentTimeMillis();
		return this;
	}
	
	/**pauses watch*/
	public void pause() {
		paused = System.currentTimeMillis();
		isPaused = true;
	}
	
	/**plays a paused watch*/
	public void play() {
		if (isPaused) {
			starts = starts + (System.currentTimeMillis() - paused);
			isPaused = false;
		}
	}

	/**returns the time elapsed in milliseconds*/
	public long time() {
		long ends = System.currentTimeMillis();
		return ends - starts;
	}

	/**allows us to convert the time ellapsed into a preferred unit of time*/
	public long time(TimeUnit unit) {
		return unit.convert(time(), TimeUnit.MILLISECONDS);
	}
}
