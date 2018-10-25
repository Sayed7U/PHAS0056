package module4;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordCounter {

	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		return new BufferedReader(isr);
	}

	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		return new BufferedReader(fr);
	}

	public static int countWordsInResource(BufferedReader dataAsBR) throws IOException {
		int count = 0;
		Scanner s = new Scanner(dataAsBR);
		while (s.hasNext()) {
			s.next();
			count++;
		}
		s.close();
		return count;
	}

	public static void main(String[] args) {
		try {
			BufferedReader urlbr = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
			System.out.println("The number of words is "+ countWordsInResource(urlbr));
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage());
		}

	}
}