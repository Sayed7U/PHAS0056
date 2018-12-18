package module8;
import java.util.*;

/**
 * evaluates primes numbers and adds them to an arraylist until interrupted
 * @author sayed
 *
 */
public class PrimeNumberTask implements Runnable {

	private int n = 1;
	public ArrayList<Integer> primes = new ArrayList<Integer>();

	public void run() {
		System.out.println("Running PrimeNumberTask...");
		while (!Thread.interrupted()) {
			boolean isPrime = true;
			if (n==1) { //not a prime
				n++;
			}
			if (n==2) { //n=2 doesnt fit the next formula so we make a specific rule for this
				primes.add(n);
				n++;
			}
			for (int i=2;i < n;i++) {
				if (n % i == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				primes.add(n);
				n++;
			}
			n++;
		}
	}
}
