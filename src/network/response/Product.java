package network.response;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Product {
    private String type;    // κ°?? ? ? ???
    private String model;   // κ°?? ? ? λͺ¨λΈλͺ?
    private String nickName;
    private int usingTime;  // ?Ό?Ή ?¬?© ?κ°?
    private int availableTime;
    private double power;   // ?λΉμ ? ₯
    private int grade;      // ? ? ₯?±κΈ?

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUsingTime() {
        return usingTime;
    }

    public void setUsingTime(int usingTime) {
        this.usingTime = usingTime;
    }

    public int getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(int availableTime) {
        this.availableTime = availableTime;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
