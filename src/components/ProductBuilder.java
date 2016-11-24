package components;

public class ProductBuilder {
    private String type;
    private String model;
    private String nickName;
    private int usingTime;
    private double power;
    // 냉방전력, 난방전력
    private double cool_heatpower;
    private int grade;

    public ProductBuilder setType(String type) {
        this.type = type;
        return this;
    }

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

    public Product build() {
        Product product = new Product(type, model, nickName,
                usingTime, power, cool_heatpower, grade);
        return product;
    }
}