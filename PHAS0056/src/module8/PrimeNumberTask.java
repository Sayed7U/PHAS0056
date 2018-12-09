package module8;
import java.util.*;

public class PrimeNumberTask implements Runnable {

	private int n = 1;
	public ArrayList<Integer> primes = new ArrayList<Integer>();

	public void run() {
		System.out.println("Running PrimeNumberTask...");
		while (!Thread.interrupted()) {
			boolean isPrime = true;
			if (n==1) {
				primes.add(n);
				n++;
			}
			if (n==2) {
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
