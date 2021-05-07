
public class Main {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setContentPane(new MyPanel());
		//setVisible 나중에 안해주면 프로그램 시작했을 때 Panel의 paint가 호출 안될때도 있음
		frame.setVisible(true);
	}
}
