
public class Circle extends Figure {

	@Override
	public void draw(int x, int y, int w, int h) {
		getGraphics().drawOval(x, y, w, h);
	}

}
