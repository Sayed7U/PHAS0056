package module3;
import java.util.Random;
import java.lang.StringBuilder;

public class Alphabet {
	
	//creating a new object for random class
	static Random r = new Random();
	
	public static void main(String[] args) {
		
		StringBuilder s = new StringBuilder(); //creating new string builder object
		
		//initialising 'counter' variables
		int total = 0;
		int exceptions = 0;
		
		
	//runs a loop 400 times which generates a random character then checks whether it is a letter or digit and appends it to a string.
		for (int i = 0; i < 400; i++) {
			char c = randomCharacter();
			if (Character.isLetterOrDigit(c)) {
				s.append(c); //appends the character to a string.
				try {
					Integer.parseInt(Character.toString(c));
					total += c; //total of all the integer characters generated are added
				}
				catch (Exception e) {
					exceptions++; //number of letters in the string
				}
			}
		}
		System.out.println("The string is " + s);
		System.out.println("The string builder has " + s.length() + " characters in it.");
		System.out.println("The sum of all the integer characters is " + total);
		System.out.println("the number of exception that occured is " + exceptions);
		
	}
	
	public static char randomCharacter() {
		char a = (char) r.nextInt(128);
		return a;
	}

}
