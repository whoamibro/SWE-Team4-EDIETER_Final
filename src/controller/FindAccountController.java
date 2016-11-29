package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class FindAccountController implements Initializable {
	@FXML
	private AnchorPane paneFind;

	@FXML
	private FlowPane inputPane;

	@FXML
	private TextField emailField;

	@FXML
	private ComboBox<String> cmbBoxSite;

	@FXML
	private Button btnFindPW;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> siteList = cmbBoxSite.getItems();
		siteList.add("naver.com");
		siteList.add("gmail.com");
		siteList.add("daum.net");
		siteList.add("직접 입력");

		cmbBoxSite.getSelectionModel().selectedItemProperty().addListener(event -> cmbBoxSiteListener());
	}

	public void cmbBoxSiteListener() {
		TextField inputField;
		// 직접 입력 텍스트 필드 유무 확인
		boolean existFlag = true;
		try {
			inputPane.getChildren().get(1);
		} catch (IndexOutOfBoundsException e) {
			existFlag = false;
		}

		if (cmbBoxSite.getSelectionModel().getSelectedItem() == "직접 입력") {
			inputField = new TextField();
			inputField.setPrefWidth(130);
			inputPane.getChildren().add(0, inputField);
		} else {
			// 직접 입력 텍스트 필드가 존재하면
			if(existFlag) {
				inputPane.getChildren().remove(0);
			}
		}
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
