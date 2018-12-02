package module6;

import java.util.*;

//using chisquared to determine how well datapoints fit a certain theory
public class ChiSquared implements GoodnessOfFitCalculator{

	//statistically compares how well an array of DataPoint fits in with a theory, using chi-squared
	public double goodnessOfFit(Theory theory,ArrayList<DataPoint> points) {
		double sum = 0;
		for (int i = 0; i < points.size(); i++ ) {
			double top = Math.pow((points.get(i).getY() - theory.y(points.get(i).getX())),2);
			double bottom = Math.pow(points.get(i).getEY(),2); //using the chi-squared formula
			sum += top/bottom;
		}
		return sum;
	}

}
