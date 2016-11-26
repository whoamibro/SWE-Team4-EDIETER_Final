package components;

import java.util.Scanner;

//사용자 정보 수정
public class UserEdit {

	private User user;

	private String name;
	private String email;
	private String password;
	private int areaSize;
	private double usedElec;

	// 현재 고객 정보 가져와서 첫 화면으로 세팅. 지금 들어가있는 값들은 추후 디비에서 가지고 오는 방식으로 수정
	public UserEdit() {
		name = "김고객";
		email = "user1@gamil.com";
		password = "1234";
		areaSize = 30;
		usedElec = 100;
	}

	// 새로운 정보 입력 받음
	public void UserNameInput() {
		Scanner scan = new Scanner(System.in);
		name = scan.nextLine();
	}

	public void UserEmailInput() {
		Scanner scan = new Scanner(System.in);
		email = scan.nextLine();
	}

	public void UserPasswordInput() {
		Scanner scan = new Scanner(System.in);
		password = scan.nextLine();
	}

	public void UserAreaSizeInput() {
		Scanner scan = new Scanner(System.in);
		areaSize = scan.nextInt();
	}

	public void UserUsedElecInput() {
		Scanner scan = new Scanner(System.in);
		usedElec = scan.nextDouble();
	}

	// user1이 정보수정 버튼 눌렀을때 고객 객체 정보 빌더패턴으로 수정
	public void updateUser() {
		UserBuilder userBuilder = new UserBuilder();
		user = userBuilder.setName(name).setEmail(email).setPassword(password).setAreaSize(areaSize)
				.setUsedElec(usedElec).build();
	}
}
