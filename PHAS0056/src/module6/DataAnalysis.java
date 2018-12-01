package module6;
import java.io.*;
import java.util.*;

public class DataAnalysis {
	
	private static Theory bestTheory(ArrayList<DataPoint> data,
			ArrayList<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(theory,data);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}

	public static void main(String[] args) {
		try {
			ArrayList<DataPoint> data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
			ArrayList<Theory> theories = new ArrayList<Theory>();
			theories.add(new PowerLawTheory(2));
			theories.add(new PowerLawTheory(2.05));
			theories.add(new QuadraticTheory(1,10,0));
			System.out.println("The best theory that matches the data file is " + bestTheory(data,theories, new ChiSquared()));
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
	}
}
