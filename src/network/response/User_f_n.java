package network.response;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class User_f_n {
    private String name;    // 이름
    private String email;   // 이메일
    private int areaSize;       // 거주공간 사이즈
    private double usedElec;    // 전력사용량
    private boolean result;     // 로그인 성공여부
    private String token;       // 로그인에 성공하였을때 session을 위한 token

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

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        this.areaSize = areaSize;
    }

    public double getUsedElec() {
        return usedElec;
    }

    public void setUsedElec(double usedElec) {
        this.usedElec = usedElec;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
