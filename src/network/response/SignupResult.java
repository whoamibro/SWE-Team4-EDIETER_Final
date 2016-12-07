package network.response;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 * LOC 29
 */
public class SignupResult {
    private String name;    // name
    private String email;   // mail
    private boolean result;
    
    public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

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
/**
 * 
 */
