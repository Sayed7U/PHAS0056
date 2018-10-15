package module3;

public class TestExceptions {

	public static void main(String[] args) {
		Complex c1 = new Complex(1,1);
		Complex c2 = new Complex(0,0);
		try {
			System.out.println("normalisation of c1 " + c1.normalised());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("normalisation of c2 " + c2.normalised());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("division of c1 and c2 (c1/c2) " + Complex.divide(c1, c2));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("division of c2 and c1 (c2/c1) " + Complex.divide(c2, c1));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		ThreeVector v1 = new ThreeVector(1,1,1);
		ThreeVector v2 = new ThreeVector(0,0,0);
		ThreeVector v3 = new ThreeVector(1,2,3);
		
		try {
			System.out.println("unitvector of v1 is " + v1.unitVector());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("unitvector of v2 is " + v2.unitVector());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("angle between v1 and v2 is  " + ThreeVector.angle(v1, v2));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("non static angle between v1 and v2 is  " + v1.angleNS(v2));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("non static angle between v1 and v3 is  " + ThreeVector.angle(v1, v3));
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
