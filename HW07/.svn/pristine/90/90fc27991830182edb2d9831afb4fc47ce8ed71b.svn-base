package client.controller;

import java.awt.EventQueue;

import provided.client.model.taskUtils.ITaskFactory;
import client.model.ClientModel;
import client.model.IViewAdapter;
import client.view.ClientView;
import client.view.IModelAdapter;

/**
 * Controller for the client.
 * @author yt30, zx17
 */
public class ClientController {
	/**
	 * The model for the client
	 */
	private ClientModel _model;
	/**
	 * The view for the client.
	 */
	private ClientView<ITaskFactory<?>> _view;

	/**
	 * Constructor for the client.
	 */
	public ClientController() {
		_model = new ClientModel(new IViewAdapter() {

			@Override
			public void append(String s) {
				_view.append(s);
			}

		});

		_view = new ClientView<ITaskFactory<?>>(new IModelAdapter<ITaskFactory<?>>() {

			@Override
			public String getDefaultRemoteHost() {
				// TODO Auto-generated method stub
				return _model.getDefaultRemoteHost();
			}

			@Override
			public void quit() {
				_model.stop();
			}

			@Override
			public String connect(String remoteHostIP) {
				return _model.connectTo(remoteHostIP);
			}

			@Override
			public void sendMsgToComputeEngine(String msg) {
				_model.sendMsgToComputeEngine(msg);
			}

			@Override
			public void runTask(ITaskFactory<?> tf, String param) {
				_model.runTask(_model.loadTask(tf, param));
			}

			@Override
			public ITaskFactory<?> addFactory(String classname) {
				return _model.makeTaskFactory(classname);
			}

			@Override
			public ITaskFactory<?> addMultiTasksFactory(ITaskFactory<?> tf1, ITaskFactory<?> tf2, String param) {
				// TODO Auto-generated method stub
				return _model.combineTaskFactory(tf1, tf2, param);
			}

		});
	}

	/**
	 * start the controller.
	 */
	public void start() {
		_model.start();
		_view.start();
	}

	/**
	 * Run the controller to launch the client.
	 * @param args Default paramters.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// java specs say that the system must be constructed on the GUI event thread
			@Override
			public void run() {
				try {
					ClientController controller = new ClientController();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
