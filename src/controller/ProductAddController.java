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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import network.Assembleddata;
import network.NetworkService;
import network.response.SignupResult;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
	
	private String baseurl;
	private final String IP = "52.78.211.206";
	private final int PORT = 80;

	// Set controller method
	public void setProductController(ProductController productController) {
		this.productController = productController;
	}

	// Return built product
	public Product getProduct() {
		return newProduct;
	}

	ObservableList<String> listProduct = cmbBoxProduct.getItems();
	
	ObservableList<String> listModel = cmbBoxModel.getItems();
	
	// ProductAddController initialize
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Initialize list of types
		/** Created by jeonyongjin on 2016. 11. 30..
		 *  LOC 8
		 */ 
		listProduct.add("Washer");
		listProduct.add("Airconditioner");
        listProduct.add("Heater");
        listProduct.add("Refrigerator");
        listProduct.add("TV");
        System.out.println("getting in here?1");
		for(int i=0;i< Assembleddata.getProductLists().size();i++){
			listModel.add(i,Assembleddata.getProductLists().get(i).getModel());
		}
		/**
		 * 
		 */

		// Event of type combobox changed
		cmbBoxProduct.getSelectionModel().selectedItemProperty().addListener(event -> {
			// Save changed type
			listModel.remove(0, listModel.size());
			type = cmbBoxProduct.getSelectionModel().getSelectedItem().toString();
			System.out.printf("type은 %s \n",type);
			for(int i =0;i<Assembleddata.getProductLists().size();i++){
				System.out.println("getting in here?2");
				System.out.printf("%s \n", Assembleddata.getProductLists().get(i).getName());
				if(Assembleddata.getProductLists().get(i).getName().equals(type)){
					System.out.println("getting in here?3");
					listModel.add(Assembleddata.getProductLists().get(i).getModel());
				}
			}
		});

		// Event of model combobox changed
		cmbBoxModel.getSelectionModel().selectedItemProperty().addListener(event2 -> {
			// Save changed model
			System.out.println(cmbBoxModel.getSelectionModel().getSelectedItem().toString());
			model = cmbBoxModel.getSelectionModel().getSelectedItem().toString();
			System.out.println(Assembleddata.getProductLists().size());
			for(int i=0;i<Assembleddata.getProductLists().size();i++){
				if(Assembleddata.getProductLists().get(i).getModel().equals(model)){
					textPower.setText(String.valueOf(Assembleddata.getProductLists().get(i).getPower()));
					textGrade.setText(String.valueOf(Assembleddata.getProductLists().get(i).getGrade()));
					if(Assembleddata.getProductLists().get(i).getName().equals("Airconditioner") || Assembleddata.getProductLists().get(i).getName().equals("Heater")){
						Power.setText(String.valueOf(Assembleddata.getProductLists().get(i).getChpower()));
					}
				}
			}
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
	
	private void Addproduct(){
		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
				.client(httpClient).build();

		NetworkService networkService = retrofit.create(NetworkService.class);
		networkService.addProduct(Assembleddata.getToken().getToken(), newProduct).enqueue(new Callback<Void>() {
			@Override
			public void onResponse(Call<Void> call, Response<Void> response) {
				int status = response.code();
				if (response.isSuccessful()) {
				
				} else {
					System.out.printf("응답코드 %d", status);
				}
			}

			@Override
			public void onFailure(Call<Void> call, Throwable throwable) {

				System.out.printf("%s", throwable.getMessage());
				System.out.println("failure");
			}
		});		
	}

}
/**
 * 
 */
