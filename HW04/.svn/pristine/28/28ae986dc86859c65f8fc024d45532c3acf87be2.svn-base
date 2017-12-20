package model.paint.strategy;

import java.awt.Graphics;

import model.ball.Ball;

/**
 * Top-level interface that represents a strategy used by a Ball when
 *  asked to perform variant paint operations. A Ball has only one IPaintStrategy
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public interface IPaintStrategy {

	/**
	 * Paints the host onto the given Graphics context.
	 * @param g The graphics context to draw upon.
	 * @param host The host ball.
	 */
	public void paint(Graphics g, Ball host);

	/**
	 * Initializes the given ball.
	 * @param host The host ball.
	 */
	public void init(Ball host);

	/**
	 * Null-object instance for this interface.
	 */
	public static IPaintStrategy NULL_OBJECT = new IPaintStrategy() {

		@Override
		public void paint(Graphics g, Ball host) {

		}

		@Override
		public void init(Ball host) {

		}
	};

}
