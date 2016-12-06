package simulation;

import javafx.scene.control.Alert;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_plan {
    // calculate_electric_usage?��?�� cal_ele_expect_usage 메소?��?�� ?��?�� 결과�? 반환?��?�� 값이 ???��?��?�� �??��
    // private double basic_usage;

    // ?���? ?���? �??��
    private int hope_fee;
    //
    private double current_total_fee;
    private double current_basic_fee;
    private double hope_basic_fee;

//    public void setBasic_usage(double basic_usage) {
//        this.basic_usage = basic_usage;
//    }

    public void setCurrent_total_fee(double current_total_fee) {
        this.current_total_fee = current_total_fee;
    }

    public void setCurrent_basic_fee(double current_basic_fee) {
        this.current_basic_fee = current_basic_fee;
    }

    public void setRemainder(int hope_fee) {
        this.hope_fee = hope_fee;
    }

    // ?��?�� ?��?��?��?��?��?���? �??�� ?��?��?�� ?��금까�? ?��마나 ?�� ?��?���??��?���? 계산?��?�� 반환?��?�� ?��?��
    public double simulator(){
        // ?��간이 ?��?��?�� ?���?분�? 그냥 비효?��?��?���? ?���??���? ?��?��?�� ?��?��

        double value = 0;
        // ?��?��까�? ?��금이 ?���? ?��망요금을 ?��?��?���? ?���?분을 ?��?�� ?���? 계산 불�? 출력
        if(hope_fee > current_total_fee) {
            // ?��망금?��?��?�� �?�?�?치세, 기금?�� ?��거하?�� ?��?��?��금만 추출
            hope_basic_fee = hope_fee / 1.137;
            // 10000?�� ?��?���? 맞춰?�� 계산
            switch(hope_fee) {
                case 10000 :
                    if (current_basic_fee <= 6480) {
                        value = (hope_basic_fee - 6480) / 125.9;
                        value += (6480 - current_basic_fee)/60.7;
                    } else {
                        value = (hope_basic_fee - current_basic_fee) / 125.9;
                    }
                    break;
                case 20000 :
                    if (current_basic_fee <= 6480) {
                        value = (hope_basic_fee - 6481) / 125.9;
                        value += (6480 - current_basic_fee)/60.7;
                    } else {
                        value = (hope_basic_fee - current_basic_fee) / 125.9;
                    }
                    break;
                case 30000:
                    if (current_basic_fee <= 6480){
                        value = (hope_basic_fee - 19571) / 187.9;
                        value += 100;
                        value += (6480 - current_basic_fee)/60.7;
                    }
                    else if(current_basic_fee > 6480 && current_basic_fee <= 19570){
                        value = (hope_basic_fee - 19571) / 187.9;
                        value += (19570 - current_basic_fee) / 125.9;
                    }
                    else if(current_basic_fee > 19570){
                        value = (hope_basic_fee - 19571) / 187.9;
                    }
                    break;
                case 40000:
                    if (current_basic_fee <= 6480){
                        value = (hope_basic_fee - 19571) / 187.9;
                        value += 100;
                        value += (6480 - current_basic_fee) / 60.7;
                    }
                    else if(current_basic_fee > 6480 && current_basic_fee <= 19570){
                        value = (hope_basic_fee - 19571) / 187.9;
                        value += (19570 - current_basic_fee) / 125.9;
                    }
                    else if(current_basic_fee > 19570){
                        value = (hope_basic_fee - 19571) / 187.9;
                    }
                    break;
                case 50000:
                    if (current_basic_fee <= 6480){
                        value = (hope_basic_fee - 39051) / 280.6;
                        value += 200;
                        value += (6480 - current_basic_fee) / 60.7;
                    }
                    else if(current_basic_fee > 6480 && current_basic_fee <= 19570){
                        value = (hope_basic_fee - 39051) / 280.6;
                        value += 100;
                        value += (19570 - current_basic_fee) / 125.9;
                    }
                    else if(current_basic_fee > 19570 && current_basic_fee <= 39050){
                        value = (hope_basic_fee - 39051)/280.6;
                        value += (44390 - current_basic_fee) / 187.9;
                    }
                    else if(current_basic_fee > 39050){
                        value = (hope_basic_fee - 39051)/280.6;
                    }
                    break;
                case 60000:
                    if (current_basic_fee <= 6480){
                        value = (hope_basic_fee - 39051) / 280.6;
                        value += 200;
                        value += (6480 - current_basic_fee) / 60.7;
                    }
                    else if(current_basic_fee > 6480 && current_basic_fee <= 19570){
                        value = (hope_basic_fee - 39051) / 280.6;
                        value += 100;
                        value += (19570 - current_basic_fee) / 125.9;
                    }
                    else if(current_basic_fee > 19570 && current_basic_fee <= 39050){
                        value = (hope_basic_fee - 39051)/280.6;
                        value += (44390 - current_basic_fee) / 187.9;
                    }
                    else if(current_basic_fee > 44390){
                        value = (hope_basic_fee - 39051)/280.6;
                    }
                    break;
                case 70000:
                    if (current_basic_fee <= 6480){
                        value = (hope_basic_fee - 39051) / 280.6;
                        value += 200;
                        value += (6480 - current_basic_fee) / 60.7;
                    }
                    else if(current_basic_fee > 6480 && current_basic_fee <= 19570){
                        value = (hope_basic_fee - 39051) / 280.6;
                        value += 100;
                        value += (19570 - current_basic_fee) / 125.9;
                    }
                    else if(current_basic_fee > 19570 && current_basic_fee <= 39050){
                        value = (hope_basic_fee - 39051)/280.6;
                        value += (44390 - current_basic_fee) / 187.9;
                    }
                    else if(current_basic_fee > 39050){
                        value = (hope_basic_fee - 39051)/280.6;
                    }
                    break;
                case 80000:
                    if (current_basic_fee <= 6480){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += 300;
                        value += (6480 - current_basic_fee) / 60.7;
                    }
                    else if(current_basic_fee > 6480 && current_basic_fee <= 19570){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += 200;
                        value += (19570 - current_basic_fee) / 125.9;
                    }
                    else if(current_basic_fee > 19570 && current_basic_fee <= 39050){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += 100;
                        value += (39050 - current_basic_fee) / 187.9;
                    }
                    else if(current_basic_fee > 39050 && current_basic_fee <= 69360){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += (69360 - current_basic_fee) / 280.6;
                    }
                    else if(current_basic_fee > 69360){
                        value = (hope_basic_fee - 69361) / 417.7;
                    }
                    break;
                case 90000:
                    if (current_basic_fee <= 6480){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += 300;
                        value += (6480 - current_basic_fee) / 60.7;
                    }
                    else if(current_basic_fee > 6480 && current_basic_fee <= 19570){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += 200;
                        value += (19570 - current_basic_fee) / 125.9;
                    }
                    else if(current_basic_fee > 19570 && current_basic_fee <= 39050){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += 100;
                        value += (39050 - current_basic_fee) / 187.9;
                    }
                    else if(current_basic_fee > 39050 && current_basic_fee <= 69360){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += (69360 - current_basic_fee) / 280.6;
                    }
                    else if(current_basic_fee > 69360){
                        value = (hope_basic_fee - 69361) / 417.7;
                    }
                    break;
                case 100000:
                    if (current_basic_fee <= 6480){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += 300;
                        value += (6480 - current_basic_fee) / 60.7;
                    }
                    else if(current_basic_fee > 6480 && current_basic_fee <= 19570){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += 200;
                        value += (19570 - current_basic_fee) / 125.9;
                    }
                    else if(current_basic_fee > 19570 && current_basic_fee <= 39050){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += 100;
                        value += (39050 - current_basic_fee) / 187.9;
                    }
                    else if(current_basic_fee > 39050 && current_basic_fee <= 69360){
                        value = (hope_basic_fee - 69361) / 417.7;
                        value += (69360 - current_basic_fee) / 280.6;
                    }
                    else if(current_basic_fee > 69360){
                        value = (hope_basic_fee - 69361) / 417.7;
                    }
                    break;
            }
        }
        else {
        	Alert successAlert = new Alert(Alert.AlertType.ERROR);
			successAlert.setHeaderText(null);
			successAlert.setContentText("Your Usage Fee is already exceed you hope Fee");
			successAlert.showAndWait();
        }
        return value;
    }
}
