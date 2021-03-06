package components;
/**
 * Created by jeonilbae on 2016. 11. 30..
 */
public class Product {
	private String type;			// Type of appliance
	private String model;			// Model name of appliance
	private String nickName;		// Appliance's nickname
	private int usingTime;			// Using time
	private double cool_heatpower;	// Power of heating or cooling
	private double power;			// Appliance's watt data
	private int grade;				// Efficient grade

	// Product constructor
	public Product(String type, String model, String nickName, int usingTime, double power, double cool_heatpower,
			int grade) {
		this.type = type;
		this.model = model;
		this.nickName = nickName;
		this.usingTime = usingTime;
		this.power = power;
		this.cool_heatpower = cool_heatpower;
		this.grade = grade;
	}

	// Get methods
	public String getType() {
		return this.type;
	}

	public String getModel() {
		return this.model;
	}

	public String getNickName() {
		return this.nickName;
	}

	public int getUsingTime() {
		return this.usingTime;
	}

	public double getPower() {
		return this.power;
	}

	public double getCool_heatpower() {
		return this.cool_heatpower;
	}

	public int getGrade() {
		return this.grade;
	}

	// Print product information to console
	public String getProductInfo() {
		String productInfo = String.format(
				"type:%s, model:%s, nickName:%s, usingTime:%d, availableTime:%d, power:%f, grade:%d",
				new Object[] { this.type, this.model, this.nickName, Integer.valueOf(this.usingTime),
						Double.valueOf(this.power), Integer.valueOf(this.grade) });
		return productInfo;
	}
}
/**
 * 
 */