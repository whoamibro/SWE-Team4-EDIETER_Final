package network.request;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Signup {
    // ??κ°??? ?? κ°μ²΄
    private String name;    // ?΄λ¦?
    private String email;   // ?΄λ©μΌ
    private String password;// λΉλ?λ²νΈ
    private int areaSize;   // ?¨?κ³μ°? ?? κ±°μ£Όκ³΅κ° ?¬?΄μ¦?
    private double ElecUsage;   // ?΄λ²λ¬ ? ? ₯?¬?©?

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
