package strategy;

import ball.Ball;
import util.Randomizer;;

/**
 * A concrete strategy class that implements IUpdateStategy.
 * A ball taking this strategy changes its radius constantly.
 * @author Yuhui Tong, Shengqi Wang
 * @version 1.0
 */
public class BreathingStrategy implements IUpdateStrategy {

	@Override
	/**
	 * An overriden method that updates the ball's state.
	 * @param context The ball that the strategy is applied on.
	 */
	public void updateState(Ball context) {
		context.setRadius(Randomizer.Singleton.randomInt(5, 15));
	}

}
