package module8;

public class ThreadsMain {
	public static void main(String[] args) {
		try {
			CountdownTask ct = new CountdownTask(10);
			PrimeNumberTask pn = new PrimeNumberTask();
			Thread ctThread = new Thread(ct);
			Thread pnThread = new Thread(pn);
			ctThread.start();
			pnThread.start();
			ctThread.join();
			pnThread.interrupt();
			
			System.out.println("The number of primes numbers in the list is" + pn.primes.size());
			System.out.println("The largest prime number is " + pn.primes.get(pn.primes.size()-1));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
