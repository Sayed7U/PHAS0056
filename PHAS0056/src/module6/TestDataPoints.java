package module6;
import java.io.*;
import java.net.URL;
import java.util.*;

public class TestDataPoints {
	
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException {
		ArrayList<DataPoint> DataPoints = new ArrayList<DataPoint>(); //an array of DataPoint (the class we made)
		URL u = new URL(url); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		BufferedReader br = new BufferedReader(isr); //put into a buffer so it can be read line by line
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim(); //gets rid of white-space preceding and following a line
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				double x1 = Double.parseDouble(s.next());
				double y1 = Double.parseDouble(s.next());
				double ey1 = Double.parseDouble(s.next());
				if (s.hasNext()) {
					LabelledDataPoint dp = new LabelledDataPoint(x1, //s.next essentially reads the next 'word'
							y1,ey1,s.next());
					System.out.println(dp);
					DataPoints.add(dp);
				} else {
					DataPoint dp = new DataPoint(x1,y1,ey1);
					DataPoints.add(dp);
					System.out.println(dp);
				}
			}
			s.close(); //closing the scanner
		}
		return DataPoints;
	}

	public static void main(String[] args) {
		try {
			dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
	}

}
