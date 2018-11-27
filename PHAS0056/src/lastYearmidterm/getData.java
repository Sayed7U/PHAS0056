package lastYearmidterm;

import java.io.*;
import java.util.*;

public class getData {
	static double lowExtent = 0;
	static double lowArea = 0;
	static int lowYearE = 0;
	static int lowMonthE = 0;
	static int lowYearA = 0;
	static int lowMonthA = 0;
	static int measurements = 0;
	static ArrayList<DataPoint> data = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> jan = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> feb = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> mar = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> apr = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> may = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> jun = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> jly = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> aug = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> sep = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> oct = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> nov = new ArrayList<DataPoint>();
	static ArrayList<DataPoint> dec = new ArrayList<DataPoint>();
	
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName); //reads characters from a file
		return new BufferedReader(fr);
	}

	public static void analyseData(BufferedReader reader) throws IOException {
		String line = "";
		reader.readLine();
		while ((line = reader.readLine()) != null) { //reads every line from the buffer and checks if its not null
			Scanner s = new Scanner(line).useDelimiter(",\\s*");
			while (s.hasNext()) {
				DataPoint dp = new DataPoint(Integer.parseInt(s.next()),Integer.parseInt(s.next()),s.next(),s.next(),Double.parseDouble(s.next()),Double.parseDouble(s.next()));
				if (dp.getExtent() == -9999 || dp.getArea() == -9999) {
					continue;
				}
				data.add(dp);
				if (lowExtent == 0) {
					lowExtent = dp.getExtent();
				}
				if (dp.getExtent() < lowExtent) {
					lowExtent = dp.getExtent();
					lowYearE = dp.getYear();
					lowMonthE = dp.getMonth();
				}
				if (lowArea == 0) {
					lowArea = dp.getArea();
				}
				if (dp.getArea() < lowArea) {
					lowArea = dp.getArea();
					lowYearA = dp.getYear();
					lowMonthA = dp.getMonth();
				}
				measurements++;
		}
		s.close(); //closes the scanner
		}
	}
	public static String lowestArea(ArrayList<DataPoint> a) throws IOException {
		double lowArea = 0;
		double lowYear = 0;
		for(int i = 0; i < a.size(); i++) {
			if(lowArea == 0) {
				lowArea = a.get(i).getArea();
			}
			if(a.get(i).getArea() < lowArea) {
				lowArea = a.get(i).getArea();
				lowYear = a.get(i).getYear();
			}
		}
		return lowArea + " with year " + lowYear;
	}
	public static DataPoint getSpecYear(ArrayList<DataPoint> a, int year) throws IOException {
		DataPoint dp = new DataPoint(0,0,"","",0,0);
		for(int i = 0; i< a.size(); i++) {
			if(a.get(i).getYear() == year) {
				dp = a.get(i);
			}
		}
		return dp;
	}
	public static ArrayList<Double> areaDiff(ArrayList<DataPoint> a) throws IOException {
		ArrayList<Double> diff = new ArrayList<Double>();
		boolean firstyear = true;
		for(int k = 1980; k <= 2017; k ++) {
			if (firstyear == true && (getSpecYear(a,k).getMonth() == 11 || getSpecYear(a,k).getMonth() == 12)) {
				k = 1979;
				firstyear = false;
			}
			diff.add((double) k);
			diff.add((double) k-1);
			diff.add((getSpecYear(a,k).getArea() - getSpecYear(a,k-1).getArea()));
		}
		return diff;
	}
	public static ArrayList<Double> fiveYearsDrop(ArrayList<Double> yearndiff) throws IOException {
		ArrayList<Double> onlydiff = new ArrayList<Double>();
		ArrayList<Double> sorteddiff = new ArrayList<Double>();
		for(int i=0;i<((int) yearndiff.size()/3);i++) {
			onlydiff.add(yearndiff.get(3*i+2)); 
		}
		Collections.sort(onlydiff);
		for(int i=0;i<5;i++) {
			sorteddiff.add(yearndiff.get(yearndiff.indexOf(onlydiff.get(i))-2));
			sorteddiff.add(yearndiff.get(yearndiff.indexOf(onlydiff.get(i))-1));
			sorteddiff.add(onlydiff.get(i));
		}
		return sorteddiff;
	}
	public static double averageArea(ArrayList<DataPoint> a) {
		double total = 0;
		for(int i = 0; i< a.size(); i++) {
			total += a.get(i).getArea();
		}
		return total/a.size();
		
	}
	public static ArrayList<Double> averageAreaYear(ArrayList<DataPoint> a) throws IOException {
		ArrayList<Double> average = new ArrayList<Double>();
		for(int k = 1980; k <= 2017; k ++) {
			average.add((double) k);
			average.add((double) k-1);
			average.add(getSpecYear(a,k).getArea() - getSpecYear(a,k-1).getArea());
		}
		return average;
	}
	public static void main(String[] args) {
		try {
			String saveDir = "C:\\Users\\Sayed\\Documents";
			String saveFile = (saveDir + File.separator + "N_extent_v3.0.csv");
			BufferedReader reader = brFromFile(saveFile);
			analyseData(reader);
			for(int i = 0; i< data.size(); i++) {
				if (data.get(i).getMonth() == 1) {
					jan.add(data.get(i));
				}
				if (data.get(i).getMonth() == 2) {
					feb.add(data.get(i));
				}
				if (data.get(i).getMonth() == 3) {
					mar.add(data.get(i));
				}
				if (data.get(i).getMonth() == 4) {
					apr.add(data.get(i));
				}
				if (data.get(i).getMonth() == 5) {
					may.add(data.get(i));
				}
				if (data.get(i).getMonth() == 6) {
					jun.add(data.get(i));
				}
				if (data.get(i).getMonth() == 7) {
					jly.add(data.get(i));
				}
				if (data.get(i).getMonth() == 8) {
					aug.add(data.get(i));
				}
				if (data.get(i).getMonth() == 9) {
					sep.add(data.get(i));
				}
				if (data.get(i).getMonth() == 10) {
					oct.add(data.get(i));
				}
				if (data.get(i).getMonth() == 11) {
					nov.add(data.get(i));
				}
				if (data.get(i).getMonth() == 12) {
					dec.add(data.get(i));
				}
			}
			System.out.println(areaDiff(jan));
			System.out.println(fiveYearsDrop(areaDiff(jan)));
			ArrayList<Double> averages = new ArrayList<Double>();
			ArrayList<Double> unsortedav;
			averages.add(averageArea(jan));
			averages.add(averageArea(feb));
			averages.add(averageArea(mar));
			averages.add(averageArea(apr));
			averages.add(averageArea(may));
			averages.add(averageArea(jun));
			averages.add(averageArea(jly));
			averages.add(averageArea(aug));
			averages.add(averageArea(sep));
			averages.add(averageArea(oct));
			averages.add(averageArea(nov));
			averages.add(averageArea(dec));
			unsortedav = averages;
			Collections.sort(averages);
			System.out.println("The month with the lowest average area is " + unsortedav.indexOf(averages.get(0)) + " with value " + averages.get(0));
			System.out.println("The month with the highest average area is " + unsortedav.indexOf(averages.get(11)) + " with value " + averages.get(11));
			
			System.out.println("The average change in area per year for jan is " + averageAreaYear(jan));
			System.out.println("Using linear extrapolation, we see that there is a general trend of the area staying level, hence there should be ice left in the Arctic ");
			
			System.out.println("The average change in area per year for dec is " + averageAreaYear(dec));
			System.out.println("Using linear extrapolation, we see that there is a general trend of the area decreasing , hence there should be no ice left in the Arctic ");
			
			System.out.println("The lowest area for january is " + lowestArea(jan));
			System.out.println("The lowest area for february is " + lowestArea(feb));
			System.out.println("The total number of measurements is " + measurements);
			System.out.println("The month/year for the lowest total ice extent is " + lowMonthE + "/" + lowYearE + " with the measurement being " + lowExtent);
			System.out.println("The month/year for the lowest total ice area is " + lowMonthA + "/" + lowYearA + " with the measurement being " + lowArea);
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}
	}
}
