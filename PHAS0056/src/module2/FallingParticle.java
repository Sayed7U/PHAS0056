package module2;

public class FallingParticle {
	
	final static double g = 9.81;
	private double m,d,t,z,h,v;
	
	public FallingParticle() {
		//returning null for no arguments
	}
	
	public FallingParticle(double v1,double v2) {
		this.m = v1;
		this.d = v2;
	}
	
	public void setH(double sh) {
		this.h = sh;
	}
	
	public void setV(double sv) {
		this.v = sv;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public double getV() {
		return this.v;
	}
	
	public double getT() {
		return this.t;
	}
	
	public void doTimeStep(double deltaT) {
		double a = ((this.d * this.v * this.v)/this.m) - g;
		this.v += a * deltaT;
		this.z += this.v * deltaT;
	}
	
	public void drop(double deltaT) {
		this.z = this.h;
		this.t = 0;
		while (this.getZ() > 0) {
			this.doTimeStep(deltaT);
			this.t += deltaT;
		}
	}
}
