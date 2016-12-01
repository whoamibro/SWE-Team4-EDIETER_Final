package main;
import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SystemMain extends Application {
	/** 
	 * created by Jin Jung on 2016. 11. 30.
	 * function : start main thread and show stage 
	 * loc : 19
	 * */
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// create loginController 
		LoginController loginController = new LoginController();
		// create loader for loginController
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
		// set controller for loader
		loader.setController(loginController);
		Scene scene = new Scene(loader.load());
		
		// set and show stage
		primaryStage.setTitle("E-Dieter");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	/** 
	 * */
	
}
