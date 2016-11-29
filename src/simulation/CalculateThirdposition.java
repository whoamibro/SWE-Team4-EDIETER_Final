package simulation;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class CalculateThirdposition {
    // 사용전력량을 받아와서 앞자리수를 계산 (누진제 적용을 위함)
    private double total_electric_usage;
    private int[] arr = new int[3];

    public void setTotal_electric_usage(double total_electric_usage) {
        this.total_electric_usage = total_electric_usage;
    }

    // 자릿수 계산
    public int[] cal_position(){
        int num, num_remain;
        num = (int)total_electric_usage / 100;
        num_remain = (int)total_electric_usage % 100;

        //2번째 index에는 백의 자리를 제외한 나머지 수를 집어넣음
        arr[1] = num_remain;
        // 나머지 수가 0이 아니라면
        if(num_remain != 0){
            // 백의자리 수가 5이상일때
            if(num >=5){
                // 모두 5로 처리 한후 0번째 index에 저장
                arr[0] = 5;
                arr[2] = num;
                return arr;
            }
            else {
                // 5 미만이라면 0번째 index에 num값을 저장
                arr[0] = num;
                return arr;
            }
        }
        // 나머지 수가 0일때
        else {
            // 백의 자리수가 5초과이면
            if (num > 5) {
                // 모두 5로 처리하고 0번째 index에 저장
                arr[0] = 5;
                arr[1] = 100;
                arr[2] = num;
                return arr;
            }
            else{
                // 5이하라면 0번째 index에 num-1값을 저장
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
