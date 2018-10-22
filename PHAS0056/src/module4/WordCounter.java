package module4;
import java.io.*;
import java.net.*;

public class WordCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}
}