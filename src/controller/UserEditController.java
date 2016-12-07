package controller;
/**
 * Created by ParkKyeungHye on 2016. 11. 30.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import components.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import network.Assembleddata;
import network.NetworkService;
import network.request.Signup;
import network.response.SignupResult;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserEditController implements Initializable {

	/**
	 * Created by jeonyongjin on 2016. 12. 2..
	 * LOC 6
	 */
	private String baseurl;
	private final String IP = "52.78.211.206";
	private final int PORT = 80;
	private Signup edituser;
	private SignupResult signupresult;
	private int flag = 0;
	/**
	 * 
	 */
	User thisUser;
	@FXML
	private AnchorPane paneUserEdit;

	@FXML
	private TextField userName;

	@FXML
	private TextField email;

	@FXML
	private PasswordField oldPassword;

	@FXML
	private PasswordField password;
	
	@FXML
	private TextField areaSize;

	@FXML
	private TextField usedElec;

	@FXML
	private Button btnOK;

	@FXML
	private Button btnCancel;

	private MainController mainController;

	public UserEditController() {
	}

	//get current user instance
	public UserEditController(User user) {
		thisUser = user;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/**
		 * Create by jeonyongjin on 2016. 11. 30 ..
		 */
		//set each text as this user's information

		userName.setText(thisUser.getName());
		email.setText(thisUser.getEmail());
		areaSize.setText(String.valueOf(thisUser.getAreaSize()));
		usedElec.setText(String.valueOf(thisUser.getUsedElec()));
		/**
		 * 
		 */
	}

	public void btnOKHandler() {
		edituser = new Signup();
		//set new information that this user entered to this user's each information item
		thisUser.setAreaSize(Integer.parseInt(areaSize.getText()));
		thisUser.setUsedElec(Double.parseDouble(usedElec.getText().split(" ")[0]));
		
		
		/**
		 * Created by jeonyongjin on 2016. 12. 2..
		 * LOC 4
		 */
		edituser.setPassword(oldPassword.getText());
		edituser.setNewpassword(password.getText());
		edituser.setAreaSize(Integer.parseInt(areaSize.getText()));
		edituser.setElecUsage(Double.parseDouble(usedElec.getText()));
		/**
		 * 
		 */
		//set loader of Main.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(mainController);

		//clear and load Main.fxml
		try {
			paneUserEdit.getChildren().clear();
			paneUserEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		EditUser();
	}

	public void btnCancelHandler() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(mainController);

		try {
			paneUserEdit.getChildren().clear();
			paneUserEdit.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Created by jeonyongjin on 2016. 12. 2..
	 * LOC 41
	 */
	private void EditUser(){
		baseurl = String.format("http://%s:%d/", IP, PORT);
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		OkHttpClient httpClient = builder.build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create())
				.client(httpClient).build();

		NetworkService networkService = retrofit.create(NetworkService.class);
		networkService.editUserIdentity(Assembleddata.getToken().getToken(), edituser).enqueue(new Callback<SignupResult>(){

			@Override
			public void onResponse(Call<SignupResult> call, Response<SignupResult> response) {
				int status = response.code();
				if(response.isSuccessful()){
					SignupResult signupresult = response.body();
					if(signupresult.isResult() == true){
						Assembleddata.setSignupresult(signupresult);
						System.out.printf("되돌아온 이름 %s\n", Assembleddata.getSignupresult().getName());
						flag = 1;
					}
					else{
						flag = 0;
					}
				}
				else{
					flag = 0;
					System.out.printf("응답코드 %d", status);
				}
				
			}
			@Override
			public void onFailure(Call<SignupResult> call, Throwable throwable) {
				// TODO Auto-generated method stub
				signupresult = null;
				flag = 0;
				System.out.printf("%s",throwable.getMessage());
				System.out.println("failure");
			}		
		});
	}
}
/**
 */