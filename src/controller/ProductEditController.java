package controller;
/**
 * Created by jeonilbae on 2016. 11. 30..
 */
import java.io.IOException;
import java.net.URL;
import java.util.ListIterator;
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

public class ProductEditController implements Initializable {
	@FXML
	private ProductController productController;
	private Product editProduct;
	
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		type = "";
		model = "";
		
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
			btnEdit.setText("�Ϸ�");
			editFlag = true;
			
		} else {
			ProductBuilder productBuilder = new ProductBuilder();
			
			ListIterator<Button> it = productController.getButtonList().listIterator();
			while(it.hasNext()) {
				Button button = it.next();
				int buttonIndex = it.previousIndex();
				int productIndex = productController.getProductIndexInList(editProduct);
				
				if(editProduct.getNickName().equals(button.getText()))
				{
					if(type == "")
						type = editProduct.getType();
					
					if(model == "")
						model = editProduct.getType();
					 
					editProduct = productBuilder
							.setType(type)
							.setModel(model)
							.setPower(Double.parseDouble(textPower.getText().split(" ")[0]))
							.setGrade(Integer.parseInt(textGrade.getText()))
							.setUsingTime(Integer.parseInt(hourField.getText()))
							.setNickName(nickNameField.getText())
							.build();
					
					button.setOnAction(event -> {
						ProductEditController productEditController = new ProductEditController();
						productEditController.setProductController(productController);
						
						productEditController.setProduct(editProduct);
						productController.setProductInList(productIndex, editProduct);
						
						FXMLLoader editLoader = new FXMLLoader(getClass().getResource("/fxml/ProductEdit.fxml"));
						editLoader.setController(productEditController);

						try {
							productController.getPaneTotal().getChildren().clear();
							productController.getPaneTotal().getChildren().add(editLoader.load());
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
					button.setText(editProduct.getNickName());
					it.set(button);
					
					productController.getButtonList().set(buttonIndex, button);
					
				}
						
			}
	
			cmbBoxType.setDisable(true);
			cmbBoxModel.setDisable(true);
			nickNameField.setDisable(true);
			hourField.setDisable(true);
			btnEdit.setText("����");
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
	
		productController.removeProductInList(editProduct);
		
		ListIterator<Button> it = productController.getButtonList().listIterator();
		while(it.hasNext()) {
			if(editProduct.getNickName().equals(it.next().getText()))
			{
				it.remove();
			}
					
		}
		
		productController.applyList();
		paneEdit.setVisible(false);
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}
}
/**
 * 
 */
