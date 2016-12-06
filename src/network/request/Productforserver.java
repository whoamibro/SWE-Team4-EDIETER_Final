package network.request;

public class Productforserver {

	private String formernickName;		// Appliance's nickname
	private String afternickName;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	private int usingTime;			// Using time
	private int pcode;
	private int code;
	
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getNickName() {
		return formernickName;
	}
	public void setNickName(String nickName) {
		this.formernickName = nickName;
	}
	public String getAfternickName() {
		return afternickName;
	}
	public void setAfternickName(String afternickName) {
		this.afternickName = afternickName;
	}
	public int getUsingTime() {
		return usingTime;
	}
	public void setUsingTime(int usingTime) {
		this.usingTime = usingTime;
	}

}
