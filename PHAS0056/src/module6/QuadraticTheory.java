package module6;

//a theory for the function y = ax^2 + bx + c
public class QuadraticTheory implements Theory {
	double a,b,c;
	
	//defining the constructor
	public QuadraticTheory(double a1, double b1, double c1) {
		this.a = a1;
		this.b = b1;
		this.c = c1;
	}
	
	//the y(x) method
	public double y(double x) {
		return (a * x*x + b * x + c);
	}
	
	//what to return in a print statement
	public String toString() {
		return Double.toString(this.a) + "x^2 + " + this.b + "x + " + this.c;
	}
}
