package controller;
/**
 * Created by ParkKyeungHye on 2016. 11. 30.(except included comment)
 */
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import components.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class UserController implements Initializable {
	//get this month
	Calendar day = Calendar.getInstance();
	private int thismonth = day.get(day.MONTH);
	
	private User thisUser;

	@FXML
	private AnchorPane paneUser;
	
	@FXML
	private Text userName;

	@FXML
	private Text areaSize;

	@FXML
	private Text usedElec;//used electricity of this month

	@FXML
	private BarChart<String, Double> barChart;

	public void setUser(User user) {
		this.thisUser = user;
	}
	/**
	 * Create by jeonyongjin on 2016. 11. 30..
	 * LOC 12
	 * get month of today and input data for drawing the chart 
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Series<String, Double> series = new Series<>();
		series.setName("전기 사용량");

		ObservableList<Data<String, Double>> list = series.getData();
		// -는 임시방편으로 사용한거 나중에 수정해야함
		list.add(new Data<>(String.valueOf(thismonth-4), thisUser.getChargeHist()[0]));
		list.add(new Data<>(String.valueOf(thismonth-3), thisUser.getChargeHist()[1]));
		list.add(new Data<>(String.valueOf(thismonth-2), thisUser.getChargeHist()[2]));
		list.add(new Data<>(String.valueOf(thismonth-1), thisUser.getChargeHist()[3]));
		list.add(new Data<>(String.valueOf(thismonth), thisUser.getChargeHist()[4]));
		list.add(new Data<>(String.valueOf(thismonth+1), thisUser.getChargeHist()[5]));

		barChart.getData().add(series);

		userName.setText(thisUser.getName());
		areaSize.setText(String.valueOf(thisUser.getAreaSize()));
		usedElec.setText(String.valueOf(thisUser.getUsedElec()));
	}
	/**
	 * 
	 */
	//button handler for past charge button
	public void btnPastHandler() {	
		//create PastUsageController and connect it to this UserController
		PastUsageController pastUsageController = new PastUsageController(thisUser);
		pastUsageController.setUserController(this);
		//set loader of PastUsage.fxml
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PastUsage.fxml"));
		loader.setController(pastUsageController);

		//clear and load PastUsage.fxml
		try {
			paneUser.getChildren().clear();
			paneUser.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void setVisible(boolean bool) {
		paneUser.setVisible(bool);
	}
}
/**
 */