package controller;

import java.net.URL;
import java.util.ResourceBundle;

import components.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UserController implements Initializable {
	
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	@FXML
	private Text userName;

	@FXML
	private Text areaSize;

	@FXML
	private Text usedElec;

	@FXML
	private BarChart<String, Double> barChart;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Series<String, Double> series = new Series<>();
		series.setName("전기 사용량");

		ObservableList<Data<String, Double>> list = series.getData();
		list.add(new Data<>("1", 1.0));
		list.add(new Data<>("2", 2.0));
		list.add(new Data<>("3", 3.0));
		list.add(new Data<>("4", 4.0));
		list.add(new Data<>("5", 5.0));
		list.add(new Data<>("6", 6.0));

		barChart.getData().add(series);

	}
	
	public void btnPastHandler() {
		

	}

}
