import java.awt.Graphics;
import java.awt.Point;

public class Rect extends Figure {
	@Override
	public void draw(Graphics g) {
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}
}
