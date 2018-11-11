package module5;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Minerals {

	public static HashMap<Integer, Double> massDataFromURL(String url) throws IOException {
		HashMap<Integer, Double> mass = new HashMap<Integer, Double>();
		URL u = new URL(url); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		BufferedReader br = new BufferedReader(isr); //put into a buffer so it can be read line by line
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim(); //gets rid of white-space preceding and following a line
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				mass.put(Integer.parseInt(s.next()),Double.parseDouble(s.next()));
			}
			s.close(); //closing the scanner
		}
		return mass;
	}
	
	public static HashMap<Integer, String> locationDataFromURL(String url) throws IOException {
		HashMap<Integer, String> location = new HashMap<Integer, String>();
		URL u = new URL(url); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		BufferedReader br = new BufferedReader(isr); //put into a buffer so it can be read line by line
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim(); //gets rid of white-space preceding and following a line
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				location.put(s.nextInt(),s.next());
			}
			s.close(); //closing the scanner
		}
		return location;
	}
	
	public static String largestMass(HashMap<Integer,Double> m, HashMap<Integer,String> l) throws IOException {
		double lmass = 0;
		int code = -1;
		String location = "";
		for (Map.Entry<Integer,Double> entry : m.entrySet()) {
			if (entry.getValue() > lmass) {
				lmass = entry.getValue();
				code = entry.getKey();
			}
		}
		for (Map.Entry<Integer, String> entry : l.entrySet()) {
			if (entry.getKey() == code) {
				location = entry.getValue();
			}
		}
		return ("The sample with the largest mass: \n"
				+ "Code Number: " + code + "/n" + 
				"Mass: " + lmass + "\n" + 
				"Location: " + location);
	}
	public static void main(String[] args) {
		try {
			HashMap<Integer, Double> massData = massDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
			HashMap<Integer, String> locationData = locationDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");
			System.out.println(largestMass(massData,locationData));
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
	}
}
