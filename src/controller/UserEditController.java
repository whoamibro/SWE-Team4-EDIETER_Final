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
	private TextField email;

	@FXML
	private PasswordField oldPassword;

	@FXML
	private PasswordField password;
	
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

	//get current user instance
	public UserEditController(User user) {
		thisUser = user;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
<<<<<<< HEAD
		/**
		 * Create by jeonyongjin on 2016. 11. 30 ..
		 */
=======
		//set each text as this user's information
>>>>>>> refs/heads/KH
		userName.setText(thisUser.getName());
		email.setText(thisUser.getEmail());
		areaSize.setText(String.valueOf(thisUser.getAreaSize()));
		usedElec.setText(String.valueOf(thisUser.getUsedElec()));
		/**
		 * 
		 */
	}

	public void btnOKHandler() {

		//set new information that this user entered to this user's each information item
		thisUser.setAreaSize(Integer.parseInt(areaSize.getText()));
		thisUser.setUsedElec(Double.parseDouble(usedElec.getText().split(" ")[0]));

		//set loader of Main.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(mainController);

		//clear and load Main.fxml
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
