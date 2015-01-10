package shapes;
import java.awt.Color;

import gpdraw.DrawingTool;

public class Line extends Shape {
	
	private int myX1, myY1, myX2, myY2;

	/**
	 * Creates a new Line from (x1, y1) to (x2, y2)
	 * @param x1 
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public Line(int x1, int y1, int x2, int y2) {
		super(x1, y1);
		myX1 = x1;
		myX2 = x2;
		myY1 = y1;
		myY2 = y2;
	}
	
	/**
	 * Creates a new line at (x1,y1) for a set length for a set angle
	 * @param x1
	 * @param y1
	 * @param degrees
	 * @param length
	 */
	public Line(int x1, int y1, double degrees, double length) {
		this(x1, y1, (int)(x1 + length * Math.cos(Math.toRadians(degrees))),
				(int)(y1 + length * Math.sin(Math.toRadians(degrees))));
	}
	
	public Line(double x, double y, double x2, double y2) {
		this ((int)x, (int)y, (int)x2, (int)x2);
	}

	public void translateTo(int x, int y) {
		super.translateTo(x, y);
		myX2 += myX1 - x;
		myY2 += myY1 - y;
		myX1 = x;
		myY1 = y;
	}

	public int getX() {
		return myX1;
	}
	
	public int getX2() {
		return myX2;
	}
	
	public int getY() {
		return myY1;
	}
	
	public int getY2() {
		return myY2;
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow((myX2 - myX1), 2) + Math.pow((myY2 - myY1), 2));
	}
	
	/**
	 * Draws the Line
	 * @param marker the DrawingTool used to draw the Line
	 * @post DrawingTool reset to Color.BLACK, down, position 90, and at home.
	 */
	public void draw(DrawingTool marker) {
		setDrawingToolToCustomValues(marker);
		marker.move(myX2, myY2);
		returnDrawingToolToDefault(marker);
	}
}
