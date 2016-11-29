package components;

//User Class
public class User {

	private String name;
	private String ID;
	private String password;
	private String email;
	private int areaSize;
	private double usedElec;
	private int[] chargeHistory; //Electricity charge history.

	public User() {

		name = "0";
		ID = "0";
		password = "0";
		email = "0";
		areaSize = 0;
		usedElec = 0.0;	
		chargeHistory = new int[13];
		
		for(int i = 1; i <13; i++){
			chargeHistory[i] = 0;
		}
	}

	public User(String name, String ID, String password, String email, int areaSize, double usedElec, int[] chargeHistory) {
		this.name = name;
		this.ID = ID;
		this.password = password;
		this.email = email;
		this.areaSize = areaSize;
		this.usedElec = usedElec;
		this.chargeHistory = chargeHistory; 
	}

	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public int getAreaSize() {
		return areaSize;
	}

	public double getUsedElec() {
		return usedElec;
	}
	
	public int[] getChargeHist() {
		return chargeHistory;
	}

}
