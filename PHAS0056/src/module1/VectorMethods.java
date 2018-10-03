package module1;

public class VectorMethods {

	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods();
		System.out.println(vm.angle(4, 3, 2, 1, 5, 4));
		System.out.println(vm.angle(4, 3, 2, 0, 0, 0));
// In the previous line you're dividing by 0, hence you return not a number.
		}
	public double dotProduct (double x1,double y1,double z1,double x2,double y2,double z2) {
		double x3 = x1 * x2;
		double y3 = y1 * y2;
		double z3 = z1 * z2;
		double sum = x3 + y3 + z3;
		return sum;
	}
	public double magnitude (double x,double y,double z) {
		double mag = Math.sqrt(x*x + y*y + z*z);
		return mag;
	}
	public double angle (double x1,double y1,double z1,double x2,double y2,double z2) {
		double a = (dotProduct(x1,y1,z1,x2,y2,z2))/(magnitude(x1,y1,z1)*magnitude(x2,y2,z2));
		double b = Math.acos(a);
		return Math.toDegrees(b);
	}

}
