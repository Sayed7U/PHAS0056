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
	
	public String getZ() {
		return "The current position of the particle is "+ this.z;
	}
	
	public double getV() {
		return this.v;
	}
	
	public double getT() {
		return this.t;
	}
	
	public  void doTimeStep(double deltaT) {
		double a = ((this.d * this.v * this.v)/this.m) - g;
		this.v = this.v + a * deltaT;
		this.z = this.z + this.v * deltaT;
	}
	
	public void drop(double deltaT) {
		this.z = this.h;
		this.t = 0;
		while (this.z > 0) {
			this.doTimeStep(deltaT);
			this.t = this.t + deltaT;
		}
	}

	public static void main(String[] args) {
		FallingParticle particle = new FallingParticle(4.3,2.4);
		particle.setH(5);
		particle.setV(0);
		particle.drop(0.5);
		System.out.println("The time taken to reach the bottom of the vessel is " + particle.getT());
		System.out.println("The velocity when it hits the bottom of the vessel is " + particle.getV());
		
		particle.setH(5);
		particle.setV(0);
		particle.drop(0.1);
		System.out.println("The time taken to reach the bottom of the vessel is " + particle.getT());

	}

}