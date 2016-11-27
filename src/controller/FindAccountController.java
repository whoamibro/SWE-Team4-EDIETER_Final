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
		// DB���� �̸��� �ּҸ� ã�Ƽ� ���� ��� ���� Ȯ�� �˸�
		Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
		successAlert.setHeaderText(null);
		successAlert.setContentText("������ Ȯ�����ּ���!");
		successAlert.showAndWait();
		
		// ã�� ���� ��� ��ϵ� �̸��� ���ٰ� �˸�
		Alert failAlert = new Alert(Alert.AlertType.ERROR);
		failAlert.setHeaderText(null);
		failAlert.setContentText("��ϵ� �̸��� �ּҰ� �����ϴ�.");
		failAlert.showAndWait();
	}
}
