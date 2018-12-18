package module9;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

/**
 * JPanel containing a rotating square
 * that can be stopped and started.
 */
@SuppressWarnings("serial")
public class AnimationPanel extends JPanel implements ActionListener {
	private Polygon shape;        // shape to be displayed
	private final int delay = 10; // delay in ms between steps
	private final double delta;   // angle to rotate in each step
	private double angle = 0.0;   // current angle of shape on screen
	private Timer animationTimer; // timer controlling frame rate
	public long factor = 1;
	private TimeWatch watch = TimeWatch.start();
	/**
	 * Create panel with rotating shape.
	 * @param width width of panel
	 * @param height height of panel
	 * @param rotationTime time for complete rotation [seconds]
	 */
	AnimationPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		int size = Math.min(width, height) / 4;
		int[] xpts = {size,-size,-size,size};
		int[] ypts = {size, size,-size,-size};
		shape = new Polygon(xpts,ypts,4);
		delta = 2*Math.PI*delay;
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}
	public String secondsFormat(long seconds) {
		int day = (int)TimeUnit.SECONDS.toDays(seconds);        
		long hours = TimeUnit.SECONDS.toHours(seconds) - (day *24);
		long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60);
		long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) *60);
		return day + " days: " + hours + " hours: " + minute + " minutes: " + second + " seconds";
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
		g.setColor(Color.GREEN);
		//mercury, making the planet 100 times bigger and radius of orbit 10 times smaller
		planet(g,0.3507*sunRadius,8.43*sunRadius,88*24*60*60,0,true);
	}

	/** Start the animation */
	public void start() {animationTimer.start();}

	/** Stop the animation */
	public void stop() {animationTimer.stop();}

	public void planet(Graphics g, double r1, double r2, double period,double phase,boolean drawOrbit) {
		// x =  r cos(ax + b)
		double x = r2  * Math.cos((angle+phase)/(period*1000)*this.factor);
		// y =  r sin(ax + b)
		double y = r2  * Math.sin((angle+phase)/(period*1000)*this.factor);
		g.fillOval((int)(x-r1), (int)(y-r1), 2 * (int) r1, 2 * (int) r1);
		if (drawOrbit) {
			g.setColor(Color.DARK_GRAY);
			g.drawOval((int)(0-r2), (int)(0-r2), 2 * (int) r2, 2 * (int) r2);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		angle += delta;
		repaint();
	}
}
