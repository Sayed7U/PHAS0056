package module4;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class NumericalReader {
	private Double minValue, maxValue,sumOfValues;
	private int nValues;
	private File outputFile;

	public static String getStringFromKeyboard() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Please type something!");
		String s = br.readLine();
		//if (s.length() == 0) {
		//	s = System.getProperty("user.home");
		//	throw new Exception("No input given, resulting to default.");
		//}
		return s;
	}

	public BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}

	void analysisStart(String dataFile) throws IOException {
		outputFile = new File(dataFile);
		minValue = null;
		maxValue = null;
		nValues = 0;
		sumOfValues = 0.0;
	}

	void analyseData(String line) throws IOException {
		line.replaceAll("\\s+","");
		line.trim();
		FileWriter fw = new FileWriter(outputFile);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		Scanner s = new Scanner(line);
		while (s.hasNext()) {
			String token = s.next();
			double x = Double.parseDouble(token);
			pw.println(x);
			sumOfValues += x;
			nValues += 1;
			if (minValue == null || x < minValue) {
				minValue = x;
			}
			if (maxValue == null || x > maxValue) {
				maxValue = x;
			}
		}
		s.close();
		pw.close();

	}

	void analysisEnd() {
		System.out.println("The minimum value is " + minValue);
		System.out.println("The maxiumum value is " + maxValue);
		System.out.println("The number of values is " +nValues);
		System.out.println("The sum of all the values is " + sumOfValues);

	}


	public static void main(String[] args) {
		try {
			String saveDir = getStringFromKeyboard();
			NumericalReader nr = new NumericalReader();
			String saveFile = (saveDir + File.separator + "numbers1.txt");
			BufferedReader reader = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			String line = "";
			nr.analysisStart(saveFile);
			while ((line = reader.readLine()) != null) {
				nr.analyseData(line);
			}
			nr.analysisEnd();
		} catch (IOException e) {
			//
		}// catch (Exception e) {
			//System.out.println(e);
		//}
	}

}
