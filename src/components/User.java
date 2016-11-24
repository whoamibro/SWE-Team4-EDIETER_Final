package components;

//User Class
public class User {

	//pushtest
	private String name;
	private String email;
	private String password;
	private int areaSize;
	private double usedElec;
//	private double[] usedHistory; //지난전력사용량 배열. 추후작업
	
	public User()
	{
		
	}
	
	public User(String name, String email, String password, int areaSize, double usedElec)
	{
		this.name = name;
		this.email = email;
		this.password = password;
		this.areaSize = areaSize;
		this.usedElec = usedElec;
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public int getAreaSize() {
		return areaSize;
	}
	
	public double getUsedElec() {
		return usedElec;
	}
	
}
