import java.awt.Point;
import java.util.Vector;

public class MyToolBar {
	private Vector<MyButton> _buttonArr;
	private MyButton rectBtn;
	private MyButton ovalBtn;
	private MyButton lineBtn;
	private Point _toolBarPosition;

	public MyToolBar(MyFrame f) {
		MyButtonActionListener btnListener = new MyButtonActionListener(f);
		_buttonArr = new Vector<>();
		_toolBarPosition = new Point(0, 0);
		// 버튼 생성
		rectBtn = new MyButton("사각형");
		this.setBounds(rectBtn);
		this.add(rectBtn);
		rectBtn.addListener(btnListener);

		ovalBtn = new MyButton("타원");
		this.setBounds(ovalBtn);
		this.add(ovalBtn);
		ovalBtn.addListener(btnListener);

		lineBtn = new MyButton("선분");
		this.setBounds(lineBtn);
		this.add(lineBtn);
		lineBtn.addListener(btnListener);
	}

	private void setBounds(MyButton b) {
		b.setBounds(0 + _toolBarPosition.x, 0 + _toolBarPosition.y, 70, 25);
		_toolBarPosition.x += 80;
		
		//frame.width
		if(500 < _toolBarPosition.x) {
			_toolBarPosition.x = 0;
			_toolBarPosition.y += 30;
		}
	}

	public Vector<MyButton> getButtonList() {
		return _buttonArr;
	}

	public MyButton getClickedButton(Point p) {
		for (MyButton it : _buttonArr) {
			if (it.contains(p)) {
				return it;
			}
		}
		return null;
	}

	private void add(MyButton b) {
		_buttonArr.add(b);
	}
}
