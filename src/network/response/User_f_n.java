package network.response;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class User_f_n {
    private String name;    // ?´ë¦?
    private String email;   // ?´ë©”ì¼
    private int areaSize;       // ê±°ì£¼ê³µê°„ ?‚¬?´ì¦?
    private double usedElec;    // ? „? ¥?‚¬?š©?Ÿ‰
    private boolean result;     // ë¡œê·¸?¸ ?„±ê³µì—¬ë¶?
    private int token;       // ë¡œê·¸?¸?— ?„±ê³µí•˜???„?•Œ session?„ ?œ„?•œ token

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
