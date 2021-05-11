import java.awt.Color;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private Vector<Figure> _figArr;
	private Vector<MyButton> _buttonArr;
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		//addMouseListener(new MyMouseListener(this));
		setContentPane(new MyPanel(this));
		_figArr = new Vector<>();
		_buttonArr = new Vector<>();
		//버튼 생성
		MyButton apple = new MyButton("apple");
		MyButton banana = new MyButton("banana");
		apple.setBounds(10, 60, 70, 25);  // 위치와 크기를 결정한다. x=10 y=60 width=70, height=25 이다.
		banana.setBounds(90, 60, 70, 25);
		this.add(apple);
		this.add(banana);
	}
	public MyButton isButtonClicked(Point p) {
		for (MyButton b : getButtonList()) {
			if (b.contains(p)) {
				return b;
			}
		}
		return null;
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
}
