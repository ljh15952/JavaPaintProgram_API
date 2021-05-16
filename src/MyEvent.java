import java.awt.Point;

public class MyEvent {
	private String _str;
	private Point _point;
	private MyButton _btn;
	public MyEvent(String name, Point position,MyButton b) {
		_str = name;
		_point = position;
		_btn = b;
	}
	
//	public String getSource() {
//		return _str;
//	}
//	public Point getSource() {
//		return _point;
//	}
	public MyButton getSource() {
		return _btn;
	}
	public String getSourceStr() {
		return _str;
	}
}
