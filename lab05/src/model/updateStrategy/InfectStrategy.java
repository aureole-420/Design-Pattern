package model.updateStrategy;

import java.awt.Color;

import model.IBallCmd;
import model.IUpdateStrategy;
import model.ball.Ball;
import util.Dispatcher;

public class InfectStrategy implements IUpdateStrategy {
	private final Color INFECTED = Color.BLACK;
	private final Color HEALTHY = Color.GREEN;
	private int count = -1;
	private int timespan = 100;
	
	@Override
	public void updateState(Ball context, Dispatcher dispatcher) {
		if (count < 0) {
			context.setColor(INFECTED);
			count = 0;
		}
		if (context.getColor() == HEALTHY) { // ball context is cured
			return;
		} 
		if (count >= timespan) { // ball context is cured
			context.setColor(HEALTHY);
			count = 0;
			return;
		}
		if (count++ < timespan) { // ball context can infect other balls!
			dispatcher.notifyAll(new IBallCmd() {
				public void apply(Ball other, Dispatcher disp) {
					if (context != other) {
						// if overlapped
						boolean isOverlapped = (context.getRadius() + other.getRadius()) > context.getLocation().distance(other.getLocation());
						if (isOverlapped) {
							if (other.getColor() == HEALTHY) {
								other.setColor(INFECTED);
							}
						}
					}
				}
			});
		}
		
	}

	@Override
	public void init(Ball context) {
		// TODO Auto-generated method stub
		
	}

}
