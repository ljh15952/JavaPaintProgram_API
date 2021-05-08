import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private MyFrame _frame;

	public MyPanel(MyFrame f) {
		setBackground(Color.white);
		_frame = f;
		// 마우스 리스너를 프레임이 가지고있으면 위에 설정창까지 좌표에 들어가서 그림이 이상하게 그려짐
		addMouseListener(new MyMouseListener(_frame));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 다형성을 활용해서 여러가지 도형이 담긴 배열을 그려주기만 해도 OK
		for (Figure r : _frame.getFigureList()) {
			r.draw(g);
		}
	}
}
