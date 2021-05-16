//TODO
//사각형 버튼, 원 버튼, 선 버튼 누른 상태마다 그리는 것을 다르게
//버튼 클릭-> Click함수 _litsener->actionPerform()
//@Override actionPerform() 내부 그리기 상태값 변경 myButton.getState()

public interface MyListener {
	void actionPerformed(MyEvent e);
}
