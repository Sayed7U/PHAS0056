package module5;

public class TestSquareMatrix {
	public static void main(String[] args) {
		try {
			SquareMatrix s = new SquareMatrix(new double[][] {{1,2,3},{2,3,3},{3,1,2}});
			SquareMatrix s2 = SquareMatrix.unitMatrix(3);
			System.out.println(SquareMatrix.multiply(s, s2));
			System.out.println(s);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

}
