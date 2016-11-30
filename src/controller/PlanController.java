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
import network.Assembleddata;
import simulation.*;

import static java.lang.Thread.sleep;

public class PlanController implements Initializable {

	private String total_electric_usage;

	private int total_fee;
	private double total_usage;
	private double ex_total_usage;
	private int tax;
	private int ele_industry_fund;

	private double current_basic_fee; // ?��?��?�� ?��기요금계 (�?과세, ???�� 미포?��)
	private int current_fee;

	private double month_basic_fee; // ?��?�� ?��?�� ?��?��?�� 것으�? ?��?��?��?�� ?��?��?��?�� ???�� ?��금액
	private int month_fee;

	private int hope_fee;
	double simul_result = 0;

	private int current_temp; // ?��?��?�� ?��?��
	private int hope_temp; // ?���? ?��?��

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
		textArea.appendText("Start Simulation...\n");
		execute_current_cal_fee();
		execute_total_cal_fee();

	}

	public void execute_current_cal_fee(){
        calculate_electric_usage.setProductCount();
        total_usage = calculate_electric_usage.calc_ele_cur_usage();
        textArea.appendText("1일부터 현재까지의 "+Assembleddata.getUser_f_n().getName()+"님 계정의 전력사용량은\n " + String.valueOf(Math.round(total_usage)) + " kwh 입니다.\n");
        ex_total_usage = calculate_electric_usage.cal_ele_expect_usage();
        textArea.appendText("이번달에 예상되는 "+Assembleddata.getUser_f_n().getName()+"님 계정의 전력사용량은\n " + String.valueOf(Math.round(ex_total_usage)) + " kwh 입니다.\n");
        
        textArea.appendText("/////////////////////////////////////////////////////////////////////////////\n");
        // ?��?���? ?��?��?��?��까�? ?��?�� �??��?���? 계산?�� (?��?�� ?���? ?��?��?�� - 1?���??��?��?��까�? ?��?��?�� ?��?��?��)
        calculateThirdposition.setTotal_electric_usage(total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // ?��?��까�??�� ?��?��?�� ?��?��?��금액 (�?과세, ???�� 미포?��)
        textArea.appendText("-------- 1일 부터 오늘까지 --------\n");
        current_basic_fee = calculatefee.cal_Basic_Fee();
        textArea.appendText("전력사용요금 : " + String.valueOf(current_basic_fee) +" 원\n");
        
        // �?과세 계산
        tax = calculatefee.taxing();
        textArea.appendText("부가가치세 : " + String.valueOf(tax) + " 원\n");
        
        // ???�� ?��?��
        ele_industry_fund = calculatefee.cal_elec_industry_fund();
        textArea.appendText("전력산업발전기금 : " + String.valueOf(ele_industry_fund) + " 원\n");
        // 총액 계산
        current_fee = calculatefee.cal_total();
        textArea.appendText("요금합계 : " + String.valueOf(current_fee) + " 원\n");
    }

    public void execute_total_cal_fee(){
        // ?��?��?�� ?��?�� ?��?�� ?��같다?�� �??��?��?�� ?��망요금까�? 추�?�? ?��?�� �??��?�� ?��?��?�� 계산
    	textArea.appendText("----- 이번달 전체 예상 시뮬레이션 -----\n");
        calculateThirdposition.setTotal_electric_usage(ex_total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // ?��?�� ?��?�� ?��?��?�� 것으�? ?��?��?��?�� ?��?��?�� ???�� ?��금액 (�?과세 ???�� 미포?��
        month_basic_fee = calculatefee.cal_Basic_Fee();
        textArea.appendText("전력사용요금 : " + String.valueOf(current_basic_fee) +" 원\n");
        
        tax = calculatefee.taxing();
        textArea.appendText("부가가치세 : " + String.valueOf(tax) + " 원\n");
        
        ele_industry_fund = calculatefee.cal_elec_industry_fund();
        textArea.appendText("전력산업발전기금 : " + String.valueOf(ele_industry_fund) + " 원\n");
        
        month_fee = calculatefee.cal_total();
        textArea.appendText("요금합계 : " + String.valueOf(current_fee) + " 원\n");
        
        // ?��?�� ?��?��?�� ?��같다�? �??��?��?�� 추�?�? ?��?���??��?�� ?��?��?��
        calculate_plan.setCurrent_basic_fee(month_basic_fee);
        calculate_plan.setCurrent_total_fee(month_fee);
        calculate_plan.setRemainder(hope_fee);

    }


}
