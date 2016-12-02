package network.request;

public class Productforserver {

	private String nickName;		// Appliance's nickname
	private int usingTime;			// Using time
	private int pcode;
	
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getUsingTime() {
		return usingTime;
	}
	public void setUsingTime(int usingTime) {
		this.usingTime = usingTime;
	}

}
