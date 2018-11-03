package module5;


public class DataPoint {
	private double x,y,ey;

	public DataPoint(double x1,double y1 ,double ey1) {
		this.x = x1;
		this.y = y1;
		this.ey = ey1;
	
	}

	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getEY() {
		return this.ey;
	}
}
