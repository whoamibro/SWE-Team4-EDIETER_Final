package network.request;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 * LOC 58
 */
public class Signup {
    // object for signup
    private String name;  
    private String email; 
    private String password;
    private String newpassword;
    public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	private int areaSize;   
    private double ElecUsage;  

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
/**
 * 
 */
