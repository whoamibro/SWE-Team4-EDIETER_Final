package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ProductEditController implements Initializable {
	@FXML
	private ProductController productController;

	@FXML
	private AnchorPane paneEdit;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnClose;

	@FXML
	private Button btnRemove;

	public AnchorPane getPaneEdit() {
		return paneEdit;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnEdit.setOnAction(event -> btnEditHandler());
		btnClose.setOnAction(event2 -> btnCancelHandler());
		btnRemove.setOnAction(event3 -> btnRemoveHandler());
	}

	public void btnEditHandler() {
		
	}

	public void btnCancelHandler() {
//		productController.setVisibleEditController(false);
//		productController.setVisibleTotalController(true);
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
