package module6;

//a theory for the function y=x^n
public class PowerLawTheory implements Theory{
	double n;
	
	//defining the constructor
	public PowerLawTheory(double n1) {
		this.n = n1;
	}
	
	//the y(x) method
	public double y(double x) {
		return Math.pow(x, n);
	}

	//what to return in a print statement
	public String toString() {
		return "x^" + this.n;
	}
}
