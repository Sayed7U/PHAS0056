package module5;

//defining a datapoint as having an x, y and error value. This class simply recalls these values
public class DataPoint {
	private double x,y,ey;

	//defining the constructor
	public DataPoint(double x1,double y1 ,double ey1) {
		this.x = x1;
		this.y = y1;
		this.ey = ey1;
	}

	//returns x value
	public double getX() {
		return this.x;
	}
	
	//returns y value
	public double getY() {
		return this.y;
	}
	
	//returns the error in y
	public double getEY() {
		return this.ey;
	}
}
