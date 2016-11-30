package simulation;

import controller.ProductController;

/**
 * Created by jeonyongjin on 2016. 11. 29..
 */
public class Calculate_tem_plan {
    // cal
    private double kcal;
    // ?จ?? ๋ณ???
    private int delta_t;
    // ?จ? ๋ฉด์ 
    private double squaremeter;
    // ๊ณต๊ฐ(๋ถ??ผ)
    private double V;
    // ๊ณต๊ฐ? ์ฐจ์? ๊ณต๊ธฐ? ??? ์ง๋
    private double m;
    // ๊ณต๊ธฐ? ๋น์ด
    private double C = 0.716;
    // ์ผ๋น?จ?
    private double K;
    // ?๋ฐฉ์ ? ฅ ๋ฐ? ?๋ฐฉ์ ? ฅ
    private double kwh;
    // ??ด์ปจ์ ??๋ฐ? ? ? ฅ
    private double cool_heatpower;
    // ?ด๋ฒ๋ฌ ๋ง์ผ ๊น์? ?จ?? ?ผ?
    private int remainday;
    // ?๋ฎฌ๋ ?ด? ๊ฒฐ๊ณผ ?จ?? ? ? ฅ? ๋ฐ์?ด
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
    // ?? ฅ๋ฐ์? ?จ?๋ฅ? ์ผ๋น?จ?๋ก? ๋ณ??
    public void setK(double c) {
        K = c + 273.15;
    }
    // ๋ถ??ผ? ??? ๊ณต๊ธฐ? ์ง๋? ๊ตฌํ? ๊ณผ์ 
    public void calculate_volume(){
        // 2 ? ???ธ? ์ธต๊ฐ ??ด - ๋ฒฝ์ ?๊ป? | 1000 ?? m^3? liter๋ก? ๋ณ??
        V = squaremeter * 2 * 1000;
        // n = PV/RT ๊ฐ? ? ?ฉ? ๊ฒ? ??๊ธฐ์ = 1, ๊ธฐ์ฒด?? = 0.082057, ๋ชฐ์ง?? g?ผ๋ก? ๋ณ?? 28.7
        m = 1 * V /( 0.082057 * K )* 28.7 ;
        System.out.printf("?ฌ?ฉ? ๊ฑฐ์ฃผ๊ณต๊ฐ? ๋ถ??ผ \t\t\t\t: %.2f liter\n",V);
        System.out.printf("?ฌ?ฉ? ๊ฑฐ์ฃผ๊ณต๊ฐ? ์ผ๋น?จ?\t\t\t\t: %.2f k\n",K);
        System.out.printf("?ฌ?ฉ? ๊ฑฐ์ฃผ๊ณต๊ฐ? ์กด์ฌ?? ๊ณต๊ธฐ? ์ง๋\t: %.2f g\n",m);
    }
    // ์นผ๋ก๋ฆฌ๋?? ๊ณ์ฐ ?? ๊ณผ์ 
    public void calculate_cal(){
        kcal = C * m * delta_t / 1000;
    }
    // cal?จ?? ?์น๋?? Kwh๋ก? ๋ณ??
    public double calculate_w(){
        double result;
        kwh = kcal/861;
        // for confirmation
        System.out.printf("?ฌ๋งํ? ?จ?๋ก? ?ฎ์ถ๊ฑฐ? ?ฌ๋ฆฌ๊ธฐ๊น์? ??? ??์ง?? ?(cal? kwh๋ก? ๋ณ???จ) : %.2f kwh\n",kwh);
        return result = kwh;
    }
    // kwh? ???ด? ??๋ฐฉ๊ธฐ? ? ? ฅ? ??๋น์์ผ์ ?จ?? ?ผ? ?? ๋ช์๊ฐ์ ? ์ถ๊?๋ก? ?ฌ?ฉ?  ? ??์ง? ?? ค์ค?
    public void calculate_t(){
        int length = ProductController.productList.size();
        double time;
        double timeperday;
        for(int i=0; i<length; i++){
            if(ProductController.productList.get(i).getType() == "Airconditioner"){
                cool_heatpower = ProductController.productList.get(i).getCool_heatpower();
                System.out.printf("?ฌ?ฉ?๊ฐ? ๋ณด์ ? ??๋ฐฉ๊ธฐ? ?๋ฐ?<?น??>?๋ฐฉ์ ? ฅ : %.2f\n",cool_heatpower);
            }
        }
        time = simul_result/cool_heatpower;
        timeperday = time/remainday;
        // for confirmation
        System.out.printf("?๋ฎฌ๋ ?ด? ๊ฒฐ๊ณผ ?ด๋ฒ๋ฌ ?ด๋ก? ??๋ฐฉ๊ธฐ๋ฅ? ?? ? ?? ์ด? ?๊ฐ? : %.2f\n", time);
        System.out.printf("?ผ๋ณ? ์ถ๊?๋ก? ??๋ฐฉ๊ธฐ๋ฅ? ?? ? ?? ?๊ฐ? : %.2f\n", timeperday);
    }
}
