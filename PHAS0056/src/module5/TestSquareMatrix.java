package module5;

public class TestSquareMatrix {
	public static void main(String[] args) {
		try {
			SquareMatrix s = new SquareMatrix(new double[3][3]);
			System.out.println(s);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

}
