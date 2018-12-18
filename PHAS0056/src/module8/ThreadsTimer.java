package module8;
import java.util.concurrent.*;

/**
 *This class compares the time taken to calculate pi using a monte carlo calculation 
 *using 1 thread and 4 threads.
 *@author sayed
 */

public class ThreadsTimer {
	public static void main(String[] args) {
		//single threaded
		long t1 = System.currentTimeMillis();
		ExecutorService single = Executors.newFixedThreadPool(1); //make a thread pool of 1
		MonteCarloPiCalculatorTask m = new MonteCarloPiCalculatorTask(10000000);
		single.submit(m); //adding it to the thread pool
		single.shutdown(); //shutsdown the pool
		long t2 = System.currentTimeMillis();
		System.out.println("The time taken to complete the single-threaded MonteCarloPiCalculator task is " + (t2-t1) + " milliseconds.");

		//multi-threaded (4 threads)
		long t3 = System.currentTimeMillis();
		ExecutorService quad = Executors.newFixedThreadPool(4); //pool of 4 threads
		MonteCarloPiCalculatorTask m1 = new MonteCarloPiCalculatorTask(2500000); //the nPoints is split evenly, adds to make 10000000
		MonteCarloPiCalculatorTask m2 = new MonteCarloPiCalculatorTask(2500000);
		MonteCarloPiCalculatorTask m3 = new MonteCarloPiCalculatorTask(2500000);
		MonteCarloPiCalculatorTask m4 = new MonteCarloPiCalculatorTask(2500000);
		quad.submit(m1);
		quad.submit(m2);
		quad.submit(m3);
		quad.submit(m4);
		quad.shutdown();
		long t4 = System.currentTimeMillis();
		System.out.println("The time taken to complete the multi-threaded (quad) MonteCarloPiCalculator task is " + (t4-t3) + " milliseconds.");
		System.out.println("The multi-threaded evaluation is significantly quicker than the single threaded evaluation.");
	}

}
