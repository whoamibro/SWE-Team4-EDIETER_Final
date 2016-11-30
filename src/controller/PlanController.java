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
		textArea.setText("Your hope fee is : " + String.valueOf(hope_fee) + "won\n");
		textArea.appendText("Start Simulation...\n");
		execute_current_cal_fee();
		execute_total_cal_fee();

	}

	public void execute_current_cal_fee(){
        calculate_electric_usage.setProductCount();
        total_usage = calculate_electric_usage.calc_ele_cur_usage();
        textArea.appendText("1�씪遺��꽣 �쁽�옱源뚯��쓽 "+Assembleddata.getUser_f_n().getName()+"�떂 怨꾩젙�쓽 �쟾�젰�궗�슜�웾��\n " + String.valueOf(Math.round(total_usage)) + " kwh �엯�땲�떎.\n");
        ex_total_usage = calculate_electric_usage.cal_ele_expect_usage();
        textArea.appendText("�씠踰덈떖�뿉 �삁�긽�릺�뒗 "+Assembleddata.getUser_f_n().getName()+"�떂 怨꾩젙�쓽 �쟾�젰�궗�슜�웾��\n " + String.valueOf(Math.round(ex_total_usage)) + " kwh �엯�땲�떎.\n");
        
        textArea.appendText("/////////////////////////////////////////////////////////////////////////////\n");
        // ?占쏙옙?占쏙옙占�? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙源뚳옙? ?占쏙옙?占쏙옙 占�??占쏙옙?占쏙옙占�? 怨꾩궛?占쏙옙 (?占쏙옙?占쏙옙 ?占쏙옙占�? ?占쏙옙?占쏙옙?占쏙옙 - 1?占쏙옙占�??占쏙옙?占쏙옙?占쏙옙源뚳옙? ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙)
        calculateThirdposition.setTotal_electric_usage(total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // ?占쏙옙?占쏙옙源뚳옙??占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙湲덉븸 (占�?怨쇱꽭, ???占쏙옙 誘명룷?占쏙옙)
        textArea.appendText("-------- 1�씪 遺��꽣 �삤�뒛源뚯� --------\n");
        current_basic_fee = calculatefee.cal_Basic_Fee();
        textArea.appendText("�쟾�젰�궗�슜�슂湲� : " + String.valueOf(current_basic_fee) +" �썝\n");
        
        // 占�?怨쇱꽭 怨꾩궛
        tax = calculatefee.taxing();
        textArea.appendText("遺�媛�媛�移섏꽭 : " + String.valueOf(tax) + " �썝\n");
        
        // ???占쏙옙 ?占쏙옙?占쏙옙
        ele_industry_fund = calculatefee.cal_elec_industry_fund();
        textArea.appendText("�쟾�젰�궛�뾽諛쒖쟾湲곌툑 : " + String.valueOf(ele_industry_fund) + " �썝\n");
        // 珥앹븸 怨꾩궛
        current_fee = calculatefee.cal_total();
        textArea.appendText("�슂湲덊빀怨� : " + String.valueOf(current_fee) + " �썝\n");
    }

    public void execute_total_cal_fee(){
        // ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙 ?占쏙옙媛숇떎?占쏙옙 占�??占쏙옙?占쏙옙?占쏙옙 ?占쏙옙留앹슂湲덇퉴占�? 異뷂옙?占�? ?占쏙옙?占쏙옙 占�??占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 怨꾩궛
    	textArea.appendText("----- �씠踰덈떖 �쟾泥� �삁�긽 �떆裕щ젅�씠�뀡 -----\n");
        calculateThirdposition.setTotal_electric_usage(ex_total_usage);
        calculatefee.setNum_remain(calculateThirdposition.cal_position()[1]);
        calculatefee.setNumofthirdposition(calculateThirdposition.cal_position()[0],calculateThirdposition.cal_position()[2]);

        // ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 寃껋쑝占�? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 ???占쏙옙 ?占쏙옙湲덉븸 (占�?怨쇱꽭 ???占쏙옙 誘명룷?占쏙옙
        month_basic_fee = calculatefee.cal_Basic_Fee();
        textArea.appendText("�쟾�젰�궗�슜�슂湲� : " + String.valueOf(current_basic_fee) +" �썝\n");
        
        tax = calculatefee.taxing();
        textArea.appendText("遺�媛�媛�移섏꽭 : " + String.valueOf(tax) + " �썝\n");
        
        ele_industry_fund = calculatefee.cal_elec_industry_fund();
        textArea.appendText("�쟾�젰�궛�뾽諛쒖쟾湲곌툑 : " + String.valueOf(ele_industry_fund) + " �썝\n");
        
        month_fee = calculatefee.cal_total();
        textArea.appendText("�슂湲덊빀怨� : " + String.valueOf(current_fee) + " �썝\n");
        
        // ?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙媛숇떎占�? 占�??占쏙옙?占쏙옙?占쏙옙 異뷂옙?占�? ?占쏙옙?占쏙옙占�??占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙
        calculate_plan.setCurrent_basic_fee(month_basic_fee);
        calculate_plan.setCurrent_total_fee(month_fee);
        calculate_plan.setRemainder(hope_fee);

    }


}
