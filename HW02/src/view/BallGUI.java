package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Graphics;
import java.awt.Color;

import java.awt.Component;

/**
 * GUI of BallWorldApp
 * @author Yuhui Tong, Anqi Yu
 * @version 1.0 
 */
public class BallGUI extends JFrame {

	/**
	 * The generated serial ID.
	 */
	private static final long serialVersionUID = 1428495908806680683L;

	/**
	 * The adapter which allow view (BallGUI) to talk to model (BallModel).
	 */
	private IView2ModelAdapter _view2ModelAdpt = IView2ModelAdapter.NULL_OBJECT;

	/**
	 * The panel containing all components;
	 */
	private JPanel pnlContent;

	/**
	 * Control panel containing buttons.
	 */
	private final JPanel pnlControl = new JPanel();

	/**
	 * Textfield where the user input classname for desired ball.
	 */
	private final JTextField textInput = new JTextField();

	/**
	 * The button at which by clicking a new ball will be loaded.
	 */
	private final JButton btnLoadNewBall = new JButton("Load new ball!");

	/**
	 * The button at which by clicking all balls will be removed.
	 */
	private final JButton btnClearBalls = new JButton("Clear balls!");

	/**
	 * The central panel, which is also the canvas to paint balls.
	 */
	private final JPanel _pnlCanvas = new JPanel() {
		/**
		 * default serial id.
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Overridden paintComponent method to paint in the panel.
		 * @param g The graphics object to paint on.
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Do everything normally done first, e.g., clear the screen.
			_view2ModelAdpt.paint(g);// ask BallModel to update.
		}
	};

	/**
	 * The constructor of BallGUI
	 * @param _view2ModelAdpt Adapter from BallGUI to BallModel
	 */
	public BallGUI(IView2ModelAdapter _view2ModelAdpt) {
		this._view2ModelAdpt = _view2ModelAdpt;
		textInput.setText("model.ball.DrunkenBall");
		textInput.setToolTipText("Please input the classname of your desired ball here!");
		textInput.setColumns(10);
		initGUI();
	}

	/**
	 * Initialize the GUI components but do not start the frame.
	 * This method could be public if desired.
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnlContent = new JPanel();
		pnlContent.setToolTipText("The panel that containing all components.");
		pnlContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlContent.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlContent);
		pnlControl.setBackground(Color.GRAY);
		pnlControl.setToolTipText("The control panel containing textfield and buttons!");

		pnlContent.add(pnlControl, BorderLayout.NORTH);

		pnlControl.add(textInput);

		btnLoadNewBall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// talk to model to a ball of desiring ball type.
				String text = textInput.getText();
				_view2ModelAdpt.loadBall(text);
				System.out.println("A new ball is loaded!");
			}
		});
		btnLoadNewBall.setToolTipText("Please click here to load your desired ball!");
		pnlControl.add(btnLoadNewBall);

		btnClearBalls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// talk to model to clear the canvas
				_view2ModelAdpt.clearBalls();
				System.out.println("All balls are removed!");
			}
		});
		btnClearBalls.setToolTipText("Click to remove all the balls!");

		pnlControl.add(btnClearBalls);
		_pnlCanvas.setBackground(Color.LIGHT_GRAY);
		_pnlCanvas.setToolTipText("This is the canvas for BallWorld!");

		pnlContent.add(_pnlCanvas, BorderLayout.CENTER);
	}

	/**
	 * Starts the already initialized frame, making it 
	 * visible and ready to interact with the user.
	 */
	public void start() {
		this.setVisible(true);
	}

	/**
	 * Get the component of the canvas/panel
	 * @return the component of the canvas/panel
	 */
	public Component getCanvas() {
		return _pnlCanvas;
	}

	/**
	 * Updates the view by repainting the canvas.
	 */
	public void repaint() {
		_pnlCanvas.repaint();
	}

	/**
	 * Testing if the GUI works
	 * @param args Default String[] argument.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BallGUI frame = new BallGUI(IView2ModelAdapter.NULL_OBJECT);
					frame.start();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
