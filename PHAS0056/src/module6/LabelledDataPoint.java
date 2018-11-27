package module6;

//handles datapoints with any labels
public class LabelledDataPoint extends DataPoint {
	private String label;

	//defining the constructor
	public LabelledDataPoint(double x1,double y1,double ey1,String labell) {
		super(x1,y1,ey1); //calls upon datapoint
		this.label = labell; //the label of the datapoint
	}
	
	//String in a print statement
	public String toString() {
		return this.label +": " + "x = " + super.getX() + ", y = " + super.getY() + " +- " + super.getEY();
	}
}
