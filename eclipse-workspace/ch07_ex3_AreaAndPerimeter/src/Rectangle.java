import java.text.NumberFormat;

public class Rectangle {
	private double length;
	private double width;
	
	public Rectangle() {
		length = 0;
		width = 0;
	}	
	
	public Rectangle(double length, double width) {  //where did this come from
        this.length = length;
        this.width = width;
	}
	
	public double getLegth() {
		return length;
	}
	
	public void setLegth(double legth) {
		this.length = legth;
	}

	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea() {
		double area = width * length;
		return area;
	}
	
	public String getAreaNumberFormat() {
	    NumberFormat number = NumberFormat.getNumberInstance();
	    number.setMinimumFractionDigits(3);
	    String numberFormatted = number.format(this.getArea());
	    return numberFormatted;        
	    }
	
	public double getPerimeter() {
        double perimeter = 2 * width + 2 * length;
        return perimeter;
    }
    
    public String getPerimeterNumberFormat() {
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMinimumFractionDigits(3);
        String numberFormatted = number.format(this.getPerimeter());
        return numberFormatted;        
    }
	
	/*public NumberFormat setArea() {
		NumberFormat area = NumberFormat.getNumberInstance();
		area.setMaximumFractionDigits(3);
		return area;		
	}
	public NumberFormat setPerimeter() {
		NumberFormat perimeter = NumberFormat.getNumberInstance();
		perimeter.setMaximumFractionDigits(3);
		return perimeter;
	}	*/
}