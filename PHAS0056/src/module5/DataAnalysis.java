package module5;

import java.io.*;
import java.net.URL;
import java.util.*;

//analyses data from a given url with x, y and error in y. Compares them to a theory using chi-squared
public class DataAnalysis {

	//reads the data from a URL and converts it to an array list of DataPoint
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException {
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
	public static double goodnessOfFit(Theory theory,ArrayList<DataPoint> points) {
		double sum = 0;
		for (int i = 0; i < points.size(); i++ ) {
			double top = Math.pow((points.get(i).getY() - theory.y(points.get(i).getX())),2);
			double bottom = Math.pow(points.get(i).getEY(),2); //using the chi-squared formula
			sum += top/bottom;
		}
		return sum;
	}

	public static void main(String[] args) {
		try {
			ArrayList<DataPoint> data = DataAnalysis.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			//testing for y^2
			double chisquared2 = goodnessOfFit(new Theory(2),data);
			System.out.println("The chi squared statistic for y^2 is: " + chisquared2);

			//testing for y^4
			double chisquared4 = goodnessOfFit(new Theory(4),data);
			System.out.println("The chi squared statistic for y^4 is: " + chisquared4);
			
			System.out.println("The y^2 shows a better fit as it has a lower value for the chi squared statistic");
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
	}
}
