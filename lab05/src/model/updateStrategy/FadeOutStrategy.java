package model.updateStrategy;

import java.awt.Color;

import model.IUpdateStrategy;
import model.ball.Ball;
import util.Dispatcher;
import util.Randomizer;

/**
 * A concrete strategy class that implements IUpdateStategy.
 * Ball color Fades out after a random period and then return back. 
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 */
public class FadeOutStrategy implements IUpdateStrategy {
	/**
	 * random interval for fade out period
	 */
	private int interval = Randomizer.Singleton.randomInt(5, 15);

	/**
	 * count for ticks
	 */
	private int count = interval;

	/**
	 * original alpha value for recovering after fade out period
	 */
	private final int ALPHA = 255;

	@Override
	/**
	 * An overridden method that updates the ball's state.
	 * @param context The ball that the strategy is applied on.
	 */
	public void updateState(Ball context, Dispatcher disp) {
		Color color = context.getColor();
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();

		count--;
		Color currentColor = new Color(red, green, blue, (int) (ALPHA * count / interval));
		context.setColor(currentColor);
		if (count == 0)
			count = interval;
	}

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		
	}
}
