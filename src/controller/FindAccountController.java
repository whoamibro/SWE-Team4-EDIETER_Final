package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class FindAccountController implements Initializable {
	@FXML
	private AnchorPane paneFind; 
	
	@FXML
	private Button btnFindPW;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void btnFindPWHandler() {
		// DB에서 이메일 주소를 찾아서 있을 경우 메일 확인 알림
		Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
		successAlert.setHeaderText(null);
		successAlert.setContentText("메일을 확인해주세요!");
		successAlert.showAndWait();
		
		// 찾지 못할 경우 등록된 이메일 없다고 알림
		Alert failAlert = new Alert(Alert.AlertType.ERROR);
		failAlert.setHeaderText(null);
		failAlert.setContentText("등록된 이메일 주소가 없습니다.");
		failAlert.showAndWait();
	}
}
