package module1;

public class ThreeVector {

	private double x,y,z; // defining the coords as local variables

	//Creating ThreeVector constructors
	public ThreeVector() { 
		//returns null for no arguments
	}

	//constructor for 3 arguments
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
		if (this.magnitude()==0) { 
			return new ThreeVector(0,0,0);
		} else {
			return new ThreeVector(x/magnitude(), y/magnitude(), z/magnitude());
		}
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

	public double scalarProduct(ThreeVector v1) {
		return scalarProduct(v1, this);
	}

	public ThreeVector vectorProduct(ThreeVector v1) {
		return vectorProduct(v1, this);
	}

	public ThreeVector add(ThreeVector v1) {
		return add(v1, this);
	}

	public double angle(ThreeVector v1) {
		return angle(v1, this);
	}
}
