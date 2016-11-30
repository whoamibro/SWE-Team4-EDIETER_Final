package simulation;

import controller.ProductController;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_tem_plan {
    // cal
    private double kcal;
    // ?��?��?�� �??��?��
    private int delta_t;
    // ?��?�� 면적
    private double squaremeter;
    // 공간(�??��)
    private double V;
    // 공간?�� 차있?�� 공기?�� ???�� 질량
    private double m;
    // 공기?�� 비열
    private double C = 0.716;
    // 켈빈?��?��
    private double K;
    // ?��방전?�� �? ?��방전?��
    private double kwh;
    // ?��?��컨의 ?��?���? ?��?��
    private double cool_heatpower;
    // ?��번달 말일 까�? ?��?? ?��?��
    private int remainday;
    // ?��뮬레?��?�� 결과 ?��?? ?��?��?�� 받아?��
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
    // ?��?��받�? ?��?���? 켈빈?��?���? �??��
    public void setK(double c) {
        K = c + 273.15;
    }
    // �??��?�� ???�� 공기?�� 질량?�� 구하?�� 과정
    public void calculate_volume(){
        // 2 ?�� ?��?��?��?�� 층간 ?��?�� - 벽의 ?���? | 1000 ?? m^3?�� liter�? �??��
        V = squaremeter * 2 * 1000;
        // n = PV/RT �? ?��?��?�� �? ??기압 = 1, 기체?��?�� = 0.082057, 몰질?��?�� g?���? �??�� 28.7
        m = 1 * V /( 0.082057 * K )* 28.7 ;
        System.out.printf("?��?��?�� 거주공간?�� �??�� \t\t\t\t: %.2f liter\n",V);
        System.out.printf("?��?��?�� 거주공간?�� 켈빈?��?��\t\t\t\t: %.2f k\n",K);
        System.out.printf("?��?��?�� 거주공간?�� 존재?��?�� 공기?�� 질량\t: %.2f g\n",m);
    }
    // 칼로리�?? 계산 ?��?�� 과정
    public void calculate_cal(){
        kcal = C * m * delta_t / 1000;
    }
    // cal?��?��?�� ?��치�?? Kwh�? �??��
    public double calculate_w(){
        double result;
        kwh = kcal/861;
        // for confirmation
        System.out.printf("?��망하?�� ?��?���? ?��추거?�� ?��리기까�? ?��?��?�� ?��?���??�� ?��(cal?�� kwh�? �??��?��) : %.2f kwh\n",kwh);
        return result = kwh;
    }
    // kwh?�� ???��?�� ?��?��방기?�� ?��?��?�� ??비시켜서 ?��?? ?��?�� ?��?�� 몇시간을 ?�� 추�?�? ?��?��?�� ?�� ?��?���? ?��?���?
    public void calculate_t(){
        int length = ProductController.productList.size();
        double time;
        double timeperday;
        for(int i=0; i<length; i++){
            if(ProductController.productList.get(i).getType() == "Airconditioner"){
                cool_heatpower = ProductController.productList.get(i).getCool_heatpower();
                System.out.printf("?��?��?���? 보유?�� ?��?��방기?�� ?���?<?��??>?��방전?�� : %.2f\n",cool_heatpower);
            }
        }
        time = simul_result/cool_heatpower;
        timeperday = time/remainday;
        // for confirmation
        System.out.printf("?��뮬레?��?�� 결과 ?��번달 ?���? ?��?��방기�? ?? ?�� ?��?�� �? ?���? : %.2f\n", time);
        System.out.printf("?���? 추�?�? ?��?��방기�? ?? ?�� ?��?�� ?���? : %.2f\n", timeperday);
    }
}
