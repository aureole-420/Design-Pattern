package model.updateStrategy;

import java.awt.Point;
import java.awt.geom.Point2D;

import model.IBallCmd;
import model.IUpdateStrategy;
import model.ball.Ball;
import util.Dispatcher;

public class CollideStrategy implements IUpdateStrategy {

    /**
     * The amount to add to the separation distance to insure that the two balls
     * are beyond collision distance
     */
	private double Nudge = 1.1;
	
	@Override
	public void updateState(Ball context, Dispatcher dispatcher) {
		dispatcher.notifyAll(new IBallCmd() {
			public void apply(Ball target, Dispatcher disp) {
				if (target == context) {
					return;
				}
				if ((context.getRadius() + target.getRadius()) > context.getLocation().distance(target.getLocation())) {
					//calculate impulse, translate source a little bit
					double reduced_mass = reducedMass(context.getRadius() * context.getRadius(), 
							target.getRadius() * target.getRadius());
					double distance = context.getLocation().distance(target.getLocation());
					double deltaR = context.getRadius() + target.getRadius() - distance;
					Point2D.Double imp = impulse(context.getLocation(),
							context.getVelocity(),
							target.getLocation(),
							target.getVelocity(),
							reduced_mass, 
							distance,
							deltaR
							);
					// update Collision for source
					updateCollision(context, target, imp.getX(), imp.getY(), dispatcher);
					// update Collision for target
					updateCollision(target, context, -imp.getX(), -imp.getY(), dispatcher);
				}
			}
		});
	}
	
	protected double reducedMass(double mSource, double mTarget) {
		if (mSource == Double.POSITIVE_INFINITY)
			return mTarget;
		if (mTarget == Double.POSITIVE_INFINITY)
			return mSource;
		else 
			return (mSource * mTarget) / (mSource + mTarget);

	}
	
	protected Point2D.Double impulse(Point lSource, Point vSource,
			            Point lTarget, Point vTarget, double reducedMass, double distance,
			            double deltaR) {
			
			        // Calculate the normal vector, from source to target
		
			        double nx = ((double) (lTarget.x - lSource.x)) / distance;
			        double ny = ((double) (lTarget.y - lSource.y)) / distance;
			        // delta velocity (speed, actually) in normal direction, source to
			        // target
			        double dvn = (vTarget.x - vSource.x) * nx + (vTarget.y - vSource.y)
			                * ny;
			
			        // move the source ball beyond collision range of the target ball, along
			        // the normal direction.
			        lSource.translate((int) Math.ceil(-nx * (Nudge * deltaR)),
			                (int) Math.ceil(-ny * (Nudge * deltaR)));

			        return new Point2D.Double(2.0 * reducedMass * dvn * nx, 2.0
			                * reducedMass * dvn * ny);
			    }
	
	protected void updateCollision(Ball context, Ball target, double impX, double impY, Dispatcher dispatcher) {
		int mContext = context.getRadius() * context.getRadius();
		context.getVelocity().translate((int) Math.round(impX / mContext),(int) Math.round(impY / mContext));
		context.interactWith(target, dispatcher);
		//dispatcher.deleteObserver(target);
		System.out.println("update collision");
	}

	@Override
	public void init(Ball context) {
		// no-op
		
	}

}
