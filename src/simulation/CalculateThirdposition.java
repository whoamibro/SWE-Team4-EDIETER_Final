package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class CalculateThirdposition {
    // ?‚¬?š©? „? ¥?Ÿ‰?„ ë°›ì•„???„œ ?•?ë¦¬ìˆ˜ë¥? ê³„ì‚° (?ˆ„ì§„ì œ ? ?š©?„ ?œ„?•¨)
    private double total_electric_usage;
    private int[] arr = new int[3];

    public void setTotal_electric_usage(double total_electric_usage) {
        this.total_electric_usage = total_electric_usage;
    }

    // ?ë¦¿ìˆ˜ ê³„ì‚°
    public int[] cal_position(){
        int num, num_remain;
        num = (int)total_electric_usage / 100;
        num_remain = (int)total_electric_usage % 100;

        //2ë²ˆì§¸ index?—?Š” ë°±ì˜ ?ë¦¬ë?? ? œ?™¸?•œ ?‚˜ë¨¸ì? ?ˆ˜ë¥? ì§‘ì–´?„£?Œ
        arr[1] = num_remain;
        // ?‚˜ë¨¸ì? ?ˆ˜ê°? 0?´ ?•„?‹ˆ?¼ë©?
        if(num_remain != 0){
            // ë°±ì˜?ë¦? ?ˆ˜ê°? 5?´?ƒ?¼?•Œ
            if(num >=5){
                // ëª¨ë‘ 5ë¡? ì²˜ë¦¬ ?•œ?›„ 0ë²ˆì§¸ index?— ???¥
                arr[0] = 5;
                arr[2] = num;
                return arr;
            }
            else {
                // 5 ë¯¸ë§Œ?´?¼ë©? 0ë²ˆì§¸ index?— numê°’ì„ ???¥
                arr[0] = num;
                return arr;
            }
        }
        // ?‚˜ë¨¸ì? ?ˆ˜ê°? 0?¼?•Œ
        else {
            // ë°±ì˜ ?ë¦¬ìˆ˜ê°? 5ì´ˆê³¼?´ë©?
            if (num > 5) {
                // ëª¨ë‘ 5ë¡? ì²˜ë¦¬?•˜ê³? 0ë²ˆì§¸ index?— ???¥
                arr[0] = 5;
                arr[1] = 100;
                arr[2] = num;
                return arr;
            }
            else{
                // 5?´?•˜?¼ë©? 0ë²ˆì§¸ index?— num-1ê°’ì„ ???¥
                arr[0] = num-1;
                if((int)total_electric_usage != 0) {
                    arr[1] = 100;
                }
                else
                    arr[1] = 0;
                return arr;
            }
        }
    }
}
