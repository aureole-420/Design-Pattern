package strategy;

import ball.Ball;
import util.Randomizer;


/**
 * A concrete strategy class that implements IUpdateStategy.
 * The ball taking this strategy changes its color every 30 ticks.
 * @author Yuhui Tong, Shengqi Wang
 * @version 1.0
 */
public class ColorStrategy implements IUpdateStrategy {
	/**
	 * count for ticks
	 */
	private int count = 30;
	
	@Override
	/**
	 * An overriden method that updates the ball's state.
	 * @param context The ball that the strategy is applied on.
	 */	
	public void updateState(Ball context) {
		count--;
		if (count == 0) {
			context.setColor(Randomizer.Singleton.randomColor());
			count = 30;
		}
	}
}
