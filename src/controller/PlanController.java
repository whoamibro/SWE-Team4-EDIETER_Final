package controller;
/**
 * Created by jeonyongjin on 2016. 11. 29..
 * 
 */
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import network.Assembleddata;
import simulation.CalculateThirdposition;
import simulation.Calculate_electric_usage;
import simulation.Calculate_fee;
import simulation.Calculate_plan;
import simulation.Calculate_tem_plan;

public class PlanController implements Initializable {

	private String total_electric_usage;

	private int total_fee;
	private double total_usage;
	private double ex_total_usage;
	private int tax;
	private int ele_industry_fund;

	private double current_basic_fee; // ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙湲곗슂湲덇퀎 (占�?怨쇱꽭, ???占쏙옙 誘명룷?占쏙옙)
	private int current_fee;

	private double month_basic_fee; // ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 寃껋쑝占�? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ???占쏙옙 ?占쏙옙湲덉븸
	private int month_fee;

	private int hope_fee;
	double simul_result = 0;

	private int current_temp; // ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙
	private int hope_temp; // ?占쏙옙占�? ?占쏙옙?占쏙옙

	private int current_day;
	private int last_day;

	CalculateThirdposition calculateThirdposition = null;
	Calculate_fee calculatefee = null;
	Calculate_electric_usage calculate_electric_usage= null;
	Calculate_plan calculate_plan = null;
	Calculate_tem_plan calculate_tem_plan = null;
	DecimalFormat form = new DecimalFormat("#.##");
	@FXML
	private Button btnPlan;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private TextArea textArea;
	
	@FXML
	private TextField curtmp;
	
	@FXML
	private TextField hopetmp;

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
		total_usage = 0;
		current_basic_fee = 0;
		tax = 0;
		ele_industry_fund = 0;
		current_fee = 0;
		month_basic_fee = 0;
		
