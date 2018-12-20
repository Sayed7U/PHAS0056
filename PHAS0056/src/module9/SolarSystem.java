package module9;

import javax.swing.*;

/**
 * Creating a solar system model upto mars with an asteroid belt and halley's comet
 */
public class SolarSystem {
	/** Create and display JFrame containing animation GUI panel */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Orbits");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1000,1000);
				JPanel panel = new AnimationGuiPanel();
				frame.add(panel);
				frame.setVisible(true);
			}
		});
	}
}
