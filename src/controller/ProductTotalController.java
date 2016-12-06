package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ProductTotalController implements Initializable {
	@FXML
	private ProductController productController;

	@FXML
	private AnchorPane paneTotal;

	@FXML
	Text text;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}
	
	
}
