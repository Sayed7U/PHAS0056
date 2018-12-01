package module6;

public class PowerLawTheory implements Theory{
	double n;
	
	public PowerLawTheory(double n1) {
		this.n = n1;
	}
	public double y(double x) {
		return Math.pow(x, n);
	}

	public String toString() {
		return "x^" + this.n;
	}
}
