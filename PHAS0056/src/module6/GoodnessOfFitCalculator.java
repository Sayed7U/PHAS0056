package module6;
import java.util.*;
import java.io.*;


public interface GoodnessOfFitCalculator {
	ArrayList<DataPoint> dataFromURL(String url) throws IOException;
	double goodnessOfFit(Theory theory,ArrayList<DataPoint> points);
}
