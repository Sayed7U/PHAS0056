package module8;
import java.util.concurrent.*;

public class ThreadsTimer {
	public static void main(String[] args) {
		//single threaded
		long t1 = System.currentTimeMillis();
		ExecutorService single = Executors.newFixedThreadPool(1);
		MonteCarloPiCalculatorTask m = new MonteCarloPiCalculatorTask(10000000);
		single.submit(m);
		single.shutdown();
		long t2 = System.currentTimeMillis();
		System.out.println("The time taken to complete the single-threaded MonteCarloPiCalculator task is " + (t2-t1) + " milliseconds.");
		
		//multi-threaded (4 threads)
		long t3 = System.currentTimeMillis();
		ExecutorService quad = Executors.newFixedThreadPool(4);
		MonteCarloPiCalculatorTask m1 = new MonteCarloPiCalculatorTask(2500000);
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
	}

}
