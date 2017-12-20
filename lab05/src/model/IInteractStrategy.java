package model;

import model.ball.Ball;
import util.Dispatcher;

/**
 * Strategy that defines a directed interaction between two balls where the balls are NOT
 * equivalently processed
 * @author yuhui
 *
 */
public interface IInteractStrategy {
	
	/**
	 * Performs a directed interaction between the context ball and the target ball 
	 * from the perspective of the context ball.
	 * @param context The Ball from whoe perspective the interaction
	 * processing takes place.
	 * @param target The Ball that is the "other ball" in the perspective of this process.
	 * @param disp The Dispatcher that is to be used if desired.
	 */
	public void interact(Ball context, Ball target, Dispatcher disp);
	
	
	/**
	 * Null strategy with no-op behavior;
	 */
	public static final IInteractStrategy NULL_STRATEGY = (context, target, disp) -> {};
}