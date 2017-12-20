package engine.model;

/**
 * The model to view adapter allowing model to call view's method.
 * @author yt30, zx17
 */
public interface IViewAdapter {
	/**
	 * Append a string to the view's display
	 * @param t The string to attach to the view's display panel.
	 */
	public void append(String t);
}
