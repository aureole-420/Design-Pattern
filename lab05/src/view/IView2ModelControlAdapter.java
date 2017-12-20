package view;

/**
 * The adapter that allows view to talk to model on controlling issues.
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 * @param <TDropListItem> The type of items in JComboBox (droplist).
 */
public interface IView2ModelControlAdapter<TDropListItem, TPSDropListItem> {

	/**
	 * This method tells model to load a ball.
	 * @param selectedItem Selected strategy factory of the strategy type that ball uses
	 */
	public void loadBall(TDropListItem selectedItem, TPSDropListItem selectedPSItem);

	/**
	 * Add a selectedItem (containing the corresponding strategy factory) to droplist
	 * @param classname The classname of ball type to be loaded
	 * @return An strategy factory to be added to the drop list.
	 */
	public TDropListItem addStrategy(String classname);

	/**
	 * This method combines two existing strategies and return a factory of combined strategy.
	 * @param selectedItem1 Selected strategy factory of the strategy type that ball uses
	 * @param selectedItem2 Selected strategy factory of the strategy type that ball uses.
	 * @return The factory of combined strategy.
	 */
	public TDropListItem combineStrategies(TDropListItem selectedItem1, TDropListItem selectedItem2);

	/**
	 * Add anew paintStrategy to the droplist.
	 * @param PaintStrategyName The shortened name of paintStrategy to be added
	 * @return The paint strategy factory for that paint strategy.
	 */
	public TPSDropListItem addPaintStrategy(String PaintStrategyName);

	/**
	 * This method tells the model to create a SwitcherBall object.
	 */
	public void makeSwitcherBall(TPSDropListItem selectedPSItem);

	/**
	 * This method tells the model to change strategy that a switcherball is taking.
	 * @param selectedItem Selected strategy factory of the strategy type that ball uses
	 */
	public void switchStrategy(TDropListItem selectedItem);

	/**
	 * This method tells the model to remove all the balls.
	 */
	public void clearBalls();

}
