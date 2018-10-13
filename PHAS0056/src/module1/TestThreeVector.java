package module1;

public class TestThreeVector {

	public static void main(String[] args) {
		//setting up the 3 three vector objects
		ThreeVector v1 = new ThreeVector(4,5,1);
		ThreeVector v2 = new ThreeVector(1,4,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		System.out.println("Vector v1: " + v1 + "\n" + "Vector v2: " + v2 + "\n" + "Vector v3: " + v3);
		System.out.println("Unit vector of v1: " + v1.unitVector() + "\n" + "Unit vector of v2: " + v2.unitVector() + "\n" + "Unit vector of v3: " + v3.unitVector());
		
		System.out.println("The scalar product between v1 and v2 is " + ThreeVector.scalarProduct(v1, v2));
		System.out.println("The scalar product between v1 and v3 is " + ThreeVector.scalarProduct(v1, v3));
		System.out.println("The vector product between v1 and v2 is " + ThreeVector.vectorProduct(v1, v2));
		System.out.println("The vector product between v1 and v3 is " + ThreeVector.vectorProduct(v1, v3));
		
		System.out.println("The non static scalar product between v1 and v2 is " + v1.scalarProductNS(v2));
		System.out.println("The non static scalar product between v1 and v3 is " + v1.scalarProductNS(v3));
		System.out.println("The non static vector product between v1 and v2 is " + v1.vectorProductNS(v2));
		System.out.println("The non static vector product between v1 and v3 is " + v1.vectorProductNS(v3));
		
		System.out.println("The angle between v1 and v2 is " + ThreeVector.angle(v1, v3));
		System.out.println("The angle between v1 and v3 is " + ThreeVector.angle(v1, v3));
		System.out.println("The non static angle between v1 and v2 is " + v1.angleNS(v2));
		System.out.println("The non static angle between v1 and v3 is " + v1.angleNS(v3));
		System.out.println(v1);
		System.out.println("Without a toString() method defined, when a 3-vector object is called in a print statement, it returns how the object"
				+ " is stored in memory.");
	}

}
