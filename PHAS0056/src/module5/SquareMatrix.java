package module5;

public class SquareMatrix {
	private double[][] m;
	
	public SquareMatrix() { 
		//returns null for no arguments
	}

	public SquareMatrix(double[][] elements) throws Exception {
		if (elements.length == 0) {
			throw new Exception ("Cannot be a zero by zero matrix.");
		}
		for (int i = 0; i < elements.length; i++) {
			if (elements.length != elements[i].length) {
				throw new Exception ("Must be a valid square matrix.");
			} 
		}
		m = elements;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder("");
		for (int i = 0; i < m.length; i++) {
		    for (int j = 0; j < m[i].length; j++) {
		    	s.append(m[i][j] + " ");
		    }
		    s.append("\n");
		}
		s.append("\n");
		return s.toString();
	}
	
	public static SquareMatrix unitMatrix(int size) throws Exception {
			double[][] array = new double[size][size];
			for (int i = 0; i < array.length; i++) {
				array[i][i] = 1;
			}
			try {
				return new SquareMatrix(array);
			} catch (Exception e) {
				System.out.print(e);
			}
			
	
	}
}
