package FirstPackage;

public class SecondClass {

	private int first_p;
	private int second_p;

	public SecondClass() {
		setFirst(0);
		setSecond(0);
	}

	public void setFirst(int first) {
		this.first_p = first;
	}

	public void setSecond(int second) {
		this.second_p = second;
	}

	public static int Sum(int first_p, int second_p) {
		int sum = first_p + second_p;
		return sum;
	}
}