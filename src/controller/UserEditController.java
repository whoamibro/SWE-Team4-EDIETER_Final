package controller;

import components.User;

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

public class UserEditController implements Initializable {

	User thisUser;
	@FXML
	private AnchorPane paneUserEdit;

	@FXML
	private TextField userName;

	@FXML
	private TextField ID;

	@FXML
	private PasswordField password;

	@FXML
	private PasswordField passwordAgain;

	@FXML
	private TextField email;

	@FXML
	private TextField areaSize;

	@FXML
	private TextField usedElec;

	@FXML
	private Button btnOK;

	@FXML
	private Button btnCancel;

	private MainController mainController;

	public UserEditController() {
	}

	// get current user instance
	public UserEditController(User user) {
		thisUser = user;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		userName.setText(thisUser.getName());
//		ID.setText(thisUser.getID());
		email.setText(thisUser.getEmail());
		areaSize.setText(String.valueOf(thisUser.getAreaSize()));
		usedElec.setText(String.valueOf(thisUser.getUsedElec()));
	}

	public void btnOKHandler() {

//		thisUser.setPassword(password.getText());
		thisUser.setEmail(email.getText());
		thisUser.setUsedElec(Double.parseDouble(usedElec.getText().split(" ")[0]));
		// if here was a message box that will pop up
		// after click this button to notify confirmation to user,
		// that would be better.

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(mainController);

		try {
			paneUserEdit.getChildren().clear();
			paneUserEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void btnCancelHandler() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(mainController);

		try {
			paneUserEdit.getChildren().clear();
			paneUserEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
