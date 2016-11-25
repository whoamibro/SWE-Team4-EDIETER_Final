package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class RegisterController implements Initializable {
	@FXML
	private Button btnOK;

	@FXML
	private Button btnCancel;

	@FXML
	private AnchorPane paneRegister;

	private Stage webStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();
		webEngine.load("http://cyber.kepco.co.kr/ckepco/front/jsp/CY/J/H/CYJHPP001.jsp");

		webStage = new Stage();
		Scene scene = new Scene(webView);
		webStage.setWidth(1020);
		webStage.setScene(scene);
		webStage.setTitle("현재 전력 사용량 알기");
		
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(loginController);

		try {
			paneRegister.getChildren().add(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void hyperlinkHandler() {
		webStage.show();
	}
}
