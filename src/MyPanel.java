import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	public MyPanel() {
		setBackground(Color.white);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(100, 100, 50, 50);
		g.drawOval(100, 100, 70, 70);
	}
}
