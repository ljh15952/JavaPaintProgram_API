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

	@Override
	public void mouseReleased(MouseEvent e) {
		Figure f;
		if (e.isShiftDown()) {
			f = new Circle(_firstPos, new Point(e.getX(), e.getY()));
		} else {
			f = new Rectangle(_firstPos, new Point(e.getX(), e.getY()));
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
