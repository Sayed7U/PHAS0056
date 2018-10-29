package module4;
//importing all the input/output modules
import java.io.*;
import java.net.*;
import java.util.Scanner;

//This class counts the number of words from a passage of text online.
public class WordCounter {

	//returns the buffered reader from a passage of text online
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is);//reading the resulting input stream
		return new BufferedReader(isr); //reads the input of a line one at a time
	}

	//returns the buffered reader from a .txt file
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName); //reads characters from a file
		return new BufferedReader(fr);
	}

	//returns the number of words within a buffered reader
	public static int countWordsInResource(BufferedReader dataAsBR) throws IOException {
		int count = 0; //Initialising a count variable
		Scanner s = new Scanner(dataAsBR);
		while (s.hasNext()) {
			s.next(); //the next 'token' is essentially after a white-space 
					  //(hence each tokens are words)
			count++;
		}
		s.close(); //closes the scanner object
		return count;
	}

	public static void main(String[] args) {
		try {
			BufferedReader urlbr = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
			System.out.println("The number of words is "+ countWordsInResource(urlbr));
		} catch (IOException e) {
			System.out.println("Problem: "+e.getMessage()); //gives the IOException error message
		}

	}
}