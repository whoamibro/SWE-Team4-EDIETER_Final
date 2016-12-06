package controller;

/**
 * Created by ParkKyeungHye on 2016. 11. 30.
 */

import components.User;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class PastUsageController implements Initializable {

	User thisUser;
	
	//past charge history
	double[] history;
	
	//get this month
	Calendar day = Calendar.getInstance();	
	private int thismonth = day.get(day.MONTH);
	
	@FXML
	private Text MonthName;
	
	@FXML
	private Text MonthName2;

	@FXML
	private Text MonthName3;

	@FXML
	private Text MonthName4;

	@FXML
	private Text MonthName5;

	@FXML
	private Text MonthName6;
	
	@FXML
	private AnchorPane panePastUsage;

	
	//past charge of each month
	@FXML
	private TextField lastMonth;
	
	@FXML
	private TextField lastMonth2;
	
	@FXML
	private TextField lastMonth3;
	
	@FXML
	private TextField lastMonth4;
	
	@FXML
	private TextField lastMonth5;
	
	@FXML
	private TextField lastMonth6;
	
	@FXML
	private Button btnOK;

	@FXML
	private Button btnCancel;

	private UserController userController;

	public PastUsageController() {
	}

	// get current user instance
	public PastUsageController(User user) {
		thisUser = user;
	}
	//set user controller
	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//set text of each month(according to current month)
		MonthName.setText(String.valueOf(thismonth)+"월");
		MonthName2.setText(String.valueOf(thismonth-1)+"월");
		MonthName3.setText(String.valueOf(thismonth-2)+"월");
		MonthName4.setText(String.valueOf(thismonth-3)+"월");
		MonthName5.setText(String.valueOf(thismonth-4)+"월");
		MonthName6.setText(String.valueOf(thismonth-5)+"월");
		
		//get thisUser's past charge history 
		history = thisUser.getChargeHist();
		
		//index 5 of history is last month's usage and index 4 is more past.
		//set text field of each month's usage
		lastMonth.setText(String.valueOf(history[5]));
		lastMonth2.setText(String.valueOf(history[4]));
		lastMonth3.setText(String.valueOf(history[3]));
		lastMonth4.setText(String.valueOf(history[2]));
		lastMonth5.setText(String.valueOf(history[1]));
		lastMonth6.setText(String.valueOf(history[0]));

	}

	public void btnOKHandler() {
		
		//get lastMonth field that user entered and save it to history[5]
		history[5] = Double.parseDouble(lastMonth.getText().split(" ")[0]);
		//set the entered last month's usage to this user's history
		thisUser.setChargeHistory(history);

		//set loader of User.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/User.fxml"));
		loader.setController(userController);

		//clear and load User.fxml
		try {
			panePastUsage.getChildren().clear();
			panePastUsage.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//cancel button handler. doing nothing, just load User.fxml
	public void btnCancelHandler() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/User.fxml"));
		loader.setController(userController);

		try {
			panePastUsage.getChildren().clear();
			panePastUsage.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/**
 */
