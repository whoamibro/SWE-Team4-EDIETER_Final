package controller;

import components.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
	
	public void addProductList(Product newProduct) {
		productList.add(newProduct);
	}
	
	public void removeProductInList(Product removeProduct) {
		productList.remove(removeProduct);
	}
	
	public int getProductIndexInList(Product searchProduct) {
		return productList.indexOf(searchProduct);
	}
	
	public int getProductListSize() {
		return productList.size();
	}
	
	public void setProductInList(int productIndex, Product editProduct) {
		productList.set(productIndex, editProduct);
	}

	public Product getProduct(int index) {
		return productList.get(index);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
