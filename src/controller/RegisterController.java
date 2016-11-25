package controller;

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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(loginController);

		try {
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
		webStage.setTitle("현재 전력 사용량 알기");
		webStage.show();

		webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
			@Override
			public void changed(ObservableValue<? extends Worker.State> arg0, Worker.State arg1, Worker.State arg2) {
				if (arg2 == Worker.State.FAILED) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText("웹페이지 로드 오류");
					alert.setContentText("인터넷 연결을 확인하세요!");
					alert.showAndWait();
					webStage.close();
				}
			}
		});
	}
}
