package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Circle is a concrete class extending the abstract AShape class.
 * It defines a circle object which can be painted onto screen.
 * @author Lyu Pan, Yuhui Tong
 *
 */
public class Circle extends AShape {

	/**
	 * Radius of Circle
	 */
	private int radius;

	/**
	 * Color of Circle
	 */
	private Color color;

	/**
	 * Constructor of Circle class
	 * @param loc upper-left corner of the rectangle containing the circle.
	 * @param radius radius of circle.
	 * @param color color color of circle.
	 */
	public Circle(Point loc, int radius, Color color) {
		super(loc);
		this.radius = radius;
		this.color = color;
	}

	/**
	 * Overridden paint method to paint Circle;
	 */
	public void paint(Graphics g) {
		//g.fillOval((int) loc.getX(), (int) loc.getY(), radius, radius);
		Point loc = this.getLoc();
		g.setColor(color);
		g.fillOval((int) loc.getX(), (int) loc.getY(), radius, radius);
	}
}
