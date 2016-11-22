package components;

//User Builder class
public class UserBuilder {
	
	private String name;
	private String email;
	private String password;
	private int areaSize;
	private double usedElec;
	
	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public UserBuilder setPassword(String password) {
		this.password = password;
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
	
	public User build() {
		User user = new User(name, email, password, areaSize, usedElec);
		return user;
	}
}
