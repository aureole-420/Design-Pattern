package model.strategy;

import model.ball.Ball;
import util.Dispatcher;

/**
 * A concrete strategy class that implements IUpdateStategy.
 * This strategy merges two child strategy such that a ball behaves in both manner.
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 */
public class MultiStrategy implements IUpdateStrategy {

	/**
	 * The first child strategy to merge with
	 */
	private IUpdateStrategy strat1;

	/**
	 * The second child strategy to merge with
	 */
	private IUpdateStrategy strat2;

	/**
	 * Constructor of MultiStrategy.
	 * @param strat1 The first child strategy to merge with.
	 * @param strat2 The second child strategy to merge with.
	 */
	public MultiStrategy(IUpdateStrategy strat1, IUpdateStrategy strat2) {
		this.strat1 = strat1;
		this.strat2 = strat2;
	}

	/**
	 * An overriden method that updates the ball's state.
	 * @param context The ball that the strategy is applied on.
	 */
	@Override
	public void updateState(Ball context, Dispatcher disp) {
		strat1.updateState(context, disp);
		strat2.updateState(context, disp);
	}

}
