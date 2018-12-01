package module6;

public class QuadraticTheory implements Theory {
	double a,b,c;
	
	public QuadraticTheory(double a1, double b1, double c1) {
		this.a = a1;
		this.b = b1;
		this.c = c1;
	}
	
	public double y(double x) {
		return (a * x*x + b * x + c);
	}
	
	public String toString() {
		return Double.toString(this.a) + "x^2 + " + this.b + "x + " + this.c;
	}
}
