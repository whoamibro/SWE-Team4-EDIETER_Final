package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import components.Product;
import components.ProductBuilder;
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
	private Product newProduct;
	private String type;
	private String model;
	public void setProductController(ProductController productController) {
		this.productController = productController;
	}
	public Product getProduct() {
		return newProduct;
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

		ObservableList<String> list = cmbBoxProduct.getItems();
		//ObservableList<String> list = FXCollections.observableArrayList();
		list.add("a");
		list.add("b");
		//cmbBoxProduct.setItems(list);
		cmbBoxProduct.getSelectionModel().selectedItemProperty().addListener(event ->{
	         type = cmbBoxProduct.getSelectionModel().getSelectedItem().toString();
	      });
		cmbBoxModel.getSelectionModel().selectedItemProperty().addListener(event ->{
	         model = cmbBoxModel.getSelectionModel().getSelectedItem().toString();
	      });
	}

	public void btnAddHandler() {


		paneAdd.getChildren().clear();

		ProductTotalController productTotalController = new ProductTotalController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductTotal.fxml"));
		loader.setController(productTotalController);

		try {
			paneAdd.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ProductBuilder productBuilder = new ProductBuilder();
		newProduct = productBuilder
				.setType(type)
				.setModel(model)
				.setPower(Double.parseDouble(textPower.getText().split(" ")[0]))
				.setGrade(Integer.parseInt(textGrade.getText().split(" ")[0]))
				.setUsingTime(Integer.parseInt(textFieldHour.getText()))
				.setNickName(textFieldName.getText())
				.build();

		Button newButton = new Button("fuck");
		newButton.setPrefSize(210, 100);
		newButton.setOnAction(event -> {
			ProductEditController productEditController = new ProductEditController();
			productEditController.setProduct(newProduct);
			FXMLLoader editLoader = new FXMLLoader(getClass().getResource("/fxml/ProductEdit.fxml"));
			editLoader.setController(productEditController);
			
			try {
				productController.getPaneTotal().getChildren().clear();
				productController.getPaneTotal().getChildren().add(editLoader.load());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		});
		productController.getButtonList().add(newButton);
		productController.applyList();
	}

	public void btnCancelHandler() {
		paneAdd.getChildren().clear();

		ProductTotalController productTotalController = new ProductTotalController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductTotal.fxml"));
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
