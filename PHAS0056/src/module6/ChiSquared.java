package module6;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ChiSquared implements GoodnessOfFitCalculator{
	//reads the data from a URL and converts it to an array list of DataPoint
	public ArrayList<DataPoint> dataFromURL(String url) throws IOException {
		ArrayList<DataPoint> mypoints = new ArrayList<DataPoint>(); //array of DataPoint (the class we made)
		URL u = new URL(url); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		BufferedReader br = new BufferedReader(isr); //put into a buffer so it can be read line by line
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim(); //gets rid of white-space preceding and following a line
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				DataPoint dp = new DataPoint(Double.parseDouble(s.next()) //s.next essentially reads the next 'word'
						,Double.parseDouble(s.next())
						,Double.parseDouble(s.next()));
				mypoints.add(dp);
			}
			s.close(); //closing the scanner
		}
		return mypoints;
	}

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
