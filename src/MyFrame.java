import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	// 버튼이랑 도형 리스트를 따로둬야지 버튼만 클릭했는지 검사가능
	private Vector<Figure> _figArr;

	// 리스트로 구현해야 될 수도있음
	private MyToolBar _toolBar;

	private StatePattern _nowState = null;

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setContentPane(new MyPanel(this));
	}

	public void Init() {
		_figArr = new Vector<>();
		MyToolBar toolBar = new MyToolBar(this);
		setToolBar(toolBar);
	}

	private void setToolBar(MyToolBar toolBar) {
		_toolBar = toolBar;
	}

	public void do_something(Point p1, Point p2) {
		if (_nowState == null)
			return;

		_nowState.do_something(p1, p2);
	}

	public void addFigure(Figure f) {
		_figArr.add(f);
		repaint();
	}

	public Vector<Figure> getFigureList() {
		return _figArr;
	}

	public Vector<MyButton> getButtonList() {
		return _toolBar.getButtonList();
	}

	public MyToolBar getToolbar() {
		return _toolBar;
	}

	public void setState(StatePattern s) {
		_nowState = s;
	}
}
