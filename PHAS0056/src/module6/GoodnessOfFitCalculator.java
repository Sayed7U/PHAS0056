package module6;
import java.util.*;

//different methods can be used to calc goodnessofFit, they should allow follow this blueprint
public interface GoodnessOfFitCalculator {
	double goodnessOfFit(Theory theory,ArrayList<DataPoint> points); //a method to calc the goodness of the fit
																	//takes in a theory and an arraylist of datapoints
}
