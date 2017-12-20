package model.ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import util.Randomizer;

/**
 * An concrete subclass of ABall
 * A ButterflyBall changes color all the time during movement.
 * @author Yuhui Tong, Anqi Yu
 * @version 1.0
 */
public class ButterflyBall extends ABall {
	/**
	 * Constructor of ButterflyBall
	 * @param startLoc Initial location of the ball
	 * @param startRadius Initial radius of the ball
	 * @param startVel Initial velocity of the ball
	 * @param startColor Initial color of the ball
	 * @param theCanvas The canvas jpanel object
	 */
	public ButterflyBall(Point initialLocation, int initialRadius, Point initialVelocity, Color initialColor, Component theCanvas) {
		super(initialLocation, initialRadius, initialVelocity, initialColor, theCanvas);
	}

	/**
	 * Assign random color to ButterflyBall for every _timeslice
	 */
	public void updateBalls() {
		this.color = Randomizer.Singleton.randomColor();
	}
}
