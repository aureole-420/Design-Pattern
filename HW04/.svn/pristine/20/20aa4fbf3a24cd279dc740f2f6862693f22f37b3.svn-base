package model;

import java.awt.Component;

/**
 * Interface that goes from the model to the view that enables the model to talk to the view
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 * This interface is written based on the template provided by Dr. Steph Wong,
 * See https://www.clear.rice.edu/comp310/JavaResources/animation.html
 */
public interface IModel2ViewAdapter {

	/**
	 * The method that tells the view to repaint 
	 */
	public void repaint();

	/**
	 * This method get he JPanel compoenent on which Balls are painted on.
	 * @return  the display panel on which Balls are painted on.
	 */
	public Component getCanvas();

	/**
	 * No-op "null" adapter
	 */
	public static final IModel2ViewAdapter NULL_OBJECT = new IModel2ViewAdapter() {
		public void repaint() {
			// nothing because this is the method of a NULL object
		}

		public Component getCanvas() {
			return null;
		};
	};
}
