package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Rectangle is a concrete class that extends the abstract AShape class.
 * It defines a Rectangle object which can be paint onto screen.
 * @author Lyu Pan, Yuhui Tong
 * 
 */
public class Rectangle extends AShape {

	/**
	 * The width of rectangle.
	 */
	private int width;

	/**
	 * The height of rectangle.
	 */
	private int height;

	/**
	 * Color of rectangle.
	 */
	private Color color;

	/**
	 * Constructor of Rectangle class.
	 * @param loc  the upper left corner of rectangle.
	 * @param width width of rectangle.
	 * @param height height of rectangle.
	 * @param color color of rectangle.
	 */
	public Rectangle(Point loc, int width, int height, Color color) {
		super(loc);
		this.color = color;
		this.width = width;
		this.height = height;
	}

	/**
	 * Overridden paint method to paint rectangle.
	 */
	@Override
	public void paint(Graphics g) {
		Point loc = this.getLoc();
		g.setColor(color);
		g.fillRect((int) loc.getX(), (int) loc.getY(), width, height);
	}

}
