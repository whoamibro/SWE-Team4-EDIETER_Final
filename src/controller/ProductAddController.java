package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ProductAddController implements Initializable {
	private ProductController productController;

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}

	@FXML
	private AnchorPane paneAdd;

	@FXML
	private ComboBox<String> cmbBoxProduct;

	@FXML
	private ComboBox<String> cmbBoxModel;

	@FXML
	private TextField textFieldName;

	@FXML
	private Text textPower;

	@FXML
	private Text textGrade;

	@FXML
	private TextField textFieldHour;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnCancel;

	public void refreshContents() {
		cmbBoxProduct.setValue("");
		cmbBoxModel.setValue("");

	}

	public AnchorPane getPaneAdd() {
		return paneAdd;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnAdd.setOnAction(event -> btnAddHandler());
		btnCancel.setOnAction(event2 -> btnCancelHandler());

		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("a");
		list.add("b");
		cmbBoxProduct.setItems(list);
	}

	public void btnAddHandler() {

		Button newButton = new Button("test");
		newButton.setPrefSize(210, 100);
		newButton.setOnAction(event -> {
			
		});

		paneAdd.getChildren().clear();

		ProductTotalController productTotalController = new ProductTotalController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductTotal.fxml"));
		loader.setController(productTotalController);

		try {
			paneAdd.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		productController.getButtonList().add(new Button("test"));
		productController.applyList();

	}

	public void btnCancelHandler() {
		paneAdd.getChildren().clear();

		ProductTotalController productTotalController = new ProductTotalController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductTotal.fxml"));
		loader.setController(productTotalController);

		try {
			paneAdd.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void displayAddProduct() {
		paneAdd.setVisible(true);

	}
}
