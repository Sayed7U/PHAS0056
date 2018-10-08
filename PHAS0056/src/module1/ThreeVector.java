package module1;

public class ThreeVector {
	
	private double x,y,z; // defining the coords as local variables
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Creating ThreeVector constructors
	public ThreeVector() { 
		//returns null for no arguments
		
	}
	
	public ThreeVector(double v1,double v2,double v3) {
		x=v1;
		y=v2;
		z=v3;
	}
	
	//Finds the magnitude of the ThreeVector
	public double magnitude() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	//Finds a vector in the same directions as the ThreeVector but with magnitude 1.
	public ThreeVector unitVector() {
		return new ThreeVector(x/magnitude(), y/magnitude(), z/magnitude());
	}
	
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}
	
	public static double scalarProduct(ThreeVector v1,ThreeVector v2) {
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	}
	
	public static ThreeVector vectorProduct(ThreeVector v1,ThreeVector v2) {
		ThreeVector v3 = new ThreeVector((v1.y*v2.z)-(v1.z*v2.y),(v1.z*v2.x)-(v1.x*v2.z),(v1.x*v2.y) - (v1.y* v2.x));
		return v3;
	}
	
	public static ThreeVector add(ThreeVector v1,ThreeVector v2) {
		return new ThreeVector(v1.x + v2.x, v1.y + v2.y,v1.z + v2.z);
	}
	
	public static double angle(ThreeVector v1,ThreeVector v2) {
		double a = (scalarProduct(v1,v2))/v1.magnitude()*v2.magnitude();
		double b = Math.acos(a);
		return Math.toDegrees(b);
	}
	
}
