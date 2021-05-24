import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
	private Point _firstPos;
	private MyFrame _frame;

	public MyMouseListener(MyFrame f) {
		_frame = f;
		_firstPos = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		_firstPos = new Point(e.getX(), e.getY());
	}

	Boolean isButtonClicked(Point p) {
		for (MyButton it : _frame.getButtonList()) {
			if (it.contains(p)) {
				it.ClickEvent();
				return true;
			}
		}
		return false;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!isButtonClicked(e.getPoint()))
			_frame.do_something(_firstPos, e.getPoint());
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
