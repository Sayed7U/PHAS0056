package lastYearmidterm;

public class DataPoint {
	private int year,month;
	private String dataType,region;
	private double extent,area;

	//defining the constructor
	public DataPoint(int yr,int mo ,String dt, String rgn, double e, double a) {
		this.year = yr;
		this.month = mo; 
		this.dataType = dt;
		this.region = rgn;
		this.extent = e;
		this.area = a;
	}

	//returns x value
	public int getYear() {
		return this.year;
	}
	
	//returns y value
	public int getMonth() {
		return this.month;
	}
	
	//returns the error in y
	public String getDataType() {
		return this.dataType;
	}
	
	public String getRegion() {
		return this.region;
	}
	public double getExtent() {
		return this.extent;
	}
	public double getArea() {
		return this.area;
	}
}
