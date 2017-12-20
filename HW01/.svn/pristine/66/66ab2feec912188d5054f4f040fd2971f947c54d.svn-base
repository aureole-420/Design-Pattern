package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Triangle is a concrete class extending the abstract AShape class.
 * It defines Triangle object that can be painted onto screen.
 * @author Lyu Pan, Yuhui Tong
 *
 */
public class Triangle extends AShape {

	/**
	 * Width and height of triangle.
	 */
	private int width = 50, height = 20;

	/**
	 * Array containing the x-coordinates of triangle.
	 */
	private int[] posX = new int[3];

	/**
	 * Array containing the y-coordinates of triangle.
	 */
	private int[] posY = new int[3];

	private Color color;

	/**
	 * Constructor of triangle class
	 * @param loc is the bottom left point of triangle.
	 * @param color color of triangle.
	 */
	public Triangle(Point loc, Color color) {
		super(loc);
		this.color = color;
		posX[0] = (int) loc.getX();
		posY[0] = (int) loc.getY();

		posX[1] = (int) loc.getX() + width;
		posY[1] = (int) loc.getY();

		posX[2] = (int) loc.getX() + width / 2;
		posY[2] = (int) loc.getY() - height;
	}

	/**
	 * Overridden paint method to paint triangle.
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillPolygon(posX, posY, 3);
	}

}
