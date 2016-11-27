package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProductEditController implements Initializable {
	@FXML
	private ProductController productController;

	@FXML
	private AnchorPane paneEdit;

	@FXML
	private ComboBox<String> cmbBoxType;

	@FXML
	private ComboBox<String> cmbBoxModel;

	@FXML
	private TextField nickNameField;

	@FXML
	private TextField hourField;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnClose;

	@FXML
	private Button btnRemove;

	private boolean editFlag = false;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}


	public void btnEditHandler() {
		if (!editFlag) {
			cmbBoxType.setDisable(false);
			cmbBoxModel.setDisable(false);
			nickNameField.setDisable(false);
			hourField.setDisable(false);
			btnEdit.setText("완료");
			editFlag = true;
		} else {
			cmbBoxType.setDisable(true);
			cmbBoxModel.setDisable(true);
			nickNameField.setDisable(true);
			hourField.setDisable(true);
			btnEdit.setText("편집");
			editFlag = false;
		}
	}

	public void btnCloseHandler() {
		ProductTotalController productTotalController = new ProductTotalController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductTotal.fxml"));
		loader.setController(productTotalController);

		try {
			paneEdit.getChildren().clear();
			paneEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void btnRemoveHandler() {
		productController.getButtonList().remove(0);
		productController.applyList();
		paneEdit.setVisible(false);
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}
}
