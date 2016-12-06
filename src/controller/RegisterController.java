package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import components.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import network.Assembleddata;
import network.NetworkService;
import network.request.Signup;
import network.response.SignupResult;
import network.response.User_f_n;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterController implements Initializable {
	/** 
	 * created by Jin Jung on 2016. 11. 30.
	 * */
	
	private String baseurl;
	private final String IP = "52.78.211.206";
	private final int PORT = 80;
//	private User newUser;
	private Signup signup = new Signup();
	private SignupResult signupresult;
	private int flag = 0;

	@FXML
	private AnchorPane paneRegister;

	@FXML
	private TextField userName;

	@FXML
	private PasswordField password;

	@FXML
	private PasswordField passwordAgain;

	@FXML
	private TextField email;

	@FXML
	private TextField areaSize;

	@FXML
	private TextField usedElec;

	@FXML
	private Button btnOK;

	@FXML
	private Button btnCancel;

	/** 
	 * */
	
	String pw;
	String pwcheck;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}

	public void btnOKHandler() {
		/** 
		 * created by Jin Jung on 2016. 11. 30.
		 * function : handler for ok button 
		 * loc : 8
		 * */
		pw = password.getText();
		System.out.printf("%s \n", pw);
		pwcheck = passwordAgain.getText();
		System.out.printf("%s \n", pwcheck);
		
		// check if password and passwordAgain is same
		if (pw.equals(pwcheck)) {
			System.out.println("여기 들어오나? ");
			signup.setName(userName.getText());
			signup.setEmail(email.getText());
			signup.setAreaSize(Integer.parseInt(areaSize.getText()));
			signup.setElecUsage(Double.parseDouble(usedElec.getText().split(" ")[0]));
			signup.setPassword(pw);
			System.out.printf("email : %s\n", signup.getEmail());
			System.out.printf("pw : %s\n", signup.getPassword());
		}
		
		Thread th = new Thread(()->{
			
			Signup();
		});
		th.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(flag ==0){
			Alert successAlert = new Alert(Alert.AlertType.ERROR);
			successAlert.setHeaderText("signup alert");
			successAlert.setContentText(" You Input Wrong type\n or Id is already exist\n or Connection to server fail");
			successAlert.showAndWait();
		}
		else if(flag ==1){
			Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
			successAlert.setHeaderText("signup alert");
			successAlert.setContentText("Register Successful");
			successAlert.showAndWait();
			showLoginWindow();
		}
		
		
		
	}
	
//	public User getuser() {
//		return newUser;
//	}

	public void btnCancelHandler() {		
		showLoginWindow();
	}

	public void showLoginWindow() {
		/** 
		 * created by Jin Jung on 2016. 11. 30.
		 * function : show login scene 
		 * loc : 
		 * */
		
		// 
		LoginController loginController = new LoginController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		loader.setController(loginController);

		try {
			paneRegister.getChildren().clear();
			paneRegister.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		/** 
		 * */
	}

	public void hyperlinkHandler() {
		/** 
		 * created by Jin Jung on 2016. 11. 30.
		 * function : load webview when click hyperlink
		 * loc : 27
		 * */
		
		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();
		// load url
		webEngine.load("http://cyber.kepco.co.kr/ckepco/front/jsp/CY/J/H/CYJHPP001.jsp");

		// create web stage
		Stage webStage = new Stage();
		Scene scene = new Scene(webView);
		webStage.setWidth(1020);
		webStage.setScene(scene);
		webStage.setTitle("");
		webStage.show();

		// check web loading state
		webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
			@Override
			public void changed(ObservableValue<? extends Worker.State> arg0, Worker.State arg1, Worker.State arg2) {
				// if loading is fail
				if (arg2 == Worker.State.FAILED) {
					// fail alert
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Check Internet Connection!");
					alert.showAndWait();
					webStage.close();
				}
			}
		});
	}
	
	
	private void Signup(){
		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
				.client(httpClient).build();

		NetworkService networkService = retrofit.create(NetworkService.class);
		networkService.getSignupResult(signup).enqueue(new Callback<SignupResult>() {
			@Override
			public void onResponse(Call<SignupResult> call, Response<SignupResult> response) {
				int status = response.code();
				if (response.isSuccessful()) {
					SignupResult signupresult = response.body();
					if (signupresult.isResult() == true) {
						Assembleddata.setSignupresult(signupresult);
						System.out.printf("되돌아온 이름 %s\n", Assembleddata.getSignupresult().getName());
						flag = 1;
					}
					else{
						flag = 0;
					}
					
				} else {
					flag=0;
					System.out.printf("응답코드 %d", status);
//					System.out.printf("%s ", Assembleddata.getSignupresult().isResult());
				}
			}

			@Override
			public void onFailure(Call<SignupResult> call, Throwable throwable) {
				signupresult = null;
				flag=0;
				System.out.printf("%s", throwable.getMessage());
				System.out.println("failure");
			}
		});
		
	}
}
