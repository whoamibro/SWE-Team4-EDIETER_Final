package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class CalculateThirdposition {
    // ?¬?©? ? ₯?? λ°μ??? ??λ¦¬μλ₯? κ³μ° (?μ§μ  ? ?©? ??¨)
    private double total_electric_usage;
    private int[] arr = new int[3];

    public void setTotal_electric_usage(double total_electric_usage) {
        this.total_electric_usage = total_electric_usage;
    }

    // ?λ¦Ώμ κ³μ°
    public int[] cal_position(){
        int num, num_remain;
        num = (int)total_electric_usage / 100;
        num_remain = (int)total_electric_usage % 100;

        //2λ²μ§Έ index?? λ°±μ ?λ¦¬λ?? ? ?Έ? ?λ¨Έμ? ?λ₯? μ§μ΄?£?
        arr[1] = num_remain;
        // ?λ¨Έμ? ?κ°? 0?΄ ???Όλ©?
        if(num_remain != 0){
            // λ°±μ?λ¦? ?κ°? 5?΄??Ό?
            if(num >=5){
                // λͺ¨λ 5λ‘? μ²λ¦¬ ?? 0λ²μ§Έ index? ???₯
                arr[0] = 5;
                arr[2] = num;
                return arr;
            }
            else {
                // 5 λ―Έλ§?΄?Όλ©? 0λ²μ§Έ index? numκ°μ ???₯
                arr[0] = num;
                return arr;
            }
        }
        // ?λ¨Έμ? ?κ°? 0?Ό?
        else {
            // λ°±μ ?λ¦¬μκ°? 5μ΄κ³Ό?΄λ©?
            if (num > 5) {
                // λͺ¨λ 5λ‘? μ²λ¦¬?κ³? 0λ²μ§Έ index? ???₯
                arr[0] = 5;
                arr[1] = 100;
                arr[2] = num;
                return arr;
            }
            else{
                // 5?΄??Όλ©? 0λ²μ§Έ index? num-1κ°μ ???₯
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
