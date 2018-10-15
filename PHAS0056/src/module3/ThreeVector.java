package module3;

public class ThreeVector {

	public double x,y,z; // defining the coords

	//Creating ThreeVector constructors
	public ThreeVector() { 
		//returns null for no arguments
	}

	//constructor for 3 arguments
	public ThreeVector(double v1,double v2,double v3) {
		this.x=v1;
		this.y=v2;
		this.z=v3;
	}

	//Finds the magnitude of the ThreeVector
	public double magnitude() {
		return Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
	}

	//Finds a vector in the same directions as the ThreeVector but with magnitude 1.
	public ThreeVector unitVector() throws Exception {
		if (this.magnitude()==0) { 
			throw new Exception("Cannot find unit vector of zero vector (dividing by zero)");
		}
		return new ThreeVector(this.x/this.magnitude(), this.y/this.magnitude(), this.z/this.magnitude());
	}

	//Defines what to print when the object is called in a print statement
	public String toString() {
		return "(" + this.x + "," + this.y + "," + this.z + ")";
	}

	//uses the formula from vector analysis to calculate the scalar product
	public static double scalarProduct(ThreeVector v1,ThreeVector v2) {
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	}

	//formula from vector analysis to calculate the vector product, returns a 3-vector
	public static ThreeVector vectorProduct(ThreeVector v1,ThreeVector v2) {
		ThreeVector v3 = new ThreeVector((v1.y*v2.z)-(v1.z*v2.y),(v1.z*v2.x)-(v1.x*v2.z),(v1.x*v2.y) - (v1.y* v2.x));
		return v3;
	}

	//adds 2 3-vectors together
	public static ThreeVector add(ThreeVector v1,ThreeVector v2) {
		return new ThreeVector(v1.x + v2.x, v1.y + v2.y,v1.z + v2.z);
	}

	//uses the scalar product formula to find the angle between 2 vectors
	public static double angle(ThreeVector v1,ThreeVector v2) throws Exception {
		if (v1.magnitude() == 0 || v2.magnitude() == 0) {
			throw new Exception("Cannot find angle between a zero vector and another vector, zero vector is a point");
		}
		double a = (scalarProduct(v1,v2))/v1.magnitude()*v2.magnitude();
		double b = Math.acos(a);
		return Math.toDegrees(b);
	}

	//Non-static versions of previous methods
	public double scalarProductNS(ThreeVector v1) {
		return scalarProduct(v1, this);
	}

	public ThreeVector vectorProductNS(ThreeVector v1) {
		return vectorProduct(v1, this);
	}

	public ThreeVector addNS(ThreeVector v1) {
		return add(v1, this);
	}

	public double angleNS(ThreeVector v1) throws Exception {
			return angle(v1,this);
	}
}
