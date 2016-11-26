package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {

	@FXML
	private AnchorPane paneMain;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnLogout;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
		UserEditController userEditController = new UserEditController();
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
