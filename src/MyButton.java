import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyButton {
	// private String _name;
	private String _name;
	private Point _position;
	private Point _size;

	// Observer Pattern
	private Vector<MyActionListener> _myListenerList;

	public MyButton(String n) {
		_name = n;
		_myListenerList = new Vector<>();
	}

	public void setBounds(int i, int j, int k, int l) {
		_position = new Point(i, j);
		_size = new Point(k, l);
	}

	public void draw(Graphics g) {
		g.drawRect(_position.x, _position.y, _size.x, _size.y);
		g.drawString(_name, _position.x + 10, _position.y + 15);
	}

	public Boolean contains(Point p) {
		if (_position.x <= p.x && _position.y <= p.y && _size.x + _position.x >= p.x && _size.y + _position.y >= p.y) {
			return true;
		}
		return false;
	}

	public void addListener(MyActionListener btnListener) {
		_myListenerList.add(btnListener);
	}

	public void ClickEvent() {
		// 리스너 활용
		for (MyActionListener it : _myListenerList) {
			it.actionPerformed(new MyEvent(_name, _position, this));
		}
	}
}
