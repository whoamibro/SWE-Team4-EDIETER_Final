package network.response;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 * LOC 30
 */
// object for productlist belongs to user
public class Product_n {
    private int pcode;
    private int usingtime;
    private String nickname;

    public int getUsingtime() {
        return usingtime;
    }

    public void setUsingtime(int usingtime) {
        this.usingtime = usingtime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }
}
/**
 * 
 */
