package module1;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector v1 = new ThreeVector(4,5,1);
		ThreeVector v2 = new ThreeVector(1,4,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		System.out.println("Vector v1: " + v1 + "\n" + "Vector v2: " + v2 + "\n" + "Vector v3: " + v3);
		System.out.println("Unit vector of v1: " + v1.unitVector() + "\n" + "Unit vector of v2: " + v2.unitVector() + "\n" + "Unit vector of v3: " + v3.unitVector());
	}

}
