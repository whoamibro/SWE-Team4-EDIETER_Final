package components;
/**
 * Created by jeonilbae on 2016. 11. 30..
 */
public class ProductBuilder {
	private String type;			// Type of appliance
	private String model;			// Model name of appliance
	private String nickName;		// Appliance's nickname
	private int usingTime;			// Using time
	private double cool_heatpower;	// Power of heating or cooling
	private double power;			// Appliance's watt data
	private int grade;				// Efficient grade

	// ProductBuilder constructor
	public ProductBuilder setType(String type) {
		this.type = type;
		return this;
	}
	
	// Set methods
	public ProductBuilder setModel(String model) {
		this.model = model;
		return this;
	}

	public ProductBuilder setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	public ProductBuilder setUsingTime(int usingTime) {
		this.usingTime = usingTime;
		return this;
	}

	public ProductBuilder setPower(double power) {
		this.power = power;
		return this;
	}

	public ProductBuilder setGrade(int grade) {
		this.grade = grade;
		return this;
	}

	public ProductBuilder setCool_heatpower(double cool_heatpower) {
		this.cool_heatpower = cool_heatpower;
		return this;
	}

	// Build product
	public Product build() {
		Product product = new Product(type, model, nickName, usingTime, power, cool_heatpower, grade);
		return product;
	}
}

/**
 * 
 */