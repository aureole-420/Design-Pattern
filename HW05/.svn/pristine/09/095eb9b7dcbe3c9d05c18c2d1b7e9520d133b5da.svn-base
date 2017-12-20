package controller;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import model.BallModel;
import model.IBallCmd;
import model.IModel2ViewAdapter;
import model.IPaintStrategyFac;
import model.IStrategyFac;
import view.BallGUI;
import view.IView2ModelPaintAdapter;
import view.IView2ModelControlAdapter;

/**
 * The controller of BallWorldApp.
 * The "Controller" in a Model-View-Controller architecture Sets up the appropriate wiring between 
 * the model and the view. Uses adapters to respond to user input and notifies the model and the view to update accordingly. 
 * @author Yuhui Tong
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
	private BallGUI<IStrategyFac<IBallCmd>, IPaintStrategyFac> view;

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

		view = new BallGUI<IStrategyFac<IBallCmd>, IPaintStrategyFac>(
				new IView2ModelControlAdapter<IStrategyFac<IBallCmd>, IPaintStrategyFac>() {
					// Implementation of Anonymous class of IView2ModelAdapter Interface.

					@Override
					/**
					 * Overridden method that tells model to load ball
					 * @param selectedItem A factory that makes the strategy for ball 
					 */
					public void loadBall(IStrategyFac<IBallCmd> selectedItem, IPaintStrategyFac selectedPSItem) {
						if (selectedItem == null || selectedPSItem == null)
							return;
						model.makeBall(selectedItem.make(), selectedPSItem.make());
					}

					@Override
					/**
					 * Overridden method that tells model to create a Strategy factor that can instantiate strategy of classname
					 */
					public IStrategyFac<IBallCmd> addStrategy(String classname) {
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
					public IStrategyFac<IBallCmd> combineStrategies(IStrategyFac<IBallCmd> selectedItem1,
							IStrategyFac<IBallCmd> selectedItem2) {
						return model.combineStrategyFacs(selectedItem1, selectedItem2);
					}

					@Override
					/**
					 * Overridden method that make a switcher ball
					 */
					public void makeSwitcherBall(IPaintStrategyFac selectedPSItem) {
						// TODO Auto-generated method stub
						model.makeBall(model.getSwitcherStrategy(), selectedPSItem.make());
					}

					@Override
					/**
					 * Overridden method that makes a switcher strategy object in the model.
					 */
					public void switchStrategy(IStrategyFac<IBallCmd> selectedItem) {
						// TODO Auto-generated method stub
						model.switchSwitcherStrategy(selectedItem.make());
					}

					/**
					 * Overridden method that add a PaintStrategy factory corresponding to a type of PaintStrategy
					 * @param PaintStrategyName Shortened name for that paint strategy.
					 * @return Selected strategy factory of the strategy type that ball uses
					 */
					@Override
					public IPaintStrategyFac addPaintStrategy(String PaintStrategyName) {
						return model.makePaintStrategyFac(PaintStrategyName);
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
