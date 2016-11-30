package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_plan {
    // calculate_electric_usage?? cal_ele_expect_usage λ©μ?? ?°?° κ²°κ³Όλ‘? λ°ν?? κ°μ΄ ???₯?? λ³??
    // private double basic_usage;

    // ?¬λ§? ?κΈ? λ³??
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

    // ??¬ ?¬?©? ? ₯??Όλ‘? λΆ??° ??? ?κΈκΉμ§? ?Όλ§λ ? ?¬?©κ°??₯?μ§? κ³μ°??¬ λ°ν?? ?¨?
    public double simulator(){
        // ?κ°μ΄ ??΄? ?΄λΆ?λΆμ? κ·Έλ₯ λΉν¨?¨? ?Όλ‘? ?Έκ°??€λ₯? ?°??€ ? ? 

        double value = 0;
        // ??¬κΉμ? ?κΈμ΄ ?΄λ―? ?¬λ§μκΈμ ???€λ©? ?΄λΆ?λΆμ ?°?΄ ?κ³? κ³μ° λΆκ? μΆλ ₯
        if(hope_fee > current_total_fee) {
            // ?¬λ§κΈ?‘?? λΆ?κ°?κ°?μΉμΈ, κΈ°κΈ? ? κ±°ν?¬ ? ? ₯?κΈλ§ μΆμΆ
            hope_basic_fee = hope_fee / 1.137;
            // 10000? ?¨?λ‘? λ§μΆ°? κ³μ°
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
            System.out.println("?΄λ―? ?¬?©??  ? ? ₯??΄ ?¬λ§μκΈ? κΈμ‘? μ΄κ³Ό????΅??€");
        }
        System.out.printf("μΆκ?λ‘? ?¬?© κ°??₯? ? ? ₯??? :  ");
        System.out.printf("%.2f", value);
        System.out.println();

        return value;
    }
}
