package module8;

/**
 *This class runs the threads for the CountdownTask.java and PrimeNumberTask.java
 *we find the number of primes and the largest prime within a given time
 *@author sayed
 */
public class ThreadsMain {
	public static void main(String[] args) {
		try {
			CountdownTask ct = new CountdownTask(20);
			PrimeNumberTask pn = new PrimeNumberTask();
			Thread ctThread = new Thread(ct);
			Thread pnThread = new Thread(pn);
			//starting the threads
			ctThread.start();
			pnThread.start();
			ctThread.join(); //waits until the ctThread is complete
			pnThread.interrupt(); //the pnThread is then interrupted

			System.out.println("The number of primes numbers in the list is " + pn.primes.size());
			System.out.println("The largest prime number is " + pn.primes.get(pn.primes.size()-1));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
