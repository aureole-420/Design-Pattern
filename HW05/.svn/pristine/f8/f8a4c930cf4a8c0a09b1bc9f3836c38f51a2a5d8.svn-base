package model.paint.shape;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import model.IShapeFactory;

/**
 * Concrete IShapeFactory that instantiates Rectangle2d.Double shapes.
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public class RectangleShapeFactory implements IShapeFactory {

	/**
	 * Singleton pattern
	 */
	public static RectangleShapeFactory Singleton = new RectangleShapeFactory();

	/**
	 * Singleton pattern
	 */
	private RectangleShapeFactory() {

	}

	@Override
	/**
	 * Instantiates a Rectangle2D.Double object at the specified orign and size.
	 * @param x x-coordinate of the center of the shape
	 * @param y y-coordinate of the center of the shape
	 * @param xScale The x-dimension of the shape, usually the x-radius.
	 * @param yScale The y-dimension of the shape, usually the y-radius.
	 */
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		return new Rectangle2D.Double(x - xScale, y - yScale, 2 * xScale, 2 * yScale);
	}

}