		calculateThirdposition = new CalculateThirdposition();
		calculatefee = new Calculate_fee();
		calculate_electric_usage= new Calculate_electric_usage();
		calculate_plan = new Calculate_plan();
		calculate_tem_plan = new Calculate_tem_plan();
		
		
		textArea.setText("Your hope fee is : " + String.valueOf(hope_fee) + "won\n");
		textArea.appendText("Start Simulation...\n");
		execute_current_cal_fee();
		execute_total_cal_fee();
		excute_plan_temperature();
	}

	public void execute_current_cal_fee(){
        calculate_electric_usage.setProductCount();
        total_usage = calculate_electric_usage.calc_ele_cur_usage();
        textArea.appendText("1 - TODAY "+Assembleddata.getUser_f_n().getName()+" 's Electric Usage is \n " + String.valueOf(form.format(total_usage)) + " kwh.\n");
        ex_total_usage = calculate_electric_usage.cal_ele_expect_usage();
        textArea.appendText("WHOLE MONTH "+Assembleddata.getUser_f_n().getName()+" 's Electric Usage is \n " + String.valueOf(form.format(ex_total_usage)) + " kwh.\n");
        
        textArea.appendText("/////////////////////////////////////////////////////////////////////////////\n");
        // ?占쏙옙?占쏙옙占�? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙源뚳옙? ?占쏙옙?占쏙옙 占�??占쏙옙?占쏙옙占�? 怨꾩궛?占쏙옙 (?占쏙옙?占쏙옙 ?占쏙옙占�? ?占쏙옙?占쏙옙?占쏙옙 - 1?占쏙옙占�??占쏙옙?占쏙옙?占쏙옙源뚳옙? ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙)
        calculateThirdposition.setTotal_electric_usage(total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // ?占쏙옙?占쏙옙源뚳옙??占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙湲덉븸 (占�?怨쇱꽭, ???占쏙옙 誘명룷?占쏙옙)
        textArea.appendText("-------- 1 - TODAY --------\n");
        current_basic_fee = calculatefee.cal_Basic_Fee();
        textArea.appendText("Basic Fee : " + String.valueOf(form.format(current_basic_fee)) +" won\n");
        
        // 占�?怨쇱꽭 怨꾩궛
        tax = calculatefee.taxing();
        textArea.appendText("Tax : " + String.valueOf(tax) + " won\n");
        
        // ???占쏙옙 ?占쏙옙?占쏙옙
        ele_industry_fund = calculatefee.cal_elec_industry_fund();
        textArea.appendText("Electric industry fund Fee : " + String.valueOf(ele_industry_fund) + " won\n");
        // 珥앹븸 怨꾩궛
        current_fee = calculatefee.cal_total();
        textArea.appendText("Total Fee : " + String.valueOf(current_fee) + " won\n");
   
        // preparing simulation
        calculate_plan.setCurrent_basic_fee(current_basic_fee);
        calculate_plan.setCurrent_total_fee(current_fee);
        calculate_plan.setRemainder(hope_fee);
        // simulation
        simul_result = calculate_plan.simulator();
        textArea.appendText("Additional available electric usage is " + String.valueOf(Math.round(simul_result)) + " kwh\n");
	}

    public void execute_total_cal_fee(){
        // ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙 ?占쏙옙媛숇떎?占쏙옙 占�??占쏙옙?占쏙옙?占쏙옙 ?占쏙옙留앹슂湲덇퉴占�? 異뷂옙?占�? ?占쏙옙?占쏙옙 占�??占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 怨꾩궛
    	textArea.appendText("----- WHOLE MONTH -----\n");
        calculateThirdposition.setTotal_electric_usage(ex_total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 寃껋쑝占�? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 ???占쏙옙 ?占쏙옙湲덉븸 (占�?怨쇱꽭 ???占쏙옙 誘명룷?占쏙옙
        month_basic_fee = calculatefee.cal_Basic_Fee();
        textArea.appendText("Basic Fee : " + String.valueOf(form.format(month_basic_fee)) +" won\n");
        
        tax = calculatefee.taxing();
        textArea.appendText("Tax : " + String.valueOf(tax) + " won\n");
        
        ele_industry_fund = calculatefee.cal_elec_industry_fund();
        textArea.appendText("Electric industry fund Fee : " + String.valueOf(ele_industry_fund) + " won\n");
        
        month_fee = calculatefee.cal_total();
        textArea.appendText("Total : " + String.valueOf(month_fee) + " won\n");
        
        // preparing simulation
        calculate_plan.setCurrent_basic_fee(month_basic_fee);
        calculate_plan.setCurrent_total_fee(month_fee);
        calculate_plan.setRemainder(hope_fee);
        // simulation
        simul_result = calculate_plan.simulator();
        textArea.appendText("Additional available electric usage is " + String.valueOf(form.format(simul_result)) + " kwh\n");
    }
    
    public void excute_plan_temperature(){
    	double m; // mass
    	double kcal; // kcal
    	double kwh; // kwh
    	double time; // time for whole month
    	double timeperday; // time for day
    	// set temperature
        current_temp = Integer.parseInt(curtmp.getText());
        hope_temp = Integer.parseInt(hopetmp.getText());
        
    	textArea.appendText("----- Simulation for temperature -----\n");
    	textArea.appendText("Current temperature is " + String.valueOf(current_temp) + " degrees celcius\n");
    	textArea.appendText("Your hope temperature is " + String.valueOf(hope_temp) + " degrees celcius\n");
        current_day = calculate_electric_usage.getDate_of_month();
        last_day = calculate_electric_usage.getLastdate_of_month();
        calculate_tem_plan.setRemainday(last_day-current_day);
        calculate_tem_plan.setSimul_result(simul_result);
        
        // simulation calculating
        calculate_tem_plan.setDelta_t(Math.abs(current_temp-hope_temp));
        calculate_tem_plan.setSquaremeter(Assembleddata.getUser_f_n().getAreaSize());
        calculate_tem_plan.setK(current_temp);
        m = calculate_tem_plan.calculate_volume();
        textArea.appendText("Mass of User's space : "+ String.valueOf(form.format(m)) + " g\n");
        kcal = calculate_tem_plan.calculate_cal();
        textArea.appendText("The amount of heat to change the temperature : " + String.valueOf(form.format(kcal)) + " kcal\n");
        kwh = calculate_tem_plan.calculate_w();
        textArea.appendText("Convert heat to electric usage : " + String.valueOf(form.format(kwh)) + " kwh\n");
        time = calculate_tem_plan.calculate_t();
        textArea.appendText("Additional available time to use airconditioner or heater among whole month : " + String.valueOf(form.format(time)) + " hour\n");
        timeperday = calculate_tem_plan.calculate_td(time);
        textArea.appendText("Additional available time to use airconditioner or heater among day : " + String.valueOf(form.format(timeperday)) + " hour\n");
    }
}
