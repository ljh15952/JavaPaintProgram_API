import java.util.Vector;

public class MyRealActionListener implements MyListener {
	private Vector<MyButton> myButton = new Vector<>();
	private MyFrame frame;
	public MyRealActionListener(MyFrame f) {
		frame = f;
	}
	public void setButton(MyButton b) {
		myButton.add(b);
	}

	@Override
	public void actionPerformed(MyEvent e) {
		if (myButton.elementAt(0) == e.getSource()) {
			frame.setFigureType(e.getSourceStr());
		} else if (myButton.elementAt(1) == e.getSource()) {
			frame.setFigureType(e.getSourceStr());
		} else if (myButton.elementAt(2) == e.getSource()) {
			frame.setFigureType(e.getSourceStr());
		}
	}
}
