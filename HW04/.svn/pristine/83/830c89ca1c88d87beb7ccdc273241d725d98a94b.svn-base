package model.paint;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import model.ball.Ball;
import model.paint.strategy.IPaintStrategy;

/**
 * The top-level affine transform-based paint strategy that provides services for its subclasses, plus default behaviors and abstract behaviors
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public abstract class APaintStrategy implements IPaintStrategy {

	/**
	 * The affine transform used by this paint strategy to translate, scale and rotate the image.
	 */
	private AffineTransform at = new AffineTransform();

	/**
	 * Protected accessor for the internal affine transform
	 * @return This instances's affine transform.
	 */
	protected AffineTransform getAT() {
		return at;
	}

	/**
	 * By default, do nothing for initialization.
	 * @param ball The ball to initialize.
	 */
	public void init(Ball ball) {
		return;
	}

	/**
	 * Constructor that initializes the strategy with an affine transform
	 * @param at The affine transform used by this paint strategy to translate, scale and rotate the image.
	 */
	public APaintStrategy(AffineTransform at) {
		this.at = at;
	}

	/**
	 * Paints on the given graphics context using the color, scale and direction provided by the host. 
	 * This is done by setting up the AffineTransform to rotate then scale then translate. 
	 * Calls paintXfrm to actually perform the painting, using the set up transform. 
	 * Calls paintCfg just before calling paintXfrm
	 * @param g The Graphics context that will be paint on
	 * @param host The host Ball that the required information will be pulled from.
	 */
	public void paint(Graphics g, Ball host) {
		double scale = host.getRadius();
		at.setToTranslation(host.getLocation().x, host.getLocation().y);
		at.scale(scale, scale);
		at.rotate(host.getVelocity().x, host.getVelocity().y);
		g.setColor(host.getColor());

		paintCfg(g, host);
		paintXfrm(g, host, at);

	}

	/**
	 * sed for doing additional configurations by a subclass. 
	 * The translation, rotation and scaling transformations have already been applied to this object's AffineTransform instance. 
	 * This method is called before the paint method's final delegation to paintXfrm. 
	 * This method is designed to be overridden by the subclass. By default the behavior is a no-op.
	 * @param g The Graphics context that will be drawn upon.
	 * @param host The Ball to be painted.
	 */
	protected void paintCfg(Graphics g, Ball host) {

	}

	/**
	 * Paints the host onto the given Graphics context. 
	 * The image is translated, scaled and rotated as determined by the given affine transformation.
	 *  This method is intended to be called either by a class's (or superclass's) own paint method or by another paint strategy who is sharing the affine transform. 
	 *  This allows the same transformation to be shared amongst multiple paint strategies.
	 * @param g The graphics context to draw upon.
	 * @param host The host ball.
	 * @param at The affine transform to use.
	 */
	public abstract void paintXfrm(Graphics g, Ball host, AffineTransform at);

}
