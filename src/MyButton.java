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
	// Composition Pattern
	private Rectangle _rect;

	// Observer Pattern
	private Vector<MyRealActionListener> _myListenerList;

	public MyButton(String n) {
		_name = n;
		_rect = null;
		_myListenerList = new Vector<>();
	}

	public void setBounds(int i, int j, int k, int l) {
		_position = new Point(i, j);
		_size = new Point(k, l);
		_rect = new Rectangle(_position, _size);
	}

	public void draw(Graphics g) {
		g.drawRect(_position.x, _position.y, _size.x, _size.y);
		g.drawString(_name, _position.x + 10, _position.y + 15);
	}

	public Boolean contains(Point p) {
		if (_rect.getX() <= p.x && _rect.getY() <= p.y && _rect.getWidth() + _rect.getX() >= p.x
				&& _rect.getHeight() + _rect.getY() >= p.y) {
			return true;
		}
		return false;
	}

	public void ClickEvent() {
		//리스너 활용
		for(MyRealActionListener it : _myListenerList) {
			it.actionPerformed(new MyEvent(_name,_position,this));
		}
	}

	public void addListener(MyRealActionListener btnListener) {
		btnListener.setButton(this);
		_myListenerList.add(btnListener);
	}
}
