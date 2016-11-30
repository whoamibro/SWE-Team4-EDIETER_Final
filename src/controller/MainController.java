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

	public MainController() {
	}

	public void setUser(User user) {
		this.thisUser = user;
	}

	private UserController userController;

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/User.fxml"));
		loader.setController(userController);
		try {
			userPane.getChildren().add(loader.load());

		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		greetText.setText("welcome " + thisUser.getName());

		Getproductlist();

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

	/**
	 * Created by jeonyongjin on 2016. 11. 30..
	 * LOC 
	 */
	private void Getproductlist(){
		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseurl)
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient)
				.build();

		NetworkService networkService = retrofit.create(NetworkService.class);
		networkService.getProductList().enqueue(new Callback<List<ProductList>>() {
			@Override
			public void onResponse(Call<List<ProductList>> call, Response<List<ProductList>> response) {
				System.out.printf("여기 출력됨?");
				int status = response.code();
				List<ProductList> productLists = response.body();
				Assembleddata.setProductLists(productLists);

				for(int i=0;i<productLists.size();i++){
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

	private void GetUserproductlist(){
		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseurl)
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient)
				.build();

		NetworkService networkService = retrofit.create(NetworkService.class);
		token.setToken(Assembleddata.tokensetting());
        System.out.println("언제 찍히니");
		System.out.printf("%d", token.getToken());

		networkService.getUserPList(token.getToken()).enqueue(new Callback<List<Product_n>>() {
			@Override
			public void onResponse(Call<List<Product_n>> call, Response<List<Product_n>> response) {
                int status = response.code();
                if(response.isSuccessful()) {
                    List<Product_n> products = response.body();
                    Assembleddata.setProducts(products);

                    for(int i=0;i<products.size();i++){
                        for(int j=0;j<Assembleddata.getProductLists().size();j++) {
                            if(products.get(i).getPcode() == Assembleddata.getProductLists().get(i).getPcode()) {
                                ProductBuilder productBuilder = new ProductBuilder();
                                Product product = productBuilder
                                        .setType(Assembleddata.getProductLists().get(i).getName())
                                        .setModel(Assembleddata.getProductLists().get(i).getModel())
                                        .setPower(Assembleddata.getProductLists().get(i).getPower())
                                        .setGrade(Assembleddata.getProductLists().get(i).getGrade())
                                        .setUsingTime(Assembleddata.getProducts().get(i).getUsingtime())
                                        .setNickName(Assembleddata.getProducts().get(i).getNickname())
                                        .build();
                                ProductController.productList.add(i,product);
                                System.out.printf("이부분 값은 ? %d", products.size());
                                System.out.printf("이부분 값은 ? %d", Assembleddata.getProductLists().size());
                                System.out.printf("%s", product.getNickName());
                                System.out.printf("%s", product.getModel());
                                System.out.printf("%s", product.getType());
                            }
                        }
                    }
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
