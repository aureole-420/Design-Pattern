package client.model.task;

import java.io.IOException;
import java.io.ObjectInputStream;

import provided.client.model.taskUtils.ITaskFactory;
import provided.compute.ILocalTaskViewAdapter;
import provided.compute.ITask;
import provided.compute.ITaskResultFormatter;

/**
 * An task the judge whether an input integer is odd number.
 * @author yt30, zx17
 */
public class IsOdd implements ITask<Boolean> {

	/**
	 * UID for well-defined serialization
	 */
	private static final long serialVersionUID = -4019588279565829029L;

	/**
	 * an input integer as a number.
	 */
	private int inputNumber;

	/**
	 * Adapter to the local view.  Marked "transient" so that it is not serialized
	 * and instead is reattached at the destination (the server).  
	 */
	private transient ILocalTaskViewAdapter taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER;

	/**
	 * Constructor for the 
	 * @param inputNumber The input integer
	 */
	public IsOdd(int inputNumber) {
		this.inputNumber = inputNumber;
		taskView.append("isOdd constructing...");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean execute() {
		// TODO Auto-generated method stub
		taskView.append("Executing isOdd task with input " + inputNumber + ".\n");
		return inputNumber % 2 == 1;
	}

	/**
	 * Sets the task view adapter to a new value.  Used by the server to attach
	 * the task to its view.
	 */
	@Override
	public void setTaskViewAdapter(ILocalTaskViewAdapter viewAdapter) {
		taskView = viewAdapter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITaskResultFormatter<Boolean> getFormatter() {
		return new ITaskResultFormatter<Boolean>() {
			public String format(Boolean result) {
				String judge = result ? " is " : " is not ";
				return inputNumber + judge + "an odd number";
			}
		};
	}

	/**
	 * static field for the Taskfactory loader to load the task factory for this task.
	 */
	public static final ITaskFactory<Boolean> FACTORY = new ITaskFactory<Boolean>() {

		@Override
		public ITask<Boolean> make(String param) {
			return new IsOdd(Integer.parseInt(param));
		}

		@Override
		public String toString() {
			return IsOdd.class.getName();
		}
	};

	/**
	 * Reinitializes transient fields upon deserialization.  See the 
	 * <a href="http://download.oracle.com/javase/6/docs/api/java/io/Serializable.html">
	 * Serializable</a> marker interface docs.
	 * taskView is set to a default value for now (ILocalTaskViewAdapter.DEFAULT_ADAPTER).
	 * @param stream The object stream with the serialized data
	 * @throws IOException if the input stream cannot be read correctly
	 * @throws ClassNotFoundException if the class file associated with the input stream cannot be located.
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject(); // Deserialize the non-transient data
		taskView = ILocalTaskViewAdapter.DEFAULT_ADAPTER; // re-initialize the transient field
	}

}
