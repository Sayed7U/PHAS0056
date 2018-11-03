package module5;

public class TestSquareMatrix {
	public static void main(String[] args) {
		try {
			
			//defining the matrices
			SquareMatrix A = new SquareMatrix(new double[][] {{2,1,0},{0,1,0},{-1,0,2}});
			SquareMatrix B = new SquareMatrix(new double[][] {{1,3,1},{0,2,0},{1,0,-1}});
			SquareMatrix C = new SquareMatrix(new double[][] {{2,3},{3,4}});
			SquareMatrix D = new SquareMatrix(new double[][] {{-4,3},{3,-2}});
			
			//addition/subtraction of A and B
			System.out.println("A + B = \n" + SquareMatrix.add(A, B));
			System.out.println("A - B = \n" + SquareMatrix.subtract(A, B));
			
			//multiplication of A and B
			SquareMatrix AB = SquareMatrix.multiply(A, B);
			SquareMatrix BA = SquareMatrix.multiply(B, A);
			System.out.println("AB = \n" + AB);
			System.out.println("BA = \n" + BA);
			//commutator defined as AB - BA
			System.out.println("The commutator [A,B] = \n" + SquareMatrix.subtract(AB,BA));
			
			//multiplication of C and D
			SquareMatrix CD = SquareMatrix.multiply(C, D);
			System.out.println("CD = \n" + CD);
			System.out.println("is CD equal to the 2x2 identity? " + CD.equals(SquareMatrix.unitMatrix(2)));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	

}
