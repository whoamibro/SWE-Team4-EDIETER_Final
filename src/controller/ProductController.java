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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class ProductController implements Initializable {
//	@FXML
//	private ProductTotalController productTotalController;
//	
//	@FXML
//	private ProductAddController productAddController;
//	
//	@FXML
//	private ProductEditController productEditController;
//	
//	public ProductTotalController getProductTotalController() {
//		return productTotalController;
//	}
//
//	public ProductAddController getProductAddController() {
//		return productAddController;
//	}
//
//	public ProductEditController getProductEditController() {
//		return productEditController;
//	}
	
//	
//	public void setVisibleTotalController(boolean bool) {
//		productTotalController.getPaneTotal().setVisible(bool);
//	}
//	
//	public void setVisibleAddController(boolean bool) {
//		productAddController.getPaneAdd().setVisible(bool);
//	}
//	
//	public void setVisibleEditController(boolean bool) {
//		productEditController.getPaneEdit().setVisible(bool);
//	}
	private ArrayList<Product> productList = new ArrayList<Product>();
	@FXML
	private AnchorPane paneProduct;
	
	@FXML
	private AnchorPane paneTotal;
	
	@FXML
	private FlowPane flowPane;
	
	public FlowPane getFlowPane() {
		return flowPane;
	}
	
	@FXML
	private Button btnAdd;

	private ObservableList<Button> buttonList = FXCollections.observableArrayList();
	
	public ObservableList<Button> getButtonList() {
		return buttonList;
	}
	
	public void applyList() {
		flowPane.getChildren().setAll(buttonList);
		flowPane.getChildren().add(btnAdd);
	}
	
	
	@Override	
	public void initialize(URL location, ResourceBundle resources) {
		// 하위 컨트롤러 필드 초기화
//		productAddController.setProductController(this);
//		productEditController.setProductController(this);
//		productTotalController.setProductController(this);
		
		ProductTotalController productTotalController = new ProductTotalController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductTotal.fxml"));
		loader.setController(productTotalController);
		try {
			paneTotal.getChildren().add(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 버튼 액션 추가
		btnAdd.setOnAction(event-> btnAddHandler());
		
		flowPane.getChildren().setAll(buttonList);
		flowPane.getChildren().add(btnAdd);
	}

	public void btnAddHandler() {
		paneTotal.getChildren().clear();
		ProductAddController productAddController = new ProductAddController();
		productAddController.setProductController(this);
		productList.add(productAddController.getProduct());
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductAdd.fxml"));
		loader.setController(productAddController);
		
		try {
			
			paneTotal.getChildren().add(loader.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
