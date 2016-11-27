package controller;

import components.User;
import components.UserBuilder;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {

	User thisUser;
	@FXML
	private AnchorPane paneLogin;

	@FXML
	private TextField ID;

	@FXML
	private PasswordField password;

	@FXML
	private Button btnLogin;

	@FXML
	private Button btnRegister;
	
	@FXML
	private Button btnFind;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void btnLoginHandler() {
		
		//Create user instance who logged in by entered information
		UserBuilder userbuilder = new UserBuilder();
		thisUser = userbuilder.setName("김고객").setID("user1").setPassword("1")
						.setEmail("user1@gmail.com").setAreaSize(10)
						.setUsedElec(100.0).build();
		MainController mainController = new MainController(thisUser);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(mainController);

		try {
			paneLogin.getChildren().clear();
			paneLogin.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void btnRegisterHandler() {
		RegisterController registerController = new RegisterController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Register.fxml"));
		loader.setController(registerController);
		
		try {
			paneLogin.getChildren().clear();
			paneLogin.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void btnFindHandler() {
		FindAccountController findAccountController = new FindAccountController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FindAccount.fxml"));
		loader.setController(findAccountController);
		
		try {
			paneLogin.getChildren().clear();
			paneLogin.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
