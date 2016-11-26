package components;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

//User Class
public class User {
	
	private String name;
	private String ID;
	private String password;
	private String email;
	private int areaSize;
	private double usedElec;
//	private double[] usedHistory; //지난전력사용량 배열. 추후작업
	
	public User()
	{
		name = "0";
		ID = "0";
		password = "0";
		email = "0";
		areaSize = 0;
		usedElec = 0.0;
				
	}
	
	public User(String name, String ID, String password, String email, int areaSize, double usedElec)
	{
		this.name = name;
		this.ID = ID;
		this.password = password;
		this.email = email;
		this.areaSize = areaSize;
		this.usedElec = usedElec;
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
	
}
