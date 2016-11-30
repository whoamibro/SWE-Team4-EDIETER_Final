package controller;

import components.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class RegisterController implements Initializable {

	private User newUser;

	@FXML
	private AnchorPane paneRegister;

	@FXML
	private TextField userName;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}

	public void btnOKHandler() {
		// if password and passwordAgain is same
		if (password.getText() == passwordAgain.getText()) {
			// Create new user instance by entered information

			newUser.setName(userName.getText());
//			newUser.setID(ID.getText());
//			newUser.setPassword(password.getText());
			newUser.setEmail(email.getText());
			newUser.setAreaSize(Integer.parseInt(areaSize.getText()));
			newUser.setUsedElec(Double.parseDouble(usedElec.getText().split(" ")[0]));
		}

		// if here was a message box that will pop up
		// after click this button to notify confirmation to user,
		// that would be better.
		showLoginWindow();

	}

	public User getuser() {
		return newUser;
	}

	public void btnCancelHandler() {
		showLoginWindow();
	}

	public void showLoginWindow() {

		LoginController loginController = new LoginController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(loginController);

		try {
			paneRegister.getChildren().clear();
			paneRegister.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void hyperlinkHandler() {
		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();
		webEngine.load("http://cyber.kepco.co.kr/ckepco/front/jsp/CY/J/H/CYJHPP001.jsp");

		Stage webStage = new Stage();
		Scene scene = new Scene(webView);
		webStage.setWidth(1020);
		webStage.setScene(scene);
		webStage.setTitle("���� ���� ���? �˱�");
		webStage.show();

		webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
			@Override
			public void changed(ObservableValue<? extends Worker.State> arg0, Worker.State arg1, Worker.State arg2) {
				if (arg2 == Worker.State.FAILED) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("���ͳ� ������ Ȯ���ϼ���!");
					alert.showAndWait();
					webStage.close();
				}
			}
		});
	}
}
