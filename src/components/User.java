package components;
/**
 * Created by ParkKyeungHye on 2016. 11. 30.
 */
//User Class
public class User {
	
	private String name;//user name
	private String email;//user email
	private int areaSize;//user area size
	private double usedElec;//used Electricity of this month(in the month)
	private double[] chargeHistory; //Electricity charge history.
	
	//get Area
	
	public String getName() {
		return name;
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

	//get charge history
	public double[] getChargeHist() {
		return chargeHistory;
	}
	//set Area
	
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAreaSize(int areaSize) {
		this.areaSize = areaSize;
	}

	public void setUsedElec(double usedElec) {
		this.usedElec = usedElec;
	}

	public void setChargeHistory(double[] chargeHistory) {
		this.chargeHistory = chargeHistory;
	}
}
/**
 */
