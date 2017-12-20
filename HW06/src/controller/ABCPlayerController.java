package controller;

import java.awt.EventQueue;

import model.ABCPlayerModel;
import model.IModel2ViewAdapter;
import provided.util.ABCInstrument;
import view.ABCPlayerGUI;
import view.IView2ModelAdapter;

/**
 * Controller of ABC music player.
 * @author Yuhui Tong, Yunxiang Zhang
 *
 */
public class ABCPlayerController {

	/**
	 * model of ABCPlayer
	 */
	private ABCPlayerModel _model;

	/**
	 * GUI of ABCPlayer
	 */
	private ABCPlayerGUI<ABCInstrument> _view;

	/**
	 * Constructor of the controller
	 */
	public ABCPlayerController() {
		_model = new ABCPlayerModel(new IModel2ViewAdapter() {

			/**
			 * {@inheritDoc}</br>
			 */
			@Override
			public void displayFileContent(String fileContents) {
				_view.displayFileContents(fileContents);
			}

			/**
			 * {@inheritDoc}</br>
			 */
			@Override
			public void addInstrument(ABCInstrument instrument) {
				_view.addInstrument(instrument);
			}
		});

		_view = new ABCPlayerGUI<ABCInstrument>(new IView2ModelAdapter<ABCInstrument>() {
			/**
			 * {@inheritDoc}</br> 
			 */
			@Override
			public void load(String filename) {
				_model.loadABCFile(filename);
			}

			/**
			 * {@inheritDoc}</br> 
			 */
			@Override
			public String parse() {
				// TODO Auto-generated method stub
				return _model.parseFile();
			}

			/**
			 * {@inheritDoc}</br> 
			 */
			@Override
			public void stop() {
				_model.stop();

			}

			/**
			 * {@inheritDoc}</br> 
			 */
			@Override
			public void play(ABCInstrument instrument) {
				_model.play(instrument);

			}

			/**
			 * {@inheritDoc}</br> 
			 */
			@Override
			public void addInstruments() {
				_model.addInstruments2View();
			}
		});
	}

	/**
	 * Start the application.
	 */
	public void start() {
		_model.start();
		_view.start();
	}

	/**
	 * Instantiate the ABCMusicPlayer
	 * @param args Default string[] arguments.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// java specs say that the system must be constructed on the GUI event thread
			@Override
			public void run() {
				try {
					ABCPlayerController controller = new ABCPlayerController();
					controller.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
