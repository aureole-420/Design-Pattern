package client.view;

/**
 * Adapter to allow view to call model's method.
 * @author yt30, zx17
 *
 * @param <TDropListItem> Generic type for comboboxItem
 */
public interface IModelAdapter<TDropListItem> {
	/**
	 * Get default remoteHost IPadress
	 * @return default remotehost IPAdress
	 */
	public String getDefaultRemoteHost();

	/**
	 * quit the client.
	 */
	public void quit();

	/**
	 * connet to a server with remoteHost IPAdress
	 * @param remoteHostIP The IPAdress for remote Host.
	 * @return The status of connection.
	 */
	public String connect(String remoteHostIP);

	/**
	 * Send message to server.
	 * @param msg Message to be sent to server.
	 */
	public void sendMsgToComputeEngine(String msg);

	/**
	 * Run the selected task.
	 * @param tf The task factory of selected task type. 
	 * @param param Parameter for the task.
	 */
	public void runTask(TDropListItem tf, String param);

	/**
	 * Add an item/factory to the drop list.
	 * @param classname The class name of selected task.
	 * @return The taskfactory.
	 */
	public TDropListItem addFactory(String classname);

	/**
	 * Add an multiTask factory.
	 * @param tf1 Taskfactory 1
	 * @param tf2 Taskfactory 2
	 * @param param Parameters for the task.
	 * @return The taskfactory for the combined task
	 */
	public TDropListItem addMultiTasksFactory(TDropListItem tf1, TDropListItem tf2, String param);

}
