package network.request;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Signup {
    // ?��?���??��?�� ?��?�� 객체
    private String name;    // ?���?
    private String email;   // ?��메일
    private String password;// 비�?번호
    private int areaSize;   // ?��?��계산?�� ?��?�� 거주공간 ?��?���?
    private double ElecUsage;   // ?��번달 ?��?��?��?��?��

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        this.areaSize = areaSize;
    }

    public double getElecUsage() {
        return ElecUsage;
    }

    public void setElecUsage(double ElecUsage) {
        this.ElecUsage = ElecUsage;
    }
}
