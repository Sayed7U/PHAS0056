package module2;

public class Complex {
	
	//defining the real and imaginary parts as local variables. x is the real part whilst y is the imaginary part.
	private double x,y;
	
	public Complex() { 
		//returns null for no arguments
	}
	
	//constructor for 2 arguments, real (x) and imaginary part (y)
	public Complex(double v1,double v2) {
		this.x=v1;
		this.y=v2;
	}
	
	//Defining final variables for useful complex numbers
	final static Complex ONE = new Complex(1,0);
	final static Complex ZERO = new Complex(0,0);
	final static Complex I = new Complex(0,1);
	
	
	//The output when a complex number is called in a print statement
	public String toString() {
		return this.x + " + " + this.y + "i"; 
	}
	
	//returns the real part
	public double real() {
		return this.x;
	}
	
	//returns the imaginary part
	public double imag() {
		return this.y;
	}
	
	//Finds the modulus or length of the complex number
	public double modulus() {
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}
	
	
	//The argument of the complex number,  we define it in radians and between -Pi and Pi.
	public double angle() {
		double agl = Math.atan(Math.abs(this.y)/Math.abs(this.x));
		if (this.x < 0 && this.y > 0) {
			agl = Math.PI - agl; //if the complex number is located in the upper left quadrant, we want the argument to indicate this by being greater than Pi/2
		}
		else if (this.x > 0 && this.y < 0) {
			agl = -agl; //defining the lower right quadrant of argand diagram as having the negative angle of the upper right quadrant
		}
		else if (this.x < 0 && this.y < 0) {
			agl = -Math.PI + agl; //defining the lower left quadrant as having the negative angle of the upper left quadrant
		}
		return agl;
	}
	
	
	//returns the complex number with the negative of the imaginary part
	public Complex conjugate() {
		return new Complex(this.x,-this.y);
	}
	
	
	//the complex number is returned with the same argument but with modulus 1.
	public Complex normalised() {
		if (this.modulus() == 0) {
			return new Complex(0,0);
		} else {
			double x2 = this.x/this.modulus();
			double y2 = this.y/this.modulus();
			return new Complex(x2,y2);
		}
	}
	
	
	//returns true if the current complex number is exactly equal to the complex number in the argument
	public boolean equals(Complex C) {
		if (this.x == C.x && this.y == C.y) {
			return true;
		} else {
			return false;
		}
	}
	
	//allows us to convert a given magnitude and angle in radians to a complex number in the form x + yi
	public static Complex setFromModulusAngle(double mag, double ang) { //the ang argument should be defined from -Pi to Pi
		double realv = mag * Math.cos(ang);
		double imgv = mag * Math.sin(ang);
		return new Complex(realv,imgv);
	}
	
	//static, addition of 2 complex numbers
	public static Complex add(Complex C1, Complex C2) {
		double x2 = C1.x + C2.x;
		double y2 = C1.y + C2.y;
		return new Complex(x2,y2);
		
	}
	
	//static, subtraction of 2 complex numbers
	public static Complex subtract(Complex C1, Complex C2) {
		double x2 = C1.x - C2.x;
		double y2 = C1.y - C2.y;
		return new Complex(x2,y2);
	}
	
	//static, multiplication of 2 complex numbers
	public static Complex multiply(Complex C1, Complex C2) {
		//using a pen and paper i found the formula for the new real and imaginary part of the output. This simply uses that formula.
		double x2 = C1.x * C2.x - C1.y * C2.y;
		double y2 = C1.y * C2.x + C2.y * C1.x;
		return new Complex(x2,y2);
	}
	
	//static, division of 2 complex numbers, in the form C1/C2
	public static Complex divide(Complex C1, Complex C2) {
		//again using a pen and paper, i found the formula for the real and imaginary parts and implemented it here
		double x2 = (C1.x * C2.x + C1.y * C2.y)/(C2.modulus()*C2.modulus());
		double y2 = (C1.y * C2.x - C2.y * C1.x)/(C2.modulus()*C2.modulus());
		return new Complex(x2,y2);
	}
}
