package model.paint.strategy;

import model.paint.UprightImagePaintStrategy;

/**
 * An example of an ImagePaintStrategy that randomly picks one of two animated image files to display when it is instantiated.
 * @author Yuhui Tong, Haoyuan Yue
 *
 */
public class BirdSheepImagePaintStrategy extends UprightImagePaintStrategy {

	/**
	 * No-parameter constructor that instantiates te AffineTransform used internally and randomly loads one 
	 * of the two files: bird or sheep with a fill factor of 0.5;
	 */
	public BirdSheepImagePaintStrategy() {
		//super("../../../model/paint/strategy/images/humbird_animate.gif", 1);
		super(Math.random() < 0.5 ? "images/humbird_animate.gif" : "images/sheep_animate.gif", 0.5);
	}

}
