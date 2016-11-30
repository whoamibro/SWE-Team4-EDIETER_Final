package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import components.Product;
import components.ProductBuilder;
import components.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import network.Assembleddata;
import network.NetworkService;
import network.request.Token;
import network.response.ProductList;
import network.response.Product_n;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController implements Initializable {
	/**
	 * Created by jeonyongjin on 2016. 11. 29..
	 * LOC : 3
	 */
	private String baseurl;
	private final String IP="52.78.211.206";
	private final int PORT=80;
	Token token = new Token();
	/**
	 */
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
	

	public MainController() {
	}

	public void setUser(User user) {
		this.thisUser = user;
	}

	private UserController userController;
	private ProductController productController;
	private PlanController planController;

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}

	public void setPlanController(PlanController planController) {
		this.planController = planController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		Getproductlist();
		FXMLLoader userLoader = new FXMLLoader(getClass().getResource("/fxml/User.fxml"));
		userLoader.setController(userController);
		try {
			userPane.getChildren().add(userLoader.load());

		} catch (IOException e) {
		}

		FXMLLoader productLoader = new FXMLLoader(getClass().getResource("/fxml/Product.fxml"));
		productLoader.setController(productController);
		try {
			productPane.getChildren().add(productLoader.load());

		} catch (IOException e) {
		}

		FXMLLoader planLoader = new FXMLLoader(getClass().getResource("/fxml/Plan.fxml"));
		planLoader.setController(planController);
		try {
			planPane.getChildren().add(planLoader.load());

		} catch (IOException e) {
		}

		// greetText.setText("welcome " + thisUser.getName());


	}

	public void btnLogoutHandler() {
		LoginController loginController = new LoginController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(loginController);

		try {
			paneMain.getChildren().clear();
			paneMain.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setVisible(boolean bool) {
		paneMain.setVisible(bool);
	}

	public void btnEditHandler() {
		UserEditController userEditController = new UserEditController(thisUser);
		userEditController.setMainController(this);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserEdit.fxml"));
		loader.setController(userEditController);

		try {
			paneMain.getChildren().clear();
			paneMain.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
