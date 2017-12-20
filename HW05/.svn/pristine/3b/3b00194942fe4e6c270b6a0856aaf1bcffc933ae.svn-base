package model.updateStrategy;

import model.IUpdateStrategy;
import model.ball.Ball;
import util.IDispatcher;
import util.Randomizer;

/**
 * A concrete strategy class that implements IUpdateStategy.
 * The ball taking this strategy changes its color every 30 ticks.
 * @author Yuhui Tong,  Haoyuan Yue
 * @param <TDispMsg> The message dispatched by dispatcher.
 * @version 1.0
 */
public class ColorStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {
	/**
	 * count for ticks
	 */
	private int count = 30;

	@Override
	/**
	 * An overriden method that updates the ball's state.
	 * @param context The ball that the strategy is applied on.
	 */
	public void updateState(Ball context, IDispatcher<TDispMsg> disp) {
		count--;
		if (count == 0) {
			context.setColor(Randomizer.Singleton.randomColor());
			count = 30;
		}
	}

	/**
	 * {@inheritDoc}<br>
	 */
	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub

	}
}
