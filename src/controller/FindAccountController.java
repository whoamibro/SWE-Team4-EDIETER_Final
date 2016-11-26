package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class FindAccountController implements Initializable {
	@FXML
	private AnchorPane paneFind; 
	
	@FXML
	private Button btnCancel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void btnCancelHandler() {
		LoginController loginController = new LoginController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(loginController);

		try {
			paneFind.getChildren().clear();
			paneFind.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
