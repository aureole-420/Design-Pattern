package model.paint.strategy;

import java.awt.Graphics;

import model.IPaintStrategy;
import model.ball.Ball;

/**
 * Paint strategy that paints a filled square with the Ball's radius. 
 * This functionality is duplicated by the RectanglePaintStrategy. 
 * The class demonstrates a direct implementation of IPaintStrategy.
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public class SquarePaintStrategy implements IPaintStrategy {
	/**
	 * No parameter constructor for the class.
	 */
	public SquarePaintStrategy() {

	}

	@Override
	/**
	 * Paints a square on the given graphics context using the color and radius
	 * provided by the host.
	 * @param g The Graphics context that will be painted on
	 * @param host The host ball that the required information will be pulled from.
	 */
	public void paint(Graphics g, Ball host) {
		int halfSide = host.getRadius();
		g.setColor(host.getColor());
		g.fillRect(host.getLocation().x - halfSide, host.getLocation().y - halfSide, 2 * halfSide, 2 * halfSide);

	}

	@Override
	/**
	 * By default, do nothing for initialization.
	 */
	public void init(Ball host) {

	}

}
