package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PlanController implements Initializable {
	@FXML
	private Button btnPlan;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private TextArea textArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = comboBox.getItems();
		list.add("1~2");
		list.add("2~3");
		list.add("3~4");

		textArea.setText("Hello World!");
	}

	public void btnPlanHandler() {

	}

}
