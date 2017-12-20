package model;

import java.awt.Shape;

/**
 * Abstract factory that creates a Shape for use as prototype shapes in IPaintStrategy. 
 * The location of the center of the shape and the x and y scales can be specified.
 * @author Yuhui Tong
 *
 */
public interface IShapeFactory {

	/**
	 * Returns a shape object centered at (x, y) and with the specified x and y dimensions.
	 * @param x x-coordinate of the center of the shape
	 * @param y y-coordinate of the center of the shape
	 * @param xScale The x-dimension of the shape, usually the x-radius.
	 * @param yScale The y-dimension of the shape, usually the y-radius.
	 * @return A shape instance
	 */
	public Shape makeShape(double x, double y, double xScale, double yScale);
}
