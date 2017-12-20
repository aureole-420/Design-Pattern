package model.updateStrategy;

import model.IInteractStrategy;
import model.IUpdateStrategy;
import model.MultiInteractStrategy;
import model.ball.Ball;
import util.Dispatcher;

public class KillStrategy implements IUpdateStrategy {
	
	public void init(Ball context) {
		System.out.println("KILLING INIT!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		context.setInteractStrategy(new MultiInteractStrategy(context.getInteractStrategy(), new IInteractStrategy() {
			public void interact(Ball context, Ball target, Dispatcher disp) {
				System.out.println("I am killing!");
				disp.deleteObserver(target);
			}
		}));
	}
	
	public void updateState(Ball context, Dispatcher disp) {
		//no-op
	}

}
