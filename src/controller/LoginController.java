package controller;

import components.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import network.Assembleddata;
import network.NetworkService;
import network.request.Login;
import network.request.Token;
import network.response.Electricusage_permon;
import network.response.User_f_n;
import okhttp3.OkHttpClient;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class LoginController implements Initializable {
	/**
	 * Created by jeonyongjin on 2016. 11. 29..
	 */
	private String baseurl;
	private final String IP="52.78.211.206";
	private final int PORT=80;
	/**
	 */

	Login login = new Login();
	User thisUser = new User();
	Token token = new Token();
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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void btnLoginHandler() {


//		//Create user instance who logged in by entered information

		login.setEmail(idField.getText());
		login.setPassword(pwField.getText());

		System.out.printf("%s , %s",idField.getText(), pwField.getText());
		Login();
		//////////////////

		if(thisUser.getChargeHistory()!=null) {
			mainController.setUserController(userController);
			mainController.setUser(thisUser);
			userController.setUser(thisUser);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));

			loader.setController(mainController);

			try {
				paneLogin.getChildren().clear();
				paneLogin.getChildren().add(loader.load());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void btnRegisterHandler() {
		RegisterController registerController = new RegisterController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Register.fxml"));
		loader.setController(registerController);
		
		try {
			paneLogin.getChildren().clear();
			paneLogin.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void btnFindHandler() {
		FindAccountController findAccountController = new FindAccountController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FindAccount.fxml"));
		loader.setController(findAccountController);
		try {
			Scene scene = new Scene(loader.load());
			Stage stage = new Stage();
			stage.setTitle("비밀번호 찾기");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Created by jeonyongjin on 2016. 11. 29..
	 */
	private void Login(){
//		// progress property binding
//		Task<Integer> task = new Task<Integer>() {
//			@Override
//			protected Integer call() throws Exception {
//				int result = 0;
//				for (int i = 1; i <= 100; i++) {
//					if (isCancelled()) {
//						break;
//					}
//					result += i;
//					updateProgress(i, 100);
//					updateMessage(String.valueOf(i));
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						if (isCancelled()) {
//							break;
//						}
//					}
//				}
//				return result;
//			}
//
//			@Override
//			public void succeeded() {
//				// lblResult.setText(String.valueOf(getValue()));
//			}
//
//			public void cancelled() {
//				// lblResult.setText("취소됨");
//			}
//
//			public void failed() {
//				// lblResult.setText("실패");
//			}
//		};
//
//		ProgressBar progressBar = new ProgressBar();
//		Pane pane = new Pane();
//		pane.setPrefSize(200, 100);
//		Scene scene = new Scene(pane);
//
//		pane.getChildren().add(progressBar);
//		Stage stage = new Stage();
//		stage.setScene(scene);
//		stage.show();
//
//		progressBar.progressProperty().bind(task.progressProperty());
//
//		Thread thread = new Thread(task);
//		thread.setDaemon(true);
//		thread.start();

		baseurl = String.format("http://%s:%d/",IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseurl)
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient)
				.build();

		NetworkService networkService = retrofit.create(NetworkService.class);

		networkService.getUserIdentity(login).enqueue(new Callback<User_f_n>() {
			@Override
			public void onResponse(Call<User_f_n> call, Response<User_f_n> response) {
				int status = response.code();
				if(response.isSuccessful()){
					User_f_n user_f_n = response.body();
					if(user_f_n.isResult() == true){
						System.out.printf("statuse code : %d", status);
						System.out.println("connect to server successful");
						Assembleddata.setUser_f_n(user_f_n);
						Assembleddata.setToken(user_f_n.getToken());

						token.setToken(user_f_n.getToken());

						System.out.printf("%d\n", user_f_n.getToken());
						System.out.printf("%s\n", user_f_n.getName());
						System.out.printf("%d\n", user_f_n.getAreaSize());

						thisUser.setName(user_f_n.getName());
						thisUser.setEmail(user_f_n.getEmail());
						thisUser.setAreaSize(user_f_n.getAreaSize());
						thisUser.setUsedElec(user_f_n.getUsedElec());
//						progressBar.disabledProperty();
						Gethistory();
					}
					else {
						System.out.println("please check your id and password");
					}
				}
				else{
					System.out.printf("응답코드 %d", status);
				}
			}
			@Override
			public void onFailure(Call<User_f_n> call, Throwable throwable) {
				System.out.printf("%s", throwable.getMessage());
				System.out.println("failure");
			}
		});
	}

	private void Gethistory() {
		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseurl)
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient)
				.build();

		System.out.printf("%d", token.getToken());
		NetworkService networkService = retrofit.create(NetworkService.class);
		networkService.getElechistory(token.getToken()).enqueue(new Callback<List<Electricusage_permon>>() {
			@Override
			public void onResponse(Call<List<Electricusage_permon>> call, Response<List<Electricusage_permon>> response) {
				int status = response.code();
				double [] chargehistory = new double[6];
				System.out.printf("여기 출력됨?\n");
				List<Electricusage_permon> electricusage_permons = response.body();
				Assembleddata.setElectricusage_permons(electricusage_permons);

				for(int i=0;i<6;i++){
					chargehistory[i] = Assembleddata.getElectricusage_permons().get(i).getUsage();
					System.out.printf("%f \n",chargehistory[i]);
				}
				thisUser.setChargeHistory(chargehistory);

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
}


