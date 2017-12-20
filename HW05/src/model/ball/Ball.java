package model.ball;

import java.awt.Point;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import util.IDispatcher;
import util.IObserver;
import model.IBallCmd;
import model.IInteractStrategy;
import model.IPaintStrategy;
import model.IUpdateStrategy;

/**
 * The class of ball object which behaves using a strategy object.
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0 
 */
//public class Ball implements Observer {
public class Ball implements IObserver<IBallCmd> {
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
	protected Component canvas;

	/**
	 * The updating strategy that ball takes.
	 */
	protected IUpdateStrategy<IBallCmd> strategy;

	protected IPaintStrategy paintStrategy;

	protected IInteractStrategy interactStrategy = IInteractStrategy.NULL_STRATEGY;

	/**
	 * Constructor of ABall
	 * @param initialLocation Initial location of the ball
	 * @param initialRadius Initial radius of the ball
	 * @param initialVelocity Initial velocity of the ball
	 * @param initialColor Initial color of the ball
	 * @param theCanvas The canvas jpanel object
	 * @param strategy The strategy that ball behaves
	 * @param paintStrategy The paintStrategy that ball uses
	 */
	public Ball(Point initialLocation, int initialRadius, Point initialVelocity, Color initialColor,
			Component theCanvas, IUpdateStrategy<IBallCmd> strategy, IPaintStrategy paintStrategy) {
		this.location = initialLocation;
		this.radius = initialRadius;
		this.velocity = initialVelocity;
		this.color = initialColor;
		this.canvas = theCanvas;
		setUpdateStrategy(strategy);
		setPaintStrategy(paintStrategy);
	}

	/**
	 * Post-contact interaction behavior of THIS ball on a target ball.
	 * @param target The Target ball to be interacted with.
	 * @param dispatcher The observable.
	 */
	public void interactWith(Ball target, IDispatcher<IBallCmd> dispatcher) {
		interactStrategy.interact(this, target, dispatcher);
	}

	/**
	 * receive message (command) from this dispatcher
	 */
	public void update(IDispatcher<IBallCmd> dispatcher, IBallCmd msg) {
		msg.apply(this, dispatcher);
	}

	/**
	 * Update the dstate of the ball.
	 * @param disp The dispatcher to use if necessary.
	 */
	public void updateState(IDispatcher<IBallCmd> disp) {
		strategy.updateState(this, disp);
	}

	/**
	 * This method paints the ball
	 * @param g The graphics object
	 */
	public void paint(Graphics g) {
		//g.setColor(color);
		//g.fillOval(location.x - radius, location.y - radius, 2 * radius, 2 * radius);
		paintStrategy.paint(g, this);
	}

	/**
	 * Default method that simulate the movement of the ball
	 */
	public void move() {
		location.x += velocity.x;
		location.y += velocity.y;
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
		if (location.x + radius > canvas.getWidth()) {
			location.x = 2 * (canvas.getWidth() - radius) - location.x;
			velocity.x = -velocity.x;
		}

		// bounced by the bottom wall
		if (location.y - radius < 0) {
			velocity.y = -velocity.y;
			location.y = 2 * radius - location.y;
		}

		// bounced by the upper wall
		if (location.y + radius > canvas.getHeight()) {
			velocity.y = -velocity.y;
			location.y = 2 * (canvas.getHeight() - radius) - location.y;
		}
	}

	/**
	 * Location setter
	 * @param p the location of ball
	 */
	public void setLocation(Point p) {
		location = p;
	}

	/**
	 * Location getter
	 * @return The location of ball
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * Radius setter
	 * @param r The radius of ball
	 */
	public void setRadius(int r) {
		radius = r;
	}

	/**
	 * Radius getter
	 * @return The radius of ball
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Velocity setter
	 * @param v The velocity of ball
	 */
	public void setVelocity(Point v) {
		velocity = v;
	}

	/**
	 * Velocity getter
	 * @return The velocity of ball.
	 */
	public Point getVelocity() {
		return velocity;
	}

	/**
	 * Color setter
	 * @param c The color of ball.
	 */
	public void setColor(Color c) {
		color = c;
	}

	/**
	 * Color getter
	 * @return The color of ball.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Strategy setter
	 * @param updateStrategy The strategy that ball takes
	 */
	public void setUpdateStrategy(IUpdateStrategy<IBallCmd> updateStrategy) {
		strategy = updateStrategy;
		updateStrategy.init(this); // initialize the interactStrategy
	}

	/**
	 * Strategy getter
	 * @return The strategy that ball takes.
	 */
	public IUpdateStrategy<IBallCmd> getStrategy() {
		return strategy;
	}

	/**
	 * Canvas getter
	 * @return The JComponent that ball is paint on.
	 */
	public Component getCanvas() {
		return canvas;
	}

	/**
	 * Paint Strategy setter
	 * @param paintStrategy The paintStrategy for a ball to take.
	 */
	public void setPaintStrategy(IPaintStrategy paintStrategy) {
		this.paintStrategy = paintStrategy;
		this.paintStrategy.init(this);
	}

	/**
	 * Paint Strategy getter
	 * @return The paint strategy
	 */
	public IPaintStrategy getPaintStrategy() {
		return paintStrategy;
	}

	/**
	 * interactStrategy setter
	 * @param interactStrategy The interactStrategy for a ball to take.
	 */
	public void setInteractStrategy(IInteractStrategy interactStrategy) {
		this.interactStrategy = interactStrategy;

	}

	/**
	 * InteractStrategy getter
	 * @return The interactStrategy that the Ball takes.
	 */
	public IInteractStrategy getInteractStrategy() {
		return this.interactStrategy;
	}
}
