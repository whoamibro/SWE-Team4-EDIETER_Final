package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import components.Product;
import components.ProductBuilder;
import components.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import network.Assembleddata;
import network.NetworkService;
import network.request.Login;
import network.request.Token;
import network.response.Electricusage_permon;
import network.response.ProductList;
import network.response.Product_n;
import network.response.User_f_n;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginController implements Initializable {
	/**
	 * Created by jeonyongjin on 2016. 11. 29..
	 */
	private String baseurl;
	private final String IP = "52.78.211.206";
	private final int PORT = 80;
	/**
	 */

	Login login = new Login();
	User thisUser = null;
	Token token = new Token();

	/**
	 * created by Jin Jung on 2016. 11. 30.
	 */
	@FXML
	private AnchorPane paneLogin;

	@FXML
	private TextField idField;

	@FXML
	private PasswordField pwField;

	@FXML
	private Button btnLogin;

	@FXML
	private Button btnRegister;

	@FXML
	private Button btnFind;

	UserController userController = new UserController();
	MainController mainController = new MainController();

	/** 
	 * */

	boolean chargeHistoryFlag = true;
	boolean productListFlag = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void btnLoginKeyPressHandler(KeyEvent e) {
		/**
		 * created by Jin Jung on 2016. 11. 30. function : keyhandler for login
		 * button loc : 2
		 */
		if(e.getCode().equals(KeyCode.ENTER)) // call btnLoginHandler when press enter key
			btnLoginHandler();
	}
	
	public void btnLoginHandler() {
		/**
		 * created by Jin Jung on 2016. 11. 30. function : handler for login
		 * button loc : 54
		 */
		// create user instance who logged in by entered information
		login.setEmail(idField.getText());
		login.setPassword(pwField.getText());

		// login thread
		Thread thread = new Thread(() -> {
			Login();
		});
		thread.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// if login is failed
		if (thisUser == null || !chargeHistoryFlag || !productListFlag) {
			// fail alert
			Alert successAlert = new Alert(Alert.AlertType.ERROR);
			successAlert.setHeaderText(null);
			successAlert.setContentText("로그인 오류 발생!");
			successAlert.showAndWait();
			return;
		}

		// create all controller
		ProductController productController = new ProductController();
		PlanController planController = new PlanController();
		MainController mainController = new MainController();

		// controller setting
		mainController.setUserController(userController);
		mainController.setProductController(productController);
		mainController.setPlanController(planController);
		mainController.setUser(thisUser);
		userController.setUser(thisUser);

		// create main scene loader
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		// set controller on loader
		loader.setController(mainController);

		// load main scene
		try {
			paneLogin.getChildren().clear();
			paneLogin.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		/** 
		 * */
	}

	public void btnRegisterHandler() {
		/**
		 * created by Jin Jung on 2016. 11. 30. function : handler for register
		 * button loc : 13
		 */
		// create Register Controller
		RegisterController registerController = new RegisterController();
		// create loader for registerController
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Register.fxml"));
		// set controller on loader
		loader.setController(registerController);

		// load register scene
		try {
			paneLogin.getChildren().clear();
			paneLogin.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		/** 
		 * */
	}

	public void btnFindHandler() {
		/**
		 * created by Jin Jung on 2016. 11. 30. function : handler for find
		 * button loc : 13
		 */
		// create findAccountController
		FindAccountController findAccountController = new FindAccountController();
		// create loader for indAccountController
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FindAccount.fxml"));
		// set controller on loader
		loader.setController(findAccountController);

		// load find scene
		try {
			Scene scene = new Scene(loader.load());
			Stage stage = new Stage();
			stage.setTitle("비밀번호 찾기");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/** 
		 * */
	}

	/**
	 * Created by jeonyongjin on 2016. 11. 29.. LOC 89
	 */
	// method for login
	private void Login() {

		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
				.client(httpClient).build();

		NetworkService networkService = retrofit.create(NetworkService.class);

		networkService.getUserIdentity(login).enqueue(new Callback<User_f_n>() {
			@Override
			public void onResponse(Call<User_f_n> call, Response<User_f_n> response) {
				int status = response.code();
				if (response.isSuccessful()) {
					User_f_n user_f_n = response.body();
					if (user_f_n.isResult() == true) {
						System.out.printf("statuse code : %d", status);
						System.out.println("connect to server successful");
						Assembleddata.setUser_f_n(user_f_n);
						Assembleddata.setToken(user_f_n.getToken());
						Assembleddata.setpw(login.getPassword());
						token.setToken(user_f_n.getToken());

						System.out.printf("%d\n", user_f_n.getToken());
						System.out.printf("%s\n", user_f_n.getName());
						System.out.printf("%d\n", user_f_n.getAreaSize());

						thisUser = new User();
						thisUser.setName(user_f_n.getName());
						thisUser.setEmail(user_f_n.getEmail());
						thisUser.setAreaSize(user_f_n.getAreaSize());
						thisUser.setUsedElec(user_f_n.getUsedElec());

						Gethistory();
						Getproductlist();
					} else {
						System.out.println("please check your id and password");
					}
				} else {
					System.out.printf("응답코드 %d", status);
				}
			}

			@Override
			public void onFailure(Call<User_f_n> call, Throwable throwable) {
				thisUser = null;
				System.out.printf("%s", throwable.getMessage());
				System.out.println("failure");
			}
		});
	}

	// method for get user's electric usage history
	private void Gethistory() {
		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
				.client(httpClient).build();

		System.out.printf("%d", token.getToken());
		NetworkService networkService = retrofit.create(NetworkService.class);
		networkService.getElechistory(token.getToken()).enqueue(new Callback<List<Electricusage_permon>>() {
			@Override
			public void onResponse(Call<List<Electricusage_permon>> call,
					Response<List<Electricusage_permon>> response) {
				int status = response.code();

				chargeHistoryFlag = true;
				double[] chargehistory = new double[6];
				for (int i = 0; i < chargehistory.length; i++)
					chargehistory[i] = -1.0;
				thisUser.setChargeHistory(chargehistory);

				System.out.printf("여기 출력됨?\n");
				List<Electricusage_permon> electricusage_permons = response.body();
				Assembleddata.setElectricusage_permons(electricusage_permons);

				for (int i = 0; i < 6; i++) {
					chargehistory[i] = Assembleddata.getElectricusage_permons().get(i).getUsage();
					System.out.printf("%f \n", chargehistory[i]);
				}

				thisUser.setChargeHistory(chargehistory);

				for (double d : thisUser.getChargeHist()) {
					System.out.println(d);
					if (d == -1.0) {
						chargeHistoryFlag = false;
					}
				}
			}

			@Override
			public void onFailure(Call<List<Electricusage_permon>> call, Throwable throwable) {
				System.out.printf("%s", throwable.getMessage());
				System.out.println("failure");
			}
		});
	}

	/**
	 *
	 */

	/**
	 * Created by jeonyongjin on 2016. 11. 30..
	 */
	private void Getproductlist() {
		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
				.client(httpClient).build();

		NetworkService networkService = retrofit.create(NetworkService.class);
		networkService.getProductList().enqueue(new Callback<List<ProductList>>() {
			@Override
			public void onResponse(Call<List<ProductList>> call, Response<List<ProductList>> response) {
				System.out.printf("여기 출력됨?");
				int status = response.code();
				List<ProductList> productLists = response.body();
				Assembleddata.setProductLists(productLists);

				for (int i = 0; i < productLists.size(); i++) {
					System.out.printf("%s \n", Assembleddata.getProductLists().get(i).getName());
				}
				GetUserproductlist();
			}

			@Override
			public void onFailure(Call<List<ProductList>> call, Throwable throwable) {
				System.out.printf("%s", throwable.getMessage());
				System.out.println("failure");
			}
		});
	}

	private void GetUserproductlist() {
		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
				.client(httpClient).build();

		NetworkService networkService = retrofit.create(NetworkService.class);
		token.setToken(Assembleddata.tokensetting());
		System.out.println("언제 찍히니");
		System.out.printf("%d", token.getToken());

		networkService.getUserPList(token.getToken()).enqueue(new Callback<List<Product_n>>() {
			@Override
			public void onResponse(Call<List<Product_n>> call, Response<List<Product_n>> response) {
				Assembleddata.setProducts(null);
				int status = response.code();
				if (response.isSuccessful()) {
					List<Product_n> products = response.body();
					Assembleddata.setProducts(products);

					productListFlag = true;
					ProductController.productList = new ArrayList<Product>();
					for (int i = 0; i < products.size(); i++) {
						for (int j = 0; j < Assembleddata.getProductLists().size(); j++) {
							if (products.get(i).getPcode() == Assembleddata.getProductLists().get(j).getPcode()) {
								ProductBuilder productBuilder = new ProductBuilder();
								Product product = productBuilder
										.setType(Assembleddata.getProductLists().get(i).getName())
										.setModel(Assembleddata.getProductLists().get(i).getModel())
										.setPower(Assembleddata.getProductLists().get(i).getPower())
										.setGrade(Assembleddata.getProductLists().get(i).getGrade())
										.setUsingTime(Assembleddata.getProducts().get(i).getUsingtime())
										.setNickName(Assembleddata.getProducts().get(i).getNickname()).build();
								ProductController.productList.add(i, product);

								System.out.printf("이부분 값은 ? %d", products.size());
								System.out.printf("이부분 값은 ? %d", Assembleddata.getProductLists().size());
								System.out.printf("%s", product.getNickName());
								System.out.printf("%s", product.getModel());
								System.out.printf("%s\n", product.getType());
							}
						}
					}

					if (ProductController.productList.size() != products.size())
						productListFlag = false;

				}
			}

			@Override
			public void onFailure(Call<List<Product_n>> call, Throwable throwable) {
				System.out.printf("%s", throwable.getMessage());
				System.out.println("failure");
			}
		});
	}
	/**
	 */

}
