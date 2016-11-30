package network.request;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Signup {
    // ?šŒ?›ê°??…?„ ?œ„?•œ ê°ì²´
    private String name;    // ?´ë¦?
    private String email;   // ?´ë©”ì¼
    private String password;// ë¹„ë?ë²ˆí˜¸
    private int areaSize;   // ?˜¨?„ê³„ì‚°?„ ?œ„?•œ ê±°ì£¼ê³µê°„ ?‚¬?´ì¦?
    private double ElecUsage;   // ?´ë²ˆë‹¬ ? „? ¥?‚¬?š©?Ÿ‰

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
