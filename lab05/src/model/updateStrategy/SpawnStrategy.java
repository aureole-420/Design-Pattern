package model.updateStrategy;
import java.awt.Point;

import model.IBallCmd;
import model.IUpdateStrategy;
import model.ball.Ball;
import util.Dispatcher;

public class SpawnStrategy implements IUpdateStrategy {
	private int count = 0;
	private int delay = 100;
	
	@Override
	public void updateState(Ball context, Dispatcher dispatcher) {
	
		if (delay < count++) {
			dispatcher.notifyAll(new IBallCmd() {

				@Override
				public void apply(Ball other, Dispatcher disp) {
					if (count != 0 && context != other ) {
						if ((context.getRadius() + other.getRadius()) > 
						context.getLocation().distance(other.getLocation())) {
						disp.addObserver(new Ball(
								new Point(context.getLocation()),
								context.getRadius(),
								new Point(-context.getVelocity().x + 1, -context.getVelocity().y +1),
								context.getColor(),
								context.getCanvas(),
								new SpawnStrategy(),
								context.getPaintStrategy()
								));	
							count = 0;
							delay *= 5;
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
