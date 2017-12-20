package model.strategy;

import java.awt.Rectangle;
import model.ball.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * A concrete strategy class that implements IUpdateStategy.
 * Ball taking this strategy will make brownian motion (random walk).
 * @author Yuhui Tong,  Haoyuan Yue
 * @version 1.0
 */
public class BrownianStrategy implements IUpdateStrategy {
	/**
	 * count for ticks
	 */
	private int count = 0;

	/**
	 * Change direction after this random ticks
	 */
	private int steps = Randomizer.Singleton.randomInt(1, 5);

	@Override
	/**
	 * An overriden method that updates the ball's state.
	 * @param context The ball that the strategy is applied on.
	 */
	public void updateState(Ball context, Dispatcher disp) {
		if (count < steps)
			count++;
		else {
			count = 0; // reset the count;
			steps = Randomizer.Singleton.randomInt(1, 5);
			context.setVelocity(Randomizer.Singleton.randomVel(new Rectangle(0, 0, 30, 30)));
		}
	}
}