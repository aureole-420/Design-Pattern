package model.strategy;

import model.ball.Ball;
import util.Dispatcher;

import java.awt.Color;

/**
 * A concrete strategy class that implements IUpdateStategy.
 * A ball will disappear every several ticks if takng this strategy.
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 */
public class NinjaStrategy implements IUpdateStrategy {

	private Color originalColor = Color.BLACK;
	private final Color backgroundColor = Color.LIGHT_GRAY;

	/**
	 * Ninja ball changes its color to background color when the count reaches timespan1.
	 */
	private int count = 0;

	/**
	 * Ninja ball changes its color to background color when the count reaches timespan1.
	 */
	private final int timespan1 = 15;

	/**
	 * Ninja ball changes to a visible color when the count reaches timespan1+timespan2.
	 */
	private final int timespan2 = 10;

	@Override
	/**
	 * An overriden method that updates the ball's state.
	 * @param context The ball that the strategy is applied on.
	 */
	public void updateState(Ball context, Dispatcher disp) {

		if (count < timespan1)
			count++;
		else if (count == timespan1) {
			originalColor = context.getColor();
			context.setColor(backgroundColor);
			count++;
		} else if (count < timespan1 + timespan2) {
			count++;
		} else {
			count = 0; // reset the count;
			context.setColor(originalColor);
			;
		}

	}

}
