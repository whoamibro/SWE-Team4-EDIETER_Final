package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import components.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import network.request.Token;

public class MainController implements Initializable {
	
	/** 
	 * created by Jin Jung on 2016. 11. 30.
	 * loc : 40 
	 * */
	private User thisUser;

	@FXML
	private AnchorPane paneMain;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnLogout;

	@FXML
	private Text greetText;

	@FXML
	private AnchorPane userPane;

	@FXML
	private AnchorPane productPane;

	@FXML
	private AnchorPane planPane;

	public void setUser(User user) {
		this.thisUser = user;
	}

	private UserController userController;
	private ProductController productController;
	private PlanController planController;

	// setter for controller
	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}

	public void setPlanController(PlanController planController) {
		this.planController = planController;
	}
	/** 
	 * */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/** 
		 * created by Jin Jung on 2016. 11. 30.
		 * function : create loader and load scene 
		 * loc : 28
		 * */
		
		// load user scene
		FXMLLoader userLoader = new FXMLLoader(getClass().getResource("/fxml/User.fxml"));
		userLoader.setController(userController);
		try {
			userPane.getChildren().add(userLoader.load());

		} catch (IOException e) {
		}
		
		// load product scene
		FXMLLoader productLoader = new FXMLLoader(getClass().getResource("/fxml/Product.fxml"));
		productLoader.setController(productController);
		try {
			productPane.getChildren().add(productLoader.load());

		} catch (IOException e) {
		}

		// load plan scene
		FXMLLoader planLoader = new FXMLLoader(getClass().getResource("/fxml/Plan.fxml"));
		planLoader.setController(planController);
		try {
			planPane.getChildren().add(planLoader.load());

		} catch (IOException e) {
		}
		
		// set welcome text
		greetText.setText("welcome " + thisUser.getName());
		/** 
		 * */
	}

	public void btnLogoutHandler() {
		/** 
		 * created by Jin Jung on 2016. 11. 30.
		 * function : handler for logout
		 * loc : 13
		 * */
		
		// create loginController 
		LoginController loginController = new LoginController();
		// create loader for loginController
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		// set controller on loader
		loader.setController(loginController);

		// load login scene
		try {
			paneMain.getChildren().clear();
			paneMain.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		/** 
		 * */
		
	}

	public void btnEditHandler() {
		/** 
		 * created by Jin Jung on 2016. 11. 30.
		 * function : handler for edit
		 * loc : 14 
		 * */
		
		// create userEditController
		UserEditController userEditController = new UserEditController(thisUser);
		userEditController.setMainController(this);
		// create loader for userEditController
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserEdit.fxml"));
		// set controller on loader
		loader.setController(userEditController);

		// load UserEdit scene
		try {
			paneMain.getChildren().clear();
			paneMain.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		/** 
		 * */
	}

}
