package module9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Panel with start, stop, exit, forward and backward buttons.
 */
@SuppressWarnings("serial")
public class AnimationGuiPanel extends JPanel
implements ActionListener {
	private AnimationPanel animPanel; // panel containing animation
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	private JButton forwardButton;
	private JButton backwardButton;
	public static JLabel factor;
	public static JLabel timeElapsed;
	public static JLabel legend;

	/** Create JPanel containing animation panel and buttons. */
	public AnimationGuiPanel() {
		super();
		setPreferredSize(new Dimension(1500,1000));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		animPanel = new AnimationPanel(1500,1000);
		startButton = new JButton("Start");
		stopButton  = new JButton("Stop");
		exitButton = new JButton("Exit");
		forwardButton = new JButton("Forward");
		backwardButton = new JButton("Backward");
		factor = new JLabel();
		timeElapsed = new JLabel();
		legend = new JLabel();
		
		legend.setText("Sun: Yellow    Mercury: Orange    Venus: Blue    Earth: Green    Mars: Red    Asteroids: Grey    Halley's comet: White");

		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		forwardButton.addActionListener(this);
		backwardButton.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		buttonPanel.add(forwardButton);
		buttonPanel.add(backwardButton);

		add(animPanel);
		add(buttonPanel);
		add(factor);
		add(timeElapsed);
		add(legend);

	}

	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		if (e.getSource()==forwardButton) {
			animPanel.factor= animPanel.factor * 10;
		};
		if (e.getSource()==backwardButton) {
			if (animPanel.factor != 1) {
				animPanel.factor= animPanel.factor / 10;
			}
		};
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()==exitButton) System.exit(0);
	}

	/** Start animation */
	public void start() {
		animPanel.start();
		AnimationPanel.watch.play();
	}

	/** Stop animation */
	public void stop() {
		animPanel.stop();
		AnimationPanel.watch.pause();
	}
}