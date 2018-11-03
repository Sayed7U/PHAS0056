package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class DataPoint {
	private double x,y,ey;

	public DataPoint() throws IOException {
		URL u = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"); //creating URL object
		InputStream is = u.openStream(); //opening the URL object 
		InputStreamReader isr = new InputStreamReader(is); //reading the resulting input stream
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
			line = line.trim();
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				this.x = Double.parseDouble(s.next());
				this.y = Double.parseDouble(s.next());
				this.ey = Double.parseDouble(s.next());
			}
			s.close();
		}
	}

	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getEY() {
		return this.ey;
	}
}
