package network.response;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class User_f_n {
    private String name;    // ?΄λ¦?
    private String email;   // ?΄λ©μΌ
    private int areaSize;       // κ±°μ£Όκ³΅κ° ?¬?΄μ¦?
    private double usedElec;    // ? ? ₯?¬?©?
    private boolean result;     // λ‘κ·Έ?Έ ?±κ³΅μ¬λΆ?
    private int token;       // λ‘κ·Έ?Έ? ?±κ³΅ν???? session? ?? token

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
