package model.paint.strategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.ball.Ball;
import model.paint.MultiPaintStrategy;

/**
 * Subclass of MultiPaintStrategy that uses a SwimFishPaintStrategy 
 * and an EllipsePaintStrategy to paint a swimming fish shape that has an eye.
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public class NiceFishPaintStrategy extends MultiPaintStrategy {

	/**
	 * No-parameter constructor that instantiates the AffineTransform for internal use.
	 */
	public NiceFishPaintStrategy() {
		super(new SwimFishPaintStrategy(), new FixedColorDecoratorPaintStrategy(Color.BLACK,
				new EllipsePaintStrategy(new AffineTransform(), 1.0 / 3, -1.0 / 3, 0.2, 0.2)));
	}

	/**
	 * Constructor that uses an externally supplied AFfineTransform for internal use.
	 * @param g The Graphics context that will be drawn upon.
	 * @param host The Ball to be painted.
	 */

	@Override
	protected void paintCfg(Graphics g, Ball host) {
		super.paintCfg(g, host);
		if (Math.abs(Math.atan2(host.getVelocity().y, host.getVelocity().x)) > Math.PI / 2.0) {
			getAT().scale(1.0, -1.0);
		}

	}

}
