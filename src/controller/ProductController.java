package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

/**
 * Created by jeonilbae on 2016. 11. 30..
 */
import components.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class ProductController implements Initializable {
	public static ArrayList<Product> productList = new ArrayList<Product>();
	@FXML
	private AnchorPane paneProduct;

	@FXML
	private AnchorPane paneTotal;

	@FXML
	private FlowPane flowPane;

	@FXML
	private Button btnAdd;

	private ObservableList<Button> buttonList=FXCollections.observableArrayList();

	public ObservableList<Button> getButtonList() {
		return buttonList;
	}

	public AnchorPane getPaneTotal() {
		return paneTotal;
	}

	public FlowPane getFlowPane() {
		return flowPane;
	}

	public void applyList() {
		flowPane.getChildren().setAll(buttonList);
		flowPane.getChildren().add(btnAdd);
	}
	/**
	 * Created by jeonilbae on 2016. 11. 30..
	 */
	
	// Add newProduct to productList
	public void addProductList(Product newProduct) {
		productList.add(newProduct);
	}
	
	// Remove product in productList
	public void removeProductInList(Product removeProduct) {
		productList.remove(removeProduct);
	}
	
	// Index of searching product in productList
	public int getProductIndexInList(Product searchProduct) {
		return productList.indexOf(searchProduct);
	}
	
	// Size of productList
	public int getProductListSize() {
		return productList.size();
	}
	
	// Replace product in productList using index and editProduct
	public void setProductInList(int productIndex, Product editProduct) {
		productList.set(productIndex, editProduct);
	}

	// Get product in productList by index
	public Product getProduct(int index) {
		return productList.get(index);
	}
	/**
	 * 
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Iterator<Product> iterator = productList.iterator();
		
		while(iterator.hasNext()) {
			Product product = iterator.next();
			
			Button newButton = new Button();
			newButton.setText(product.getNickName());
			newButton.setPrefSize(210, 100);
			// Event of button click
			newButton.setOnAction(event -> {
				
				// Create object of ProductEditController
				ProductEditController productEditController = new ProductEditController();
				productEditController.setProductController(this);

				// Initialize productEditController's product field
				productEditController.setProduct(product);
				
				// Connect loader with ProductEdit.fxml
				FXMLLoader editLoader = new FXMLLoader(getClass().getResource("/fxml/ProductEdit.fxml"));
				editLoader.setController(productEditController);

				// Add loader to pane
				try {
					getPaneTotal().getChildren().clear();
					getPaneTotal().getChildren().add(editLoader.load());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
						
			buttonList.add(newButton);
		}
		
		ProductTotalController productTotalController = new ProductTotalController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductTotal.fxml"));
		loader.setController(productTotalController);
		try {
			paneTotal.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		applyList();
	}

	public void btnAddHandler() {
		ProductAddController productAddController = new ProductAddController();
		productAddController.setProductController(this);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductAdd.fxml"));
		loader.setController(productAddController);

		try {
			paneTotal.getChildren().clear();
			paneTotal.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
/**
 * 
 */
