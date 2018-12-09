package module8;
import java.util.*;

public class PrimeNumberTask implements Runnable {

	private int n = 1;
	private ArrayList<Integer> primes = new ArrayList<Integer>();

	public void run() {
		while (true) {
			if (n==1) {
			primes.add(n);
		}
		if (n==2) {
			primes.add(n);
		}
		for (int i=1;i < n;i++) {
			if (n % i == 0) {
				break;
			}
			primes.add(n);
		}
		n++;
		}
	}
}
