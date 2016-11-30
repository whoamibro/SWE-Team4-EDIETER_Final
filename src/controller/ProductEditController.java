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
import network.Assembleddata;

//ProductEditController
public class ProductEditController implements Initializable {
	@FXML
	private ProductController productController;	// ProductController
	private Product editProduct;			// Edit product
	
	private String type;		// String of type
	private String model;		// String of model
	@FXML
	private AnchorPane paneEdit;

	@FXML
	private ComboBox<String> cmbBoxType;		// List of appliance types

	@FXML
	private ComboBox<String> cmbBoxModel;		// List of appliance models

	@FXML
	private Text textPower;

	@FXML
	private Text textGrade;

	@FXML
	private TextField nickNameField;

	@FXML
	private TextField hourField;

	@FXML
	private Button btnEdit;			// Edit appliance button

	@FXML
	private Button btnClose;		// Close edit pane button

	@FXML
	private Button btnRemove;		// Remove appliance button

	private boolean editFlag = false;	// Change flag of edit button

	// Set product field of editController
	public void setProduct(Product editProduct) {
		this.editProduct = editProduct;
	}
	
	// Set controller method
	public void setProductController(ProductController productController) {
		this.productController = productController;
	}
	
	// ProductEditController initialize
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		type = "";		// Initialize type
		model = "";		// Initialize model
		
		// Initialize list of types
		ObservableList<String> listType = cmbBoxType.getItems();

		ObservableList<String> listModel = cmbBoxModel.getItems();
		
		/** Created by jeonyongjin on 2016. 11. 30..
		 *  LOC 8
		 */ 
		listType.add("washer");
		listType.add("airconditioner");
        listType.add("heater");
        listType.add("refrigerator");
        listType.add("TV");
		for(int i=0;i< Assembleddata.getProductLists().size();i++){
			listModel.add(i,Assembleddata.getProductLists().get(i).getName());
		}
		/**
		 * 
		 */

		// Event of type combobox changed
		cmbBoxType.getSelectionModel().selectedItemProperty().addListener(event -> {
			
			// Save changed type
			type = cmbBoxType.getSelectionModel().getSelectedItem().toString();
		});

		// Event of model combobox changed
		cmbBoxModel.getSelectionModel().selectedItemProperty().addListener(event -> {
			
			// Save changed model
			model = cmbBoxModel.getSelectionModel().getSelectedItem().toString();
		});
		
		// Initialize textboxes by information of edit product
		cmbBoxType.setPromptText(editProduct.getType());
		cmbBoxModel.setPromptText(editProduct.getModel());
		textPower.setText(String.valueOf(editProduct.getPower()) + " kW");
		textGrade.setText(String.valueOf(editProduct.getGrade()));
		nickNameField.setText(editProduct.getNickName());
		hourField.setText(String.valueOf(editProduct.getUsingTime()));
	
	}

	// Event of edit button
	public void btnEditHandler() {
		
		// If user see edit button
		if (!editFlag) {
		
			// Change user could edit
			cmbBoxType.setDisable(false);
			cmbBoxModel.setDisable(false);
			nickNameField.setDisable(false);
			hourField.setDisable(false);
			btnEdit.setText("Set");
			
			editFlag = true;		// Change flag
		} 
		
		// If user see set button
		else {
			
			// Create object of productBuilder
			ProductBuilder productBuilder = new ProductBuilder();
			
			// Iterator of buttonList
			ListIterator<Button> it = productController.getButtonList().listIterator();
			
			// Search button of editProduct in buttonList
			while(it.hasNext()) {
				
				Button button = it.next();		// Temporary button
				int buttonIndex = it.previousIndex();		// Save button index
				
				// Save editProduct index of productList
				int productIndex = productController.getProductIndexInList(editProduct);
				
				// If product's nickname equals button's name
				if(editProduct.getNickName().equals(button.getText()))
				{
					// If type is initialized
					if(type == "")
						type = editProduct.getType();		// Save type of editProduct					
					
					// If model is initialized
					if(model == "")
						model = editProduct.getType();		// Save model of editProduct
					 
					// Create product with productBuilder
					editProduct = productBuilder
							.setType(type)
							.setModel(model)
							.setPower(Double.parseDouble(textPower.getText().split(" ")[0]))
							.setGrade(Integer.parseInt(textGrade.getText()))
							.setUsingTime(Integer.parseInt(hourField.getText()))
							.setNickName(nickNameField.getText())
							.build();
					
					// Event of button click
					button.setOnAction(event -> {
						
						// Create object of ProductEditController
						ProductEditController productEditController = new ProductEditController();
						productEditController.setProductController(productController);
						
						// Initialize productEditController's product field
						productEditController.setProduct(editProduct);
						
						// Replace product to editProduct in productList
						productController.setProductInList(productIndex, editProduct);
						
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
					
					// Set button's name with nickname of product
					button.setText(editProduct.getNickName());
					
					it.set(button);			// Replace button to new button
					
					// Replace button to new button in buttonList
					productController.getButtonList().set(buttonIndex, button);
					
				}
						
			}
	
			// Change user couldn't edit
			cmbBoxType.setDisable(true);
			cmbBoxModel.setDisable(true);
			nickNameField.setDisable(true);
			hourField.setDisable(true);
			btnEdit.setText("Edit");
			
			editFlag = false;		// Change flag
		}
	}

	// Event of close button
	public void btnCloseHandler() {
		
		// Create object of productTotalController
		ProductTotalController productTotalController = new ProductTotalController();
		
		// Connect loader with ProductTotal.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductTotal.fxml"));
		loader.setController(productTotalController);

		// Add loader to pane
		try {
			paneEdit.getChildren().clear();
			paneEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Event of remove button
	public void btnRemoveHandler() {
	
		// Remove product in productList
		productController.removeProductInList(editProduct);
		
		// Iterator of buttonList
		ListIterator<Button> it = productController.getButtonList().listIterator();
		
		// Search button of removeProduct in buttonList
		while(it.hasNext()) {
			
			// If product's nickname equals button's name
			if(editProduct.getNickName().equals(it.next().getText()))
			{
				it.remove();		// Remove button
			}

		}
		
		productController.applyList();		// Initialize buttons
		paneEdit.setVisible(false);			// Hide editPane
	}

}
/**
 * 
 */
