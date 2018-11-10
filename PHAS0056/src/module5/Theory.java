package module5;

//this class would be used to compare the datapoints to a model
public class Theory {

	private int n;

	//defining the constructor
	public Theory(int n1) {
		this.n = n1;
	}

	//returns y^n,  the model we would compare the datapoints to
	public double y(double x) {
		return Math.pow(x, this.n);
	}

}
