package controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import model.BallModel;
import model.IModel2ViewAdapter;

import view.BallGUI;
import view.IView2ModelAdapter;

/**
 * The controller of BallWorldApp.
 * @author Yuhui Tong, Anqi Yu
 * @version 1.0
 */
public class BallWorldController {

	/**
	 * The model object
	 */
	private BallModel model;

	/**
	 * The view object
	 */
	private BallGUI view;

	/**
	 * Constructor of the controller
	 */
	public BallWorldController() {
		model = new BallModel(new IModel2ViewAdapter() {
			// Implementation of Anonymous class of IModel2ViewAdapter Interface.
			/**
			 * Overridden method that tells view to repaint.
			 */
			@Override
			public void repaint() {
				view.repaint();
			}

			/**
			 * Overridden method that obtain the jpanel object
			 */
			@Override
			public Component getCanvas() {
				return view.getCanvas();
			};
		});

		view = new BallGUI(new IView2ModelAdapter() {
			// Implementation of Anonymous class of IView2ModelAdapter Interface.
			/**
			 * Overridden method that tells model to update (call all observers' update method)
			 */
			@Override
			public void paint(Graphics g) {
				model.update(g);
			}

			/**
			 * Overridden method that tells model to make new ball
			 */
			@Override
			public void loadBall(String classname) {
				model.makeBall(classname);
			}

			/**
			 * Overridden method that tells model to remove all balls
			 */
			@Override
			public void clearBalls() {
				model.clearBalls();
			}
		});
	}

	/**
	 * Start the system
	 */
	public void start() {
		model.start();
		view.start();
	}

	/**
	 * Instantiate BallWorld
	 * @param args Default string[] arguments.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// java specs say that the system must be constructed on the GUI event thread
			public void run() {
				try {
					BallWorldController controller = new BallWorldController(); // instantiate the sytem
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
