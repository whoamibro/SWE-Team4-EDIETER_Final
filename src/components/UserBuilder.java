package components;

//User Builder class
public class UserBuilder {

	private String name;
	private String ID;
	private String password;
	private String email;
	private int areaSize;
	private double usedElec;
	private int[] chargeHistory;//Electricity charge history.

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setID(String ID) {
		this.ID = ID;
		return this;
	}

	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder setAreaSize(int areaSize) {
		this.areaSize = areaSize;
		return this;
	}

	public UserBuilder setUsedElec(double usedElec) {
		this.usedElec = usedElec;
		return this;
	}
	
	public UserBuilder setChargeHist(int[] chargeHistory) {
		this.chargeHistory = chargeHistory;
		return this;
	}

	public User build() {
		User user = new User(name, ID, password, email, areaSize, usedElec, chargeHistory);
		return user;
	}
}
