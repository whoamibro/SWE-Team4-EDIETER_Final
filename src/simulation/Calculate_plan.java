package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_plan {
    // calculate_electric_usage에서 cal_ele_expect_usage 메소드의 연산 결과로 반환되는 값이 저장되는 변수
    // private double basic_usage;

    // 희망 요금 변수
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

    // 현재 사용전력량으로 부터 원하는 요금까지 얼마나 더 사용가능한지 계산하여 반환하는 함수
    public double simulator(){
        // 시간이 없어서 이부분은 그냥 비효율적으로 노가다를 뛰엇다 ㅠㅠ

        double value = 0;
        // 현재까지 요금이 이미 희망요금을 넘었다면 이부분을 뛰어 넘고 계산 불가 출력
        if(hope_fee > current_total_fee) {
            // 희망금액에서 부가가치세, 기금을 제거하여 전력요금만 추출
            hope_basic_fee = hope_fee / 1.137;
            // 10000원 단위로 맞춰서 계산
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
            System.out.println("이미 사용하신 전력량이 희망요금 금액을 초과하였습니다");
        }
        System.out.printf("추가로 사용 가능한 전력량은 :  ");
        System.out.printf("%.2f", value);
        System.out.println();

        return value;
    }
}
