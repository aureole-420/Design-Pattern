package model;

import model.ball.Ball;
import util.Dispatcher;

/**
 * Merge two interactStrategies to one.
 * @author yuhui
 *
 */
public class MultiInteractStrategy implements IInteractStrategy {
	private IInteractStrategy is1;
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
	
	@Override
	public void interact(Ball context, Ball target, Dispatcher disp) {
		is1.interact(context, target, disp);
		is2.interact(context, target, disp);
	}

}
