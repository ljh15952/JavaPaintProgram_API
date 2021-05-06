import java.awt.Graphics;

public abstract class Figure {
	private int _x, _y, _width, _height;
	private Graphics _g;

	public int getHeight() {
		return _height;
	}

	public void setHeight(int _height) {
		this._height = _height;
	}

	public int getWidth() {
		return _width;
	}

	public void setWidth(int _width) {
		this._width = _width;
	}

	public int getY() {
		return _y;
	}

	public void setY(int _y) {
		this._y = _y;
	}

	public int getX() {
		return _x;
	}

	public void setX(int _x) {
		this._x = _x;
	}

	public Graphics getGraphics() {
		return _g;
	}

	public void setGraphics(Graphics _g) {
		this._g = _g;
	}

	public abstract void draw(int x, int y, int w, int h);

}
