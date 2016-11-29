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

	private double current_basic_fee; // 현재의 전기요금계 (부과세, 펀드 미포함)
	private int current_fee;

	private double month_basic_fee; // 한달 동안 사용할 것으로 예상되는 전력량에 대한 요금액
	private int month_fee;

	private int hope_fee;
	double simul_result = 0;

	private int current_temp; // 현재의 온도
	private int hope_temp; // 희망 온도

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

        // 앞으로 어느정도까지 사용 가능한지 계산함 (한달 전체 전력량 - 1일부터오늘까지 사용한 전력량)
        calculateThirdposition.setTotal_electric_usage(total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // 현재까지의 사용한 전력요금액 (부과세, 펀드 미포함)
        current_basic_fee = calculatefee.cal_Basic_Fee();
        // 부과세 계산
        calculatefee.taxing();
        // 펀드 포함
        calculatefee.cal_elec_industry_fund();
        // 총액 계산
        current_fee = calculatefee.cal_total();
    }

    public void execute_total_cal_fee(){
        // 패턴이 한달 내내 똑같다는 가정하에 희망요금까지 추가로 사용 가능한 전력량 계산
        calculateThirdposition.setTotal_electric_usage(ex_total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // 한달 동안 사용할 것으로 예상되는 전력에 대한 요금액 (부과세 펀드 미포함
        month_basic_fee = calculatefee.cal_Basic_Fee();
        calculatefee.taxing();
        calculatefee.cal_elec_industry_fund();
        month_fee = calculatefee.cal_total();

        // 한달 패턴이 똑같다고 가정할때 추가로 사용가능한 전력량
        calculate_plan.setCurrent_basic_fee(month_basic_fee);
        calculate_plan.setCurrent_total_fee(month_fee);
        calculate_plan.setRemainder(hope_fee);


    }


}
