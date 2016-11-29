package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import components.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MainController implements Initializable {
	private User thisUser;

	@FXML
	private AnchorPane paneMain;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnLogout;

	@FXML
	private Text greetText;

	@FXML
	private AnchorPane userPane;

	public MainController() {
	}

	public void setUser(User user) {
		this.thisUser = user;
	}

	private UserController userController;

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/User.fxml"));
		loader.setController(userController);
		try {
			userPane.getChildren().add(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		greetText.setText("�솚�쁺�빀�땲�떎 " + thisUser.getName() + "�떂");
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
