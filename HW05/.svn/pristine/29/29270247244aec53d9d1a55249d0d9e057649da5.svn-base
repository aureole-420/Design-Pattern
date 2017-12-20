package model.updateStrategy;

import java.awt.Point;

import model.IBallCmd;
import model.IInteractStrategy;
import model.IUpdateStrategy;
import model.MultiInteractStrategy;
import model.ball.Ball;
import util.IDispatcher;

/**
 * (exerting acceleration on other balls) implemented purely as an interaction strategy.   
 * Combine with Overlap/Collide to see slowing other balls.
 * @author yuhui
 *
 * @param <TDispMsg> The message dispatched by dispatcher.
 */
public class AccelerateStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/**
	 * Acceleration ratio for every tick
	 */
	private double AccelerationRatio = 2;

	/**
	 * {@inheritDoc}<br/>
	 * Initialize a pure interaction strategy that accelerate target balls.
	 */
	public void init(Ball context) {
		// System.out.println("KILLING INIT!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		context.setInteractStrategy(new MultiInteractStrategy(context.getInteractStrategy(), new IInteractStrategy() {
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
				if (context == target) {
					return; // do nothing to context ifself
				}

				// accelerate velocity by 10% every tick
				Point vel = target.getVelocity();
				if (vel.x * vel.x + vel.y * vel.y > 1000) {
					return;
				}
				target.setVelocity(new Point((int) Math.round(AccelerationRatio * target.getVelocity().getX()),
						(int) Math.round(AccelerationRatio * target.getVelocity().getY())));
				//target.setVelocity(new Point(0, 0));
			}
		}));
	}

	/**
	 * {@inheritDoc}<br/>
	 */
	@Override
	public void updateState(Ball context, IDispatcher<TDispMsg> disp) {
		// TODO Auto-generated method stub

	}

}
