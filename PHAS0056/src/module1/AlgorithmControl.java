package module1;
import java.text.DecimalFormat;

public class AlgorithmControl {

	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl();
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		System.out.println("Total number of loops for 1,000 steps: " + decimalFormat.format(ac.timer(10,1000)) +"\n" +
		"Total number of loops for 50,000 steps: " + decimalFormat.format(ac.timer(10, 50000)));
	//More prints are doen with 1000steps than 50,000 steps. The 50,000 steps can run through the loop faster as it 
	//doesn't have to print so often.
	}
	public void loop () {
		for (int i = 1; i < 9; i++) {
		System.out.println(i);
		}
	}
	public void decrement() { 
		int i = 10;
		while (i > -6) { 
			System.out.println(i);
			i--;
		}
	}
	public void increment() {
		for (double i = 2.5; i < 4.4; i = i + 0.1) {
			System.out.println(i);
		}
	}
	public int timer(long maxTime, int loopSteps) {
		long timeBefore = System.currentTimeMillis();
		int i = 1;
		while (System.currentTimeMillis() - timeBefore < maxTime*1000) {
			int remainder = i % loopSteps;
			if (remainder == 0) {
				System.out.println(i + " iterations..");
			}
			i++;
		}
		return (i-1);
	}

}
