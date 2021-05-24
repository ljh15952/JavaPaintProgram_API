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

	private MyButton rectBtn;
	private MyButton ovalBtn;
	private MyButton lineBtn;

	private StatePattern _nowState = null;

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setContentPane(new MyPanel(this));
	}

	public void Init() {
		_figArr = new Vector<>();
		_buttonArr = new Vector<>();
		MyButtonActionListener btnListener = new MyButtonActionListener(this);
		// 버튼 생성
		rectBtn = new MyButton("사각형");
		rectBtn.setBounds(10, 60, 70, 25); // 위치와 크기를 결정한다. x=10 y=60 width=70, height=25 이다.
		this.add(rectBtn);
		rectBtn.addListener(btnListener);

		ovalBtn = new MyButton("타원");
		this.add(ovalBtn);
		ovalBtn.setBounds(90, 60, 70, 25);
		ovalBtn.addListener(btnListener);

		lineBtn = new MyButton("선분");
		this.add(lineBtn);
		lineBtn.setBounds(170, 60, 70, 25);
		lineBtn.addListener(btnListener);
	}

	class MyButtonActionListener implements MyActionListener {
		private MyFrame frame;

		public MyButtonActionListener(MyFrame f) {
			frame = f;
		}

		@Override
		public void actionPerformed(MyEvent e) {
			if (e.getSource() == rectBtn) {
				_nowState = new DrawRectState(frame);
			} else if (e.getSource() == ovalBtn) {
				_nowState = new DrawOvalState(frame);
			} else if (e.getSource() == lineBtn) {
				_nowState = new DrawLineState(frame);
			}
		}
	}

	public void do_something(Point p1, Point p2) {
		if (_nowState == null)
			return;

		_nowState.do_something(p1, p2);
	}

	public void add(MyButton b) {
		_buttonArr.add(b);
	}

	public void addFigure(Figure f) {
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
