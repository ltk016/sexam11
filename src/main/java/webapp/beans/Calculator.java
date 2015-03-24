package webapp.beans;

public class Calculator {

	private Calculator() {

	}

	static private Calculator calc;
//	Singleton, 딱 하나만 생성 가능
	public static Calculator getInstance() {
		if (calc == null)
			calc = new Calculator();
		return calc;
	}

	public int sum(int a, int b) {
		return a + b;
	}
}
