package model.ball;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class EllipseBall extends ABall {
	private double r = 2.0/3; // radius of proto ball
	private AffineTransform at = new AffineTransform();
	private Shape proto_shape = new Ellipse2D.Double(-2*r, -r, 4*r, 2*r);

	public EllipseBall(Point startLoc, int startRadius, Point startVel, Color startColor, Component theCanvas) {
		super(startLoc, startRadius, startVel, startColor, theCanvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateBalls() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		//at.setToTranslation(location.x, location.y);
		//at.setToTranslation(0, 0);
		//at.rotate(1,1);
		at.setToTranslation(location.x, location.y);
		at.rotate(velocity.x, velocity.y);
		at.scale(radius, radius);
		
		// at.rotate(velocity.x, velocity.y);
		
		//at.rotate(velocity.x, velocity.y);
		Shape newShape = at.createTransformedShape(proto_shape);
		g.setColor(color);
		((Graphics2D) g).fill(newShape);
	}

}
