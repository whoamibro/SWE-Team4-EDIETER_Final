package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {

	@FXML
	private AnchorPane paneLogin;

	@FXML
	private TextField userName;

	@FXML
	private TextField password;

	@FXML
	private Button btnLogin;

	@FXML
	private Button btnRegister;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void btnLoginHandler() {
		MainController mainController = new MainController();
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
		paneLogin.getChildren().clear();
		RegisterController registerController = new RegisterController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Register.fxml"));
		loader.setController(registerController);
		try {
			paneLogin.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
