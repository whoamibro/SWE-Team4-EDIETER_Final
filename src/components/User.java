package components;

//User Class
public class User {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getID() {
//		return ID;
//	}
//
//	public void setID(String ID) {
//		this.ID = ID;
//	}

//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAreaSize() {
		return areaSize;
	}

	public void setAreaSize(int areaSize) {
		this.areaSize = areaSize;
	}

	public double getUsedElec() {
		return usedElec;
	}

	public void setUsedElec(double usedElec) {
		this.usedElec = usedElec;
	}

	private String name;
//	private String ID;
//	private String password;
	private String email;
	private int areaSize;
	private double usedElec;
	private double[] chargeHistory = new double[6]; //Electricity charge history.



	public double[] getChargeHistory() {
		return chargeHistory;
	}

	public void setChargeHistory(double[] chargeHistory) {
		this.chargeHistory = chargeHistory;
	}
	//	public User() {
//
//		name = "0";
//		ID = "0";
//		password = "0";
//		email = "0";
//		areaSize = 0;
//		usedElec = 0.0;
//		chargeHistory = new int[13];
//
//		for(int i = 1; i <13; i++){
//			chargeHistory[i] = 0;
//		}
//	}
//
//	public User(String name, String ID, String password, String email, int areaSize, double usedElec, int[] chargeHistory) {
//		this.name = name;
//		this.ID = ID;
//		this.password = password;
//		this.email = email;
//		this.areaSize = areaSize;
//		this.usedElec = usedElec;
//		this.chargeHistory = chargeHistory;
//	}



}
