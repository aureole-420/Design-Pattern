package model.ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import util.Randomizer;

/**
 * An concrete subclass of ABall.
 * A BreathingBall changes its radius during movement.
 * @author Yuhui Tong, Anqi Yu
 * @version 1.0
 */
public class BreathingBall extends ABall {

	/**
	 * Constructor of BreathingBall
	 * @param startLoc Initial location of the ball
	 * @param startRadius Initial radius of the ball
	 * @param startVel Initial velocity of the ball
	 * @param startColor Initial color of the ball
	 * @param theCanvas The canvas jpanel object
	 */
	public BreathingBall(Point initialLocation, int initialRadius, Point initialVelocity, Color initialColor, Component theCanvas) {
		super(initialLocation, initialRadius, initialVelocity, initialColor, theCanvas);
	}

	/**
	 * Specific ball behavior: changing the radius;
	 */
	public void updateBalls() {
		int temp = this.radius + Randomizer.Singleton.randomInt(5, 10);
		while (temp < 5 || temp > 25) {
			temp = this.radius + Randomizer.Singleton.randomInt(-10, 10);
		}
		this.radius = temp;

	}
}
