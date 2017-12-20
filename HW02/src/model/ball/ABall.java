package model.ball;

import java.awt.Point;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

/**
 * The abstract class of all Balls
 * @author Yuhui Tong, Anqi Yu
 * @version 1.0 
 */
public abstract class ABall implements Observer {

	/**
	 * The location of the ball
	 */
	protected Point location;

	/**
	 * The radius of the ball;
	 */
	protected int radius;

	/**
	 * The velocity of the ball during moving, which is represented by a point
	 */
	protected Point velocity;

	/**
	 * The color of the ball;
	 */
	protected Color color;

	/**
	 * The canvas
	 */
	protected Component Canvas;

	/**
	 * Constructor of ABall
	 * @param startLoc Initial location of the ball
	 * @param startRadius Initial radius of the ball
	 * @param startVel Initial velocity of the ball
	 * @param startColor Initial color of the ball
	 * @param theCanvas The canvas jpanel object
	 */
	public ABall(Point startLoc, int startRadius, Point startVel, Color startColor, Component theCanvas) {
		this.location = startLoc;
		this.radius = startRadius;
		this.velocity = startVel;
		this.color = startColor;
		this.Canvas = theCanvas;
	}

	/**
	 * This method is called whenever the observed object is changed. An application calls an Observable object's notifyObservers method to have
	 * all the observers notified of the change.
	 * @param o the observable object
	 * @param arg An argument passed to the notifyObservers method.
	 */
	public void update(Observable o, Object arg) {
		paint((Graphics) arg);
		move();
		updateBalls();
		bounce();
	}

	/**
	 * This method paints the ball
	 * @param g The graphics object
	 */
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(location.x - radius, location.y - radius, 2 * radius, 2 * radius);
	}

	/**
	 * Default method that simulate the movement of the ball
	 */
	public void move() {
		location.x += velocity.x;
		location.y += velocity.y;
	}

	/**
	 * This method defines different characteristics of concrete subclasses of ABall.
	 * Will be overriden in concrete subclasses.
	 */
	public void updateBalls() {

	}

	/**
	 * This method simulate the bouncing behavior of the ball
	 */
	public void bounce() {
		// bounced by the left wall
		if (location.x - radius < 0) {
			location.x = 2 * radius - location.x;
			velocity.x = -velocity.x;
		}

		// bounced by the right wall
		if (location.x + radius > Canvas.getWidth()) {
			location.x = 2 * (Canvas.getWidth() - radius) - location.x;
			velocity.x = -velocity.x;
		}

		// bounced by the bottom wall
		if (location.y - radius < 0) {
			velocity.y = -velocity.y;
			location.y = 2 * radius - location.y;
		}

		// bounced by the upper wall
		if (location.y + radius > Canvas.getHeight()) {
			velocity.y = -velocity.y;
			location.y = 2 * (Canvas.getHeight() - radius) - location.y;
		}
	}
}
