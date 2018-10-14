package module2;

public class ParticleMain {
	public static void main(String[] args) {
		//setting up the falling particle
		FallingParticle particle = new FallingParticle(4.3,2.4);
		
		particle.setH(5);
		particle.setV(0);
		particle.drop(0.5);
		System.out.println("dt = 0.5");
		System.out.println("The time taken to reach the bottom of the vessel is " + particle.getT() + " seconds.");
		System.out.println("The velocity when it hits the bottom of the vessel is " + particle.getV() + " m/s. \n");
		
		particle.setV(0);
		particle.drop(0.1);
		System.out.println("dt = 0.1");
		System.out.println("The time taken to reach the bottom of the vessel is " + particle.getT() + " seconds.");
		System.out.println("The velocity when it hits the bottom of the vessel is " + particle.getV() + " m/s. \n");
		
		particle.setV(0);
		particle.drop(0.01);
		System.out.println("dt = 0.01");
		System.out.println("The time taken to reach the bottom of the vessel is " + particle.getT() + " seconds.");
		System.out.println("The velocity when it hits the bottom of the vessel is " + particle.getV() + " m/s. \n");
		
		particle.setV(0);
		particle.drop(0.001);
		System.out.println("dt = 0.001");
		System.out.println("The time taken to reach the bottom of the vessel is " + particle.getT() + " seconds.");
		System.out.println("The velocity when it hits the bottom of the vessel is " + particle.getV() + " m/s. \n");
		
		particle.setV(0);
		particle.drop(0.0001);
		System.out.println("dt = 0.0001");
		System.out.println("The time taken to reach the bottom of the vessel is " + particle.getT() + " seconds.");
		System.out.println("The velocity when it hits the bottom of the vessel is " + particle.getV() + " m/s. \n");
		
		System.out.println("As we decrease the increment dt towards zero, the time taken and velocity calculated are more accurate."
				+ "\nThe acceleration,"
				+ " velocity and position functions with respect to time become smoother with smaller dt.");
	}


}
