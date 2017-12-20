package model.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

/**
 * Concrete class that defines invariant painting behaviors to paint Shape objects 
 * for all its subclasses. Note: This cannot be directly instantiated 
 * by the BallWorld system because it lacks a no-parameter constructor.
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public class ShapePaintStrategy extends APaintStrategy {

	/**
	 * The Shape to be painted
	 */
	private Shape shape;

	/**
	 * Constructor that allocates a new AffineTransform for internal use.
	 * @param shape The Shape to be painted
	 */
	public ShapePaintStrategy(Shape shape) {
		super(new AffineTransform());
		this.shape = shape;
	}

	/**
	 * Constructor that uses a supplied AffineTransform for internal use.
	 * @param at The AffineTransform to use.
	 * @param shape The shape to be painted.
	 */
	public ShapePaintStrategy(AffineTransform at, Shape shape) {
		super(at);
		this.shape = shape;
	}

	/**
	@Override
	public void paint(Graphics g, Ball host) {
		double scale = host.getRadius();
	
		
		AffineTransform at = super.getAT();
		at.setToTranslation(host.getLocation().x, host.getLocation().y);
		at.scale(scale, scale);
		at.rotate(host.getVelocity().x, host.getVelocity().y);
		g.setColor(host.getColor());
	
		
		paintCfg(g, host);
		paintXfrm(g, host, at);	
		
	}
	*/

	/**
	 * Paints the shape on the given Graphics context using the supplied AffineTransform. 
	 * Called by the inherited paint method.
	 * @param g The Graphics context to paint upon.
	 * @param host The host Ball
	 * @param at The AffineTransform to use
	 */
	@Override
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		Shape newShape = at.createTransformedShape(shape);
		((Graphics2D) g).fill(newShape);
	}

}
