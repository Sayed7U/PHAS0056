package module6;
import java.io.*;
import java.util.*;

//finds the best theory out of a list of theory that matches datapoints from a url
public class DataAnalysis {
	
	
	//compares the goodness of the fit between an array of theories and returns the one with the lowest goodness of fit
	private static Theory bestTheory(ArrayList<DataPoint> data,
			ArrayList<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(theory,data);
			if (first) {
				bestTheory = theory; //first theory set to be the 'best'.
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
			ArrayList<DataPoint> data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"); //getting data from the URL
			ArrayList<Theory> theories = new ArrayList<Theory>(); //creating an empty arraylist for the theories
			//adding them to the ArrayList
			theories.add(new PowerLawTheory(2));
			theories.add(new PowerLawTheory(2.05));
			theories.add(new QuadraticTheory(1,10,0));
			System.out.println("The best theory that matches the data file is " + bestTheory(data,theories, new ChiSquared()));
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
	}
}
