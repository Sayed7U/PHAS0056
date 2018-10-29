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
		System.out.print("Please enter the path for the file");
		String s = br.readLine();
		if (s.length() == 0) {
			s = System.getProperty("user.home");
		}
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
		FileWriter fw = new FileWriter(outputFile,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		line = line.trim();
		Scanner s = new Scanner(line);
		if (line.length() != 0 && !line.startsWith("c") && !line.startsWith("x")) {
			while (s.hasNext()) {
				String token = s.next();
				double x = Double.parseDouble(token);
				pw.println(x);
				System.out.println(x);
				sumOfValues += x;
				nValues += 1;
				if (minValue == null || x < minValue) {
					minValue = x;
				}
				if (maxValue == null || x > maxValue) {
					maxValue = x;
				}
			}
		}
		s.close();
		pw.close();
	}

	void analysisEnd() {
		System.out.println("The minimum value is " + minValue);
		System.out.println("The maxiumum value is " + maxValue);
		System.out.println("The number of values is " + nValues);
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
			
			NumericalReader nr2 = new NumericalReader();
			String saveFile2 = (saveDir + File.separator + "numbers2.txt");
			BufferedReader reader2 = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
			String line2 = "";
			nr2.analysisStart(saveFile2);
			while ((line2 = reader2.readLine()) != null) {
				nr2.analyseData(line2);

			}
			nr2.analysisEnd();
		} catch (IOException e) {
			//
		} catch (Exception e) {
			System.out.println(e);
		}
		// catch (Exception e) {
			//System.out.println(e);
		//}
	}

}
