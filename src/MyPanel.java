import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener {
	// Test Variable
	Rectangle r;
	Circle c;

	public MyPanel() {
		setBackground(Color.white);
		addMouseListener(this);
		r = new Rectangle();
		c = new Circle();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("Panel paint");
		r.setGraphics(g);
		c.setGraphics(g);
		r.draw(100, 100, 50, 50);
		c.draw(100, 100, 50, 50);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
}
