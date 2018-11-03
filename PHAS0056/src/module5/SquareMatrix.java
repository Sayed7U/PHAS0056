package module5;

//Objects of this type can carry out square matrix operations
public class SquareMatrix {
	
	//defining an array for the elements of the matrix
	private double[][] m;
	
	public SquareMatrix() { 
		//returns null for no arguments
	}
	
	//defining the constructor, takes in a double array
	public SquareMatrix(double[][] elements) throws Exception {
		if (elements.length == 0) {
			throw new Exception ("Cannot be a zero by zero matrix.");
		}
		for (int i = 0; i < elements.length; i++) { //loops through each row 
			if (elements.length != elements[i].length) { //checks that they are the same size as the column
				throw new Exception ("Must be a valid square matrix.");
			} 
		}
		m = elements;
	}
	
	//output when the object is called in a print statement
	public String toString() {
		StringBuilder s = new StringBuilder("");
		for (int i = 0; i < this.m.length; i++) {
		    for (int j = 0; j < this.m[i].length; j++) {
		    	s.append(m[i][j] + " ");
		    }
		    s.append("\n"); //new line prints after every row
		}
		s.append("\n"); //new line after so other lines printed after are clear to read
		return s.toString();
	}
	
	//returns a unit matrix with a given size (e.g size = 3 gives 3x3 unit matrix)
	public static SquareMatrix unitMatrix(int size) throws Exception {
		if (size <= 0) {
			throw new Exception ("Must have a size of 1 or above");
		}
		double[][] array = new double[size][size];
		for (int i = 0; i < array.length; i++) {
			array[i][i] = 1; //sets all the diagonal elements to 1
			//the rest of the array is zero hence we don't need to set them
		}
		return new SquareMatrix(array);
	}
	
	//checks whether two matrices have exactly the same elements
	public boolean equals(SquareMatrix sm) {
		if (this.m.length != sm.m.length) { //they have to have the same size otherwise it
											//returns false
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
	
	
	//adds two matrices together, statically
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.m.length != sm2.m.length) { //they have to be the same size for the operation to be valid
			throw new Exception ("The matrices must be of the same size!");
		}
		double[][] array = new double[sm1.m.length][sm1.m.length];
		for (int i = 0; i < sm1.m.length; i++) {
			for (int j = 0; j < sm1.m.length; j++) {
				array[i][j] = sm1.m[i][j] + sm2.m[i][j];
			}
		}
		return new SquareMatrix(array);
	}
	
	
	//subtracts two matrices, statically, essentially the same as the add method
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.m.length != sm2.m.length) {
			throw new Exception ("The matrices must be of the same size!");
		}
		double[][] array = new double[sm1.m.length][sm1.m.length];
		for (int i = 0; i < sm1.m.length; i++) {
			for (int j = 0; j < sm1.m.length; j++) {
				array[i][j] = sm1.m[i][j] - sm2.m[i][j];
			}
		}
		return new SquareMatrix(array);
	}
	
	//multiplies two matrices together, statically
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.m.length != sm2.m.length) {
			throw new Exception ("The matrices must be of the same size!");
		}
		double[][] array = new double[sm1.m.length][sm1.m.length];
		for (int i = 0; i < sm1.m.length; i++) {
			for (int j = 0; j < sm1.m.length; j++) {
				for (int k = 0; k < sm1.m.length; k++) {
					array[i][j] += sm1.m[i][k] * sm2.m[k][j]; //follows the formula given
				}
			}
		}
		return new SquareMatrix(array);
	}
	
	//the previous 3 methods are now defined non-statically
	public SquareMatrix add(SquareMatrix sm) throws Exception {
		return add(this,sm);
	}
	public SquareMatrix subtract(SquareMatrix sm) throws Exception {
		return subtract(this,sm);
	}
	public SquareMatrix multiply(SquareMatrix sm) throws Exception {
		return multiply(this,sm);
	}
}
