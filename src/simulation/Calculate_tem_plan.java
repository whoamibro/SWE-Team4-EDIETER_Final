package simulation;

import controller.ProductController;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_tem_plan {
    // cal
    private double kcal;
    // 온도의 변화량
    private int delta_t;
    // 단위 면적
    private double squaremeter;
    // 공간(부피)
    private double V;
    // 공간에 차있는 공기에 대한 질량
    private double m;
    // 공기의 비열
    private double C = 0.716;
    // 켈빈온도
    private double K;
    // 냉방전력 및 난방전력
    private double kwh;
    // 에어컨의 냉난방 전력
    private double cool_heatpower;
    // 이번달 말일 까지 남은 일수
    private int remainday;
    // 시뮬레이션 결과 남은 전력량 받아옴
    private double simul_result;
    public void setSimul_result(double simul_result){
        this.simul_result = simul_result;
    }

    public int getDelta_t() {
        return delta_t;
    }

    public void setDelta_t(int delta_t) {
        this.delta_t = delta_t;
    }

    public double getSquaremeter() {
        return squaremeter;
    }

    public void setSquaremeter(double squaremeter) {
        this.squaremeter = squaremeter*3.3;
    }

    public void setRemainday(int remainday) {
        this.remainday = remainday;
    }

    public double getK() {
        return K;
    }
    // 입력받은 온도를 켈빈온도로 변환
    public void setK(double c) {
        K = c + 273.15;
    }
    // 부피에 대한 공기의 질량을 구하는 과정
    public void calculate_volume(){
        // 2 는 아파트의 층간 높이 - 벽의 두께 | 1000 은 m^3을 liter로 변환
        V = squaremeter * 2 * 1000;
        // n = PV/RT 가 적용된 것 대기압 = 1, 기체상수 = 0.082057, 몰질량을 g으로 변환 28.7
        m = 1 * V /( 0.082057 * K )* 28.7 ;
        System.out.printf("사용자 거주공간의 부피 \t\t\t\t: %.2f liter\n",V);
        System.out.printf("사용자 거주공간의 켈빈온도\t\t\t\t: %.2f k\n",K);
        System.out.printf("사용자 거주공간에 존재하는 공기의 질량\t: %.2f g\n",m);
    }
    // 칼로리를 계산 하는 과정
    public void calculate_cal(){
        kcal = C * m * delta_t / 1000;
    }
    // cal단위의 수치를 Kwh로 변환
    public double calculate_w(){
        double result;
        kwh = kcal/861;
        // for confirmation
        System.out.printf("희망하는 온도로 낮추거나 올리기까지 필요한 에너지의 량(cal을 kwh로 변환함) : %.2f kwh\n",kwh);
        return result = kwh;
    }
    // kwh에 대해서 냉난방기의 전력을 대비시켜서 남은 일수 동안 몇시간을 더 추가로 사용할 수 있는지 알려줌
    public void calculate_t(){
        int length = ProductController.productList.size();
        double time;
        double timeperday;
        for(int i=0; i<length; i++){
            if(ProductController.productList.get(i).getType() == "Airconditioner"){
                cool_heatpower = ProductController.productList.get(i).getCool_heatpower();
                System.out.printf("사용자가 보유한 냉난방기의 냉방<혹은>난방전력 : %.2f\n",cool_heatpower);
            }
        }
        time = simul_result/cool_heatpower;
        timeperday = time/remainday;
        // for confirmation
        System.out.printf("시뮬레이션 결과 이번달 내로 냉난방기를 틀 수 있는 총 시간 : %.2f\n", time);
        System.out.printf("일별 추가로 냉난방기를 틀 수 있는 시간 : %.2f\n", timeperday);
    }
}
