package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
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
		XYChart.Series<String, Double> series1 = new XYChart.Series<>();

		ObservableList<Data<String, Double>> list = FXCollections.observableArrayList();
		list.add(new XYChart.Data<>("1", 1.0));
		list.add(new XYChart.Data<>("2", 2.0));
		list.add(new XYChart.Data<>("3", 3.0));
		list.add(new XYChart.Data<>("4", 4.0));
		list.add(new XYChart.Data<>("5", 5.0));
		list.add(new XYChart.Data<>("6", 6.0));

		series1.setData(list);
		series1.setName("전기 사용량");
		barChart.getData().add(series1);

		// XYChart.Series<String, Double> series1 = new Series<String,
		// Double>();
		// series1.getData().add(new XYChart.Data<String, Double>("Natural",
		// 1.4));
		// barChart.getData().add(series1);
	}

	// �궗�슜�옄 �꺆�뿉 �궗�슜�옄 �젙蹂� 蹂댁뿬以� 硫붿냼�뱶

	// �쟾�젰�궗�슜 洹몃옒�봽. 異뷀썑
	// public void displayUserGraph() {

	// }

}
