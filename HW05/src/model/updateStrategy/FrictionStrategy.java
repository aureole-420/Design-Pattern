package model.updateStrategy;

import java.awt.Point;

import model.IBallCmd;
import model.IInteractStrategy;
import model.IUpdateStrategy;
import model.MultiInteractStrategy;
import model.ball.Ball;
import util.IDispatcher;

/**
 * (exerting friction on other balls) implemented purely as an interaction strategy.   
 * Combine with Overlap/Collide to see slowing other balls.
 * @author Yuhui Tong
 *
 * @param <TDispMsg> The message dispatched by dispatcher.
 */
public class FrictionStrategy<TDispMsg> implements IUpdateStrategy<TDispMsg> {

	/**
	 * Friction Ratio.
	 */
	private double FrictionRatio = 0.50;

	/**
	 * {@inheritDoc}<br/>
	 * Initialize an interact strategy that slows down target balls.
	 */
	public void init(Ball context) {
		// System.out.println("KILLING INIT!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		context.setInteractStrategy(new MultiInteractStrategy(context.getInteractStrategy(), new IInteractStrategy() {
			public void interact(Ball context, Ball target, IDispatcher<IBallCmd> disp) {
				if (context == target) {
					return; // do nothing to context ifself
				}
				// reducing velocity by 5% every ticker
				Point vel = target.getVelocity();
				if (vel.x * vel.x + vel.y * vel.y < 2) {
					return;
				}
				target.setVelocity(new Point((int) Math.round((FrictionRatio * target.getVelocity().getX())),
						(int) Math.round((FrictionRatio * target.getVelocity().getY()))));

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
