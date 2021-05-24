import java.util.Vector;

class MyButtonActionListener implements MyActionListener {
	private MyFrame frame;

	public MyButtonActionListener(MyFrame f) {
		frame = f;
	}

	@Override
	public void actionPerformed(MyEvent e) {
//		페퍼런스로 비교
//		if (frame.getToolbar().getButtonList().elementAt(0) == e.getSource()) {
//			frame.setState(new DrawRectState(frame));
//		} else if (frame.getToolbar().getButtonList().elementAt(1) == e.getSource()) {
//			frame.setState(new DrawOvalState(frame));
//		} else if (frame.getToolbar().getButtonList().elementAt(2) == e.getSource()) {
//			frame.setState(new DrawLineState(frame));
//		}
		// 이름으로 비교
		if ("사각형" == e.getSourceStr()) {
			frame.setState(new DrawRectState(frame));
		} else if ("타원" == e.getSourceStr()) {
			frame.setState(new DrawOvalState(frame));
		} else if ("선분" == e.getSourceStr()) {
			frame.setState(new DrawLineState(frame));
		}
	}
}