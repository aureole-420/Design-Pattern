package model.paint;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;

import model.ball.Ball;

/**
 * A composite design pattern extension of APaintStrategy that paints a set of paint strategies. 
 * Note: This paint strategy cannot be used directly by the BallWorld system because it lacks a no-parameter constructor.
 * @author Yuhui Tong, Haoyuan Yue
 */
public class MultiPaintStrategy extends APaintStrategy {

	/**
	 * The set of paint strategies to paint
	 */
	private APaintStrategy[] pstrats;

	/**
	 * Constructor that takes the paint strategies that are of the composite.
	 * @param at The AffineTransform to use.
	 * @param pstrats paint strategies
	 */
	public MultiPaintStrategy(AffineTransform at, APaintStrategy... pstrats) {
		super(at);
		this.pstrats = pstrats;
	}

	public MultiPaintStrategy(APaintStrategy... pstrats) {
		this(new AffineTransform(), pstrats);
	}

	/**
	 * Delegates to all the IPaintStrategies in the composite. Paints using given graphics context using the supplied AffineTransform.
	 * Called by the inherited paint method.
	 * @param g The graphics context to paint upon.
	 * @param host The host Ball
	 * @param at The AffineTransform to use.
	 */
	@Override
	public void paintXfrm(Graphics g, Ball host, AffineTransform at) {
		for (int i = 0; i < pstrats.length; i++) {
			pstrats[i].paintXfrm(g, host, at);
		}

	}

	/**
	 * Delegates to all the IPaintStrategies in the composite. Used to initialize the paint strategies.
	 * @param host The host Ball
	 */
	public void init(Ball host) {
		for (int i = 0; i < pstrats.length; i++) {
			pstrats[i].init(host);
		}
	}

}
