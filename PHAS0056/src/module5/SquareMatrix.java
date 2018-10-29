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
		for (int i = 0; i < this.m.length; i++) {
		    for (int j = 0; j < this.m[i].length; j++) {
		    	s.append(m[i][j] + " ");
		    }
		    s.append("\n");
		}
		s.append("\n");
		return s.toString();
	}
	
	public static SquareMatrix unitMatrix(int size) throws Exception {
		if (size <= 0) {
			throw new Exception ("Must have a size of 1 or above");
		}
		double[][] array = new double[size][size];
		for (int i = 0; i < array.length; i++) {
			array[i][i] = 1;
		}
		return new SquareMatrix(array);
	}
	
	public boolean equals(SquareMatrix sm) {
		if (this.m.length != sm.m.length) {
			return false;
		}
		for (int i = 0; i < this.m.length; i++) {
			for (int j = 0; j < this.m[i].length; j++) {
				if (this.m[i][j] != sm.m[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
