package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 * LOC 55
 */
public class CalculateThirdposition {
    // ?��?��?��?��?��?�� 받아???�� ?��?��리수�? 계산 (?��진제 ?��?��?�� ?��?��)
    private double total_electric_usage;
    private int[] arr = new int[3];

    public void setTotal_electric_usage(double total_electric_usage) {
        this.total_electric_usage = total_electric_usage;
    }

    // ?��릿수 계산
    public int[] cal_position(){
        int num, num_remain;
        num = (int)total_electric_usage / 100;
        num_remain = (int)total_electric_usage % 100;
        //2번째 index?��?�� 백의 ?��리�?? ?��?��?�� ?��머�? ?���? 집어?��?��
        arr[1] = num_remain;
        // ?��머�? ?���? 0?�� ?��?��?���?
        if(num_remain != 0){
            // 백의?���? ?���? 5?��?��?��?��
            if(num >=5){
                // 모두 5�? 처리 ?��?�� 0번째 index?�� ???��
                arr[0] = 5;
                arr[2] = num;
                return arr;
            }
            else {
                // 5 미만?��?���? 0번째 index?�� num값을 ???��
                arr[0] = num;
                return arr;
            }
        }
        // ?��머�? ?���? 0?��?��
        else {
            // 백의 ?��리수�? 5초과?���?
            if (num > 5) {
                // 모두 5�? 처리?���? 0번째 index?�� ???��
                arr[0] = 5;
                arr[1] = 100;
                arr[2] = num;
                return arr;
            }
            else{
                // 5?��?��?���? 0번째 index?�� num-1값을 ???��
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
