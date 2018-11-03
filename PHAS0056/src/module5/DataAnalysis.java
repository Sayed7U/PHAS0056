package module5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis {
	public static ArrayList dataFromURL(String url) {
		URL u = new URL(url); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim();
			Scanner s = new Scanner(line);
			int i = 0;
			while (s.hasNext()) {
				this.x[i] = Double.parseDouble(s.next());
				this.y[i] = Double.parseDouble(s.next());
				this.ey[i] = Double.parseDouble(s.next());
				i++;
			}
			s.close();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
