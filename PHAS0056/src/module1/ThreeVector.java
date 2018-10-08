package module1;

public class ThreeVector {
	
	private double x,y,z; // defining the coords as local variables
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ThreeVector() {
		
	}
	
	public ThreeVector(double v1,double v2,double v3) {
		x=v1;
		y=v2;
		z=v3;
	}
	
	public double magnitude() {
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	public ThreeVector unitVector() {
		return new ThreeVector(x/magnitude(), y/magnitude(), z/magnitude());
	}
}
