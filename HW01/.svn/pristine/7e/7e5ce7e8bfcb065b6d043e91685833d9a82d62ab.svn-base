package shape;

import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

/**
 * CompositeShape is a concrete class that extends the abstract AShape class.
 * Multiple customized AShape parts can be added to / removed from the CompositeShape.
 * The compound shape can be painted onto screen.
 * @author Lyu Pan, Yuhui Tong.
 *
 */
public class CompositeShape extends AShape {

	/**
	 * List of AShapes which consist of CompositeShape. 
	 */
	private List<AShape> shapes;

	/**
	 * Constructor of CompositeShape.
	 * @param loc default parameter for AShape. Not necessarily to be used for CompositeShape. 
	 */
	public CompositeShape(Point loc) {
		super(loc);
		shapes = new LinkedList<AShape>();
	}

	/**
	 * Add a child shape to CompositeShape
	 * @param child shape that makes a part of CompositeShape
	 */
	public void addChild(AShape child) {
		shapes.add(child);
	}

	/**
	 * Remove a child shape from CompositeShape. Specifically, it removes the last added child.
	 * @return AShape the child shape that is removed.
	 */
	public AShape removeChild() {
		if (shapes.isEmpty())
			return null;
		return shapes.remove(shapes.size() - 1);
	}
	
	/**
	 * Removes all child shapes from CompositeShape.
	 */
	public void clear() {
		shapes = new LinkedList<AShape>();
	}
	
	/**
	 * Overridden paint method paint CompositeShape.
	 */
	@Override
	public void paint(Graphics g) {
		// paint all child shape that make up CompositeShape.
		for (AShape shape : shapes)
			shape.paint(g);
	}

}
