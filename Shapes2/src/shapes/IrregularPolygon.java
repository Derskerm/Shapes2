package shapes;

import gpdraw.DrawingTool;
import java.awt.geom.Point2D;
import java.util.ArrayList;
	
public class IrregularPolygon extends Shape {
	
	private ArrayList<Point2D.Double> points;
	private ArrayList<Line> mySides;        // array of Line objects for each side
	
	public IrregularPolygon() {
		super(0, 0);
		points = new ArrayList<Point2D.Double>();
	}
	
	public void add(Point2D.Double point) {
		points.add(point);
	}
	
    public double calcPerimeter(){
    	double total = 0;
    	for (int i = 0; i < points.size(); i++) {
    		if (i == points.size()-1) {
    			total += Math.sqrt(points.get(i).distance(points.get(0)));
    		} else {
    			total += Math.sqrt(points.get(i).distance(points.get(i+1)));
    		}
    	}
    	return total;
    }
    
    public void remove() {
    	points.remove(points.size()-1);
    }
    
    public void add(Point2D.Double[] p) {
    	for (Point2D.Double q : p) {
    		points.add(q);
    	}
    }
    
    public double calcArea(){
    	double total = 0;
    	for (int i = 0; i < points.size(); i++) {
    		if (i == points.size()-1) {
    			total += points.get(i).x * points.get(0).y;
    		} else {
    			total += points.get(i).x * points.get(i+1).y;
    		}
    	}
    	for (int i = 0; i < points.size(); i++) {
    		if (i == points.size()-1) {
    			total -= points.get(i).y * points.get(0).x;
    		} else {
    			total -= points.get(i).y * points.get(i+1).x;
    		}
    	}
    	
    	total /= 2;
    	total = Math.abs(total);
    	return total;
    }
    
    public boolean equals(Object obj) {
    	if (obj instanceof IrregularPolygon) {
    		IrregularPolygon other = (IrregularPolygon)obj;
	    	if (other.points.size() != this.points.size()) {
	    		return false;
	    	} else {
	    		for (int i = 0; i < points.size(); i++) {
	    			if (!this.points.get(i).equals(other.points.get(i))) {
	    				return false;
	    			}
	    		}
	    	}
	    	return true;
    	} else {
    		return false;
    	}
    }
    
    public String toString() {
    	String s = "";
    	for (Point2D.Double p : points) {
    		s += p.toString() + "/n";
    	}
    	return s;
    }
    
    public void draw(DrawingTool marker){
    	Line[] lines = new Line[points.size()];
    	for (int i = 0; i < lines.length; i++) {
    		Point2D.Double p1 = points.get(i);
    		Point2D.Double p2 = points.get(i+1);
    		lines[i] = new Line(p1.x, p1.y, p2.x, p2.y);
    	}
    	
    	for (Line l : lines) {
    		l.draw(marker);
    	}
    }
    
}	
	