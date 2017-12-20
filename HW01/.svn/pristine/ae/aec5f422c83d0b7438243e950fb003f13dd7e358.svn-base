package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import shape.AShape;
import shape.Circle;
import shape.Triangle;
import shape.Rectangle;
import shape.CompositeShape;
import java.awt.Point;

/**
 * Main frame for the application, which implements two functions.
 * function 1: click a button to display captured input text;
 * function 2: click buttons to display various simple and composite shapes.
 * @author Lyu Pan, Yuhui Tong
 */
public class MainAppFrame extends JFrame {

	/**
	 * Auto-generated Serial Version ID for serializing and deserializing an object
	 */
	private static final long serialVersionUID = -4255830396470732847L;

	/**
	 * Main panel containing components in the application
	 */
	private JPanel contentPane;

	/**
	 * North panel to hold Label/textfield/buttons.
	 */
	private final JPanel pnlControl = new JPanel();

	/**
	 * Label component on the North panel
	 * display user's input captured from text field. 
	 */
	private final JLabel lblDisplay = new JLabel("Display");

	/**
	 * Button component on the North panel
	 * Click to capture user's input
	 */
	private final JButton btnControl = new JButton("Click me!");

	/**
	 * Textfield component on the North panel
	 * Text is input here
	 */
	private final JTextField txtInput = new JTextField();

	/**
	 * AShape 
	 */
	private AShape ashape = new Rectangle(new Point(50, 50), 50, 40, Color.BLUE);

	/**
	 * Central panel where shapes are displayed.
	 */
	private final JPanel pnlCentral = new JPanel() {

		/**
		 * Auto-generated Serial Version ID for serializing and deserializing an object
		 */
		private static final long serialVersionUID = 1L;

		/** 
		 * Overridden  paintComponent method to paint a shape in the panel.
		 * @param g The graphics object to paint on.
		 */
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Do everything normally done first, e.g. clear the screen.
			g.setColor(Color.RED); // set the color to use when drawing
			g.fillOval(75, 100, 20, 40); // paint a filled 20x40 red ellipse whose upper left corner is at (75, 100)
			ashape.paint(g);
		}
	};
	/**
	 * South panel containing buttons which control shape display.
	 */
	private final JPanel pnlSouth = new JPanel();

	/**
	 * Click this button will paint a circle on central panel.
	 */
	private final JButton btnCircle = new JButton("Circle");

	/**
	 * Click this button will paint a rectangle on central panel.
	 */
	private final JButton btnRectangle = new JButton("Rectangle");

	/**
	 * Click this button will paint a triangle on central panel.
	 */
	private final JButton btnTriangle = new JButton("Triangle");

	/**
	 * Click this button will paint a composite shape on central panel.
	 */
	private final JButton btnComposite = new JButton("Composite");

	/**
	 * Launch the application.
	 * @param args	a default argument array of main method. 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAppFrame frame = new MainAppFrame();
					frame.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor for the frame, call the initialization method.
	 */
	public MainAppFrame() {
		initGUI();
	}

	/**
	 * Initialize the GUI components but do not start the frame.
	 */
	public void initGUI() {
		// set the content panel 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		pnlControl.setToolTipText("Control panel for text input and display!");
		pnlControl.setBackground(Color.ORANGE);

		contentPane.add(pnlControl, BorderLayout.NORTH);

		pnlControl.add(lblDisplay);
		lblDisplay.setToolTipText("Copied will be displayed here!");

		// click the button -- btnControl -- to display the input text.
		pnlControl.add(btnControl);
		// add a listener using lambda function
		btnControl.addActionListener((e) -> {lblDisplay.setText(txtInput.getText());});
		btnControl.setToolTipText("Click the button to copy input text!");
		btnControl.setBackground(Color.PINK);

		pnlControl.add(txtInput);
		txtInput.setToolTipText("Input sth to be copied.");
		txtInput.setText("Make input here!");
		txtInput.setColumns(10);
		pnlCentral.setToolTipText("Shapes will be displayed here!");
		pnlCentral.setBackground(Color.LIGHT_GRAY);

		contentPane.add(pnlCentral, BorderLayout.CENTER);
		pnlSouth.setToolTipText("South panel that contains buttons!");
		pnlSouth.setBackground(Color.GRAY);

		contentPane.add(pnlSouth, BorderLayout.SOUTH);

		// click the button -- btnCircle -- to display a predetermined circle.
		btnCircle.setToolTipText("Paint Circle!");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ashape = new Circle(new Point(70, 20), 50, Color.GREEN);
				pnlCentral.repaint();
			}
		});
		pnlSouth.add(btnCircle);

		// click the button -- btnRectangle -- to display a predetermined rectangle.
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ashape = new Rectangle(new Point(150, 20), 50, 30, Color.GREEN);
				pnlCentral.repaint();
			}
		});
		btnRectangle.setToolTipText("Paint rectangle!");
		pnlSouth.add(btnRectangle);

		// click the button -- btnTriangle-- to display a predetermined triangle.
		btnTriangle.setToolTipText("Paint triangle!");
		btnTriangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ashape = new Triangle(new Point(200, 50), Color.GREEN);
				pnlCentral.repaint();
			}
		});
		pnlSouth.add(btnTriangle);

		// click the button -- btnComposite -- to display a predetermined composite shape.
		btnComposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ashape = new CompositeShape(new Point(0, 0));
				((CompositeShape) ashape).addChild(new Triangle(new Point(300, 50), Color.YELLOW)); // add triangle to CompositeShape
				((CompositeShape) ashape).addChild(new Rectangle(new Point(300, 50), 50, 40, Color.YELLOW)); // add rectangle to CompositeShape
				pnlCentral.repaint();
			}
		});
		btnComposite.setToolTipText("Paint Composite shape!");
		pnlSouth.add(btnComposite);

	}

	/**
	 * Start the already initialized frame, making it visible and ready to interact with the user.
	 */
	public void start() {
		this.setVisible(true);
	}
}
