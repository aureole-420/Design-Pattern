package model;

import model.ball.Ball;
import util.IDispatcher;

/**
 * Merge two interactStrategies to one.
 * @author Yuhui Tong
 * @version 1.0
 */
public class MultiInteractStrategy implements IInteractStrategy {
	/**
	 * The first interact strategy to be merged 
	 */
	private IInteractStrategy is1;

	/**
	 * The second interact strategy to be merged 
	 */
	private IInteractStrategy is2;

	/**
	 * constructor 
	 * @param is1 first interactStrategy
	 * @param is2 second interactStrategy
	 */
	public MultiInteractStrategy(IInteractStrategy is1, IInteractStrategy is2) {
		this.is1 = is1;
		this.is2 = is2;
	}

	/**
	 * {@inheritDoc}<br/>
	 */
	@Override
	public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
		is1.interact(context, target, disp);
		is2.interact(context, target, disp);
	}

}
