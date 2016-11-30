package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_plan {
    // calculate_electric_usage?óê?Ñú cal_ele_expect_usage Î©îÏÜå?ìú?ùò ?ó∞?Ç∞ Í≤∞Í≥ºÎ°? Î∞òÌôò?êò?äî Í∞íÏù¥ ???û•?êò?äî Î≥??àò
    // private double basic_usage;

    // ?ù¨Îß? ?öîÍ∏? Î≥??àò
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

    // ?òÑ?û¨ ?Ç¨?ö©?†Ñ?†•?üâ?úºÎ°? Î∂??Ñ∞ ?õê?ïò?äî ?öîÍ∏àÍπåÏß? ?ñºÎßàÎÇò ?çî ?Ç¨?ö©Í∞??ä•?ïúÏß? Í≥ÑÏÇ∞?ïò?ó¨ Î∞òÌôò?ïò?äî ?ï®?àò
    public double simulator(){
        // ?ãúÍ∞ÑÏù¥ ?óÜ?ñ¥?Ñú ?ù¥Î∂?Î∂ÑÏ? Í∑∏ÎÉ• ÎπÑÌö®?ú®?†Å?úºÎ°? ?Ö∏Í∞??ã§Î•? ?õ∞?óá?ã§ ?Ö†?Ö†

        double value = 0;
        // ?òÑ?û¨ÍπåÏ? ?öîÍ∏àÏù¥ ?ù¥ÎØ? ?ù¨ÎßùÏöîÍ∏àÏùÑ ?Ñò?óà?ã§Î©? ?ù¥Î∂?Î∂ÑÏùÑ ?õ∞?ñ¥ ?ÑòÍ≥? Í≥ÑÏÇ∞ Î∂àÍ? Ï∂úÎ†•
        if(hope_fee > current_total_fee) {
            // ?ù¨ÎßùÍ∏à?ï°?óê?Ñú Î∂?Í∞?Í∞?ÏπòÏÑ∏, Í∏∞Í∏à?ùÑ ?†úÍ±∞Ìïò?ó¨ ?†Ñ?†•?öîÍ∏àÎßå Ï∂îÏ∂ú
            hope_basic_fee = hope_fee / 1.137;
            // 10000?õê ?ã®?úÑÎ°? ÎßûÏ∂∞?Ñú Í≥ÑÏÇ∞
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
            System.out.println("?ù¥ÎØ? ?Ç¨?ö©?ïò?ã† ?†Ñ?†•?üâ?ù¥ ?ù¨ÎßùÏöîÍ∏? Í∏àÏï°?ùÑ Ï¥àÍ≥º?ïò???äµ?ãà?ã§");
        }
        System.out.printf("Ï∂îÍ?Î°? ?Ç¨?ö© Í∞??ä•?ïú ?†Ñ?†•?üâ?? :  ");
        System.out.printf("%.2f", value);
        System.out.println();

        return value;
    }
}
