package module1;

public class Complex {
	
	private double x,y;
	
	//constructor for 2 arguments, real and imaginary part
	public Complex(double v1,double v2) {
		this.x=v1;
		this.y=v2;
	}
	
	public String toString() {
		return x + y + "i"; 
	}
	public double real() {
		return x;
	}
	
	public double imag() {
		return y;
	}

	public double modulus() {
		return Math.sqrt(x*x + y*y);
	}
	
	public double angle() {
		double agl = Math.atan(y/x);
		if (x < 0 && y > 0) {
			agl = Math.PI - agl;
		}
		else if (x > 0 && y < 0) {
			agl = -agl;
		}
		else if (x < 0 && y < 0) {
			agl = -Math.PI + agl;
		}
		return agl;
	}
	
	public Complex conjugate() {
		return new Complex(x,-y);
	}
	
	public Complex normalised() {
		double x2 = x/modulus();
		double y2 = y/modulus();
		return new Complex(x2,y2);
	}
	
	public boolean equals(Complex C) {
		if (this.x == C.x && this.y == C.y) {
			return true;
		} else {
			return false;
		}
		
	}
}
