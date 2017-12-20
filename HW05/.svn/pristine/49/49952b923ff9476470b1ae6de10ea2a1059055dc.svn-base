package model.paint.shape;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import model.IShapeFactory;

/**
 * Concrete shape factory that instantiates Ellipse2D.Double shapes.
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public class EllipseShapeFactory implements IShapeFactory {

	/**
	 * Singleton pattern
	 */
	public static EllipseShapeFactory Singleton = new EllipseShapeFactory();

	/**
	 * Singleton pattern
	 */
	private EllipseShapeFactory() {
	}

	/**
	 * {@inheritDoc}<br/>
	 */
	@Override
	public Shape makeShape(double x, double y, double xScale, double yScale) {
		return new Ellipse2D.Double(x - xScale, y - yScale, 2 * xScale, 2 * yScale);
	}

}
