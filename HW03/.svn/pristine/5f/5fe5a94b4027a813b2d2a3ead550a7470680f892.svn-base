package view;

import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * The GUI of the BallWorld project.
 * @author Yuhui Tong, Shengqi Wang
 * @version 1.0
 * @param <TDropListItem> A generic type which corresponds to Strategy factory on the model side.
 */
public class BallGUI<TDropListItem> extends JFrame {

	/**
	 * Generated serial version ID.
	 */
	private static final long serialVersionUID = -8105423316749761148L;

	/**
	 * The adapter which allow view (BallGUI) to talk to model (BallModel).
	 */
	private IView2ModelControlAdapter<TDropListItem> _view2ModelControlAdpt; // = IView2ModelControlAdapter<Object>.NULL_OBJECT;

	/**
	 * The adapter which allow view (BallGUI) to talk to model (BallModel).
	 */
	private IView2ModelPaintAdapter _view2ModelPaintAdpt = IView2ModelPaintAdapter.NULL_OBJECT;

	/**
	 * The main container (GUI window)
	 */
	private JPanel contentPane;
	
	/**
	 * The control panel consisting of several subpanels
	 */
	private JPanel _pnlControl; 
	
	/**
	 * The subpanel consisting of textfield and buttons regarding Strategy input.
	 */
	private JPanel _pnlAddType;
	
	/**
	 * The textfield that takes strategy classname.
	 */
	private JTextField txtInputClass;
	
