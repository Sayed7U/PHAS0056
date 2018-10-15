package module3;
import java.util.Random;
import java.lang.StringBuilder;

public class Alphabet {
	
	static Random r = new Random();
	
	public static void main(String[] args) {
		
		StringBuilder s = new StringBuilder();
		int total = 0;
		int exceptions = 0;
		
		for (int i = 0; i <= 400; i++) {
			char c = randomCharacter();
			if (Character.isLetterOrDigit(c)) {
				s.append(c);
				try {
					Integer.parseInt(Character.toString(c));
					total += c;
				}
				catch (Exception e) {
					exceptions += 1;
				}
			}
		}
	}
	
	public static char randomCharacter() {
		char a = (char) r.nextInt(128);
		return a;
	}

}
