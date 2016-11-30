package controller;
/**
 * Created by jeonilbae on 2016. 11. 30..
 */
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
import network.Assembleddata;

// ProductAddController
public class ProductAddController implements Initializable {
	@FXML
	private AnchorPane paneAdd;

	@FXML
	private ComboBox<String> cmbBoxProduct;		// List of appliance types

	@FXML
	private ComboBox<String> cmbBoxModel;		// List of appliance models

	@FXML
	private Text textPower;

	@FXML
	private Text textGrade;

	@FXML
	private Text Power;

	@FXML
	private TextField textFieldNickName;

	@FXML
	private TextField textFieldHour;

	@FXML
	private Button btnAdd;			// Add appliance button

	@FXML
	private Button btnCancel;		// Cancel inserting button

	private ProductController productController;	// ProductController
	private Product newProduct;		// New product
	private String type;		// String of type
	private String model;		// String of model

	// Set controller method
	public void setProductController(ProductController productController) {
		this.productController = productController;
	}

	// Return built product
	public Product getProduct() {
		return newProduct;
	}

	// ProductAddController initialize
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Initialize list of types
		ObservableList<String> listProduct = cmbBoxProduct.getItems();
<<<<<<< HEAD
		
		// Add types to list
		listProduct.add("?ƒ‰?ž¥ê³?");
		listProduct.add("?—?–´ì»?");
        listProduct.add("?‚œë°©ê¸°");
        listProduct.add("?„¸?ƒê¸?");
        listProduct.add("TV");

        // Initialize list of models
		ObservableList<String> listModel = cmbBoxModel.getItems();
		
		// Add models to list
		listModel.add("c");
		listModel.add("d");
=======
		ObservableList<String> listModel = cmbBoxModel.getItems();
		
		/** Created by jeonyongjin on 2016. 11. 30..
		 *  LOC 8
		 */ 
		listProduct.add("washer");
		listProduct.add("airconditioner");
        listProduct.add("heater");
        listProduct.add("refrigerator");
        listProduct.add("TV");
		for(int i=0;i< Assembleddata.getProductLists().size();i++){
			listModel.add(i,Assembleddata.getProductLists().get(i).getName());
		}
		/**
		 * 
		 */
>>>>>>> 9d3b5c656fc95950f130ee9a8507d2f510f76f71
		
		// Event of type combobox changed
		cmbBoxProduct.getSelectionModel().selectedItemProperty().addListener(event -> {
			
			// Save changed type
			type = cmbBoxProduct.getSelectionModel().getSelectedItem().toString();
		});

		// Event of model combobox changed
		cmbBoxModel.getSelectionModel().selectedItemProperty().addListener(event -> {
			
			// Save changed model
			model = cmbBoxModel.getSelectionModel().getSelectedItem().toString();
		});
	}

	// Event of add button
	public void btnAddHandler() {
		
		paneAdd.getChildren().clear();		// Clean the pane

		// Create object of productTotalController
		ProductTotalController productTotalController = new ProductTotalController();
		
		// Set productTotalController's controller
		productTotalController.setProductController(productController);
		
		// Connect loader with ProductTotal.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductTotal.fxml"));		
		loader.setController(productTotalController);

		// Add loader to pane
		try {
			paneAdd.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create object of ProductBuilder
		ProductBuilder productBuilder = new ProductBuilder();
		
		// Parse textbox and Create product with productBuilder
		newProduct = productBuilder
				.setType(type)
				.setModel(model)
				.setPower(Double.parseDouble(textPower.getText().split(" ")[0]))
				.setGrade(Integer.parseInt(textGrade.getText()))
				.setUsingTime(Integer.parseInt(textFieldHour.getText()))
				.setNickName(textFieldNickName.getText())
				.build();
	
		// Create button named product's nickname
		Button newButton = new Button(newProduct.getNickName());
		newButton.setPrefSize(210, 100);
		
		// Event of button click
		newButton.setOnAction(event -> {
			
			// Create object of ProductEditController
			ProductEditController productEditController = new ProductEditController();
			productEditController.setProductController(productController);

			// Initialize productEditController's product field
			productEditController.setProduct(newProduct);
			
			// Connect loader with ProductEdit.fxml
			FXMLLoader editLoader = new FXMLLoader(getClass().getResource("/fxml/ProductEdit.fxml"));
			editLoader.setController(productEditController);

			// Add loader to pane
			try {
				productController.getPaneTotal().getChildren().clear();
				productController.getPaneTotal().getChildren().add(editLoader.load());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		// Add newButton to buttonList
		productController.getButtonList().add(newButton);
		
		// Initialize buttons
		productController.applyList();
		
		// Add newProduct to productList
		productController.addProductList(newProduct);
	}

	// Event of cancel button
	public void btnCancelHandler() {
		
		paneAdd.getChildren().clear();		// Clean the pane

		// Create object of productTotalController
		ProductTotalController productTotalController = new ProductTotalController();
		
		// Connect loader with ProductTotal.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductTotal.fxml"));
		loader.setController(productTotalController);

		// Add loader to pane
		try {
			paneAdd.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
/**
 * 
 */
