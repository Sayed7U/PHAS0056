package module4;
import java.io.*;
import java.net.URL;

public class NumericalReader {
	
	public static String getStringFromKeyboard() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Please type something!");
		String s = br.readLine();
		return s;
	}
	
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}
	
	void analysisStart(String dataFile) throws IOException {
		File f = new File(dataFile);
		int minValue,maxValue,nValues,sumOfValues;
	}
	
	void analyseData(String line) {
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
