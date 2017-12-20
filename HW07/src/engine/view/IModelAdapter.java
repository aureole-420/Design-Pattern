package engine.view;

/**
 * The view to model adapter.
 * @author yt30, zx17
 */
public interface IModelAdapter {
	/**
	 * This method allows quitting the engine.
	 */
	public void quit();

	/**
	 * Send message to client from the engine.
	 * @param msg Message to be sent to client.
	 */
	public void sendMsgToClient(String msg);

}
