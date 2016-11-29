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
		siteList.add("���� �Է�");

		cmbBoxSite.getSelectionModel().selectedItemProperty().addListener(event -> cmbBoxSiteListener());
	}

	public void cmbBoxSiteListener() {
		TextField inputField;
		// ���� �Է� �ؽ�Ʈ �ʵ� ���� Ȯ��
		boolean existFlag = true;
		try {
			inputPane.getChildren().get(1);
		} catch (IndexOutOfBoundsException e) {
			existFlag = false;
		}

		if (cmbBoxSite.getSelectionModel().getSelectedItem() == "���� �Է�") {
			inputField = new TextField();
			inputField.setPrefWidth(130);
			inputPane.getChildren().add(0, inputField);
		} else {
			// ���� �Է� �ؽ�Ʈ �ʵ尡 �����ϸ�
			if(existFlag) {
				inputPane.getChildren().remove(0);
			}
		}
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
