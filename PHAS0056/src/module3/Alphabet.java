package module3;
import java.util.Random;
import java.lang.StringBuilder;

public class Alphabet {
	
	static Random r = new Random();
	static StringBuilder s = new StringBuilder();

	public static void main(String[] args) {
		for (int i = 0; i <= 400; i++) {
			char c = randomCharacter();
			if (Character.isDigit(c) || Character.isLetter(c)) {
				s.append(c);
				Integer.parseInt(c);
				
			}
		}
	}
	
	public static char randomCharacter() {
		char a = (char) r.nextInt(128);
		return a;
	}

}
