import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener {
	private Vector<Figure> _figArr;
	private Point _firstPos;

	public MyPanel() {
		setBackground(Color.white);
		addMouseListener(this);
		_figArr = new Vector<>();
		_firstPos = null;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//다형성을 활용해서 여러가지 도형이 담긴 배열을 그려주기만 해도 OK
		for (Figure r : _figArr) {
			r.draw(g);
		}
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
		_figArr.add(f);
		repaint();
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
