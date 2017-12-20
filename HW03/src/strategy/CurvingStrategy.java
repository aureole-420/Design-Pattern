package strategy;

import ball.Ball;
import java.awt.Point;


/**
 * A concrete strategy class that implements IUpdateStategy.
 * A ball rotates if taking this strategy.
 * @author Yuhui Tong, Shengqi Wang
 * @version 1.0
 */
public class CurvingStrategy implements IUpdateStrategy {
	
	/**
	 * The rotating angular velocity.
	 */
	private double theta = Math.PI / 15;
	
	@Override
	/**
	 * An overriden method that updates the ball's state.
	 * @param context The ball that the strategy is applied on.
	 */	
	public void updateState(Ball context) {
		Point v = context.getVelocity();
		int vx =v.x, vy = v.y;
		context.setVelocity(new Point((int) Math.round(vx * Math.cos(theta) - vy * Math.sin(theta)),
		 (int) Math.round(vy * Math.cos(theta) + vx * Math.sin(theta))));
		
	}

}
