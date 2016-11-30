package network.response;

/**
 * Created by jeonyongjin on 2016. 11. 30..
 * LOC 57
 */
// object for crawledproduct on web
public class ProductList {
	private int pcode;
    private String pname;
    private String model;
    private double power;
    private double chpower;
    private int grade;

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getName() {
        return pname;
    }

    public void setName(String name) {
        this.pname = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getChpower() {
        return chpower;
    }

    public void setChpower(double chpower) {
        this.chpower = chpower;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
/**
 * 
 */
