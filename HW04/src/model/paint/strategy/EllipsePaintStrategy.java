package model.paint.strategy;

import java.awt.geom.AffineTransform;

import model.paint.shape.EllipseShapeFactory;

/**
 * Paint strategy to paint an ellipse shape
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public class EllipsePaintStrategy extends ShapePaintStrategy {

	/**
	 * No parameter constructor that creates a prototype ellipse that has twice the width as height but an average radius of 1.
	 */
	public EllipsePaintStrategy() {
		super(EllipseShapeFactory.Singleton.makeShape(0, 0, 4.0 / 3, 2.0 / 3));
		//this(new AffineTransform(), -2.0/3, -1.0/3, 4.0/3, 2.0/3);
	}

	/**
	 * Constructor that allows the specification of the location x-radius and y-radius of th
	 * prototype ellipse. The affineTransform to use is given.
	 * @param at The AffineTransform to use for internal calculations
	 * @param x floating point x-coordinate of center of circle
	 * @param y floating point y-coordinate of center of circle
	 * @param width floating point x-radius of the circle (ellipse)
	 * @param height floating point y-radius of the circle (ellipse)
	 */
	public EllipsePaintStrategy(AffineTransform at, double x, double y, double width, double height) {
		super(at, EllipseShapeFactory.Singleton.makeShape(x, y, width, height));
	}

}
