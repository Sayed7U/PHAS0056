package module1;

public class DataTypes {
	public static void main(String args[]) {
		double doubVar = 5.0;
		System.out.println(doubVar);
		float floatVar = 5.0f;
		System.out.println(floatVar);
		int intVar = 5;
		System.out.println(intVar);
		long longVar = 5;
		System.out.println(longVar);
		byte byteVar = 5;
		System.out.println(byteVar);
		System.out.println(doubVar * floatVar * intVar * longVar * byteVar);
		System.out.println("The value of the double variable is " + doubVar);
		System.out.println(intVar + doubVar);
		System.out.println(byteVar + doubVar);
		
//		int j = 1;
//		int i;
//		j = i + 1;
		double doubVar2 = 4.99;
		int widenVar;
		widenVar = (int) doubVar2;
		System.out.println(widenVar);
// Double variables are 64 bit numbers with a floating point whilst integers are 32 bit with no floating point. 
// There is a loss of of information and the floating point is lost. Hence only 4 is printed.
	}
}
