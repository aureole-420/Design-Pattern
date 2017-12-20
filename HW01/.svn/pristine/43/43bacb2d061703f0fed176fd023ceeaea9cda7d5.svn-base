package shape;

import java.awt.Point;
import java.awt.Graphics;

/**
 * An abstract Shape class whose concrete subclass implements various of simple and composite shape.
 * The shape can be painted onto screen via paint method.
 * @author Lyu Pan, Yuhui Tong
 *
 */
public abstract class AShape {
	/**
	 * Location where AShape is going to be painted to. 
	 * Specifically, loc denotes the upper left corner of the shape.
	 */
	private Point loc;

	/**
	 * Constructor of AShape class
	 * @param loc denotes the upper left corner of the shape.
	 */
	public AShape(Point loc) {
		this.loc = loc;
	}

	/**
	 * Get the location of the shape, i.e.t the upper left corner of the shape.
	 * @return location of the shape.
	 */
	public Point getLoc() {
		return loc;
	}
	
	/**
	 * Set the location of the shape, i.e. the upper left corner of the shape.
	 * @param loc new location where the shape will be placed at 
	 */
	public void setLoc(Point loc) {
		this.loc = loc;
	}

	/**
	 * Paint AShape to the screen.
	 * @param g Graphics object to paint on.
	 */
	public abstract void paint(Graphics g);
}
