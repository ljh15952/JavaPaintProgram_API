import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private Vector<Figure> _figArr;

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		//addMouseListener(new MyMouseListener(this));
		setContentPane(new MyPanel(this));
		_figArr = new Vector<>();
	}

	public void addFigureList(Figure f) {
		_figArr.add(f);
		repaint();
	}

	public Vector<Figure> getFigureList() {
		return _figArr;
	}
}
