package model.updateStrategy;

import model.IUpdateStrategy;

/**
 * An interface that defines a factory that instantiates
 * a specific IUpdateStrategy
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 */
public interface IStrategyFac {
	/**
	 * Instantiate the specific IUpdateStrategy for which this factory is defined.
	 * @return An IUpdateStrategy instance.
	 */
	public IUpdateStrategy make();
}
