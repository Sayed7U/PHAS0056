package module5;

import java.io.*;
import java.net.URL;
import java.util.*;

public class DataAnalysis {
	public static ArrayList<DataPoint> dataFromURL(String url) throws IOException {
		ArrayList<DataPoint> mypoints = new ArrayList<DataPoint>();
		URL u = new URL(url); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim();
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				DataPoint dp = new DataPoint(Double.parseDouble(s.next())
						,Double.parseDouble(s.next())
						,Double.parseDouble(s.next()));
				mypoints.add(dp);
			}
			s.close();
		}
		return mypoints;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
