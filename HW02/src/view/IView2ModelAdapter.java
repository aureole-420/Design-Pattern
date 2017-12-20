package view;

import java.awt.Graphics;

/**
 * The interface of the adapter from the view to the model that enables the view to talk to the model.
 * @author Yuhui Tong, Anqi Yu
 * @version 1.0
 */
public interface IView2ModelAdapter {

	/**
	 * let the model paint
	 * @param g The graphic object
	 */
	public void paint(Graphics g);

	/**
	 * This method 
	 * @param classname The classname of ball type to be loaded
	 */
	public void loadBall(String classname);

	/**
	 * This method tells the model to remove all the balls.
	 */
	public void clearBalls();

	/**
	 * "null" object to insure that view's operation is valid.
	 */
	public static final IView2ModelAdapter NULL_OBJECT = new IView2ModelAdapter() {

		public void paint(Graphics g) {

		}

		public void loadBall(String classname) {

		}

		public void clearBalls() {

		}

	};
}
