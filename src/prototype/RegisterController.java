package prototype;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class RegisterController implements Initializable {
	@FXML
	private Button btnOK;

	@FXML
	private Button btnCancel;

	@FXML
	private AnchorPane paneRegister;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnOK.setOnAction(event -> {
			btnOKHandler();
		});
		btnCancel.setOnAction(event2 -> {
			btnCancelHandler();
		});
	}

	public void btnOKHandler() {
		showLoginWindow();
	}

	public void btnCancelHandler() {
		showLoginWindow();
	}

	public void showLoginWindow() {
		paneRegister.getChildren().clear();

		LoginController loginController = new LoginController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
		loader.setController(loginController);

		try {
			paneRegister.getChildren().add(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
