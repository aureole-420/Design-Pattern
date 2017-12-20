package controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import model.BallModel;
import model.IModel2ViewAdapter;

import view.BallGUI;
import view.IView2ModelPaintAdapter;
import view.IView2ModelControlAdapter;

import strategy.IStrategyFac;
/**
 * The controller of BallWorldApp.
 * @author Yuhui Tong, Shengqi Wang
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
	private BallGUI<IStrategyFac> view;

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

		view = new BallGUI<IStrategyFac>(
			new IView2ModelControlAdapter<IStrategyFac>() {
			// Implementation of Anonymous class of IView2ModelAdapter Interface.
			
			@Override
			/**
			 * Overridden method that tells model to load ball
			 * @param selectedItem A factory that makes the strategy for ball 
			 */
			public void loadBall(IStrategyFac selectedItem) {
				if (selectedItem == null) return;
				model.makeBall(selectedItem.make());
			}
			
			@Override
			/**
			 * Overridden method that tells model to create a Strategy factor that can instantiate strategy of classname
			 */
			public IStrategyFac addStrategy(String classname) {
				return model.makeStrategyFac(classname);
			}
			
			@Override
			/**
			 * Overridden method that tells model to remove all balls
			 */
			public void clearBalls() {
				model.clearBalls();
			}

			@Override
			/**
			 * Overridden method that tells model to create a strategy factor that can combine
			 * two strategy factories.
			 * @param selectedItem1 Strategyfactor 1
			 * @param selectedItem2 Strategyfactory 2
			 */
			public IStrategyFac combineStrategies(IStrategyFac selectedItem1, IStrategyFac selectedItem2) {
				return model.combineStrategyFacs(selectedItem1, selectedItem2);
			}

			@Override
			/**
			 * Overridden method that make a switcher ball
			 */
			public void makeSwitcherBall() {
				// TODO Auto-generated method stub
				model.makeBall(model.getSwitcherStrategy());
			}

			@Override
			/**
			 * Overridden method that makes a switcher strategy object in the model.
			 */
			public void switchStrategy(IStrategyFac selectedItem) {
				// TODO Auto-generated method stub
				model.switchSwitcherStrategy(selectedItem.make());		
			}
		}, new IView2ModelPaintAdapter() {
			/**
			 * Overridden method that tells model to update (call all observers' update method)
			 */
			@Override
			public void paint(Graphics g) {
				model.update(g);
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
