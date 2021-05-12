import java.awt.Graphics;
import java.awt.Point;

public class MyButton {
	private String _name;
	private Point _position;
	private Point _size;
	//Composition Pattern
	private Rectangle _rect;
	public MyButton(String n) {
		_name = n;
		_rect = null;
	}

	public void setBounds(int i, int j, int k, int l) {
		_position = new Point(i, j);
		_size = new Point(k, l);
		_rect = new Rectangle(_position, _size);
	}

	public void draw(Graphics g) {
		g.drawRect(_position.x, _position.y, _size.x, _size.y);
	}

	public Boolean contains(Point p) {
		if (_rect.getX() <= p.x && 
			_rect.getY() <= p.y &&
			_rect.getWidth() + _rect.getX() >= p.x &&
			_rect.getHeight() + _rect.getY() >= p.y) {
				return true;
		}
		return false;
	}
	
	public void ClickEvent(){
		System.out.println(_name + " 클릭됨");
	}
}
