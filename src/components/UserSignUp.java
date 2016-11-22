package components;
import java.util.ArrayList;
import java.util.Scanner;

//사용자 회원가입
public class UserSignUp {
	
	private String name;
	private String email;
	private String password;
	private int areaSize;
	private double usedElec;
	
	
	//회원 가입 정보 입력 받음
	public void UserNameInput(){
       Scanner scan = new Scanner(System.in);
       name = scan.nextLine();
	}
	
	public void UserEmailInput(){
	   Scanner scan = new Scanner(System.in);
	   email = scan.nextLine();
	}
	
	public void UserPasswordInput(){
	   Scanner scan = new Scanner(System.in);
	   password = scan.nextLine();
	}
	
	public void UserAreaSizeInput(){
	   Scanner scan = new Scanner(System.in);
	   areaSize = scan.nextInt();
	}
	
	public void UserUsedElecInput(){
	   Scanner scan = new Scanner(System.in);
	   usedElec = scan.nextDouble();
	}	
	
	//user1이 회원가입 버튼 눌렀을때 고객 객체 빌더패턴으로 생성
	public void addUser() {
		UserBuilder userBuilder = new UserBuilder();
		User user = userBuilder
				.setName(name)
				.setEmail(email)
				.setPassword(password)
				.setAreaSize(areaSize)
				.setUsedElec(usedElec)
				.build();
	}
}
