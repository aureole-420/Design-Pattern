package model;

import model.paint.strategy.IPaintStrategy;

/**
 * An interface that defines a factory that instantiate a specific IPaintStrategy.
 * @author Yuhui Tong, Haoyuan Yue
 * @version 1.0
 */
public interface IPaintStrategyFac {

	/**
	 * Instantiate the specific IPaintStrategy for which this factory is defined.
	 * @return An IPaintStrategy instance.
	 */
	IPaintStrategy make();

}
