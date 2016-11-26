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

public class UserEditController implements Initializable {
	
	User thisuser;
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
	
	public UserEditController(){}
	
	//get current user instance
	public UserEditController(User user){
		thisuser = user;
	}
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	


	public void btnOKHandler() {
		paneUserEdit.getChildren().clear();
		
		UserBuilder userBuilder = new UserBuilder();
		thisuser = userBuilder
				.setPassword(password.getText())
				.setEmail(email.getText())
				.setAreaSize(Integer.parseInt(areaSize.getText()))
				.setUsedElec(Double.parseDouble(usedElec.getText().split(" ")[0]))
				.build();

		//if here was a message box that will pop up 
		//after click this button to notify confirmation to user,
		//that would be better.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(mainController);

		try {
			paneUserEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void btnCancelHandler() {
		paneUserEdit.getChildren().clear();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(mainController);

		try {
			paneUserEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
