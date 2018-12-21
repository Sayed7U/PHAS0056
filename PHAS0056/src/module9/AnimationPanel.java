package module9;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

/**
 * JPanel containing the sun,planets, asteroids and comet
 * that can be stopped and started.
 */
@SuppressWarnings("serial")
public class AnimationPanel extends JPanel implements ActionListener {
	private final int delay = 100; // delay in ms between steps
	private final double delta;   // the step in which the angle increases
	private double angle = 0.0;   // initial angle for the planets
	private Timer animationTimer; // timer controlling frame rate
	public long factor = 1; // rate at which the time increases by
	private final int AU = 149597871; // astronomical unit in km
	private final int R0 = 695508; // radius of the sun in km
	public static TimeWatch watch = TimeWatch.start(); // timewatch used to get time elapsed
	ArrayList<Double> randomRadius = new ArrayList<Double>(); // arraylist of random numbers assigned to the radius of an asteroid orbit
	ArrayList<Double> randomPhase = new ArrayList<Double>(); // arraylist of random numbers assigned to the phase of an asteroid orbit
	boolean firstFrame = true; // checks whether it is the first frame of the animation
	/**
	 * Setting the constructor
	 * @param width width of panel
	 * @param height height of panel
	 */
	AnimationPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		delta = delay* 2 * Math.PI;
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}
	/** converts seconds to a string with years, days, hours, minutes and seconds */
	public String secondsFormat(long seconds) {
		long year = seconds / (60 * 60 * 24 * 365);
		long day = TimeUnit.SECONDS.toDays(seconds) - year*365;
		long hours = TimeUnit.SECONDS.toHours(seconds) - (TimeUnit.SECONDS.toDays(seconds)* 24);
		long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60);
		long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) *60);
		return year + " years: "+ day + " days: " + hours + " hours: " + minute + " minutes: " + second + " seconds";
	}
	/** Paint shape at appropriate angle. */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		int sunRadius = 10;
		long timeElapsed = watch.time(TimeUnit.SECONDS) * this.factor;
		AnimationGuiPanel.factor.setText("Multiplier: " + this.factor + "x");
		AnimationGuiPanel.timeElapsed.setText("Time elapsed: " + secondsFormat(timeElapsed));
		// Fill in background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		// Now move origin to centre of panel
		g.translate(width/2, height/2);
		// Drawing the sun
		g.setColor(Color.YELLOW);
		g.fillOval(-sunRadius,-sunRadius,2 * sunRadius,2 * sunRadius);
		// mercury, making the planet 100 times bigger and radius of orbit 10 times smaller
		g.setColor(Color.ORANGE);
		planet(g,0.3507*sunRadius,8.43*sunRadius,88*24*60*60,0,true);
		// venus, making the planet 100 times bigger and radius of orbit 10 times smaller
		g.setColor(Color.BLUE);
		planet(g,0.8699*sunRadius,15.55*sunRadius,225*24*60*60,0,true);
		// earth, making the planet 100 times bigger and radius of orbit 10 times smaller
		g.setColor(Color.GREEN);
		planet(g,0.9158*sunRadius,21.5*sunRadius,365*24*60*60,0,true);
		// mars, making the planet 100 times bigger and radius of orbit 10 times smaller
		g.setColor(Color.RED);
		planet(g,0.4872*sunRadius,32.76*sunRadius,687*24*60*60,0,true);
		// halley's comet, making the comet 100,000 times bigger and radius of orbit 10 times smaller
		g.setColor(Color.WHITE);
		comet(g,((double)6/R0)*sunRadius*100000,((17.834*AU)/R0)*sunRadius*0.1,((35.082*AU)/R0)*sunRadius*0.1,0.96714,76*365.25*24*60*60,0,true);
		// asteroid belt, the radius 0.2 times radius of sun and the radius of orbit 10 times smaller
		g.setColor(Color.GRAY);
		asteroid(g,0.2*sunRadius,2.2*(AU/R0)*sunRadius*0.1,1000,(AU/R0)*sunRadius*0.1,900*24*60*60);
	}

	/** Start the animation */
	public void start() {
		animationTimer.start();
		watch.play();
	}

	/** Stop the animation */
	public void stop() {
		animationTimer.stop();
		watch.pause();
	}
	/**
	 * Creating the planet motion
	 * @param g the graphic used
	 * @param r1 the radius of the planet
	 * @param r2 the radius of the orbit
	 * @param period the time to complete 1 orbit
	 * @param phase the offset factor for the orbit (where it starts)
	 * @param drawOrbit whether we want the orbit to be drawn out or not
	 */
	public void planet(Graphics g, double r1, double r2, double period,double phase,boolean drawOrbit) {
		// x =  r cos(2PiX/T + phase)
		double x = r2  * Math.cos((angle/(period*1000)+phase)*this.factor);
		// y =  r sin(2PiX/T + phase)
		double y = r2  * Math.sin((angle/(period*1000)+phase)*this.factor);
		g.fillOval((int)(x-r1), (int)(y-r1), 2 * (int) r1, 2 * (int) r1);
		if (drawOrbit) {
			g.setColor(Color.DARK_GRAY);
			g.drawOval((int)(0-r2), (int)(0-r2), 2 * (int) r2, 2 * (int) r2);
		}
	}
	/**
	 * Creating the comet motion
	 * @param g the graphic used
	 * @param r1 the radius of the comet
	 * @param a the length of the semi major axis
	 * @param aph the aphelion, extreme point of the orbit (greatest distance from sun)
	 * @param ecc the eccentricity of the orbit (how much it deviates from being circular)
	 * @param period the time to complete 1 orbit
	 * @param phase the offset factor for the orbit (where it starts)
	 * @param drawOrbit whether we want the orbit to be drawn out or not
	 */
	public void comet(Graphics g,double r1,double a,double aph,double ecc,double period,double phase,boolean drawOrbit) {
		double b = Math.sqrt(a*a*(1-ecc*ecc));
		double r = (a * (1 - ecc*ecc))/(1+ ecc * Math.cos(((angle+phase)/(period*1000))*this.factor));
		double x = r * Math.cos((angle/(period*1000)+phase)*this.factor);
		double y = r * Math.sin((angle/(period*1000)+phase)*this.factor);
		g.fillOval((int)(x-r1), (int)(y-r1), 2 * (int) r1, 2 * (int) r1);
		if (drawOrbit) {
			g.setColor(Color.DARK_GRAY);
			g.drawOval((int)(0 -aph), (int)(0-b), 2 * (int) a, 2 * (int) b);
		}
	}
	/**
	 * Creating the asteroid motion
	 * @param g the graphic used
	 * @param r1 the radius of the asteroid
	 * @param r2 the radius of the orbit
	 * @param n the number of asteroids
	 * @param t the thickness of the asteroid belt
	 * @param period the time to complete 1 orbit
	 */
	public void asteroid(Graphics g, double r1,double r2,int n, double t,double period) {
		for (int i=0; i < n; i++) {
			if (firstFrame) {
				randomRadius.add(Math.random());
				randomPhase.add(Math.random());
			}
			planet(g,r1,r2+(int) (randomRadius.get(i)*t) ,period,2 *Math.PI*randomPhase.get(i),false); //treat each asteroid like a planet orbit
		}
		firstFrame = false;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		angle += delta;
		repaint();
	}
}
