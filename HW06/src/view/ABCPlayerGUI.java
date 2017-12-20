package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The GUI of ABCMusicPlayer.
 * @author Yuhui Tong, Yunxiang Zhang
 *
 */
public class ABCPlayerGUI<TInstrument> extends JFrame {

	/**
	 * Default Serial code.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The content panel
	 */
	private JPanel contentPane;

	/**
	 *  The control panel
	 */
	private final JPanel _pnlControl = new JPanel();

	/**
	 * The text field to get music filename.
	 */
	private final JTextField _txtFileName = new JTextField();

	/**
	 * The "Load" button to load .abc file and display the contents.
	 */
	private final JButton _btnLoad = new JButton("Load");

	/**
	 * The "Parse" button to parse to parse the file and display the IPhrase object.
	 */
	private final JButton _btnParse = new JButton("Parse");

	/**
	 * The label to display "Files:"
	 */
	private final JLabel lblNewLabel = new JLabel("File:");

	/**
	 * The dropbox where an instrument is selected to play music
	 */
	private final JComboBox<TInstrument> _cbInstruments = new JComboBox<TInstrument>();

	/**
	 * The "Play" button to play music.
	 */
	private final JButton _btnPlay = new JButton("Play");

	/**
	 * The split panel to hold two JScrollPanel.
	 */
	private final JSplitPane _spDisplay = new JSplitPane();

	/**
	 * The scroll panel for file contents.
	 */
	private final JScrollPane _scpFileContents = new JScrollPane();

	/**
	 * The text area for file contents.
	 */
	private final JTextArea _taFileContents = new JTextArea();

	/**
	 * The scroll panel for IPhrase structure.
	 */
	private final JScrollPane _scpIPhrase = new JScrollPane();

	/**
	 * The text area for IPhrase structure.
	 */
	private final JTextArea _taPhraseStructure = new JTextArea();

	/**
	 * The "Stop" button to stop playing music.
	 */
	private final JButton _btnStop = new JButton("Stop");

	/**
	 * The view to model adapter.
	 */
	private IView2ModelAdapter<TInstrument> _view2ModelAdpt;

	/**
	 * Create the frame.
	 */
	public ABCPlayerGUI(IView2ModelAdapter<TInstrument> _view2ModelAdpt) {
		this._view2ModelAdpt = _view2ModelAdpt;
		_txtFileName.setText("scale");
		_txtFileName.setToolTipText("File to load. Assumed to be in the songs folder with .abc extension.");
		_txtFileName.setColumns(8);
		initGUI();
	}

	/**
	 * Start the frame.
	 */
	public void start() {
		_view2ModelAdpt.addInstruments();
		this.setVisible(true);
	}

	/**
	 * Init the GUI.
	 */
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		_pnlControl
				.setBorder(new TitledBorder(null, "Control Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_pnlControl.setBackground(Color.LIGHT_GRAY);

		contentPane.add(_pnlControl, BorderLayout.NORTH);

		_pnlControl.add(lblNewLabel);

		_pnlControl.add(_txtFileName);

		_btnLoad.addActionListener(new ActionListener() { // load file.
			@Override
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.load(_txtFileName.getText());
				_btnParse.setEnabled(true);
			}
		});
		_btnLoad.setToolTipText("Load the file and create the ABCParser");
		_pnlControl.add(_btnLoad);

		_btnParse.addActionListener(new ActionListener() {// parse file
			@Override
			public void actionPerformed(ActionEvent e) {
				String iphrase_structure = _view2ModelAdpt.parse();
				_taPhraseStructure.setText(iphrase_structure);//display the iphrase structure.
				_btnPlay.setEnabled(true);
			}
		});
		_btnParse.setToolTipText("Parse the file and create an IPhrase structure.");
		_btnParse.setEnabled(false);
		_pnlControl.add(_btnParse);

		_cbInstruments.setToolTipText("Select an instrument to use when playing.");

		_pnlControl.add(_cbInstruments);
		_btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // play the music
				if (_cbInstruments.getSelectedIndex() < 0) {
					System.out.println("You need to select an instrument to play with!");
					return;
				}
				_view2ModelAdpt.play(_cbInstruments.getItemAt(_cbInstruments.getSelectedIndex()));
				_btnStop.setEnabled(true);
			}
		});
		_btnPlay.setToolTipText("Play the parsed IPhrase data structure.");
		_btnPlay.setEnabled(false);
		_pnlControl.add(_btnPlay);

		_btnStop.addActionListener(new ActionListener() { // stop playing music.
			@Override
			public void actionPerformed(ActionEvent e) {
				_view2ModelAdpt.stop();
				System.out.println("Music is stopped.");
			}
		});

		_btnStop.setToolTipText("Stop playing music.");
		_btnStop.setEnabled(false);
		_pnlControl.add(_btnStop);

		_spDisplay.setResizeWeight(0.5);
		_spDisplay.setOrientation(JSplitPane.VERTICAL_SPLIT);

		contentPane.add(_spDisplay, BorderLayout.CENTER);
		_scpFileContents.setViewportBorder(
				new TitledBorder(null, "File Contents", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_scpFileContents.setToolTipText("");

		_spDisplay.setLeftComponent(_scpFileContents);
		_taFileContents.setLineWrap(true);
		_taFileContents.setToolTipText("The text contents of the file.");

		_scpFileContents.setViewportView(_taFileContents);
		_scpIPhrase.setViewportBorder(
				new TitledBorder(null, "Parsed IPhrase structure", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		_spDisplay.setRightComponent(_scpIPhrase);
		_taPhraseStructure.setToolTipText("The string expression of parsed iphrase structure.");
		_taPhraseStructure.setLineWrap(true);

		_scpIPhrase.setViewportView(_taPhraseStructure);
	}

	/**
	 * Display the file contents of the ABC file.
	 * @param fileContents The file contents of the ABC file.
	 */
	public void displayFileContents(String fileContents) {
		_taFileContents.setText(fileContents);
	}

	/**
	 * Add Instrument to the instrument drop list
	 * @param instrument The instrument to be added to the drop list.
	 */
	public void addInstrument(TInstrument instrument) {
		_cbInstruments.addItem(instrument);
	}

}
