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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MainController implements Initializable {

	User thisUser;
	@FXML
	private AnchorPane paneMain;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnLogout;
	
	@FXML
	private Text greetText;
	
	public MainController(){}
	
	public MainController(User user){
		thisUser = user;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		greetText.setText("환영합니다 " + thisUser.getName() + "님");
	}

	public void btnLogoutHandler() {
		LoginController loginController = new LoginController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(loginController);

		try {
			paneMain.getChildren().clear();
			paneMain.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setVisible(boolean bool) {
		paneMain.setVisible(bool);
	}

	public void btnEditHandler() {
		UserEditController userEditController = new UserEditController(thisUser);
		userEditController.setMainController(this);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserEdit.fxml"));
		loader.setController(userEditController);

		try {
			paneMain.getChildren().clear();
			paneMain.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
