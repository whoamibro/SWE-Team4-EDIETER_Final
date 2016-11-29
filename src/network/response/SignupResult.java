package network.response;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class SignupResult {
    private String name;    // 이름
    private String email;   // 이메일

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
}
