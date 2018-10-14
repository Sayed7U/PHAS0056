package module2;

public class FallingParticle {
	
	final static double g = 9.81;
	double m,d,t,z,h,v;
	
	public FallingParticle() {
		//returning null for no arguments
	}
	
	public FallingParticle(double v1,double v2) {
		m = v1;
		d = v2;
	}
	
	public String setH(double sh) {
		h = sh;
		return "Height set to: "+ h;
	}
	
	public String setV(double sv) {
		v = sv;
		return "Velocity set to: "+ v;
	}
	
	public String getZ() {
		return "The current position of the particle is "+ z;
	}
	
	public String getV() {
		return "The current velocity of the particle is "+ v;
	}
	
	public String getT() {
		return "The time elapsed since the particle was dropped is "+ t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
