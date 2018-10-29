package module4;
//importing all the input/output modules
import java.io.*;
import java.net.URL;
import java.util.Scanner;

//reads a passage of text online and outputs values to console and a .txt file. Also finds the properties of the values
public class NumericalReader {

	//defining private variables
	private Double minValue, maxValue,sumOfValues;
	private int nValues;
	private File outputFile;
	private PrintWriter pw;


	//returns the user keyboard input, we ask for a file directory (a string)
	public static String getStringFromKeyboard() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in); //reading the resulting input
		BufferedReader br = new BufferedReader(isr); //put into a buffer so it can be read line by line
		System.out.print("Please enter the file directory: ");
		String s = br.readLine(); //reads it line by line
		if (s.length() == 0) {
			s = System.getProperty("user.home"); //if no input is given, the default directory is set
		}
		return s;
	}

	//returns the buffered reader from a passage of text online
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		return new BufferedReader(isr); //reads the input of a line one at a time
	}

	//Initialises the variables to analyse the data
	void analysisStart(String dataFile) throws IOException {
		outputFile = new File(dataFile); //creating a new .txt file
		minValue = null;
		maxValue = null;
		nValues = 0;
		sumOfValues = 0.0;
		FileWriter fw = new FileWriter(this.outputFile); //writing to a file, the boolean tells us 
		//whether we want to overwrite the data or append it
		BufferedWriter bw = new BufferedWriter(fw); //the reverse of buffered reader
		pw = new PrintWriter(bw); //allows us to print numbers and string to file
	}

	//looks at each line and finds the values and prints it to console and to .txt file
	//also finds the min, max, sum and number of all the values
	void analyseData(String line) throws IOException {
		line = line.trim(); //gets rid of white-space proceeding and 
		Scanner s = new Scanner(line);
		if (line.length() != 0 && !line.startsWith("c") && !line.startsWith("x")) { 
			while (s.hasNext()) {
				String token = s.next();
				double x = Double.parseDouble(token);//converts the string to a double
				this.pw.println(x); //printing to .txt file
				System.out.println(x); //printing to console
				this.sumOfValues += x;
				this.nValues += 1;
				if (this.minValue == null || x < this.minValue) { //minvalue is null when there is no assigned value
					this.minValue = x;
				}
				if (this.maxValue == null || x > this.maxValue) { //maxvalue is null when there is no assigned value
					this.maxValue = x;
				}
			}
		}
		s.close(); //closes the scanner
	}

	//print statements as soon as the analysis ends, prints the min, max, sum and number of values.
	void analysisEnd() {
		System.out.println("The minimum value is " + minValue);
		System.out.println("The maxiumum value is " + maxValue);
		System.out.println("The number of values is " + nValues);
		System.out.println("The sum of all the values is " + sumOfValues);
		pw.close(); //closes the print writer
	}


	public static void main(String[] args) {
		try {
			String saveDir = getStringFromKeyboard();
			NumericalReader nr = new NumericalReader();
			String saveFile = (saveDir + File.separator + "numbers1.txt");
			BufferedReader reader = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
			String line = ""; //empty string
			nr.analysisStart(saveFile);
			while ((line = reader.readLine()) != null) { //reads every line from the buffer and checks if its not null
				nr.analyseData(line);//analyses each line

			}
			nr.analysisEnd();

			System.out.println("Now for data2.txt...");
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
			System.out.println("Problem: "+e.getMessage());
		}
	}
}
