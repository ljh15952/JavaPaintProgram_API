import java.awt.Graphics;
import java.awt.Point;

public class Line extends Figure {
	public Line(Point p, Point s) {
		super(p, s);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(getX(), getY(), getWidth(), getHeight());
		//g.drawLine(200, 0, 100, 100);
	}
}