	/**
	 * The panel that balls are painted on.
	 */
	private JPanel _pnlCanvas = new JPanel() {
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
			_view2ModelPaintAdpt.paint(g);// ask BallModel to update.
		}
	};
	
	/**
	 * Click this button to add a new strategy.
	 */
	private JButton _btnAddType;
	
	/**
	 * The subpanel consisting droplists and buttons regarding ball type selection and ball creation.
	 */
	private JPanel _pnlImplement;
	
	/**
	 * Click the button to make a ball using selected strategy.
	 */
	private JButton btnMakeBall;
	
	/**
	 * Droplist 1 from which one can select the strategy that a ball/switch is going to take.
	 */
	private JComboBox<TDropListItem> _list1DL;
	
	/**
	 * Droplist 2 from which one can select the strategy to combined with.
	 */
	private JComboBox<TDropListItem> _list2DL;
	
	/**
	 * CLick this button to combine strategy.
	 */
	private JButton _btnCombineStrategy;
	
	/**
	 * subpanel regarding switcherball
	 */
	private JPanel _pnlSwitcher;
	
	/**
	 * Click this button to make a switcher ball
	 */
	private JButton _btnMakeSwitcher;
	
	/**
	 * click this button to change the strategy of all switch balls.
	 */
	private JButton _btnSwitch;
	
	/**
	 * click this button to remove all balls.
	 */
	private JButton _btnClear;
	
	/**
	 * The subpanel consisting buttons regarding removing balls.
	 */
	private JPanel _pnlClear;


	
	/**
	 * Constructor of BallGUI
	 * @param _view2ModelControlAdpt The adapter that allows view to talk to model on controlling issues.
	 * @param iVew2ModelPaintAdapter The adapter that allows view to talk to model on painting issues.
	 */
	public BallGUI(IView2ModelControlAdapter<TDropListItem> _view2ModelControlAdpt, IView2ModelPaintAdapter iVew2ModelPaintAdapter) {
		this._view2ModelControlAdpt = _view2ModelControlAdpt;
		this._view2ModelPaintAdpt = iVew2ModelPaintAdapter;
		initGUI();
	}
	
	/**
	 *  A method determines how GUI works.
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);		
		
		_pnlControl = new JPanel();
		_pnlControl.setToolTipText("Control Panel");
		_pnlControl.setBackground(new Color(30, 144, 255));
		contentPane.add(_pnlControl, BorderLayout.NORTH);
		

		// subpanel 1
		_pnlAddType = new JPanel();
		_pnlControl.add(_pnlAddType);
		_pnlAddType.setLayout(new GridLayout(2, 1, 0, 0));
		// _pnlAddType.setBackground(Color.GRAY);
		
		txtInputClass = new JTextField();
		txtInputClass.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtInputClass.setToolTipText("Input a strategy name");
		txtInputClass.setText("Straight");
		_pnlAddType.add(txtInputClass);
		txtInputClass.setColumns(4);
		
		
		_btnAddType = new JButton("Add to lists"); // add ball type
		_btnAddType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TDropListItem o = _view2ModelControlAdpt.addStrategy(txtInputClass.getText());
				if (o == null) return; // just in case;
				
				System.out.println("New ball type: "+ txtInputClass.getText()+" is added!");
				_list1DL.insertItemAt(o, 0);
				_list2DL.insertItemAt(o, 0);
			}
		});
		_btnAddType.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		_btnAddType.setForeground(Color.BLACK);
		_btnAddType.setBackground(Color.WHITE);
		_btnAddType.setToolTipText("Click to add the above strategy type to list.");
		_pnlAddType.add(_btnAddType);
		

		
		// subpanel 2
		_pnlImplement = new JPanel();
		_pnlControl.add(_pnlImplement);
		_pnlImplement.setLayout(new GridLayout(4, 1, 0, 0));

		btnMakeBall = new JButton("Make Selected Balls"); // make ball
		btnMakeBall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelControlAdpt.loadBall(_list1DL.getItemAt(_list1DL.getSelectedIndex()));
				System.out.println("A new ball is loaded!");
			}
		});
		btnMakeBall.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnMakeBall.setToolTipText("Click to load an selected ball");
		_pnlImplement.add(btnMakeBall);
		
		_list1DL = new JComboBox<TDropListItem>();
		_list1DL.setToolTipText("The top drop list to select what strategy to use in a new ball and to switch the switcher to.");
		_pnlImplement.add(_list1DL);
		
		_list2DL = new JComboBox<TDropListItem>();
		_list2DL.setToolTipText("Bottom drop list, used for combining with the top list selection.");
		_pnlImplement.add(_list2DL);
		
		_btnCombineStrategy = new JButton("Combine!");
		_btnCombineStrategy.setToolTipText("Click to combine the Strategy");
		_btnCombineStrategy.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		_btnCombineStrategy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// do nothing if either dropbox is not selected
				if (_list1DL.getSelectedIndex() == -1 || _list2DL.getSelectedIndex() == -1) 
					return;
				TDropListItem o = _view2ModelControlAdpt.combineStrategies(_list1DL.getItemAt(_list1DL.getSelectedIndex()), 
						_list2DL.getItemAt(_list2DL.getSelectedIndex()));
				_list1DL.insertItemAt(o, 0);
				_list2DL.insertItemAt(o, 0);
			}
		});
		_pnlImplement.add(_btnCombineStrategy);
		

		
		// subpanel 3
		_pnlSwitcher = new JPanel();
		_pnlControl.add(_pnlSwitcher);
		_pnlSwitcher.setLayout(new GridLayout(2, 1, 0, 0));

		
		_btnMakeSwitcher = new JButton("Make Switcher"); // make switcher
		_btnMakeSwitcher.setToolTipText("Click to make a Switcher Ball");
		_btnMakeSwitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelControlAdpt.makeSwitcherBall();
				}
			});
		
		_btnMakeSwitcher.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		_pnlSwitcher.add(_btnMakeSwitcher);
		
		_btnSwitch = new JButton("Switch!"); // switch switcher's strategy
		_btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelControlAdpt.switchStrategy(_list1DL.getItemAt(_list1DL.getSelectedIndex()));
			}
		});
		_btnSwitch.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		_btnSwitch.setToolTipText("Click to swap the strategy of switcher balls into the strategy in the upper-left droplist");
		_pnlSwitcher.add(_btnSwitch);
		
		// 
		_pnlClear = new JPanel();
		_pnlControl.add(_pnlClear);
		_pnlClear.setLayout(new GridLayout(1, 1, 0, 0));
		
		_btnClear = new JButton("Clear All!");
		_btnClear.setToolTipText("Clear all the ball on canvas");
		_btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_view2ModelControlAdpt.clearBalls();
			}
		});
		_pnlClear.add(_btnClear);
		_pnlCanvas.setToolTipText("Drawing Canvas for ball display");
		
		
		// canvas that balls are painted on
		_pnlCanvas.setBackground(Color.LIGHT_GRAY);
		contentPane.add(_pnlCanvas, BorderLayout.CENTER);
		
		
	}
	
	/**
	 * start the frame
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
	
}
