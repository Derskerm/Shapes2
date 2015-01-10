package shapes;

import gpdraw.DrawingTool;

import java.awt.Color;

public abstract class Shape{
	private int myX;
	private int myY;
	private Color myColor;
	private int myWidth;
	
	public Shape(int x, int y) {
		myX = x;
		myY = y;
		myColor = Color.BLACK;
		myWidth = 1;
	}
	
	public void setColor(Color color) {
		myColor = color;
	}
	
	public Color getColor() {
		return myColor;
	}
	
	public void translateTo(int x, int y) {
		myX = x;
		myY = y;
	}
	
	public int getX() {
		return myX;
	}
	
	public int getY() {
		return myY;
	}
	
	public void setWidth(int width) {
		myWidth = width;
	}
	
	public int getWidth() {
		return myWidth;
	}
	
	/**
	 * Use before each draw() method.
	 * Sets DrawingTool to the values preset in the Shape object
	 * @param marker the DrawingTool to be set to values
	 */
	protected void setDrawingToolToCustomValues(DrawingTool marker) {
		marker.up();
		marker.setColor(myColor);
		marker.move(myX, myY);
		marker.setDirection(90);
		marker.setWidth(myWidth);
		marker.down();
	}
	
	/**
	 * Use after each draw() method.
	 * Returns the DrawingTool to the default states
	 * @param marker the DrawingTool to be reset
	 * @post DrawingTool reset to Color.BLACK, down, width 1, direction 90, and at home.
	 */
	protected void returnDrawingToolToDefault(DrawingTool marker) {
		marker.up();
		marker.setColor(Color.BLACK);
		marker.home();
		marker.setDirection(90);
		marker.setWidth(1);
		marker.down();
	}
	
	public abstract void draw(DrawingTool marker);
	
	
}

