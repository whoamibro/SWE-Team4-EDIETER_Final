package prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class UserEditController implements Initializable {
	@FXML
	private AnchorPane paneUserEdit;

	@FXML
	private Button btnOK;

	@FXML
	private Button btnCancel;

	private MainController mainController;

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void btnOKHandler() {
		paneUserEdit.getChildren().clear();

		LoginController loginController = new LoginController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
		loader.setController(loginController);

		try {
			paneUserEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void btnCancelHandler() {
		paneUserEdit.getChildren().clear();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		loader.setController(mainController);

		try {
			paneUserEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
