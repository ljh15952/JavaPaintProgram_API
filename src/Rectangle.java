import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Figure {
	public Rectangle(Point p, Point s) {
		super(p, s);
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}
}
