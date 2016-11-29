package network.request;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Signup {
    // 회원가입을 위한 객체
    private String name;    // 이름
    private String email;   // 이메일
    private String password;// 비밀번호
    private int areaSize;   // 온도계산을 위한 거주공간 사이즈
    private double ElecUsage;   // 이번달 전력사용량

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
