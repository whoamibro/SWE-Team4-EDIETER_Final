package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;

public class UserController implements Initializable {

	@FXML
	private TextField textFieldUser;

	@FXML
	private TextField textFieldSize;

	@FXML
	private TextField textFieldUsage;

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

}
