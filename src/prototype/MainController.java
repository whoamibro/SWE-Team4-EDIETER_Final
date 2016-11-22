package prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
	public AnchorPane getPaneMain() {
		return paneMain;
	}

	@FXML
	private AnchorPane paneMain;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnLogout;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogout.setOnAction(event -> {
			btnLogoutHandler();
		});

		btnEdit.setOnAction(event2 -> {
			btnEditHandler();
		});
	}

	public void btnLogoutHandler() {
		paneMain.getChildren().clear();

		LoginController loginController = new LoginController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
		loader.setController(loginController);

		try {
			paneMain.getChildren().add(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setVisible(boolean bool) {
		paneMain.setVisible(bool);
	}

	public void btnEditHandler() {
		paneMain.getChildren().clear();

		UserEditController userEditController = new UserEditController();
		userEditController.setMainController(this);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserEdit.fxml"));
		loader.setController(userEditController);
		
		try {
			paneMain.getChildren().add(loader.load());
		} catch( IOException e){
			e.printStackTrace();
		}
	}

}
