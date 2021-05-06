import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	// Test Variable
	Rectangle r;
	Circle c;

	public MyPanel() {
		setBackground(Color.white);
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
}
