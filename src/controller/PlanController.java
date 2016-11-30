package controller;
/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import simulation.*;

import static java.lang.Thread.sleep;

public class PlanController implements Initializable {

	private String total_electric_usage;

	private int total_fee;
	private double total_usage;
	private double ex_total_usage;

	private double current_basic_fee; // ?˜„?¬?˜ ? „ê¸°ìš”ê¸ˆê³„ (ë¶?ê³¼ì„¸, ???“œ ë¯¸í¬?•¨)
	private int current_fee;

	private double month_basic_fee; // ?•œ?‹¬ ?™?•ˆ ?‚¬?š©?•  ê²ƒìœ¼ë¡? ?˜ˆ?ƒ?˜?Š” ? „? ¥?Ÿ‰?— ???•œ ?š”ê¸ˆì•¡
	private int month_fee;

	private int hope_fee;
	double simul_result = 0;

	private int current_temp; // ?˜„?¬?˜ ?˜¨?„
	private int hope_temp; // ?¬ë§? ?˜¨?„

	private int current_day;
	private int last_day;

	CalculateThirdposition calculateThirdposition = new CalculateThirdposition();
	Calculate_fee calculatefee = new Calculate_fee();
	Calculate_electric_usage calculate_electric_usage= new Calculate_electric_usage();
	Calculate_plan calculate_plan = new Calculate_plan();
	Calculate_tem_plan calculate_tem_plan = new Calculate_tem_plan();

	@FXML
	private Button btnPlan;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private TextArea textArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = comboBox.getItems();
		list.add("10000");
		list.add("20000");
		list.add("30000");
		list.add("40000");
		list.add("50000");
		list.add("60000");
		list.add("70000");
		list.add("80000");
		list.add("90000");
		list.add("100000");


		comboBox.getSelectionModel().selectedItemProperty().addListener(event -> {
			hope_fee = Integer.parseInt(comboBox.getSelectionModel().getSelectedItem().toString());
		});
	}

	public void btnPlanHandler() throws InterruptedException {
		textArea.setText("Your hope fee is : " + String.valueOf(hope_fee) + "won\n");
		textArea.appendText("Start Simulation...");

	}

	public void execute_current_cal_fee(){
        calculate_electric_usage.setProductCount();
        total_usage = calculate_electric_usage.calc_ele_cur_usage();
        ex_total_usage = calculate_electric_usage.cal_ele_expect_usage();

        // ?•?œ¼ë¡? ?–´?Š? •?„ê¹Œì? ?‚¬?š© ê°??Š¥?•œì§? ê³„ì‚°?•¨ (?•œ?‹¬ ? „ì²? ? „? ¥?Ÿ‰ - 1?¼ë¶??„°?˜¤?Š˜ê¹Œì? ?‚¬?š©?•œ ? „? ¥?Ÿ‰)
        calculateThirdposition.setTotal_electric_usage(total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // ?˜„?¬ê¹Œì??˜ ?‚¬?š©?•œ ? „? ¥?š”ê¸ˆì•¡ (ë¶?ê³¼ì„¸, ???“œ ë¯¸í¬?•¨)
        current_basic_fee = calculatefee.cal_Basic_Fee();
        // ë¶?ê³¼ì„¸ ê³„ì‚°
        calculatefee.taxing();
        // ???“œ ?¬?•¨
        calculatefee.cal_elec_industry_fund();
        // ì´ì•¡ ê³„ì‚°
        current_fee = calculatefee.cal_total();
    }

    public void execute_total_cal_fee(){
        // ?Œ¨?„´?´ ?•œ?‹¬ ?‚´?‚´ ?˜‘ê°™ë‹¤?Š” ê°?? •?•˜?— ?¬ë§ìš”ê¸ˆê¹Œì§? ì¶”ê?ë¡? ?‚¬?š© ê°??Š¥?•œ ? „? ¥?Ÿ‰ ê³„ì‚°
        calculateThirdposition.setTotal_electric_usage(ex_total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // ?•œ?‹¬ ?™?•ˆ ?‚¬?š©?•  ê²ƒìœ¼ë¡? ?˜ˆ?ƒ?˜?Š” ? „? ¥?— ???•œ ?š”ê¸ˆì•¡ (ë¶?ê³¼ì„¸ ???“œ ë¯¸í¬?•¨
        month_basic_fee = calculatefee.cal_Basic_Fee();
        calculatefee.taxing();
        calculatefee.cal_elec_industry_fund();
        month_fee = calculatefee.cal_total();

        // ?•œ?‹¬ ?Œ¨?„´?´ ?˜‘ê°™ë‹¤ê³? ê°?? •?• ?•Œ ì¶”ê?ë¡? ?‚¬?š©ê°??Š¥?•œ ? „? ¥?Ÿ‰
        calculate_plan.setCurrent_basic_fee(month_basic_fee);
        calculate_plan.setCurrent_total_fee(month_fee);
        calculate_plan.setRemainder(hope_fee);


    }


}
