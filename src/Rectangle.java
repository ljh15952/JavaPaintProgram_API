
public class Rectangle extends Figure {

	@Override
	public void draw(int x, int y, int w, int h) {
		getGraphics().drawRect(x, y, w, h);
	}

}
