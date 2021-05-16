import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	// 버튼이랑 도형 리스트를 따로둬야지 버튼만 클릭했는지 검사가능
	private Vector<Figure> _figArr;
	private Vector<MyButton> _buttonArr;
	private MyButton _clickedButton = null;
	private String _drawType = "";

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setContentPane(new MyPanel(this));
	}

	public void setClickedButton(Point p) {
		for (MyButton b : getButtonList()) {
			if (b.contains(p)) {
				_clickedButton = b;
			}
		}
	}

	public MyButton getClickedButton(Point p) {
		for (MyButton b : getButtonList()) {
			if (b.contains(p)) {
				return b;
			}
		}
		return null;
	}

	public void isButtonUp(Point p) {
		if (_clickedButton != null) {
			// 만약 버튼을 클릭했다면 도형그리기 X,
			if (getClickedButton(p) == _clickedButton) {
				// 만약 클릭하고 땟을때 버튼이 같다면
				_clickedButton.ClickEvent();
				_clickedButton = null;
			}
		}
	}

	public void add(MyButton b) {
		_buttonArr.add(b);
	}

	public void addFigureList(Figure f) {
		_figArr.add(f);
		repaint();
	}

	public Vector<Figure> getFigureList() {
		return _figArr;
	}

	public Vector<MyButton> getButtonList() {
		return _buttonArr;
	}

	public void Init() {
		_figArr = new Vector<>();
		_buttonArr = new Vector<>();
		// 버튼 생성
		MyButton Rect = new MyButton("사각형");
		MyButton Oval = new MyButton("타원");
		MyButton Line = new MyButton("선분");
		this.add(Rect);
		this.add(Oval);
		this.add(Line);
		Rect.setBounds(10, 60, 70, 25); // 위치와 크기를 결정한다. x=10 y=60 width=70, height=25 이다.
		Oval.setBounds(90, 60, 70, 25);
		Line.setBounds(170, 60, 70, 25);
		MyRealActionListener btnListener = new MyRealActionListener(this);
		Rect.addListener(btnListener);
		Oval.addListener(btnListener);
		Line.addListener(btnListener);
	}

	public void makeFigure(boolean isshiftDown, Point _firstPos, Point e) {
		// 버튼을 클릭했다면 그림X
		if (_clickedButton != null)
			return;
		if (_drawType == "")
			return;
		Figure f = null;
		Point _lastPos = e;
		Point _realPos = new Point(Math.min(_firstPos.x, _lastPos.x), Math.min(_firstPos.y, _lastPos.y));
		Point _realSize = new Point(Math.abs(_firstPos.x - _lastPos.x), Math.abs(_firstPos.y - _lastPos.y));

		if (_drawType == "사각형") {
			f = new Rectangle(_realPos, _realSize);
		} else if (_drawType == "타원") {
			f = new Circle(_realPos, _realSize);
		} else if (_drawType == "선분") {
			f = new Line(_firstPos, _lastPos);
		}
		addFigureList(f);
	}

	public void setFigureType(String type) {
		_drawType = type;
	}
	
//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//		for(MyButton b : _buttonArr) {
//			b.draw(g);
//		}
//	}
}
