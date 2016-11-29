package network.request;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Login {
    //     로그인을 위한 객체
//   private String id;      // id
    private String email;   // 이메일
    private String password;// 비밀번호

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
}
