package model;

/**
 * An interface that defines a factory that instantiates
 * a specific IUpdateStrategy
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 */
public interface IStrategyFac<TDispMsg> {
	/**
	 * Instantiate the specific IUpdateStrategy for which this factory is defined.
	 * @return An IUpdateStrategy instance.
	 */
	public IUpdateStrategy<TDispMsg> make();
}
