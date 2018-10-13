package module1;

public class Complex {
	
	private double x,y;
	
	//constructor for 2 arguments, real and imaginary part
	public Complex(double v1,double v2) {
		this.x=v1;
		this.y=v2;
	}
	
	public String toString() {
		return this.x + " + " + this.y + "i"; 
	}
	public double real() {
		return this.x;
	}
	
	public double imag() {
		return this.y;
	}

	public double modulus() {
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}
	
	public double angle() {
		double agl = Math.atan(this.y/this.x);
		if (this.x < 0 && this.y > 0) {
			agl = Math.PI - agl;
		}
		else if (this.x > 0 && this.y < 0) {
			agl = -agl;
		}
		else if (this.x < 0 && this.y < 0) {
			agl = -Math.PI + agl;
		}
		return agl;
	}
	
	public Complex conjugate() {
		return new Complex(this.x,-this.y);
	}
	
	public Complex normalised() {
		double x2 = this.x/modulus();
		double y2 = this.y/modulus();
		return new Complex(x2,y2);
	}
	
	public boolean equals(Complex C) {
		if (this.x == C.x && this.y == C.y) {
			return true;
		} else {
			return false;
		}
	}
	
	public Complex setFromModulusAngle(double mag, double ang) {
		double realv = mag * Math.cos(ang);
		double imgv = mag * Math.sin(ang);
		if (ang > Math.PI/2) {
			realv = -realv;
		}
		else if (ang < -Math.PI/2) {
			realv = -realv;
		}
		return new Complex(realv,imgv);
	}
}
