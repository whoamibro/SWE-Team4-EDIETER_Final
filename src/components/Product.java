package components;

public class Product {
	private String type;
	private String model;
	private String nickName;
	private int usingTime;
	// �߰� �����κ�
	private double cool_heatpower;
	private double power;
	private int grade;

	public Product(String type, String model, String nickName, int usingTime, double power, double cool_heatpower,
			int grade) {
		this.type = type;
		this.model = model;
		this.nickName = nickName;
		this.usingTime = usingTime;
		this.power = power;
		// �߰� �����κ�
		this.cool_heatpower = cool_heatpower;
		this.grade = grade;
	}

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

	public String getProductInfo() {
		String productInfo = String.format(
				"type:%s, model:%s, nickName:%s, usingTime:%d, availableTime:%d, power:%f, grade:%d",
				new Object[] { this.type, this.model, this.nickName, Integer.valueOf(this.usingTime),
						Double.valueOf(this.power), Integer.valueOf(this.grade) });
		return productInfo;
	}
}