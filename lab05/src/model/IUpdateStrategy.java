package model;

import model.ball.Ball;
import util.Dispatcher;

/**
 * The Interface for Strategy that a ball takes.
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 */
public interface IUpdateStrategy {
	
	/**
	 * Initialize the updateStrategy for the ball, e.g. initialize
	 * the interaction strategy.
	 * @param context
	 */
	public void init(Ball context);
	
	/**
	 * This method affect the behavior of a ball by updating its state.
	 * @param context The ball that the strategy is applied on.
	 * @param disp The dispatcher to use if necessary
	 */
	public void updateState(Ball context, Dispatcher disp);
}
