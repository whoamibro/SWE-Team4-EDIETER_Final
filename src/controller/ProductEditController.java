package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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

public class ProductEditController implements Initializable {
	@FXML
	private ProductController productController;
	private Product editProduct;
	private int productIndex;
	
	private String type;
	private String model;
	@FXML
	private AnchorPane paneEdit;

	@FXML
	private ComboBox<String> cmbBoxType;

	@FXML
	private ComboBox<String> cmbBoxModel;

	@FXML
	private Text textPower;

	@FXML
	private Text textGrade;

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

	public void setProduct(Product editProduct) {
		this.editProduct = editProduct;
	}
	
	public void setProductIndex(int productIndex) {
		this.productIndex = productIndex;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<String> listType = cmbBoxType.getItems();
		listType.add("a");
		listType.add("b");

		ObservableList<String> listModel = cmbBoxModel.getItems();
		listModel.add("c");
		listModel.add("d");

		cmbBoxType.getSelectionModel().selectedItemProperty().addListener(event -> {
			type = cmbBoxType.getSelectionModel().getSelectedItem().toString();
		});

		cmbBoxModel.getSelectionModel().selectedItemProperty().addListener(event -> {
			model = cmbBoxModel.getSelectionModel().getSelectedItem().toString();
		});
		
		
		cmbBoxType.setPromptText(editProduct.getType());
		cmbBoxModel.setPromptText(editProduct.getModel());
		textPower.setText(String.valueOf(editProduct.getPower()) + " kW");
		textGrade.setText(String.valueOf(editProduct.getGrade()));
		nickNameField.setText(editProduct.getNickName());
		hourField.setText(String.valueOf(editProduct.getUsingTime()));
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
			ProductBuilder productBuilder = new ProductBuilder();
			
			editProduct = productBuilder
					.setType(type)
					.setModel(model)
					.setPower(Double.parseDouble(textPower.getText().split(" ")[0]))
					.setGrade(Integer.parseInt(textGrade.getText()))
					.setUsingTime(Integer.parseInt(hourField.getText()))
					.setNickName(nickNameField.getText())
					.build();
			
			productController.removeProductInList(editProduct);
			productController.addProductList(editProduct);
			
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
		int index = productController.getProductIndexInList(editProduct);
		productController.removeProductInList(editProduct);
		JOptionPane.showMessageDialog(null, editProduct.getNickName());
		productController.getButtonList().remove(index);
		productController.applyList();
		paneEdit.setVisible(false);
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}
}
