package module5;

import java.io.*;
import java.net.URL;
import java.util.*;

//finds the largest and smallest mass values from mineral data online
public class Minerals {

	//returns a hashmap of the mass data from a url, the key being the mineral code
	public static HashMap<Integer, Double> massDataFromURL(String url) throws IOException {
		HashMap<Integer, Double> massMap = new HashMap<Integer, Double>();
		URL u = new URL(url); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		BufferedReader br = new BufferedReader(isr); //put into a buffer so it can be read line by line
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim(); //gets rid of white-space preceding and following a line
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				massMap.put(Integer.parseInt(s.next()),Double.parseDouble(s.next()));
			}
			s.close(); //closing the scanner
		}
		return massMap;
	}

	//returns a hashmap of the location data from a url, the key being the mineral code
	public static HashMap<Integer, String> locationDataFromURL(String url) throws IOException {
		HashMap<Integer, String> locationMap = new HashMap<Integer, String>();
		URL u = new URL(url); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		BufferedReader br = new BufferedReader(isr); //put into a buffer so it can be read line by line
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim(); //gets rid of white-space preceding and following a line
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				String location = s.next(); //the first col is the value of the keys
				locationMap.put(Integer.parseInt(s.next()),location);
			}
			s.close(); //closing the scanner
		}
		return locationMap;
	}

	//finds the largest mass of the data, also gives the code and location
	public static String largestMass(HashMap<Integer,Double> m, HashMap<Integer,String> l) throws IOException {
		//setting the variables
		double lMass = 0;
		int code = -1;
		String location = "";
		for (Map.Entry<Integer,Double> entry : m.entrySet()) { //looping through the HashMap
			if (entry.getValue() > lMass) {
				lMass = entry.getValue();
				code = entry.getKey();
			}
		}
		for (Map.Entry<Integer, String> entry : l.entrySet()) {
			if (entry.getKey() == code) { //finds a key with the same code then gets the location
				location = entry.getValue();
			}
		}
		return ("The sample with the largest mass: \n"
				+ "Code Number: " + code + "\n" + 
				"Mass: " + lMass + "g \n" + 
				"Location: " + location + "\n");
	}

	//finds the smallest mass of the data, also gives the code and location
	public static String smallestMass(HashMap<Integer,Double> m, HashMap<Integer,String> l) throws IOException {
		double sMass = 0;
		int code = -1;
		String location = "";
		for (Map.Entry<Integer,Double> entry : m.entrySet()) {
			if (sMass == 0) {
				sMass = entry.getValue(); //first entry gets set to the smallest mass
			}
			if (entry.getValue() < sMass) {
				sMass = entry.getValue();
				code = entry.getKey();
			}
		}
		for (Map.Entry<Integer, String> entry : l.entrySet()) {
			if (entry.getKey() == code) {
				location = entry.getValue();
			}
		}
		return ("The sample with the smallest mass: \n"
				+ "Code Number: " + code + "\n" + 
				"Mass: " + sMass + "g \n" + 
				"Location: " + location + "\n");
	}
	public static void main(String[] args) {
		try {
			//Creating the url data as hashmaps
			HashMap<Integer, Double> massData = massDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
			HashMap<Integer, String> locationData = locationDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");

			System.out.println(largestMass(massData,locationData));
			System.out.println(smallestMass(massData,locationData));
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
	}
}
