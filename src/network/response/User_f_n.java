package network.response;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class User_f_n {
    private String name;    // ?���?
    private String email;   // ?��메일
    private int areaSize;       // 거주공간 ?��?���?
    private double usedElec;    // ?��?��?��?��?��
    private boolean result;     // 로그?�� ?��공여�?
    private int token;       // 로그?��?�� ?��공하???��?�� session?�� ?��?�� token

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

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }
}
