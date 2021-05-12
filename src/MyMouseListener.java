import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
	private Point _firstPos;
	private MyFrame _frame;

	private MyButton _clickedButton;

	public MyMouseListener(MyFrame f) {
		_frame = f;
		_firstPos = null;

		_clickedButton = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		_firstPos = new Point(e.getX(), e.getY());
		_clickedButton = _frame.isButtonClicked(_firstPos);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (_clickedButton != null) {
			// 만약 버튼을 클릭했다면 도형그리기 X,
			if (_frame.isButtonClicked(e.getPoint()) == _clickedButton) {
				// 만약 클릭하고 땟을때 버튼이 같다면
				_clickedButton.ClickEvent();
				_clickedButton = null;
			}
			return;
		}

		Figure f;
		Point _lastPos = e.getPoint();
		Point _realPos = new Point(Math.min(_firstPos.x, _lastPos.x), Math.min(_firstPos.y, _lastPos.y));
		Point _realSize = new Point(Math.abs(_firstPos.x - _lastPos.x), Math.abs(_firstPos.y - _lastPos.y));

		if (e.isShiftDown()) {
			f = new Circle(_realPos, _realSize);
		} else {
			f = new Rectangle(_realPos, _realSize);
		}
		_frame.addFigureList(f);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// System.out.println("mouseExited");
	}
}
