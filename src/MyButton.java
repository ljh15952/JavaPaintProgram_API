import java.awt.Graphics;
import java.awt.Point;

public class MyButton {
	private String _name;
	Point _position;
	Point _size;

	public MyButton(String n) {
		_name = n;
	}

	public void setBounds(int i, int j, int k, int l) {
		_position = new Point(i, j);
		_size = new Point(k, l);
	}

	public void draw(Graphics g) {
		g.drawRect(_position.x, _position.y, _size.x, _size.y);
	}

	public Boolean contains(Point p) {
		if (_position.x <= p.x && 
			_position.y <= p.y &&
			_position.x + _size.x >= p.x &&
			_position.y + _size.y >= p.y) {
			return true;
		}
		return false;
	}
	
	public void ClickEvent(){
		System.out.println(_name + " 클릭됨");
	}
}
