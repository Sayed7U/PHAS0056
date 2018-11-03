package module5;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class DataPoint {
	private double[] x,y,ey;

	public DataPoint() throws IOException {
		URL u = new URL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"); //creating URL object
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

	public double[] getX() {
		return this.x;
	}
	public double[] getY() {
		return this.y;
	}
	public double[] getEY() {
		return this.ey;
	}
}
