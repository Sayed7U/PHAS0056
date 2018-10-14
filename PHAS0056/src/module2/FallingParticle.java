package module2;

public class FallingParticle {
	
	final static double g = 9.81; //the gravity of earth is constant and so is final
	private double m,d,t,z,h,v; //setting up mass m, drag coeff d, time elapsed t, vertical position z, initial starting pos h, velocity v
	
	public FallingParticle() {
		//returning null for no arguments
	}
	
	//constructor with 2 arguments, the mass and the drag coeff
	public FallingParticle(double m1,double d2) {
		this.m = m1;
		this.d = d2;
	}
	
	//sets the height of the falling particle
	public void setH(double sh) {
		this.h = sh;
	}
	
	//sets the initial velocity of the particle
	public void setV(double sv) {
		this.v = sv;
	}
	
	//returns the current position of the particle (z pos)
	public double getZ() {
		return this.z;
	}
	
	//returns the current velocity of the particle
	public double getV() {
		return this.v;
	}
	
	//returns the time elapsed since the particle was dropped
	public double getT() {
		return this.t;
	}
	
	//calculates v and z for the next time step.
	public void doTimeStep(double deltaT) {
		double a = ((this.d * this.v * this.v)/this.m) - g; //eqn given in task
		this.v += a * deltaT;
		this.z += this.v * deltaT;
	}
	
	//drops the particle, loops over the timestep until its position is zero (hits the bottom of the vessel)
	public void drop(double deltaT) {
		this.z = this.h;
		this.t = 0;
		while (this.getZ() > 0) {
			this.doTimeStep(deltaT);
			this.t += deltaT;
		}
	}
}
