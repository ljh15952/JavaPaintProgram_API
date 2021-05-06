import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Figure {
	public Circle(Point p, Point s) {
		super(p, s);
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
}
