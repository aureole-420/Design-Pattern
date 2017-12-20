package util;

/**
 * Represents the identity map. Null-object pattern for ILambda.
 * @author yuhui
 *
 */
public class NoOpLambda implements ILambda {

	/**
	 * This is the class field that gives access to the one instance of this class
	 */
	public static NoOpLambda Singleton = new NoOpLambda();

	/**
	 * A private constructor keeps everyone except this class from constructing an instance.
	 */
	private NoOpLambda() {
	}

	/**
	 * Does nothing.
	 * @param arg input object for this ILambda object.
	 */
	@Override
	public Object apply(Object arg) {
		// Does nothing
		return null;
	}

}
